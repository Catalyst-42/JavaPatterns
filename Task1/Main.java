package Task1;

import java.util.function.Consumer;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Consumer<String[]> maxUniqueChars = strings -> {
            String result = " ";
            
            int unique = 0;
            int maxUnique = 0;

            for (String string: strings) {
                Set<Character> uniqueChars = new HashSet<Character>();
                for(char c : string.toCharArray()) {
                    uniqueChars.add(c);
                }

                unique = uniqueChars.size();

                if (unique > maxUnique) {
                    maxUnique = unique;
                    result = string;
                }
            }

            System.out.println(result);
        };

        String[] strings = {"a", "bbb", "avt", "oooo"};
        maxUniqueChars.accept(strings);
    }
}
