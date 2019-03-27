package com.jaycee.rda.processor;

import com.jaycee.rda.domain.Instruction;
import com.jaycee.rda.rules.PRIMERuleEngine;
import com.jaycee.rda.rules.RuleEngine;

import java.util.HashMap;
import java.util.Map;

public abstract class RDProcessor {
    public static Map<String, Instruction> mapLME = new HashMap<String, Instruction>();
    public static Map<String, Instruction> mapPRIME = new HashMap<String, Instruction>();


    public abstract void process(Instruction instruction);

    /**
     * publish event based on incoming instruction and existing data
     *
     * @return
     */
    public void publish(Instruction instruction){
        System.out.println("RefDataApp publish below instruction internally: ");
        System.out.println(merge(instruction));
        System.out.println("============================================================================================================================================= ");

    }

    /**
     * merge based on pre-defined rules
     *
     * @param instruction
     * @return
     */
    public Instruction merge(Instruction instruction){
        return instruction;
    }
}
