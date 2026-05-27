package org.example;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        try {

            File file = new File(
                    "bridglabz-java/src/csv/IndiaStateCensusData.csv");

            System.out.println("File Exists : "
                    + file.exists());

            System.out.println("File Path : "
                    + file.getAbsolutePath());

            StateCensusAnalyser analyser =
                    new StateCensusAnalyser();

            int count =
                    analyser.loadIndiaCensusData(
                            "bridglabz-java/src/csv/IndiaStateCensusData.csv");

            System.out.println(
                    "Number Of Records : " + count);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }
}