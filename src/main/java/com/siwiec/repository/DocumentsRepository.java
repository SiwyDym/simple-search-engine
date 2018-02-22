package com.siwiec.repository;

import com.siwiec.model.SearchTerm;
import com.siwiec.model.Term;
import com.siwiec.model.Document;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * Created by emarsiw on 2018-02-21.
 */
public class DocumentsRepository{

    private static final Logger LOGGER = LogManager.getLogger(DocumentsRepository.class);
    private static List<Document> documents = new ArrayList<>();
    //list of all unique words in whole repository sorted by term (IDfi)
    private static Map<SearchTerm, List<Document>> idfStructure = new HashMap<>();

    private static List<Term> tfiStructure = new ArrayList<>();

    private static Integer amountsDocuments = 0;

    public static List<Document> getDocuments() {
        return documents;
    }

    public static void createStubRepository() {
        LOGGER.debug("Create stub repository. ");
        addDocument(new Document("the Brown fox jumped over the brown dog"));
        addDocument(new Document("the lazy brown dog sat in the corner"));
        addDocument(new Document("the red fox bit the lazy dog"));
    }

    public static void addDocument(Document document) {
        LOGGER.debug("Add {} document.", document.get());
        documents.add(document);
        setIdfStructure(document);
    }

    //todo: normalization: delete not important words like: "of", "is" "the"
    //todo: normalization: delete "es", "s" on the end, eg. foxes -> fox, dogs -> dog
    //todo: normalization: synonyms
    //todo: normalization: characters filter,eg & -> and
    private static void setIdfStructure(Document document) {
        amountsDocuments++; //new document

        document.extractTerms()
                .forEach(term ->
                        {
                            SearchTerm searchTerm = new SearchTerm(term.getName());
                            if (idfStructure.containsKey(searchTerm)) {
                                if (!idfStructure.get(searchTerm).contains(document))  //avoid documents duplicates
                                    idfStructure.get(searchTerm).add(document);
                            } else {
                                List<Document> temp = new ArrayList<>();
                                temp.add(document);
                                idfStructure.put(searchTerm, temp);
                            }
                        }
                );
    }

    public static Map<SearchTerm, List<Document>> getIdfStructure() {
        return idfStructure;
    }
}
