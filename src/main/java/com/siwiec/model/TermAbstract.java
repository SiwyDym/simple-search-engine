package com.siwiec.model;

import java.util.Objects;

/**
 * Created by emarsiw on 2018-02-22.
 */
public class TermAbstract{
    private final String name;

    TermAbstract(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Term) {
            Term term = (Term) o;
            return Objects.equals(name, term.getName());
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
