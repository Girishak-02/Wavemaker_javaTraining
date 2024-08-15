package VehiclesAssignment;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        Car car = new Car("Toyota");
        car.start();
        car.stop();
        System.out.println(car.color());

        Bike bike = new Bike("Royal Enfield");
        bike.start();
        bike.stop();
        System.out.println(bike.color());

        ElectricCar electricCar = new ElectricCar("Hyundai", "80 kWh");
        electricCar.start();
        electricCar.charge();
        electricCar.stop();
        System.out.print(electricCar.color());

        ElectricBike electricBike = new ElectricBike("Ola", "20 kWh");
        electricBike.start();
        electricBike.charge();
        electricBike.stop();
        System.out.println(electricBike.color());
    }
}
