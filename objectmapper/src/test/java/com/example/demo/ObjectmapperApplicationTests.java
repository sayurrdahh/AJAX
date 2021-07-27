package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class ObjectmapperApplicationTests {

	//junit test로 돌려야함
	@Test
	void contextLoads() throws JsonProcessingException {
		System.out.println("---------------");
		
		//text JSON -> Object
		//Object -> text Json
		
		//controller req json(text) -> object
		//response object -> json(text)
		
		var objectMapper = new ObjectMapper();
		
		//Object -> text
		//Object mapper get method를 활용한다
		var user = new User("agewwe", 10, "30302302");
		
		//writeValueAsString은 예외가 발생할 수 있기 때문에 위에 예외처리를 해줘야한다.
		var text = objectMapper.writeValueAsString(user);
		System.out.println(text);
		
		
		//text -> Object
		//기본 생성자가 필요
		var objectUser = objectMapper.readValue(text, User.class);
		System.out.println(objectUser);
		
		
		
	}

}
