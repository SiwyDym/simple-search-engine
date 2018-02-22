package com.siwiec.engine;

import com.siwiec.repository.DocumentsRepository;
import com.siwiec.util.Document;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Created by emarsiw on 2018-02-21.
 */
public class Engine{

    private static final Logger LOGGER = LogManager.getLogger(Engine.class);


    public static void initEngine() {
        //create mocking documents
        DocumentsRepository.createStubRepository();
        //get documents from repository
    }

    //return list of documents sorted by TF-IDF
    public static List<Document> search(String searchValue) {
        return sortedByIDFT(DocumentsRepository.getIdfStructure().get(searchValue));
    }

    private static List<Document> sortedByIDFT(List<Document> documents) {


        return documents;//todo not implement
    }


}
