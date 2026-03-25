package com.aiproject.aiproject.Service;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.document.Document;
//import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.rag.advisor.RetrievalAugmentationAdvisor;
import org.springframework.ai.rag.preretrieval.query.expansion.MultiQueryExpander;
import org.springframework.ai.rag.preretrieval.query.expansion.QueryExpander;
import org.springframework.ai.rag.preretrieval.query.transformation.QueryTransformer;
import org.springframework.ai.rag.preretrieval.query.transformation.RewriteQueryTransformer;
import org.springframework.ai.rag.preretrieval.query.transformation.TranslationQueryTransformer;
import org.springframework.ai.rag.retrieval.join.ConcatenationDocumentJoiner;
import org.springframework.ai.rag.retrieval.search.DocumentRetriever;
import org.springframework.ai.rag.retrieval.search.VectorStoreDocumentRetriever;
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
    private ChatClient OpenAiChatClient;
    @Autowired
    private ChatMemory chatMemory;

    @Autowired
    private VectorStore vectorStore;

//    MessageChatMemoryAdvisor messageChatMemoryAdvisor = MessageChatMemoryAdvisor.builder(chatMemory).build();


    public Flux<String> streamchat(String query, String convoid) {

        String CONVERSATION_ID = convoid;
        return OpenAiChatClient.prompt().advisors(MessageChatMemoryAdvisor.builder(chatMemory).conversationId(CONVERSATION_ID).build()).system("""
                You are a concise assistant.l̥
                - No examples unless asked
                - No extra explanation given
                - No repetition
                """).user(query).stream().content();
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
    }

    public String processchat4(String query) {

        QueryTransformer queryTransformer = RewriteQueryTransformer.builder().chatClientBuilder(OpenAiChatClient.mutate().clone()).build();

//        QueryTransformer queryTransformer = RewriteQueryTransformer.builder()          this and above one we can use basicalyy we need chatClientBuilder which call LLM and this is the type of builder when we do builder.build() it internally gives us chatclientbuilder
//                .chatClientBuilder(ChatClient.builder(chatModel)).build();

        QueryTransformer queryTransformer2 = TranslationQueryTransformer.builder().chatClientBuilder(OpenAiChatClient.mutate().clone()).targetLanguage("english").build();


        DocumentRetriever documentRetriever = VectorStoreDocumentRetriever.builder().vectorStore(vectorStore).similarityThreshold(0.5).topK(5).build();

        QueryExpander queryExpander = MultiQueryExpander.builder().chatClientBuilder(OpenAiChatClient.mutate().clone()).build();

        var advisor = RetrievalAugmentationAdvisor.builder()
//                .queryTransformers(queryTransformer, queryTransformer2)
//                .queryExpander(queryExpander)
                .documentRetriever(documentRetriever)
                .documentJoiner(new ConcatenationDocumentJoiner())
                .build();


        var response = OpenAiChatClient.prompt("Do not answer from your own knowledge.").advisors(advisor)
                .system("""
                        You are a course recommendation assistant.
                        
                        Select matching lines from the context.
                        
                        Rules:
                        1. Return exact lines from context.
                        2. Do NOT change wording.
                        3. If multiple matches, return all.
                        4. If no match, say: "No relevant course found."
                        
                        Format:
                        Course: <first few words of the line>
                        Details: <full line>
                        instructor :<full line>
                        """).user(query).call().content();
        return response;

    }
}
