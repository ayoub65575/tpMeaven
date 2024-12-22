package com.yourame;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonService {

    public static List<Person> filterByAddress(String address) {
        List<Person> mockPersonsDatabase = Arrays.asList(
                Person.builder().firstName("John").familyName("Doe").birthDate(LocalDate.of(1990, 5, 12))
                        .address("789 Street X").build(),
                Person.builder().firstName("Jane").familyName("Smith").birthDate(LocalDate.of(2005, 10, 15))
                        .address("101 Street Y").build(),
                Person.builder().firstName("Jim").familyName("Brown").birthDate(LocalDate.of(1985, 3, 9))
                        .address("789 Street X").build()
                    );

        Predicate<Person> hasAddress = person -> person.getAddress().equals(address);

        return mockPersonsDatabase.stream()
                .filter(hasAddress)
                .collect(Collectors.toList());
    }


}
