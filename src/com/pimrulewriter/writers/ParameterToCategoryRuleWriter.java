package com.pimrulewriter.writers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ParameterToCategoryRuleWriter {

    public void writeOtherParameterToCategoryRule(ArrayList<String> columnA, ArrayList<String> columnB, int numberOfColumns, Scanner input) {

        System.out.println("From which field do you want to get your category?");
        String field = input.next().toLowerCase();
        String prefix = "";
        if(numberOfColumns ==1){
            System.out.println("What prefix to do you want to give to your category name? (ex. category_, brand_ etc.)");
            prefix = input.next();
        }
        try {
            FileWriter fileWriter = new FileWriter("generated_rules.yml");

            fileWriter.write("rules:\n");
            for (int i = 0; i < columnA.size(); i++){
                if (numberOfColumns == 2){
                    fileWriter.write("    add_product_to_"+columnB.get(i)+"_category:\n");
                } else {
                    fileWriter.write("    add_product_to_"+columnA.get(i).toLowerCase()+"_category:\n");
                }
                fileWriter.write("        priority: 90\n");
                fileWriter.write("            -   field: "+field+"\n");
                fileWriter.write("                value: \""+columnA.get(i)+"\"\n");
                fileWriter.write("                channel: null\n");
                fileWriter.write("        actions:\n");
                fileWriter.write("            -   type: add\n");
                fileWriter.write("                field: categories\n");
                fileWriter.write("                items:\n");
                if (numberOfColumns == 2){
                    fileWriter.write("                  - "+columnB.get(i)+"\n");
                } else {
                    fileWriter.write("                  - "+prefix+columnA.get(i).toLowerCase()+"\n");
                }
            }


            fileWriter.close();
            System.out.println("Brand rules generated");
        } catch (
                IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public void writeBrandRule(ArrayList<String> columnA,ArrayList<String> columnB,int numberOfColumns) {
        try {
            FileWriter fileWriter = new FileWriter("generated_rules.yml");

            fileWriter.write("rules:\n");
            for (int i = 0; i < columnA.size(); i++){
                if (numberOfColumns == 2){
                    fileWriter.write("    add_"+columnB.get(i)+"_category:\n");
                } else {
                    fileWriter.write("    add_"+columnA.get(i).toLowerCase()+"_brand_category:\n");
                }
                fileWriter.write("        priority: 90\n");
                fileWriter.write("            -   field: brand\n");
                fileWriter.write("                value: \""+columnA.get(i)+"\"\n");
                fileWriter.write("                channel: null\n");
                fileWriter.write("        actions:\n");
                fileWriter.write("            -   type: add\n");
                fileWriter.write("                field: categories\n");
                fileWriter.write("                items:\n");
                if (numberOfColumns == 2){
                    fileWriter.write("                  - "+columnB.get(i)+"\n");
                } else {
                    fileWriter.write("                  - brands_"+columnA.get(i).toLowerCase()+"\n");
                }
            }


            fileWriter.close();
            System.out.println("Brand rules generated");
        } catch (
                IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}
