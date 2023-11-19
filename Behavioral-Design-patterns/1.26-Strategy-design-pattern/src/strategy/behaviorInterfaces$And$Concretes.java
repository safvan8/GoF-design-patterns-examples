package strategy;

//Strategy interface for quack behavior
interface QuackBehavior {
	void quack();
}

//Strategy interface for fly behavior
interface FlyBehavior {
	void fly();
}

//Concrete quack behaviors
class Quack implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("Quacking");
	}
}

class Squeak implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("Squeaking");
	}
}

class SilentQuack implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("Silent quack");
	}
}

//Concrete fly behaviors
class FlyWithWings implements FlyBehavior {
	@Override
	public void fly() {
		System.out.println("Flying with wings");
	}
}

class NoFly implements FlyBehavior {
	@Override
	public void fly() {
		System.out.println("Cannot fly");
	}
}
