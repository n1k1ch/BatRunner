package com.n1k1ch.batRunner

import com.n1k1ch.batRunner.ui.FileTreeCellRenderer
import groovy.swing.SwingBuilder
import javafx.scene.control.SelectionMode

import javax.swing.JFrame
import javax.swing.JTree
import javax.swing.ListSelectionModel
import javax.swing.event.ListSelectionEvent
import javax.swing.event.ListSelectionListener
import javax.swing.event.TreeModelListener
import javax.swing.event.TreeSelectionEvent
import javax.swing.filechooser.FileSystemView
import javax.swing.tree.DefaultMutableTreeNode
import javax.swing.tree.DefaultTreeCellRenderer
import javax.swing.tree.DefaultTreeModel
import java.awt.BorderLayout
import java.awt.Cursor
import java.awt.GridLayout
import java.awt.Label
import java.awt.event.MouseEvent
import java.awt.event.MouseListener

/**
 * Created by Nikita on 11.07.2014.
 */
class BatRunner {

    def batListData = ["1", "2", "3"]

    def batList

    def treeModel

    def rootDirectory = "C:\\"

    def fileSystemView

    def currentDirectory


    static void main(String[] args) {
        def batRunner = new BatRunner()

        batRunner.show()
    }

    void show() {
        def builder = new SwingBuilder()

        def treePanel = {
            builder.panel(
                    layout: new BorderLayout(),
            ){
                button(
                        text: "Select folder",
                        actionPerformed: {
                            /*TODO: implement*/
                        },
                        constraints: BorderLayout.NORTH
                )
                scrollPane(
                        constraints: BorderLayout.CENTER
                ) {
                    def rootFile = new File(rootDirectory)
                    def root = new DefaultMutableTreeNode(rootFile)

                    fileSystemView = FileSystemView.fileSystemView

                    fileSystemView.getFiles(rootFile, true).each {
                        it.isDirectory() ? root.add(new DefaultMutableTreeNode(it)):{};
                    }

                    treeModel = new DefaultTreeModel(root)

                    def r = new DefaultTreeCellRenderer()
                    def cellRenderer = [
                            getTreeCellRendererComponent: {
                                JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row,boolean hasFocus ->
                                def lab = r.getTreeCellRendererComponent(tree, value.userObject.name, sel, expanded, leaf, row, hasFocus)
                                println(lab)
                                lab.icon = fileSystemView.getSystemIcon(value.userObject)
                                lab.cursor = new Cursor(Cursor.HAND_CURSOR)
                                lab
                            }
                    ] as DefaultTreeCellRenderer


                    DefaultTreeCellRenderer cellRenderer2 = new DefaultTreeCellRenderer()
                    cellRenderer2.leafIcon = cellRenderer.closedIcon
                    cellRenderer2.cursor = new Cursor(Cursor.HAND_CURSOR)

                    tree(
                        model: treeModel,
                        cellRenderer: cellRenderer2
                    ).addTreeSelectionListener({ TreeSelectionEvent tsl ->
                        currentDirectory = new File(tsl.newLeadSelectionPath.lastPathComponent.userObject.path)
                        println(currentDirectory)

                        batListData.clear()

                        fileSystemView.getFiles(currentDirectory, true).each{
                            println(it)
                            if(!it.isDirectory()) {
                                batListData << it
                            }
                        }
                        batList.listData=batListData
                    })
                }
            }
        }

        def batListPanel = {
            builder.panel(
            ){
                batList = list(
                        selectionMode: ListSelectionModel.SINGLE_SELECTION
                )

                batList.addListSelectionListener({ListSelectionEvent lse ->
                    println(lse)
                })
            }
        }

        def consoleOutputPanel = {
            builder.panel(
            ) {
                label(
                        text: "Results here"
                )
            }
        }


        builder.frame(
                title: "bat Runner",
                size: [800, 500],
                defaultCloseOperation: JFrame.EXIT_ON_CLOSE,
                show: true,
                layout: new GridLayout(
                        rows: 1,
                        columns: 3
                )
        ) {
            treePanel()
            batListPanel()
            consoleOutputPanel()
        }
    }
}
