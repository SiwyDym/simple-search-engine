package com.siwiec.engine;

import com.siwiec.exception.SearchTermNotFoundException;
import com.siwiec.model.Document;
import com.siwiec.model.SearchTerm;
import com.siwiec.repository.DocumentsRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by emarsiw on 2018-02-21.
 */
public class Engine{

    private static final Logger LOGGER = LogManager.getLogger(Engine.class);


    public static void initEngine() {
        //create mocking documents
        DocumentsRepository.createStubRepository();
    }

    //return list of documents sorted by TF-IDF
    public static List<Document> search(String searchValue) throws SearchTermNotFoundException {
        List<Document> documents = DocumentsRepository.getIdfStructure().get(new SearchTerm(searchValue));

        if (null == documents || documents.isEmpty()) {
            throw new SearchTermNotFoundException("No document with word: " + searchValue);
        }

        sortedByTFIDF(documents, searchValue);

        return documents;
    }

    private static void sortedByTFIDF(List<Document> documents, String searchValue) {
        documents.sort(Comparator.comparing((document -> document.getWeightConcreteTerm(searchValue))));
        Collections.reverse(documents);
    }


}
