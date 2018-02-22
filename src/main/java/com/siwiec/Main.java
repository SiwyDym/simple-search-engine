package com.siwiec;

import com.siwiec.engine.Engine;
import com.siwiec.util.Document;
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
        LOGGER.info("If you want search some word please input: s");
        LOGGER.info("If you want exit please type any other key");
        while (scanner.next().equals("s")) {

            LOGGER.info("Please write word to search : ");
            List<Document> founded = Engine.search(scanner.next());
            founded.forEach(document -> LOGGER.info("Document: " + document.get()));
        }

    }
}
