package org.jt.sms.service;

import org.jt.sms.domain.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    void addStudent() {
        var student =new Student();
        student.setStudentName("Abhijit");
        student.setStudentRoll(101);

        var service = new StudentService();
        var result = service.addStudent(student);
        Assertions.assertEquals(result.getStudentRoll(),100);
    }
}