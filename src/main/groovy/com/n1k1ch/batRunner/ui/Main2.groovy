package com.n1k1ch.batRunner.ui

import groovy.swing.SwingBuilder

import javax.swing.JFrame

/**
 * Created by Nikita on 10.07.2014.
 */

def swingBuilder = new SwingBuilder()
swingBuilder.frame(
        title: "Framik 2",
        defaultCloseOperation: JFrame.EXIT_ON_CLOSE,
        size: [800,500],
        show: true
)