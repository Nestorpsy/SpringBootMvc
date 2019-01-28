package com.udemy.backendninja;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BackendninjaApplicationTests {

	@Test
	public void contextLoads() {
		assertEquals(true, true);
	}

}

