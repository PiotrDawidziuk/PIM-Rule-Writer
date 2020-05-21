package com.pimrulewriter.additional;

import com.pimrulewriter.readers.InputFileReader;
import com.pimrulewriter.writers.RuleWriter;

import java.util.Scanner;

public class Intro {

    public void intro (){
        System.out.println( Colors.ANSI_BLUE +
                "    ____  ______  ___   ____        __        _       __     _ __           \n" +
                "   / __ \\/  _/  |/  /  / __ \\__  __/ /__     | |     / /____(_) /____  _____\n" +
                "  / /_/ // // /|_/ /  / /_/ / / / / / _ \\    | | /| / / ___/ / __/ _ \\/ ___/\n" +
                " / ____// // /  / /  / _, _/ /_/ / /  __/    | |/ |/ / /  / / /_/  __/ /    \n" +
                "/_/   /___/_/  /_/  /_/ |_|\\__,_/_/\\___/     |__/|__/_/  /_/\\__/\\___/_/     \n" +
                "                                                                            \n" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_CYAN + "Welcome to PIM Rule Writer by Piotr Dawidziuk, 2020" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_YELLOW + "To use this program you must prepare a csv file with columns of data that is going to be used to create a YAML file with rules. \n" +
                "If you wish to write a rule that doesn't need a file, create an empty file"+ Colors.ANSI_RESET);
    }


    public void readAndWrite(Scanner input) {
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
    }
}
