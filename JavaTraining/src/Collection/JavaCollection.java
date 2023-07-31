package Collection;

import java.util.LinkedList;

public class JavaCollection {
	public static void main(String args[]) {
		LinkedList<String> list=new LinkedList<String>();
		list.add("a");
		list.add(1,"b");
		list.addLast("t");
		System.out.print(list);
	}

}
