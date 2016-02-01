import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Test {
	
	public static <T> void main(String[] args) throws FileNotFoundException {
		double nh, nh1, nh2, nr, nr1, nr2;
		nh = nh1 = nh2 = nr = nr1 = nr2 = 0;
		Scanner scan;
		
		
		if(args.length != 3 && args.length != 4){
			System.out.println("Incorrect number of arguments");
			System.exit(0);
		}
		
		if(args.length == 3){
			int maxsize = Integer.parseInt(args[1]);
			File file = new File(args[2]);
			scan = new Scanner(file);
			Cache<String> levelOne = new Cache<String>(maxsize);
			while(scan.hasNext()){
				String c = scan.next();
				if(levelOne.searchCache(c) != null){
					nh++;
					nh1++;
				}
				nr1++;
				nr++;
			}
			System.out.println("First level cache with " + maxsize + " entries has been created");
			System.out.println("..............................");
			double hr = (nh / nr);
			System.out.println("Total number of references:      " + nr);
			System.out.println("Total number of cache hits:      " + nh);
			System.out.println("The global hit ratio         :   " + hr);
			System.out.println("Number of 1st-level cache hits:  " + nh1);

		}
		
		if(args.length == 4){
			int maxsize1 = Integer.parseInt(args[1]);
			int maxsize2 = Integer.parseInt(args[2]);
			File file2 = new File(args[3]);
			scan = new Scanner(file2);
			Cache<String> levelOne2 = new Cache<String>(maxsize1);
			Cache<String> levelTwo = new Cache<String>(maxsize2);
			while(scan.hasNext()){
				String c = scan.next();
				if(levelOne2.searchCache(c) != null){
					nh++;
					nh1++;
					nr1++;
					levelTwo.removeObject(c);
					levelTwo.addObject(c);
				}else if(levelTwo.searchCache(c) != null){
					nh++;
					nh2++;
					nr2++;
				}else{
					nr1++;
					nr2++;
				}
				nr++;
			}
			System.out.println("First level cach with " + maxsize1 + " entries has been created");
			System.out.println("Second level cache with " + maxsize2 + " entries has been created");
			System.out.println("..............................");
			System.out.println(nh1);
			System.out.println(nr1);
			double hr1 = nh1/nr1;
			double hr2 = nh2 / nr2;
			double hr = (nh1 + nh2) / nr1;
			System.out.println("Total number of references:     " + nr);
			System.out.println("Total number of cache hits:     " + nh);
			System.out.println("The global hit ratio         :  " + hr);
			System.out.println("Number of 1st-level cache hits: " + nh1);
			System.out.println("1st-level cache hit ratio    :  " + hr1);
			System.out.println("Number of 2nd-level cache hits: " + nh2);
			System.out.println("2nd-level cache hit ratio     : " + hr2);
		}

	}
}
