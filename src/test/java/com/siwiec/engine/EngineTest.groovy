package com.siwiec.engine

import com.siwiec.exception.SearchTermNotFoundException
import com.siwiec.model.Document
import spock.lang.Specification

/**
 * Created by emarsiw on 2018-02-22.
 */
class EngineTest extends Specification {

    List<Document> documentList = new ArrayList<Document>()

    def "check if sorting TF-IDF is working well "() {
        given:
        def searchValue = "fox"
        documentList.add(new Document("fox is fox when is fox"))
        documentList.add(new Document("fox is fox when is know body"))
        documentList.add(new Document("fox is fox"))
        documentList.add(new Document("fox"))
        for (Document doc : documentList) {
            doc.extractTerms()
        }
        when:
        Engine.sortedByTFIDF(documentList, searchValue)
        then:
        documentList.get(0).get() == "fox"
        documentList.get(1).get() == "fox is fox"
        documentList.get(2).get() == "fox is fox when is fox"
        documentList.get(3).get() == "fox is fox when is know body"
    }

    def "Situation when search text not exist in repository"() {

        given:
        documentList = new ArrayList<Document>()
        def searchValue = "fox"

        when:
        Engine.search(searchValue)
        then:
        thrown(SearchTermNotFoundException)

    }
}
