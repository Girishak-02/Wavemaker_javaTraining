package VehiclesAssignment;

class Car implements Vehicle {
    private String model;

    public Car(String model) {
        this.model = model;
    }

    @Override
    public void start() {
        System.out.println(model + " car started.");
    }

    @Override
    public void stop() {
        System.out.println(model + " car stopped.");
    }
    @Override
    public String color(){
        System.out.println("Enter the color of the car :");
        return "Car color is:"+Vehicle.sc.next();
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
