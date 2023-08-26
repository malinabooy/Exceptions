package Sem2;
/**
 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
 При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
 Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
 должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
 3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и
 MyArrayDataException и вывести результат расчета.
 */
import java.util.Random;

public class Main {
        static Random random = new Random();

        public static void main(String[] args) {
            for (int i = 0; i < 10; i++) {
                System.out.println("Итерация " + (i+1) + "\n");
                processArrayExp();
            }
        }
        public static void processArrayExp(){
            try {
                System.out.printf("Сумма элементов массива: %d\n", processArray(generateArray()));
            }
            catch (MyArrayDataSizeExeption e){
                System.out.printf("%s\n Элемент под  индексом [%d][%d]\n", e.getMessage(), e.getX(),e.getY());
            }
            catch (MyArraySizeExeption e){
                System.out.printf("%s\n Требуется ввести массив 4х4, получили %d x %d\n", e.getMessage(), e.getX(), e.getY());
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
            finally {
                System.out.println("Завершение обработки --------\n");
            }
        }
        public static String[][] generateArray() {
            int add = random.nextInt(2);
            String[][] arr = new String[4 + add][4 + add];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (random.nextInt(25) == 1) {
                        arr[i][j] = "aaa";
                    }
                    else{
                        arr[i][j] = Integer.toString(random.nextInt(100));
                    }
                    System.out.printf("%s ", arr[i][j]);
                }
                System.out.println();
            }
            return arr;
        }
        public static int processArray(String[][] arr) throws MyArraySizeExeption, MyArrayDataSizeExeption{
            if(arr.length != 4 || arr[0].length != 4){
                throw new MyArraySizeExeption("Некорректный размер массива ", arr.length, arr[0].length);
            }
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    sum += parseElement(arr[i][j], i, j);
                }
            }
            return sum;
        }
        public static  int parseElement(String st, int i, int j) throws MyArrayDataSizeExeption {
            try {
                return Integer.parseInt(st);
            }
            catch (NumberFormatException e){
                throw new MyArrayDataSizeExeption("Некорректный формат данных ", i, j);
            }

        }
}

abstract class MyException extends Exception{
    private final int x;
    private final int y;

    public MyException(String message, int x, int y){
        super(message);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
class MyArraySizeExeption extends MyException{
    public MyArraySizeExeption(String message, int x, int y){
        super(message, x, y);
    }
}
class MyArrayDataSizeExeption extends MyException{
    public MyArrayDataSizeExeption(String message, int x, int y){
        super(message, x, y);
    }
}
