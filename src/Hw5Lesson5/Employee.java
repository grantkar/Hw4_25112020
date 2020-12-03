package Hw5Lesson5;

public class Employee {
    private String fio;
    private String position;
    private String email;
    private int phoneNumber;
    private int salary;
    private int age;


    public Employee(String fio, String position, String email, int phoneNumber, int salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }
    public String toString(){
        return String.format("ФИO: %s. Возраст: %d\n Должность: %s. Email: %s\n Телефон: %d Зарплата: %d" ,fio, age,
                position, email, phoneNumber, salary);
    }

    public int getAge() {
        return age;
    }

    void info() {
      //  System.out.println(fio + "ФИО: "+"Возраст "+age+"\n" +"Должность: "+ position+" Email: "+ email+
        //        "\nТелефон: "+ phoneNumber+" Зарплата "   +salary + "руб.");
        System.out.printf("ФИO: %s. Возраст: %d\n Должность: %s. Email: %s\n Телефон: %d Зарплата: %d",fio, age,
                position, email, phoneNumber, salary);
    }
}
