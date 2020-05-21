package com.pimrulewriter.writers;

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
        System.out.println("What kind of rule do you want to write?\n" +
                " - Brand rule with 1 column [b1]\n" +
                " - Brand rule with 2 columns [b2] (brand name, category name)\n" +
                " - Other parameter-to-category rule with one column [ptc]\n" +
                " - Other parameter-to-category rule with two columns [ptc2]\n" +
                " - Empty category rule [e]\n" +
                " - Rule that sets a value to parameter when other parameter value is on the list [v2p]\n"
        );
        typeOfRule = input.next().toLowerCase();

        ParameterToCategoryRuleWriter PTCRwriter = new ParameterToCategoryRuleWriter();
        EmptyCategoryRuleWriter ECRWriter = new EmptyCategoryRuleWriter();
        IfAttributeListedSetParameterToRuleWriter IALSPTRwriter = new IfAttributeListedSetParameterToRuleWriter();

        if (typeOfRule.equals("b1")){
            PTCRwriter.writeBrandRule(columnA,null,1);
        } else if (typeOfRule.equals("b2")){
            PTCRwriter.writeBrandRule(columnA,columnB,2);
        } else if (typeOfRule.equals("ptc")) {
            PTCRwriter.writeOtherParameterToCategoryRule(columnA,null,1,input);
        } else if (typeOfRule.equals("ptc2")){
            PTCRwriter.writeOtherParameterToCategoryRule(columnA,columnB,2,input);
        } else if (typeOfRule.equals("e")){
            ECRWriter.writeEmptyCategoryRule(input);
        } else if (typeOfRule.equals("v2p")){
            IALSPTRwriter.writeSetParameterRule(columnA,input);
        }
        else {
            System.out.println("Wrong command");
        }

    }


}
