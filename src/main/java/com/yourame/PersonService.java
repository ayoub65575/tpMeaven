package com.yourame;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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

    public static List<Person> filterAdults() {
        List<Person> mockPersonsDatabase = Arrays.asList(
                Person.builder().firstName("John").familyName("Doe").birthDate(LocalDate.of(1990, 5, 12))
                        .address("789 Street X").build(),
                Person.builder().firstName("Jane").familyName("Smith").birthDate(LocalDate.of(2005, 10, 15))
                        .address("101 Street Y").build(),
                Person.builder().firstName("Jim").familyName("Brown").birthDate(LocalDate.of(1985, 3, 9))
                        .address("789 Street X").build());

        Predicate<Person> isAdult = person -> person.calculateAge() >= 18;

        return mockPersonsDatabase.stream()
                .filter(isAdult)
                .collect(Collectors.toList());
    }


    public static Set<Person> removeBobWithoutIterator() {
        Set<Person> people = new HashSet<>();
        people.add(Person.builder().firstName("Alice").familyName("Johnson").build());
        people.add(Person.builder().firstName("Bob").familyName("Martin").build());
        people.add(Person.builder().firstName("Charlie").familyName("Davis").build());

        for (Person person : people) {
            if (person.getFamilyName().equals("Martin")) {
                people.remove(person); // Erreur ici
            }
        }
        return people;
    }

    public static Set<Person> removeBobUsingIterator() {
        Set<Person> people = new HashSet<>();
        people.add(Person.builder().firstName("Alice").familyName("Johnson").build());
        people.add(Person.builder().firstName("Bob").familyName("Martin").build());
        people.add(Person.builder().firstName("Charlie").familyName("Davis").build());

        // Suppression avec iterator (sécurisé)
        Iterator<Person> iterator = people.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getFamilyName().equals("Martin")) {
                iterator.remove(); // Suppression sécurisée
            }
        }
        return people;
    }


}
