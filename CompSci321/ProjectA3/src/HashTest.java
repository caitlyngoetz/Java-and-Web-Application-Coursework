import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
/**
 * Driver class for A3
 * Should have three command-line arguments (third is optional)
 * java HashTest <input type> <load factor> <debug level>
 * @author scrabtre
 *
 */
public class HashTest {

	static String error = "Usage: java HashTest <input type> <load factor> [<debug level>]";

	public static void main(String[] args) {

		if(args.length != 2 && args.length != 3){
			System.out.println("Incorrect # of arguments.\n\t" + error);
			System.exit(0);
		}

		double loadFactor;
		int m = 95989;
		int debug = 0;
		int totalNumOfProbes1 = 0;
		int totalNumOfProbes2 = 0;
		int numberElements = 0;
		int same1 = 0;
		int same2 = 0;
		
		

		loadFactor = Double.parseDouble(args[1]);
		if(loadFactor < 0 || loadFactor > 1){
			System.out.println(error);
			System.exit(0);
		}

		if(args.length == 3){
			debug = Integer.parseInt(args[2]);
		}

		if(debug < 0 || debug > 2){
			System.out.println(error);
			System.exit(0);
		}

		System.out.println("A good table size is found: " + m);
		numberElements = (int) (loadFactor * m);

		int input = Integer.parseInt(args[0]);
		if(input == 1){
			System.out.println("Data source type: random number generator");

			HashTable<Integer> linearTable = new HashTable<Integer>(m, true, debug);
			HashTable<Integer> doubleTable = new HashTable<Integer>(m, false, debug);

			Random rand = new Random();
			//algorithm
			for(int i = 0; i < numberElements; i++){
				Integer number = new Integer(Math.abs(rand.nextInt()));
				HashObject<Integer> obj1 = new HashObject<Integer>(number);
				HashObject<Integer> obj2 = new HashObject<Integer>(number);

				int find1 = linearTable.find(obj1.getKey(), obj1);
				int find2 = doubleTable.find(obj2.getKey(), obj2);

				if(find1 == -1){
					if(linearTable.insert(obj1.getKey(), obj1) != -1){
						totalNumOfProbes1 += linearTable.getProbes();
						obj1.setCurrentProbes(linearTable.getProbes());
						obj1.found();
					}else{
						i--;
					}
				}else{
					linearTable.getObj(find1).found();
					same1++;
				}

				if(find2 == -1){
					if(doubleTable.insert(obj2.getKey(), obj2) != -1){
						totalNumOfProbes2 += doubleTable.getProbes();
						obj2.setCurrentProbes(doubleTable.getProbes());
						obj2.found();
					}else{
						i--;
					}
				}else{
					doubleTable.getObj(find2).found();
					same2++;
				}
			}

			double avgNumOfProbes = ((double)totalNumOfProbes1) / ((double) numberElements);
			System.out.println("Using Linear Hashing....");
			System.out.println("Inserted " + numberElements + " elements, of which " + same1 + " duplicates");
			System.out.println("Load factor = " + loadFactor + ", Avg. number of probes " + avgNumOfProbes);

			avgNumOfProbes = ((double)totalNumOfProbes2) / ((double) numberElements);
			System.out.println("Using Double Hashing....");
			System.out.println("Inserted " + numberElements + " elements, of which " + same2 + " duplicates");
			System.out.println("Load factor = " + loadFactor + ", Avg. number of probes " + avgNumOfProbes);

			if(debug > 0){
				System.out.println("Linear Table Output: ");
				System.out.println(linearTable.toString());
				System.out.println("Double Hashing Table Output: ");
				System.out.println(doubleTable.toString());
			}

		}else if(input == 2){
			System.out.println("Data source type: System.currentTimeMillis()");

			HashTable<Long> linearTable = new HashTable<Long>(m, true, debug);
			HashTable<Long> doubleTable = new HashTable<Long>(m, false, debug);

			for(int i = 0; i < numberElements; i++){
				Long num = new Long(System.currentTimeMillis());
				HashObject<Long> obj1 = new HashObject<Long>(num);
				HashObject<Long> obj2 = new HashObject<Long>(num);

				int find1 = linearTable.find(obj1.getKey(), obj1);
				int find2 = doubleTable.find(obj2.getKey(), obj2);

				if(find1 == -1){
					if(linearTable.insert(obj1.getKey(), obj1) != -1){
						totalNumOfProbes1 += linearTable.getProbes();
						obj1.setCurrentProbes(linearTable.getProbes());
						obj1.found();
					}else{
						i--;
					}
				}else{
					linearTable.getObj(find1).found();
					same1++;
				}

				if(find2 == -1){
					if(doubleTable.insert(obj2.getKey(), obj2) != -1){
						totalNumOfProbes2 += doubleTable.getProbes();
						obj2.setCurrentProbes(doubleTable.getProbes());
						obj2.found();
					}else{
						i--;
					}
				}else{
					doubleTable.getObj(find2).found();
					same2++;
				}
			}

			double avgNumOfProbes = ((double)totalNumOfProbes1) / ((double) numberElements);
			System.out.println("Using Linear Hashing....");
			System.out.println("Inserted " + numberElements + " elements, of which " + same1 + " duplicates");
			System.out.println("Load factor = " + loadFactor + ", Avg. number of probes " + avgNumOfProbes);

			avgNumOfProbes = ((double)totalNumOfProbes2) / ((double) numberElements);
			System.out.println("Using Double Hashing....");
			System.out.println("Inserted " + numberElements + " elements, of which " + same2 + " duplicates");
			System.out.println("Load factor = " + loadFactor + ", Avg. number of probes " + avgNumOfProbes);

			if(debug > 0){
				System.out.println("Linear Table Output: ");
				System.out.println(linearTable.toString());
				System.out.println("Double Hashing Table Output: ");
				System.out.println(doubleTable.toString());
			}

		}else if(input == 3){
			System.out.println("Data source type: word-list");

			HashTable<String> linearTable = new HashTable<String>(m, true, debug);
			HashTable<String> doubleTable = new HashTable<String>(m, false, debug);

			File file = new File("word-list");
			Scanner scan = null;
			try {
				scan = new Scanner(file);
			} catch (FileNotFoundException e) {}

			for(int i = 0; i < numberElements; i++){
				String word = scan.nextLine();
				HashObject<String> obj1 = new HashObject<String>(word);
				HashObject<String> obj2 = new HashObject<String>(word);

				int find1 = linearTable.find(obj1.getKey(), obj1);
				int find2 = doubleTable.find(obj2.getKey(), obj2);

				if(find1 == -1){
					if(linearTable.insert(obj1.getKey(), obj1) != -1){
						totalNumOfProbes1 += linearTable.getProbes();
						obj1.setCurrentProbes(linearTable.getProbes());
						obj1.found();
					}else{
						i--;
					}
				}else{
					linearTable.getObj(find1).found();
					same1++;
				}

				if(find2 == -1){
					if(doubleTable.insert(obj2.getKey(), obj2) != -1){
						totalNumOfProbes2 += doubleTable.getProbes();
						obj2.setCurrentProbes(doubleTable.getProbes());
						obj2.found();
					}else{
						i--;
					}
				}else{
					doubleTable.getObj(find2).found();
					same2++;
				}
			}

			scan.close();

			double avgNumOfProbes = ((double)totalNumOfProbes1) / ((double) numberElements);
			System.out.println("Using Linear Hashing....");
			System.out.println("Inserted " + numberElements + " elements, of which " + same1 + " duplicates");
			System.out.println("Load factor = " + loadFactor + ", Avg. number of probes " + avgNumOfProbes);

			avgNumOfProbes = ((double)totalNumOfProbes2) / ((double) numberElements);
			System.out.println("Using Double Hashing....");
			System.out.println("Inserted " + numberElements + " elements, of which " + same2 + " duplicates");
			System.out.println("Load factor = " + loadFactor + ", Avg. number of probes " + avgNumOfProbes);

			if(debug > 0){
				System.out.println("Linear Table Output: ");
				System.out.println(linearTable.toString());
				System.out.println("Double Hashing Table Output: ");
				System.out.println(doubleTable.toString());
			}
		}
	}
}