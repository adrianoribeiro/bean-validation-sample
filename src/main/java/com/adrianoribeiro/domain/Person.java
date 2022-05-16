package com.adrianoribeiro.domain;

import com.adrianoribeiro.validator.FieldSize;

import java.time.LocalDate;

public class Person implements Comparable<Person>{
    private Long id;
    @FieldSize(10)
    private String firstName;
    @FieldSize(10)
    private String lastName;
    private LocalDate dateOfBirth;

    public Person() {}

    public Person(Long id, String firstName, String lastName, LocalDate dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public int compareTo(Person otherPerson) {
        return this.getFirstName().compareTo(otherPerson.getFirstName());
    }
}
