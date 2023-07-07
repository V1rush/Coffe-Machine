package course.project;

class Coffee {
    protected double amountOfGroundCoffee, amountOfWater, arabicaRatio, robustaRatio, calories, caffeine;

    public void calculate() {
        calories = 1.5 * amountOfGroundCoffee;
        caffeine = robustaRatio * amountOfGroundCoffee * 0.025 + arabicaRatio * amountOfGroundCoffee * 0.013;
    }

    public double getAmountOfGroundCoffee() {
        return amountOfGroundCoffee;
    }

    public double getAmountOfWater() {
        return amountOfWater;
    }
    
    public double getAmountOfCaffeine() {
        return caffeine * 1000;
    }
    
    public double getAmountOfCalories() {
        return calories;
    }

    public String getInfo() {
        return "Amount of ground coffee = " + amountOfGroundCoffee + ", Amount of water = " + amountOfWater + ", Arabica ratio = " + arabicaRatio + ", Robusta ratio = " + robustaRatio;
    }
}
