package Task2;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Human> humans = List.of(
            new Human(4, "Who", "Me", LocalDate.parse("1982-01-05"), 1),
            new Human(25, "John", "Doe", LocalDate.parse("1996-05-15"), 70),
            new Human(30, "Jane", "Smith", LocalDate.parse("1992-08-20"), 65),
            new Human(35, "Alice", "Johnson", LocalDate.parse("1987-03-10"), 80),
            new Human(40, "Bob", "Brown", LocalDate.parse("1982-01-05"), 75),
            new Human(40, "Bob", "Brown", LocalDate.parse("2004-16-04"), 75)
        );

        // Output all humans
        System.out.println("All humans:");
        humans.forEach(System.out::println);

        // Sort by sum of weigth and age
        List<Human> sortedList = humans.stream()
                .sorted(Comparator.comparingInt(h -> h.age + h.weight))
                .collect(Collectors.toList());
        System.out.println("\nSorted list by sum of age and weight:");
        sortedList.forEach(System.out::println);

        // Filter by weigth % 5
        List<Human> filteredList = sortedList.stream()
                .filter(h -> h.weight % 5 == 0)
                .collect(Collectors.toList());
        System.out.println("\nFiltered list by weight divisible by 5:");
        filteredList.forEach(System.out::println);

        // First four elements
        List<Human> firstFour = filteredList.stream()
                .limit(4)
                .collect(Collectors.toList());
        System.out.println("\nFirst four elements:");
        firstFour.forEach(System.out::println);

        // Join all names by space
        String concatenatedNames = firstFour.stream()
                .map(h -> h.firstName)
                .collect(Collectors.joining(" "));
        System.out.println("\nConcatenated names: " + concatenatedNames);
    }
}

