package course.project;

public class Grinder {
    private double grindSize, amountOfCoffee;

    public Grinder(double grindSize, double amountOfCoffee) {
        this.grindSize = grindSize;
        this.amountOfCoffee = amountOfCoffee;
    }
    
    public int grindingWater() {
        double neededWater;
        
        //The amount of hot water that's used to grind the coffee
        //The larger grind size, the less consumed water
        neededWater = amountOfCoffee * 2 + 0.5 * (100 - grindSize);
        return (int)neededWater;
    }

    public double getGrindSize() {
        return grindSize;
    }

    public double getAmountOfCoffee() {
        return amountOfCoffee;
    }

    public void setGrindSize(double grindSize) {
        this.grindSize = grindSize;
    }

    public void setAmountOfCoffee(double amountOfCoffee) {
        this.amountOfCoffee = amountOfCoffee;
    }

    public String getInfo() {
        return "Grind size = " + grindSize + ", Amount of coffee = " + amountOfCoffee;
    }
}
