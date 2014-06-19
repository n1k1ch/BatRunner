package com.n1k1ch.batRunner

import org.codehaus.groovy.runtime.DefaultGroovyMethods

/**
 * Created by Nikita on 19.06.2014.
 */

println("Hallo")

str = "hallo";

str.length().times {
    //println(it.intValue())
    println(str.substring(it.intValue(), str.length()))
}

def  z = 1


//println(z.metaClass.methods)
DefaultGroovyMethods dgm = new DefaultGroovyMethods();
println(dgm)
