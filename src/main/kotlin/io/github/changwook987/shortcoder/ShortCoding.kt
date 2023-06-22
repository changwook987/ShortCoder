package io.github.changwook987.shortcoder

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.command.WriteCommandAction

class ShortCoding : AnAction() {
    override fun actionPerformed(event: AnActionEvent) {
        val project = event.project ?: return
        val psiFile = event.getData(CommonDataKeys.PSI_FILE) ?: return

        WriteCommandAction.writeCommandAction(project).run<RuntimeException> {
            try {

                ShortCoder.compress(psiFile)
            } catch (_: NotImplementedError) {
            }
        }
    }
}

