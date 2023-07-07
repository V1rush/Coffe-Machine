package course.project;

public class Espresso extends Coffee {
    public Espresso(String size) {
        amountOfGroundCoffee = 7;
        amountOfWater = 30;
        arabicaRatio = 0.7;
        robustaRatio = 0.3;
        
        if (size.equals("Double")) {
            amountOfGroundCoffee *= 2;
            amountOfWater *= 2;
        }
        
        super.calculate();
    }
}
