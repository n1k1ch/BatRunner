package com.n1k1ch.batRunner.ui

import javax.swing.JLabel
import javax.swing.JTree
import javax.swing.filechooser.FileSystemView
import javax.swing.tree.DefaultMutableTreeNode
import javax.swing.tree.DefaultTreeCellRenderer
import java.awt.Color
import java.awt.Component

/**
 * Created by Nikita on 11.07.2014.
 */
class FileTreeCellRenderer extends DefaultTreeCellRenderer {

    def fileSystemView = FileSystemView.getFileSystemView()

    public Component getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus) {
        def label = super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus)

        def node = value
        def file = node.getUserObject()
        label.icon = fileSystemView.getSystemIcon(file)
        label.text = "HERAKS" + file.name
        label.toolTipText=file.path

        println(node)

        selected ? {
            label.background = new Color(230, 230, 255)
            label.foreground = new Color(0,0,0)
        } : {
            label.background = new Color(255, 255, 255)
            label.foreground = new Color(0,0,0)

        }

        label
    }
}
