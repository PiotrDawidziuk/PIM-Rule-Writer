package com.pimrulewriter;

import com.pimrulewriter.readers.InputFileReader;
import com.pimrulewriter.writers.RuleWriter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        InputFileReader inputFileReader = new InputFileReader();

        inputFileReader.openFile(input);
        int columns = inputFileReader.getNumberOfColumns();

        RuleWriter ruleWriter = null;

        if (columns == 0) {
            System.out.println("Wrong number of columns or columns are not equal");
        } else {
            ruleWriter = new RuleWriter(inputFileReader.getColumnA(),inputFileReader.getColumnB(),inputFileReader.getColumnC());
        }

        if (ruleWriter!=null){
            ruleWriter.writeRules();
        }

        input.close();
    }

}
