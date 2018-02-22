package com.siwiec.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by emarsiw on 2018-02-21.
 */
public class Term extends TermAbstract{

    private double globalWeight; // weight per all collection documents
    private double localWeight;  // weight in document
    private Integer nrOfOccurence = 0;

    public Term(String name, Integer sizeOfAllTerms) {
        super(name);
        reSumLocalWeight(sizeOfAllTerms);
    }

    public double getLocalWeight() {
        return BigDecimal.valueOf(localWeight)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    void reSumLocalWeight(Integer sizeOfAllTerms) {
        nrOfOccurence++;
        this.localWeight = (double) nrOfOccurence / (double) sizeOfAllTerms;
    }

}
