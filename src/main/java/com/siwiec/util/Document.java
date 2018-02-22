package com.siwiec.util;

import java.util.Objects;

/**
 * Created by emarsiw on 2018-02-21.
 */
public class Document{

    private final String content;

    public Document(String content) {
        this.content = content.toLowerCase(); //normalization: lowercased
    }

//    public List<Term> convertToTerms() {
////
//        List<Term> termList = new ArrayList<>();
//
//        String[] terms = get().split(" ");
//        for (String t : terms) {
//            termList.add(new Term(t));
//        }
//        return null;
//    }

    public String get() {
        return content;
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
