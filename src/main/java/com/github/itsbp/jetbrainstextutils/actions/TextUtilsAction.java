package com.github.itsbp.jetbrainstextutils.actions;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.pom.Navigatable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.Locale;


public class TextUtilsAction extends AnAction {
    protected static final String ActionTextUpperCase = "Convert to Uppercase";
    protected static final String ActionTextLowerCase = "Convert to Lowercase";
    protected static final String ActionTextBase64Encode = "Base64 Encode";
    protected static final String ActionTextBase64Decode = "Base64 Decode";
    protected static final String ActionTextSortLinesAscending = "Sort Lines in Ascending order";
    protected static final String ActionTextSortLinesDescending = "Sort Lines in Descending order";
    protected static final String ActionTextRemoveDuplicates = "Remove Duplicates";

    public TextUtilsAction() {
        super();
    }

    public TextUtilsAction(@Nullable String text, @Nullable String description, @Nullable Icon icon) {
        super(text, description, icon);
    }

    /**
     * Implement this method to provide your action handler.
     *
     * @param event Carries information on the invocation place
     */
    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        // Using the event, create and show a dialog
        final Editor editor = event.getRequiredData(CommonDataKeys.EDITOR);
        final Project project = event.getRequiredData(CommonDataKeys.PROJECT);
        final Document document = editor.getDocument();
        // Work off of the primary caret to get the selection info
        Caret primaryCaret = editor.getCaretModel().getPrimaryCaret();
        int start = primaryCaret.getSelectionStart();
        int end = primaryCaret.getSelectionEnd();
        String selectedText = editor.getSelectionModel().getSelectedText();

        String replacementText = null;
        String[] selectedLines;
        switch (event.getPresentation().getText()) {
            case ActionTextLowerCase:
                replacementText = selectedText.toLowerCase(Locale.ROOT);
                break;
            case ActionTextUpperCase:
                replacementText = selectedText.toUpperCase(Locale.ROOT);
                break;
            case ActionTextSortLinesAscending:
                selectedLines = selectedText.split("\n");
                Arrays.sort(selectedLines);
                replacementText = String.join("\n", Arrays.asList(selectedLines));
                break;
            case ActionTextSortLinesDescending:
                selectedLines = selectedText.split("\n");
                Arrays.sort(selectedLines, Collections.reverseOrder());
                replacementText = String.join("\n", Arrays.asList(selectedLines));
                break;
            case ActionTextRemoveDuplicates:
                selectedLines = selectedText.split("\n");
                replacementText = String.join("\n", Arrays.stream(selectedLines).distinct().toArray(String[]::new));
                break;
            case ActionTextBase64Encode:
                replacementText = Base64.getEncoder().encodeToString(selectedText.getBytes());
                break;
           case ActionTextBase64Decode:
                replacementText = new String(Base64.getDecoder().decode(selectedText));
                break;
        }

        // Replace the selection with a fixed string.
        // Must do this document change in a write action context.
        String finalReplacementText = replacementText;
        WriteCommandAction.runWriteCommandAction(project, () ->
                document.replaceString(start, end, finalReplacementText)
        );

        // De-select the text range that was just replaced
        primaryCaret.removeSelection();
    }

    public void update(AnActionEvent e) {
        Presentation presentation = e.getPresentation();
        // Get required data keys
        final Project project = e.getProject();
        final Editor editor = e.getData(CommonDataKeys.EDITOR);
        // Set visibility only in case of existing project and editor and if a selection exists
        e.getPresentation().setEnabledAndVisible(project != null
                && editor != null
                && editor.getSelectionModel().hasSelection());
        if (e.getPlace().equals(ActionPlaces.MAIN_MENU)) {
            presentation.setText("BP:My Menu item name");
        } else if (e.getPlace().equals(ActionPlaces.MAIN_TOOLBAR)) {
            presentation.setText("BP:My Toolbar item name");
        }
    }
}