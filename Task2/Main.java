package Task2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {        
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        List<Human> humans = List.of(
            new Human(4, "Who", "Me", LocalDate.parse("05-01-1982", f), 1),
            new Human(25, "Jone", "James", LocalDate.parse("15-05-1996", f), 70),
            new Human(40, "Michael", "Mirov", LocalDate.parse("16-04-2004", f), 11),
            new Human(30, "Kawasaki", "Amico", LocalDate.parse("20-08-1999", f), 34),
            new Human(35, "Cago", "Flaf", LocalDate.parse("10-03-2024", f), 35),
            new Human(40, "Crico", "Endur", LocalDate.parse("05-01-2012", f), 56)
        );

        // Output all humans
        System.out.println("All humans");
        humans.forEach(System.out::println);

        // Sorted by sum of weigth and age
        List<Human> sorted = humans.stream()
        .sorted(Comparator.comparingInt(h -> h.age + h.weight))
        .collect(Collectors.toList());
        
        System.out.println("\nSorted by sum of weigth and age");
        sorted.forEach(System.out::println);

        // Filter by weigth % 5
        List<Human> filtered = humans.stream()
        .filter(h -> h.weight % 5 == 0)
        .collect(Collectors.toList());
        
        System.out.println("\nFilter by weigth % 5");
        filtered.forEach(System.out::println);

        // First four elements
        List<Human> first4 = humans.stream()
        .limit(4)
        .collect(Collectors.toList());
        
        System.out.println("\nFirst four elements");
        first4.forEach(System.out::println);

        // Join all names by space
        String names = humans.stream()
        .map(h -> h.firstName)
        .collect(Collectors.joining(" "));

        System.out.println("\nNames: " + names);
    }
}
