// Car parts interfaces
interface Engine {
	void design();
}

interface Wheels {
	void manufacture();
}

interface Seats {
	void assemble();
}

// Concrete luxury car parts
class LuxuryEngine implements Engine {
	@Override
	public void design() {
		System.out.println("Designing a luxury car engine.");
	}
}

class LuxuryWheels implements Wheels {
	@Override
	public void manufacture() {
		System.out.println("Manufacturing luxury car wheels.");
	}
}

class LuxurySeats implements Seats {
	@Override
	public void assemble() {
		System.out.println("Assembling luxury car seats.");
	}
}

// Concrete sports car parts
class SportsEngine implements Engine {
	@Override
	public void design() {
		System.out.println("Designing a sports car engine.");
	}
}

class SportsWheels implements Wheels {
	@Override
	public void manufacture() {
		System.out.println("Manufacturing sports car wheels.");
	}
}

class SportsSeats implements Seats {
	@Override
	public void assemble() {
		System.out.println("Assembling sports car seats.");
	}
}

// Abstract Factory for car parts
interface CarPartsFactory {
	Engine createEngine();

	Wheels createWheels();

	Seats createSeats();
}

// Concrete factory for luxury car parts
class LuxuryCarPartsFactory implements CarPartsFactory {
	@Override
	public Engine createEngine() {
		return new LuxuryEngine();
	}

	@Override
	public Wheels createWheels() {
		return new LuxuryWheels();
	}

	@Override
	public Seats createSeats() {
		return new LuxurySeats();
	}
}

// Concrete factory for sports car parts
class SportsCarPartsFactory implements CarPartsFactory {
	@Override
	public Engine createEngine() {
		return new SportsEngine();
	}

	@Override
	public Wheels createWheels() {
		return new SportsWheels();
	}

	@Override
	public Seats createSeats() {
		return new SportsSeats();
	}
}

public class CarExample {
	public static void assembleCar(CarPartsFactory factory) {
		Engine engine = factory.createEngine();
		Wheels wheels = factory.createWheels();
		Seats seats = factory.createSeats();

		engine.design();
		wheels.manufacture();
		seats.assemble();
	}

	public static void main(String[] args) {
		System.out.println("Assembling a luxury car:");
		assembleCar(new LuxuryCarPartsFactory());

		System.out.println("\nAssembling a sports car:");
		assembleCar(new SportsCarPartsFactory());
	}
}
