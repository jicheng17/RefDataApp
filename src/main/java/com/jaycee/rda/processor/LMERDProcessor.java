package com.jaycee.rda.processor;

import com.jaycee.rda.domain.Instruction;
import com.jaycee.rda.rules.PRIMERuleEngine;
import com.jaycee.rda.rules.RuleEngine;

public class LMERDProcessor extends RDProcessor {
    @Override
    public void process(Instruction instruction) {
        mapLME.put(instruction.getInstId(), instruction);
        publish(instruction);
    }
}
