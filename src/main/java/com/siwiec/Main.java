package com.siwiec;

import com.siwiec.engine.Engine;
import com.siwiec.exception.SearchTermNotFoundException;
import com.siwiec.model.Document;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Scanner;

/**
 * Created by emarsiw on 2018-02-21.
 */
public class Main{

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("Start Simple Search App.");

        Engine.initEngine();
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("If you want search some word please input: search");
        LOGGER.info("If you want exit please type any other key");
        while (scanner.next().equals("search")) {

            LOGGER.info("Please write word to search: ");
            String searchValue = scanner.next();
            List<Document> founded = null;
            try {
                founded = Engine.search(searchValue);
                founded.forEach(document -> LOGGER.info("Found document: " + document.get() + "|| weight: " + document.getWeightConcreteTerm(searchValue)));
            } catch (SearchTermNotFoundException e) {
                LOGGER.info(e.getMessage());
            }
        }

    }
}
