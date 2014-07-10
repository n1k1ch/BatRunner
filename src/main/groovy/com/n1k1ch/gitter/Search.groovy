package com.n1k1ch.gitter

import groovy.json.JsonSlurper

/**
 * Created by Nikita on 10.07.2014.
 */
class Search {
    static final address = "https://api.github.com/users/PLACEHOLDER/repos"

    static Object[] byUser(String query){
        def results = []
        def url = new URL(address.replaceFirst("PLACEHOLDER", query))
        def repos = new JsonSlurper().parse(url)

        repos.each {
            def repo = new Repo()
            repo.id = it.id
            repo.name = it.name
            repo.pushedAt = it.pushed_at
            repo.login = it.owner.login
            results << repo
        }

        return results
    }
}
