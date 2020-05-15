package com.pimrulewriter.readers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputFileReader {

    ArrayList<String> columnA = new ArrayList<>();
    ArrayList<String> columnB = new ArrayList<>();
    ArrayList<String> columnC = new ArrayList<>();

    public void openFile(){
        String delimiter = ";";

        Scanner input  = new Scanner(System.in);
        System.out.println("What is the delimiter of your CSV file? ; or , (; being the default value)");
        delimiter = input.next();
        if (!delimiter.equals(",")){
            delimiter = ";";
        }
        System.out.println("What file do you want to open? Include extension (.csv, .txt etc.)");
        String fileName = input.next();

        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                data = data.replace("\"", "");
                String[] tempData = data.split(delimiter);
                if (tempData.length==1) {
                    columnA.add(tempData[0]);
                } else if (tempData.length==2) {
                    columnA.add(tempData[0]);
                    columnB.add(tempData[1]);
                } else if (tempData.length==3) {
                    columnA.add(tempData[0]);
                    columnB.add(tempData[1]);
                    columnC.add(tempData[2]);
                } else {
                    System.out.println("Wrong number of columns");
                    break;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public ArrayList<String> getColumnA() {
        return columnA;
    }

    public ArrayList<String> getColumnB() {
        return columnB;
    }

    public ArrayList<String> getColumnC() {
        return columnC;
    }
}
