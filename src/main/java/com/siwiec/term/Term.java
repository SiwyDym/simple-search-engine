package com.siwiec.term;

import com.siwiec.util.Document;

import java.util.Objects;

/**
 * Created by emarsiw on 2018-02-21.
 */
public class Term{

    private final String name;
    private Integer globalWeight; // globalWeight per all collection documents
    private Integer localWeight; //globalWeight in document

    public Term(String name) {
        this.name = name;
    }

    public Integer getGlobalWeight() {
        return globalWeight;
    }

    public void setGlobalWeight(Integer globalWeight) {
        this.globalWeight = globalWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Term) {
            Term term = (Term) o;
            return Objects.equals(name, term.name);
        } else if (o instanceof String) {
            return Objects.equals(name, o);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
