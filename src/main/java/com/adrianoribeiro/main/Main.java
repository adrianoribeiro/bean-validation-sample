package com.adrianoribeiro.main;

import com.adrianoribeiro.domain.Person;

import javax.validation.*;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Person person = new Person();
        person.setFirstName("Apenas um teste de nome grande");

        Set<ConstraintViolation<Person>> validate = validator.validate(person);

        System.out.println(validate);
    }
}
