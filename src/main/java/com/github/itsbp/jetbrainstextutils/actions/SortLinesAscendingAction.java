package com.github.itsbp.jetbrainstextutils.actions;

import java.util.Arrays;

public class SortLinesAscendingAction extends BaseReplaceTextAction{

    @Override
    public String transformSelectedText(String selectedText) {
        String[] selectedLines = selectedText.split("\n");
        Arrays.sort(selectedLines);
        return String.join("\n", Arrays.asList(selectedLines));
    }
}
