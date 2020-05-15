package com.pimrulewriter;

import com.pimrulewriter.readers.InputFileReader;

public class Main {

    public static void main(String[] args) {

        InputFileReader inputFileReader = new InputFileReader();

        inputFileReader.openFile();

        for (int i = 0; i < inputFileReader.getColumnA().size(); i++) {
            System.out.println(inputFileReader.getColumnA().get(i)+" ");
            System.out.println(inputFileReader.getColumnB().get(i)+" ");
            System.out.println(inputFileReader.getColumnC().get(i)+" ");
        }

    }

}
