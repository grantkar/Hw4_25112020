package Hw7Lesson7;

public class Cat {
    private String name;
    private int amount;

    public Cat(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void eat(Plate plate) {
        System.out.println("cat " + name + " eat...");
        System.out.print(name + " ");
        plate.decreaseFood(this.amount);

    }



    public void fear(Dog dog){
        System.out.println("Cat "+ name + " fear dog "+ dog.getName());
    }
}
