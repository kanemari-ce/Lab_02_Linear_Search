public class LibraryFinder {

    public static int findFirst(String[] titles, String target) {
        int comparisons = 0;
        if (titles == null || target == null) {
            return -1;
        }
        for (int i = 0; i < titles.length; i++) {
            comparisons++;
            System.out.println("Inspecting index " + i + ": " + titles[i]);
            if (titles[i].equalsIgnoreCase(target)) {
                System.out.println("Comparisons made: " + comparisons);
                return i;
            }
        }
        System.out.println("Comparisons made: " + comparisons);
        return -1;
    }

    public static int countMatches(String[] titles, String target) {
        int comparisons = 0;
        if (titles == null || target == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < titles.length; i++) {
            comparisons++;
            System.out.println("Inspecting index " + i + ": " + titles[i]);
            if (titles[i].equalsIgnoreCase(target)) {
                count++;
            }
        }
        System.out.println("Comparisons made: " + comparisons);
        return count;
    }

    public static void main(String[] args) {
        String[] titles = {"C", "Java", "DSA", "Java", "SQL"};

        System.out.println("=== findFirst(\"C\") - target at FIRST position ===");
        int first = findFirst(titles, "C");
        System.out.println(first != -1 ? "First match at index " + first : "Not found (-1)");

        System.out.println();
        System.out.println("=== findFirst(\"SQL\") - target at LAST position ===");
        int last = findFirst(titles, "SQL");
        System.out.println(last != -1 ? "First match at index " + last : "Not found (-1)");

        System.out.println();
        System.out.println("=== findFirst(\"Java\") - repeated title ===");
        int rep = findFirst(titles, "Java");
        System.out.println(rep != -1 ? "First match at index " + rep : "Not found (-1)");

        System.out.println();
        System.out.println("=== findFirst(\"Python\") - target MISSING ===");
        int missing = findFirst(titles, "Python");
        System.out.println(missing != -1 ? "First match at index " + missing : "Not found (-1)");

        System.out.println();
        System.out.println("=== countMatches(\"Java\") - repeated title ===");
        int count1 = countMatches(titles, "Java");
        System.out.println("Total matches: " + count1);

        System.out.println();
        System.out.println("=== countMatches(\"Python\") - target MISSING ===");
        int count2 = countMatches(titles, "Python");
        System.out.println("Total matches: " + count2);

        String[] adjacent = {"Java", "Java", "DSA", "SQL"};

        System.out.println();
        System.out.println("=== findFirst(\"Java\") - ADJACENT duplicates [Java, Java, DSA, SQL] ===");
        int adjFirst = findFirst(adjacent, "Java");
        System.out.println(adjFirst != -1 ? "First match at index " + adjFirst : "Not found (-1)");

        System.out.println();
        System.out.println("=== countMatches(\"Java\") - ADJACENT duplicates [Java, Java, DSA, SQL] ===");
        int adjCount = countMatches(adjacent, "Java");
        System.out.println("Total matches: " + adjCount);
    }
}
