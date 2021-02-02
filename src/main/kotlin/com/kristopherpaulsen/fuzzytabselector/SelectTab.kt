package com.kristopherpaulsen.fuzzytabselector;
import com.intellij.openapi.actionSystem.*
import com.intellij.openapi.ui.popup.JBPopupFactory
import com.intellij.openapi.fileEditor.ex.FileEditorManagerEx
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.vfs.VirtualFile
import java.nio.file.Paths


class SelectTab : AnAction() {
    override fun actionPerformed(event: AnActionEvent) {
        val project = event.getRequiredData(CommonDataKeys.PROJECT)
        val dataContext = event.dataContext
        val actionGroup = DefaultActionGroup("YES", true)
        val editorManager = FileEditorManagerEx.getInstanceEx(project);

        editorManager.windows.forEach { window -> window.files.forEach { file ->
            actionGroup.add(MenuItem(
                name = { this.fileNameWithDirectory(file) },
                icon = file.fileType.icon!!,
                file = file,
                window = window,
            ))
        }}

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

    private fun fileNameWithDirectory(file : VirtualFile) : String {
        return Regex("[^/]*/[^/]*$").find(file.canonicalPath.toString())!!.value
    }
}