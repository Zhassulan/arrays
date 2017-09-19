package teaching;

import teaching.arrays.*;
import java.util.Collection;
import java.util.ArrayList;

public class Main {

	public static void main(String [] args) {
		ArrayManager am = new ArrayManager();
		String [][] arr = 	{ 
							{"Иванов",  "08:00-12:00", "08:00-12:00", "08:00-12:00", "08:00-12:00", "08:00-12:00"}, 
							{"Маратов", "08:00-12:00", "08:00-12:00", "08:00-12:00", "08:00-12:00", "08:00-12:00"},
							{"Иванов",  "08:00-12:00", "09:00-12:00", "07:00-12:00", "08:00-13:00", "08:00-12:00"},
							{"Маратов", "07:00-11:00", "08:00-13:00", "08:00-12:00", "14:00-19:00", "08:00-12:00"},
							{"Иванов",  "08:00-12:00", "13:00-18:00", "08:00-12:00", "08:00-15:00", "08:00-12:00"}
							};
		
		System.out.println("Before: ");
		am.printArr(arr);
		am.ProcessArr(arr, arr.length, arr[0].length);
		System.out.println("After: ");
		String newarr [][] = am.NewArr(arr) ;
		am.printArr(newarr);
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
