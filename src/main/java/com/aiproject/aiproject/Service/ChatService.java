package com.aiproject.aiproject.Service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ChatService {

    @Autowired
    private ChatClient OllamaChatClient;

    public Flux<String> streamchat(String query){
        return OllamaChatClient
                .prompt()
                .user(query)
                .stream()
                .content();
    }
}
