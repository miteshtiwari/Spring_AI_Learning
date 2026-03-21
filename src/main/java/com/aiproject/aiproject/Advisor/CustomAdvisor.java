package com.aiproject.aiproject.Advisor;

import org.springframework.ai.chat.client.ChatClientRequest;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.client.advisor.api.Advisor;
import org.springframework.ai.chat.client.advisor.api.CallAdvisor;
import org.springframework.ai.chat.client.advisor.api.CallAdvisorChain;

public class CustomAdvisor implements CallAdvisor {
    @Override
    public ChatClientResponse adviseCall(ChatClientRequest chatClientRequest, CallAdvisorChain callAdvisorChain) {
        System.out.println("chat client rqst is " + chatClientRequest.prompt().getContents());

        ChatClientResponse chatClientResponse = callAdvisorChain.nextCall(chatClientRequest);

        System.out.println("token total used "+chatClientResponse.chatResponse().getMetadata().getUsage().getCompletionTokens());
        return chatClientResponse;
    }

    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
