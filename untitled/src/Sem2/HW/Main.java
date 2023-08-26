package Sem2.HW;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float enteredNumber = getFloatInput();
        System.out.println("Вы ввели: " + enteredNumber);
    }
    public static float getFloatInput() {
        Scanner scanner = new Scanner(System.in);
        float inputNumber = 0; // Значение по умолчанию

        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Введите дробное число: ");
                inputNumber = scanner.nextFloat();
                validInput = true; // Если ввод корректен, завершаем цикл
            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода! Пожалуйста, введите дробное число.");
                scanner.nextLine(); // Очищаем буфер после ошибочного ввода
            }
        }
        return inputNumber;
    }

}