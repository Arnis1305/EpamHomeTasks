package fundamentals;

import java.util.Random;
import java.util.Scanner;

public class MainAndOptionalTasks {
    public static void main(String[] args) {
        callMenuForJavaFundamentals();
    }

    static Scanner scanner = new Scanner(System.in);

    private static void callMenuForJavaFundamentals() {
        System.out.println("\n1) Welcome Function. " + "\n2) Mirror arguments function." + "\n3) Random numbers function. "
                + "\n4) Calculation function. " + "\n5) Calendar function." + "\n6) Optional Task 1." + "\n7) Exit. " + "\n");
        System.out.println("Please enter the number of the task: ");
        int valueFromUser = scanner.nextInt();
        switch (valueFromUser) {
            case 1:
                callWelcomeFunction();
                callMenuForJavaFundamentals();
                break;
            case 2:
                callMirrorArgumentsFunction();
                callMenuForJavaFundamentals();
                break;
            case 3:
                callRandomNumbersFunction();
                callMenuForJavaFundamentals();
                break;
            case 4:
                callCalculationFunction();
                callMenuForJavaFundamentals();
                break;
            case 5:
                callCalendarFunction();
                callMenuForJavaFundamentals();
                break;
            case 6:
                callTheFirstOptionalTask();
                callMenuForJavaFundamentals();
                break;
            case 7:
                break;
            default:
                System.out.println("Please enter the number from array! ");
                callMenuForJavaFundamentals();
        }
    }

    private static void callWelcomeFunction() {
        System.out.println("Please enter your name: ");
        String userName = scanner.next();
        System.out.println("Welcome " + userName + "!");
    }

    private static void callMirrorArgumentsFunction() {
        System.out.println("Please enter array length: ");
        int arraySize = scanner.nextInt();
        int arrayOfIntegerValues[] = new int[arraySize];
        System.out.println("Please enter integer values of the array: ");
        for (int i = 0; i < arraySize; i++) {
            arrayOfIntegerValues[i] = scanner.nextInt();
        }
        System.out.println("Your reversed array: ");
        for (int i = arraySize-1; i > -1 ; i--) {
            System.out.println(arrayOfIntegerValues[i] + "; ");
        }
    }

    private static void callRandomNumbersFunction() {
        System.out.println("Please enter array length: ");
        int arraySize = scanner.nextInt();
        Random randomNumbers = new Random();
        int arrayOfRandomValues[] = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            arrayOfRandomValues[i] = randomNumbers.nextInt();
            System.out.println(arrayOfRandomValues[i] + " ");
        }
        System.out.println("Without println: ");
        for (int i = 0; i < arraySize; i++) {
            System.out.print(arrayOfRandomValues[i] + " ");
        }
    }

    private static void callCalculationFunction() {
        System.out.println("Please enter first integer number: ");
        int firstNumber = scanner.nextInt();
        System.out.println("Please enter second integer number: ");
        int secondNumber = scanner.nextInt();
        int resultOfAddition = firstNumber + secondNumber;
        System.out.println("Result of addition: " + resultOfAddition);
        int resultOfMultiplication = firstNumber * secondNumber;
        System.out.println("Result of Multiplication: " + resultOfMultiplication);
    }

    private static void callCalendarFunction() {
        String monthes[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        System.out.println("Please enter integer value between 1 and 12: ");
        boolean inputError = true;
        while (inputError) {
            if (scanner.hasNextInt()) {
                int monthOfTheYear = scanner.nextInt();
                if (monthOfTheYear > 0 && monthOfTheYear < 13 ) {
                    System.out.println("Your month: " + monthes[monthOfTheYear - 1]);
                } else {
                    System.out.println("Please enter correct values! "); }
            } else {
                scanner.next();
                System.out.println("Please enter correct values! ");
                continue;
            }
            inputError = false;
        }
    }

    private static void callTheFirstOptionalTask(){
        System.out.println("Please enter array length: ");
        int arraySize = scanner.nextInt();
        int arrayOfIntegerValues[] = new int[arraySize];
        System.out.println("Please enter integer values of the array: ");
        for (int i = 0; i < arraySize; i++) {
            arrayOfIntegerValues[i] = scanner.nextInt();
        }
        int minimumNumber = arrayOfIntegerValues[0];
        int maximumNumber = arrayOfIntegerValues[0];
        for (int i = 0; i < arraySize; i++) {
            if (minimumNumber > arrayOfIntegerValues[i]) {
                minimumNumber = arrayOfIntegerValues[i];
            }
            if (maximumNumber < arrayOfIntegerValues[i]) {
                maximumNumber = arrayOfIntegerValues[i];
            }
        }
        int minimumNumberLength = String.valueOf(minimumNumber).length();
        int maximumNumberLength = String.valueOf(maximumNumber).length();
        System.out.println("Minimum number: " + minimumNumber + ". Length of the number: " + minimumNumberLength);
        System.out.println("Maximum number: " + maximumNumber + ". Length of the number: " + maximumNumberLength);
        System.out.println("Sorted array Min -> Max: ");
        bubbleSort(arrayOfIntegerValues);
        for (int i = 0; i < arraySize; i++) {
            System.out.print(arrayOfIntegerValues[i] + " ");
        }
        System.out.println();
        System.out.println("Your reversed array Max -> Min: ");
        for (int i = arraySize-1; i > -1 ; i--) {
            System.out.print(arrayOfIntegerValues[i] + " ");
        }
        System.out.println();
    }

    private static void bubbleSort(int[] arrayOfIntegerValues) {
        for (int i = arrayOfIntegerValues.length-1 ; i > 0 ; i--) {
            for (int j = 0 ; j < i ; j++) {
                if (arrayOfIntegerValues[j] > arrayOfIntegerValues[j+1]) {
                    int tmp = arrayOfIntegerValues[j];
                    arrayOfIntegerValues[j] = arrayOfIntegerValues[j+1];
                    arrayOfIntegerValues[j+1] = tmp;
                }
            }
        }
    }
}