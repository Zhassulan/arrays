package teaching;

import teaching.arrays.*;
import java.util.Collection;
import java.util.ArrayList;

public class Main {

	public static void main(String [] args) {
		ArrayManager am = new ArrayManager();
		String [][] arr = 	{ 
							{"Иванов",      "Маратов",     "Иванов"}, 
							{"08:00-12:00", "08:00-12:00", "08:00-12:00"},
							{"08:00-12:00", "08:00-12:00", "08:00-14:00"},
							{"09:00-16:00", "08:00-12:00", "17:00-19:00"},
							{"08:00-18:00", "08:00-12:00", "09:00-17:00"},
							{"08:00-12:00", "08:00-12:00", "08:00-12:00"},
							{"09:00-13:00", "08:00-12:00", "08:00-13:00"}
							};
		
		//am.printArr(arr);
		am.ProcessArr(arr, arr[0].length, arr.length);
		am.printArr(arr);
		/*
		Collection <String> cs = new ArrayList <String> ();
		Collection <Integer> ci = new ArrayList <Integer> ();
		ci.add(1);
		ci.add(2);
		ci.add(3);
		cs.add("hello");
		cs.add("world");
		am.PrintCollection(cs);
		am.PrintCollection(ci);
		*/
	}

}
