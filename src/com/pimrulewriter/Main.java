package com.pimrulewriter;

import com.pimrulewriter.additional.Intro;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Intro intro = new Intro();
        intro.intro();
        intro.readAndWrite(input);

        input.close();
    }

}
