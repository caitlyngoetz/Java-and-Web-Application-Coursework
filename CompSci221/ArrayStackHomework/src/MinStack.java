import java.util.Arrays;


public class MinStack<Character> implements StackADT<Character> {
	private Character[] stack;
	private int top;
	private final int DEFAULT_CAPACITY=10;
	
	@SuppressWarnings("unchecked")
	public MinStack(){
		top = 0;
		stack = (Character[])new Object[DEFAULT_CAPACITY];
	}
	
	protected void expandCapacity()
	{
		Character[] temp = (Character[])(Arrays.copyOf(stack, stack.length*2));
		stack = temp;
	}

	@Override
	public void push(Character element) {
		if(top ==stack.length) expandCapacity();
		stack[top] = element;
		top++;
	}

	@Override
	public Character pop() {
		if(isEmpty()) throw new EmptyCollectionException("MinStack");
		top--;
		Character retVal = stack[top];
		stack[top] = null;
		return retVal;
	}

	@Override
	public Character peek() {
		if(isEmpty()) throw new EmptyCollectionException("MinStack");
		return stack[top-1];
	}

	@Override
	public boolean isEmpty() {
		return (size() == 0);
	}

	@Override
	public int size() {
		return top;
	}
	
	@Override
	public String toString()
	{if(isEmpty()) return null;
		StringBuilder strBld = new StringBuilder();
		strBld.append("[");
		for(int i = 0; i < top; i++){
			strBld.append(stack[i].toString());
			strBld.append(", ");
		}
		if(isEmpty()){
			strBld.replace(strBld.length() - 2, strBld.length()-1, "");
		}
		strBld.append("]");
		return strBld.toString();
	}

}
