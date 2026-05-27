package org.example;
/*
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;*/

public class UC14 {

    public static void main(String[] args) throws Exception {

       /* CSVWriter writer =
                new CSVWriter(new FileWriter("address.csv"));*/

        String[] header = {"Name", "City"};
        String[] data1 = {"Ranjith", "Chennai"};
        String[] data2 = {"Arun", "Madurai"};

       /* writer.writeNext(header);
        writer.writeNext(data1);
        writer.writeNext(data2);

        writer.close();

        CSVReader reader =
                new CSVReader(new FileReader("address.csv"));

        for (String[] row : reader.readAll()) {

            for (String value : row) {
                System.out.print(value + " ");
            }

            System.out.println();
        }

        reader.close();
    }*/
    }
}