package com.pimrulewriter.writers;

import java.util.ArrayList;
import java.util.Scanner;

public class RuleWriter {

    public RuleWriter(ArrayList<String > columnA) {
    }

    public RuleWriter(ArrayList<String > columnA,ArrayList<String > columnB) {
    }

    public RuleWriter(ArrayList<String > columnA,ArrayList<String > columnB,ArrayList<String > columnC) {
    }

    public void writeRules(){

        String typeOfRule = "brand";
        Scanner input  = new Scanner(System.in);
        System.out.println("What kind of rule do you want to write? (default: brand rule)");
        typeOfRule = input.next();
        if (typeOfRule.equals("brand")){
            writeBrandRule();
        } else {
            System.out.println("Wrong command");
        }

    }

    private void writeBrandRule() {
        System.out.println("writing brand rule");
    }

}
