package bean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class AppTest {

    private  static Validator validator;
    private Set<ConstraintViolation<Person>> violations;

    @BeforeAll
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        AppTest PersonConstraintTest;
        PersonConstraintTest.validator = factory.getValidator();
    }

    @Test
    public void testNOk() {
        Person p2 = new Person();
        p2.setFirstName("21");
        p2.setLastName("a");
        p2.setEmail("21");
        p2.setLogin(null);
        violations = validator.validate(p2);
        assertEquals(4, violations.size());
    }


}
