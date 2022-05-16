package com.adrianoribeiro.validator;

import com.adrianoribeiro.domain.Person;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class PersonTest {

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void shouldNotCreatePersonIfFirstNameIsBiggerThan10() {
        Person person = new Person(1L, "Adrianoooooooooo", "Ribeiro", LocalDate.of(1990, 7, 29));

        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        assertEquals(1, constraintViolations.size());
        assertEquals("This field has more than 10 characters.", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void shouldNotCreatePersonIfLastNameIsBiggerThan10() {
        Person person = new Person(1L, "Adriano", "Ribeiro Ribeiro", LocalDate.of(1990, 7, 29));

        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        assertEquals(1, constraintViolations.size());
        assertEquals("This field has more than 10 characters.", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void shouldCreatePerson() {
        Person person = new Person(1L, "Adriano", "Ribeiro", LocalDate.of(1990, 7, 29));

        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        assertEquals(0, constraintViolations.size());
    }
}
