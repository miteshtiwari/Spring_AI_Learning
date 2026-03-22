package com.aiproject.aiproject;

import com.aiproject.aiproject.Helper.Helper;
import com.aiproject.aiproject.Service.ChatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class AiprojectApplicationTests {

	@Autowired
	private ChatService chatService;


	@Test
	void testprompttemplate(){
		System.out.println("checking");
	}

	@Test
	void savedatattomariadb(){
		System.out.println("saving data to db");
		this.chatService.saveData(new Helper().getdata());
		System.out.println("data saved succesfully");

	}

}
