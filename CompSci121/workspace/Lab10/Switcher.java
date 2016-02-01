import java.util.Scanner;

public class Switcher{
	private static int size1=0;        //this is a private variable
	private static int size2=0;        

	public static boolean switchThem(int []arr1,int []arr2){     //function returns boolean if switching them is only possibility
		//when their size are equal as in different size array it can switch
		//them when u reach end of one array
		int temp = 0,i,t;
		for(i=0,t=0;i<size1&&t<size2;i++,t++){                        //for loop increase the index of array and check of they both reach at
			//end temp=arr1[i
			arr1[i]=arr2[t];
			arr2[t]=temp;
		}
		if(i==size1 && t==size2)                                            //after the ending of for loop if both the index i,t are equal and equal to
			//common size then function returns true value
			return true;
		else
			return false;                                                             //else it returns false that it can't be switched
	}
	public static void main(String agr[]){
		Scanner in = new Scanner(System.in);
		System.out.print("\nEnter size element in Array 1 :");          //getting the size of array 1
		size1=in.nextInt();
		System.out.print("\nEnter size element in Array 2 :");         //getting the size of array 2
		size2=in.nextInt();
		int A[] = new int[size1];
		int B[] = new int[size2];
		System.out.print("\n\nEnter "+size1+" element in Array 1 :\n");    //initializes array 1
		for(int i=0;i<size1;i++){
			System.out.print("\nEnter "+(i+1)+" element of first array : ");
			A[i]=in.nextInt();
		}
		System.out.print("\n\nEnter the "+size2+" elements in Array 2 \n");    //initializes array 2
		for(int i=0;i<size2;i++){
			System.out.print("\nEnter "+(i+1)+" element of second array : ");
			B[i]=in.nextInt();
		}
		boolean t=switchThem(A,B);
		if(t){                                                                 //if it returns true then it prints both switch array
			System.out.print("\n\n "+size1+" element in Array 1 :\n");
			for(int i=0;i<size1;i++)
				System.out.print("\n "+(i+1)+" element of array : "+A[i]);
			System.out.print("\n\n "+size2+" element in Array 2 :\n\n");
			for(int i=0;i<size2;i++)
				System.out.print("\n "+(i+1)+" element of array : "+B[i]);
		}else
			System.out.print("\nSize Not Equal of arrays ");
	}
}