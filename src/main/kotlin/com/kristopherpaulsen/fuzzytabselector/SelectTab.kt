package com.kristopherpaulsen.fuzzytabselector;
import com.intellij.openapi.actionSystem.*
import com.intellij.openapi.ui.popup.JBPopupFactory
import com.intellij.openapi.fileEditor.ex.FileEditorManagerEx
import com.intellij.openapi.actionSystem.PlatformDataKeys

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.Project


class SelectTab : AnAction() {
    override fun actionPerformed(event: AnActionEvent) {
        val project = event.getRequiredData(CommonDataKeys.PROJECT)
        val dataContext = event.dataContext
        val actionGroup = DefaultActionGroup("YES", true)
        val editorManager = FileEditorManagerEx.getInstanceEx(project);
        val files = editorManager.windows.flatMap { window ->
            window.files.asList()
        }

        files!!.forEach { file ->
            actionGroup.add(MenuItem(file.name, file));
        }

        JBPopupFactory
            .getInstance()
            .createActionGroupPopup(
                "Select Tab",
                actionGroup,
                dataContext,
                JBPopupFactory.ActionSelectionAid.SPEEDSEARCH,
                false,
            ).showCenteredInCurrentWindow(project)
    }
}