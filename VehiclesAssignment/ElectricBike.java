package VehiclesAssignment;

class ElectricBike extends ElectricVehicle {
    private String model;

    public ElectricBike(String model, String batteryCapacity) {
        super(batteryCapacity);
        this.model = model;
    }

    @Override
    public void start() {
        System.out.println(model + " electric bike started.");
    }
    @Override
    public String color(){
        return "Enter color:"+Vehicle.sc.next();
    }
    @Override
    public void stop() {
        System.out.println(model + " electric bike stopped.");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
