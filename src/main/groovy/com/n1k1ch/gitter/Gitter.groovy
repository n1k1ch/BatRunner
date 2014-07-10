package com.n1k1ch.gitter

import com.n1k1ch.gitter.ui.BlackCellRenderer
import groovy.swing.SwingBuilder

import javax.swing.JFrame
import java.awt.BorderLayout

/**
 * Created by Nikita on 10.07.2014.
 */
class Gitter {

    def searchField
    def resultsList

    static void main(String[] args){
        def gitter = new Gitter()
        gitter.show()
    }

    void show(){
        def swingBuilder = new SwingBuilder()

        def customMenuBar = {
            swingBuilder.menuBar{
                menu(
                        text: "File",
                        mnemonic: 'F'
                ){
                    menuItem(
                            text: "Exit",
                            mnemonic: 'X',
                            actionPerformed: {
                                dispose()
                            }
                    )
                }
            }
        }

        def searchPanel = {
            swingBuilder.panel(
                    constraints:BorderLayout.NORTH
            ){
                searchField = textField(
                        columns: 15,
                        text: "n1k1ch"
                )
                button(
                        text: "Search",
                        actionPerformed: {
                            doOutside {
                                resultsList.listData = Search.byUser(searchField.text)
                            }
                        }
                )
            }
        }

        def resultsPanel = {
            swingBuilder.scrollPane(
                    constraints:BorderLayout.CENTER
            ){
                resultsList = list(
                        fixedCellWidth: 500,
                        fixedCellHeight: 50,
                        cellRenderer: new BlackCellRenderer()
                )
            }
        }


        swingBuilder.frame(
                title: "Gitter",
                defaultCloseOperation: JFrame.EXIT_ON_CLOSE,
                size: [800,500],
                show: true
        ) {
            customMenuBar()
            searchPanel()
            resultsPanel()
        }
    }
}
