package shallow;

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
	int age; // premitive type- will be cloned while doing shallowClone
	Car car; // Object type- will not be cloned while doing shallowClone

	Person(int age, String brand) {
		this.age = age;
		this.car = new Car(brand);
	}

	// Shallow Clone
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "Age: " + age + ", Owns a " + car;
	}
}

public class ShallowCopyDemo {
	public static void main(String[] args) throws CloneNotSupportedException {

		Person person1 = new Person(30, "Toyota");

		// Shallow cloning
		Person person2 = (Person) person1.clone(); // 30, "Toyota"
		// both person1 and person2 objects poiting to same Toyota Car Object

		// Changing the car brand for person2
		// (This will change person1's car brand as well due to shallow copying)
		person2.car.brand = "Ford";

		System.out.println("Original Person: " + person1);
		System.out.println("Shallow Clone: " + person2);
	}
}
