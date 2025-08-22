class Bird {
    public void fly() {
        System.out.println("Flying...");
    }
    
    public void eat() {
        System.out.println("Eating...");
    }
    
    public void makeSound() {
        System.out.println("Chirp...");
    }
    
    public void layEggs() {
        System.out.println("Laying eggs...");
    }
    
    public void sleep() {
        System.out.println("Sleeping...");
    }
    
    public void buildNest() {
        System.out.println("Building nest...");
    }
}

class Penguin extends Bird {
    // Refused bequest: Penguins can't fly
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins can't fly!");
    }
    
    @Override
    public void makeSound() {
        System.out.println("Squawk...");
    }
    
    public void swim() {
        System.out.println("Swimming...");
    }
    
    public void slideOnIce() {
        System.out.println("Sliding on ice...");
    }
}

class Ostrich extends Bird {
    // Ostriches also can't fly
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostriches can't fly!");
    }
    
    // Also refuse nest building behavior
    @Override
    public void buildNest() {
        throw new UnsupportedOperationException("Ostriches don't build nests like other birds!");
    }
    
    @Override
    public void makeSound() {
        System.out.println("Boom...");
    }
    
    public void run() {
        System.out.println("Running very fast...");
    }
    
    public void kickWithPowerfulLegs() {
        System.out.println("Kicking with powerful legs...");
    }
}

class Kiwi extends Bird {
    // Kiwis can't fly either
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Kiwis can't fly!");
    }
    
    // Kiwis are nocturnal, so they have different sleep patterns
    @Override
    public void sleep() {
        System.out.println("Sleeping during the day...");
    }
    
    public void huntAtNight() {
        System.out.println("Hunting for insects at night...");
    }
    
    public void digWithBeak() {
        System.out.println("Digging in the ground with long beak...");
    }
}

// Another example with different inheritance issues
class Vehicle {
    public void startEngine() {
        System.out.println("Starting engine...");
    }
    
    public void drive() {
        System.out.println("Driving...");
    }
    
    public void refuel() {
        System.out.println("Refueling...");
    }
    
    public void honk() {
        System.out.println("Honking horn...");
    }
    
    public void useWipers() {
        System.out.println("Using windshield wipers...");
    }
}

class Bicycle extends Vehicle {
    // Bicycles refuse most vehicle behaviors
    @Override
    public void startEngine() {
        throw new UnsupportedOperationException("Bicycles don't have engines!");
    }
    
    @Override
    public void refuel() {
        throw new UnsupportedOperationException("Bicycles don't need fuel!");
    }
    
    @Override
    public void honk() {
        System.out.println("Ringing bell...");
    }
    
    @Override
    public void useWipers() {
        throw new UnsupportedOperationException("Bicycles don't have windshield wipers!");
    }
    
    public void pedal() {
        System.out.println("Pedaling...");
    }
    
    public void ringBell() {
        System.out.println("Ring ring!");
    }
}

class ElectricCar extends Vehicle {
    // Electric cars refuse some traditional vehicle behaviors
    @Override
    public void refuel() {
        throw new UnsupportedOperationException("Electric cars don't use gasoline!");
    }
    
    public void charge() {
        System.out.println("Charging battery...");
    }
    
    public void enableAutopilot() {
        System.out.println("Enabling autopilot...");
    }
}

// Demonstration of the problem
class TransportationService {
    public void maintainVehicle(Vehicle vehicle) {
        try {
            vehicle.startEngine();
            vehicle.refuel();
            vehicle.useWipers();
            System.out.println("Vehicle maintenance completed");
        } catch (UnsupportedOperationException e) {
            System.out.println("Maintenance failed: " + e.getMessage());
        }
    }
    
    public void trainBird(Bird bird) {
        try {
            bird.fly();
            bird.buildNest();
            System.out.println("Bird training completed");
        } catch (UnsupportedOperationException e) {
            System.out.println("Training failed: " + e.getMessage());
        }
    }
    
    // This method shows the Liskov Substitution Principle violation
    public void demonstrateFlightCapability(Bird[] birds) {
        for (Bird bird : birds) {
            try {
                System.out.println("Testing flight for " + bird.getClass().getSimpleName());
                bird.fly(); // Some birds will throw exceptions!
            } catch (UnsupportedOperationException e) {
                System.out.println("Cannot fly: " + e.getMessage());
            }
        }
    }
    
    public static void demonstrateProblems() {
        TransportationService service = new TransportationService();
        
        // Bird hierarchy problems
        Bird[] birds = {
            new Penguin(),
            new Ostrich(), 
            new Kiwi()
        };
        service.demonstrateFlightCapability(birds);
        
        // Vehicle hierarchy problems
        Vehicle[] vehicles = {
            new Bicycle(),
            new ElectricCar()
        };
        
        for (Vehicle vehicle : vehicles) {
            System.out.println("\nMaintaining " + vehicle.getClass().getSimpleName());
            service.maintainVehicle(vehicle);
        }
    }
}
