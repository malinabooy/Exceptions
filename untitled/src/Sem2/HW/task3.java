package Sem2.HW;
import java.io.FileNotFoundException;

public class task3 {
    public static void main(String[] args) {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (NullPointerException e) {
            System.out.println("Указатель не может указывать на null!");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        } catch (Throwable e) {
            System.out.println("Что-то пошло не так...");
        }
    }

    /**
     * throws FileNotFoundException можно убрать, если это не часть плана
     */
    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        boolean someCondition = true;
        if (someCondition) {
            throw new FileNotFoundException("Файл не найден");
        }
        System.out.println(a + b);
    }
}
