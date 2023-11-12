package com.safvan.facade;

class Amplifier {
	void on() {
		System.out.println("Amplifier is ON");
	}

	void off() {
		System.out.println("Amplifier is OFF");
	}

	// Other amplifier methods...
}
class Tuner {
    // Tuner methods...
}

class DvdPlayer {
    void on() {
        System.out.println("DVD Player is ON");
    }

    void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }

    void stop() {
        System.out.println("DVD Player stopped");
    }

    void eject() {
        System.out.println("Ejecting DVD");
    }

    void off() {
        System.out.println("DVD Player is OFF");
    }

    // Other DVD player methods...
}

class CdPlayer {
    // CD player methods...
}

class Projector {
    void on() {
        System.out.println("Projector is ON");
    }

    void wideScreenMode() {
        System.out.println("Projector is in widescreen mode");
    }

    void off() {
        System.out.println("Projector is OFF");
    }

    // Other projector methods...
}

class Screen {
    void down() {
        System.out.println("Screen is lowered");
    }

    void up() {
        System.out.println("Screen is raised");
    }

    // Other screen methods...
}

class TheaterLights {
    void dim(int level) {
        System.out.println("Lights dimmed to " + level + "%");
    }

    void on() {
        System.out.println("Lights are ON");
    }

    // Other lights methods...
}

class PopcornPopper {
    void on() {
        System.out.println("Popcorn Popper is ON");
    }

    void off() {
        System.out.println("Popcorn Popper is OFF");
    }

    void pop() {
        System.out.println("Popcorn Popper is popping popcorn!");
    }

    // Other popcorn popper methods...
}