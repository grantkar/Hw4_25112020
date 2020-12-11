package Hw7Lesson7;

public class Main {

    public static void main(String[] args) {

        Cat cat = new Cat("Murzik", 20);

        Cat [] cats = {
                new Cat("Barsik", 20),
                new Cat("Kyzia", 10),
                new Cat("Vasia", 30),
                new Cat("Pyxlok", 40)
        };

        Plate plate = new Plate(100);
        cat.eat(plate);
        plate.info();

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            plate.info();
        }

        plate.addFoot();
        cats[3].eat(plate);

        plate.info();

        Dog dog = new Dog("Tuzik");
        dog.scare(cat);

    }
}
