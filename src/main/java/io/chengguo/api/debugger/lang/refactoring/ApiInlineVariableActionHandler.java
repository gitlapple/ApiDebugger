package io.chengguo.api.debugger.lang.refactoring;

import com.intellij.lang.Language;
import com.intellij.lang.refactoring.InlineActionHandler;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import io.chengguo.api.debugger.lang.ApiLanguage;
import io.chengguo.api.debugger.lang.psi.ApiNamedElement;

@Deprecated
public class ApiInlineVariableActionHandler extends InlineActionHandler {
    @Override
    public boolean isEnabledForLanguage(Language language) {
        return language == ApiLanguage.INSTANCE;
    }

    @Override
    public boolean canInlineElement(PsiElement element) {
        return element instanceof ApiNamedElement;
    }

    @Override
    public void inlineElement(Project project, Editor editor, PsiElement element) {
        System.out.println("project = " + project + ", editor = " + editor + ", element = " + element);
    }
}