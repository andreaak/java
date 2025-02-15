package com.java._01_ElementsJava._10_Documentations;

import java.lang.annotation.Documented;

public class Main {
    // Аннотация @Documented - документирует в JavaDoc
    @Documented
    @interface ClassPreamble {
        String author();

        String date();

        int currentRevision() default 1;

        String lastModified() default "N/A";

        String lastModifiedBy() default "N/A";

        String[] reviewers();
    }

    // Тело аннотации содержит описание элементов аннотации
    @ClassPreamble(
            author = "Yevhenii",
            date = "24/06/2018",
            currentRevision = 5,
            lastModified = "24/06/2018",
            lastModifiedBy = "Yevhenii Tykhonov",
            reviewers = {"Yevhenii", "Alex", "Bob"}
    )
    public static void main(String[] args) {
    }
}