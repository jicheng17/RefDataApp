package com.jaycee.rda.rules;

import com.jaycee.rda.domain.Instruction;

public class PRIMERuleEngine implements RuleEngine<Instruction> {

    public Instruction applyRule(Instruction instruction, Instruction instructionExt) {

        if(instructionExt != null ){
            if( instruction.getSource().equals("PRIME")) {
                if (instructionExt.getSource().equals("LME")) {
                    instruction.setDeliveryDate(instructionExt.getDeliveryDate());
                    instruction.setLastTradingDate(instructionExt.getLastTradingDate());
                    instruction.setMarket("PB");
                }
            }
        }
        return instruction;
    }
}
