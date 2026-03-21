package com.aiproject.aiproject.Contolller;

import com.aiproject.aiproject.Entity.Tut;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AiContoller {

    private ChatClient OpenAiChatClient;

    private ChatClient OllamaChatClient;

    public AiContoller(@Qualifier("OpenAiChatClient") ChatClient openAiChatClient, @Qualifier("OllamaChatClient")ChatClient ollamaChatClient) {
        this.OpenAiChatClient = openAiChatClient;
        this.OllamaChatClient = ollamaChatClient;
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

        public String chattemplate(){
        // first step
        PromptTemplate strtemplate = PromptTemplate.builder().template("what is {techname} tell me example of {technology}").build();

        //render the template

        String renderedmsg = strtemplate.render(Map.of(
                "techname","spring",
                "technology","spring boot"
        ));

        Prompt prompt = new Prompt(renderedmsg);

    //        var content = this.OllamaChatClient.prompt(prompt).call().content();
        return renderedmsg;
    }

    @GetMapping("/chat")
    private ResponseEntity<String> chat3(@RequestParam(value = "q",required = true) String query){
        var build =  OllamaChatClient
                .prompt()
                .user(query)
                .call()
                .content();

        return ResponseEntity.ok("Response from AI :-"+ build);
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
//// there is some issue with ollama itself sometime it gives response in entity format sometime not
//        Tut build =  OllamaChatClient
//                .prompt(prompt)
//                .user(query)
//                .advisors(new SimpleLoggerAdvisor())
//                .call()
//                .entity(Tut.class);
//
//        return build;
//    }


}
