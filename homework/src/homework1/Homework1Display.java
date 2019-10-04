package homework1;

public class Homework1Display {
    public static void main(String[] args) {
        System.out.println("The value of the dices:");
        
        Homework1 dice = new Homework1();
        int dice1, dice2;

        for (;;) {
            dice1 = dice.rollTheDice();
            dice2 = dice.rollTheDice();
            System.out.println("Dice 1: " + dice1 + "   Dice 2: " + dice2);
            if (dice1 == dice2) break;
        }
    }
}