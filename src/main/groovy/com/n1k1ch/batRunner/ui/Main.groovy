package com.n1k1ch.batRunner.ui

import groovy.swing.SwingBuilder

import javax.swing.BoxLayout
import java.awt.BorderLayout

/**
 * Created by Nikita on 19.06.2014.
 */

count = 0
new SwingBuilder().edt {
    frame(title: 'MyFramik', size: [700, 500], show: true) {
        borderLayout(
                hgap: 5
        )
        textLabel = label(text: 'Push the button',
                constraints: BorderLayout.WEST)
        button(
                text: 'Center',
                constraints: BorderLayout.CENTER,
                actionPerformed: {count--; textLabel.text = "Unclicked ${count} time(z)"}
        )
        button(
                text: 'Right',
                actionPerformed: {count++; textLabel.text = "Clicked ${count} time(z)"; println("clicked")},
                constraints:BorderLayout.EAST
        )
        textLabel = label(
                text: 'Opa, eshe text',
                constraints:BorderLayout.EAST
        )
    }
}