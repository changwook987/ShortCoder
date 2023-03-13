package io.github.changwook987.shortcoder

import com.intellij.codeInsight.actions.*
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.LangDataKeys

class ShortCoding : AnAction() {

    override fun actionPerformed(event: AnActionEvent) {
        val project = event.project ?: error("project is null")
        val file = event.getData(LangDataKeys.PSI_FILE)
        if (file != null) {
            var processor: AbstractLayoutCodeProcessor = ReformatCodeProcessor(project, file, null, false)
            processor = OptimizeImportsProcessor(processor)
            processor = RearrangeCodeProcessor(processor)
            processor = CodeCleanupCodeProcessor(processor)
            processor.run()

        }
    }

}
