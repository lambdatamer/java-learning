public class App {
	public static void main(String[] args) {
		MyInt num = new MyInt();
		for (int i = 0; i < 1000; i++) {
			num.increment();
		}
		System.out.println(num.toString());
	}
}

