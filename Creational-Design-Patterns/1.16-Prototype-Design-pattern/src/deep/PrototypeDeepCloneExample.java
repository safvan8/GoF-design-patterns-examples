package deep;

import java.util.HashMap;
import java.util.Map;

// Prototype interface
interface Prototype extends Cloneable {
	Prototype clone() throws CloneNotSupportedException;
}

// Car class as a prototype
class Car implements Prototype {
	private String brand;

	public Car(String brand) {
		this.brand = brand;
	}

	@Override
	public Prototype clone() throws CloneNotSupportedException {
		return (Prototype) super.clone(); // Shallow clone for the referenced Object
	}

	@Override
	public String toString() {
		return brand;
	}

	// Setter for brand
	public void setBrand(String brand) {
		this.brand = brand;
	}
}

// Person class
class Person implements Prototype {
	private String name;
	private Car car;

	public Person(String name, Car car) {
		this.name = name;
		this.car = car;
	}

	// Deep cloning implementation
	@Override
	public Prototype clone() throws CloneNotSupportedException {
		// Clone the Person object
		Person clonedPerson = (Person) super.clone();

		// Manually clone the referenced (dependent) car object and assign it
		// to ensure no shared reference to the same car object
		clonedPerson.car = (Car) car.clone();

		return clonedPerson;
	}

	@Override
	public String toString() {
		return name + " owns a " + car;
	}

	// Getter for car
	public Car getCar() {
		return car;
	}
}

// Prototype manager
class PrototypeManager {
	private static final Map<String, Prototype> prototypes = new HashMap<>();

	static {
		// Initialize prototypes
		prototypes.put("car", new Car("Toyota"));
		prototypes.put("person", new Person("Safvan", new Car("Default Car")));
	}

	// Get a prototype instance by type
	public static Prototype getPrototype(String type) {
		try {
			return prototypes.get(type).clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
}

public class PrototypeDeepCloneExample {
	public static void main(String[] args) {
		// Use the prototype manager to create instances
		Prototype carPrototype = PrototypeManager.getPrototype("car");
		Prototype personPrototype1 = PrototypeManager.getPrototype("person");
		Prototype personPrototype2 = PrototypeManager.getPrototype("person");

		// Update the car brand in one of the person prototypes
		((Person) personPrototype1).getCar().setBrand("BMW");

		// Output the prototypes
		System.out.println("Car Prototype: " + carPrototype);
		System.out.println("Person Prototype1 deep cloned: " + personPrototype1);
		System.out.println("Person Prototype2 deep cloned: " + personPrototype2);
	}
}
