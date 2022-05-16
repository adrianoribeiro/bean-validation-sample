package com.adrianoribeiro.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckCaseValidator implements ConstraintValidator<CheckCase, String> {

    private CaseMode caseMode;

    public void initialize(CheckCase constraintAnnotation) {
        this.caseMode = constraintAnnotation.value();
    }

    public boolean isValid(String text, ConstraintValidatorContext constraintContext) {
        if (text == null)
            return true;

        boolean isValid;
        if (caseMode == CaseMode.UPPER) {
            isValid = text.equals(text.toUpperCase());
        } else {
            isValid = text.equals(text.toLowerCase());
        }

        if (!isValid) {
            constraintContext.disableDefaultConstraintViolation();
            constraintContext.buildConstraintViolationWithTemplate("{com.adrianoribeiro.constraints.CheckCase.message}").addConstraintViolation();
        }
        return isValid;
    }
}