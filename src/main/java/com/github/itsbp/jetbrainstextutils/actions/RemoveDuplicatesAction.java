package com.github.itsbp.jetbrainstextutils.actions;

import java.util.Arrays;

public class RemoveDuplicatesAction extends BaseReplaceTextAction{

    @Override
    public String transformSelectedText(String selectedText) {

        String[] selectedLines = selectedText.split("\n");
        return String.join("\n", Arrays.stream(selectedLines).distinct().toArray(String[]::new));
    }
}
