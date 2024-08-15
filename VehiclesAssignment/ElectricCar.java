package VehiclesAssignment;

class ElectricCar extends ElectricVehicle {
    private String model;

    public ElectricCar(String model, String batteryCapacity) {
        super(batteryCapacity);
        this.model = model;
    }
    @Override
    public void start() {
        System.out.println(model + " Electric car started.");
    }

    @Override
    public void stop() {
        System.out.println(model + " Electric car stopped.");
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

