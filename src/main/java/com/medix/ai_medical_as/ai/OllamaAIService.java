// this happen in mile stone 2.5.2 .
//package com.medix.ai_medical_as.ai;
//
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestClient;
//
//import java.util.Map;
//
//@Service
//public class OllamaAIService implements AIService {
//
//    private final RestClient restClient;
//
//    public OllamaAIService() {
//
//        this.restClient = RestClient.builder()
//                .baseUrl("http://localhost:11434")
//                .build();
//    }
//
//    @Override
//    public String generateResponse(String userMessage) {
//
//        Map<String, Object> requestBody = Map.of(
//                "model", "llama3.2",
//                "prompt", userMessage,
//                "stream", false
//        );
//
//        Map response = restClient.post()
//                .uri("/api/generate")
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(requestBody)
//                .retrieve()
//                .body(Map.class);
//
//        if (response == null || response.get("response") == null) {
//            throw new RuntimeException(
//                    "AI service returned an empty response"
//            );
//        }
//
//        return response.get("response").toString();
//    }
//}
//
//
//package com.medix.ai_medical_as.ai;
//
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestClient;
//
//import java.util.Map;
//
//@Service
//public class OllamaAIService implements AIService {
//
//    private final RestClient restClient;
//
//    public OllamaAIService() {
//
//        this.restClient = RestClient.builder()
//                .baseUrl("http://localhost:11434")
//                .build();
//    }
//
//    @Override
//    public String generateResponse(String userMessage) {
//
//        String systemPrompt = """
//                You are an AI medical assistant.
//
//                Your purpose is to provide general health information
//                and educational guidance.
//
//                Follow these rules:
//
//                1. Do not claim to be a doctor.
//                2. Do not provide a definitive diagnosis.
//                3. Do not prescribe prescription medicines.
//                4. Explain health information in simple language.
//                5. If symptoms could indicate an emergency, clearly
//                   recommend seeking urgent medical care.
//                6. Encourage the user to consult a qualified healthcare
//                   professional when appropriate.
//                7. Do not invent medical facts.
//                8. Ask relevant follow-up questions when more information
//                   is needed.
//                9. Keep responses clear and reasonably concise.
//
//                User question:
//                """ + userMessage;
//
//        Map<String, Object> requestBody = Map.of(
//                "model", "llama3.2",
//                "prompt", systemPrompt,
//                "stream", false
//        );
//
//        Map response = restClient.post()
//                .uri("/api/generate")
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(requestBody)
//                .retrieve()
//                .body(Map.class);
//
//        if (response == null || response.get("response") == null) {
//
//            throw new RuntimeException(
//                    "AI service returned an empty response"
//            );
//        }
//
//        return response.get("response").toString();
//    }
//}



// this updated in mile stone 2.6.2 .
//package com.medix.ai_medical_as.ai;
//
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestClient;
//
//import java.util.List;
//import java.util.Map;
//
//@Service
//public class OllamaAIService implements AIService {
//
//    private final RestClient restClient;
//
//    public OllamaAIService() {
//        this.restClient = RestClient.builder()
//                .baseUrl("http://localhost:11434")
//                .build();
//    }
//
//    @Override
//    public String generateResponse(List<String> conversationHistory) {
//
//        StringBuilder prompt = new StringBuilder();
//
//        prompt.append("""
//                You are an AI medical assistant.
//
//                Your purpose is to provide general health information
//                and educational guidance.
//
//                Rules:
//
//                1. Do not claim to be a doctor.
//                2. Do not provide a definitive diagnosis.
//                3. Do not prescribe prescription medicines.
//                4. Explain health information in simple language.
//                5. If symptoms could indicate an emergency, recommend
//                   seeking urgent medical care.
//                6. Encourage consultation with a qualified healthcare
//                   professional when appropriate.
//                7. Do not invent medical facts.
//                8. Use previous conversation messages to understand
//                   the user's current question.
//                9. Keep responses clear and reasonably concise.
//
//                Conversation:
//
//                """);
//
//        prompt.append("""
//                IMPORTANT:
//                The following messages belong to ONE continuous conversation.
//                Do not say that this is a new conversation.
//                Use the previous messages to understand references such as
//                "it", "this", "that", or "my problem".
//
//                Conversation history:
//
//                """);
//
//        for (String message : conversationHistory) {
//            prompt.append(message);
//            prompt.append("\n");
//        }
//
//        prompt.append("""
//
//                Now answer the user's latest message.
//                Do not repeat the conversation history.
//                Do not mention that you are reading conversation history.
//
//                AI:
//                """);
//
//        Map<String, Object> requestBody = Map.of(
//                "model", "llama3.2",
//                "prompt", prompt.toString(),
//                "stream", false
//        );
//
//        Map response = restClient.post()
//                .uri("/api/generate")
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(requestBody)
//                .retrieve()
//                .body(Map.class);
//
//        if (response == null || response.get("response") == null) {
//            throw new RuntimeException(
//                    "AI service returned an empty response"
//            );
//        }
//
//        return response.get("response").toString();
//    }
//}




// this updated in mile stone 2.7.5 .
//
//package com.medix.ai_medical_as.ai;
//
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestClient;
//
//import java.util.List;
//import java.util.Map;
//
//@Service
//public class OllamaAIService implements AIService {
//
//    private final RestClient restClient;
//    private final MedicalPromptService medicalPromptService;
//
//    public OllamaAIService(
//            MedicalPromptService medicalPromptService) {
//
//        this.medicalPromptService = medicalPromptService;
//
//        this.restClient = RestClient.builder()
//                .baseUrl("http://localhost:11434")
//                .build();
//    }
//
//    @Override
//    public String generateResponse(
//            List<String> conversationHistory) {
//
//        String prompt =
//                medicalPromptService.buildPrompt(
//                        conversationHistory
//                );
//
//        Map<String, Object> requestBody = Map.of(
//                "model", "llama3.2",
//                "prompt", prompt,
//                "stream", false
//        );
//
//        Map response = restClient.post()
//                .uri("/api/generate")
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(requestBody)
//                .retrieve()
//                .body(Map.class);
//
//        if (response == null ||
//                response.get("response") == null) {
//
//            throw new RuntimeException(
//                    "AI service returned an empty response"
//            );
//        }
//
//        return response
//                .get("response")
//                .toString();
//    }
//}


package com.medix.ai_medical_as.ai;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import java.util.Map;

@Service
public class OllamaAIService implements AIService {

    private final RestClient restClient;
    private final MedicalPromptService medicalPromptService;
    private final ObjectMapper objectMapper;

    @Value("${ai.ollama.base-url}")
    private String ollamaBaseUrl;

    @Value("${ai.ollama.model}")
    private String ollamaModel;
    public OllamaAIService(
            MedicalPromptService medicalPromptService,
            ObjectMapper objectMapper,
            @Value("${ai.ollama.base-url}") String ollamaBaseUrl) {

        this.medicalPromptService = medicalPromptService;
        this.objectMapper = objectMapper;

        SimpleClientHttpRequestFactory factory =
                new SimpleClientHttpRequestFactory();

        factory.setConnectTimeout(5000);
        factory.setReadTimeout(60000);

        this.restClient = RestClient.builder()
             //   .baseUrl("http://localhost:11434")   instead of this we can use this new this is updated in 2.10.2 where we store the localhost in a variable then passs it
                .baseUrl(ollamaBaseUrl)
                .requestFactory(
                        new SimpleClientHttpRequestFactory()
                )
                .build();
    }

    @Override
    public MedicalAIResponse generateResponse(
            List<String> conversationHistory) {

        String prompt =
                medicalPromptService.buildPrompt(
                        conversationHistory
                );

        Map<String, Object> requestBody = Map.of(
                "model", "llama3.2",
                "prompt", prompt,
                "stream", false
        );

        try {

            Map response = restClient.post()
                    .uri("/api/generate")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(requestBody)
                    .retrieve()
                    .body(Map.class);

            if (response == null ||
                    response.get("response") == null) {

                throw new RuntimeException(
                        "AI service returned an empty response"
                );
            }

            String aiText =
                    response.get("response").toString();

            try {

                return objectMapper.readValue(
                        aiText,
                        MedicalAIResponse.class
                );

            } catch (Exception e) {

                throw new RuntimeException(
                        "AI returned invalid JSON response",
                        e
                );
            }

        } catch (Exception e) {

//            throw new RuntimeException(
//                    "Unable to communicate with AI service",
//                    e
//            ); in milestone 2.8.3 because we create a class for  RuntimeException therefore we change the name of this

            throw new AIServiceException(
                    "Unable to communicate with AI service",
                    e
            );
        }
    }
}
