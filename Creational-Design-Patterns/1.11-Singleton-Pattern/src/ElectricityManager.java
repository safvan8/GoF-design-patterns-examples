public class ElectricityManager {

	// Private static instance variable to hold the single instance
	private static ElectricityManager instance = null;

	// Private constructor to prevent external instantiation
	private ElectricityManager() {
	}

	// Public static method to access the single instance
	public static ElectricityManager getInstance() {
		if (instance == null) {
			instance = new ElectricityManager(); // Create the instance if it doesn't exist
		}
		return instance;
	}

	// Method to control the electricity consumption
	public void manageElectricity() {
		System.out.println("Electricity is being managed.");
	}

	// Main method (if applicable) for your program
	public static void main(String[] args) {
		// Your main code can go here (if applicable)
		ElectricityManager manager = ElectricityManager.getInstance(); // Get the single instance
		manager.manageElectricity();
	}
}
