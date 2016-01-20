package com.vladimir.rodin;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.zip.Adler32;

public class Main {

    public static String toHex(String arg) {
        return String.format("%040x", new BigInteger(1, arg.getBytes(/*YOUR_CHARSET?*/)));
    }


    public static void main(String[] args) {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userInput = null;

        System.out.print("Введите фразу, которые Вы хотите зашифровать: ");

        try {
            userInput = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("ASCII код каждого символа: ");
        assert userInput != null;
        for (int i = 0; i < userInput.length(); i++) {
            int ch = (int) userInput.charAt(i);
            System.out.print("ASCII(" + userInput.charAt(i) + "):" + ch + "    ");
        }
        System.out.println();
        System.out.println();
        System.out.print("Фраза " + userInput + " зашифрованная методом ADLER32: ");

        byte[] bytes = null;

        bytes = userInput.getBytes();

        Adler32 adl = new Adler32();
        adl.update(bytes);
        System.out.print(adl.getValue());
    }
}
