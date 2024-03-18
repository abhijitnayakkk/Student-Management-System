package org.jt.sms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

@RestControllerAdvice
public class HandleException {
    //@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NoResourceFoundException.class)
    public ProblemDetail handler(NoResourceFoundException e) {
        return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(404),e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ProblemDetail handler(RuntimeException e) {
        var problemDetail = ProblemDetail.forStatus(400);
        problemDetail.setTitle("Not Found");
        problemDetail.setDetail(e.getMessage());
        return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(400), e.getMessage());//spring 3.o concept problem detail
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handler(MethodArgumentNotValidException e) {

        var details = new StringJoiner("," );
        e.getAllErrors().forEach(error ->{
            var fieldName = ((FieldError)error).getField();
            var message=error.getDefaultMessage();
            details.add(fieldName +": "+message);
        });
        var problemDetail = ProblemDetail.forStatus(422);
        problemDetail.setTitle("Invalid Data");
        problemDetail.setDetail(details.toString());


        return problemDetail;//spring 3.o concept problem detail
    }

//    @ExceptionHandler(Exception.class)
    //    public ProblemDetail handler(Exception e) {
//        return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(500),e.getMessage());
//    }

}
