package com.cg.loginapp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoginappApplicationTests {

	@Test
	void contextLoads() {
		int expected=5;
		int actual=5;
		assertThat(actual).isEqualTo(expected);
	}

}
