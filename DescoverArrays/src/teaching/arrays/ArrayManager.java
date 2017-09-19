package teaching.arrays;

import java.util.Collection;

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
		int st1, st2, en1, en2;
		for (int i = 0; i < rows; i++) {
			for (int i1 = i + 1; i1 < rows; i1++) {
				if (arr[i][0].equalsIgnoreCase(arr[i1][0]))	{
					for (int j = 1; j < cols; j++) {
						System.out.println(arr[i][j]);
						st1 = Integer.parseInt(getStartTime(arr[i][j]));
						en1 = Integer.parseInt(getEndTime(arr[i][j]));
						
						st2 = Integer.parseInt(getStartTime(arr[i1][j]));
						en2 = Integer.parseInt(getEndTime(arr[i1][j]));
						
						if (en1 < st2)	{
							arr[i][j] = arr[i][j] + " + " + arr[i1][j];
						}
						else	{
							if (st1 > st2)	{
							st1 = st2;
							}
							if (en1 < en2) {
								en1 = en2;
							}
							arr[i][j] = st1 + ":00 - " + en1 + ":00";
						}
						arr[i1][j] = "";
					}
					arr[i1][0] = "";
					}	
				}
		}
	}
	
	String getStartTime(String time)	{
		String res = null;
		try {
			res = time.substring(0, 2);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	String getEndTime(String time)	{
		String res = null;
		try {
			res = time.substring(6, 8);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}	
	
	/*public void PrintCollection(Collection<?> c)	{
		for (Object o : c)	{
			System.out.println(o);
		}
	}*/
}
