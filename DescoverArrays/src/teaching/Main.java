package teaching;

import teaching.arrays.*;
import java.util.Collection;
import java.util.ArrayList;

/**
 * Точка входа в приложение
 * @author Zhassulan Tokbaev
 * @version 1.0
 * @see Main
*/

public class Main {
	public static void main(String [] args) {
		ArrayManager am = new ArrayManager();
		//Объявляем двумерный массив типа строка, первый элемент ФИО, остальные - расписание рабочего дня
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
	}

}
