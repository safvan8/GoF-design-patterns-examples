package protectionProxy;

// User interface representing the basic user functionalities
interface User {
	String getUsername();

	String getSensitiveInfo();
}

// RealUser is the actual implementation of the User interface
class RealUser implements User {
	private String username;
	private String sensitiveInfo;

	RealUser(String username, String sensitiveInfo) {
		this.username = username;
		this.sensitiveInfo = sensitiveInfo;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getSensitiveInfo() {
		return sensitiveInfo;
	}
}

// UserProxy is the Protection Proxy controlling access to RealUser
class UserProxy implements User {
	private RealUser realUser;

	UserProxy(String username, String password) {
		// Simulate authentication logic (for simplicity)
		if ("admin".equals(username) && "admin123".equals(password)) {
			realUser = new RealUser(username, "Highly confidential information...");
		} else {
			realUser = new RealUser(username, "Unauthorized to access sensitive information.");
		}
	}

	@Override
	public String getUsername() {
		return realUser.getUsername();
	}

	@Override
	public String getSensitiveInfo() {
		return realUser.getSensitiveInfo();
	}
}

// Client code demonstrating the usage of Protection Proxy
public class ProtectionProxyExample {
	public static void main(String[] args) {
		// Admin access
		User adminUser = new UserProxy("admin", "admin123");
		System.out.println("Admin Access:");
		System.out.println("Username: " + adminUser.getUsername());
		System.out.println("Sensitive Info: " + adminUser.getSensitiveInfo());

		System.out.println();

		// Unauthorized access
		User unauthorizedUser = new UserProxy("guest", "guest123");
		System.out.println("Unauthorized Access:");
		System.out.println("Username: " + unauthorizedUser.getUsername());
		System.out.println("Sensitive Info: " + unauthorizedUser.getSensitiveInfo());
	}
}
