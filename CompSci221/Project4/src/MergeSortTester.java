import java.util.Comparator;
import java.util.Iterator;

/**
 * A unit test class for DoubleLinkedListADT. 
 * @author cgoetz: testing framework and empty list scenario
 */
public class MergeSortTester {
	private int passes = 0;
	private int failures = 0;
	private int total = 0;

	/**
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		// to avoid every method being static
		MergeSortTester tester = new MergeSortTester();
		tester.runTests();
	}

	/**
	 * Returns an DoubleLinkedListADT so the implementation can be changed in
	 * this one location rather than in every test.
	 * 
	 * @return a new DoubleLinkedListADT
	 */
	private WrappedDLL<Integer> newList() {
		return new WrappedDLL<Integer>();
	}
	/**
	 * Returns a Comparator so the implementation can be done in this one location
	 * rather than in every test
	 * 
	 * @return a new Comparator
	 */
	private class MyComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {			
			return o1-o2;
		}
	}
	
	/**
	 * Returns if two lists are equal to each other for testing purposes
	 * At this location so that it can be used in every test
	 * @param test
	 * @param expected
	 * @return test result
	 */
	private Boolean testResult(WrappedDLL<Integer> test, WrappedDLL<Integer> expected){
		Iterator<Integer> expected_it = expected.iterator();
		
		for(Integer i : test)
			if(!i.equals(expected_it.next()))
				return false;
	
		return true;
	}

	/**
	 * Print test results in a consistent format
	 * 
	 * @param testDesc
	 *            description of the test
	 * @param result
	 *            indicates if the test passed or failed
	 */
	private void printTest(String testDesc, boolean result) {
		total++;
		if (result) {
			passes++;
		} else {
			failures++;
		}
		System.out.printf("%-46s\t%s\n", testDesc, (result ? "   PASS"
				: "***FAIL***"));
	}

	/** Print a final summary */
	private void printFinalSummary() {
		System.out.printf("\nTotal Tests: %d,  Passed: %d,  Failed: %d\n",
				total, passes, failures);
	}

	/**
	 * Run tests to confirm required functionality from list constructors and
	 * methods
	 */
	private void runTests() {
		// //////////////////
		// EMPTY LIST TESTS
		// //////////////////
		printTest("emptyListTestSortNatural", emptyListTestSortNatural());
		printTest("emptyListTestSortComparator", emptyListTestSortComparator());
		printTest("emptyListTestSmallestNatural", emptyListTestSmallestNatural());
		printTest("emptyListTestSmallestComparator", emptyListTestSmallestComparator());
		printTest("emptyListTestLargestNatural", emptyListTestLargestNatural());
		printTest("emptyListTestLargestComparator", emptyListTestLargestComparator());

		// /////////////////
		// ONE ELEMENT LIST
		// /////////////////
		printTest("oneElementListTestSortNatural", oneElementListTestSortNatural());
		printTest("oneElementListTestSortComparator", oneElementListTestSortComparator());
		printTest("oneElementListTestSmallestNatural", oneElementListTestSmallestNatural());
		printTest("oneElementListTestSmallestComparator", oneElementListTestSmallestComparator());
		printTest("oneElementListTestLargestNatural", oneElementListTestLargestNatural());
		printTest("oneElementListTestLargestComparator", oneElementListTestLargestComparator());

		// /////////////////
		// TWO ELEMENT LIST
		// ////////////////
		printTest("twoElementListTestSortNatural", twoElementListTestSortNatural());
		printTest("twoElementListTestSortNaturalReversed", twoElementListSortNaturalReversed());
		printTest("twoElementListTestSortComparator", twoElementListTestSortComparator());
		printTest("twoElementListTestSortComparatorReversed", twoElementListTestSortComparatorReversed());
		printTest("twoElementListTestSmallestNatural", twoElementListTestSmallestNatural());
		printTest("twoElementListTestSmallestNaturalReversed", twoElementListTestSmallestNaturalReversed());
		printTest("twoElementListTestSmallestComparator", twoElementListTestSmallestComparator());
		printTest("twoElementListTestSmallestComparatorReversed", twoElementListTestSmallestComparatorReversed());
		printTest("twoElementListTestLargestNatural", twoElementListTestLargestNatural());
		printTest("twoElementListTestLargestNaturalReversed", twoElementListTestLargestNaturalReversed());
		printTest("twoElementListTestLargestComparator", twoElementListTestLargestComparator());
		printTest("twoElementListTestLargestComparatoReversed", twoElementListTestLargestComparatorReversed());

		// ///////////////////
		// THREE ELEMENT LIST
		// ///////////////////
		printTest("threeElementListTestSortNatural", threeElementListTestSortNatural());
		printTest("threeElementListTestSortNaturalMixed1", threeElementListTestSortNaturalMixed1());
		printTest("threeElementListTestSortNaturalMixed2", threeElementListTestSortNaturalMixed2());
		printTest("threeElementListTestSortNaturalReversed", threeElementListTestSortNaturalReversed());
		printTest("threeElementListTestSortComparator", threeElementListTestSortComparator());
		printTest("threeElementListTestSortComparatorMixed1", threeElementListTestSortComparatorMixed1());
		printTest("threeElementListTestSortComparatorMixed2", threeElementListTestSortComparatorMixed2());
		printTest("threeElementListTestSortComparatorReversed", threeElementListTestSortComparatorReversed());
		printTest("threeElementListTestSmallestNatural", threeElementListTestSmallestNatural());
		printTest("threeElementListTestSmallestNaturalMixed1", threeElementListTestSmallestNaturalMixed1());
		printTest("threeElementListTestSmallestNaturalMixed2", threeElementListTestSmallestNaturalMixed2());
		printTest("threeElementListTestSmallestNaturalReversed", threeElementListTestSmallestNaturalReversed());
		printTest("threeElementListTestSmallestComparator", threeElementListTestSmallestComparator());
		printTest("threeElementListTestSmallestComparatorMixed1", threeElementListTestSmallestComparatorMixed1());
		printTest("threeElementListTestSmallestComparatorMixed2", threeElementListTestSmallestComparatorMixed2());
		printTest("threeElementListTestSmallestComparatorReversed", threeElementListTestSmallestComparatorReversed());
		printTest("threeElementListTestLargestNatural", threeElementListTestLargestNatural());
		printTest("threeElementListTestLargestNaturalMixed1", threeElementListTestLargestNaturalMixed1());
		printTest("threeElementListTestLargestNaturalMixed2", threeElementListTestLargestNaturalMixed2());
		printTest("threeElementListTestLargestNaturalReversed", threeElementListTestLargestNaturalReversed());
		printTest("threeElementListTestLargestComparator", threeElementListTestLargestComparator());
		printTest("threeElementListTestLargestComparatorMixed1", threeElementListTestLargestComparatorMixed1());
		printTest("threeElementListTestLargestComparatorMixed2", threeElementListTestLargestComparatorMixed2());
		printTest("threeElementListTestLargestComparatorReversed", threeElementListTestLargestComparatorReversed());

		// ////////////////////
		// TEN ELEMENT LIST
		// ////////////////////
		printTest("tenElementListTestSortNatural", tenElementListTestSortNatural());
		printTest("tenElementListTestSortNaturalMixed", tenElementListSortNaturalMixed());
		printTest("tenElementListTestSortNaturalReversed", tenElementListSortNaturalReversed());
		printTest("tenElementListTestSortComparator", tenElementListTestSortComparator());
		printTest("tenElementListTestSortComparatorMixed", tenElementListTestSortComparatorMixed());
		printTest("tenElementListTestSortComparatorReversed", tenElementListTestSortComparatorReversed());
		printTest("tenElementListTestSmallestNatural", tenElementListTestSmallestNatural());
		printTest("tenElementListTestSmallestNaturalMixed", tenElementListTestSmallestNaturalMixed());
		printTest("tenElementListTestSmallestNaturalReversed", tenElementListTestSmallestNaturalReversed());
		printTest("tenElementListTestSmallestComparator", tenElementListTestSmallestComparator());
		printTest("tenElementListTestSmallestComparatorMixed", tenElementListTestSmallestComparatorMixed());
		printTest("tenElementListTestSmallestComparatorReversed", tenElementListTestSmallestComparatorReversed());
		printTest("tenElementListTestLargestNatural", tenElementListTestLargestNatural());
		printTest("tenElementListTestLargestNaturalMixed", tenElementListTestLargestNaturalMixed());
		printTest("tenElementListTestLargestNaturalReversed", tenElementListTestLargestNaturalReversed());
		printTest("tenElementListTestLargestComparator", tenElementListTestLargestComparator());
		printTest("tenElementListTestLargestComparatorMixed", tenElementListTestLargestComparatorMixed());
		printTest("tenElementListTestLargestComparatorReversed", tenElementListTestLargestComparatorReversed());
		printTest("tenElementListTestSortNaturalSame", tenElementListTestSortNaturalSame());
		printTest("tenElementListTestSortComparatorSame", tenElementListTestSortComparatorSame());
		printTest("tenElmentListTestSortNaturalDouble", tenElementListTestSortNaturalDouble());
		printTest("tenElementListTestSortComparatorDouble", tenElementListTestSortComparatorDouble());

		// ///////////////
		// final verdict
		// ///////////////
		printFinalSummary();
	}

	// ///////////////////
	// EMPTY LIST TESTS TODO
	// ///////////////////

	/** @return test success */
	private boolean emptyListTestSortNatural(){
		WrappedDLL<Integer> list = newList();
		WrappedDLL<Integer> expected = newList();
	
		try{
			MergeSort.sort(list);
			return testResult(list, expected);
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"emptyListTestSortNatural", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean emptyListTestSortComparator(){
		WrappedDLL<Integer> expected = newList();
		WrappedDLL<Integer> list = newList();
		
		try{
			MergeSort.sort(list, new MyComparator());
			return testResult(list, expected);
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"emptyListTestSortComparator", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean emptyListTestSmallestNatural(){
		WrappedDLL<Integer> list = newList();
		try{
			if(MergeSort.findSmallest(list) != null) return false;
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"emptyListTestSmallestNatural", e.toString());
			return false;
		}
		return true;
	}

	/** @return test succes */
	private boolean emptyListTestSmallestComparator(){
		WrappedDLL<Integer> list = newList();
		try{
			if(MergeSort.findSmallest(list, new MyComparator()) != null) return false;
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"emptyListTestSmallestComparator", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean emptyListTestLargestNatural(){
		WrappedDLL<Integer> list = newList();
		try{
			if(MergeSort.findLargest(list) != null) return false;
		}catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"emptyListTestLargestNatural", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean emptyListTestLargestComparator(){
		WrappedDLL<Integer> list = newList();
		try{
			if(MergeSort.findLargest(list, new MyComparator()) != null) return false;
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"emptyListTestLargestComparator", e.toString());
			return false;
		}
		return true;
	}

	///////////////////
	//ONE ELEMENT LIST TODO
	//////////////////

	/** @return test success */
	private boolean oneElementListTestSortNatural(){
		WrappedDLL<Integer> list = newList();
		WrappedDLL<Integer> expected = newList();
		Integer i = new Integer(1);
		list.add(i);
		expected.add(i);
		try{
			MergeSort.sort(list);
			return testResult(list, expected);
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"oneElementListTestSortNatural", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneElementListTestSortComparator(){
		WrappedDLL<Integer> list = newList();
		WrappedDLL<Integer> expected = newList();
		Integer i = new Integer(1);
		list.add(i);
		expected.add(i);
		try{
			MergeSort.sort(list, new MyComparator());
			return testResult(list,expected);
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"oneElementListTestSortComparator", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneElementListTestSmallestNatural(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		list.add(i);
		try{
			if(MergeSort.findSmallest(list) != i) return false;
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"oneElementListTestSmallestNatural", e.toString());
			return false;
		}
		return true;
	}

	/** @return test succes */
	private boolean oneElementListTestSmallestComparator(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		list.add(i);
		try{
			if(MergeSort.findSmallest(list, new MyComparator()) != i) return false;
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"oneElementListTestSmallestComparator", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean oneElementListTestLargestNatural(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		list.add(i);
		try{
			if(MergeSort.findLargest(list) != i) return false;
		}catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneElementListTestLargestNatural", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean oneElementListTestLargestComparator(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		list.add(i);
		try{
			if(MergeSort.findLargest(list, new MyComparator()) != i) return false;
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"oneElementListTestLargestComparator", e.toString());
			return false;
		}
		return true;
	}
	///////////////////
	//TWO ELEMENT LIST TODO
	//////////////////

	/** @return test success */
	private boolean twoElementListTestSortNatural(){
		WrappedDLL<Integer> expected = newList();
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.add(i);
		list.add(j);
		expected.add(i);
		expected.add(j);
		try{
			MergeSort.sort(list);
			return testResult(list, expected);
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"twoElementListTestSortNatural", e.toString());
			return false;
		}
		}

	/** @return test success */
	private boolean twoElementListSortNaturalReversed(){
		WrappedDLL<Integer> list = newList();
		WrappedDLL<Integer> expected = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.add(j);
		list.add(i);
		expected.add(i);
		expected.add(j);
		try{
			MergeSort.sort(list);
			return testResult(list, expected);
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"twoElementListSortNaturalReversed", e.toString());
			return false;
		}
	}


	/** @return test success */
	private boolean twoElementListTestSortComparator(){
		WrappedDLL<Integer> expected = newList();
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.add(i);
		list.add(j);
		expected.add(i);
		expected.add(j);
		try{
			MergeSort.sort(list, new MyComparator());
			return testResult(list, expected);
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"twoElementListTestSortComparator", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoElementListTestSortComparatorReversed(){
		WrappedDLL<Integer> expected = newList();
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.add(j);
		list.add(i);
		expected.add(i);
		expected.add(j);
		try{
			MergeSort.sort(list, new MyComparator());
			return testResult(list, expected);
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"twoElementListTestSortComparatorReversed", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoElementListTestSmallestNatural(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.add(i);
		list.add(j);
		try{
			if(MergeSort.findSmallest(list) != i) return false;
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"twoElementListTestSmallestNatural", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean twoElementListTestSmallestNaturalReversed(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.add(j);
		list.add(i);
		try{
			if(MergeSort.findSmallest(list) != i) return false;
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"twoElementListTestSmallestNaturalReversed", e.toString());
			return false;
		}
		return true;
	}

	/** @return test succes */
	private boolean twoElementListTestSmallestComparator(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.add(i);
		list.add(j);
		try{
			if(MergeSort.findSmallest(list, new MyComparator()) != i) return false;
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"twoElementListTestSmallestComparator", e.toString());
			return false;
		}
		return true;
	}

	/** @return test succes */
	private boolean twoElementListTestSmallestComparatorReversed(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.add(j);
		list.add(i);
		try{
			if(MergeSort.findSmallest(list, new MyComparator()) != i) return false;
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"twoElementListTestSmallestComparatorReversed", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean twoElementListTestLargestNatural(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.add(i);
		list.add(j);
		try{
			if(MergeSort.findLargest(list) != j) return false;
		}catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoElementListTestLargestNatural", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean twoElementListTestLargestNaturalReversed(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.add(j);
		list.add(i);
		try{
			if(MergeSort.findLargest(list) != j) return false;
		}catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoElementListTestLargestNaturalReversed", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean twoElementListTestLargestComparator(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.add(i);
		list.add(j);
		try{
			if(MergeSort.findLargest(list, new MyComparator()) != j) return false;
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"twoElementListTestLargestComparator", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean twoElementListTestLargestComparatorReversed(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.add(j);
		list.add(i);
		try{
			if(MergeSort.findLargest(list, new MyComparator()) != j) return false;
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"twoElementListTestLargestComparatorReversed", e.toString());
			return false;
		}
		return true;
	}

	/////////////////////////
	//THREE ELEMENT LIST TODO
	/////////////////////////

	/** @return test success */
	private boolean threeElementListTestSortNatural(){
		WrappedDLL<Integer> expected = newList();
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(i);
		list.add(j);
		list.add(k);
		expected.add(i);
		expected.add(j);
		expected.add(k);
		try{
			MergeSort.sort(list);
			return testResult(list,expected);
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"threeElementListTestSortNatural", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeElementListTestSortNaturalMixed1(){
		WrappedDLL<Integer> list = newList();
		WrappedDLL<Integer> expected = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(j);
		list.add(k);
		list.add(i);
		expected.add(i);
		expected.add(j);
		expected.add(k);
		try{
			MergeSort.sort(list);
			return testResult(list, expected);
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"threeElementListTestSortNaturalMixed1", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeElementListTestSortNaturalMixed2(){
		WrappedDLL<Integer> list = newList();
		WrappedDLL<Integer> expected = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(k);
		list.add(i);
		list.add(j);
		expected.add(i);
		expected.add(j);
		expected.add(k);
		try{
			MergeSort.sort(list);
			return testResult(list, expected);
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"threeElementListTestSortNaturalMixed2", e.toString());
			return false;
		}
	}
	
	/** @return test success */
	private boolean threeElementListTestSortNaturalReversed(){
		WrappedDLL<Integer> list = newList();
		WrappedDLL<Integer> expected = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(k);
		list.add(j);
		list.add(i);
		expected.add(i);
		expected.add(j);
		expected.add(k);
		try{
			MergeSort.sort(list);
			return testResult(list, expected);
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"threeElementListTestSortNaturalReversed", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeElementListTestSortComparator(){
		WrappedDLL<Integer> list = newList();
		WrappedDLL<Integer> expected = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(i);
		list.add(j);
		list.add(k);
		expected.add(i);
		expected.add(j);
		expected.add(k);
		try{
			MergeSort.sort(list, new MyComparator());
			return testResult(list, expected);
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"threeElementListTestSortComparator", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeElementListTestSortComparatorMixed1(){
		WrappedDLL<Integer> list = newList();
		WrappedDLL<Integer> expected = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(j);
		list.add(k);
		list.add(i);
		expected.add(i);
		expected.add(j);
		expected.add(k);
		try{
			MergeSort.sort(list, new MyComparator());
			return testResult(list, expected);
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"threeElementListTestSortComparatorMixed1", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeElementListTestSortComparatorMixed2(){
		WrappedDLL<Integer> list = newList();
		WrappedDLL<Integer> expected = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(k);
		list.add(i);
		list.add(j);
		expected.add(i);
		expected.add(j);
		expected.add(k);
		try{
			MergeSort.sort(list, new MyComparator());
			return testResult(list, expected);
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"threeElementListTestSortComparatorMixed2", e.toString());
			return false;
		}
	}
	
	/** @return test success */
	private boolean threeElementListTestSortComparatorReversed(){
		WrappedDLL<Integer> list = newList();
		WrappedDLL<Integer> expected = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(k);
		list.add(j);
		list.add(i);
		expected.add(i);
		expected.add(j);
		expected.add(k);
		try{
			MergeSort.sort(list);
			return testResult(list, expected);
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"threeElementListTestSortComparatorReversed", e.toString());
			return false;
		}
		
	}

	/** @return test success */
	private boolean threeElementListTestSmallestNatural(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(i);
		list.add(j);
		list.add(k);
		try{
			if(MergeSort.findSmallest(list) != i) return false;
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"threeElementListTestSmallestNatural", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean threeElementListTestSmallestNaturalMixed1(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(j);
		list.add(k);
		list.add(i);
		try{
			if(MergeSort.findSmallest(list) != i) return false;
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"threeElementListTestSmallestNaturalMixed1", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean threeElementListTestSmallestNaturalMixed2(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(k);
		list.add(i);
		list.add(j);
		try{
			if(MergeSort.findSmallest(list) != i) return false;
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"threeElementListTestSmallestNaturalMixed2", e.toString());
			return false;
		}
		return true;
	}
	
	/** @return test success */
	private boolean threeElementListTestSmallestNaturalReversed(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(k);
		list.add(j);
		list.add(i);
		try{
			MergeSort.sort(list);
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"threeElementListTestSmallestNaturalReversed", e.toString());
			return false;
		}
		return true;
	}

	/** @return test succes */
	private boolean threeElementListTestSmallestComparator(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(i);
		list.add(j);
		list.add(k);
		try{
			if(MergeSort.findSmallest(list, new MyComparator()) != i) return false;
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"threeElementListTestSmallestComparator", e.toString());
			return false;
		}
		return true;
	}

	/** @return test succes */
	private boolean threeElementListTestSmallestComparatorMixed1(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(j);
		list.add(k);
		list.add(i);
		try{
			if(MergeSort.findSmallest(list, new MyComparator()) != i) return false;
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"threeElementListTestSmallestComparatorMixed1", e.toString());
			return false;
		}
		return true;
	}

	/** @return test succes */
	private boolean threeElementListTestSmallestComparatorMixed2(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(k);
		list.add(i);
		list.add(j);
		try{
			if(MergeSort.findSmallest(list, new MyComparator()) != i) return false;
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"threeElementListTestSmallestComparatorMixed2", e.toString());
			return false;
		}
		return true;
	}
	
	/** @return test success */
	private boolean threeElementListTestSmallestComparatorReversed(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(k);
		list.add(j);
		list.add(i);
		try{
			MergeSort.sort(list);
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"threeElementListTestSmallestComparatorReversed", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean threeElementListTestLargestNatural(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(i);
		list.add(j);
		list.add(k);
		try{
			if(MergeSort.findLargest(list) != k) return false;
		}catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeElementListTestLargestNatural", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean threeElementListTestLargestNaturalMixed1(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(j);
		list.add(k);
		list.add(i);
		try{
			if(MergeSort.findLargest(list) != k) return false;
		}catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeElementListTestLargestNaturalMixed1", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean threeElementListTestLargestNaturalMixed2(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(k);
		list.add(i);
		list.add(j);
		try{
			if(MergeSort.findLargest(list) != k) return false;
		}catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeElementListTestLargestNaturalMixed2", e.toString());
			return false;
		}
		return true;
	}
	
	/** @return test success */
	private boolean threeElementListTestLargestNaturalReversed(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(k);
		list.add(j);
		list.add(i);
		try{
			MergeSort.sort(list);
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"threeElementListTestLargestNaturalReversed", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean threeElementListTestLargestComparator(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(i);
		list.add(j);
		list.add(k);
		try{
			if(MergeSort.findLargest(list, new MyComparator()) != k) return false;
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"threeElementListTestLargestComparator", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean threeElementListTestLargestComparatorMixed1(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(j);
		list.add(k);
		list.add(i);
		try{
			if(MergeSort.findLargest(list, new MyComparator()) != k) return false;
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"threeElementListTestLargestComparatorMixed1", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean threeElementListTestLargestComparatorMixed2(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(k);
		list.add(i);
		list.add(j);
		try{
			if(MergeSort.findLargest(list, new MyComparator()) != k) return false;
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"threeElementListTestLargestComparatorMixed2", e.toString());
			return false;
		}
		return true;
	}
	
	/** @return test success */
	private boolean threeElementListTestLargestComparatorReversed(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(k);
		list.add(j);
		list.add(i);
		try{
			MergeSort.sort(list);
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"threeElementListTestLargestComparatorReversed", e.toString());
			return false;
		}
		return true;
	}

	///////////////////
	//TEN ELEMENT LIST TODO
	//////////////////

	/** @return test success */
	private boolean tenElementListTestSortNatural(){
		WrappedDLL<Integer> list = newList();
		WrappedDLL<Integer> expected = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		Integer n = new Integer(6);
		Integer o = new Integer(7);
		Integer p = new Integer(8);
		Integer q = new Integer(9);
		Integer r = new Integer(10);
		list.add(i);
		list.add(j);
		list.add(k);
		list.add(l);
		list.add(m);
		list.add(n);
		list.add(o);
		list.add(p);
		list.add(q);
		list.add(r);
		expected.add(i);
		expected.add(j);
		expected.add(k);
		expected.add(l);
		expected.add(m);
		expected.add(n);
		expected.add(o);
		expected.add(p);
		expected.add(q);
		expected.add(r);
		try{
			MergeSort.sort(list);
			return testResult(list, expected);
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"tenElementListTestSortNatural", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean tenElementListSortNaturalMixed(){
		WrappedDLL<Integer> list = newList();
		WrappedDLL<Integer> expected = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		Integer n = new Integer(6);
		Integer o = new Integer(7);
		Integer p = new Integer(8);
		Integer q = new Integer(9);
		Integer r = new Integer(10);
		list.add(m);
		list.add(k);
		list.add(o);
		list.add(i);
		list.add(q);
		list.add(p);
		list.add(j);
		list.add(r);
		list.add(n);
		list.add(l);
		expected.add(i);
		expected.add(j);
		expected.add(k);
		expected.add(l);
		expected.add(m);
		expected.add(n);
		expected.add(o);
		expected.add(p);
		expected.add(q);
		expected.add(r);
		try{
			MergeSort.sort(list);
			return testResult(list, expected);
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"tenElementListSortNaturalMixed", e.toString());
			return false;
		}
	}
	
	/** @return test success */
	private boolean tenElementListSortNaturalReversed(){
		WrappedDLL<Integer> list = newList();
		WrappedDLL<Integer> expected = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		Integer n = new Integer(6);
		Integer o = new Integer(7);
		Integer p = new Integer(8);
		Integer q = new Integer(9);
		Integer r = new Integer(10);
		list.add(r);
		list.add(q);
		list.add(p);
		list.add(o);
		list.add(n);
		list.add(m);
		list.add(l);
		list.add(k);
		list.add(j);
		list.add(i);
		expected.add(i);
		expected.add(j);
		expected.add(k);
		expected.add(l);
		expected.add(m);
		expected.add(n);
		expected.add(o);
		expected.add(p);
		expected.add(q);
		expected.add(r);
		try{
			MergeSort.sort(list);
			return testResult(list, expected);
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"tenElementListSortNaturalReversed", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean tenElementListTestSortComparator(){
		WrappedDLL<Integer> list = newList();
		WrappedDLL<Integer> expected = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		Integer n = new Integer(6);
		Integer o = new Integer(7);
		Integer p = new Integer(8);
		Integer q = new Integer(9);
		Integer r = new Integer(10);
		list.add(i);
		list.add(j);
		list.add(k);
		list.add(l);
		list.add(m);
		list.add(n);
		list.add(o);
		list.add(p);
		list.add(q);
		list.add(r);
		expected.add(i);
		expected.add(j);
		expected.add(k);
		expected.add(l);
		expected.add(m);
		expected.add(n);
		expected.add(o);
		expected.add(p);
		expected.add(q);
		expected.add(r);
		try{
			MergeSort.sort(list, new MyComparator());
			return testResult(list, expected);
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"tenElementListTestSortComparator", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean tenElementListTestSortComparatorMixed(){
		WrappedDLL<Integer> list = newList();
		WrappedDLL<Integer> expected = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		Integer n = new Integer(6);
		Integer o = new Integer(7);
		Integer p = new Integer(8);
		Integer q = new Integer(9);
		Integer r = new Integer(10);
		list.add(m);
		list.add(k);
		list.add(o);
		list.add(i);
		list.add(q);
		list.add(p);
		list.add(j);
		list.add(r);
		list.add(n);
		list.add(l);
		expected.add(i);
		expected.add(j);
		expected.add(k);
		expected.add(l);
		expected.add(m);
		expected.add(n);
		expected.add(o);
		expected.add(p);
		expected.add(q);
		expected.add(r);
		try{
			MergeSort.sort(list, new MyComparator());
			return testResult(list, expected);
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"tenElementListTestSortComparatorMixed", e.toString());
			return false;
		}
	}
	
	/** @return test success */
	private boolean tenElementListTestSortComparatorReversed(){
		WrappedDLL<Integer> list = newList();
		WrappedDLL<Integer> expected = newList();
		
		for(int i = 9; i >= 0; i--)
			list.add(new Integer(i));
		
		for(int i = 0; i < 10; i++)
			expected.add(new Integer(i));
		
		try{
			MergeSort.sort(list, new MyComparator());
			return testResult(list, expected);
			
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"tenElementListTestSortComparatorReversed", e.toString());
			return false;
		}
	}


	/** @return test success */
	private boolean tenElementListTestSmallestNatural(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		Integer n = new Integer(6);
		Integer o = new Integer(7);
		Integer p = new Integer(8);
		Integer q = new Integer(9);
		Integer r = new Integer(10);
		list.add(i);
		list.add(j);
		list.add(k);
		list.add(l);
		list.add(m);
		list.add(n);
		list.add(o);
		list.add(p);
		list.add(q);
		list.add(r);
		try{
			if(MergeSort.findSmallest(list) != i) return false;
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"tenElementListTestSmallestNatural", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean tenElementListTestSmallestNaturalMixed(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		Integer n = new Integer(6);
		Integer o = new Integer(7);
		Integer p = new Integer(8);
		Integer q = new Integer(9);
		Integer r = new Integer(10);
		list.add(m);
		list.add(k);
		list.add(o);
		list.add(i);
		list.add(q);
		list.add(p);
		list.add(j);
		list.add(r);
		list.add(n);
		list.add(l);
		try{
			if(MergeSort.findSmallest(list) != i) return false;
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"tenElementListTestSmallestNaturalMixed", e.toString());
			return false;
		}
		return true;
	}
	
	/** @return test success */
	private boolean tenElementListTestSmallestNaturalReversed(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		Integer n = new Integer(6);
		Integer o = new Integer(7);
		Integer p = new Integer(8);
		Integer q = new Integer(9);
		Integer r = new Integer(10);
		list.add(r);
		list.add(q);
		list.add(p);
		list.add(o);
		list.add(n);
		list.add(m);
		list.add(l);
		list.add(k);
		list.add(j);
		list.add(i);
		try{
			if(MergeSort.findSmallest(list) != i) return false;
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"tenElementListTestSmallestNaturalReversed", e.toString());
			return false;
		}
		return true;
	}

	/** @return test succes */
	private boolean tenElementListTestSmallestComparator(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		Integer n = new Integer(6);
		Integer o = new Integer(7);
		Integer p = new Integer(8);
		Integer q = new Integer(9);
		Integer r = new Integer(10);
		list.add(i);
		list.add(j);
		list.add(k);
		list.add(l);
		list.add(m);
		list.add(n);
		list.add(o);
		list.add(p);
		list.add(q);
		list.add(r);
		try{
			if(MergeSort.findSmallest(list, new MyComparator()) != i) return false;
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"tenElementListTestSmallestComparator", e.toString());
			return false;
		}
		return true;
	}

	/** @return test succes */
	private boolean tenElementListTestSmallestComparatorMixed(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		Integer n = new Integer(6);
		Integer o = new Integer(7);
		Integer p = new Integer(8);
		Integer q = new Integer(9);
		Integer r = new Integer(10);
		list.add(m);
		list.add(k);
		list.add(o);
		list.add(i);
		list.add(q);
		list.add(p);
		list.add(j);
		list.add(r);
		list.add(n);
		list.add(l);
		try{
			if(MergeSort.findSmallest(list, new MyComparator()) != i) return false;
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"tenElementListTestSmallestComparatorMixed", e.toString());
			return false;
		}
		return true;
	}

	/** @return test succes */
	private boolean tenElementListTestSmallestComparatorReversed(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		Integer n = new Integer(6);
		Integer o = new Integer(7);
		Integer p = new Integer(8);
		Integer q = new Integer(9);
		Integer r = new Integer(10);
		list.add(r);
		list.add(q);
		list.add(p);
		list.add(o);
		list.add(n);
		list.add(m);
		list.add(l);
		list.add(k);
		list.add(j);
		list.add(i);
		try{
			if(MergeSort.findSmallest(list, new MyComparator()) != i) return false;
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"tenElementListTestSmallestComparatorReversed", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean tenElementListTestLargestNatural(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		Integer n = new Integer(6);
		Integer o = new Integer(7);
		Integer p = new Integer(8);
		Integer q = new Integer(9);
		Integer r = new Integer(10);
		list.add(i);
		list.add(j);
		list.add(k);
		list.add(l);
		list.add(m);
		list.add(n);
		list.add(o);
		list.add(p);
		list.add(q);
		list.add(r);
		try{
			if(MergeSort.findLargest(list) != r) return false;
		}catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"tenElementListTestLargestNatural", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean tenElementListTestLargestNaturalMixed(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		Integer n = new Integer(6);
		Integer o = new Integer(7);
		Integer p = new Integer(8);
		Integer q = new Integer(9);
		Integer r = new Integer(10);
		list.add(m);
		list.add(k);
		list.add(o);
		list.add(i);
		list.add(q);
		list.add(p);
		list.add(j);
		list.add(r);
		list.add(n);
		list.add(l);
		try{
			if(MergeSort.findLargest(list) != r) return false;
		}catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"tenElementListTestLargestNaturalMixed", e.toString());
			return false;
		}
		return true;
	}
	
	/** @return test success */
	private boolean tenElementListTestLargestNaturalReversed(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		Integer n = new Integer(6);
		Integer o = new Integer(7);
		Integer p = new Integer(8);
		Integer q = new Integer(9);
		Integer r = new Integer(10);
		list.add(r);
		list.add(q);
		list.add(p);
		list.add(o);
		list.add(n);
		list.add(m);
		list.add(l);
		list.add(k);
		list.add(j);
		list.add(i);
		try{
			if(MergeSort.findLargest(list) != r) return false;
		}catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"tenElementListTestLargestNaturalReversed", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean tenElementListTestLargestComparator(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		Integer n = new Integer(6);
		Integer o = new Integer(7);
		Integer p = new Integer(8);
		Integer q = new Integer(9);
		Integer r = new Integer(10);
		list.add(i);
		list.add(j);
		list.add(k);
		list.add(l);
		list.add(m);
		list.add(n);
		list.add(o);
		list.add(p);
		list.add(q);
		list.add(r);
		try{
			if(MergeSort.findLargest(list, new MyComparator()) != r) return false;
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"tenElementListTestLargestComparator", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean tenElementListTestLargestComparatorMixed(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		Integer n = new Integer(6);
		Integer o = new Integer(7);
		Integer p = new Integer(8);
		Integer q = new Integer(9);
		Integer r = new Integer(10);
		list.add(m);
		list.add(k);
		list.add(o);
		list.add(i);
		list.add(q);
		list.add(p);
		list.add(j);
		list.add(r);
		list.add(n);
		list.add(l);
		try{
			if(MergeSort.findLargest(list, new MyComparator()) != r) return false;
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"tenElementListTestLargestComparatorMixed", e.toString());
			return false;
		}
		return true;
	}
	
	/** @return test success */
	private boolean tenElementListTestLargestComparatorReversed(){
		WrappedDLL<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		Integer n = new Integer(6);
		Integer o = new Integer(7);
		Integer p = new Integer(8);
		Integer q = new Integer(9);
		Integer r = new Integer(10);
		list.add(r);
		list.add(q);
		list.add(p);
		list.add(o);
		list.add(n);
		list.add(m);
		list.add(l);
		list.add(k);
		list.add(j);
		list.add(i);
		try{
			if(MergeSort.findLargest(list, new MyComparator()) != r) return false;
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"tenElementListTestLargestComparatorReversed", e.toString());
			return false;
		}
		return true;
	}
	/** @return test success */
	private boolean tenElementListTestSortNaturalSame(){
		WrappedDLL<Integer> list = newList();
		WrappedDLL<Integer> expected = newList();
		Integer i = new Integer(3);
		Integer j = new Integer(3);
		Integer k = new Integer(3);
		Integer l = new Integer(3);
		Integer m = new Integer(3);
		Integer n = new Integer(3);
		Integer o = new Integer(3);
		Integer p = new Integer(3);
		Integer q = new Integer(3);
		Integer r = new Integer(3);
		list.add(i);
		list.add(j);
		list.add(k);
		list.add(l);
		list.add(m);
		list.add(n);
		list.add(o);
		list.add(p);
		list.add(q);
		list.add(r);
		expected.add(i);
		expected.add(j);
		expected.add(k);
		expected.add(l);
		expected.add(m);
		expected.add(n);
		expected.add(o);
		expected.add(p);
		expected.add(q);
		expected.add(r);
		try{
			MergeSort.sort(list);
			return testResult(list, expected);
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"tenElementListTestSortNatural", e.toString());
			return false;
		}
	}
	
	/** @returns test success */
	private boolean tenElementListTestSortComparatorSame(){
		WrappedDLL<Integer> list = newList();
		WrappedDLL<Integer> expected = newList();
		Integer i = new Integer(3);
		Integer j = new Integer(3);
		Integer k = new Integer(3);
		Integer l = new Integer(3);
		Integer m = new Integer(3);
		Integer n = new Integer(3);
		Integer o = new Integer(3);
		Integer p = new Integer(3);
		Integer q = new Integer(3);
		Integer r = new Integer(3);
		list.add(i);
		list.add(j);
		list.add(k);
		list.add(l);
		list.add(m);
		list.add(n);
		list.add(o);
		list.add(p);
		list.add(q);
		list.add(r);
		expected.add(i);
		expected.add(j);
		expected.add(k);
		expected.add(l);
		expected.add(m);
		expected.add(n);
		expected.add(o);
		expected.add(p);
		expected.add(q);
		expected.add(r);
		try{
			MergeSort.sort(list, new MyComparator());
			return testResult(list, expected);
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"tenElementListTestSortComparator", e.toString());
			return false;
		}
	}
	
	/** @returns test success */
	private boolean tenElementListTestSortNaturalDouble() {
		WrappedDLL<Integer> list = newList();
		WrappedDLL<Integer> expected = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(1);
		Integer k = new Integer(2);
		Integer l = new Integer(2);
		Integer m = new Integer(3);
		Integer n = new Integer(3);
		Integer o = new Integer(4);
		Integer p = new Integer(4);
		Integer q = new Integer(5);
		Integer r = new Integer(5);
		list.add(i);
		list.add(j);
		list.add(k);
		list.add(l);
		list.add(m);
		list.add(n);
		list.add(o);
		list.add(p);
		list.add(q);
		list.add(r);
		expected.add(i);
		expected.add(j);
		expected.add(k);
		expected.add(l);
		expected.add(m);
		expected.add(n);
		expected.add(o);
		expected.add(p);
		expected.add(q);
		expected.add(r);
		try{
			MergeSort.sort(list);
			return testResult(list, expected);
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"tenElementListTestSortNatural", e.toString());
			return false;
		}
	}
	
	/** @returns test success */
	private boolean tenElementListTestSortComparatorDouble() {
		WrappedDLL<Integer> list = newList();
		WrappedDLL<Integer> expected = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(1);
		Integer k = new Integer(2);
		Integer l = new Integer(2);
		Integer m = new Integer(3);
		Integer n = new Integer(3);
		Integer o = new Integer(4);
		Integer p = new Integer(4);
		Integer q = new Integer(5);
		Integer r = new Integer(5);
		list.add(i);
		list.add(j);
		list.add(k);
		list.add(l);
		list.add(m);
		list.add(n);
		list.add(o);
		list.add(p);
		list.add(q);
		list.add(r);
		expected.add(i);
		expected.add(j);
		expected.add(k);
		expected.add(l);
		expected.add(m);
		expected.add(n);
		expected.add(o);
		expected.add(p);
		expected.add(q);
		expected.add(r);
		try{
			MergeSort.sort(list, new MyComparator());
			return testResult(list, expected);
		}catch (Exception e){
			System.out.printf("%s caught unexpected %s\n",
					"tenElementListTestSortComparator", e.toString());
			return false;
		}
	}
}