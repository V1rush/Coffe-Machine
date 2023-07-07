package course.project;

public class CoffeeMachine {
    private final int waterCapacity = 1000, robustaCapacity = 200, arabicaCapacity = 200; 
    private int currentWaterLevel, currentArabicaLevel, currentRobustaLevel;
    private final int maxServedCups = 10;
    private Grinder coffeeGrinder;
    private Coffee coffee;

    public CoffeeMachine(int waterLevel, int robustaLevel, int arabicaLevel, String coffeeType, String cupSize, double grindSize) {
        this.currentWaterLevel = waterLevel;
        this.currentArabicaLevel = arabicaLevel;
        this.currentRobustaLevel = robustaLevel;
        
        if (coffeeType.equals("Espresso")) {
            coffee = new Espresso(cupSize);
        }
        
        else coffee = new Americano(cupSize); 
        
        coffeeGrinder = new Grinder(grindSize, coffee.getAmountOfGroundCoffee());
    }
    
    public CoffeeMachine() {
        
    }
    
    public Coffee getCoffee() {
        return coffee;
    }
    
    public void brewCoffee() {
        currentWaterLevel -= coffee.amountOfWater;
        currentRobustaLevel -= coffee.getAmountOfGroundCoffee() * coffee.robustaRatio;
        currentArabicaLevel -= coffee.getAmountOfGroundCoffee() * coffee.arabicaRatio;
        currentWaterLevel -= coffeeGrinder.grindingWater();
    }
    
    public int getAmountOfGrindingWater() {
        return coffeeGrinder.grindingWater();
    }
    
    public int getCurrentWaterLevel() {
        return currentWaterLevel;
    }

    public int getCurrentArabicaLevel() {
        return currentArabicaLevel;
    }

    public int getCurrentRobustaLevel() {
        return currentRobustaLevel;
    }
    
    public String getInfo() {
        return "Water capacity = " + waterCapacity + ", Robusta capacity = " + robustaCapacity 
                + ", Arabica capacity = " + arabicaCapacity + ", Current water level = " + currentWaterLevel 
                + ", Max served cups = " + maxServedCups;
    }
}
