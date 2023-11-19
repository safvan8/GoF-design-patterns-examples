package strategy;

//Duck class utilizing strategy pattern
public abstract class Duck {
	private QuackBehavior quackBehavior;
	private FlyBehavior flyBehavior;

	public Duck(QuackBehavior quackBehavior, FlyBehavior flyBehavior) {
		this.quackBehavior = quackBehavior;
		this.flyBehavior = flyBehavior;
	}

	public void swim() {
		System.out.println("Swimming");
	}

	public void display() {
		System.out.println("Generic duck display");
	}

	public void performQuack() {
		quackBehavior.quack();
	}

	public void performFly() {
		flyBehavior.fly();
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}

	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}
}