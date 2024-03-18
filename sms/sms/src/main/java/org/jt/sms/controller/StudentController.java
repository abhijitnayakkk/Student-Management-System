package org.jt.sms.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.jt.sms.domain.ContactInfo;
import org.jt.sms.domain.Student;
import org.jt.sms.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.*;
import org.jt.sms.domain.ContactInfo;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
@Tag(name=" Student API",description = "This controller class manages CRUD operation student entities")
public class StudentController {
    private final StudentService service;
    private final ContactInfo contactInfo;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Create a new student")
    public Student saveStudent( @Valid @RequestBody Student student) {

        return service.addStudent(student);
    }
    @PutMapping("/{roll}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Student updateStudent(@Positive @PathVariable int roll, @RequestBody Student student){
        return service.updateStudent(roll,student);
    }
    @GetMapping
    public List<Student> students() {

        return service.getStudent();
    }
    @GetMapping("/{id}")
    public Student student(@Min(value = 100) @PathVariable("id") int roll){

        return service.getStudent(roll);
    }
    @DeleteMapping("/{roll}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiResponse(description = "Student not Found",responseCode = "400",
            content =@Content(schema =@Schema(implementation = ProblemDetail.class)))
    public Student removeStudent(@PathVariable int roll){

        return service.deleteStudent(roll);
    }
    @GetMapping("/contacts")
    public ContactInfo contactInfo(){
        System.out.println("Contact controller");
        return contactInfo;
    }

}
