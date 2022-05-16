package com.adrianoribeiro.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldSizeValidator implements ConstraintValidator<FieldSize, String> {

    private Integer value;

    @Override
    public void initialize(FieldSize constraintAnnotation) {
        this.value = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String text, ConstraintValidatorContext constraintContext) {

        boolean isValid = (text != null && text.getBytes().length < value);

        if(!isValid) {
            constraintContext.disableDefaultConstraintViolation();
            constraintContext.buildConstraintViolationWithTemplate(
                    String.format("This field has more than %s characters.", value)).addConstraintViolation();
        }

        return isValid;
    }
}
