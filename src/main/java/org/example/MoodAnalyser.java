package org.example;

public class MoodAnalyser {
    public String analyseMood(String msg){
        if (msg.contains("SAD")){
            return "SAD";
        }else{
            return "HAPPY";
        }
    }
    public static void main(String[] args) {

    }
}
