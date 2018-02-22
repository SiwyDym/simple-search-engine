package com.siwiec.model;

import java.util.Objects;

/**
 * Created by emarsiw on 2018-02-21.
 */
public class Term extends TermAbstract{

    private Integer globalWeight; // weight per all collection documents
    private Integer localWeight;  // weight in document
    private Integer nrOfOccurence = 0;

    public Term(String name) {
        super(name);
    }

    public Integer getGlobalWeight() {
        return globalWeight;
    }

    public void setGlobalWeight(Integer globalWeight) {
        this.globalWeight = globalWeight;
    }

    public Integer getLocalWeight() {
        return localWeight;
    }

    void reSumLocalWeight(Integer sizeOfAllTerms) {
        nrOfOccurence++;
        this.localWeight = nrOfOccurence / sizeOfAllTerms;
    }

}
