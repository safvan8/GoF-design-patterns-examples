//Abstract UI component interfaces
interface Button {
	void render();
}

interface TextField {
	void display();
}

interface Checkbox {
	void select();
}

//Concrete UI components for Windows
class WindowsButton implements Button {
	@Override
	public void render() {
		System.out.println("Rendering a Windows button");
	}
}

class WindowsTextField implements TextField {
	@Override
	public void display() {
		System.out.println("Displaying a Windows text field");
	}
}

class WindowsCheckbox implements Checkbox {
	@Override
	public void select() {
		System.out.println("Selecting a Windows checkbox");
	}
}

//Concrete UI components for macOS
class MacButton implements Button {
	@Override
	public void render() {
		System.out.println("Rendering a macOS button");
	}
}

class MacTextField implements TextField {
	@Override
	public void display() {
		System.out.println("Displaying a macOS text field");
	}
}

class MacCheckbox implements Checkbox {
	@Override
	public void select() {
		System.out.println("Selecting a macOS checkbox");
	}
}

//Abstract factory interface
interface UIFactory {
	Button createButton();

	TextField createTextField();

	Checkbox createCheckbox();
}

//Concrete factory for Windows
class WindowsUIFactory implements UIFactory {
	@Override
	public Button createButton() {
		return new WindowsButton();
	}

	@Override
	public TextField createTextField() {
		return new WindowsTextField();
	}

	@Override
	public Checkbox createCheckbox() {
		return new WindowsCheckbox();
	}
}

//Concrete factory for macOS
class MacUIFactory implements UIFactory {
	@Override
	public Button createButton() {
		return new MacButton();
	}

	@Override
	public TextField createTextField() {
		return new MacTextField();
	}

	@Override
	public Checkbox createCheckbox() {
		return new MacCheckbox();
	}
}

//Client code
public class Ui_Example {
	public static void main(String[] args) {

		String platform = "macOS"; // You determine the platform dynamically

		UIFactory factory;

		if (platform.equals("Windows")) {
			factory = new WindowsUIFactory();
		} else if (platform.equals("macOS")) {
			factory = new MacUIFactory();
		} else {
			throw new UnsupportedOperationException("Platform not supported");
		}

		Button button = factory.createButton();
		TextField textField = factory.createTextField();
		Checkbox checkbox = factory.createCheckbox();

		button.render();
		textField.display();
		checkbox.select();
	}
}
