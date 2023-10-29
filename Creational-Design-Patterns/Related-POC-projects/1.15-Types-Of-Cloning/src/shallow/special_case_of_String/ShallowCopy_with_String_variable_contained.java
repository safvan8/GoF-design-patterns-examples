package shallow.special_case_of_String;

//dependent object ( referenced object )
class Car {
	String brand;

	Car(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + "]";
	}

}

class Person implements Cloneable {
	int age;
	Car car;
	String name;

	Person(int age, String carBrand, String name) {
		this.age = age;
		this.car = new Car(carBrand);
		this.name = name;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", car=" + car + ", name=" + name + "]";
	}

}

public class ShallowCopy_with_String_variable_contained {
	public static void main(String[] args) throws CloneNotSupportedException {
		Person person1 = new Person(30, "Toyota", "Safvan");

		// Deep cloning
		Person person2 = (Person) person1.clone();

		// Changing the car brand for person2 (This won't affect person1's car brand due
		// to deep cloning)
		person2.car.brand = "Ford";
		person2.name="SA";

		System.out.println("Original Person: " + person1);
		System.out.println("Deep Clone: " + person2);
	}
}
