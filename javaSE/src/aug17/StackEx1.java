package aug17;

import java.util.Stack;

public class StackEx1 {

	public static void main(String[] args) {
		String[] groupA = {"���Ű��ź","�����Ʈ","����","���ѹα�"};
		
		Stack<String> stack = new Stack<String>();
		for(String n : groupA)
			stack.push(n);
		
		while(!stack.isEmpty())
			System.out.println(stack.pop());
	}

}
