/*
 * Copyright 2010-present ApiDebugger
 */
package io.chengguo.api.debugger.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.chengguo.api.debugger.lang.psi.ApiTypes.*;
import io.chengguo.api.debugger.lang.psi.*;

public class ApiRequestTargetImpl extends ApiElementImpl implements ApiRequestTarget {

  public ApiRequestTargetImpl(ASTNode node) {
    super(node);
  }

  public <R> R accept(@NotNull ApiVisitor<R> visitor) {
    return visitor.visitRequestTarget(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ApiVisitor) accept((ApiVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ApiHost getHost() {
    return findNotNullChildByClass(ApiHost.class);
  }

  @Override
  @NotNull
  public ApiPathAbsolute getPathAbsolute() {
    return findNotNullChildByClass(ApiPathAbsolute.class);
  }

  @Override
  @Nullable
  public ApiPort getPort() {
    return findChildByClass(ApiPort.class);
  }

  @Override
  @NotNull
  public ApiScheme getScheme() {
    return findNotNullChildByClass(ApiScheme.class);
  }

}