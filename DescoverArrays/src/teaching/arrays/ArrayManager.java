package teaching.arrays;

import java.util.Collection;

public class ArrayManager {
	
	private String [][] arr;

	public void printArr(String [][] arr)	{
		String str = null;
		for (String[] innArr: arr) {
			str = "";
	        for	(String data: innArr) {
	        	str = str.concat(data);
				str = str.concat(" ");
				if (IfTime(data))
					{
					System.out.println("Start time: " + getStartTime(data));
					System.out.println("End time: " + getEndTime(data));
					}
	        }
	        //System.out.println(str);
	     }
	}
	
	public void ProcessArr(String [][] arr, int cols, int rows)	{
		int st1, st2, en1, en2;
		for (int i = 0; i < cols; i++) {
			for (int j = i + 1; j < cols; j++) {
				if (arr[0][i] == arr[0][j])
					{
					//this.arr.
					for (int i2 = 1; i2 < rows; i2++) {
						st1 = Integer.parseInt(getStartTime(arr[i2][i]));
						en1 = Integer.parseInt(getEndTime(arr[i2][i]));
						st2 = Integer.parseInt(getStartTime(arr[i2][j]));
						en2 = Integer.parseInt(getEndTime(arr[i2][j]));
					}
					}	
				}
		}
	}
	
	boolean IfTime(String time)	{
		boolean b = false;
		if (time.indexOf(":") != -1) b = true;
		return b;
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
	
	public void PrintCollection(Collection<?> c)	{
		for (Object o : c)	{
			System.out.println(o);
		}
	}
}
