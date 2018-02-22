package com.siwiec.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by emarsiw on 2018-02-21.
 */
public class Document{

    private static final Logger LOGGER = LogManager.getLogger(Document.class);

    private final String content;
    private List<Term> terms = new ArrayList<>();

    public Document(String content) {
        this.content = content.toLowerCase(); //normalization: lowercased
    }

    public List<Term> extractTerms() {
        LOGGER.debug("Extract terms... ");
        String[] stringTerms = get().split(" ");

        List<Term> termsWithDuplicates = new ArrayList<>();
        for (String t : stringTerms) {
            termsWithDuplicates.add(new Term(t, stringTerms.length));
        }

        return removeDuplicates(termsWithDuplicates);
    }

    private List<Term> removeDuplicates(List<Term> termsWithDuplicates) {
        termsWithDuplicates
                .forEach(term -> {
                    if (terms.contains(term)) {
                        terms.get(terms.indexOf(term)).reSumLocalWeight(termsWithDuplicates.size());
                    } else {
                        terms.add(term);
                    }
                });
        return terms;
    }

    public String get() {
        return content;
    }

    public double getWeightConcreteTerm(String term) {
        return terms.get(terms.indexOf(new Term(term, 1))).getLocalWeight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Document)) return false;
        Document document = (Document) o;
        return Objects.equals(content, document.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}
