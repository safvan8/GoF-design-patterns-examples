package strategy;

public class DuckSimulator {
	public static void main(String[] args) {
		// Creating ducks with different behaviors
		Duck mallardDuck = new MallardDuck();
		Duck rubberDuck = new RubberDuck();
		Duck decoyDuck = new DecoyDuck();

		// Displaying ducks and performing behaviors
		System.out.println("Mallard Duck:");
		mallardDuck.display();
		mallardDuck.performQuack();
		mallardDuck.performFly();
		mallardDuck.swim();
		System.out.println();

		System.out.println("Rubber Duck:");
		rubberDuck.display();
		rubberDuck.performQuack();
		rubberDuck.performFly();
		rubberDuck.swim();
		System.out.println();

		System.out.println("Decoy Duck:");
		decoyDuck.display();
		decoyDuck.performQuack();
		decoyDuck.performFly();
		decoyDuck.swim();
	}
}
