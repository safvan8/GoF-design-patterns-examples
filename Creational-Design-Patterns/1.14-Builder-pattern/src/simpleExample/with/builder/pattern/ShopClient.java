package simpleExample.with.builder.pattern;

public class ShopClient {

	public static void main(String[] args) {

		Phone phone = new PhoneBuilder().setRam(3).setProcessor("Snapdragon").setOs("Android").getPhone();

		System.out.println(phone);

		// all Phone no need to pass all args as like constrcutor,
		// can set values in any order
	}
}
