package Sem3.HW;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ФИО и номер через пробел: ");
        String userData = scanner.nextLine();
        try {
            processUserData(userData);
            System.out.println("Данные успешно обработаны и записаны в файл.");
        } catch (UserDataFormatException | IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    public static void processUserData(String userData) throws UserDataFormatException, IOException {
        String[] dataElements = userData.split(" ");
        if (dataElements.length != 4) {
            throw new UserDataFormatException("Введено неверное кол-во данных");
        }
        String lastName = dataElements[0];
        String firstName = dataElements[1];
        String middleName = dataElements[2];
        String phoneNumber = dataElements[3];

        if (!phoneNumber.matches("\\d+")) {
            throw new UserDataFormatException("Номер телефона должен быть целым числом");
        }
        String fileName = lastName + ".txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

        try {
            writer.write(lastName + " " + firstName + " " + middleName + " " + phoneNumber);
            writer.newLine();
        } finally {
            writer.close();
        }
    }
}

class UserDataFormatException extends Exception {
    public UserDataFormatException(String message) {
        super(message);
    }
}





