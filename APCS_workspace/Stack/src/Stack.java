import java.util.ArrayList;


public class Stack {
	// Make string to allow for operators.
	ArrayList<String> stack;
	
	Stack() {
		this.stack = new ArrayList<String>();
	}
	
	public void push(String value) {
		this.stack.add(value);
	}
	
	// I believe in the real implementation of a stack the pop()
	// method returns a value as well as removing it.
	public String pop() {
		try {
			// Only able to get last(top) element in the ArrayList to simulate a stack.
			return this.stack.remove(this.stack.size() - 1);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	public int getSize() {
		return this.stack.size();
	}
	
	public boolean isEmpty() {
		if(this.stack.size() <= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	// Real one has an overloaded method that takes an index, not needed for my use.
	public String peek() {
		if (isEmpty()) {
			return "Empty";
		} else {
			return this.stack.get(this.stack.size() - 1);
		}
		
	}
	
}
