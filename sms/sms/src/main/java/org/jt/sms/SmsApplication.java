package org.jt.sms;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.jt.sms.domain.ContactInfo;
import org.jt.sms.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@OpenAPIDefinition(
//		info = @Info(title = "Student Management System",
//				description = "A web application for managing student records", version = "v1")
//)
@EnableConfigurationProperties(ContactInfo.class)

public class SmsApplication {

    public static void main(String[] args) {
		SpringApplication.run(SmsApplication.class, args);
	}


}
