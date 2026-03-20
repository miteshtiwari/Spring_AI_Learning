package com.aiproject.aiproject.Contolller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.DefaultChatClient;
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

        DefaultChatClient.DefaultCallResponseSpec build = (DefaultChatClient.DefaultCallResponseSpec) chatClient.prompt("hi").call();

        return ResponseEntity.ok("this is ok"+build);
    }

    @GetMapping("/chat2")
    private ResponseEntity<String> chat2(@RequestParam(value = "q",required = true) String query){

        DefaultChatClient.DefaultCallResponseSpec build = (DefaultChatClient.DefaultCallResponseSpec) chatClient.prompt("hi").call();

        return ResponseEntity.ok("this is ok"+build);
    }

}
