import java.util.Scanner;
import java.util.Arrays;

public class TrueFalse {

	static boolean[] flags = null; //boolean type
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter the size of array: ");
		while (true){
			int size = keyboard.nextInt();
			if (size > 0){
				flags = new boolean[size];
				for (int i = 0; i < flags.length; i++){
					if (i == 0){
						flags[0] = true;
					}
					else if (i%2 == 0){
						flags[i] = true;
					}else{
						flags[i] = false;
					}
				}
				System.out.println(Arrays.toString(flags));
			}else{
				System.out.println("Please enter a number greater than 0: ");
			}
		}
	}
}