package com.siwiec.model

import spock.lang.Specification

/**
 * Created by emarsiw on 2018-02-22.
 */
class DocumentTest extends Specification {

    def "if create document is normalize - lowercased"() {
        given:
        Document document

        when:
        document = new Document("Potatoe")

        then:
        document.get() == "potatoe"
    }

    def "ExtractTerms - method not return duplicates"() {

        Document document = new Document(content)
        expect:
        def terms = document.extractTerms()
        size == terms.size()
        where:
        size | content
        5    | "Potatoe eat fox when was potatoe"
        1    | "Potatoe Potatoe Potatoe potatoe"
    }

    def "ExtractTerms - check if localWeight was correct computed if terms amount is even"() {
        given:
        Document document = new Document("the Brown fox jumped over the brown dog brown kartofel")
        when:
        def terms = document.extractTerms()
        then:
        terms.get(0).getName() == "the"
        terms.get(0).getLocalWeight() == 0.2d
        terms.get(1).getName() == "brown"
        terms.get(1).getLocalWeight() == 0.3d

    }

    def "ExtractTerms - check if localWeight was correct computed if terms amount is NOT even"() {
        given:
        Document document = new Document("the Brown fox")
        when:
        def terms = document.extractTerms()
        then:
        terms.get(0).getName() == "the"
        terms.get(0).getLocalWeight() == 0.33d
        terms.get(1).getName() == "brown"
        terms.get(1).getLocalWeight() == 0.33d

    }
}