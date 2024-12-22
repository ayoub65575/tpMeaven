package com.yourame;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

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

}
