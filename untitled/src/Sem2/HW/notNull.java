package Sem2.HW;

/**
 * Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
 * Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
 */

import java.util.Scanner;

public class notNull {
    public static void main(String[] args) {
        try {
            String userInput = getStringInput();
            if (userInput.isEmpty()) {
                throw new IllegalArgumentException("Пустые строки вводить нельзя.");
            }
            System.out.println("Вы ввели: " + userInput);
        } catch (IllegalArgumentException ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }
    }

    public static String getStringInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        return scanner.nextLine();
    }
}
