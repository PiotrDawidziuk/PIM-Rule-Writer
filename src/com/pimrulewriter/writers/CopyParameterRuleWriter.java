package com.pimrulewriter.writers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CopyParameterRuleWriter {

    void copyParameter(ArrayList<String> columnA,ArrayList<String> columnB, Scanner input) {

        System.out.println("What do you want to name your rule (ex. copy_attributes_x_to_attrs_y)?");
        String ruleName = input.next();
        System.out.println("Set conditions. Which field is in conditions (ex. copy_flag)?");
        String conditionField = input.next();
        System.out.println("From which locale? (ex. en_US)");
        String conditionLocale = input.next();
        System.out.println("Which channel?(ex. null)");
        String conditionChannel = input.next();
        System.out.println("What's your parameter value?");
        String conditionValue = input.next();
        System.out.println("Now we have to describe the copied attributes. What is the locale you copy from? (ex. en_US)");
        String localeFrom = input.next();
        System.out.println("What is the locale you copy to?(ex. en_US)");
        String localeTo = input.next();
        System.out.println("What is the scope you copy from? (ex. ecommerce)");
        String scopeFrom = input.next();
        System.out.println("What is the scope you copy to?(ex. ecommerce)");
        String scopeTo = input.next();
        System.out.println("Remember some attributes don't need scope or locale and others do.\n" +
                "If you get errors, just edit the YAML file with notepad and delete unnecessary parameters");

        try {
            FileWriter fileWriter = new FileWriter("generated_rules.yml");

            fileWriter.write("rules:\n");
            fileWriter.write("    "+ruleName+":\n" +
                    "        priority: 90\n" +
                    "        conditions:\n" +
                    "            -   field: "+conditionField+"\n" +
                    "                locale: "+conditionLocale+"\n" +
                    "                operator: IN\n" +
                    "                channel: "+conditionChannel+"\n" +
                    "                value: \n" +
                    "                    - "+conditionValue+"            \n" +
                    "        actions:\n");
            for (int i = 0; i < columnA.size(); i++){
                fileWriter.write(
                        "            -   type: copy\n" +
                        "                from_field: "+columnA.get(i)+"\n" +
                        "                to_field: "+columnB.get(i)+"\n" +
                        "                from_locale: "+localeFrom+"\n" +
                        "                to_locale: "+localeTo+"\n" +
                        "                from_scope: "+scopeFrom+"\n" +
                        "                to_scope: "+scopeTo+"\n");
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
