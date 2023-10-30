package shallow;

import java.util.HashMap;
import java.util.Map;

//Prototype interface
interface Prototype extends Cloneable {
	Prototype clone() throws CloneNotSupportedException;
}

//Car class as a prototype
class Car implements Prototype {
	private String brand;

	public Car(String brand) {
		this.brand = brand;
	}

	@Override
	public Prototype clone() throws CloneNotSupportedException {
		return (Prototype) super.clone(); // Shallow clone
	}

	@Override
	public String toString() {
		return brand;
	}

	// to update brand
	public void setBrand(String brand) {
		this.brand = brand;
	}
}

//Person class
class Person implements Prototype {
	private String name;
	private Car car;

	public Person(String name, Car car) {
		this.name = name;
		this.car = car;
	}

	@Override
	public Prototype clone() throws CloneNotSupportedException {
		return (Prototype) super.clone(); // Shallow clone
	}

	@Override
	public String toString() {
		return name + " owns a " + car;
	}

	// getter for car
	public Car getCar() {
		return car;
	}
}

//Prototype manager
class PrototypeManager {
	private static final Map<String, Prototype> prototypes = new HashMap<>();

	/**
	 * If you have a set of default prototypes, defining them in the static block
	 * ensures that they are available for cloning from the start and this is
	 * reccomended approach. If you want more prototypes, you can update the static
	 * block accordingly.
	 */

	static {
		prototypes.put("car", new Car("Toyota Car Brand"));
		// we are using a [new Car("Default Car Brand")] for person
		prototypes.put("person", new Person("Default Person Name", new Car("Default Car Brand")));
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

public class PrototypeShallowCloneExample {
	public static void main(String[] args) {

		// Use the prototype manager to create instances
		// This creates a separate Car prototype object, unrelated to the Person
		// prototypes.
		Prototype carPrototype = PrototypeManager.getPrototype("car");
		System.out.println("Car Prototype: " + carPrototype);

		// Use the prototype manager to create instances
		Prototype personPrototype1 = PrototypeManager.getPrototype("person");
		Prototype personPrototype2 = PrototypeManager.getPrototype("person");

		// Updating the dependent or referenced object will update the same Car
		// prototype.
		((Person) personPrototype1).getCar().setBrand("BMW");
		((Person) personPrototype2).getCar().setBrand("BMW");

		System.out.println("Person Prototype1 shallow cloned: " + personPrototype1);
		System.out.println("Person Prototype2 shallow cloned: " + personPrototype2);

	}
}
