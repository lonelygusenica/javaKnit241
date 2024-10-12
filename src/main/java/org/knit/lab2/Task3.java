package org.knit.lab2;

import java.util.Scanner;

class Calculator {
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        return a / b;
    }
}

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            System.out.print("Введите первое число (или 'exit' для выхода): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Выход из программы.");
                break;
            }

            double num1 = getValidNumber(input, scanner);

            System.out.print("Введите оператор (+, -, *, /): ");
            String operator = scanner.nextLine();

            System.out.print("Введите второе число: ");
            double num2 = getValidNumber(scanner.nextLine(), scanner);

            if (operator.equals("/") && num2 == 0) {
                System.out.println("Ошибка: Деление на ноль невозможно.");
                continue;
            }

            double result = 0;
            boolean validOperation = true;

            switch (operator) {
                case "+":
                    result = calculator.add(num1, num2);
                    break;
                case "-":
                    result = calculator.subtract(num1, num2);
                    break;
                case "*":
                    result = calculator.multiply(num1, num2);
                    break;
                case "/":
                    result = calculator.divide(num1, num2);
                    break;
                default:
                    System.out.println("Ошибка: недопустимый оператор.");
                    validOperation = false;
            }

            if (validOperation) {
                System.out.println("Результат: " + result);
            }
        }
        scanner.close();
    }

    public static boolean isNumeric(String input) {
        return input.matches("-?\\d+(\\.\\d+)?");
    }

    public static double getValidNumber(String input, Scanner scanner) {
        while (!isNumeric(input)) {
            System.out.print("Ошибка: введите допустимое число: ");
            input = scanner.nextLine();
        }
        return Double.parseDouble(input);
    }
}
