package com.jaycee.rda;


import com.jaycee.rda.domain.Instruction;
import com.jaycee.rda.processor.LMERDProcessor;
import com.jaycee.rda.processor.PRIMERDProcessor;
import com.jaycee.rda.processor.RDProcessor;
import com.jaycee.rda.util.Util;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LMERDProcessorTest {
    private static Instruction instruction = null;
    private static Instruction instruction2 = null;

    @Test
    public void lmeRDprocessorTest() {
        RDProcessor lmerdProcessor = new LMERDProcessor();
        lmerdProcessor.process(instruction);

        assertTrue(instruction.getMarket().equals("LME_PB"));
        assertTrue("".equals(instruction.getTradable()));
    }

    @Test
    public void primeRDprocessorMergeTest() {
        RDProcessor.mapPRIME.clear();
        RDProcessor.mapPRIME.put(instruction.getInstId(), instruction);

        RDProcessor primerdProcessor = new PRIMERDProcessor();
        primerdProcessor.process(instruction2);

        assertTrue(!Boolean.valueOf(instruction2.getTradable()));
        assertTrue((instruction2.getMarket()).equals("PB"));
    }

    @Before
    public void beforeTest() {
        String input = "|LME   |  PB_03_2018 |  15-03-2018                    | 17-03-2018    |  LME_PB                 | Lead 13 March 2018     |               |        |";
        String[] strs = input.split("\\|");

        instruction = new Instruction(strs[1].trim(), strs[2].trim(), Util.toDate(strs[3].trim()), Util.toDate(strs[4].trim()),
                strs[5].trim(), strs[6].trim(), strs[7].trim(), strs[8].trim());

        input = "|PRIME |  PB_03_2018 |  14-03-2018                    | 18-03-2018    |  LME_PB                 | Lead 13 March 2018     | PB_03_2018    | FALSE  |";
        strs = input.split("\\|");

        instruction2 = new Instruction(strs[1].trim(), strs[2].trim(), Util.toDate(strs[3].trim()), Util.toDate(strs[4].trim()),
                strs[5].trim(), strs[6].trim(), strs[7].trim(), strs[8].trim());
    }
}
