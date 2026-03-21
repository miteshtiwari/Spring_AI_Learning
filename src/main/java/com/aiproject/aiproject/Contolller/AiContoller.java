package com.aiproject.aiproject.Contolller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiContoller {

    private ChatClient OpenAiChatClient;

    private ChatClient OllamaChatClient;

    public AiContoller(@Qualifier("OpenAiChatClient") ChatClient openAiChatClient, @Qualifier("OllamaChatClient")ChatClient ollamaChatClient) {
        this.OpenAiChatClient = openAiChatClient;
        this.OllamaChatClient = ollamaChatClient;
    }

    @GetMapping("/chat")
    private ResponseEntity<String> chat(@RequestParam(value = "q",required = true) String query){

        var build =  OllamaChatClient.prompt(query)
                .advisors(new SimpleLoggerAdvisor())
                .call()
                .content();

        return ResponseEntity.ok("Response from AI :-"+ build);
    }


}
