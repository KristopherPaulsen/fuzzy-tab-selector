package com.kristopherpaulsen.fuzzytabselector;

import com.intellij.openapi.ListSelection
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.popup.JBPopupFactory
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.fileEditor.ex.FileEditorManagerEx
import com.intellij.openapi.fileEditor.impl.EditorWindow
import com.intellij.openapi.fileEditor.impl.FileEditorManagerImpl
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.actionSystem.DefaultActionGroup
import com.intellij.openapi.actionSystem.ActionManager
import com.intellij.ui.components.JBList
import javax.swing.ListSelectionModel
import com.intellij.openapi.actionSystem.PlatformDataKeys





class GoToTab(val title: String) : AnAction() {
    override fun actionPerformed(event: AnActionEvent) {
        println("WHAT");
    }
}

class TextBoxes : AnAction("Text _Boxes") {
    override fun actionPerformed(event: AnActionEvent) {
        println("WHAT!!!!!!!!!!!!!!!!!!!");
    }
}


class SelectTab : AnAction() {
    override fun update(e: AnActionEvent) {
        // Using the event, evaluate the context, and enable or disable the action.
    }

    override fun actionPerformed(event: AnActionEvent) {
        val project = event.getRequiredData(CommonDataKeys.PROJECT)
        val dataContext = event.dataContext

        val actionGroup = DefaultActionGroup("YES", true)

        actionGroup.add(TextBoxes());

        JBPopupFactory
            .getInstance()
            .createActionGroupPopup(
                "things",
                actionGroup,
                dataContext,
                JBPopupFactory.ActionSelectionAid.SPEEDSEARCH,
                false,
            ).showCenteredInCurrentWindow(project)
    }
}

//class SelectTab : AnAction() {
//    override fun update(e: AnActionEvent) {
//        // Using the event, evaluate the context, and enable or disable the action.
//    }
//
//    override fun actionPerformed(event: AnActionEvent) {
//        val project = event.getRequiredData(CommonDataKeys.PROJECT)
//        val dataContext = event.dataContext
//        val activeWindowPane: EditorWindow? = EditorWindow.DATA_KEY.getData(event.dataContext)
//        val fileEditorManagerEx = FileEditorManagerEx.getInstanceEx(project)
//        val fileEditorManagerImpl = fileEditorManagerEx as FileEditorManagerImpl
//        val activeEditorTab = activeWindowPane!!.selectedEditor
//        val activeFile = activeEditorTab!!.file
//        val files: Array<VirtualFile> = activeWindowPane.files
//
//        val actionNames = ActionManager.getInstance().getActionIdList("");
//
//        val actionGroup = DefaultActionGroup("YES", true)
//
//        actionNames.forEach { actionName ->
//            println(actionName)
//        };
//
//        JBPopupFactory.getInstance()
//            .createActionGroupPopup(
//                "foo",
//                actionGroup,
//                dataContext,
//                JBPopupFactory.ActionSelectionAid.SPEEDSEARCH,
//                false,
//                null,
//                100,
//            )
//            .showCenteredInCurrentWindow(project)
//
//        //activeWindowPane!!.closeFile(activeFile, true, false)
//        //fileEditorManagerImpl.openFileInNewWindow(activeFile)
//    }
//
//    private fun goToTab(dataContext: DataContext, project: Project) {
//        val editorManager = FileEditorManagerEx.getInstanceEx(project)
//        var currentWindow = EditorWindow.DATA_KEY.getData(dataContext)
//        if (currentWindow == null) {
//            currentWindow = editorManager.currentWindow
//        }
//        val files = currentWindow!!.files
//        val fileIndex = if (index == -1) files.size - 1 else index
//        if (fileIndex >= 0 && fileIndex < files.size) {
//            editorManager.openFile(files[fileIndex], true)
//        }
//    }
//}
