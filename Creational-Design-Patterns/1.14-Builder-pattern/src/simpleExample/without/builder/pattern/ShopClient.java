package simpleExample.without.builder.pattern;

public class ShopClient {

	public static void main(String[] args) {

		Phone phone = new Phone("Android", 3, "Snapdragon", 5.5, 5000);

		System.out.println(phone);

		// all Phone creators must pass all constructor args in the correct order

	}
}
