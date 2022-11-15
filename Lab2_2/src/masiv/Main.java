package masiv;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static int IntegralNumber(int sr) { //метод для обробки виключення, коли в масиві відсутнє від'ємне число
        if(sr > 0) { //«кинуто виняток» та створено екземпляр RuntimeException з повідомленням
            throw new IllegalArgumentException("В масив не було введено негативних чисел");
        }
        else System.out.println("Середнє арифметичне негативних елементів масиву: ");
        return sr;
    }
    public static void Input(int[] array) { //метод введення масиву чисел
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < array.length; i++) {
            try { //обробка виключення введення рядка замість числа
                array[i] = sc.nextInt();
            }
            catch (InputMismatchException e) {
                System.err.println("Введіть число типу даних int");
                sc.nextLine();
            }
        }
    }
    public static int Average(int[] array) { //визначення мінімального числа масиву
        //Знаходження середнього арифметичного від'ємних чисел
        int sum = 0;
        int count = 0;
        int sr = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] < 0) {
                sum += array[i]; // Розраховуємо суму негативних елементів
                count++; // Знаходимо кількість негативних елементів
            }
        }
        return sr = sum / count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 0;
        System.out.print("Задайте розмір масиву: ");
        try {
            n = sc.nextInt();
        }
        catch (InputMismatchException e)
        {
            System.err.println("Введений рядок замість числа");
            sc.nextLine();
        }

        int[] array = new int[n]; //створюємо одновимірний масив елементів

        System.out.println("Введіть елементи масиву:" + "\t");
        Input(array);

        System.out.println("Введений масив: " + Arrays.toString(array));

        System.out.println(IntegralNumber(Average(array)));

    }
}