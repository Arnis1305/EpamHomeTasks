package collections.optionaltask;

import java.io.File;
import java.util.*;

public class AdditionalUnit {
    public static void main(String[] args) {
        additionalUnit.getStackFromIntegerNumberAndBackToInteger();
        additionalUnit.sortPoemByStringLength();
        additionalUnit.getDirectoriesAndFilesOfFolder();
    }

    static AdditionalUnit additionalUnit = new AdditionalUnit();
    Scanner scanner = new Scanner(System.in);

    private void getStackFromIntegerNumberAndBackToInteger() {
        System.out.println("Please enter Integer number: ");
        Deque<Character> stack = new ArrayDeque<>();
        int numberIntegerForStack = scanner.nextInt();
        char [] digitsArrayForNumber = String.valueOf(numberIntegerForStack).toCharArray();
        for (char digits : digitsArrayForNumber) {
            stack.push(digits);
        }
        while (!stack.isEmpty()) {
            char numberFromStackTypeOfChar = stack.pop();
            int numberIntegerFromStack = Character.getNumericValue(numberFromStackTypeOfChar);
            System.out.print(numberIntegerFromStack);
        }
    }

    private void sortPoemByStringLength() {
        System.out.println("\n\nSorted poem: ");
        ArrayList<String> poem = new ArrayList<>();
        poem.add("I love the Earth");
        poem.add("And everything that lives.");
        poem.add("I love the plants");
        poem.add("And the beauty each one gives.");
        poem.add("I love the animals");
        poem.add("And the fishes at sea.");
        poem.add("For I am a part of Mother Earth");
        poem.add("And it is a part of me. ");
        poem.sort((o1, o2) -> o1.length() - o2.length());
        poem.forEach(System.out::println);
    }

    private void getDirectoriesAndFilesOfFolder() {
        ArrayList<String> directoriesAndFiles = new ArrayList<>();
        File directoryToScan = new File("D://");
        System.out.println("\nInside of " + directoryToScan);
        if (directoryToScan.isDirectory()) {
            for (File objectInDirectory : directoryToScan.listFiles()) {
                if (objectInDirectory.isDirectory()) {
                    directoriesAndFiles.add(objectInDirectory.getName() + " | folder");
                } else {
                    directoriesAndFiles.add(objectInDirectory.getName() + " | file");
                }
            }
        }
        directoriesAndFiles.forEach(System.out::println);
    }
}