package com.hsbc.models;

import lombok.AllArgsConstructor;
import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Component
public class Person {
    protected long personId;
    //autowiring @ field level
    @Autowired(required = false)
    @Qualifier("fullName1")
    protected FullName senderName;

    @Autowired(required = false)
    @Qualifier("fullName2")
    protected FullName receiverName;
   // @Autowired
    protected LocalDate dob;


}
