package bean.validation;

import jakarta.validation.Constraint;

import jakarta.validation.Payload;
import jakarta.validation.constraints.Size;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy={LoginValidator.class})
@Target({ElementType.METHOD, ElementType.FIELD,
        ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Login{
    String message() default "Login is not valid";
    Class<?>[] groups() default {}; // Groupe de validation partiel
    Class<? extends Payload>[] payload() default{}; // Metadonnée de la contrainte
}



