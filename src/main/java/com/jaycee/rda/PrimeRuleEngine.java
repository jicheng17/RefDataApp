package com.jaycee.rda;

public class PrimeRuleEngine implements RuleEngine<Instruction> {

    @Override
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
