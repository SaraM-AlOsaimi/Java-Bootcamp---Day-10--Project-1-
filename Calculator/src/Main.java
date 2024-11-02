import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

/* Create Calculator in Java that’s used to calculate addition, subtraction, multiplication, division, modulus, min, max, average of numbers.
Display a menu to the user that’s contains the following options:
Enter 1 to addition the numbers
Enter 2 to subtraction the numbers
Enter 3 to multiplication the numbers
Enter 4 to division the numbers
Enter 5 to modulus the numbers
Enter 6 to find minimum number
Enter 7 to find maximum number
Enter 8 to find the average of numbers
Enter 9 to print the last result in calculator
Enter 10 to print the list of all results in calculator
The program must accept two numbers and operation from the user
Provide option to exit calculator program, if user wants to exit use methods*/

        Scanner input = new Scanner(System.in);
        ArrayList<Double> results = new ArrayList<>();
        double lastResult = 0;
        boolean exit = false;

        System.out.println("Welcome to the calculator +-*/");
        System.out.println("--------------------------");

        try {
            System.out.println("Enter first number ");
            double firstNum = input.nextDouble();

            System.out.println("Enter Second number ");
            double secNum = input.nextDouble();

            System.out.println("Choose an option from the menu or 0 to exit:");
            System.out.println("Enter 1 to add the numbers");
            System.out.println("Enter 2 to subtract the numbers");
            System.out.println("Enter 3 to multiply the numbers");
            System.out.println("Enter 4 to divide the numbers");
            System.out.println("Enter 5 to modulus the numbers");
            System.out.println("Enter 6 to find the minimum number");
            System.out.println("Enter 7 to find the maximum number");
            System.out.println("Enter 8 to find the average of numbers");
            System.out.println("Enter 9 to print the last result");
            System.out.println("Enter 10 to print the list of all results");
            System.out.println("Enter 0 to exit");

            while (!exit) {

                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        lastResult = addition(firstNum, secNum);
                        System.out.println("Result: " + lastResult);
                        results.add(lastResult);
                        break;
                    case 2:
                        lastResult = subtraction(firstNum, secNum);
                        System.out.println("Result: " + lastResult);
                        break;
                    case 3:
                        lastResult = multiplication(firstNum, secNum);
                        System.out.println("Result: " + lastResult);
                        break;
                    case 4:
                        if (secNum != 0) {
                            lastResult = division(firstNum, secNum);
                            System.out.println("Result: " + lastResult);
                            results.add(lastResult);
                        } else {
                            System.out.println("Error: Division by zero is not allowed.");
                        }
                    case 5:
                        lastResult = modulus(firstNum, secNum);
                        System.out.println("Result: " + lastResult);
                        break;
                    case 6:
                        lastResult = minimum(firstNum, secNum);
                        System.out.println("Minimum: " + lastResult);
                        break;
                    case 7:
                        lastResult = maximum(firstNum, secNum);
                        System.out.println("Maximum: " + lastResult);
                        break;
                    case 8:
                        lastResult = average(firstNum, secNum);
                        System.out.println("Average: " + lastResult);
                        results.add(lastResult);
                        break;
                    case 9:
                        System.out.println("Last Result: " + lastResult);
                        break;
                    case 10:
                        System.out.println("All results:");
                        for (double result : results) {
                            System.out.println(result);
                        }
                        break;
                    case 0:
                        exit = true;
                        System.out.println("Exiting calculator. Goodbye!");
                        break;
                    default:
                        System.out.println("Please choose a valid option from the menu.");
                }
            }
        } catch (Exception e){
            System.out.println("Exception has occurred :( " + e.getMessage());
        }
    }
    public static double addition(double firstNum , double secNum){
        return firstNum + secNum;
    }
    public static double subtraction(double firstNum , double secNum){
        return firstNum - secNum;
    }
    public static double multiplication(double firstNum ,double secNum){
        return firstNum * secNum;
    }
    public static double division(double firstNum , double secNum){
       return firstNum/secNum;
    }
    public static double modulus(double firstNum , double secNum){
      return firstNum % secNum;
    }
    public static double minimum(double firstNum , double secNum){
        return Math.min(firstNum,secNum);
    }
    public static double maximum(double firstNum , double secNum){
        return Math.max(firstNum,secNum);
    }
    public static double average(double firstNum ,double secNum){
        return (firstNum + secNum) / 2;
    }

}