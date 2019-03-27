package com.jaycee.rda.processor;

import com.jaycee.rda.domain.Instruction;
import com.jaycee.rda.rules.PRIMERuleEngine;
import com.jaycee.rda.rules.RuleEngine;

public class PRIMERDProcessor extends RDProcessor {
    @Override
    public void process(Instruction instruction) {
        mapPRIME.put(instruction.getInstId(), instruction);
        publish(instruction);
    }

    /**
     * merge based on pre-defined rules
     *
     * @param instruction
     * @return
     */
    @Override
    public Instruction merge(Instruction instruction){

        Instruction instructionExt = mapLME.get(instruction.getInstId());

        RuleEngine ruleEngine = new PRIMERuleEngine();
        return (Instruction) ruleEngine.applyRule(instruction, instructionExt);
    }
}
