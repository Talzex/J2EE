package bean.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateValidator implements ConstraintValidator<Dates, java.util.Date> {

    @Override
    public void initialize(final Dates dates){

    }

    @Override
    public boolean isValid(java.util.Date d, ConstraintValidatorContext constraintValidatorContext){
        if (d == null) return true;
        return d.toString().matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$");
    }
}
