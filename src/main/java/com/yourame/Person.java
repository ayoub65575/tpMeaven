
package com.yourame;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;



@Builder
@Data
public class Person implements Comparable < Person >{
    private String firstName;
    private String familyName;
    private LocalDate birthDate;
    private String address;

    public int calculateAge() {
        return LocalDate.now().getYear() - birthDate.getYear();
    }

    @Override
    public int compareTo(Person other) {
        int comparaisonLastName = this.familyName.compareTo(other.familyName);
        if (comparaisonLastName != 0) {
            return comparaisonLastName;
        } else {
            return this.firstName.compareTo(other.firstName);
        }
    }

}
