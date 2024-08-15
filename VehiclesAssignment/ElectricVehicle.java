package VehiclesAssignment;

abstract class ElectricVehicle {
//    static Scanner sc = new Scanner(System.in);
    private String batteryCapacity;

    abstract String color();

    public ElectricVehicle(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }
    public abstract void start();

    public abstract void stop();

    public void charge() {
        System.out.println("Charging capacity: " + batteryCapacity);
    }

    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }
}
