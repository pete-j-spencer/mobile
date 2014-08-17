package com.spencer.quizzer.model;

import java.io.Serializable;

/**
 * Created by Pete on 6/9/2014.
 */
public abstract class Prompt  implements Serializable {
    public abstract String getPromptDisplayText();
}
