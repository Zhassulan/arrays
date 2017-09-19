package teaching.arrays;

public class ArrayManager {
	
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
	
	public void ProcessArr(String [][] arr, int rows, int cols)	{
		//вспомогательные переменные
		int st1, st2, en1, en2;
		//проход всех строк
		for (int i = 0; i < rows - 1; i++) {
			for (int i1 = i + 1; i1 < rows; i1++) {
				//сравнение 0-го элемента строки с соседними строками
				if (arr[i][0].equalsIgnoreCase(arr[i1][0]))	{
					//сравнение времён, остальных элементов строки
					for (int j = 1; j < cols; j++) {

						st1 = Integer.parseInt(getStartTime(arr[i][j]));
						en1 = Integer.parseInt(getEndTime(arr[i][j]));
						
						st2 = Integer.parseInt(getStartTime(arr[i1][j]));
						en2 = Integer.parseInt(getEndTime(arr[i1][j]));
						
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
					arr[i1][0] = "-";
					}	
				}
		}
	}
	
	private String getStartTime(String time)	{
		String res = null;
		try {
			res = time.substring(0, 2);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	private String getEndTime(String time)	{
		String res = null;
		try {
			res = time.substring(6, 8);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}	
	
	public String [][] NewArr(String [][] arr)	{
		int rows = 0;
		for (int i = 0; i < arr.length; i++) {
			if (!arr[i][0].equals("-"))
				rows += 1;
		}
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
