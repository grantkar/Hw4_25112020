package konvertor;

import java.util.Scanner;

public class Main {


    static Scanner scanner = new Scanner(System.in);
    static final float teaSpoon = 5.00f;
    static final float tableSpoon = 15.00f;
    static float ml;
    static float res;
    static int answer;

    public static void main(String[] args) {
       MyWindow myWindow = new MyWindow();



        do {
            System.out.println("Введите количество мл. для конвертации: ");
            ml = scanner.nextInt();

            while (ml < 0) {
                System.out.println("Введите пожалуйста положительное количество мл.");
                ml = scanner.nextInt();
            }
            if (ml < 15) {
                res = ml / teaSpoon;
                System.out.printf("Количество введенных мл. эквивалентно %.1f чайным ложкам", res);
                System.out.println();
            } else {
                res = ml / tableSpoon;
                System.out.printf("Количество введенных мл. эквивалентно %.1f столовым ложкам", res);
                System.out.println();
            }
            System.out.println("Хотите конвертировать еще? Если да - наберите 1, если нет любую другую цифру");
            answer = scanner.nextInt();
        }while (answer==1);
    }
}
