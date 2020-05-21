package com.pimrulewriter.writers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class IfAttributeListedSetParameterToRuleWriter {

    void writeSetParameterRule(ArrayList<String> columnA, Scanner input) {

        System.out.println("What parameter values does the list contain (ex. brand, supplier etc.)?");
        String conditionParameter = input.next();
        System.out.println("What parameter do you want to set for those products (ex. brand, supplier, x_flag)?");
        String setParameter = input.next();
        System.out.println("What is the desired value (ex. available, sold_out)?");
        String setValue = input.next();
        System.out.println("What is the locale?(ex. en_US, fr_FR)?");
        String locale = input.next();

        try {
            FileWriter fileWriter = new FileWriter("generated_rules.yml");

            fileWriter.write("rules:\n");
            fileWriter.write("    assign_attribute_"+setParameter.toLowerCase()+":\n" +
                    "        priority: 90\n" +
                    "        conditions:\n" +
                    "            - field: "+conditionParameter+"\n" +
                    "              operator: IN\n" +
                    "              value: \n");
            for (int i = 0; i < columnA.size(); i++){
                fileWriter.write("                  - "+columnA.get(i)+"\n");
                }
            fileWriter.write("        actions:\n" +
                    "            - type: set\n" +
                    "              field: "+setParameter+"\n" +
                    "              locale: "+locale+"\n" +
                    "              channel: null\n" +
                    "              value: "+setValue+"");

            fileWriter.close();
            System.out.println("Brand rules generated");
        } catch (
                IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
