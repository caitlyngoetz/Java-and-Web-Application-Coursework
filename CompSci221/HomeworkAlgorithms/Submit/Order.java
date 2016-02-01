/**
 * Takes an array and reorders it so elements are in ascending order.
 * @author mvail
 */
public class Order {
	static long statements = 0;
	/**
	 * Take an int[] and reorganize it so they are in ascending order.
	 * @param array ints that need to be ordered 
	 * @return 
	 */
	public static long order(int[] array) {
        for (int next = 1; next < array.length; next++) { 
            int val = array[next];
            int index = next;
            statements ++;
            while (index > 0 && val < array[index - 1]) {
                array[index] = array[index - 1];
                index--;
                statements++;
            }
            array[index] = val;
        }
        return statements;
	}
}