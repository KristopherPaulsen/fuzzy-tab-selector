package com.kristopherpaulsen.fuzzytabselector;

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import com.intellij.pom.Navigatable


class SelectTab : AnAction() {
    override fun update(e: AnActionEvent) {
        // Using the event, evaluate the context, and enable or disable the action.
    }

    override fun actionPerformed(event: AnActionEvent) {
        val currentProject: Project? = event.project
        val dlgMsg = StringBuffer(event.presentation.text + " Selected!")
        val dlgTitle = event.presentation.description
        // If an element is selected in the editor, add info about it.
        val nav: Navigatable? = event.getData(CommonDataKeys.NAVIGATABLE)
        if (nav != null) {
            dlgMsg.append(
                String.format(
                    "\nSelected Element: %s",
                    nav.toString()
                )
            )
        }
        Messages.showMessageDialog(
            currentProject,
            dlgMsg.toString(),
            dlgTitle,
            Messages.getInformationIcon()
        )
    }
}