package Hw5Lesson5;

import java.util.Arrays;

public class MainOopApp {
    public static void main(String[] args) {


        Employee[] employees = {
                new Employee("Иванов Иван Иванович", "Директор", "Ivanov@mail.ru",
                        555555, 300000, 50),
                new Employee("Васильев Василий Васильевич", "Охранник", "vasili@mail.ru",
                        321321, 30000, 45),
                new Employee("Андреев Андрей Андреевич", "Senior-Java developer", "Andrei@mail.ru"
                        , 888888, 200000, 35),
                new Employee("Максимов Максим Максимович", "Middle-Java developer", "Maks@mail.ru"
                        , 777777, 100000, 34),
                new Employee("Хаюров Евгений Викторович", "Junior-Java developer", "xaur@mail.ru"
                        , 456456, 30000, 25)
        };


        for (int i = 0; i < employees.length; i++) {
               if (employees[i].getAge()>=40) {
                   System.out.println(employees[i]);
               }
            }
        }
    }

