package strategy;

//MallardDuck class using specific quack and fly behaviors
class MallardDuck extends Duck {
	public MallardDuck() {
		super(new Quack(), new FlyWithWings());
	}

	@Override
	public void display() {
		System.out.println("Looks like a Mallard");
	}
}

//RubberDuck class using specific quack behavior and no fly
class RubberDuck extends Duck {
	public RubberDuck() {
		super(new Squeak(), new NoFly());
	}

	@Override
	public void display() {
		System.out.println("Looks like a Rubber Duck");
	}
}

//DecoyDuck class using silent quack and no fly
class DecoyDuck extends Duck {
	public DecoyDuck() {
		super(new SilentQuack(), new NoFly());
	}

	@Override
	public void display() {
		System.out.println("Looks like a Decoy Duck");
	}
}
