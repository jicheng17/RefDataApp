package com.jaycee.rda;

import com.jaycee.rda.domain.InstructType;
import com.jaycee.rda.domain.Instruction;
import com.jaycee.rda.processor.ProcessorFactory;
import com.jaycee.rda.processor.RDProcessor;
import com.jaycee.rda.util.Util;

import java.io.*;

/**
 * Engine class to run the program
 */
public class AppEngine {
    public static void main(String[] arg) {
        System.out.println("=========== Start RD processor ========== ");
        String input = "";

        InputStream is = null;
        try {
            is = AppEngine.class.getResourceAsStream("/INSTRUCTION.dat");

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String header = reader.readLine();
            if (is != null) {
                while ((input = reader.readLine()) != null) {

                    String[] strs = input.split("\\|");
                    Instruction instruction = new Instruction(strs[1].trim(), strs[2].trim(), Util.toDate(strs[3].trim()), Util.toDate(strs[4].trim()), strs[5].trim(),
                            strs[6].trim(), strs[7].trim(), strs[8].trim());

                    System.out.println(instruction.getSource() + " publishes below instruction: ");
                    System.out.println(header);
                    System.out.println(input);

                    RDProcessor processor = ProcessorFactory.getProcessor(InstructType.valueOf(instruction.getSource()));
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
