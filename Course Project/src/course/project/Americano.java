package course.project;

public class Americano extends Coffee {
    public Americano(String size) {
        amountOfGroundCoffee = 7;
        amountOfWater = 170;
        arabicaRatio = 0.85;
        robustaRatio = 0.15;
        
        if (size.equals("Double")) {
            amountOfGroundCoffee *= 2;
            amountOfWater = 220;
        }
        
        super.calculate();
    }
}