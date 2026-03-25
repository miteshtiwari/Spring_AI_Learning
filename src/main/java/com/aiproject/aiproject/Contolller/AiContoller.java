package com.aiproject.aiproject.Contolller;

import com.aiproject.aiproject.Entity.Tut;
import com.aiproject.aiproject.Service.ChatService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.document.Document;
//import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.ai.ollama.OllamaChatModel;
import reactor.core.publisher.Flux;

import java.lang.annotation.Documented;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class AiContoller {

    @Autowired
    private ChatService chatService;

    @Autowired
    private VectorStore vectorStore;

    private final ChatClient OpenAiChatClient;

//    private ChatClient OllamaChatClient;

    public AiContoller(@Qualifier("OpenAiChatClient") ChatClient OpenAiChatClient) {
        this.OpenAiChatClient = OpenAiChatClient;
    }


// Controller for doing chat with LLM
//    @GetMapping("/chat")
//    private ResponseEntity<String> chat(@RequestParam(value = "q",required = true) String query){
//
//        var build =  OllamaChatClient
//                .prompt()
//                .user(query)
//                .system("GIve the Response As you are a Cricket Expert")
//                .advisors(new SimpleLoggerAdvisor())
//                .call()
//                .content();
//
//        return ResponseEntity.ok("Response from AI :-"+ build);
//    }
//

    public String chattemplate() {
        // first step
        PromptTemplate strtemplate = PromptTemplate.builder().template("what is {techname} tell me example of {technology}").build();

        //render the template

        String renderedmsg = strtemplate.render(Map.of(
                "techname", "spring",
                "technology", "spring boot"
        ));

        Prompt prompt = new Prompt(renderedmsg);

        //        var content = this.OllamaChatClient.prompt(prompt).call().content();
        return renderedmsg;
    }


    public String buildSystemPrompt(String contextdata) {

        PromptTemplate template = PromptTemplate.builder()
                .template("""
                        You are a Coding Assistant.
                        
                        TASK:
                        Answer the user's question using ONLY the DOCUMENTS provided.
                        
                        RULES:
                        - Find the exact sentence in DOCUMENTS that answers the question.
                        - If found, return that sentence.
                        - Do NOT generate your own knowledge.
                        - Keep the answer short and direct.
                        
                        If the answer is NOT present in DOCUMENTS, reply exactly:
                        This Query is not in db
                        
                        OUTPUT FORMAT:
                        Answer: <short answer>
                        Source: <exact sentence from documents>
                        
                        IMPORTANT:
                        - Do not explain anything.
                        - Do not add extra text.
                        - Only return the format above.
                        
                        DOCUMENTS:
                        {documents}
                        """)
                .build();

        return template.render(Map.of(
                "documents", contextdata
        ));
    }

    // implememted similarity search

    @GetMapping("/chat")
    private ResponseEntity<String> chat3(@RequestParam(value = "q") String query) {

        SearchRequest searchRequest = SearchRequest.builder()
                .topK(4)
                .similarityThreshold(0.6)
                .query(query)
                .build();

        List<Document> documents = vectorStore.similaritySearch(searchRequest);

        String contextdata = documents.stream()
                .map(Document::getText)
                .collect(Collectors.joining("\n\n---\n\n"));

        System.out.println("context data " + contextdata);

        String systemPrompt = buildSystemPrompt(contextdata);

        var response = OpenAiChatClient
                .prompt()
                .system(systemPrompt)   // ✅ context + rules
                .user("Answer this question strictly from the documents: " + query)        // ✅ user question
                .call()
                .content();

        return ResponseEntity.ok("Response from AI :- " + response);
    }

    @GetMapping("/chatnew")
    private ResponseEntity<String> chat4(@RequestParam(value = "q") String query) {


//        OpenAiChatClient OpenAiChatClient;
        return ResponseEntity.ok(chatService.processchat4(query));
    }



//    @GetMapping("/chat-class")
//    private Tut chat2(@RequestParam(value = "q",required = true) String query){
//
//        String prompt = """
//        Return ONLY valid JSON.
//
//        STRICT RULES:
//        - No explanation
//        - No extra text
//        - No markdown
//        - Only JSON
//
//        Format:
//        {
//          "title": "...",
//          "content": "...",
//          "createdYear": "..."
//        }
//
//        """;

    /// / there is some issue with ollama itself sometime it gives response in entity format sometime not
//        Tut build =  OllamaChatClient
//                .prompt(prompt)
//                .user(query)
//                .advisors(new SimpleLoggerAdvisor())
//                .call()
//                .entity(Tut.class);
//
//        return build;
//    }
    @GetMapping("/stream-chat")
    public ResponseEntity<Flux<String>> streamchat(@RequestParam("q") String query, @RequestHeader("conversation-id") String convoid) {

        return ResponseEntity.ok(chatService.streamchat(query, convoid));
    }

}
