package com.yourame;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PersonServiceTest {

    @Test
        public void testFilterByAddress() {
                List<Person> peopleLivingIn789StreetX = PersonService.filterByAddress("789 Street X");
                // Liste attendue des personnes vivant à "789 Street X"
                List<Person> expectedPersonsLivingIn789StreetX = Arrays.asList(
                                Person.builder().firstName("John").familyName("Doe")
                                                .birthDate(LocalDate.of(1990, 5, 12))
                                                .address("789 Street X").build(),
                                Person.builder().firstName("Jim").familyName("Brown")
                                                .birthDate(LocalDate.of(1985, 3, 9))
                                                .address("789 Street X").build());

                // Vérification avec AssertJ
                assertThat(peopleLivingIn789StreetX).containsExactlyInAnyOrderElementsOf(expectedPersonsLivingIn789StreetX);
        }

        @Test
        public void testFilterAdults() {
                List<Person> adults = PersonService.filterAdults();

                // Liste attendue des adultes (18 ans ou plus)
                List<Person> expectedAdultPersons = Arrays.asList(
                                Person.builder().firstName("John").familyName("Doe")
                                                .birthDate(LocalDate.of(1990, 5, 12))
                                                .address("789 Street X").build(),
                                Person.builder().firstName("Jane").familyName("Smith")
                                                .birthDate(LocalDate.of(2005, 10, 15))
                                                .address("101 Street Y").build(),
                                Person.builder().firstName("Jim").familyName("Brown")
                                                .birthDate(LocalDate.of(1985, 3, 9))
                                                .address("789 Street X").build());

                // Vérification avec AssertJ
                assertThat(adults).containsExactlyInAnyOrderElementsOf(expectedAdultPersons);
        }

        @Test
        public void testSortPerson() {
                List<Person> people = new ArrayList<>();
                people.add(Person.builder().firstName("Hamid").familyName("Jamila").build());
                people.add(Person.builder().firstName("Martin").familyName("Bob").build());
                people.add(Person.builder().firstName("Hamid").familyName("Charles").build());
                people.add(Person.builder().firstName("Bernard").familyName("Charles").build());

                // Tri de la liste de personnes
                Collections.sort(people);

                assertThat(people.get(0))
                                .isEqualTo(Person.builder().firstName("Martin").familyName("Bob").build());
                assertThat(people.get(1))
                                .isEqualTo(Person.builder().firstName("Bernard").familyName("Charles").build());
                assertThat(people.get(2))
                                .isEqualTo(Person.builder().firstName("Hamid").familyName("Charles").build());
                assertThat(people.get(3))
                                .isEqualTo(Person.builder().firstName("Hamid").familyName("Jamila").build());

        }


         @Test
        public void testRemoveBobWithoutIterator() {
                assertThatThrownBy(() -> PersonService.removeBobWithoutIterator())
                                .isInstanceOf(ConcurrentModificationException.class);
        }

        @Test
        public void testRemoveBobUsingIterator() {
                Set<Person> people = new HashSet<>();
                people.add(Person.builder().firstName("Alice").familyName("Johnson").build());
                people.add(Person.builder().firstName("Charlie").familyName("Davis").build());

                Set<Person> peopleWithoutBob = PersonService.removeBobUsingIterator();

                assertThat(peopleWithoutBob).containsExactlyInAnyOrderElementsOf(people);
        }

}
