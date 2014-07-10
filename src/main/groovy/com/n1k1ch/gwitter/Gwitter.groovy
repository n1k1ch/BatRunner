package com.n1k1ch.gwitter

import groovy.swing.SwingBuilder

import javax.swing.JFrame
import java.awt.BorderLayout

/**
 * Created by Nikita on 10.07.2014.
 */
class Gwitter {
    def searchField
    def resultsList

    static void main(String[] args) {
        def gwitter = new Gwitter()

        gwitter.show()
    }

    void show(){
        def swingBuilder = new SwingBuilder()

        def customMenuBar = {
            swingBuilder.menuBar{
                menu(
                        text: "File",
                        mnemonic: 'F'
                ) {
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
                    constraints: BorderLayout.NORTH
            ){
                searchField = textField(columns: 15)
                button(text: "Search", actionPerformed: {/* TODO */})
            }
        }

        def resultsPanel = {
            swingBuilder.scrollPane(
                    constraints:BorderLayout.CENTER
            ) {
                resultsList = list()
            }
        }

        swingBuilder.frame(
                title: 'Gwitter',
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
