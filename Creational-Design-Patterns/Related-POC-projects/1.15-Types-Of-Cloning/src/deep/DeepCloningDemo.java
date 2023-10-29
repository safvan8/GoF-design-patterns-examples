package deep;

//dependent object ( referenced object )
class Car {
	String brand;

	Car(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return brand;
	}
}

class Person implements Cloneable {
	int age;
	Car car;

	Person(int age, String carBrand) {
		this.age = age;
		this.car = new Car(carBrand);
	}

	// Deep Cloning
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// Step 1: Call the clone() method from the superclass (Object) to create a
		// shallow copy of the current object.
		Person clonedPerson = (Person) super.clone();

		// Step 2: Create a new Car object for the clonedPerson by copying the car's
		// brand.
		clonedPerson.car = new Car(this.car.brand);

		// Step 3: Return the cloned Person object, which is now a deep copy.
		return clonedPerson;
	}

	@Override
	public String toString() {
		return "Age: " + age + ", Owns a " + car;
	}
}

public class DeepCloningDemo {
	public static void main(String[] args) throws CloneNotSupportedException {
		Person person1 = new Person(30, "Toyota");

		// Deep cloning
		Person person2 = (Person) person1.clone();

		// Changing the car brand for person2 (This won't affect person1's car brand due
		// to deep cloning)
		person2.car.brand = "Ford";

		System.out.println("Original Person: " + person1);
		System.out.println("Deep Clone: " + person2);
	}
}
