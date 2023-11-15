// Step 1: Create an interface for the manufacturing system
package bridge;

interface Manufacturing {
	void assemble();

	void paint();
}

// Step 2: Create an implementation of the manufacturing system
class CarManufacturing implements Manufacturing {
	@Override
	public void assemble() {
		System.out.println("Assembling Car");
	}

	@Override
	public void paint() {
		System.out.println("Painting Car");
	}
}

class BikeManufacturing implements Manufacturing {
	@Override
	public void assemble() {
		System.out.println("Assembling Bike");
	}

	@Override
	public void paint() {
		System.out.println("Painting Bike");
	}
}

// Step 3: Create an abstract class for the vehicle
abstract class Vehicle {
	protected Manufacturing manufacturing;

	protected Vehicle(Manufacturing manufacturing) {
		this.manufacturing = manufacturing;
	}

	abstract void produce();
}

// Step 4: Create concrete implementations of the vehicle
class Car extends Vehicle {
	public Car(Manufacturing manufacturing) {
		super(manufacturing);
	}

	@Override
	void produce() {
		System.out.println("Producing Car:");
		manufacturing.assemble();
		manufacturing.paint();
	}
}

class Bike extends Vehicle {
	public Bike(Manufacturing manufacturing) {
		super(manufacturing);
	}

	@Override
	void produce() {
		System.out.println("Producing Bike:");
		manufacturing.assemble();
		manufacturing.paint();
	}
}

// Step 5: Client code
public class BridgeVehicleExample {
	public static void main(String[] args) {
		Manufacturing carManufacturing = new CarManufacturing();
		Manufacturing bikeManufacturing = new BikeManufacturing();

		Vehicle car = new Car(carManufacturing);
		Vehicle bike = new Bike(bikeManufacturing);

		car.produce();
		System.out.println("\n\n");
		bike.produce();
	}
}
