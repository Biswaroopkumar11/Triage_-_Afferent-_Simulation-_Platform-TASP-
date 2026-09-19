package com.medix.ai_medical_as.ai;

import java.util.List;

public class MedicalAIResponse {

    private String answer;

    private List<String> possibleCauses;

    private List<String> warningSigns;

    private String recommendedAction;

    private boolean needsMedicalAttention;

    public MedicalAIResponse() {
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public List<String> getPossibleCauses() {
        return possibleCauses;
    }

    public void setPossibleCauses(List<String> possibleCauses) {
        this.possibleCauses = possibleCauses;
    }

    public List<String> getWarningSigns() {
        return warningSigns;
    }

    public void setWarningSigns(List<String> warningSigns) {
        this.warningSigns = warningSigns;
    }

    public String getRecommendedAction() {
        return recommendedAction;
    }

    public void setRecommendedAction(String recommendedAction) {
        this.recommendedAction = recommendedAction;
    }

    public boolean isNeedsMedicalAttention() {
        return needsMedicalAttention;
    }

    public void setNeedsMedicalAttention(
            boolean needsMedicalAttention) {
        this.needsMedicalAttention = needsMedicalAttention;
    }
}