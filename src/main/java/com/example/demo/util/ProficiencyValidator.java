package com.example.demo.util;

import java.util.Arrays;
import java.util.List;

public class ProficiencyValidator {

    private static final List<String> ALLOWED =
            Arrays.asList("Beginner", "Intermediate", "Advanced", "Expert");

    public static boolean isValid(String proficiency) {
        return ALLOWED.contains(proficiency);
    }
}
