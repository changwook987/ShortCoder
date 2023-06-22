package io.github.changwook987.shortcoder.impl

import com.intellij.application.options.CodeStyle
import com.intellij.psi.PsiFile
import com.intellij.psi.codeStyle.CodeStyleManager
import io.github.changwook987.shortcoder.ShortCoder

class KotlinShortCoder : ShortCoder {
    override fun process(file: PsiFile) {
        val codeStyle = CodeStyle.getLanguageSettings(file)
        setZero(codeStyle)
        codeStyle.indentOptions?.let { setZero(it) }
        CodeStyleManager.getInstance(file.project).reformat(file)
    }

    private fun setZero(any: Any) {
        val clazz = any::class.java
        for (field in clazz.fields) {
            try {
                when (field.type) {
                    Boolean::class.javaPrimitiveType -> {
                        field.setBoolean(any, false)
                    }

                    Int::class.javaPrimitiveType -> {
                        field.setInt(any, 0)
                    }
                }
            } catch (_: Exception) {
            }
        }
    }
}
