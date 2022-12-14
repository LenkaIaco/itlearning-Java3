package sk.itlearning.java3.java3a.d.generics;

import java.util.List;

class G0_Adder {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void add(List list) {
		list.add(50);
		list.add(true);
	}
	
}