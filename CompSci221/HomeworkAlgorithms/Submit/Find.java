/**
 * Returns index of a value in an int[] or -1 if it isn't found.
 * @author mvail
 */
public class Find {
static long statements = 0;
	/**
	 * Return index where value is found in array or -1 if not found.
	 * @param array ints where value may be found
	 * @param value int that may be in array
	 * @return index where value is found or -1 if not found
	 */
	public static long find(int[] array, long value) {	
		statements += 2;
		for (int i = 0; i < array.length; i++) {              
			statements += 3;
			if (array[i] == value) {						
				statements += 1;
				return statements;
			}
		}
		
		return statements;
	}
}