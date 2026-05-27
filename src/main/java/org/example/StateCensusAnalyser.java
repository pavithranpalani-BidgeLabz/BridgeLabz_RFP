package org.example;


import java.io.FileReader;
import java.io.Reader;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyser {

    public int loadIndiaCensusData(String csvFilePath)
            throws CensusAnalyserException {

        try {

            Reader reader = new FileReader(csvFilePath);

            CsvToBean<CSVStateCensus> csvToBean =
                    new CsvToBeanBuilder(reader)
                            .withType(CSVStateCensus.class)
                            .withIgnoreLeadingWhiteSpace(true)
                            .build();

            Iterator<CSVStateCensus> censusIterator =
                    csvToBean.iterator();

            int count = 0;

            while (censusIterator.hasNext()) {

                count++;

                censusIterator.next();
            }

            return count;

        } catch (RuntimeException e) {

            throw new CensusAnalyserException(
                    "Incorrect Delimiter",
                    CensusAnalyserException.ExceptionType.INCORRECT_DELIMITER);

        } catch (Exception e) {

            if (csvFilePath.contains(".txt")) {

                throw new CensusAnalyserException(
                        "Invalid File Type",
                        CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE);
            }

            throw new CensusAnalyserException(
                    "File Not Found",
                    CensusAnalyserException.ExceptionType.NO_SUCH_FILE);
        }
    }
}
