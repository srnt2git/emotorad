package com.emotorad.service.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber,String> {
    private static final String PHONE_NUMBER_REGEX = "^[0-9]{10}$";
    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {

        if (phoneNumber == null) {
            return false;
        }

        return Pattern.matches(PHONE_NUMBER_REGEX, phoneNumber);
    }
}
