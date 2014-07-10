package com.n1k1ch.gitter.ui

import javax.swing.DefaultListCellRenderer
import javax.swing.JList
import java.awt.Color
import java.awt.Component

/**
 * Created by Nikita on 10.07.2014.
 */
class BlackCellRenderer extends DefaultListCellRenderer{

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        def cell = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus)

        if(index%2 == 0) {
            cell.background = new Color(230, 230, 255)
        }
        cell
    }
}
