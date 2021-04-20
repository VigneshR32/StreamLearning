package com.assignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class FirstName {

    public static void main(String[] args) {
        try {
            List<String> firstName = Files.readAllLines(Paths.get("./Firstname.txt"));
            System.out.println(firstName.stream()
                    .filter(s->s.startsWith("B"))
                    .count());

            List<String > listStartsC = firstName.stream()
                    .filter(s->s.startsWith("C") && s.contains("s"))
                    .collect(Collectors.toList());
            System.out.println(listStartsC);
            System.out.println(
                    firstName.stream()
                    .filter(s->s.startsWith("M"))
                    .mapToInt(a->a.trim().length())
                    .sum()
            );
            firstName.stream()
                        .filter(e->e.contains("-"))
                        .map(e->e.replace("-"," "))
                        .forEach(System.out::println);
            System.out.println(firstName.stream()
                    .max(Comparator.comparing(s->s.length()))
                    .get());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
