package Hw7Lesson7;

public class Plate {
    private int food;
    final int addKorm = 100;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int amount) {
        if (amount < 0) {
            return;
        } else if ((food - amount)<0){
            System.out.println(" осталась голодной");
            return;
        }
        food -= amount;
        System.out.println(" насытился");
    }

    public void info() {
        System.out.println("Food: " + food);
    }

    public void addFoot(){
        food = food + addKorm;
        System.out.println("Хозяин добавил "+ addKorm + " корма");
        System.out.println("Food: " + food);
    }
}

