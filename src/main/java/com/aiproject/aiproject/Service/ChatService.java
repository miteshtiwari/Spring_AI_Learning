package com.aiproject.aiproject.Service;

import com.aiproject.aiproject.Helper.Helper;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.document.Document;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatService {

    @Autowired
    private ChatClient OllamaChatClient;
    @Autowired
    private ChatMemory chatMemory;

    @Autowired
    private VectorStore vectorStore;

//    MessageChatMemoryAdvisor messageChatMemoryAdvisor = MessageChatMemoryAdvisor.builder(chatMemory).build();


    public Flux<String> streamchat(String query, String convoid) {

        String CONVERSATION_ID = convoid;
        return OllamaChatClient
                .prompt()
                .advisors(
                        MessageChatMemoryAdvisor.builder(chatMemory)
                                .conversationId(CONVERSATION_ID)
                                .build()
                )
                .system("""
                        You are a concise assistant.l̥
                        - No examples unless asked
                        - No extra explanation given
                        - No repetition
                        """)
                .user(query)
                .stream()
                .content();
    }
    public void saveData(List<String> list) {

        List<Document> finalDocs = new ArrayList<>();

        for (String item : list) {

            String[] sentences = item.split("(?<=\\. )");

            StringBuilder chunk = new StringBuilder();

            for (String sentence : sentences) {

                if (chunk.length() + sentence.length() < 300) {
                    chunk.append(sentence).append(" ");
                } else {
                    finalDocs.add(new Document(chunk.toString()));
                    chunk = new StringBuilder(sentence);
                }
            }

            if (!chunk.isEmpty()) {
                finalDocs.add(new Document(chunk.toString()));
            }
        }

        System.out.println("Chunks created: " + finalDocs.size());

        vectorStore.add(finalDocs);
    }}
