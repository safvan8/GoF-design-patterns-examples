package com.safvan.facade;

// Define the interface for the HomeTheaterFacade
interface HomeTheaterFacade {
	void watchMovie(String movie);

	void endMovie();
}

// Implement the HomeTheaterFacade interface
class HomeTheaterFacadeImpl implements HomeTheaterFacade {
	// Components of the subsystem
	Amplifier amp;
	Tuner tuner;
	DvdPlayer dvd;
	CdPlayer cd;
	Projector projector;
	Screen screen;
	TheaterLights lights;
	PopcornPopper popper;

	// Constructor to initialize the components
	public HomeTheaterFacadeImpl(Amplifier amp, Tuner tuner, DvdPlayer dvd, CdPlayer cd, Projector projector,
			Screen screen, TheaterLights lights, PopcornPopper popper) {
		this.amp = amp;
		this.tuner = tuner;
		this.dvd = dvd;
		this.cd = cd;
		this.projector = projector;
		this.screen = screen;
		this.lights = lights;
		this.popper = popper;
	}

	// Unified interface method to watch a movie
	public void watchMovie(String movie) {
		System.out.println("Get ready to watch a movie...");
		// Turn on components and perform necessary actions
		popper.on();
		popper.pop();
		lights.dim(10);
		screen.down();
		projector.on();
		projector.wideScreenMode();
		amp.on();
		dvd.on();
		dvd.play(movie);
	}

	// Unified interface method to end the movie
	public void endMovie() {
		System.out.println("Shutting movie theater down...");
		// Turn off components and perform necessary actions
		popper.off();
		lights.on();
		screen.up();
		projector.off();
		amp.off();
		dvd.stop();
		dvd.eject();
		dvd.off();
	}
}

// Test Drive Class
public class HomeTheaterTest {
	public static void main(String[] args) {
		// instantiate components here
		Amplifier amp = new Amplifier();
		Tuner tuner = new Tuner();
		DvdPlayer dvd = new DvdPlayer();
		CdPlayer cd = new CdPlayer();
		Projector projector = new Projector();
		Screen screen = new Screen();
		TheaterLights lights = new TheaterLights();
		PopcornPopper popper = new PopcornPopper();

		// Create an instance of the HomeTheaterFacade and pass the components
		HomeTheaterFacade homeTheater = new HomeTheaterFacadeImpl(amp, tuner, dvd, cd, projector, screen, lights,
				popper);

		// Use the facade to watch and end the movie
		homeTheater.watchMovie("Raiders of the Lost Ark");

		System.err.println("\n\n\n\n=====================\n\n\n\n");

		homeTheater.endMovie();
	}
}
