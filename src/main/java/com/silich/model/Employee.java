package com.silich.model;

import net.sf.oval.constraint.*;

import java.sql.Date;

public class Employee {
    private int id;

    @Email
    @NotEmpty
    @NotNull
    private String email;

    @NotNull
    @NotEmpty
    @Length(min = 3)
    private String firstName;

    @NotNull
    @NotEmpty
    @Length(min = 3)
    private String lastName;

    @NotEmpty
    @NotNull
    @NotNegative
    private int age;

    private Date createdOn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + id;
        result = prime * result +
                ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result +
                ((email == null) ? 0 : email.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Employee employee = (Employee) obj;
        return id == employee.id
                && (firstName.equals(employee.firstName)
                || (firstName != null && firstName.equals(employee.getFirstName()))) && (lastName.equals(employee.lastName)
                || (lastName != null && lastName.equals(employee.getLastName()) || (email != null && email.equals(employee.getEmail()))
        ));
    }
}
