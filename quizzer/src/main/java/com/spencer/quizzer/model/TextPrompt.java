package com.spencer.quizzer.model;

import java.io.Serializable;

/**
 * Created by Pete on 6/9/2014.
 */
public class TextPrompt extends Prompt  implements Serializable {
    String text;


    public TextPrompt(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TextPrompt{" +
                "text='" + text + '\'' +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getPromptDisplayText() {
        return getText();
    }
}
