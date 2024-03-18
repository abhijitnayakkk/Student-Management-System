package org.jt.sms.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"studentPhoneNumber","studentName"})
public class Student {
    @NonNull
    @NotEmpty
    @NotBlank
    private String studentName;
    @Positive
    @Min(value = 100)
    @JsonAlias("roll")
    private int studentRoll;
    @Email(message = "student email should be in proper format")
    private String studentEmail;
    @NotNull
    @Pattern(regexp = "^[6-9][0-9]{9}$",message = "mobile number should be in proper format")
    private String studentPhoneNumber;
    @Digits(integer = 5,fraction = 2)
    @PositiveOrZero
    private double studentFees;
    private List<String> hobbies;
    private Address address;

//    public Object getFee() {
//    }

//    public String getFee() {
//    }
}
