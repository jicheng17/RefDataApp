package com.jaycee.rda;

import java.util.HashMap;
import java.util.Map;

public class RDProcessor {
    public static Map<String, Instruction> mapLME = new HashMap<String, Instruction>();

    public void process(Instruction instruction) {
        if( instruction.getSource().equals("LME")) {
            mapLME.put(instruction.getInstId(), instruction);
        }

        publish(instruction);
    }

    /**
     * publish event based on incoming instruction and existing data
     *
     * @return
     */
    public void publish(Instruction instruction){
        System.out.println(instruction.getSource() + ":");
        System.out.println(merge(instruction));
    }

    /**
     * merge based on pre-defined rules
     *
     * @param instruction
     * @return
     */
    public Instruction merge(Instruction instruction){
        Instruction instructionExt = mapLME.get(instruction.getInstId());

        RuleEngine ruleEngine = new PrimeRuleEngine();
        return (Instruction) ruleEngine.applyRule(instruction, instructionExt);
    }
}
