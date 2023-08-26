package Sem1;

import java.util.Random;
import java.util.Scanner;

public class Task1 {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();


    public static void main(String[] args) {
        //System.out.printf("Длина массива\n", task(new int[]{1,2,3,4,5,6}));
        //task2();
        //task3();
        task4();
    }

    /**
     * Реализуйте метод, принимающий в качестве аргумента целочисленный массив.
     * Если длина массива меньше некоторого заданного минимума, метод возвращает
     * -1, в качестве кода ошибки, иначе - длину массива.
     */
    static int task(int [] arr){
        if (arr.length == 0){
            return -1;
        }
        return arr.length;
    }

    /**
     * Реализуйте метод, принимающий в качестве аргумента целочисленный массив и некоторое значение.
     * Метод ищет в массиве заданное значение и возвращает его индекс. При этом, например:
     * 1. если длина массива меньше некоторого заданного минимума, метод возвращает -1, в качестве кода ошибки.
     * 2. если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
     * 3. если вместо массива пришел null, метод вернет -3
     *
     * Напишите метод, в котором реализуйте взаимодействие с пользователем.
     * То есть, этот метод запросит искомое число у пользователя, вызовет первый,
     * обработает возвращенное значение и покажет читаемый результат пользователю.
     * Например, если вернулся -2, пользователю выведется сообщение: “Искомый элемент не найден”.
     */
    static void task2(){
        while (true){
            System.out.println("Укажите число для поиска: ");
            if (scanner.hasNextInt()){
                int searchNumber = scanner.nextInt();
                int[] array = new int[random.nextInt(5) + 1];
                if (random.nextInt(2) == 0){
                    array = null;
                    System.out.println("Null");
                }
                if(array != null){
                    for (int i = 0; i < array.length; i++) {
                        array[i] = random.nextInt(10);
                        System.out.printf("%d\t", array[i]);
                    }
                    System.out.println();
                }

                int codeResult = processArray(array, searchNumber);
                if (codeResult == -1){
                    System.out.println("Длина массива менее трех элементов");
                }
                else if (codeResult == -2) {
                    System.out.println("Элемент не найден");

                }
                else if (codeResult == -3) {
                    System.out.println("Массив некорректно проинициализирован");
                }
                else {
                    System.out.println("Массив успешно обработан");
                    System.out.printf("Элемент найден по индексу: %d\n", codeResult);
                }

            }
            else {
                System.out.println("Число для поиска указано некорректно\n Повторите ввод:");
                scanner.nextLine();
            }

        }
    }
    static int processArray(int [] arr, int searchNumber){
        if(arr == null){
            return -3;
        }
        if (arr.length < 3){
            return -1;
        }
        int searchRes = -2;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == searchNumber){
                searchRes = i;
            }
        }
        return searchRes;
    }
    /**
     * Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
     * Необходимо посчитать и вернуть сумму элементов этого массива.
     * При этом накладываем на метод 2 ограничения: метод может работать только с квадратными массивами
     * (кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать только значение 0 или 1.
     * Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об ошибке.
     */

    static void task3(){
        for (int i = 0; i < 5; i++) {
            System.out.printf("\n *** Итерация % d ***\n\n", i+1);
            processArray( generateArray());
        }

    }
    static void processArray(int [][] arr){
        for (int i = 0; i < arr.length; i++) {
            if(arr[0].length != arr.length){
                throw new RuntimeException("Некорректная размерность массива");
            }
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] != 0 && arr[i][j] != 1){
                    throw new RuntimeException(String.format("Некорректное значение массива по индексу [%d][%d]", i, j));
                }
                else {
                    sum += arr[i][j];
                }
            }

        }
        System.out.printf("Сумма элементов: %d", sum);

    }
    //Метод генерации двумерного массива
    static int [][] generateArray(){
        int[][] arr = new int[random.nextInt(2)+4][4];
        for (int i = 0; i <arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = random.nextInt(2);
                if(random.nextInt(50)==0){
                    arr[i][j] = 2;//намеренная ошибка
                }
                System.out.printf("%d\t", arr[i][j]);
            }
            System.out.println();
        }
        return arr;
    }

    /**
     *
     */
    static void task4(){
        for (int i = 0; i < 5; i++) {
            System.out.printf("\n*** Итерация % d ***\n\n", i+1);
            int errCode = processArrayV2(generateArray());
            if (errCode == -1){
                System.out.println(" Некорректная размерность массива");
            }
            else if (errCode == -2){
                System.out.println(" Некорретное значение массива");
            }
            else{
                System.out.printf("Сумма элементов массива %d\n", errCode);
            }
        }
    }

    static int processArrayV2(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != arr.length){
                return -1;
            }
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0 && arr[i][j] != 1){
                    return -2;
                }
                else{
                    sum += arr[i][j];
                }
            }
        }
        return sum;
    }
}
