package VehiclesAssignment;

class Bike implements Vehicle {
    private String model;

    public Bike(String model) {
        this.model = model;
    }

    @Override
    public void start() {
        System.out.println(model + " Bike started.");
    }

    @Override
    public void stop() {
        System.out.println(model + " Bike stopped.");
    }
    @Override
    public String color(){
        System.out.println("Enter the color of the Bike :");
        return "Bike color is:"+Vehicle.sc.next();
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
