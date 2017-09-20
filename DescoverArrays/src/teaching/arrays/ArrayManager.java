package teaching.arrays;

import java.util.Arrays;

/**
 * @author Zhassulan Tokbaev
 * @version 1.0
 * Класс для оперирования над массивами и сопутствующие вспомогательные методы
 * @see ArrayManager
 */

public class ArrayManager {

	/** метод распечатки двумерного массива в виде матрицы
	 * @param String [][] двумерный массив строк
	 * @see printArr
	 */
	public void printArr(String [][] arr)	{
		String str = null;
		for (String[] innArr: arr) {
			str = "";
	        for (String data: innArr) {
	            str = str.concat(data);
	            str = str.concat("\t");
	        }
	        System.out.println(str);
	     }
	}
	
	/** метод начала обработки массива согласно задаче
	 * @param String [][] двумерный массив строк 
	 * @param int rows количество строк массива
	 * @param int cols количество столбцов 
	 * @see ProcessArr
	 */
	public void ProcessArr(String [][] arr, int rows, int cols)	{
		//вспомогательные переменные
		int st1, st2, en1, en2;
		//проход всех строк на предмет поиска одинаковых нулевых элементов
		for (int i = 0; i < rows - 1; i++) {
			for (int i1 = i + 1; i1 < rows; i1++) {
				//сравнение 0-го элемента строки с соседними строками
				if (arr[i][0].equalsIgnoreCase(arr[i1][0]))	{
					//если обнаружили схожий элемент, начинаем сравнение остальные элементов текущих двух строк
					for (int j = 1; j < cols; j++) {
						/*получаем целочисленные значения извлекая час из времени
						 * st1,en1 - начало и конец рабочего дня строки источника
						 * st2,en2 - начало и конец рабочего дня искомой строки
						 * "08:00-12:00" st1-en1
						 * "09:00-13:00" st2-en2
						 */
						
						st1 = Integer.parseInt(getStartTime(arr[i][j]));
						en1 = Integer.parseInt(getEndTime(arr[i][j]));
						
						st2 = Integer.parseInt(getStartTime(arr[i1][j]));
						en2 = Integer.parseInt(getEndTime(arr[i1][j]));
						
						//сравниваем времена
						if (st2 > en1)	{
							//сцепление
							arr[i][j] = arr[i][j] + " + " + arr[i1][j];
						}
						else	{
							boolean b = false;
							if (st1 > st2)	{
								st1 = st2;
								b = true;
							}
							if (en2 > en1) {
								en1 = en2;
								b = true;
							}
							if (b)	{
								//объединение
								String st3 = null;
								String en3 = null;
								if (st1 < 10) st3 = "0" + Integer.toString(st1) + ":00";
								else st3 = Integer.toString(st1) + ":00";
								if (en1 < 10) en3 = "0" + Integer.toString(en1) + ":00";
								else en3 = Integer.toString(en1) + ":00";
								arr[i][j] = st3 + "-" + en3;
							}
						}
					}
					arr[i1][0] = "-"; //помечаем прошедшую строку как обработанную
					}	
				}
		}
	}
	
	/** метод извлечения времени начала рабочего дня
	 * @param String time отрезок рабочего времени в формате "09:00-13:00"
	 * @return String строка час начала рабочего времени 
	 * @see getStartTime
	 */
	private String getStartTime(String time)	{
		String res = null;
		try {
			res = time.substring(0, 2);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	/** метод извлечения времени конца рабочего дня
	 * @param String time отрезок рабочего времени в формате "09:00-13:00"
	 * @return String строка час конца рабочего времени
	 * @see getEndTime
	 */
	private String getEndTime(String time)	{
		String res = null;
		try {
			res = time.substring(6, 8);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}	
	
	/** метод копирования входящего массива в новый возвращаемый массив
	 * @param String [][] arr двумерный массив строкового типа
	 * @return String [][] arr двумерный массив строкового типа
	 * @see NewArr
	 */
	public String [][] NewArr(String [][] arr)	{
		int rows = 0;
		//определяем для нового массива количество строк, в входящем массиве строки не предназначенные для обработки мы помечали знаком тире "-"
		for (int i = 0; i < arr.length; i++) {
			if (!arr[i][0].equals("-"))
				rows += 1;
		}
		//определяем количество столбцов для новог массива
		int cols = arr[0].length;
		int m = 0;
		String [][] newarr = new String [rows][cols];
		for (int i = 0; i < rows; i++) {
			if (!arr[i][0].equals("-"))	{
				//заполнение нового массива
				for (int j = 0; j < cols; j++) {
					newarr[m][j] = arr[i][j];
				}
				m += 1;
				}
			}
		return newarr;
	}
}
