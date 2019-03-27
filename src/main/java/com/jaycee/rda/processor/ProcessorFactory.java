package com.jaycee.rda.processor;

import com.jaycee.rda.domain.InstructType;

public class ProcessorFactory {
    public static RDProcessor getProcessor(InstructType instructType){
        if( instructType.equals(InstructType.LME)){
            return new LMERDProcessor();
        }else{
            return new PRIMERDProcessor();
        }
    }
}
