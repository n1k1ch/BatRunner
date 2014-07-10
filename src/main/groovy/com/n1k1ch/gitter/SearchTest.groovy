package com.n1k1ch.gitter

/**
 * Created by Nikita on 10.07.2014.
 */
class SearchTest extends GroovyTestCase{
    void testSearchByUser(){
        def results = Search.byUser("n1k1ch");
        results.each {
            assertEquals("n1k1ch", it.login)
        }

    }
}
