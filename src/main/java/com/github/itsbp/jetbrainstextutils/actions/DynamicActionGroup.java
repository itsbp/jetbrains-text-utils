package com.github.itsbp.jetbrainstextutils.actions;

// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.


import com.intellij.openapi.actionSystem.ActionGroup;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import icons.SdkIcons;
import org.jetbrains.annotations.NotNull;

/**
 * Demonstrates adding an action group to a menu statically in plugin.xml, and then creating a menu item within
 * the group at runtime. See plugin.xml for the declaration of {@link DynamicActionGroup}, and note the group
 * declaration does not contain an action. {@link DynamicActionGroup} is based on {@link ActionGroup} because menu
 * children are determined on rules other than just positional constraints.
 *
 * @see ActionGroup
 */
public class DynamicActionGroup extends ActionGroup {

  /**
   * Returns an array of menu actions for the group.
   *
   * @param e Event received when the associated group-id menu is chosen.
   * @return AnAction[] An instance of {@link AnAction}, in this case containing a single instance of the
   * {@link TextUtilsAction} class.
   */
  @NotNull
  @Override
  public AnAction[] getChildren(AnActionEvent e) {
    return new AnAction[]{
            new TextUtilsAction(TextUtilsAction.ActionTextUpperCase, "Convert to Uppercase", SdkIcons.Sdk_default_icon),
            new TextUtilsAction(TextUtilsAction.ActionTextLowerCase, "Convert to Lowercase", SdkIcons.Sdk_default_icon),
            new TextUtilsAction(TextUtilsAction.ActionTextSortLinesAscending, TextUtilsAction.ActionTextSortLinesAscending, SdkIcons.Sdk_default_icon),
            new TextUtilsAction(TextUtilsAction.ActionTextSortLinesDescending, TextUtilsAction.ActionTextSortLinesDescending, SdkIcons.Sdk_default_icon),
            new TextUtilsAction(TextUtilsAction.ActionTextBase64Encode, "Base64 Encode", SdkIcons.Sdk_default_icon),
            new TextUtilsAction(TextUtilsAction.ActionTextBase64Decode, "Base64 Decode", SdkIcons.Sdk_default_icon),
            new TextUtilsAction(TextUtilsAction.ActionTextRemoveDuplicates, "Remove duplicate lines", SdkIcons.Sdk_default_icon),
    };
  }

}
