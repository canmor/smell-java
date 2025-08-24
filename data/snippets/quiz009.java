class Vehicle {
    public void startEngine() {
        System.out.println("Engine started.");
    }
    
    public void stopEngine() {
        System.out.println("Engine stopped.");
    }
    
    public void accelerate() {
        System.out.println("Accelerating...");
    }
    
    public void brake() {
        System.out.println("Braking...");
    }
    
    public void refuel() {
        System.out.println("Refueling with gasoline.");
    }
    
    public void changeGear() {
        System.out.println("Changing gear.");
    }
    
    public void turnOnHeadlights() {
        System.out.println("Headlights turned on.");
    }
    
    public void honkHorn() {
        System.out.println("Horn honked.");
    }
}

class ElectricBicycle extends Vehicle {
    
    @Override
    public void startEngine() {
        throw new UnsupportedOperationException("Electric bicycles don't have engines!");
    }
    
    @Override
    public void stopEngine() {
        throw new UnsupportedOperationException("Electric bicycles don't have engines!");
    }
    
    @Override
    public void refuel() {
        throw new UnsupportedOperationException("Electric bicycles don't use gasoline!");
    }
    
    @Override
    public void changeGear() {
        throw new UnsupportedOperationException("This electric bicycle doesn't have gears!");
    }
    
    @Override
    public void honkHorn() {
        throw new UnsupportedOperationException("Electric bicycles typically don't have horns!");
    }
    
    public void chargeBattery() {
        System.out.println("Charging battery.");
    }
    
    public void checkBatteryLevel() {
        System.out.println("Battery level: 75%");
    }
    
    public void activateAssistMode() {
        System.out.println("Pedal assist mode activated.");
    }
    
    @Override
    public void accelerate() {
        System.out.println("Electric bicycle accelerating with motor assist.");
    }
    
    @Override
    public void brake() {
        System.out.println("Electric bicycle braking with regenerative charging.");
    }
    
    @Override
    public void turnOnHeadlights() {
        System.out.println("LED headlight turned on.");
    }
}
