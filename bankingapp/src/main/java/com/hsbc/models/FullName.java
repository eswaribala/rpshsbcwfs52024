package com.hsbc.models;

import lombok.*;

import java.util.regex.Pattern;


@AllArgsConstructor
@NoArgsConstructor
public class FullName {
    private String firstName;
    private String lastName;
    @Setter
    @Getter
    private String middleName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {

        String firstNameExpression="[a-zA-Z]+";
        Pattern pattern= Pattern.compile(firstNameExpression);
        if(pattern.matcher(firstName.trim()).matches()) {
            this.firstName = firstName.trim();
        }else {
            throw new RuntimeException("Invalid First Name");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
