package com.pimrulewriter.writers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EmptyCategoryRuleWriter {

    void writeEmptyCategoryRule(Scanner input) {

        System.out.println("What is the name of the category that you want to add products without category (ex: no_category)?");
        String categoryName = input.next().toLowerCase();

        try {
            FileWriter fileWriter = new FileWriter("generated_rules.yml");

            fileWriter.write("rules:\n");
            fileWriter.write("    empty_category_to_delisted:\n" +
                    "        priority: 90\n" +
                    "        conditions:\n" +
                    "            -   field: categories\n" +
                    "                operator: UNCLASSIFIED\n" +
                    "                value: \n" +
                    "                  - null\n" +
                    "        actions:\n" +
                    "            -   type: add\n" +
                    "                field: categories\n" +
                    "                items:\n" +
                    "                  - "+categoryName);

            fileWriter.close();
            System.out.println("Brand rules generated");
        } catch (
                IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
