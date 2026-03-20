package com.aiproject.aiproject.Contolller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiContoller {


    private ChatClient chatClient;

    public AiContoller(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/chat")
    private ResponseEntity<String> chat(@RequestParam(value = "q",required = true) String query){

       String build = chatClient.prompt("hi").call().content();

        return ResponseEntity.ok("this is ok"+build);
    }

}
