package com.github.itsbp.jetbrainstextutils.actions;

import java.util.Locale;

public class ConvertToUppercaseAction extends BaseReplaceTextAction {

    @Override
    public String transformSelectedText(String selectedText) {
        return selectedText.toUpperCase(Locale.ROOT);
    }
}
