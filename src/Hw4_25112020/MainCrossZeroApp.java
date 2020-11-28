package Hw4_25112020;
import java.util.Random;
import java.util.Scanner;

public class MainCrossZeroApp {
    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 5;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();


    public static void main(String[] args) {


        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static boolean checkWin(char symb) {
        if (winKombDiagonal1(symb) || winKombDiagonal2(symb) || winKombHoriz(symb) || winKombVertic(symb)){
            return true;
        }
        return false;
    }

    public static boolean winKombDiagonal1(char symb){
        int lineDiag1 = 0;
        for (int i = 0; i < DOTS_TO_WIN; i++) {
             if (map[i][i]==symb) {
                 lineDiag1++;
             }
            }
             if (lineDiag1==DOTS_TO_WIN) {
                    return true;
        }return false;
    }
    
    public static boolean winKombDiagonal2(char symb) {
        int dotKomb2 = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (j == (SIZE - 1) - i) {
                    if (map[i][j]==symb) {
                        dotKomb2++;
                    }
                }
            }
        }
        if (dotKomb2 == DOTS_TO_WIN ) {
            return true;
        }return false;
    }

    public static boolean winKombHoriz(char symb){

        int [] lineHoriz= new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
              if (map[i][j]==symb){
               lineHoriz[i]++;
            } if (lineHoriz[i]==DOTS_TO_WIN ) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean winKombVertic(char symb){
        int [] lineVertic = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(map[j][i]==symb){
                    lineVertic[i]++;
                  }
            }if (lineVertic[i]==DOTS_TO_WIN){
                return true;
            }
        }
        return false;
    }

    public static boolean chekVictory(char symb){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i,j)){
                    map[i][j] = DOT_O;
                    if (checkWin(DOT_O)){
                        map[i][j]=DOT_O;
                        return true;
                    } else {
                        map[i][j]=DOT_EMPTY;
                    }
                }
            }
        }return false;
    }

    public static boolean chekBlok(char symb){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i,j)){
                   if (map[i][j] == DOT_X) {
                       if (checkWin(DOT_X)){
                           map[i][j] = DOT_O;
                       return true;
                    }
                   }
                }
            }
        } return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
    public static void aiTurn() {
        int x, y;
        do {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            } while (!isCellValid(x, y));
            System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
            map[y][x] = DOT_O;

    }


    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }
    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
