package org.jt.sms.service;

import org.jt.sms.domain.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;  
import java.util.List;


@Service
public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    public List<Student> getStudent() {
        return students;
    }
    public Student updateStudent(int roll,Student student){
        var existingStudent = getStudent(roll);
        existingStudent.setStudentName(student.getStudentName());
        existingStudent.setStudentFees(student.getStudentFees());
        existingStudent.setHobbies(student.getHobbies());
        existingStudent.setStudentEmail(student.getStudentEmail());
        existingStudent.setStudentPhoneNumber(student.getStudentPhoneNumber());
         existingStudent.setAddress(student.getAddress());

        var index =getIndex(roll);
        students.set(index,existingStudent);
        return existingStudent;
    }
    public Student getStudent(int roll) {
        for (var student : students) {
            if (student.getStudentRoll() == roll)   
                return student;
        }
throw new RuntimeException("Student not Found")  ;
    }

    public Student deleteStudent(int roll) {
        var student = getStudent(roll);
        students.remove(student);
        return student;
    }
    private int getIndex(int roll){
        for(int i=0;i< students.size();i++){
            var student= students.get(i);
            if(student.getStudentRoll()==roll){
                return i;}
        }
        return -1;
    }

}
