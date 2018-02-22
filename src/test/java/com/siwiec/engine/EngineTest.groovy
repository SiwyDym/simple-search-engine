package com.siwiec.engine

import com.siwiec.model.Document
import spock.lang.Specification

/**
 * Created by emarsiw on 2018-02-22.
 */
class EngineTest extends Specification {

    def "check if sorting TF-IDF is working well "() {
        given:
        def searchValue = "fox"
        List<Document> documentList = new ArrayList<Document>()
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
}
