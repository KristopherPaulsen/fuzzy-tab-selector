package com.kristopherpaulsen.fuzzytabselector;

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.fileEditor.ex.FileEditorManagerEx
import com.intellij.openapi.fileEditor.impl.EditorWindow
import com.intellij.openapi.vfs.VirtualFile
import java.util.function.Supplier
import javax.swing.Icon

class MenuItem(
    name: Supplier<String>,
    icon: Icon,
    private val file: VirtualFile,
    private val window: EditorWindow
) : AnAction(name, icon) {
    override fun actionPerformed(event: AnActionEvent) {
        val editorManager = FileEditorManagerEx.getInstanceEx(
            CommonDataKeys.PROJECT.getData(event.dataContext)!!
        )

        editorManager.openFileWithProviders(file, true, window)
    }

//    private fun getProject(event: AnActionEvent): Project? {
//        return PlatformDataKeys.PROJECT.getData(event.dataContext)
//    }
}