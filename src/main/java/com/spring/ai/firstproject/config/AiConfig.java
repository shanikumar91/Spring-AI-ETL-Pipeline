package com.spring.ai.firstproject.config;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class AiConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder){
        return builder
                .defaultAdvisors( new SimpleLoggerAdvisor(), new SafeGuardAdvisor(List.of("games")))
                .defaultOptions(
                        OllamaChatOptions.builder()
                                .model("codellama:latest")
                                .temperature(0.7)
                                .maxTokens(200)
                )
                .build();
    }
}
