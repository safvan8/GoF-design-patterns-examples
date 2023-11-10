package com.safvan.decorator;

// Step 1: Define the Beverage (Component) interface
abstract class Beverage {
	String description = "Unknown Beverage";

	String getDescription() {
		return description;
	}

	abstract double cost();
}

// Step 2: Implement concrete components (different types of coffee)
class Espresso extends Beverage {
	Espresso() {
		description = "Espresso";
	}

	double cost() {
		return 1.99;
	}
}

class HouseBlend extends Beverage {
	HouseBlend() {
		description = "House Blend Coffee";
	}

	double cost() {
		return 0.89;
	}
}

// Step 3: Define the CondimentDecorator (Decorator) interface
abstract class CondimentDecorator extends Beverage {
	abstract String getDescription();
}

// Step 4: Implement concrete condiment decorators
class Milk extends CondimentDecorator {
	Beverage beverage;

	Milk(Beverage beverage) {
		this.beverage = beverage;
	}

	String getDescription() {
		return this.beverage.getDescription() + ", Milk";
	}

	double cost() {
		return 0.10 + this.beverage.cost();
	}
}

class Soy extends CondimentDecorator {
	Beverage beverage;

	Soy(Beverage beverage) {
		this.beverage = beverage;
	}

	String getDescription() {
		return this.beverage.getDescription() + ", Soy";
	}

	double cost() {
		return 0.15 + this.beverage.cost();
	}
}

// Step 5: Client code
public class CoffeeShop {
	public static void main(String[] args) {
		// Ordering an espresso with milk
		Beverage espressoWithMilk = new Milk(new Espresso());
		System.out.println("Description: " + espressoWithMilk.getDescription());
		System.out.println("Cost: $" + espressoWithMilk.cost());

		// Ordering a house blend with soy and milk
		Beverage houseBlendWithSoyAndMilk = new Milk(new Soy(new HouseBlend()));
		System.out.println("Description: " + houseBlendWithSoyAndMilk.getDescription());
		System.out.println("Cost: $" + houseBlendWithSoyAndMilk.cost());
	}
}
