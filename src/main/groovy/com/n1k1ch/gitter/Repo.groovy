package com.n1k1ch.gitter

/**
 * Created by Nikita on 10.07.2014.
 */
class Repo {
    String id
    String name
    String pushedAt
    String login

    public String toString(){
        return "${name} (#${id}), last push: ${pushedAt}, login: ${login}"
    }
}
