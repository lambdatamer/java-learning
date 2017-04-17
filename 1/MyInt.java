import java.lang.String;

public class MyInt {
	private int value;

	MyInt() {
		this.value = 0;
	}

	MyInt(MyInt origin) {
		this.value = origin.getValue();
	}

	public int getValue() {
		return this.value;
	}

	public void increment() {
		this.value += 1;
	}

	public void decrement() {
		this.value -= 1;
	}

	public void add(MyInt operand) {
		this.value += operand.getValue();
	}

	// public MyInt add(MyInt operand) {
	// 	MyInt result = new MyInt(this.getValue() + operand.getValue());
	// 	return result;
	// }

	public void substract(MyInt operand) {
		this.value -= operand.getValue();
	}

	// public MyInt substract(MyInt operand) {
	// 	MyInt result = new MyInt(this.getValue() - operand.getValue());
	// 	return result;
	// }

	@Override
	public String toString() {
		return String.valueOf(this.value);
	}
}