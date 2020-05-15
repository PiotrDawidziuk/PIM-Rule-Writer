package com.pimrulewriter;

import com.pimrulewriter.readers.InputFileReader;
import com.pimrulewriter.writers.RuleWriter;

public class Main {

    public static void main(String[] args) {

        InputFileReader inputFileReader = new InputFileReader();

        inputFileReader.openFile();
        int columns = inputFileReader.getNumberOfColumns();

        RuleWriter ruleWriter = null;

        if (columns == 0) {
            System.out.println("Wrong number of columns or columns are not equal");
        } else if (columns == 1){
            ruleWriter = new RuleWriter(inputFileReader.getColumnA());
        } else if (columns ==2){
            ruleWriter = new RuleWriter(inputFileReader.getColumnA(),inputFileReader.getColumnB());
        } else if (columns ==3){
            ruleWriter = new RuleWriter(inputFileReader.getColumnA(),inputFileReader.getColumnB(),inputFileReader.getColumnC());
        }

        if (ruleWriter!=null){
            ruleWriter.writeRules();
        }

    }

}
