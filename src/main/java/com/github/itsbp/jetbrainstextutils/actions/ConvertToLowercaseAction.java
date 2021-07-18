package com.github.itsbp.jetbrainstextutils.actions;

import java.util.Locale;

public class ConvertToLowercaseAction extends BaseReplaceTextAction{
    @Override
    public String transformSelectedText(String selectedText) {
        return selectedText.toLowerCase(Locale.ROOT);
    }
}
