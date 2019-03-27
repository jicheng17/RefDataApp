package com.jaycee.rda;

import com.jaycee.rda.util.Util;

import java.io.*;
import java.util.Scanner;

public class AppEngine {
    public static void main(String[] arg) {
        RDProcessor processor = new RDProcessor();

        System.out.println("=========== Start RD processor ========== ");
        String str = "";

        InputStream is = null;
        try {
            is = AppEngine.class.getResourceAsStream("/INSTRUCTION.dat");

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            reader.readLine();
            if (is != null) {
                while ((str = reader.readLine()) != null) {
                    String[] strs = str.split("\\|");
                    Instruction instruction = new Instruction(strs[1].trim(), strs[2].trim(), Util.toDate(strs[3].trim()), Util.toDate(strs[4].trim()), strs[5].trim(),
                            strs[6].trim(), strs[7].trim(), strs[8].trim());

                    processor.process(instruction);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (Throwable ignore) {
            }
        }

        System.out.println("=========== End RD processor ========== ");

    }
}
