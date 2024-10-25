package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InternTest {

    @Test
    void compareTo() {
        List<Intern> interns = new ArrayList<>();
        interns.add(new Intern("Daniil Starov", 41, Haircolour.BLACK));
        interns.add(new Intern("Madli Petuhhov", 34, Haircolour.BLONDE));
        interns.add(new Intern("Liis Usin", 33, Haircolour.BROWN));
        interns.add(new Intern("Anna Brita Ani", 23, Haircolour.BLONDE));
        interns.add(new Intern("Liis Schotter", 33, Haircolour.BLONDE));
        interns.add(new Intern("Mikk Sarv", 37, Haircolour.BROWN));

        interns.sort(Intern.byName().thenComparing(Intern.byHaircolour().thenComparing(Intern.byAge())));
        System.out.println(interns);

    }
}