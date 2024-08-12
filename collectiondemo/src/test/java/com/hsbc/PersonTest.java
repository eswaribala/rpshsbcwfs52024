package com.hsbc;

import com.hsbc.dal.PersonDAL;
import com.hsbc.dal.PersonImpl;
import com.hsbc.models.Person;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    //person object null or not
    private static Person person;
    private static PersonDAL personDAL;

    @BeforeAll
    public static void createInstance() throws IOException {

        person=new Person();
        personDAL=new PersonImpl("store","person.csv");
    }

    @BeforeEach
    public void initializeInstance(){
          person.setName("Parameswari");
          person.setDob(LocalDate.of(1970,12,2));

    }

    @Test
    @DisplayName("Check Person Object Null Not")
    @Order(1)
    @Tag("dev")
    public void personNotNull(){
        assertNotNull(person);

    }

    @Test
    public void isDOBBeforeCurrentDate(){
        assertTrue(person.getDob().isBefore(LocalDate.now()));
    }

    @ParameterizedTest
    @ValueSource(strings={"Parameswari","Eswari","Jhansi","Roopa"})
    public void isPersonNameEqualToGivenValue(String name){
           assertEquals(name,person.getName());
    }

    @ParameterizedTest
    @CsvFileSource(files ="Person.csv", numLinesToSkip = 1)
    public void isNameLengthAbove5AndIsDOBBeforeCurrentDate(String name,
                                                            String dob){
        person=new Person(name,LocalDate.parse(dob));
        assertAll(
                ()->assertTrue(person.getName().length()>5),
                ()->assertFalse(person.getDob().isAfter(LocalDate.now()))
        );

    }


    @Test
    @DisplayName("Testing Person List Size Equal to 100")
    public void isPersonListEqualToExpectedSize() throws IOException {
        assertThat(personDAL.getPersons(),hasSize(100));
    }


    @AfterEach
    public void resetInstanceValues(){

    }

    @AfterAll
    public static void removeInstance(){
          person=null;


    }




}
