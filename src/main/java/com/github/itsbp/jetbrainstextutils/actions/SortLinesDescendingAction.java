package com.github.itsbp.jetbrainstextutils.actions;

import java.util.Arrays;
import java.util.Collections;

public class SortLinesDescendingAction extends BaseReplaceTextAction{

    @Override
    public String transformSelectedText(String selectedText) {
        String[] selectedLines = selectedText.split("\n");
        Arrays.sort(selectedLines, Collections.reverseOrder());
        return String.join("\n", Arrays.asList(selectedLines));
    }
}
