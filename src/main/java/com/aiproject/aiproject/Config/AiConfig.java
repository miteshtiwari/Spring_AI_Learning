package com.aiproject.aiproject.Config;

//import com.aiproject.aiproject.Advisor.CustomAdvisor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {


    // Note :- humko chatClient k under chatmodel btana padta hai which chatmodel we have to use


    // implementing chat memory :-
    // MessageChatmemoryadvisor banana hai uske aandar ChatMemory de deni hai bss , chat memory mai ye class aati by default MessageWindowChatMemory iske aandar inmemory wala intenally use hota hai


    @Bean(name = "OllamaChatClient")
    public ChatClient OllamaChatClient(OllamaChatModel chatModel, ChatMemory chatMemory) {
        MessageChatMemoryAdvisor messageChatMemoryAdvisor = MessageChatMemoryAdvisor.builder(chatMemory).build();
        return ChatClient
                .builder(chatModel)
                .defaultAdvisors(new SimpleLoggerAdvisor(),messageChatMemoryAdvisor)
                .build();
    }

    @Bean(name = "OpenAiChatClient")
    public ChatClient openAiChatClient(OpenAiChatModel chatModel) {
        return ChatClient.builder(chatModel)
                .build();
    }
}
