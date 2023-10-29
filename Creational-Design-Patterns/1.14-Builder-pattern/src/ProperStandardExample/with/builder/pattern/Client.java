package ProperStandardExample.with.builder.pattern;

class Car {
    private final String make;
    private final String model;
    private final int year;

    // Private constructor to initialize car attributes
    private Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car [make=" + make + ", model=" + model + ", year=" + year + "]";
    }

    // Static nested class for building Car objects
    static class CarBuilder {
        private String make;
        private String model;
        private int year;

        // Set the car's make and return the builder
        public CarBuilder setMake(String make) {
            this.make = make;
            return this;
        }

        // Set the car's model and return the builder
        public CarBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        // Set the car's year and return the builder
        public CarBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        // Build and return a new Car instance
        public Car build() {
            return new Car(make, model, year);
        }
    }
}

public class Client {
    public static void main(String[] args) {
        // Create a Car using the CarBuilder
        Car car = new Car.CarBuilder()
            .setMake("Toyota")
            .setModel("Innova")
            .build();

        // Output car details
        System.out.println(car);
    }
}
