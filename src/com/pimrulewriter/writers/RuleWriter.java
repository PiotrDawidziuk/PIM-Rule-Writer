package com.pimrulewriter.writers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RuleWriter {
    ArrayList<String> columnA = null;
    ArrayList<String> columnB = null;
    ArrayList<String> columnC = null;

    public RuleWriter(ArrayList<String> columnA, ArrayList<String> columnB, ArrayList<String> columnC) {
        this.columnA = columnA;
        this.columnB = columnB;
        this.columnC = columnC;
    }

    public void writeRules(){

        String typeOfRule = "brand";
        Scanner input  = new Scanner(System.in);
        System.out.println("What kind of rule do you want to write? Brand rule with 1 column [b1], brand rule with 2 columns [b2]");
        typeOfRule = input.next().toLowerCase();
        if (typeOfRule.equals("b1")){
            writeBrandRuleWithOneColumn(columnA);
        } else {
            System.out.println("Wrong command");
        }

    }

    private void writeBrandRuleWithOneColumn(ArrayList<String> columnA) {
        try {
            FileWriter fileWriter = new FileWriter("generated_rules.yml");

            fileWriter.write("rules:\n");
            for (int i = 0; i < columnA.size(); i++){
                fileWriter.write("    add_"+columnA.get(i).toLowerCase()+"_brand_category:\n");
                fileWriter.write("        priority: 90\n");
                fileWriter.write("            -   field: brand\n");
                fileWriter.write("                value: \""+columnA.get(i)+"\"\n");
                fileWriter.write("                channel: null\n");
                fileWriter.write("        actions:\n");
                fileWriter.write("            -   type: add\n");
                fileWriter.write("                field: categories\n");
                fileWriter.write("                items:\n");
                fileWriter.write("                  - brands_"+columnA.get(i).toLowerCase()+"\n");
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
