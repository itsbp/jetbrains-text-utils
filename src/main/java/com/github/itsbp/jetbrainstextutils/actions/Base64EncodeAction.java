package com.github.itsbp.jetbrainstextutils.actions;

import java.util.Base64;

public class Base64EncodeAction extends BaseReplaceTextAction{

    @Override
    public String transformSelectedText(String selectedText) {
        return Base64.getEncoder().encodeToString(selectedText.getBytes());
    }
}
