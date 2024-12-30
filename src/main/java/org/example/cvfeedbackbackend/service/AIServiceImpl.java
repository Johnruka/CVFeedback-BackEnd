package org.example.cvfeedbackbackend.service;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AIServiceImpl implements AIService {

    OpenAiChatModel openAiChatModel;

    @Autowired
    public AIServiceImpl(OpenAiChatModel openAiChatModel) {
        this.openAiChatModel = openAiChatModel;
    }

    @Override
    public String generateFeedback(String cv) {
        return "feedback";
    }

    @Override
    public String convertCVFeedbackChatbotToText(String cv) {
        String cvFeedbackChatbotToText = convertCVFeedbackChatbotToText(cv);
        return "cvFeedbackChatbotToText: " + cvFeedbackChatbotToText;
    }

    @Override
    public String callAIModelApi(String inputText) {
        String modelResponse = callAIModelApi(inputText);
        return modelResponse;
    }
}
