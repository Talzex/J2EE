package bean.validation;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LoginValidator implements ConstraintValidator<Login, String> {
    @Override
    public void initialize(final Login login){

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext){
        return (s.length() > 2 && s.length() < 8 && s.matches("^[a-zA-Z]+$"));
    }
}
