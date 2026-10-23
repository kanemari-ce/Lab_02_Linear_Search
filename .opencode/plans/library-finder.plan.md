# Lab2 Plan: Linear Search in Real Applications — LibraryFinder (v2)

## Context
- Working dir: `C:\Users\Acer\Desktop\CpE211-Labs\Lab2` (repo; only README present)
- User spec: case-insensitive matching; `findFirst(String[], String)` + `countMatches(String[], String)`
- Print every inspected index; manual-trace test evidence must count every comparison
- User asked: plan to write on build-mode switch → YES, one file: `LibraryFinder.java`

## Implementation Steps
1. Create `LibraryFinder.java` (code below)
2. Verify: `javac LibraryFinder.java` then `java LibraryFinder` (workdir Lab2)
3. Compare program's "Comparisons made:" lines against manual trace counts (1/5/2/5/1/4)
4. No commit unless user requests

## File: LibraryFinder.java
```java
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
```

## Design Decisions
- `equalsIgnoreCase` (user choice, case-insensitive); null-safe guards
- Each search prints `Comparisons made: N` so program output doubles as test evidence for the manual trace
- `findFirst`: early return → best case O(1); `countMatches`: full scan → always Θ(n)
- Array A = user's exact array `[C, Java, DSA, Java, SQL]`; Array B adds adjacent duplicates `[Java, Java, DSA, SQL]`
- 8 searches cover all 4 required cases: first position, last position, missing, repeated incl. adjacent

## Expected Output vs Manual Trace
| Search | Trace comparisons | Trace result |
|---|---|---|
| findFirst("C") in A | 1 | index 0 |
| findFirst("SQL") in A | 5 (=n) | index 4 |
| findFirst("Java") in A | 2 | index 1 (dup at 3 never inspected) |
| findFirst("Python") in A | 5 (=n) | -1 |
| countMatches("Java") in A | 5 (=n) | 2 |
| countMatches("Python") in A | 5 (=n) | 0 |
| findFirst("Java") in B | 1 | index 0 |
| countMatches("Java") in B | 4 (=n) | 2 |
