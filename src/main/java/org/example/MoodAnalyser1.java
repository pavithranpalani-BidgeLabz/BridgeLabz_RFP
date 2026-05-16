package org.example;

public class MoodAnalyser1 {
    String message;

    public MoodAnalyser1(String message) {
        this.message = message;
    }

    // UC1 && UC2 && UC3
    public String analyseMood() throws MoodAnalysisException {
        try {
            if (message.length() == 0){
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.EMPTY,"Mood can't be Empty");
            }
            if (message.contains("SAD")) {
                return "SAD";
            } else {
                return "HAPPY";
            }
        } catch (RuntimeException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NULL
                    , "Mood can't be Null");
        }
    }
}
