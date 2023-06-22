package io.github.changwook987.shortcoder

import com.intellij.psi.PsiFile
import io.github.changwook987.shortcoder.impl.KotlinShortCoder
import org.jetbrains.kotlin.idea.KotlinLanguage

interface ShortCoder {
    companion object {
        fun compress(file: PsiFile) {
            when (file.language) {
                is KotlinLanguage -> KotlinShortCoder()
                else -> TODO("sorry")
            }.process(file)
        }
    }

    fun process(file: PsiFile)
}