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
	
	public void ProcessArr(String [][] arr, int cols, int rows)	{
		int st1, st2, en1, en2;
		for (int i = 0; i < cols; i++) {
			for (int j = i + 1; j < cols; j++) {
				if (arr[0][i].equals(arr[0][j]))	{
					for (int i2 = 1; i2 < rows; i2++) {
						st1 = Integer.parseInt(getStartTime(arr[i2][i]));
						en1 = Integer.parseInt(getEndTime(arr[i2][i]));
						st2 = Integer.parseInt(getStartTime(arr[i2][j]));
						en2 = Integer.parseInt(getEndTime(arr[i2][j]));
						
						if (en1 < st2)	{
							//System.out.println(arr[i2][i] + " + " + arr[i2][j]);
							arr[i2][i] = arr[i2][i] + " + " + arr[i2][j];
						}
						else	{
							if (st1 > st2)	{
							st1 = st2;
							}
							if (en1 < en2) {
								en1 = en2;
							}
							//System.out.println(st1 + ":00 - " + en1 + ":00");
							arr[i2][i] = st1 + ":00 - " + en1 + ":00";
						}
						arr[i2][j] = "";
					}
					arr[0][j] = "";
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
