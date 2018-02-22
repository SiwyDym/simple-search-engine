package com.siwiec.model

import spock.lang.Specification

/**
 * Created by emarsiw on 2018-02-22.
 */
class TermTest extends Specification {

    def "when create new Term - localWeight was computed "() {
        given:
        Term term = new Term("ziemniak", 5)
        when:
        double weight = term.getLocalWeight()
        then:
        weight == 0.2

    }
}
