package com.safvan.adpater;

//Target interface
interface ITarget {
	void request();
}

//Adaptee (legacy class that we want use with Modern ITarget interface)
class Adaptee {
	void specificRequest() {
		System.out.println("Legacy functionality: Specific Request");
	}
}

//Adapter
class Adapter implements ITarget {
	private Adaptee adaptee;

	Adapter(Adaptee adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public void request() {
		// Adapting the specificRequest to the Target interface
		adaptee.specificRequest();
	}
}

//Client code using the Target interface
public class Client {
	public static void main(String[] args) {
		// Using the legacy class through the Adapter
		Adaptee legacyObject = new Adaptee();

		ITarget adapter = new Adapter(legacyObject);
		adapter.request();
	}
}