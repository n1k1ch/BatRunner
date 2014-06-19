package com.n1k1ch.batRunner.ui

import groovy.swing.SwingBuilder

import javax.swing.BoxLayout
import java.awt.BorderLayout

/**
 * Created by Nikita on 19.06.2014.
 */

count = 0
new SwingBuilder().edt {
    frame(title: 'MyFramik', size: [400, 250], show: true) {
        borderLayout()
        textLabel = label(text: 'Push the button', constraints: BorderLayout.NORTH)
        button(
                text: 'Na na',
                constraints: BorderLayout.CENTER,
                actionPerformed: {count--; textLabel.text = "Unclicked ${count} time(z)"}
        )
        button(text: 'Push me',
            actionPerformed: {count++; textLabel.text = "Clicked ${count} time(z)"; println("clicked")},
            constraints:BorderLayout.SOUTH
        )
    }
}