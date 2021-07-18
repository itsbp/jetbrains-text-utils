package com.github.itsbp.jetbrainstextutils.actions;

import java.util.Base64;

public class Base64DecodeAction extends BaseReplaceTextAction{

    @Override
    public String transformSelectedText(String selectedText) {
        return new String(Base64.getDecoder().decode(selectedText));
    }
}
