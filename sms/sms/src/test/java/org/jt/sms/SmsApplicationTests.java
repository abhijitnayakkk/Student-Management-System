package org.jt.sms;

import org.jt.sms.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SmsApplicationTests {

	@Test
	void contextLoads() {
		var service = new StudentService();

	}

}
