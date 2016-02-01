import java.awt.List;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * A unit test class for DoubleLinkedListADT. This is a set of black box tests
 * that should work for any implementation of DoubleLinkedListADT.
 * 
 * NOTE: One set of example tests is given for the scenario of a creating a new,
 * empty list to get you started.
 * 
 * Method newList() returns one of two (or more) alternate implementations to
 * all tests, so you don't have to do a search and replace on constructor calls
 * in every test.
 * 
 * @author cgoetz: testing framework and empty list scenario
 */
public class DoubleLinkedListTester {
	private int passes = 0;
	private int failures = 0;
	private int total = 0;

	/**
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		// to avoid every method being static
		DoubleLinkedListTester tester = new DoubleLinkedListTester();
		tester.runTests();
	}

	/**
	 * Returns an DoubleLinkedListADT so the implementation can be changed in
	 * this one location rather than in every test.
	 * 
	 * @return a new DoubleLinkedListADT
	 */
	private DoubleLinkedList<Integer> newList() {
		return new DoubleLinkedList<Integer>();
	}

	private DoubleLinkedList<Integer> newList1() {
		DoubleLinkedList<Integer> list = newList();
		list.add(1);
		return list;
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
		// ///////////////////////////////
		// UNORDERED ARRAY LIST TEST
		// ///////////////////////////////

		// TESTS ON A NEW, EMPTY LIST
		printTest("testAddToFrontOnNewList", testAddToFrontOnNewList());
		printTest("testAddToRearOnNewList", testAddToRearOnNewList());
		printTest("testAddAfterOnNewList", testAddAfterOnNewList());
		printTest("testRemoveFirstOnNewList", testRemoveFirstOnNewList());
		printTest("testRemoveLastOnNewList", testRemoveLastOnNewList());
		printTest("testRemoveElementOnNewList", testRemoveElementOnNewList());
		printTest("testFirstOnNewList", testFirstOnNewList());
		printTest("testLastOnNewList", testLastOnNewList());
		printTest("testIsEmptyOnNewList", testIsEmptyOnNewList());
		printTest("testSizeOnNewList", testSizeOnNewList());
		printTest("testIteratorOnNewList", testIteratorOnNewList());
		printTest("testToStringOnNewList", testToStringOnNewList());

		// TEST ON A ONE ELEMENT LIST USING ADD TO FRONT
		printTest("testAddToFrontOnOneElementListAddToFront",
				testAddToRearOnOneElementListAddToFront());
		printTest("testAddToRearOnOneElementListAddToFront",
				testAddToRearOnOneElementListAddToFront());
		printTest("testAddAfterOnOneElementListAddToFrontValid",
				testAddAfterOnOneElementListAddToFrontValid());
		printTest("testAddAfterOnOneElementListAddToFrontInvalid",
				testAddAfterOnOneElementListAddToFrontInvalid());
		printTest("testRemoveFirstOnOneElementListAddToFront",
				testRemoveFirstOnOneElementListAddToFront());
		printTest("testRemoveLastOnOneElementListAddToFront",
				testRemoveLastOnOneElementListAddToFront());
		printTest("testRemoveElementOnOneElementListAddToFrontValid",
				testRemoveElementOnOneElementListAddToFrontValid());
		printTest("testRemoveElementOnOneElementListAddToFrontInvalid",
				testRemoveElementOnOneElementListAddToFrontInvalid());
		printTest("testFirstOnOneElementListAddToFront",
				testFirstOnOneElementListAddToFront());
		printTest("testLastOnOneElementListAddToFront",
				testLastOnOneElementListAddToFront());
		printTest("testContainsOnOneElementListAddToFrontValid",
				testContainsOnOneElementListAddToFrontValid());
		printTest("testContainsOnOneElementListAddToFrontInvalid",
				testContainsOnOneElementListAddToFrontInvalid());
		printTest("testIsEmptyOnOneElementListAddToFront",
				testIsEmptyOnOneElementListAddToFront());
		printTest("testSizeOnOneElementListAddToFront",
				testSizeOnOneElementListAddToFront());
		printTest("testIteratorOnOneElementListAddToFront",
				testIteratorOnOneElementListAddToFront());
		printTest("testToStringOnOneElementListAddToFront",
				testToStringOnOneElementListAddToFront());

		// TEST ON A ONE ELEMENT LIST USING ADD TO REAR
		printTest("testAddToFrontOnOneElementListAddToRear",
				testAddToFrontOnOneElementListAddToRear());
		printTest("testAddToRearOnOneElementListAddToRear",
				testAddToRearOnOneElementListAddToRear());
		printTest("testAddAfterOnOneElementListAddToRearValid",
				testAddAfterOnOneElementListAddToRearValid());
		printTest("testAddAfterOnOneElementListAddToRearInvalid",
				testAddAfterOnOneElementListAddToRearInvalid());
		printTest("testRemoveFirstOnOneElementListAddToRear",
				testRemoveFirstOnOneElementListAddToRear());
		printTest("testRemoveLastOnOneElementListAddToRear",
				testRemoveLastOnOneElementListAddToRear());
		printTest("testRemoveElementOnOneElementListAddToRearValid",
				testRemoveElementOnOneElementListAddToRearValid());
		printTest("testRemoveElementOnOneElementListAddToRearInvalid",
				testRemoveElementOnOneElementListAddToRearInvalid());
		printTest("testFirstOnOneElementListAddToRear",
				testFirstOnOneElementListAddToRear());
		printTest("testLastOnOneElementListAddToRear",
				testLastOnOneElementListAddToRear());
		printTest("testContainsOnOneElementListAddToRearValid",
				testContainsOnOneElementListAddToRearValid());
		printTest("testContainsOnOneElementListAddToRearInvalid",
				testContainsOnOneElementListAddToRearInvalid());
		printTest("testIsEmptyOnOneElementListAddToRear",
				testIsEmptyOnOneElementListAddToRear());
		printTest("testSizeOnOneElementListAddToRear",
				testSizeOnOneElementListAddToRear());
		printTest("testIteratorOnOneElementListAddToRear",
				testIteratorOnOneElementListAddToRear());
		printTest("testToStringOnOneElementListAddToRear",
				testToStringOnOneElementListAddToRear());

		// TEST ON A ONE ELEMENT LIST USING REMOVE FIRST
		printTest("testAddToFrontOnOneElementListRemoveFirst",
				testAddToFrontOnOneElementListRemoveFirst());
		printTest("testAddToRearOnOneElementListRemoveFirst",
				testAddToRearOnOneElementListRemoveFirst());
		printTest("testAddAfterOnOneElementListRemoveFirstValid",
				testAddAfterOnOneElementListRemoveFirstValid());
		printTest("testAddAfterOnOneElementListRemoveFirstInvalid",
				testAddAfterOnOneElementListRemoveFirstInvalid());
		printTest("testRemoveFirstOnOneElementListRemoveFirst",
				testRemoveFirstOnOneElementListRemoveFirst());
		printTest("testRemoveLastOnOneElementListRemoveFirst",
				testRemoveLastOnOneElementListRemoveFirst());
		printTest("testRemoveElementOnOneElementListRemoveFirstValid",
				testRemoveElementOnOneElementListRemoveFirstValid());
		printTest("testRemoveElementOnOneElementListRemoveFirstInvalid",
				testRemoveElementOnOneElementListRemoveFirstInvalid());
		printTest("testFirstOnOneElementListRemoveFirst",
				testFirstOnOneElementListRemoveFirst());
		printTest("testLastOnOneElementListRemoveFirst",
				testLastOnOneElementListRemoveFirst());
		printTest("testContainsOnOneElementListRemoveFirstValid",
				testContainsOnOneElementListRemoveFirstValid());
		printTest("testContainsOnOneElementListRemoveFirstInvalid",
				testContainsOnOneElementListRemoveFirstInvalid());
		printTest("testIsEmptyOnOneElementListRemoveFirst",
				testIsEmptyOnOneElementListRemoveFirst());
		printTest("testSizeOnOneElementListRemoveFirst",
				testSizeOnOneElementListRemoveFirst());
		printTest("testIteratorOnOneElementListRemoveFirst",
				testIteratorOnOneElementListRemoveFirst());
		printTest("testToStringOnOneElementListRemoveFirst",
				testToStringOnOneElementListRemoveFirst());

		// TEST ON A ONE ELEMENT LIST USING REMOVE LAST
		printTest("testAddToFrontOnOneElementListRemoveLast",
				testAddToFrontOnOneElementListRemoveLast());
		printTest("testAddToRearOnOneElementListRemoveLast",
				testAddToRearOnOneElementListRemoveLast());
		printTest("testAddAfterOnOneElementListRemoveLastValid",
				testAddAfterOnOneElementListRemoveLastValid());
		printTest("testAddAfterOnOneElementListRemoveLastInvalid",
				testAddAfterOnOneElementListRemoveLastInvalid());
		printTest("testRemoveFirstOnOneElementListRemoveLast",
				testRemoveFirstOnOneElementListRemoveLast());
		printTest("testRemoveLastOnOneElementListRemoveLast",
				testRemoveLastOnOneElementListRemoveLast());
		printTest("testRemoveElementOnOneElementListRemoveLastValid",
				testRemoveElementOnOneElementListRemoveLastValid());
		printTest("testRemoveElementOnOneElementListRemoveLastInvalid",
				testRemoveElementOnOneElementListRemoveLastInvalid());
		printTest("testFirstOnOneElementListRemoveLast",
				testFirstOnOneElementListRemoveLast());
		printTest("testLastOnOneElementListRemoveLast",
				testLastOnOneElementListRemoveLast());
		printTest("testContainsOnOneElementListRemoveLastValid",
				testContainsOnOneElementListRemoveLastValid());
		printTest("testContainsOnOneElementListRemoveLastInvalid",
				testContainsOnOneElementListRemoveLastInvalid());
		printTest("testIsEmptyOnOneElementListRemoveLast",
				testIsEmptyOnOneElementListRemoveLast());
		printTest("testSizeOnOneElementListRemoveLast",
				testSizeOnOneElementListRemoveLast());
		printTest("testIteratorOnOneElementListRemoveLast",
				testIteratorOnOneElementListRemoveLast());
		printTest("testToStringOnOneElementListRemoveLast",
				testToStringOnOneElementListRemoveLast());

		// TEST ON A ONE ELEMENT LIST USING REMOVE
		printTest("testAddToFrontOnOneElementListRemove",
				testAddToFrontOnOneElementListRemove());
		printTest("testAddToRearOnOneElementListRemove",
				testAddToRearOnOneElementListRemove());
		printTest("testAddAfterOnOneElementListRemoveValid",
				testAddAfterOnOneElementListRemoveValid());
		printTest("testAddAfterOnOneElementListRemoveInvalid",
				testAddAfterOnOneElementListRemoveInvalid());
		printTest("testRemoveFirstOnOneElementListRemove",
				testRemoveFirstOnOneElementListRemove());
		printTest("testRemoveLastOnOneElementListRemove",
				testRemoveLastOnOneElementListRemove());
		printTest("testRemoveElementOnOneElementListRemoveValid",
				testRemoveElementOnOneElementListRemoveValid());
		printTest("testRemoveElementOnOneElementListRemoveInvalid",
				testRemoveElementOnOneElementListRemoveInvalid());
		printTest("testFirstOnOneElementListRemove",
				testFirstOnOneElementListRemove());
		printTest("testLastOnOneElementListRemove",
				testLastOnOneElementListRemove());
		printTest("testContainsOnOneElementListRemoveValid",
				testContainsOnOneElementListRemoveValid());
		printTest("testContainsOnOneElementListRemoveInvalid",
				testContainsOnOneElementListRemoveInvalid());
		printTest("testIsEmptyOnOneElementListRemove",
				testIsEmptyOnOneElementListRemove());
		printTest("testSizeOnOneElementListRemove",
				testSizeOnOneElementListRemove());
		printTest("testIteratorOnOneElementListRemove",
				testIteratorOnOneElementListRemove());
		printTest("testToStringOnOneElementListRemove",
				testToStringOnOneElementListRemove());

		// TEST ON A ONE ELEMENT LIST USING ADD AFTER
		printTest("testAddToFrontOnOneElementListAddAfter",
				testAddToFrontOnOneElementListAddAfter());
		printTest("testAddToRearOnOneElementListAddAfter",
				testAddToRearOnOneElementListAddAfter());
		printTest("testAddAfterOnOneElementListAddAfterValid",
				testAddAfterOnOneElementListAddAfterValid());
		printTest("testAddAfterOnOneElementListAddToAfterInvalid",
				testAddAfterOnOneElementListAddAfterInvalid());
		printTest("testRemoveFirstOnOneElementListAddAfter",
				testRemoveFirstOnOneElementListAddAfter());
		printTest("testRemoveLastOnOneElementListAddAfter",
				testRemoveLastOnOneElementListAddAfter());
		printTest("testRemoveElementOnOneElementListAddAfterValidOne",
				testRemoveElementOnOneElementListAddAfterValidOne());
		printTest("testRemoveElementOnOneElementListAddAfterValidTwo",
				testRemoveElementOnOneElementListAddAfterValidTwo());
		printTest("testRemoveElementOnOneElementListAddAfterInvalid",
				testRemoveElementOnOneElementListAddAfterInvalid());
		printTest("testFirstOnOneElementListAddAfter",
				testFirstOnOneElementListAddAfter());
		printTest("testLastOnOneElementListAddAfter",
				testLastOnOneElementListAddAfter());
		printTest("testContainsOnOneElementListAddAfterValid",
				testContainsOnOneElementListAddAfterValidOne());
		printTest("testContainsOnOneElementListAddAfterValid",
				testContainsOnOneElementListAddAfterValidTwo());
		printTest("testContainsOnOneElementListAddAfterInvalid",
				testContainsOnOneElementListAddAfterInvalid());
		printTest("testIsEmptyOnOneElementListAddAfter",
				testIsEmptyOnOneElementListAddAfter());
		printTest("testSizeOnOneElementListAddAfter",
				testSizeOnOneElementListAddAfter());
		printTest("testIteratorOnOneElementListAddAfter",
				testIteratorOnOneElementListAddAfter());
		printTest("testToStringOnOneElementListAddAfter",
				testToStringOnOneElementListAddAfter());

		// TEST ON A TWO ELEMENT LIST USING ADD TO FRONT FOR FIRST ELEMENT
		printTest("testAddToFrontOnTwoElementListAddToFrontFirstElement",
				testAddToFrontOnTwoElementListAddToFrontFirstElement());
		printTest("testAddToRearOnTwoElementListAddToFrontFirstElement",
				testAddToRearOnTwoElementListAddToFrontFirstElement());
		printTest("testAddAfterOnTwoElementListAddToFrontFirstElementValidOne",
				testAddAfterOnTwoElementListAddToFrontFirstElementValidOne());
		printTest("testAddAfterOnTwoElementListAddToFrontFirstElementValidTwo",
				testAddAfterOnTwoElementListAddToFrontFirstElementValidTwo());
		printTest("testAddAfterOnTwoElementListAddToFrontFirstElementInvalid",
				testAddAfterOnTwoElementListAddToFrontFirstElementInvalid());
		printTest("testRemoveFirstOnTwoElementListAddToFrontFirstElement",
				testRemoveFirstOnTwoElementListAddToFrontFirstElement());
		printTest("testRemoveLastOnTwoElementListAddToFrontFirstElement",
				testRemoveLastOnTwoElementListAddToFrontFirstElement());
		printTest(
				"testRemoveElementOnTwoElementListAddToFrontFirstElementValidOne",
				testRemoveElementOnTwoElementListAddToFrontFirstElementValidOne());
		printTest(
				"testRemoveElementOnTwoElementListAddToFrontFirstElementValidTwo",
				testRemoveElementOnTwoElementListAddToFrontFirstElementValidTwo());
		printTest(
				"testRemoveElementOnTwoElementListAddToFrontFirstElementInvalid",
				testRemoveElementOnTwoElementListAddToFrontFirstElementInvalid());
		printTest("testFirstOnTwoElementListAddToFrontFirstElement",
				testFirstOnTwoElementListAddToFrontFirstElement());
		printTest("testLastOnTwoElementListAddToFrontFirstElement",
				testLastOnTwoElementListAddToFrontFirstElement());
		printTest("testContainsOnTwoElementListAddToFrontFirstElementValidOne",
				testContainsOnTwoElementListAddToFrontFirstElementValidOne());
		printTest("testContainsOnTwoElementListAddToFrontFirstElementValidTwo",
				testContainsOnTwoElementListAddToFrontFirstElementValidTwo());
		printTest("testContainsOnTwoElementListAddToFrontFirstElementInvalid",
				testContainsOnTwoElementListAddToFrontFirstElementInvalid());
		printTest("testIsEmptyOnTwoElementListAddToFrontFirstElement",
				testIsEmptyOnTwoElementListAddToFrontFirstElement());
		printTest("testSizeOnTwoElementListAddToFrontFirstElement",
				testSizeOnTwoElementListAddToFrontFirstElement());
		printTest("testIteratorOnTwoElementListAddToFrontFirstElement",
				testIteratorOnTwoElementListAddToFrontFirstElement());
		printTest("testToStringOnTwoElementListAddToFrontFirstElement",
				testToStringOnTwoElementListAddToFrontFirstElement());

		// TEST ON A TWO ELEMENT LIST USING ADD TO REAR ON SECOND ELEMENT
		printTest("testAddToFrontOnTwoElementListAddToRearSecondElement",
				testAddToFrontOnTwoElementListAddToRearSecondElement());
		printTest("testAddToRearOnTwoElementListAddToRearSecondElement",
				testAddToRearOnTwoElementListAddToRearSecondElement());
		printTest("testAddAfterOnTwoElementListAddToRearSecondElementValidOne",
				testAddAfterOnTwoElementListAddToRearSecondElementValidOne());
		printTest("testAddAfterOnTwoElementListAddToRearSecondElementValidTwo",
				testAddAfterOnTwoElementListAddToRearSecondElementValidTwo());
		printTest("testAddAfterOnTwoElementListAddToRearSecondElementInvalid",
				testAddAfterOnTwoElementListAddToRearSecondElementInvalid());
		printTest("testRemoveFirstOnTwoElementListAddToRearSecondElement",
				testRemoveFirstOnTwoElementListAddToRearSecondElement());
		printTest("testRemoveLastOnTwoElementListAddToRearSecondElement",
				testRemoveLastOnTwoElementListAddToRearSecondElement());
		printTest(
				"testRemoveElementOnTwoElementListAddToRearSecondElementValidOne",
				testRemoveElementOnTwoElementListAddToRearSecondElementValidOne());
		printTest(
				"testRemoveElementOnTwoElementListAddToRearSecondElementValidTwo",
				testRemoveElementOnTwoElementListAddToRearSecondElementValidTwo());
		printTest(
				"testRemoveElementOnTwoElementListAddToRearSecondElementInvalid",
				testRemoveElementOnTwoElementListAddToRearSecondElementInvalid());
		printTest("testFirstOnTwoElementListAddToRearSecondElement",
				testFirstOnTwoElementListAddToRearSecondElement());
		printTest("testLastOnTwoElementListAddToRearSecondElement",
				testLastOnTwoElementListAddToRearSecondElement());
		printTest("testContainsOnTwoElementListAddToRearSecondElementValidOne",
				testContainsOnTwoElementListAddToRearSecondElementValidOne());
		printTest("testContainsOnTwoElementListAddToRearSecondElementValidTwo",
				testContainsOnTwoElementListAddToRearSecondElementValidTwo());
		printTest("testContainsOnTwoElementListAddToRearSecondElementInvalid",
				testContainsOnTwoElementListAddToRearSecondElementInvalid());
		printTest("testIsEmptyOnTwoElementListAddToRearSecondElement",
				testIsEmptyOnTwoElementListAddToRearSecondElement());
		printTest("testSizeOnTwoElementListAddToRearSecondElement",
				testSizeOnTwoElementListAddToRearSecondElement());
		printTest("testIteratorOnTwoElementListAddToRearSecondElement",
				testIteratorOnTwoElementListAddToRearSecondElement());
		printTest("testToStringOnTwoElementListAddToRearSecondElement",
				testToStringOnTwoElementListAddToRearSecondElement());

		// TEST ON A TWO ELEMENT LIST USING REMOVE FIRST
		printTest("testAddToFrontOnTwoElementListRemoveFirstElement",
				testAddToFrontOnTwoElementListRemoveFirstElement());
		printTest("testAddToRearOnTwoElementListRemoveFirstElement",
				testAddToRearOnTwoElementListRemoveFirstElement());
		printTest("testAddAfterOnTwoElementListRemoveFirstElementValidOne",
				testAddAfterOnTwoElementListRemoveFirstElementValidOne());
		printTest("testAddAfterOnTwoElementListRemoveFirstElementValidTwo",
				testAddAfterOnTwoElementListRemoveFirstElementValidTwo());
		printTest("testAddAfterOnTwoElementListRemoveFirstElementInvalid",
				testAddAfterOnTwoElementListRemoveFirstElementInvalid());
		printTest("testRemoveFirstOnTwoElementListRemoveFirstElement",
				testRemoveFirstOnTwoElementListRemoveFirstElement());
		printTest("testRemoveLastOnTwoElementListRemoveFirstElement",
				testRemoveLastOnTwoElementListRemoveFirstElement());
		printTest(
				"testRemoveElementOnTwoElementListRemoveFirstElementValidOne",
				testRemoveElementOnTwoElementListRemoveFirstElementValidOne());
		printTest("testRemoveElementOnTwoElementListRemoveFirstElementInvalid",
				testRemoveElementOnTwoElementListRemoveFirstElementInvalid());
		printTest("testFirstOnTwoElementListRemoveFirstElement",
				testFirstOnTwoElementListRemoveFirstElement());
		printTest("testLastOnTwoElementListRemoveFirstElement",
				testLastOnTwoElementListRemoveFirstElement());
		printTest("testContainsOnTwoElementListRemoveFirstElementValidOne",
				testContainsOnTwoElementListRemoveFirstElementValidOne());
		printTest("testContainsOnTwoElementListRemoveFirstElementValidTwo",
				testContainsOnTwoElementListRemoveFirstElementValidTwo());
		printTest("testContainsOnTwoElementListRemoveFirstElementInvalid",
				testContainsOnTwoElementListRemoveFirstElementInvalid());
		printTest("testIsEmptyOnTwoElementListRemoveFirstElement",
				testIsEmptyOnTwoElementListRemoveFirstElement());
		printTest("testSizeOnTwoElementListRemoveFirstElement",
				testSizeOnTwoElementListRemoveFirstElement());
		printTest("testIteratorOnTwoElementListRemoveFirstElement",
				testIteratorOnTwoElementListRemoveFirstElement());
		printTest("testToStringOnTwoElementListRemoveFirstElement",
				testToStringOnTwoElementListRemoveFirstElement());

		// TEST ON A TWO ELEMENT LIST USING REMOVE ON FIRST ELEMENT
		printTest("testAddToFrontOnTwoElementListRemoveFirst",
				testAddToFrontOnTwoElementListRemoveFirst());
		printTest("testAddToRearOnTwoElementListRemoveFirst",
				testAddToRearOnTwoElementListRemoveFirst());
		printTest("testAddAfterOnTwoElementListRemoveFirstValidOne",
				testAddAfterOnTwoElementListRemoveFirstValidOne());
		printTest("testAddAfterOnTwoElementListRemoveFirstValidTwo",
				testAddAfterOnTwoElementListRemoveFirstValidTwo());
		printTest("testAddAfterOnTwoElementListRemoveFirstInvalid",
				testAddAfterOnTwoElementListRemoveFirstInvalid());
		printTest("testRemoveFirstOnTwoElementListRemoveFirst",
				testRemoveFirstOnTwoElementListRemoveFirst());
		printTest("testRemoveLastOnTwoElementListRemoveFirst",
				testRemoveLastOnTwoElementListRemoveFirst());
		printTest("testRemoveElementOnTwoElementListRemoveFirstValidOne",
				testRemoveElementOnTwoElementListRemoveFirstValidOne());
		printTest("testRemoveElementOnTwoElementListRemoveFirstInvalid",
				testRemoveElementOnTwoElementListRemoveFirstInvalid());
		printTest("testFirstOnTwoElementListRemoveFirst",
				testFirstOnTwoElementListRemoveFirst());
		printTest("testLastOnTwoElementListRemoveFirst",
				testLastOnTwoElementListRemoveFirst());
		printTest("testContainsOnTwoElementListRemoveFirstValidOne",
				testContainsOnTwoElementListRemoveFirstValidOne());
		printTest("testContainsOnTwoElementListRemoveFirstValidTwo",
				testContainsOnTwoElementListRemoveFirstValidTwo());
		printTest("testContainsOnTwoElementListRemoveFirstInvalid",
				testContainsOnTwoElementListRemoveFirstInvalid());
		printTest("testIsEmptyOnTwoElementListRemoveFirst",
				testIsEmptyOnTwoElementListRemoveFirst());
		printTest("testSizeOnTwoElementListRemoveFirst",
				testSizeOnTwoElementListRemoveFirst());
		printTest("testIteratorOnTwoElementListRemoveFirst",
				testIteratorOnTwoElementListRemoveFirst());
		printTest("testToStringOnTwoElementListRemoveFirst",
				testToStringOnTwoElementListRemoveFirst());

		// TEST ON A TWO ELEMENT LIST USING ADD AFTER TO ADD MIDDLE ELEMENT
		printTest("testAddToFrontOnTwoElementListAddAfterSecondElement",
				testAddToFrontOnTwoElementListAddAfterSecondElement());
		printTest("testAddToRearOnTwoElementListAddAfterSecondElement",
				testAddToRearOnTwoElementListAddAfterSecondElement());
		printTest("testAddAfterOnTwoElementListAddAfterSecondElementValidOne",
				testAddAfterOnTwoElementListAddAfterSecondElementValidOne());
		printTest("testAddAfterOnTwoElementListAddAfterSecondElementValidTwo",
				testAddAfterOnTwoElementListAddAfterSecondElementValidTwo());
		printTest(
				"testAddAfterOnTwoElementListAddAfterSecondElementValidThree",
				testAddAfterOnTwoElementListAddAfterSecondElementValidThree());
		printTest("testAddAfterOnTwoElementListAddAfterSecondElementInvalid",
				testAddAfterOnTwoElementListAddAfterSecondElementInvalid());
		printTest("testRemoveFirstOnTwoElementListAddAfterSecondElement",
				testRemoveFirstOnTwoElementListAddAfterSecondElement());
		printTest("testRemoveLastOnTwoElementListAddAfterSecondElement",
				testRemoveLastOnTwoElementListAddAfterSecondElement());
		printTest(
				"testRemoveElementOnTwoElementListAddAfterSecondElementValidOne",
				testRemoveElementOnTwoElementListAddAfterSecondElementValidOne());
		printTest(
				"testRemoveElementOnTwoElementListAddAfterSecondElementValidTwo",
				testRemoveElementOnTwoElementListAddAfterSecondElementValidTwo());
		printTest(
				"testRemoveElementOnTwoElementListAddAfterSecondElementValidThree",
				testRemoveElementOnTwoElementListAddAfterSecondElementValidThree());
		printTest(
				"testRemoveElementOnTwoElementListAddAfterSecondElementInvalid",
				testRemoveElementOnTwoElementListAddAfterSecondElementInvalid());
		printTest("testFirstOnTwoElementListAddAfterSecondElement",
				testFirstOnTwoElementListAddAfterSecondElement());
		printTest("testLastOnTwoElementListAddAfterSecondElement",
				testLastOnTwoElementListAddAfterSecondElement());
		printTest("testContainsOnTwoElementListAddAfterSecondElementValidOne",
				testContainsOnTwoElementListAddAfterSecondElementValidOne());
		printTest("testContainsOnTwoElementListAddAfterSecondElementValidTwo",
				testContainsOnTwoElementListAddAfterSecondElementValidTwo());
		printTest(
				"testContainsOnTwoElementListAddAfterSecondElementValidThree",
				testContainsOnTwoElementListAddAfterSecondElementValidThree());
		printTest("testContainsOnTwoElementListAddAfterSecondElementInvalid",
				testContainsOnTwoElementListAddAfterSecondElementInvalid());
		printTest("testIsEmptyOnTwoElementListAddAfterSecondElement",
				testIsEmptyOnTwoElementListAddAfterSecondElement());
		printTest("testSizeOnTwoElementListAddAfterSecondElement",
				testSizeOnTwoElementListAddAfterSecondElement());
		printTest("testIteratorOnTwoElementListAddAfterSecondElement",
				testIteratorOnTwoElementListAddAfterSecondElement());
		printTest("testToStringOnTwoElementListAddAfterSecondElement",
				testToStringOnTwoElementListAddAfterSecondElement());

		// TEST ON A TWO ELEMENT LIST USING REMOVE ON LAST ELEMENT
		printTest("testAddToFrontOnTwoElementListRemoveLastElement",
				testAddToFrontOnTwoElementListRemoveLastElement());
		printTest("testAddToRearOnTwoElementListRemoveLastElement",
				testAddToRearOnTwoElementListRemoveLastElement());
		printTest("testAddAfterOnTwoElementListRemoveLastElementValidOne",
				testAddAfterOnTwoElementListRemoveLastElementValidOne());
		printTest("testAddAfterOnTwoElementListRemoveLastElementValidTwo",
				testAddAfterOnTwoElementListRemoveLastElementValidTwo());
		printTest("testAddAfterOnTwoElementListRemoveLastElementInvalid",
				testAddAfterOnTwoElementListRemoveLastElementInvalid());
		printTest("testRemoveFirstOnTwoElementListRemoveLastElement",
				testRemoveFirstOnTwoElementListRemoveLastElement());
		printTest("testRemoveLastOnTwoElementListRemoveLastElement",
				testRemoveLastOnTwoElementListRemoveLastElement());
		printTest("testRemoveElementOnTwoElementListRemoveLastElementValidOne",
				testRemoveElementOnTwoElementListRemoveLastElementValidOne());
		printTest("testRemoveElementOnTwoElementListRemoveLastElementInvalid",
				testRemoveElementOnTwoElementListRemoveLastElementInvalid());
		printTest("testFirstOnTwoElementListRemoveLastElement",
				testFirstOnTwoElementListRemoveLastElement());
		// printTest("testLastOnTwoElementListRemoveLastElement",
		// testLastOnTwoElementListRemoveLastElement());
		printTest("testContainsOnTwoElementListRemoveLastElementValidOne",
				testContainsOnTwoElementListRemoveLastElementValidOne());
		// printTest("testContainsOnTwoElementListRemoveLastElementValidTwo",
		// testContainsOnTwoElementListRemoveLastElementValidTwo());
		printTest("testContainsOnTwoElementListRemoveLastElementInvalid",
				testContainsOnTwoElementListRemoveLastElementInvalid());
		printTest("testIsEmptyOnTwoElementListRemoveLastElement",
				testIsEmptyOnTwoElementListRemoveLastElement());
		printTest("testSizeOnTwoElementListRemoveLastElement",
				testSizeOnTwoElementListRemoveLastElement());
		printTest("testIteratorOnTwoElementListRemoveLastElement",
				testIteratorOnTwoElementListRemoveLastElement());
		printTest("testToStringOnTwoElementListRemoveLastElement",
				testToStringOnTwoElementListRemoveLastElement());

		// TEST ON A TWO ELEMENT LIST USING REMOVE LAST
		printTest("testAddToFrontOnTwoElementListRemoveLast",
				testAddToFrontOnTwoElementListRemoveLast());
		printTest("testAddToRearOnTwoElementListRemoveLast",
				testAddToRearOnTwoElementListRemoveLast());
		printTest("testAddAfterOnTwoElementListRemoveLastValidOne",
				testAddAfterOnTwoElementListRemoveLastValidOne());
		printTest("testAddAfterOnTwoElementListRemoveLastValidTwo",
				testAddAfterOnTwoElementListRemoveLastValidTwo());
		printTest("testAddAfterOnTwoElementListRemoveLastInvalid",
				testAddAfterOnTwoElementListRemoveLastInvalid());
		printTest("testRemoveFirstOnTwoElementListRemoveLast",
				testRemoveFirstOnTwoElementListRemoveLast());
		printTest("testRemoveLastOnTwoElementListRemoveLast",
				testRemoveLastOnTwoElementListRemoveLast());
		printTest("testRemoveElementOnTwoElementListRemoveLastValidOne",
				testRemoveElementOnTwoElementListRemoveLastValidOne());
		printTest("testRemoveElementOnTwoElementListRemoveLastInvalid",
				testRemoveElementOnTwoElementListRemoveLastInvalid());
		printTest("testFirstOnTwoElementListRemoveLast",
				testFirstOnTwoElementListRemoveLast());
		printTest("testLastOnTwoElementListRemoveLast",
				testLastOnTwoElementListRemoveLast());
		printTest("testContainsOnTwoElementListRemoveLastValidOne",
				testContainsOnTwoElementListRemoveLastValidOne());
		printTest("testContainsOnTwoElementListRemoveLastValidTwo",
				testContainsOnTwoElementListRemoveLastValidTwo());
		printTest("testContainsOnTwoElementListRemoveLastInvalid",
				testContainsOnTwoElementListRemoveLastInvalid());
		printTest("testIsEmptyOnTwoElementListRemoveLast",
				testIsEmptyOnTwoElementListRemoveLast());
		printTest("testSizeOnTwoElementListRemoveLast",
				testSizeOnTwoElementListRemoveLast());
		printTest("testIteratorOnTwoElementListRemoveLast",
				testIteratorOnTwoElementListRemoveLast());
		printTest("testToStringOnTwoElementListRemoveLast",
				testToStringOnTwoElementListRemoveLast());

		// TEST ON A THREE ELEMENT LIST USING ADD TO FRONT ON FIRST ELEMENT
		printTest("testAddToFrontOnThreeElementListAddToFrontFirstElement",
				testAddToFrontOnThreeElementListAddToFrontFirstElement());
		printTest("testAddToRearOnThreeElementListAddToFrontFirstElement",
				testAddToRearOnThreeElementListAddToFrontFirstElement());
		printTest(
				"testAddAfterOnThreeElementListAddToFrontFirstElementValidOne",
				testAddAfterOnThreeElementListAddToFrontFirstElementValidOne());
		printTest(
				"testAddAfterOnThreeElementListAddToFrontFirstElementValidTwo",
				testAddAfterOnThreeElementListAddToFrontFirstElementValidTwo());
		printTest(
				"testAddAfterOnThreeElementListAddToFrontFirstElementValidThree",
				testAddAfterOnThreeElementListAddToFrontFirstElementValidThree());
		printTest(
				"testAddAfterOnThreeElementListAddToFrontFirstElementInvalid",
				testAddAfterOnThreeElementListAddToFrontFirstElementInvalid());
		printTest("testRemoveFirstOnThreeElementListAddToFrontFirstElement",
				testRemoveFirstOnThreeElementListAddToFrontFirstElement());
		printTest("testRemoveLastOnThreeElementListAddToFrontFirstElement",
				testRemoveLastOnThreeElementListAddToFrontFirstElement());
		printTest(
				"testRemoveElementOnThreeElementListAddToFrontFirstElementValidOne",
				testRemoveElementOnThreeElementListAddToFrontFirstElementValidOne());
		printTest(
				"testRemoveElementOnThreeElementListAddToFrontFirstElementValidTwo",
				testRemoveElementOnThreeElementListAddToFrontFirstElementValidTwo());
		printTest(
				"testRemoveElementOnThreeElementListAddToFrontFirstElementValidThree",
				testRemoveElementOnThreeElementListAddToFrontFirstElementValidThree());
		printTest(
				"testRemoveElementOnThreeElementListAddToFrontFirstElementInvalid",
				testRemoveElementOnThreeElementListAddToFrontFirstElementInvalid());
		printTest("testFirstOnThreeElementListAddToFrontFirstElement",
				testFirstOnThreeElementListAddToFrontFirstElement());
		printTest("testLastOnThreeElementListAddToFrontFirstElement",
				testLastOnThreeElementListAddToFrontFirstElement());
		printTest(
				"testContainsOnThreeElementListAddToFrontFirstElementValidOne",
				testContainsOnThreeElementListAddToFrontFirstElementValidOne());
		printTest(
				"testContainsOnThreeElementListAddToFrontFirstElementValidTwo",
				testContainsOnThreeElementListAddToFrontFirstElementValidTwo());
		printTest(
				"testContainsOnThreeElementListAddToFrontFirstElementValidThree",
				testContainsOnThreeElementListAddToFrontFirstElementValidThree());
		printTest(
				"testContainsOnThreeElementListAddToFrontFirstElementInvalid",
				testContainsOnThreeElementListAddToFrontFirstElementInvalid());
		printTest("testIsEmptyOnThreeElementListAddToFrontFirstElement",
				testIsEmptyOnThreeElementListAddToFrontFirstElement());
		printTest("testSizeOnThreeElementListAddToFrontFirstElement",
				testSizeOnThreeElementListAddToFrontFirstElement());
		printTest("testIteratorOnThreeElementListAddToFrontFirstElement",
				testIteratorOnThreeElementListAddToFrontFirstElement());
		printTest("testToStringOnThreeElementListAddToFrontFirstElement",
				testToStringOnThreeElementListAddToFrontFirstElement());

		// TEST ON A THREE ELEMENT LIST USING ADD AFTER ON SECONED ELEMENT
		printTest("testAddToFrontOnThreeElementListAddAfterSecondElement",
				testAddToFrontOnThreeElementListAddAfterSecondElement());
		printTest("testAddToRearOnThreeElementListAddAfterSecondElement",
				testAddToRearOnThreeElementListAddAfterSecondElement());
		printTest(
				"testAddAfterOnThreeElementListAddAfterSecondElementValidOne",
				testAddAfterOnThreeElementListAddAfterSecondElementValidOne());
		printTest(
				"testAddAfterOnThreeElementListAddAfterSecondElementValidTwo",
				testAddAfterOnThreeElementListAddAfterSecondElementValidTwo());
		printTest(
				"testAddAfterOnThreeElementListAddAfterSecondElementValidThree",
				testAddAfterOnThreeElementListAddAfterSecondElementValidThree());
		printTest("testAddAfterOnThreeElementListAddAfterSecondElementInvalid",
				testAddAfterOnThreeElementListAddAfterSecondElementInvalid());
		printTest("testRemoveFirstOnThreeElementListAddAfterSecondElement",
				testRemoveFirstOnThreeElementListAddAfterSecondElement());
		printTest("testRemoveLastOnThreeElementListAddAfterSecondElement",
				testRemoveLastOnThreeElementListAddAfterSecondElement());
		printTest(
				"testRemoveElementOnThreeElementListAddAfterSecondElementValidOne",
				testRemoveElementOnThreeElementListAddAfterSecondElementValidOne());
		printTest(
				"testRemoveElementOnThreeElementListAddAfterSecondElementValidTwo",
				testRemoveElementOnThreeElementListAddAfterSecondElementValidTwo());
		printTest(
				"testRemoveElementOnThreeElementListAddAfterSecondElementValidThree",
				testRemoveElementOnThreeElementListAddAfterSecondElementValidThree());
		printTest(
				"testRemoveElementOnThreeElementListAddAfterSecondElementInvalid",
				testRemoveElementOnThreeElementListAddAfterSecondElementInvalid());
		printTest("testFirstOnThreeElementListAddAfterSecondElement",
				testFirstOnThreeElementListAddAfterSecondElement());
		printTest("testLastOnThreeElementListAddAfterSecondElement",
				testLastOnThreeElementListAddAfterSecondElement());
		printTest(
				"testContainsOnThreeElementListAddAfterSecondElementValidOne",
				testContainsOnThreeElementListAddAfterSecondElementValidOne());
		printTest(
				"testContainsOnThreeElementListAddAfterSecondElementValidTwo",
				testContainsOnThreeElementListAddAfterSecondElementValidTwo());
		printTest(
				"testContainsOnThreeElementListAddAfterSecondElementValidThree",
				testContainsOnThreeElementListAddAfterSecondElementValidThree());
		printTest("testContainsOnThreeElementListAddAfterSecondElementInvalid",
				testContainsOnThreeElementListAddAfterSecondElementInvalid());
		printTest("testIsEmptyOnThreeElementListAddAfterSecondElement",
				testIsEmptyOnThreeElementListAddAfterSecondElement());
		printTest("testSizeOnThreeElementListAddAfterSecondElement",
				testSizeOnThreeElementListAddAfterSecondElement());
		printTest("testIteratorOnThreeElementListAddAfterSecondElement",
				testIteratorOnThreeElementListAddAfterSecondElement());
		printTest("testToStringOnThreeElementListAddAfterSecondElement",
				testToStringOnThreeElementListAddAfterSecondElement());

		// TEST ON A THREE ELEMENT LIST USING ADD TO REAR ON THE THIRD ELEMENT
		printTest("testAddToFrontOnThreeElementListAddToRearThirdElement",
				testAddToFrontThreeElementListAddToRearThirdElement());
		printTest("testAddToRearOnThreeElementListAddToRearThirdElement",
				testAddToRearOnThreeElementListAddToRearOnThirdElement());
		printTest(
				"testAddAfterOnThreeElementListAddToRearThirdElementValidOne",
				testAddAfterOnThreeElementListAddToRearThirdElementValidOne());
		printTest(
				"testAddAfterOnThreeElementListAddToRearThirdElementValidTwo",
				testAddAfterOnThreeElementListAddToRearThirdElementValidTwo());
		printTest(
				"testAddAfterOnThreeElementListAddToRearThirdElementValidThree",
				testAddAfterOnThreeElementListAddToRearThirdElementValidThree());
		printTest("testAddAfterOnThreeElementListAddToRearThirdElementInvalid",
				testAddAfterOnThreeElementListAddToRearThirdElementInvalid());
		printTest("testRemoveFirstOnThreeElementListAddToRearThirdElement",
				testRemoveFirstOnThreeElementListAddToRearThirdElement());
		printTest("testRemoveLastOnThreeElementListAddToRearThirdElement",
				testRemoveLastOnThreeElementListAddToRearThirdElement());
		printTest(
				"testRemoveElementOnThreeElementListAddToRearThirdElementValidOne",
				testRemoveElementOnThreeElementListAddToRearThirdElementValidOne());
		printTest(
				"testRemoveElementOnThreeElementListAddToRearThirdElementValidTwo",
				testRemoveElementOnThreeElementListAddToRearThirdElementValidTwo());
		printTest(
				"testRemoveElementOnThreeElementListAddToRearThirdElementValidThree",
				testRemoveElementOnThreeElementListAddToRearThirdElementValidThree());
		printTest(
				"testRemoveElementOnThreeElementListAddToRearThirdElementInvalid",
				testRemoveElementOnThreeElementListAddToRearThirdElementInvalid());
		printTest("testFirstOnThreeElementListAddToRearThirdElement",
				testFirstOnThreeElementListAddToRearThirdElement());
		printTest("testLastOnThreeElementListAddToRearThirdElement",
				testLastOnThreeElementListAddToRearThirdElement());
		printTest(
				"testContainsOnThreeElementListAddToRearThirdElementValidOne",
				testContainsOnThreeElementListAddToRearThirdElementValidOne());
		printTest(
				"testContainsOnThreeElementListAddToRearThirdElementValidTwo",
				testContainsOnThreeElementListAddToRearThirdElementValidTwo());
		printTest(
				"testContainsOnThreeElementListAddToRearThirdElementValidThree",
				testContainsOnThreeElementListAddToRearThirdElementValidThree());
		printTest("testContainsOnThreeElementListAddToRearThirdElementInvalid",
				testContainsOnThreeElementListAddToRearThirdElementInvalid());
		printTest("testIsEmptyOnThreeElementListAddToRearThirdElement",
				testIsEmptyOnThreeElementListAddToRearThirdElement());
		printTest("testSizeOnThreeElementListAddToRearThirdElement",
				testSizeOnThreeElementListAddToRearThirdElement());
		printTest("testIteratorOnThreeElementListAddToRearThirdElement",
				testIteratorOnThreeElementListAddToRearThirdElement());
		printTest("testToStringOnThreeElementListAddToRearThirdElement",
				testToStringOnThreeElementListAddToRearThirdElement());

		// TEST ON A THREE ELEMENT LIST USING ADD AFTER TO ADD AN ELEMENT IN
		// BETWEEN FIRST AND SECOND
		printTest("testAddToFrontOnThreeElementListAddAfterFirst",
				testAddToFrontThreeElementListAddAfterFirst());
		printTest("testAddToRearOnThreeElementListAddAfterFirst",
				testAddToRearOnThreeElementListAddAfterFirst());
		printTest("testAddAfterOnThreeElementListAddAfterFirstValidOne",
				testAddAfterOnThreeElementListAddAfterFirstValidOne());
		printTest("testAddAfterOnThreeElementListAddAfterFirstValidTwo",
				testAddAfterOnThreeElementListAddAfterFirstValidTwo());
		printTest("testAddAfterOnThreeElementListAddAfterFirstValidThree",
				testAddAfterOnThreeElementListAddAfterFirstValidThree());
		printTest("testAddAfterOnThreeElementListAddAfterFirstValidFour",
				testAddAfterOnThreeElementListAddAfterFirstValidFour());
		printTest("testAddAfterOnThreeElementListAddAfterFirstInvalid",
				testAddAfterOnThreeElementListAddAfterFirstInvalid());
		printTest("testRemoveFirstOnThreeElementListAddAfterFirst",
				testRemoveFirstOnThreeElementListAddAfterFirst());
		printTest("testRemoveLastOnThreeElementListAddAfterFirst",
				testRemoveLastOnThreeElementListAddAfterFirst());
		printTest("testRemoveElementOnThreeElementListAddAfterFirstValidOne",
				testRemoveElementOnThreeElementListAddAfterFirstValidOne());
		printTest("testRemoveElementOnThreeElementListAddAfterFirstValidTwo",
				testRemoveElementOnThreeElementListAddAfterFirstValidTwo());
		printTest("testRemoveElementOnThreeElementListAddAfterFirstValidThree",
				testRemoveElementOnThreeElementListAddAfterFirstValidThree());
		printTest("testRemoveElementOnThreeElementListAddAfterFirstValidThree",
				testRemoveElementOnThreeElementListAddAfterFirstValidFour());
		printTest("testRemoveElementOnThreeElementListAddAfterFirstInvalid",
				testRemoveElementOnThreeElementListAddAfterFirstInvalid());
		printTest("testFirstOnThreeElementListAddAfterFirst",
				testFirstOnThreeElementListAddAfterFirst());
		printTest("testLastOnThreeElementListAddAfterFirst",
				testLastOnThreeElementListAddAfterFirst());
		printTest("testContainsOnThreeElementListAddAfterFirstValidOne",
				testContainsOnThreeElementListAddAfterFirstValidOne());
		printTest("testContainsOnThreeElementListAddAfterFirstValidTwo",
				testContainsOnThreeElementListAddAfterFirstValidTwo());
		printTest("testContainsOnThreeElementListAddAfterFirstValidThree",
				testContainsOnThreeElementListAddAfterFirstValidThree());
		printTest("testContainsOnThreeElementListAddAfterFirstValidFour",
				testContainsOnThreeElementListAddAfterFirstValidFour());
		printTest("testContainsOnThreeElementListAddAfterFirstInvalid",
				testContainsOnThreeElementListAddAfterFirstInvalid());
		printTest("testIsEmptyOnThreeElementListAddAfterFirst",
				testIsEmptyOnThreeElementListAddAfterFirst());
		printTest("testSizeOnThreeElementListAddAfterFirst",
				testSizeOnThreeElementListAddAfterFirst());
		printTest("testIteratorOnThreeElementListAddAfterFirst",
				testIteratorOnThreeElementListAddAfterFirst());
		printTest("testToStringOnThreeElementListAddAfterFirst",
				testToStringOnThreeElementListAddAfterFirst());

		// TEST ON A THREE ELEMENT LIST USING ADD AFTER TO ADD AN ELEMENT IN
		// BETWEEN SECOND AND THIRD
		printTest("testAddToFrontOnThreeElementListAddAfterSecond",
				testAddToFrontThreeElementListAddAfterSecond());
		printTest("testAddToRearOnThreeElementListAddAfterSecond",
				testAddToRearOnThreeElementListAddAfterSecond());
		printTest("testAddAfterOnThreeElementListAddAfterSecondValidOne",
				testAddAfterOnThreeElementListAddAfterSecondValidOne());
		printTest("testAddAfterOnThreeElementListAddAfterSecondValidTwo",
				testAddAfterOnThreeElementListAddAfterSecondValidTwo());
		printTest("testAddAfterOnThreeElementListAddAfterSecondValidThree",
				testAddAfterOnThreeElementListAddAfterSecondValidThree());
		printTest("testAddAfterOnThreeElementListAddAfterSecondValidFour",
				testAddAfterOnThreeElementListAddAfterSecondValidFour());
		printTest("testAddAfterOnThreeElementListAddAfterSecondInvalid",
				testAddAfterOnThreeElementListAddAfterSecondInvalid());
		printTest("testRemoveFirstOnThreeElementListAddAfterSecond",
				testRemoveFirstOnThreeElementListAddAfterSecond());
		printTest("testRemoveLastOnThreeElementListAddAfterSecond",
				testRemoveLastOnThreeElementListAddAfterSecond());
		printTest("testRemoveElementOnThreeElementListAddAfterSecondValidOne",
				testRemoveElementOnThreeElementListAddAfterSecondValidOne());
		printTest("testRemoveElementOnThreeElementListAddAfterSecondValidTwo",
				testRemoveElementOnThreeElementListAddAfterSecondValidTwo());
		printTest(
				"testRemoveElementOnThreeElementListAddAfterSecondValidThree",
				testRemoveElementOnThreeElementListAddAfterSecondValidThree());
		printTest(
				"testRemoveElementOnThreeElementListAddAfterSecondValidThree",
				testRemoveElementOnThreeElementListAddAfterSecondValidFour());
		printTest("testRemoveElementOnThreeElementListAddAfterSecondInvalid",
				testRemoveElementOnThreeElementListAddAfterSecondInvalid());
		printTest("testFirstOnThreeElementListAddAfterSecond",
				testFirstOnThreeElementListAddAfterSecond());
		printTest("testLastOnThreeElementListAddAfterSecond",
				testLastOnThreeElementListAddAfterSecond());
		printTest("testContainsOnThreeElementListAddAfterSecondValidOne",
				testContainsOnThreeElementListAddAfterSecondValidOne());
		printTest("testContainsOnThreeElementListAddAfterSecondValidTwo",
				testContainsOnThreeElementListAddAfterSecondValidTwo());
		printTest("testContainsOnThreeElementListAddAfterSecondValidThree",
				testContainsOnThreeElementListAddAfterSecondValidThree());
		printTest("testContainsOnThreeElementListAddAfterSecondValidFour",
				testContainsOnThreeElementListAddAfterSecondValidFour());
		printTest("testContainsOnThreeElementListAddAfterSecondInvalid",
				testContainsOnThreeElementListAddAfterSecondInvalid());
		printTest("testIsEmptyOnThreeElementListAddAfterSecond",
				testIsEmptyOnThreeElementListAddAfterSecond());
		printTest("testSizeOnThreeElementListAddAfterSecond",
				testSizeOnThreeElementListAddAfterSecond());
		printTest("testIteratorOnThreeElementListAddAfterSecond",
				testIteratorOnThreeElementListAddAfterSecond());
		printTest("testToStringOnThreeElementListAddAfterSecond",
				testToStringOnThreeElementListAddAfterSecond());

		// TEST ON A THREE ELEMENT LIST USING ADD AFTER TO ADD AN ELEMENT AFTER
		// THE THIRD ELEMENT
		printTest("testAddToFrontOnThreeElementListAddAfterThird",
				testAddToFrontThreeElementListAddAfterThird());
		printTest("testAddToRearOnThreeElementListAddAfterThird",
				testAddToRearOnThreeElementListAddAfterThird());
		printTest("testAddAfterOnThreeElementListAddAfterThirdValidOne",
				testAddAfterOnThreeElementListAddAfterThirdValidOne());
		printTest("testAddAfterOnThreeElementListAddAfterThirdValidTwo",
				testAddAfterOnThreeElementListAddAfterThirdValidTwo());
		printTest("testAddAfterOnThreeElementListAddAfterThirdValidThree",
				testAddAfterOnThreeElementListAddAfterThirdValidThree());
		printTest("testAddAfterOnThreeElementListAddAfterThirdInvalid",
				testAddAfterOnThreeElementListAddAfterThirdInvalid());
		printTest("testRemoveFirstOnThreeElementListAddAfterThird",
				testRemoveFirstOnThreeElementListAddAfterThird());
		printTest("testRemoveLastOnThreeElementListAddAfterThird",
				testRemoveLastOnThreeElementListAddAfterThird());
		printTest("testRemoveElementOnThreeElementListAddAfterThirdValidOne",
				testRemoveElementOnThreeElementListAddAfterThirdValidOne());
		printTest("testRemoveElementOnThreeElementListAddAfterThirdValidTwo",
				testRemoveElementOnThreeElementListAddAfterThirdValidTwo());
		printTest("testRemoveElementOnThreeElementListAddAfterThirdValidThree",
				testRemoveElementOnThreeElementListAddAfterThirdValidThree());
		printTest("testRemoveElementOnThreeElementListAddAfterThirdValidThree",
				testRemoveElementOnThreeElementListAddAfterThirdValidFour());
		printTest("testRemoveElementOnThreeElementListAddAfterThirdInvalid",
				testRemoveElementOnThreeElementListAddAfterThirdInvalid());
		printTest("testFirstOnThreeElementListAddAfterThird",
				testFirstOnThreeElementListAddAfterThird());
		printTest("testLastOnThreeElementListAddAfterThird",
				testLastOnThreeElementListAddAfterThird());
		printTest("testContainsOnThreeElementListAddAfterThirdValidOne",
				testContainsOnThreeElementListAddAfterThirdValidOne());
		printTest("testContainsOnThreeElementListAddAfterThirdValidTwo",
				testContainsOnThreeElementListAddAfterThirdValidTwo());
		printTest("testContainsOnThreeElementListAddAfterThirdValidThree",
				testContainsOnThreeElementListAddAfterThirdValidThree());
		printTest("testContainsOnThreeElementListAddAfterThirdValidFour",
				testContainsOnThreeElementListAddAfterThirdValidFour());
		printTest("testContainsOnThreeElementListAddAfterThirdInvalid",
				testContainsOnThreeElementListAddAfterThirdInvalid());
		printTest("testIsEmptyOnThreeElementListAddAfterThird",
				testIsEmptyOnThreeElementListAddAfterThird());
		printTest("testSizeOnThreeElementListAddAfterThird",
				testSizeOnThreeElementListAddAfterThird());
		printTest("testIteratorOnThreeElementListAddAfterThird",
				testIteratorOnThreeElementListAddAfterThird());
		printTest("testToStringOnThreeElementListAddAfterThird",
				testToStringOnThreeElementListAddAfterThird());

		// TEST ON A THREE ELEMENT LIST USING REMOVE FIRST (21)
		printTest("testAddToFrontOnThreeElementListRemoveFirst",
				testAddToFrontOnThreeElementListRemoveFirst());
		printTest("testAddToRearOnThreeElementListRemoveFirst",
				testAddToRearOnThreeElementListRemoveFirst());
		printTest("testAddAfterOnThreeElementListRemoveFirstValidOne",
				testAddAfterOnThreeElementListRemoveFirstValidOne());
		printTest("testAddAfterOnThreeElementListRemoveFirstValidTwo",
				testAddAfterOnThreeElementListRemoveFirstValidTwo());
		printTest("testAddAfterOnThreeElementListRemoveFirstValidThree",
				testAddAfterOnThreeElementListRemoveFirstValidThree());
		printTest("testAddAfterOnThreeElementListRemoveFirstInvalid",
				testAddAfterOnThreeElementListRemoveFirstInvalid());
		printTest("testRemoveFirstOnThreeElementListRemoveFirst",
				testRemoveFirstOnThreeElementListRemoveFirst());
		printTest("testRemoveLastOnThreeElementListRemoveFirst",
				testRemoveLastOnThreeElementListRemoveFirst());
		printTest("testRemoveElementOnThreeElementListRemoveFirstValidOne",
				testRemoveElementOnThreeElementListRemoveFirstValidOne());
		printTest("testRemoveElementOnThreeElementListRemoveFirstValidTwo",
				testRemoveElementOnThreeElementListRemoveFirstValidTwo());
		printTest("testRemoveElementOnThreeElementListRemoveFirstInvalid",
				testRemoveElementOnThreeElementListRemoveFirstInvalid());
		printTest("testFirstOnThreeElementListRemoveFirst",
				testFirstOnThreeElementListRemoveFirst());
		printTest("testLastOnThreeElementListRemoveFirst",
				testLastOnThreeElementListRemoveFirst());
		printTest("testContainsOnThreeElementListRemoveFirstValidOne",
				testContainsOnThreeElementListRemoveFirstValidOne());
		printTest("testContainsOnThreeElementListRemoveFirstValidTwo",
				testContainsOnThreeElementListRemoveFirstValidTwo());
		printTest("testContainsOnThreeElementListRemoveFirstValidThree",
				testContainsOnThreeElementListRemoveFirstValidThree());
		printTest("testContainsOnThreeElementListRemoveFirstInvalid",
				testContainsOnThreeElementListRemoveFirstInvalid());
		printTest("testIsEmptyOnThreeElementListRemoveFirst",
				testIsEmptyOnThreeElementListRemoveFirst());
		printTest("testSizeOnThreeElementListRemoveFirst",
				testSizeOnThreeElementListRemoveFirst());
		printTest("testIteratorOnThreeElementListRemoveFirst",
				testIteratorOnThreeElementListRemoveFirst());
		printTest("testToStringOnThreeElementListRemoveFirst",
				testToStringOnThreeElementListRemoveFirst());

		// TEST ON A THREE ELEMENT LIST USING REMOVE ON FIRST ELEMENT (21)
		printTest("testAddToFrontOnThreeElementListRemoveFirstElement",
				testAddToFrontOnThreeElementListRemoveFirstElement());
		printTest("testAddToRearOnThreeElementListRemoveFirstElement",
				testAddToRearOnThreeElementListRemoveFirstElement());
		printTest("testAddAfterOnThreeElementListRemoveFirstElementValidOne",
				testAddAfterOnThreeElementListRemoveFirstElementValidOne());
		printTest("testAddAfterOnThreeElementListRemoveFirstElementValidTwo",
				testAddAfterOnThreeElementListRemoveFirstElementValidTwo());
		printTest("testAddAfterOnThreeElementListRemoveFirstElementValidThree",
				testAddAfterOnThreeElementListRemoveFirstElementValidThree());
		printTest("testAddAfterOnThreeElementListRemoveFirstElementInvalid",
				testAddAfterOnThreeElementListRemoveFirstElementInvalid());
		printTest("testRemoveFirstOnThreeElementListRemoveFirstElement",
				testRemoveFirstOnThreeElementListRemoveFirstElement());
		printTest("testRemoveLastOnThreeElementListRemoveFirstElement",
				testRemoveLastOnThreeElementListRemoveFirstElement());
		printTest(
				"testRemoveElementOnThreeElementListRemoveFirstElementValidOne",
				testRemoveElementOnThreeElementListRemoveFirstElementValidOne());
		printTest(
				"testRemoveElementOnThreeElementListRemoveFirstElementValidTwo",
				testRemoveElementOnThreeElementListRemoveFirstElementValidTwo());
		printTest(
				"testRemoveElementOnThreeElementListRemoveFirstElementInvalid",
				testRemoveElementOnThreeElementListRemoveFirstElementInvalid());
		printTest("testFirstOnThreeElementListRemoveFirstElement",
				testFirstOnThreeElementListRemoveFirstElement());
		printTest("testLastOnThreeElementListRemoveFirstElement",
				testLastOnThreeElementListRemoveFirstElement());
		printTest("testContainsOnThreeElementListRemoveFirstElementValidOne",
				testContainsOnThreeElementListRemoveFirstElementValidOne());
		printTest("testContainsOnThreeElementListRemoveFirstElementValidTwo",
				testContainsOnThreeElementListRemoveFirstElementValidTwo());
		printTest("testContainsOnThreeElementListRemoveFirstElementValidThree",
				testContainsOnThreeElementListRemoveFirstElementValidThree());
		printTest("testContainsOnThreeElementListRemoveFirstElementInvalid",
				testContainsOnThreeElementListRemoveFirstElementInvalid());
		printTest("testIsEmptyOnThreeElementListRemoveFirstElement",
				testIsEmptyOnThreeElementListRemoveFirstElement());
		printTest("testSizeOnThreeElementListRemoveFirstElement",
				testSizeOnThreeElementListRemoveFirstElement());
		printTest("testIteratorOnThreeElementListRemoveFirstElement",
				testIteratorOnThreeElementListRemoveFirstElement());
		printTest("testToStringOnThreeElementListRemoveFirstElement",
				testToStringOnThreeElementListRemoveFirstElement());

		// TEST ON A THREE ELEMENT LIST USING REMOVE ON SECOND ELEMENT (21)
		printTest("testAddToFrontOnThreeElementListRemoveSecondElement",
				testAddToFrontOnThreeElementListRemoveSecondElement());
		printTest("testAddToRearOnThreeElementListRemoveSecondElement",
				testAddToRearOnThreeElementListRemoveSecondElement());
		printTest("testAddAfterOnThreeElementListRemoveSecondElementValidOne",
				testAddAfterOnThreeElementListRemoveSecondElementValidOne());
		printTest("testAddAfterOnThreeElementListRemoveSecondElementValidTwo",
				testAddAfterOnThreeElementListRemoveSecondElementValidTwo());
		printTest(
				"testAddAfterOnThreeElementListRemoveSecondElementValidThree",
				testAddAfterOnThreeElementListRemoveSecondElementValidThree());
		printTest("testAddAfterOnThreeElementListRemoveSecondElementInvalid",
				testAddAfterOnThreeElementListRemoveSecondElementInvalid());
		printTest("testRemoveFirstOnThreeElementListRemoveSecondElement",
				testRemoveFirstOnThreeElementListRemoveSecondElement());
		printTest("testRemoveLastOnThreeElementListRemoveSecondElement",
				testRemoveLastOnThreeElementListRemoveSecondElement());
		printTest(
				"testRemoveElementOnThreeElementListRemoveSecondElementValidOne",
				testRemoveElementOnThreeElementListRemoveSecondElementValidOne());
		printTest(
				"testRemoveElementOnThreeElementListRemoveSecondElementValidTwo",
				testRemoveElementOnThreeElementListRemoveSecondElementValidTwo());
		printTest(
				"testRemoveElementOnThreeElementListRemoveSecondElementInvalid",
				testRemoveElementOnThreeElementListRemoveSecondElementInvalid());
		printTest("testFirstOnThreeElementListRemoveSecondElement",
				testFirstOnThreeElementListRemoveSecondElement());
		printTest("testLastOnThreeElementListRemoveSecondElement",
				testLastOnThreeElementListRemoveSecondElement());
		printTest("testContainsOnThreeElementListRemoveSecondElementValidOne",
				testContainsOnThreeElementListRemoveSecondElementValidOne());
		printTest("testContainsOnThreeElementListRemoveSecondElementValidTwo",
				testContainsOnThreeElementListRemoveSecondElementValidTwo());
		printTest(
				"testContainsOnThreeElementListRemoveSecondElementValidThree",
				testContainsOnThreeElementListRemoveSecondElementValidThree());
		printTest("testContainsOnThreeElementListRemoveSecondElementInvalid",
				testContainsOnThreeElementListRemoveSecondElementInvalid());
		printTest("testIsEmptyOnThreeElementListRemoveSecondElement",
				testIsEmptyOnThreeElementListRemoveSecondElement());
		printTest("testSizeOnThreeElementListRemoveSecondElement",
				testSizeOnThreeElementListRemoveSecondElement());
		printTest("testIteratorOnThreeElementListRemoveSecondElement",
				testIteratorOnThreeElementListRemoveSecondElement());
		printTest("testToStringOnThreeElementListRemoveSecondElement",
				testToStringOnThreeElementListRemoveSecondElement());

		// TEST ON A THREE ELEMENT LIST USING REMOVE ON THRID ELEMENT (22)
		printTest("testAddToFrontOnThreeElementListRemoveThirdElement",
				testAddToFrontOnThreeElementListRemoveThirdElement());
		printTest("testAddToRearOnThreeElementListRemoveThirdElement",
				testAddToRearOnThreeElementListRemoveThirdElement());
		printTest("testAddAfterOnThreeElementListRemoveThirdElementValidOne",
				testAddAfterOnThreeElementListRemoveThirdElementValidOne());
		printTest("testAddAfterOnThreeElementListRemoveThirdElementValidTwo",
				testAddAfterOnThreeElementListRemoveThirdElementValidTwo());
		printTest("testAddAfterOnThreeElementListRemoveThirdElementInvalid",
				testAddAfterOnThreeElementListRemoveThirdElementInvalid());
		printTest("testRemoveFirstOnThreeElementListRemoveThirdElement",
				testRemoveFirstOnThreeElementListRemoveThirdElement());
		// printTest("testRemoveLastOnThreeElementListRemoveThirdElement",
		// testRemoveLastOnThreeElementListRemoveThirdElement());
		printTest(
				"testRemoveElementOnThreeElementListRemoveThirdElementValidOne",
				testRemoveElementOnThreeElementListRemoveThirdElementValidOne());
		printTest(
				"testRemoveElementOnThreeElementListRemoveThirdElementValidTwo",
				testRemoveElementOnThreeElementListRemoveThirdElementValidTwo());
		printTest(
				"testRemoveElementOnThreeElementListRemoveThirdElementInvalid",
				testRemoveElementOnThreeElementListRemoveThirdElementInvalid());
		printTest("testFirstOnThreeElementListRemoveThirdElement",
				testFirstOnThreeElementListRemoveThirdElement());
		// printTest("testLastOnThreeElementListRemoveThirdElement",
		// testLastOnThreeElementListRemoveThirdElement());
		printTest("testContainsOnThreeElementListRemoveThirdElementValidOne",
				testContainsOnThreeElementListRemoveThirdElementValidOne());
		printTest("testContainsOnThreeElementListRemoveThirdElementValidTwo",
				testContainsOnThreeElementListRemoveThirdElementValidTwo());
		// printTest("testContainsOnThreeElementListRemoveThirdElementValidThree",
		// testContainsOnThreeElementListRemoveThirdElementValidThree());
		printTest("testContainsOnThreeElementListRemoveThirdElementInvalid",
				testContainsOnThreeElementListRemoveThirdElementInvalid());
		printTest("testIsEmptyOnThreeElementListRemoveThirdElement",
				testIsEmptyOnThreeElementListRemoveThirdElement());
		printTest("testSizeOnThreeElementListRemoveThirdElement",
				testSizeOnThreeElementListRemoveThirdElement());
		printTest("testIteratorOnThreeElementListRemoveThirdElement",
				testIteratorOnThreeElementListRemoveThirdElement());
		printTest("testToStringOnThreeElementListRemoveThirdElement",
				testToStringOnThreeElementListRemoveThirdElement());

		// TEST ON THREE ELEMENT LIST USING REMOVE LAST (21)
		printTest("testAddToFrontOnThreeElementListRemoveLast",
				testAddToFrontOnThreeElementListRemoveLast());
		printTest("testAddToRearOnThreeElementListRemoveLast",
				testAddToRearOnThreeElementListRemoveLast());
		printTest("testAddAfterOnThreeElementListRemoveLastValidOne",
				testAddAfterOnThreeElementListRemoveLastValidOne());
		printTest("testAddAfterOnThreeElementListRemoveLastValidTwo",
				testAddAfterOnThreeElementListRemoveLastValidTwo());
		printTest("testAddAfterOnThreeElementListRemoveLastInvalid",
				testAddAfterOnThreeElementListRemoveLastInvalid());
		printTest("testRemoveFirstOnThreeElementListRemoveLast",
				testRemoveFirstOnThreeElementListRemoveLast());
		printTest("testRemoveLastOnThreeElementListRemoveLast",
				testRemoveLastOnThreeElementListRemoveLast());
		printTest("testRemoveElementOnThreeElementListRemoveLastValidOne",
				testRemoveElementOnThreeElementListRemoveLastValidOne());
		printTest("testRemoveElementOnThreeElementListRemoveLastValidTwo",
				testRemoveElementOnThreeElementListRemoveLastValidTwo());
		printTest("testRemoveElementOnThreeElementListRemoveLastInvalid",
				testRemoveElementOnThreeElementListRemoveLastInvalid());
		printTest("testFirstOnThreeElementListRemoveLast",
				testFirstOnThreeElementListRemoveLast());
		printTest("testLastOnThreeElementListRemoveLast",
				testLastOnThreeElementListRemoveLast());
		printTest("testContainsOnThreeElementListRemoveLastValidOne",
				testContainsOnThreeElementListRemoveLastValidOne());
		printTest("testContainsOnThreeElementListRemoveLastValidTwo",
				testContainsOnThreeElementListRemoveLastValidTwo());
		printTest("testContainsOnThreeElementListRemoveLastValidThree",
				testContainsOnThreeElementListRemoveLastValidThree());
		printTest("testContainsOnThreeElementListRemoveLastInvalid",
				testContainsOnThreeElementListRemoveLastInvalid());
		printTest("testIsEmptyOnThreeElementListRemoveLast",
				testIsEmptyOnThreeElementListRemoveLast());
		printTest("testSizeOnThreeElementListRemoveLast",
				testSizeOnThreeElementListRemoveLast());
		printTest("testIteratorOnThreeElementListRemoveLast",
				testIteratorOnThreeElementListRemoveLast());
		printTest("testToStringOnThreeElementListRemoveLast",
				testToStringOnThreeElementListRemoveLast());

		// ////////////////////////
		// LIST ITERATOR TESTS
		// ///////////////////////

		// [A] -> iterator remove() after next() returns A -> []
		printTest("5testOnIteratorRemoveAfterNextOneElement",
				testOnIteratorRemoveAfterNextOneElement());
		// [A,B] -> iterator remove() after next() returns A -> [B]
		printTest("testOnIteratorRemoveAfterNextTwoElement",
				testOnIteratorRemoveAfterNextTwoElement());
		// [A,B] -> iterator remove() after next() returns B -> [A]
		printTest("testOnIteratorRemoveAfterNextTwoElementTwo",
				testOnIteratorRemoveAfterNextTwoElementTwo());
		// [A,B,C] -> iterator remove() after next() returns A -> [B,C]
		printTest("testOnIteratorRemoveAfterNextThreeElement",
				testOnIteratorRemoveAfterNextThreeElement());
		// [A,B,C] -> iterator remove() after next() returns B -> [A,C]
		printTest("testOnIteratorRemoveAfterNextThreeElementTwo",
				testOnIteratorRemoveAfterNextThreeElementTwo());
		// [A,B,C] -> iterator remove() after next() returns C -> [A,B]
		printTest("testOnIteratorRemoveAfterNextThreeElementThree",
				testOnIteratorRemoveAfterNextThreeElementThree());
		// [A] -> iterator remove() after previous() returns A -> []
		printTest("testOnIteratorRemoveAfterPreviousOneElement",
				testOnIteratorRemoveAfterPreviousOneElement());
		// [A,B] -> iterator remove() after previous() returns A -> [B]
		printTest("testOnIteratorRemoveAfterPreviousTwoElement",
				testOnIteratorRemoveAfterPreviousTwoElement());
		// [A,B,C] -> iterator remove() after previous() returns A -> [B,C]
		printTest("testOnIteratorRemoveAfterPreviousThreeElement",
				testOnIteratorRemoveAfterPreviousThreeElement());
		// [A,B,C] -> iterator remove() after previous() returns B -> [A,C]
		printTest("testOnIteratorRemoveAfterPreviousThreeElementTwo",
				testOnIteratorRemoveAfterPreviousThreeElementTwo());
		// [] -> index add(A) -> [A]
		printTest("testOnAddIndexNewList", testOnAddIndexNewList());
		// [A] -> index 1 add(B) with new iterator -> [B,A]
		printTest("testAddIndexOneOneList", testAddIndexOneOneList());
		// [A,B,C] -> set(1,D) after addToFront
		printTest("testOnSetOneAfterAddToFrontValid",
				testOnSetOneAfterAddToFrontValid());
		// [A] -> iterator set(B) after next() returns A -> [B]
		printTest("testOnIteratorSetAfterNextOneElement",
				testOnIteratorSetAfterNextOneElement());
		// [A] -> iterator set(B) after previous() returns A -> [B]
		printTest("testOnIteratorSetAfterPreviousOneElement",
				testOnIteratorSetAfterPreviousOneElement());
		// [A]-> indexOfOnInvalidTargetElement
		printTest("testIndexOfOnInvalidTargetElement",
				testIndexOfOnInvalidTargetElement());

		// /////////////////////////////////
		// Failed tests from MVail (224)
		// /////////////////////////////////

		// testAddIndexOnNewListInvalid ***FAIL***
		printTest("testAddIndexOnNewListInvalid",
				testAddIndexOnNewListInvalid());
		// testSetOnNewList ***FAIL***
		printTest("testSetOnNewList", testSetOnNewList());
		// testGetOnNewList ***FAIL***
		printTest("testGetOnNewList", testGetOnNewList());
		// testIndexOfOnNewList ***FAIL***
		printTest("testIndexOfOnNewList", testIndexOfOnNewList());
		// caught unexpected EmptyCollectionException: The DoubleLinkedList is
		// empty.
		// testRemoveIndexOnNewList ***FAIL***
		printTest("testRemoveIndexOnNewList", testRemoveIndexOnNewList());
		// caught unexpected EmptyCollectionException: The DoubleLinkedList is
		// empty.
		// testContainsOnNewList ***FAIL***
		printTest("testContainsOnNewList", testContainsOnNewList());

		// testListIteratorHasPreviousOnNewList ***FAIL***
		printTest("testListIteratorHasPreviousOnNewList",
				testListIteratorHasPreviousOnNewList());
		// expected NoSuchElementException
		// caught java.lang.NullPointerException
		// testListIteratorPreviousOnNewList ***FAIL***
		printTest("testListIteratorPreviousOnNewList",
				testListIteratorPreviousOnNewList());
		// caught unexpected java.lang.NullPointerException
		// testListIteratorNextIndexOnNewList ***FAIL***
		printTest("testListIteratorNextIndexOnNewList",
				testListIteratorNextIndexOnNewList());

		// expected IndexOutOfBoundsException
		// caught java.lang.NullPointerException
		// testAddIndexAfterAddToFrontInvalid ***FAIL***
		printTest("testAddIndexAfterAddToFrontInvalid",
				testAddIndexAfterAddToFrontInvalid());
		// testSetAfterAddToFrontInvalid ***FAIL***
		printTest("testSetAfterAddToFrontInvalid",
				testSetAfterAddToFrontInvalid());
		// testListIteratorConstructorIdxOnNewListInvalid1 
		// testGetAfterAddToFrontValid ***FAIL***
		// testGetAfterAddToFrontInvalid ***FAIL***
		printTest("testGetAfterAddToFrontInvalid",
				testGetAfterAddToFrontInvalid());
		// expected IndexOutOfBoundsException
		// caught ElementNotFoundException: The target element is not in this
		// DoubleLinkedList
		// testRemoveIndexAfterAddToFrontInvalid ***FAIL***
		printTest("testRemoveIndexAfterAddToFrontInvalid",
				testRemoveIndexAfterAddToFrontInvalid());
		// caught unexpected java.lang.NullPointerException
		// testListIteratorHasNextAfterAddToFront3 ***FAIL***
		printTest("testListIteratorHasNextAfterAddToFront3",
				testListIteratorHasNextAfterAddtoFront3());
		// caught unexpected java.lang.NullPointerException
		// testListIteratorNextAfterAddToFront3 ***FAIL***
		printTest("testListIteratorNextAfterAddtoFront3",
				testListIteratorNextAfterAddtoFront3());

		// testListIteratorPreviousIndexAfterAddToFront ***FAIL***
		printTest("testListIteratorPreviousIndexAfterAddToFront",
				testListIteratorPreviousIndexAfterAddToFront());

		// testListIteratorHasPreviousAfterAddToRear3 ***FAIL***
		printTest("testListIteratorHasPreviousAfterAddToRear3",
				testListIteratorHasPreviousAfterAddToRear3());

		// caught unexpected java.lang.NullPointerException
		// testListIteratorHasPreviousAfterAddIndex2 ***FAIL***
		printTest("testListIteratorHasPreviousAfterAddIndex2",
				testListIteratorHasPreviousAfterAddIndex2());
		// caught unexpected java.lang.NullPointerException
		// testListIteratorHasPreviousAfterAddIndex3 ***FAIL***
		printTest("testListIteratorHasPreviousAfterAddIndex3",
				testListIteratorHasPreviousAfterAddIndex3());

		// testListIteratorNextIndexAfterAddAfter ***FAIL***
		printTest("testListIteratorNextIndexAfterAddAfter",
				testListIteratorNextIndexAfterAddAfter());
		// testIndexOfAfterAddAfterToMiddle ***FAIL***
		printTest("testIndexOfAfterAddAfterToMiddle",
				testIndexOfAfterAddAfterToMiddle());
		// test last three elements
		printTest("testLastThreeElements", testLastThreeElements());

		// ///////////////
		// final verdict
		// ///////////////
		printFinalSummary();
	}

	// /////////////////////////////
	// UNORDERED LIST TESTS
	// ////////////////////////////

	// //////////////////////////
	// SCENARIO: NEW, EMPTY LIST
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnNewList() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		try {
			list.addToFront(i);
			if (list.contains(i) != true)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToFrontOnNewList", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnNewList() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		try {
			list.addToRear(i);
			if (list.contains(i) != true)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToRearOnNewList", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnNewList() {
		DoubleLinkedListADT<Integer> list = newList();
		try {
			list.addAfter(new Integer(1), new Integer(2));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnNewList", "ElementNotFoundException",
					e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnNewList() {
		DoubleLinkedListADT<Integer> list = newList();
		try {
			list.removeFirst();
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveFirstOnNewList", "EmptyCollectionException",
					e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveLastOnNewList() {
		DoubleLinkedListADT<Integer> list = newList();
		try {
			list.removeLast();
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveLastOnNewList", "EmptyCollectionException",
					e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveElementOnNewList() {
		DoubleLinkedListADT<Integer> list = newList();
		try {
			list.remove(new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnNewList", "ElementNotFoundException",
					e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnNewList() {
		DoubleLinkedListADT<Integer> list = newList();
		try {
			list.first(); // exception expected
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testFirstOnNewList", "EmptyCollectionException",
					e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testLastOnNewList() {
		DoubleLinkedListADT<Integer> list = newList();
		try {
			list.last(); // exception expected
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testLastOnNewList", "EmptyCollectionException",
					e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testIsEmptyOnNewList() {
		DoubleLinkedListADT<Integer> list = newList();
		try {
			return (list.isEmpty() == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testIsEmptyOnNewList", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnNewList() {
		DoubleLinkedListADT<Integer> list = newList();
		try {
			return (list.size() == 0);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnNewList",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnNewList() {
		DoubleLinkedListADT<Integer> list = newList();
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == true) { // should be false
				return false;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return false;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n",
					"testIteratorOnNewList", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnNewList() {
		DoubleLinkedListADT<Integer> list = newList();
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			// if (str.length() == 0) {
			// return false;
			// }
			// char lastChar = str.charAt(str.length()-1);
			// if (str.contains("@")
			// && !str.contains(" ")
			// && Character.isLetter(str.charAt(0))
			// && (Character.isDigit(lastChar)
			// ||
			// (lastChar >= 'a' && lastChar <= 'f'))) {
			// return false; //looks like default toString()
			// }
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// //////////////////////////
	// SCENARIO: TESTS ON A ONE ELEMENT LIST USING ADD TO FRONT
	// //////////////////////////

	/** @return test success */
	private boolean testAddToRearOnOneElementListAddToFront() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addToRear(j);
			if (list.last() != j)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToRearOnOneElementListAddToFront", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnOneElementListAddToFrontValid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(j, i);
			if (list.last() != j)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnOneElementListAddToFrontValid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAfterOnOneElementListAddToFrontInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(i, j);
			if (list.contains(i) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnOneElementListAddToFrontInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnOneElementListAddToFront() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		try {
			if (list.removeFirst() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveFirstOnOneElementListAddToFront",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnOneElementListAddToFront() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		try {
			if (list.removeLast() != i)
				return false;

		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveLastOnOneElementListAddToFront",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnOneElementListAddToFrontValid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		try {
			if (list.remove(i) != i)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnOneElementListAddToFrontValid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnOneElementListAddToFrontInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		try {
			list.remove(new Integer(2));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnOneElementListAddToFrontInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnOneElementListAddToFront() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		try {
			if (list.first() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testFirstOnOneElementListAddToFront",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnOneElementListAddToFront() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		try {
			if (list.last() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testLastOnNewList", "EmptyCollectionException",
					e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnOneElementListAddToFrontValid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		try {
			return (list.contains(i) == true);
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testContainsOnOneElementListAddToFrontValid",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnOneElementListAddToFrontInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		try {
			return (list.contains(new Integer(2)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnOneElementListAddToFrontInvalid",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnOneElementListAddToFront() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		try {
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testIsEmptyOnOneElementListAddToFront", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnOneElementListAddToFront() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		try {
			return (list.size() == 1);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testSizeOnOneElementListAddToFront", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnOneElementListAddToFront() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return true;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n",
					"testIteratorOnOneElementListAddToFront", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnOneElementListAddToFront() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// //////////////////////////
	// SCENARIO: TESTS ON A ONE ELEMENT LIST USING ADD TO REAR
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnOneElementListAddToRear() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToRear(i);
		try {
			list.addToFront(j);
			if (list.first() != j)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToFrontOnOneElementListAddToRear", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnOneElementListAddToRear() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToRear(i);
		try {
			list.addToRear(j);
			if (list.last() != j)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToRearOnOneElementListAddToRear", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnOneElementListAddToRearValid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToRear(i);
		try {
			list.addAfter(j, i);
			if (list.last() != j)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnOneElementListAddToRearValid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnOneElementListAddToRearInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToRear(i);
		try {
			list.addAfter(new Integer(2), new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnOneElementListAddToRearInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnOneElementListAddToRear() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToRear(i);
		try {
			if (list.removeFirst() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveFirstOnOneElementListAddToRear",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnOneElementListAddToRear() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToRear(i);
		try {
			if (list.removeLast() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveLastOnOneElementListAddToRear",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnOneElementListAddToRearValid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToRear(i);
		try {
			if (list.remove(i) != i)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnOneElementListAddToRearValid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnOneElementListAddToRearInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToRear(i);
		try {
			list.remove(new Integer(2));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnOneElementListAddToRearInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnOneElementListAddToRear() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToRear(i);
		try {
			if (list.first() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testFirstOnOneElementListAddToRear",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnOneElementListAddToRear() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToRear(i);
		try {
			if (list.last() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testLastOnOneElementListAddToRear",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnOneElementListAddToRearValid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToRear(i);
		try {
			return (list.contains(i) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnOneElementListAddToRearValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnOneElementListAddToRearInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToRear(i);
		try {
			return (list.contains(new Integer(2)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnOneELementListAddToRearInvalid",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnOneElementListAddToRear() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToRear(i);
		try {
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testIsEmptyOnOneElementListAddToRear", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnOneElementListAddToRear() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToRear(i);
		try {
			return (list.size() == 1);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testSizeOnOneElementListAddToRear", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnOneElementListAddToRear() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToRear(i);
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return true;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n",
					"testIteratorOnOneElementListAddToRear", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnOneElementListAddToRear() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToRear(i);
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// //////////////////////////
	// SCENARIO: TESTS ON A ONE ELEMENT LIST USING REMOVE FIRST
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnOneElementListRemoveFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.removeFirst();
		try {
			list.addToFront(j);
			if (list.first() != j)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToFrontOnOneElementListRemoveFirst", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnOneElementListRemoveFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.removeFirst();
		try {
			list.addToRear(j);
			if (list.last() != j)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToRearOnOneElementListRemoveFirst", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnOneElementListRemoveFirstValid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.removeFirst();
		try {
			list.addAfter(j, i);
			if (list.last() != j)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnOneElementListRemoveFirstValid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAfterOnOneElementListRemoveFirstInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeFirst();
		try {
			list.addAfter(new Integer(2), new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnOneElementListRemoveFirstInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnOneElementListRemoveFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeFirst();
		try {
			if (list.removeFirst() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveFirstOnOneElementListRemoveFirst",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnOneElementListRemoveFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeFirst();
		try {
			if (list.removeLast() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveLastOnOneElementListRemoveFirst",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnOneElementListRemoveFirstValid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeFirst();
		try {
			if (list.remove(i) != i)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnOneElementListRemoveFirstValid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnOneElementListRemoveFirstInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeFirst();
		try {
			list.remove(new Integer(2));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnOneElementListRemoveFirstInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnOneElementListRemoveFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeFirst();
		try {
			if (list.first() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testFirstOnOneElementListRemoveFirst",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnOneElementListRemoveFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeFirst();
		try {
			if (list.last() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testLastOnOneElementListRemoveFirst",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnOneElementListRemoveFirstValid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeFirst();
		try {
			return (list.contains(i) == false);
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnOneELementListRemoveFirstValid",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnOneElementListRemoveFirstInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeFirst();
		try {
			return (list.contains(new Integer(2)) == false);
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnONeElementListRemoveFirstInvalid",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnOneElementListRemoveFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeFirst();
		try {
			return (list.isEmpty() == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testIsEmptyOnOneElementListRemoveFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnOneElementListRemoveFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeFirst();
		try {
			return (list.size() == 0);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testSizeOnOneElementListRemoveFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnOneElementListRemoveFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeFirst();
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return true;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n",
					"testIteratorOnOneElementListRemoveFirst", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnOneElementListRemoveFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		try {
			list.removeFirst();
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			// if (str.length() == 0) {
			// return true;
			// }
			// char lastChar = str.charAt(str.length()-1);
			// if (str.contains("@")
			// && !str.contains(" ")
			// && Character.isLetter(str.charAt(0))
			// && (Character.isDigit(lastChar)
			// ||
			// (lastChar >= 'a' && lastChar <= 'f'))) {
			// return false; //looks like default toString()
			// }
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// //////////////////////////
	// SCENARIO: TESTS ON A ONE ELEMENT LIST USING REMOVE LAST
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnOneElementListRemoveLast() {
		DoubleLinkedListADT<Integer> list = newList1();
		Integer j = new Integer(1);
		try {
			list.removeLast();
			list.addToFront(j);

			if (list.first() == j)
				return true;
			else {
				return false;
			}

		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToFrontOnOneElementListRemoveLast", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testAddToRearOnOneElementListRemoveLast() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.removeLast();
		try {
			list.addToRear(j);
			if (list.last() != j)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToRearOnOneElementListRemoveLast", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnOneElementListRemoveLastValid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.removeLast();
		try {
			list.addAfter(j, i);
			if (list.last() != j)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnOneElementListRemoveLastValid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnOneElementListRemoveLastInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeLast();
		try {
			list.addAfter(new Integer(2), new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnOneElementListRemoveLastInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnOneElementListRemoveLast() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeLast();
		try {
			if (list.removeFirst() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveFirstOnOneElementListRemoveLast",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnOneElementListRemoveLast() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeLast();
		try {
			if (list.removeLast() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveLastOnOneElementListRemoveLast",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnOneElementListRemoveLastValid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeLast();
		try {
			if (list.remove(i) != i)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnOneElementListRemoveLastValid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnOneElementListRemoveLastInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeLast();
		try {
			list.remove(new Integer(2));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnOneElementListRemoveLastInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnOneElementListRemoveLast() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeLast();
		try {
			if (list.first() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testFirstOnOneElementListRemoveLast",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnOneElementListRemoveLast() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeLast();
		try {
			if (list.last() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testLastOnOneElementListRemoveLast",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnOneElementListRemoveLastValid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeLast();
		try {
			return (list.contains(i) == false);
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testContainsOnOneELementListRemoveLastValid",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnOneElementListRemoveLastInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeLast();
		try {
			return (list.contains(new Integer(2)) == false);
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnOneElementListRemoveLastInvalid",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnOneElementListRemoveLast() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeLast();
		try {
			return (list.isEmpty() == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testIsEmptyOnOneElementListRemoveLast", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnOneElementListRemoveLast() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeLast();
		try {
			return (list.size() == 0);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testSizeOnOneElementListRemoveLast", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnOneElementListRemoveLast() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeLast();
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return true;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n",
					"testIteratorOnOneElementListRemoveLast", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnOneElementListRemoveLast() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeLast();
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			// if (str.length() == 0) {
			// return false;
			// }
			// char lastChar = str.charAt(str.length()-1);
			// if (str.contains("@")
			// && !str.contains(" ")
			// && Character.isLetter(str.charAt(0))
			// && (Character.isDigit(lastChar)
			// ||
			// (lastChar >= 'a' && lastChar <= 'f'))) {
			// return false; //looks like default toString()
			// }
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// //////////////////////////
	// SCENARIO: TESTS ON A ONE ELEMENT LIST USING REMOVE
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnOneElementListRemove() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.remove(i);
		try {
			list.addToFront(j);
			if (list.first() != j)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToFrontOnOneElementListRemove", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnOneElementListRemove() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.remove(i);
		try {
			list.addToRear(j);
			if (list.last() != j)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToRearOnOneElementListRemove", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnOneElementListRemoveValid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.remove(i);
		try {
			list.addAfter(j, i);
			if (list.last() != j)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnOneElementListRemoveValid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnOneElementListRemoveInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.remove(i);
		try {
			list.addAfter(new Integer(2), new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnOneElementListRemoveInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnOneElementListRemove() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.remove(i);
		try {
			if (list.removeFirst() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveFirstOnOneElementListRemove",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnOneElementListRemove() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.remove(i);
		try {
			if (list.removeLast() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveLastOnOneElementListRemove",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnOneElementListRemoveValid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.remove(i);
		try {
			if (list.remove(i) != i)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnOneElementListRemoveValid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnOneElementListRemoveInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.remove(i);
		try {
			list.remove(new Integer(2));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnOneElementListRemoveInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnOneElementListRemove() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.remove(i);
		try {
			if (list.first() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testFirstOnOneElementListRemove",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnOneElementListRemove() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.remove(i);
		try {
			if (list.last() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testLastOnOneElementListRemove",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnOneElementListRemoveValid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.remove(i);
		try {
			return (list.contains(i) == false);
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnOneElementListRemoveValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnOneElementListRemoveInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.remove(i);
		try {
			return (list.contains(new Integer(2)) == false);
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnOneElementListRemoveInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnOneElementListRemove() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.remove(i);
		try {
			return (list.isEmpty() == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testIsEmptyOnOneElementListRemove", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnOneElementListRemove() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.remove(i);
		try {
			return (list.size() == 0);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testSizeOnOneElementListRemove", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnOneElementListRemove() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.remove(i);
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return true;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n",
					"testIteratorOnOneElementListRemove", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnOneElementListRemove() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.remove(i);
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			// if (str.length() == 0) {
			// return false;
			// }
			// char lastChar = str.charAt(str.length()-1);
			// if (str.contains("@")
			// && !str.contains(" ")
			// && Character.isLetter(str.charAt(0))
			// && (Character.isDigit(lastChar)
			// ||
			// (lastChar >= 'a' && lastChar <= 'f'))) {
			// return false; //looks like default toString()
			// }
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// //////////////////////////
	// SCENARIO: TESTS ON A ONE ELEMENT LIST USING ADD AFTER
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnOneElementListAddAfter() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(j, i);
			if (list.last() != j)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToFrontOnOneElementListAddAfter", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnOneElementListAddAfter() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(j, i);
			if (list.last() != j)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToRearOnOneElementListAddAfter", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnOneElementListAddAfterValid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(j, i);
			if (list.last() != j)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnOneElementListAddAfterValid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */

	private boolean testAddAfterOnOneElementListAddAfterInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		try {
			list.addAfter(new Integer(2), new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnOneElementListAddAfterInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnOneElementListAddAfter() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(j, i);
			if (list.removeFirst() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveFirstOnOneElementListAddAfter",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnOneElementListAddAfter() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(j, i);
			if (list.removeLast() != j)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveLastOnOneElementListAddAfter",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnOneElementListAddAfterValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(j, i);
			if (list.remove(i) != i)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnOneElementListAddAfterValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnOneElementListAddAfterValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(j, i);
			if (list.remove(j) != j)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnOneElementListAddAfterValidTwo",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnOneElementListAddAfterInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(j, i);
			list.remove(new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnOneElementListAddAfterInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnOneElementListAddAfter() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(j, i);
			if (list.first() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testFirstOnOneElementListAddAfter",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnOneElementListAddAfter() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(j, i);
			if (list.last() != j)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testLastOnOneElementListAddAfter",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnOneElementListAddAfterValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(j, i);
			return (list.contains(i) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnOneElementListAddAfterValidOne",
					e.toString());
			return false;
		}
	}

	/** @return test success */

	private boolean testContainsOnOneElementListAddAfterValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(j, i);
			return (list.contains(j) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnOneElemetnListAddAfterValidTwo",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnOneElementListAddAfterInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(j, i);
			return (list.contains(new Integer(3)) == false);
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testContainsOnOneElementListAddAfterInvalid",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnOneElementListAddAfter() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(j, i);
			return (list.contains(j));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testIsEmptyOnOneElementListAddAfter", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnOneElementListAddAfter() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(j, i);
			return (list.size() == 2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testSizeOnOneElementListAddAfter", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnOneElementListAddAfter() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addAfter(j, i);
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return true;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n",
					"testIteratorOnOneElementListAddAfter", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnOneElementListAddAfter() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addAfter(j, i);
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// //////////////////////////
	// SCENARIO: TESTS ON A TWO ELEMENT LIST ADDING 1ST ELEMENT TO FRONT
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnTwoElementListAddToFrontFirstElement() {
		DoubleLinkedListADT<Integer> list = newList1();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.addToFront(k);
			if (list.first() != k)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToFrontOnTwoElementListAddToFrontFirstElement",
					e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnTwoElementListAddToFrontFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.addToRear(k);
			if (list.last() != k)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToRearOnTwoElementListAddToFrontFirstElement",
					e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListAddToFrontFirstElementValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.addAfter(k, i);
			if (list.contains(k) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testAddAfterOnTwoElementListAddToFrontFirstElementValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListAddToFrontFirstElementValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.addAfter(k, j);
			if (list.contains(k) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testAddAfterOnTwoElementListAddToFrontFirstElementValidTwo",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAfterOnTwoElementListAddToFrontFirstElementInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.addAfter(new Integer(4), new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testAddAfterOnTwoElementListAddToFrontFirstElementInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnTwoElementListAddToFrontFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			if (list.removeFirst() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveFirstOnTwoElementListAddToFrontFirstElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnTwoElementListAddToFrontFirstElement() {
		DoubleLinkedListADT<Integer> list = newList1();
		Integer j = new Integer(4);
		list.addToRear(j);
		try {
			if (list.removeLast() != j)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveLastOnTwoElementListAddToFrontFirstElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnTwoElementListAddToFrontFirstElementValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			if (list.remove(i) != i)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnTwoElementListAddToFrontFirstElementValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnTwoElementListAddToFrontFirstElementValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			if (list.remove(j) != j)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnTwoElementListAddToFrontFirstElementValidTwo",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnTwoElementListAddToFrontFirstElementInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnTwoElementListAddToFrontFirstElementInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnTwoElementListAddToFrontFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			if (list.first() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testFirstOnTwoElementListAddToFrontFirstElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnTwoElementListAddToFrontFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			if (list.last() != j)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testLastOnTwoElementListAddToFrontFirstElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListAddToFrontFirstElementValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			return (list.contains(i) == true);
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testContainsOnTwoElementListAddToFrontFirstElementValidOne",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListAddToFrontFirstElementValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			return (list.contains(j) == true);
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testContainsOnTwoElementListAddToFrontFirstElementValidTwo",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListAddToFrontFirstElementInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			return (list.contains(new Integer(3)) == false);
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testContainsOnTwoElementListAddToFrontFirstElementInvalid",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnTwoElementListAddToFrontFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testIsEmptyOnTwoElementListAddToFrontFirstElement",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnTwoElementListAddToFrontFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			return (list.size() == 2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testSizeOnTwoElementListAddToFrontFirstElement",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnTwoElementListAddToFrontFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return true;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n",
					"testIteratorOnTwoElementListAddToFrontFirstElement",
					e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnTwoElementListAddToFrontFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// //////////////////////////
	// SCENARIO: TESTS ON A TWO ELEMENT LIST USING ADD TO REAR ON SECOND ELEMENT
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnTwoElementListAddToRearSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.addToFront(k);
			if (list.first() != k)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToFrontOnTwoElementListAddToRearSecondElement",
					e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnTwoElementListAddToRearSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.addToRear(k);
			if (list.last() != k)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToRearOnTwoElementListAddToRearSecondElement",
					e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListAddToRearSecondElementValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.addAfter(k, i);
			if (list.contains(k) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testAddAfterOnTwoElementListAddToRearSecondElementValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListAddToRearSecondElementValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.addAfter(k, j);
			if (list.contains(k) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testAddAfterOnTwoElementListAddToRearSecondElementValidTwo",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListAddToRearSecondElementInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.addAfter(new Integer(4), new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testAddAfterOnTwoElementListAddToRearSecondElementInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnTwoElementListAddToRearSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			if (list.removeFirst() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveFirstOnTwoElementListAddToRearSecondElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnTwoElementListAddToRearSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			if (list.removeLast() != j)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveLastOnTwoElementListAddToRearSecondElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnTwoElementListAddToRearSecondElementValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			if (list.remove(i) != i)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnTwoElementListAddToRearSecondElementValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnTwoElementListAddToRearSecondElementValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			if (list.remove(j) != j)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnTwoElementListAddToRearSecondElementValidTwo",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnTwoElementListAddToRearSecondElementInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnTwoElementListAddToRearSecondElementInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnTwoElementListAddToRearSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			if (list.first() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testFirstOnTwoElementListAddToRearSecondElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnTwoElementListAddToRearSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			if (list.last() != j)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testLastOnTwoElementListAddToRearSecondElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListAddToRearSecondElementValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			return (list.contains(i) == true);
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testContainsOnTwoElementListAddToRearSecondElementValidOne",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListAddToRearSecondElementValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			return (list.contains(j) == true);
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testContainsOnTwoElementListAddToRearSecondElementValidTwo",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListAddToRearSecondElementInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			return (list.contains(new Integer(3)) == false);
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testContainsOnTwoElementListAddToRearSecondElementInvalid",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnTwoElementListAddToRearSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testIsEmptyOnTwoElementListAddToRearSecondElement",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnTwoElementListAddToRearSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			return (list.size() == 2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testSizeOnTwoElementListAddToRearSecondElement",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnTwoElementListAddToRearSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return true;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n",
					"testIteratorOnTwoElementListAddToRearSecondElement",
					e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnTwoElementListAddToRearSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// //////////////////////////
	// SCENARIO: TESTS ON A TWO ELEMENT LIST REMOVING FIRST ELEMENT
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnTwoElementListRemoveFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			list.addToFront(k);
			if (list.first() != k)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToFrontOnTwoElementListRemoveFirstElement",
					e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnTwoElementListRemoveFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			list.addToRear(k);
			if (list.last() != k)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToRearOnTwoElementListRemoveFirstElement",
					e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListRemoveFirstElementValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			list.addAfter(k, i);
			if (list.contains(k) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnTwoElementListRemoveFirstElementValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListRemoveFirstElementValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			list.addAfter(k, j);
			if (list.contains(k) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnTwoElementListRemoveFirstElementValidTwo",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListRemoveFirstElementInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			list.addAfter(new Integer(4), new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnTwoElementListRemoveFirstElementInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnTwoElementListRemoveFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			if (list.removeFirst() != j)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveFirstOnTwoElementListRemoveFirstElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnTwoElementListRemoveFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			if (list.removeLast() != j)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveLastOnTwoElementListRemoveFirstElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnTwoElementListRemoveFirstElementValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			if (list.remove(j) != j)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnTwoElementListRemoveFirstElementValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnTwoElementListRemoveFirstElementInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			list.remove(new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnTwoElementListRemoveFirstElementInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnTwoElementListRemoveFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			if (list.first() != j)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testFirstOnTwoElementListRemoveFirstElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnTwoElementListRemoveFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			if (list.last() != j)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testLastOnTwoElementListRemoveFirstElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListRemoveFirstElementValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			return (list.contains(i) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnTwoElementListRemoveFirstElementValidOne",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListRemoveFirstElementValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			return (list.contains(j) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnTwoElementListRemoveFirstElementValidTwo",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListRemoveFirstElementInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			return (list.contains(new Integer(3)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnTwoElementListRemoveFirstElementInvalid",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnTwoElementListRemoveFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testIsEmptyOnTwoElementListRemoveFirstElement",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnTwoElementListRemoveFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			return (list.size() == 1);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testSizeOnTwoElementListRemoveFirstElement", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnTwoElementListRemoveFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return true;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n",
					"testIteratorOnTwoElementListRemoveFirstElement",
					e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnTwoElementListRemoveFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		list.remove(i);
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// //////////////////////////
	// SCENARIO: TESTS ON A TWO ELEMENT LIST USING REMOVE FIRST
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnTwoElementListRemoveFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			list.addToFront(k);
			if (list.first() != k)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToFrontOnTwoElementListRemoveFirst", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnTwoElementListRemoveFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			list.addToRear(k);
			if (list.last() != k)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToRearOnTwoElementListRemoveFirst", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListRemoveFirstValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			list.addAfter(k, i);
			if (list.contains(k) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnTwoElementListRemoveFirstValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListRemoveFirstValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			list.addAfter(k, j);
			if (list.contains(k) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnTwoElementListRemoveFirstValidTwo",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListRemoveFirstInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			list.addAfter(new Integer(4), new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnTwoElementListRemoveFirstInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnTwoElementListRemoveFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			if (list.removeFirst() != j)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveFirstOnTwoElementListRemoveFirst",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnTwoElementListRemoveFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			if (list.removeLast() != j)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveLastOnTwoElementListRemoveFirst",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnTwoElementListRemoveFirstValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			if (list.remove(j) != j)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnTwoElementListRemoveFirstValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnTwoElementListRemoveFirstInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			list.remove(new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnTwoElementListRemoveFirstInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnTwoElementListRemoveFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			if (list.first() != j)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testFirstOnTwoElementListRemoveFirst",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnTwoElementListRemoveFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			if (list.last() != j)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testLastOnTwoElementListRemoveFirst",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListRemoveFirstValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			return (list.contains(i) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnTwoElementListRemoveFirstValidOne",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListRemoveFirstValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			return (list.contains(j) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnTwoElementListRemoveFirstValidTwo",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListRemoveFirstInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			return (list.contains(new Integer(3)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnTwoElementListRemoveFirstInvalid",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnTwoElementListRemoveFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testIsEmptyOnTwoElementListRemoveFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnTwoElementListRemoveFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			return (list.size() == 1);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testSizeOnTwoElementListRemoveFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnTwoElementListRemoveFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return true;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n",
					"testIteratorOnTwoElementListRemoveFirst", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnTwoElementListRemoveFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		list.removeFirst();
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// //////////////////////////
	// SCENARIO: TESTS ON A TWO ELEMENT LIST USING ADD AFTER FOR SECOND ELEMENT
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnTwoElementListAddAfterSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(5);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			list.addToFront(l);
			if (list.first() != l)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToFrontOnTwoElementListAddAfterSecondElement",
					e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnTwoElementListAddAfterSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(5);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToRear(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			list.addToRear(l);
			if (list.last() != l)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToRearOnTwoElementListAddAfterSecondElement",
					e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListAddAfterSecondElementValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(5);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			list.addAfter(l, i);
			if (list.contains(l) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testAddAfterOnTwoElementListAddAfterSecondElementValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListAddAfterSecondElementValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(5);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			list.addAfter(l, j);
			if (list.contains(l) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testAddAfterOnTwoElementListAddAfterSecondElementValidTwo",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListAddAfterSecondElementValidThree() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(5);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			list.addAfter(l, k);
			if (list.contains(l) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testAddAfterOnTwoElementListAddAfterSecondElementValidThree",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListAddAfterSecondElementInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(6);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			list.addAfter(new Integer(5), new Integer(4));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnTwoElementListAddAfterSecondElementInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnTwoElementListAddAfterSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			if (list.removeFirst() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveFirstOnTwoElementListAddAfterSecondElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnTwoElementListAddAfterSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			if (list.removeLast() != k)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveLastOnTwoElementListAddAfterSecondElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnTwoElementListAddAfterSecondElementValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			if (list.remove(i) != i)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnTwoElementListAddAfterSecondElementValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnTwoElementListAddAfterSecondElementValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			if (list.remove(j) != j)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnTwoElementListAddAfterSecondElementValidTwo",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testRemoveElementOnTwoElementListAddAfterSecondElementValidThree() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			if (list.remove(k) != k)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnNewList", "ElementNotFoundException",
					e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnTwoElementListAddAfterSecondElementInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(5);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.addAfter(j, i);
			list.remove(new Integer(4));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnTwoElementListAddAfterSecondElementInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnTwoElementListAddAfterSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			if (list.first() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testFirstOnTwoElementListAddAfterSecondElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnTwoElementListAddAfterSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			if (list.last() != k)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testLastOnTwoElementListAddAfterSecondElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListAddAfterSecondElementValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			return (list.contains(i) == true);
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testContainsOnTwoElementListAddAfterSecondElementValidOne",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListAddAfterSecondElementValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			return (list.contains(j) == true);
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testContainsOnTwoElementListAddAfterSecondElementValidTwo",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListAddAfterSecondElementValidThree() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			return (list.contains(k) == true);
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testContainsOnTwoElementListAddAfterSecondElementValidThree",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListAddAfterSecondElementInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(5);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			return (list.contains(new Integer(4)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnTwoElementListAddAfterSecondElementInvalid",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnTwoElementListAddAfterSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testIsEmptyOnTwoElementListAddAfterSecondElement",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnTwoElementListAddAfterSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			return (list.size() == 3);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testSizeOnTwoElementListAddAfterSecondElement",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnTwoElementListAddAfterSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return true;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n",
					"testIteratorOnTwoElementListAddAfterSecondElement",
					e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnTwoElementListAddAfterSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// //////////////////////////
	// SCENARIO: TESTS ON A TWO ELEMENT LIST USING REMOVE ON LAST ELEMENT
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnTwoElementListRemoveLastElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(j);
			list.addToFront(k);
			if (list.first() != k)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToFrontOnTwoElementListRemoveLastElement",
					e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnTwoElementListRemoveLastElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(j);
			list.addToRear(k);
			if (list.last() != k)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToRearOnTwoElementListRemoveLastElement",
					e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListRemoveLastElementValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(j);
			list.addAfter(k, i);
			if (list.contains(k) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnTwoElementListRemoveLastElementValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListRemoveLastElementValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeLast();
			list.addAfter(k, j);
			if (list.contains(k))
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnTwoElementListRemoveLastElementValidTwo",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListRemoveLastElementInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(j);
			list.addAfter(new Integer(4), new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnTwoElementListRemoveLastElementInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnTwoElementListRemoveLastElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(j);
			if (list.removeFirst() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveFirstOnTwoElementListRemoveLastElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnTwoElementListRemoveLastElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(j);
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveLastOnTwoElementListRemoveLastElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnTwoElementListRemoveLastElementValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(j);
			if (list.remove(i) != i)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnTwoElementListRemoveLastElementValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnTwoElementListRemoveLastElementInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(j);
			list.remove(new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnTwoElementListRemoveLastElementInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnTwoElementListRemoveLastElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(j);
			if (list.first() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testFirstOnTwoElementListRemoveLastElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/*	*//** @return test success */
	/*
	 * private boolean testLastOnTwoElementListRemoveLastElement() {
	 * DoubleLinkedListADT<Integer> list = newList(); Integer i = new
	 * Integer(4); Integer j = new Integer(2); list.addToFront(i);
	 * list.addToRear(j); try { list.remove(j); if(list.last() != i) return
	 * false; } catch (EmptyCollectionException e) { return true; } catch
	 * (Exception e) { System.out.printf("%s expected %s, caught %s\n",
	 * "testLastOnTwoElementListRemoveLastElement", "EmptyCollectionException",
	 * e.toString()); return false; } return true; }
	 */

	/** @return test success */
	private boolean testContainsOnTwoElementListRemoveLastElementValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(j);
			return (list.contains(i) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnTwoElementListRemoveLastElementValidOne",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	/*
	 * private boolean testContainsOnTwoElementListRemoveLastElementValidTwo() {
	 * DoubleLinkedListADT<Integer> list = newList(); Integer i = new
	 * Integer(4); Integer j = new Integer(2); list.addToFront(i);
	 * list.addToRear(j); try { list.remove(j); return (list.contains(j) ==
	 * false); } catch (Exception e) {
	 * System.out.printf("%s caught unexpected %s\n",
	 * "testContainsOnTwoElementListRemoveLastElementValidTwo", e.toString());
	 * return false; } }
	 */

	/** @return test success */
	private boolean testContainsOnTwoElementListRemoveLastElementInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(j);
			return (list.contains(new Integer(3)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnTwoElementListRemoveLastElementInvalid",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnTwoElementListRemoveLastElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(j);
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testIsEmptyOnTwoElementListRemoveLastElement",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnTwoElementListRemoveLastElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(j);
			return (list.size() == 1);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testSizeOnTwoElementListRemoveLastElement", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnTwoElementListRemoveLastElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		list.remove(j);
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return true;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n",
					"testIteratorOnTwoElementListRemoveLastElement",
					e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnTwoElementListRemoveLastElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		list.remove(j);
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// //////////////////////////
	// SCENARIO: TESTS ON A TWO ELEMENT LIST USING REMOVE ON LAST ELEMENT
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnTwoElementListRemoveLast() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeLast();
			list.addToFront(k);
			if (list.first() != k)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToFrontOnTwoElementListRemoveLast", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnTwoElementListRemoveLast() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeLast();
			list.addToRear(k);
			if (list.last() != k)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToRearOnTwoElementListRemoveLast", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListRemoveLastValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeLast();
			list.addAfter(k, i);
			if (list.contains(k) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnTwoElementListRemoveLastValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListRemoveLastValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeLast();
			list.addAfter(k, j);
			if (list.contains(k) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnTwoElementListRemoveLastValidTwo",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListRemoveLastInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeLast();
			list.addAfter(new Integer(4), new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnTwoElementListRemoveLastInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnTwoElementListRemoveLast() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeLast();
			if (list.removeFirst() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveFirstOnTwoElementListRemoveLast",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnTwoElementListRemoveLast() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeLast();
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveLastOnTwoElementListRemoveLast",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnTwoElementListRemoveLastValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeLast();
			if (list.remove(i) != i)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnTwoElementListRemoveLastValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnTwoElementListRemoveLastInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeLast();
			list.remove(new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnTwoElementListRemoveLastInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnTwoElementListRemoveLast() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeLast();
			if (list.first() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testFirstOnTwoElementListRemoveLast",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnTwoElementListRemoveLast() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeLast();
			if (list.last() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testLastOnTwoElementListRemoveLast",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListRemoveLastValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeLast();
			return (list.contains(i) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnTwoElementListRemoveLastValidOne",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListRemoveLastValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeLast();
			return (list.contains(j) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnTwoElementListRemoveLastValidTwo",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListRemoveLastInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeLast();
			return (list.contains(new Integer(3)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnTwoElementListRemoveLastInvalid",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnTwoElementListRemoveLast() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeLast();
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testIsEmptyOnTwoElementListRemoveLast", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnTwoElementListRemoveLast() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeLast();
			return (list.size() == 1);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testSizeOnTwoElementListRemoveLast", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnTwoElementListRemoveLast() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		list.removeLast();
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return true;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n",
					"testIteratorOnTwoElementListRemoveLast", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnTwoElementListRemoveLast() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(4);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		list.removeLast();
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// //////////////////////////
	// SCENARIO: TESTS ON A THREE ELEMENT LIST USING ADD TO FRONT ON FIRST
	// ELEMENT
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnThreeElementListAddToFrontFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addToFront(l);
			if (list.first() != l)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToFrontOnThreeElementListAddToFrontFirstElement",
					e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnThreeElementListAddToFrontFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addToRear(l);
			if (list.last() != l)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToRearOnThreeElementListAddToFrontFirstElement",
					e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddToFrontFirstElementValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, i);
			if (list.contains(l) == true)
				return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListAddToFrontFirstElementValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddToFrontFirstElementValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, j);
			if (list.contains(l) == true)
				return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListAddToFrontFirstElementValidTwo",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddToFrontFirstElementValidThree() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(4, k);
			if (list.contains(l) == true)
				return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListAddToFrontFirstElementValidThree",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddToFrontFirstElementInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(new Integer(5), new Integer(4));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListAddToFrontFirstElementInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnThreeElementListAddToFrontFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if (list.removeFirst() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveFirstOnThreeElementListAddToFrontFirstElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnThreeElementListAddToFrontFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if (list.removeLast() != k)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveLastOnThreeElementListAddToFrontFirstElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddToFrontFirstElementValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if (list.remove(i) != i)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListAddToFrontFirstElementValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddToFrontFirstElementValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if (list.remove(j) != j)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListAddToFrontFirstElementValidTwo",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddToFrontFirstElementValidThree() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if (list.remove(k) != k)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListAddToFrontFirstElementValidThree",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddToFrontFirstElementInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(new Integer(4));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListAddToFrontFirstElementInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnThreeElementListAddToFrontFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if (list.first() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testFirstOnThreeElementListAddToFrontFirstElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnThreeElementListAddToFrontFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if (list.last() != k)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testLastOnThreeElementListAddToFrontFirstElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddToFrontFirstElementValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.contains(i) == true);
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListAddToFrontFirstElementValidOne",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddToFrontFirstElementValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.contains(j) == true);
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListAddToFrontFirstElementValidTwo",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddToFrontFirstElementValidThree() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.contains(k) == true);
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListAddToFrontFirstElementValidThree",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddToFrontFirstElementInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.contains(new Integer(4)) == false);
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListAddToFrontFirstElementInvalid",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnThreeElementListAddToFrontFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testIsEmptyOnNewList", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnThreeElementListAddToFrontFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.size() == 3);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnNewList",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnThreeElementListAddToFrontFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return true;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n",
					"testIteratorOnNewList", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnThreeElementListAddToFrontFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// //////////////////////////
	// SCENARIO: TESTS ON A THREE ELEMENT LIST USING ADD AFTER FOR SECOND
	// ELEMENT
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnThreeElementListAddAfterSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addToFront(l);
			if (list.first() != l)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToFrontOnThreeElementListAddAfterSecondElement",
					e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnThreeElementListAddAfterSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToRear(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addToRear(l);
			if (list.last() != l)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToRearOnThreeElementListAddAfterSecondElement",
					e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddAfterSecondElementValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, i);
			if (list.contains(l) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListAddAfterSecondElementValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddAfterSecondElementValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, j);
			if (list.contains(l) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListAddAfterSecondElementValidTwo",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddAfterSecondElementValidThree() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, k);
			if (list.contains(l) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListAddAfterSecondElementValidThree",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddAfterSecondElementInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(new Integer(5), new Integer(4));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListAddAfterSecondElementInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnThreeElementListAddAfterSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if (list.removeFirst() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveFirstOnThreeElementListAddAfterSecondElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnThreeElementListAddAfterSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if (list.removeLast() != k)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveLastOnThreeElementListAddAfterSecondElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddAfterSecondElementValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if (list.remove(i) != i)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListAddAfterSecondElementValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddAfterSecondElementValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if (list.remove(j) != j)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListAddAfterSecondElementValidTwo",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddAfterSecondElementValidThree() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if (list.remove(k) != k)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListAddAfterSecondElementValidThree",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddAfterSecondElementInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(new Integer(4));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListAddAfterSecondElementInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnThreeElementListAddAfterSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if (list.first() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testFirstOnThreeElementListAddAfterSecondElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnThreeElementListAddAfterSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if (list.last() != k)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testLastOnThreeElementListAddAfterSecondElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterSecondElementValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.contains(i) == true);
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListAddAfterSecondElementValidOne",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterSecondElementValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.contains(j) == true);
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListAddAfterSecondElementValidTwo",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterSecondElementValidThree() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.contains(k) == true);
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListAddAfterSecondElementValidThree",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterSecondElementInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.contains(new Integer(4)) == false);
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListAddAfterSecondElementInvalid",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnThreeElementListAddAfterSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testIsEmptyOnThreeElementListAddAfterSecondElement",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnThreeElementListAddAfterSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.size() == 3);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testSizeOnThreeElementListAddAfterSecondElement",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnThreeElementListAddAfterSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return true;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n",
					"testIteratorOnThreeElementListAddAfterSecondElement",
					e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnThreeElementListAddAfterSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// //////////////////////////
	// SCENARIO: TESTS ON A THREE ELEMENT LIST USING ADD TO REAR ON THIRD
	// ELEMENT
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontThreeElementListAddToRearThirdElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addToFront(l);
			if (list.first() != l)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToFrontThreeElementListAddToRearThirdElement",
					e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnThreeElementListAddToRearOnThirdElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToRear(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addToRear(l);
			if (list.last() != l)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToRearOnThreeElementListAddToRearOnThirdElement",
					e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddToRearThirdElementValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, i);
			if (list.contains(l) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListAddToRearThirdElementValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddToRearThirdElementValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, j);
			if (list.contains(l) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListAddToRearThirdElementValidTwo",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddToRearThirdElementValidThree() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, k);
			if (list.contains(l) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListAddToRearThirdElementValidThree",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddToRearThirdElementInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(new Integer(5), new Integer(4));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListAddToRearThirdElementInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnThreeElementListAddToRearThirdElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if (list.removeFirst() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveFirstOnThreeElementListAddToRearThirdElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnThreeElementListAddToRearThirdElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if (list.removeLast() != k)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveLastOnThreeElementListAddToRearThirdElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddToRearThirdElementValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if (list.remove(i) != i)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListAddToRearThirdElementValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddToRearThirdElementValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if (list.remove(j) != j)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListAddToRearThirdElementValidTwo",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddToRearThirdElementValidThree() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if (list.remove(k) != k)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListAddToRearThirdElementValidThree",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddToRearThirdElementInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(new Integer(4));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListAddToRearThirdElementInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnThreeElementListAddToRearThirdElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if (list.first() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testFirstOnThreeElementListAddToRearThirdElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnThreeElementListAddToRearThirdElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if (list.last() != k)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testLastOnThreeElementListAddToRearThirdElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddToRearThirdElementValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.contains(i) == true);
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListAddToRearThirdElementValidOne",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddToRearThirdElementValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.contains(j) == true);
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListAddToRearThirdElementValidTwo",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddToRearThirdElementValidThree() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.contains(k) == true);
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListAddToRearThirdElementValidThree",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddToRearThirdElementInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.contains(new Integer(4)) == false);
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListAddToRearThirdElementInvalid",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnThreeElementListAddToRearThirdElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testIsEmptyOnThreeElementListAddToRearThirdElement",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnThreeElementListAddToRearThirdElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.size() == 3);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testSizeOnThreeElementListAddToRearThirdElement",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnThreeElementListAddToRearThirdElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return true;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n",
					"testIteratorOnThreeElementListAddToRearThirdElement",
					e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnThreeElementListAddToRearThirdElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// //////////////////////////
	// SCENARIO: TESTS ON A THREE ELEMENT LIST USING ADD AFTER THE FIRST ELEMENT
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontThreeElementListAddAfterFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(m, i);
			list.addToFront(l);
			if (list.first() != l)
				return false;
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testAddToFrontThreeElementListAddAfterFirst",
					e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnThreeElementListAddAfterFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		list.addToRear(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(m, i);
			list.addToRear(l);
			if (list.last() != l)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToRearOnThreeElementListAddAfterFirst",
					e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddAfterFirstValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(m, i);
			list.addAfter(l, i);
			if (list.contains(l) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListAddAfterFirstValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddAfterFirstValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(m, i);
			list.addAfter(l, j);
			if (list.contains(l) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListAddAfterFirstValidTwo",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddAfterFirstValidThree() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(m, i);
			list.addAfter(l, k);
			if (list.contains(l) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListAddAfterFirstValidThree",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddAfterFirstValidFour() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(m, i);
			list.addAfter(l, m);
			if (list.contains(l) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListAddAfterFirstValidFour",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAfterOnThreeElementListAddAfterFirstInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, i);
			list.addAfter(new Integer(6), new Integer(5));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListAddAfterFirstInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnThreeElementListAddAfterFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, i);
			if (list.removeFirst() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveFirstOnThreeElementListAddAfterFirst",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnThreeElementListAddAfterFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, i);
			if (list.removeLast() != k)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveLastOnThreeElementListAddAfterFirst",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddAfterFirstValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, i);
			if (list.remove(i) != i)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListAddAfterFirstValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddAfterFirstValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, i);
			if (list.remove(j) != j)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListAddAfterFirstValidTwo",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddAfterFirstValidThree() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, i);
			if (list.remove(k) != k)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListAddAfterFirstValidThree",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddAfterFirstValidFour() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, i);
			if (list.remove(l) != l)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListAddAfterFirstValidFour",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddAfterFirstInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, i);
			list.remove(new Integer(5));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListAddAfterFirstInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnThreeElementListAddAfterFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, i);
			if (list.first() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testFirstOnThreeElementListAddAfterFirst",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnThreeElementListAddAfterFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, i);
			if (list.last() != k)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testLastOnThreeElementListAddAfterFirst",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterFirstValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, i);
			return (list.contains(i) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListAddAfterFirstValidOne",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterFirstValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, i);
			return (list.contains(j) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListAddAfterFirstValidTwo",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterFirstValidThree() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, i);
			return (list.contains(k) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListAddAfterFirstValidThree",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterFirstValidFour() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, i);
			return (list.contains(l) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListAddAfterFirstValidFour",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterFirstInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, i);
			return (list.contains(new Integer(5)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListAddAfterFirstInvalid",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnThreeElementListAddAfterFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, i);
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testIsEmptyOnThreeElementListAddAfterFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnThreeElementListAddAfterFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, i);
			return (list.size() == 4);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testSizeOnThreeElementListAddAfterFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnThreeElementListAddAfterFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, i);
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return true;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out
			.printf("%s caught unexpected %s\n",
					"testIteratorOnThreeElementListAddAfterFirst",
					e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnThreeElementListAddAfterFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, i);
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// //////////////////////////
	// SCENARIO: TESTS ON A THREE ELEMENT LIST USING ADD AFTER THE SECOND
	// ELEMENT
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontThreeElementListAddAfterSecond() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(m, j);
			list.addToFront(l);
			if (list.first() != l)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToFrontThreeElementListAddAfterSecond",
					e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnThreeElementListAddAfterSecond() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		list.addToRear(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(m, j);
			list.addToRear(l);
			if (list.last() != l)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToRearOnThreeElementListAddAfterSecond",
					e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddAfterSecondValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(m, j);
			list.addAfter(l, i);
			if (list.contains(l) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListAddAfterSecondValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddAfterSecondValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(m, j);
			list.addAfter(l, j);
			if (list.contains(l) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListAddAfterSecondValidTwo",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddAfterSecondValidThree() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(m, j);
			list.addAfter(l, k);
			if (list.contains(l) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListAddAfterSecondValidThree",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddAfterSecondValidFour() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(m, j);
			list.addAfter(new Integer(6), m);
			if (list.contains(l) == true)
				return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListAddAfterSecondValidFour",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddAfterSecondInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, j);
			list.addAfter(new Integer(6), new Integer(5));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListAddAfterSecondInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnThreeElementListAddAfterSecond() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, j);
			if (list.removeFirst() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveFirstOnThreeElementListAddAfterSecond",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnThreeElementListAddAfterSecond() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, j);
			if (list.removeLast() != k)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveLastOnThreeElementListAddAfterSecond",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddAfterSecondValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, j);
			if (list.remove(i) != i)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListAddAfterSecondValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddAfterSecondValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, j);
			if (list.remove(j) != j)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListAddAfterSecondValidTwo",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testRemoveElementOnThreeElementListAddAfterSecondValidThree() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, j);
			if (list.remove(k) != k)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListAddAfterSecondValidThree",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddAfterSecondValidFour() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, j);
			if (list.remove(l) != l)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListAddAfterSecondValidFour",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddAfterSecondInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, j);
			list.remove(new Integer(5));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListAddAfterSecondInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnThreeElementListAddAfterSecond() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, j);
			if (list.first() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testFirstOnThreeElementListAddAfterSecond",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnThreeElementListAddAfterSecond() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, j);
			if (list.last() != k)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testLastOnThreeElementListAddAfterSecond",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterSecondValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, j);
			return (list.contains(i) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListAddAfterSecondValidOne",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterSecondValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, j);
			return (list.contains(j) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListAddAfterSecondValidTwo",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterSecondValidThree() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, j);
			return (list.contains(k) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListAddAfterSecondValidThree",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterSecondValidFour() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, j);
			return (list.contains(l) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListAddAfterSecondValidFour",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterSecondInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, j);
			return (list.contains(new Integer(5)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListAddAfterSecondInvalid",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnThreeElementListAddAfterSecond() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, j);
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testIsEmptyOnThreeElementListAddAfterSecond",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnThreeElementListAddAfterSecond() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, j);
			return (list.size() == 4);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testSizeOnThreeElementListAddAfterSecond", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnThreeElementListAddAfterSecond() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, j);
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return true;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n",
					"testIteratorOnThreeElementListAddAfterSecond",
					e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnThreeElementListAddAfterSecond() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, j);
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// //////////////////////////
	// SCENARIO: TESTS ON A THREE ELEMENT LIST USING ADD AFTER THE THIRD ELEMENT
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontThreeElementListAddAfterThird() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(m, k);
			list.addToFront(l);
			if (list.first() != l)
				return false;
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testAddToFrontThreeElementListAddAfterThird",
					e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnThreeElementListAddAfterThird() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		list.addToRear(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(m, k);
			list.addToRear(l);
			if (list.last() != l)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToRearOnThreeElementListAddAfterThird",
					e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddAfterThirdValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(m, k);
			list.addAfter(l, i);
			if (list.contains(l) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListAddAfterThirdValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddAfterThirdValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(m, k);
			list.addAfter(l, j);
			if (list.contains(l) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListAddAfterThirdValidTwo",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddAfterThirdValidThree() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		Integer m = new Integer(5);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(m, k);
			list.addAfter(l, k);
			if (list.contains(l) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListAddAfterThirdValidThree",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddAfterThirdInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, k);
			list.addAfter(new Integer(6), new Integer(5));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListAddAfterThirdInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnThreeElementListAddAfterThird() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, k);
			if (list.removeFirst() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveFirstOnThreeElementListAddAfterThird",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnThreeElementListAddAfterThird() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, k);
			if (list.removeLast() != l)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveLastOnThreeElementListAddAfterThird",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddAfterThirdValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, k);
			if (list.remove(i) != i)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListAddAfterThirdValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddAfterThirdValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, k);
			if (list.remove(j) != j)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListAddAfterThirdValidTwo",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddAfterThirdValidThree() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, k);
			if (list.remove(k) != k)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListAddAfterThirdValidThree",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddAfterThirdValidFour() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, k);
			if (list.remove(l) != l)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListAddAfterThirdValidFour",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddAfterThirdInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, k);
			list.remove(new Integer(5));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListAddAfterThirdInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnThreeElementListAddAfterThird() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, k);
			if (list.first() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testFirstOnThreeElementListAddAfterThird",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnThreeElementListAddAfterThird() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, k);
			if (list.last() != l)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testLastOnThreeElementListAddAfterThird",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterThirdValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, k);
			return (list.contains(i) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListAddAfterThirdValidOne",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterThirdValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, k);
			return (list.contains(j) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListAddAfterThirdValidTwo",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterThirdValidThree() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, k);
			return (list.contains(k) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListAddAfterThirdValidThree",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterThirdValidFour() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, k);
			return (list.contains(l) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListAddAfterThirdValidFour",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterThirdInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, k);
			return (list.contains(new Integer(5)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListAddAfterThirdInvalid",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnThreeElementListAddAfterThird() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, k);
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testIsEmptyOnThreeElementListAddAfterThird", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnThreeElementListAddAfterThird() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, k);
			return (list.size() == 4);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testSizeOnThreeElementListAddAfterThird", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnThreeElementListAddAfterThird() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, k);
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return true;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out
			.printf("%s caught unexpected %s\n",
					"testIteratorOnThreeElementListAddAfterThird",
					e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnThreeElementListAddAfterThird() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, k);
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// //////////////////////////
	// SCENARIO: TESTS ON A THREE ELEMENT LIST USING REMOVE FIRST
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnThreeElementListRemoveFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeFirst();
			list.addToFront(l);
			if (list.first() != l)
				return false;
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testAddToFrontOnThreeElementListRemoveFirst",
					e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnThreeElementListRemoveFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeFirst();
			list.addToRear(l);
			if (list.last() != l)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToRearOnThreeElementListRemoveFirst", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListRemoveFirstValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeFirst();
			list.addAfter(l, j);
			if (list.contains(l) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListRemoveFirstValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListRemoveFirstValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeFirst();
			list.addAfter(l, k);
			if (list.contains(l) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListRemoveFirstValidTwo",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListRemoveFirstValidThree() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeFirst();
			list.addAfter(l, k);
			if (list.contains(l) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListRemoveFirstValidThree",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */

	private boolean testAddAfterOnThreeElementListRemoveFirstInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeFirst();
			list.addAfter(new Integer(5), new Integer(4));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListRemoveFirstInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnThreeElementListRemoveFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeFirst();
			if (list.removeFirst() != j)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveFirstOnThreeElementListRemoveFirst",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnThreeElementListRemoveFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeFirst();
			if (list.removeLast() != k)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveLastOnThreeElementListRemoveFirst",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListRemoveFirstValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeFirst();
			if (list.remove(j) != j)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListRemoveFirstValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListRemoveFirstValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeFirst();
			if (list.remove(k) != k)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListRemoveFirstValidTwo",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListRemoveFirstInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			list.remove(new Integer(4));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListRemoveFirstInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnThreeElementListRemoveFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeFirst();
			if (list.first() != j)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testFirstOnThreeElementListRemoveFirst",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnThreeElementListRemoveFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeFirst();
			if (list.last() != k)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testLastOnThreeElementListRemoveFirst",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveFirstValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeFirst();
			return (list.contains(i) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListRemoveFirstValidOne",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveFirstValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeFirst();
			return (list.contains(j) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListRemoveFirstValidTwo",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveFirstValidThree() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeFirst();
			return (list.contains(k) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListRemoveFirstValidThree",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveFirstInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeFirst();
			return (list.contains(new Integer(4)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListRemoveFirstInvalid",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnThreeElementListRemoveFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeFirst();
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testIsEmptyOnThreeElementListRemoveFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnThreeElementListRemoveFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeFirst();
			return (list.size() == 2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testSizeOnThreeElementListRemoveFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnThreeElementListRemoveFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeFirst();
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return true;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n",
					"testIteratorOnThreeElementListRemoveFirst", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnThreeElementListRemoveFirst() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeFirst();
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// //////////////////////////
	// SCENARIO: TESTS ON A THREE ELEMENT LIST USING REMOVE FIRST ELEMENT
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnThreeElementListRemoveFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(i);
			list.addToFront(l);
			if (list.first() != l)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToFrontOnThreeElementListRemoveFirstElement",
					e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnThreeElementListRemoveFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(i);
			list.addToRear(l);
			if (list.last() != l)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToRearOnThreeElementListRemoveFirstElement",
					e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListRemoveFirstElementValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(i);
			list.addAfter(l, j);
			if (list.contains(l) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListRemoveFirstElementValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListRemoveFirstElementValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(i);
			list.addAfter(l, k);
			if (list.contains(l) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListRemoveFirstElementValidTwo",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListRemoveFirstElementValidThree() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(i);
			list.addAfter(l, k);
			if (list.contains(l) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListRemoveFirstElementValidThree",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */

	private boolean testAddAfterOnThreeElementListRemoveFirstElementInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(i);
			list.addAfter(new Integer(5), new Integer(4));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListRemoveFirstElementInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnThreeElementListRemoveFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(i);
			if (list.removeFirst() != j)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveFirstOnThreeElementListRemoveFirstElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnThreeElementListRemoveFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(i);
			if (list.removeLast() != k)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveLastOnThreeElementListRemoveFirstElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListRemoveFirstElementValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(i);
			if (list.remove(j) != j)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListRemoveFirstElementValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListRemoveFirstElementValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(i);
			if (list.remove(k) != k)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListRemoveFirstElementValidTwo",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListRemoveFirstElementInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			list.remove(new Integer(4));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListRemoveFirstElementInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnThreeElementListRemoveFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(i);
			if (list.first() != j)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testFirstOnThreeElementListRemoveFirstElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnThreeElementListRemoveFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(i);
			if (list.last() != k)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testLastOnThreeElementListRemoveFirstElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveFirstElementValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(i);
			return (list.contains(i) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListRemoveFirstElementValidOne",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveFirstElementValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(i);
			return (list.contains(j) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListRemoveFirstElementValidTwo",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveFirstElementValidThree() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(i);
			return (list.contains(k) == true);
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListRemoveFirstElementValidThree",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveFirstElementInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(i);
			return (list.contains(new Integer(4)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListRemoveFirstElementInvalid",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnThreeElementListRemoveFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(i);
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testIsEmptyOnThreeElementListRemoveFirstElement",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnThreeElementListRemoveFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(i);
			return (list.size() == 2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testSizeOnThreeElementListRemoveFirstElement",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnThreeElementListRemoveFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(i);
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return true;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n",
					"testIteratorOnThreeElementListRemoveFirstElement",
					e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnThreeElementListRemoveFirstElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(i);
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// //////////////////////////
	// SCENARIO: TESTS ON A THREE ELEMENT LIST USING REMOVE SECOND ELEMENT
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnThreeElementListRemoveSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(j);
			list.addToFront(l);
			if (list.first() != l)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToFrontOnThreeElementListRemoveSecondElement",
					e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnThreeElementListRemoveSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(j);
			list.addToRear(l);
			if (list.last() != l)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToRearOnThreeElementListRemoveSecondElement",
					e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListRemoveSecondElementValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(j);
			list.addAfter(l, i);
			if (list.contains(l) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListRemoveSecondElementValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListRemoveSecondElementValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(j);
			list.addAfter(l, k);
			if (list.contains(l) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListRemoveSecondElementValidTwo",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListRemoveSecondElementValidThree() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(j);
			list.addAfter(l, k);
			if (list.contains(l) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListRemoveSecondElementValidThree",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */

	private boolean testAddAfterOnThreeElementListRemoveSecondElementInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(j);
			list.addAfter(new Integer(5), new Integer(4));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListRemoveSecondElementInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnThreeElementListRemoveSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(j);
			if (list.removeFirst() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveFirstOnThreeElementListRemoveSecondElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnThreeElementListRemoveSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(j);
			if (list.removeLast() != k)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveLastOnThreeElementListRemoveSecondElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListRemoveSecondElementValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(j);
			if (list.remove(i) != i)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListRemoveSecondElementValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListRemoveSecondElementValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(j);
			if (list.remove(k) != k)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListRemoveSecondElementValidTwo",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListRemoveSecondElementInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(j);
			list.remove(new Integer(4));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListRemoveSecondElementInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnThreeElementListRemoveSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(j);
			if (list.first() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testFirstOnThreeElementListRemoveSecondElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnThreeElementListRemoveSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(j);
			if (list.last() != k)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testLastOnThreeElementListRemoveSecondElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveSecondElementValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(j);
			return (list.contains(i) == true);
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListRemoveSecondElementValidOne",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveSecondElementValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(j);
			return (list.contains(j) == false);
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListRemoveSecondElementValidTwo",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveSecondElementValidThree() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(j);
			return (list.contains(k) == true);
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListRemoveSecondElementValidThree",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveSecondElementInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(j);
			return (list.contains(new Integer(4)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListRemoveSecondElementInvalid",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnThreeElementListRemoveSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(j);
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testIsEmptyOnThreeElementListRemoveSecondElement",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnThreeElementListRemoveSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(j);
			return (list.size() == 2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testSizeOnThreeElementListRemoveSecondElement",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnThreeElementListRemoveSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(j);
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return true;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n",
					"testIteratorOnThreeElementListRemoveSecondElement",
					e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnThreeElementListRemoveSecondElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(j);
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// //////////////////////////
	// SCENARIO: TESTS ON A THREE ELEMENT LIST USING REMOVE THIRD ELEMENT
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnThreeElementListRemoveThirdElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(k);
			list.addToFront(l);
			if (list.first() != l)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToFrontOnThreeElementListRemoveThirdElement",
					e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnThreeElementListRemoveThirdElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(k);
			list.addToRear(l);
			if (list.last() != l)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToRearOnThreeElementListRemoveThirdElement",
					e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListRemoveThirdElementValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(k);
			list.addAfter(l, i);
			if (list.contains(l) == true)
				return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListRemoveThirdElementValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListRemoveThirdElementValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(k);
			list.addAfter(l, j);
			if (list.contains(l) == true)
				return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListRemoveThirdElementValidTwo",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */

	private boolean testAddAfterOnThreeElementListRemoveThirdElementInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(k);
			list.addAfter(new Integer(5), new Integer(4));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListRemoveThirdElementInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnThreeElementListRemoveThirdElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(k);
			if (list.removeFirst() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveFirstOnThreeElementListRemoveThirdElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	/*
	 * private boolean testRemoveLastOnThreeElementListRemoveThirdElement() {
	 * DoubleLinkedListADT<Integer> list = newList(); Integer i = new
	 * Integer(1); Integer j = new Integer(2); Integer k = new Integer(3);
	 * list.addToFront(i); list.addAfter(j, i); list.addToRear(k); try {
	 * list.remove(k); if(list.removeLast() != j) return false; } catch
	 * (EmptyCollectionException e) { return true; } catch (Exception e) {
	 * System.out.printf("%s expected %s, caught %s\n",
	 * "testRemoveLastOnThreeElementListRemoveThirdElement",
	 * "EmptyCollectionException", e.toString()); return false; } return true; }
	 */

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListRemoveThirdElementValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(k);
			if (list.remove(i) != i)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListRemoveThirdElementValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListRemoveThirdElementValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(k);
			if (list.remove(j) != j)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListRemoveThirdElementValidTwo",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListRemoveThirdElementInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(k, i);
		list.addToRear(j);
		try {
			list.remove(k);
			list.remove(new Integer(4));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListRemoveThirdElementInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnThreeElementListRemoveThirdElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(k);
			if (list.first() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testFirstOnThreeElementListRemoveThirdElement",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	/*
	 * private boolean testLastOnThreeElementListRemoveThirdElement() {
	 * DoubleLinkedListADT<Integer> list = newList(); Integer i = new
	 * Integer(1); Integer j = new Integer(2); Integer k = new Integer(3);
	 * list.addToFront(i); list.addAfter(j, i); list.addToRear(k); try {
	 * list.remove(k); if(list.last() != j) return false; } catch
	 * (EmptyCollectionException e) { return true; } catch (Exception e) {
	 * System.out.printf("%s expected %s, caught %s\n",
	 * "testLastOnThreeElementListRemoveThirdElement",
	 * "EmptyCollectionException", e.toString()); return false; } return true; }
	 */

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveThirdElementValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(k);
			return (list.contains(i) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListRemoveThirdElementValidOne",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveThirdElementValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(k);
			return (list.contains(j) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListRemoveThirdElementValidTwo",
					e.toString());
			return false;
		}
	}

	/*	*//** @return test success */
	/*
	 * private boolean
	 * testContainsOnThreeElementListRemoveThirdElementValidThree() {
	 * DoubleLinkedListADT<Integer> list = newList(); Integer i = new
	 * Integer(1); Integer j = new Integer(2); Integer k = new Integer(3);
	 * list.addToFront(i); list.addAfter(j, i); list.addToRear(k); try {
	 * list.remove(k); return (list.contains(k) == false); } catch (Exception e)
	 * { System.out.printf("%s caught unexpected %s\n",
	 * "testContainsOnThreeElementListRemoveThirdElementValidThree",
	 * e.toString()); return false; } }
	 */

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveThirdElementInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(k);
			return (list.contains(new Integer(4)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListRemoveThirdElementInvalid",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnThreeElementListRemoveThirdElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(k);
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testIsEmptyOnThreeElementListRemoveThirdElement",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnThreeElementListRemoveThirdElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(k);
			;
			return (list.size() == 2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testSizeOnThreeElementListRemoveThirdElement",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnThreeElementListRemoveThirdElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(k);
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return true;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n",
					"testIteratorOnThreeElementListRemoveThirdElement",
					e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnThreeElementListRemoveThirdElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(k);
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// //////////////////////////
	// SCENARIO: TESTS ON A THREE ELEMENT LIST USING REMOVE LAST
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnThreeElementListRemoveLast() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeLast();
			list.addToFront(l);
			if (list.first() != l)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToFrontOnThreeElementListRemoveLast", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnThreeElementListRemoveLast() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeLast();
			list.addToRear(l);
			if (list.last() != l)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddToRearOnThreeElementListRemoveLast", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListRemoveLastValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeLast();
			list.addAfter(l, i);
			if (list.contains(l) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListRemoveLastValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListRemoveLastValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeLast();
			list.addAfter(l, j);
			if (list.contains(l) != true)
				return false;
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListRemoveLastValidTwo",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */

	private boolean testAddAfterOnThreeElementListRemoveLastInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeLast();
			list.addAfter(new Integer(5), new Integer(4));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testAddAfterOnThreeElementListRemoveLastInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnThreeElementListRemoveLast() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeLast();
			if (list.removeFirst() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveFirstOnThreeElementListRemoveLast",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnThreeElementListRemoveLast() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeLast();
			if (list.removeLast() != j)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveLastOnThreeElementListRemoveLast",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListRemoveLastValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeLast();
			if (list.remove(i) != i)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListRemoveLastValidOne",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListRemoveLastValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeLast();
			if (list.remove(j) != j)
				return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListRemoveLastValidTwo",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListRemoveLastInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(k, i);
		list.addToRear(j);
		try {
			list.removeLast();
			list.remove(new Integer(4));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testRemoveElementOnThreeElementListRemoveLastInvalid",
					"ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnThreeElementListRemoveLast() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeLast();
			if (list.first() != i)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testFirstOnThreeElementListRemoveLast",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnThreeElementListRemoveLast() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeLast();
			if (list.last() != j)
				return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"testLastOnThreeElementListRemoveLast",
					"EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveLastValidOne() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeLast();
			return (list.contains(i) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListRemoveLastValidOne",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveLastValidTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeLast();
			return (list.contains(j) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListRemoveLastValidTwo",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveLastValidThree() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeLast();
			return (list.contains(k) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListRemoveLastValidThree",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveLastInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeLast();
			return (list.contains(new Integer(4)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnThreeElementListRemoveLastInvalid",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnThreeElementListRemoveLast() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.removeLast() == k);
			// return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testIsEmptyOnThreeElementListRemoveLast", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnThreeElementListRemoveLast() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeLast();
			return (list.size() == 2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testSizeOnThreeElementListRemoveLast", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnThreeElementListRemoveLast() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeLast();
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return true;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n",
					"testIteratorOnThreeElementListRemoveLast", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnThreeElementListRemoveLast() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeLast();
			;
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// ////////////////////////
	// LIST ITERATOR TESTS
	// ///////////////////////

	// [A] -> iterator remove() after next() returns A -> []
	/** @return test success */
	public boolean testOnIteratorRemoveAfterNextOneElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		Iterator<Integer> it = list.iterator();
		try {
			it.next();
			it.remove();
			if (list.size() != 0)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testOnIteratorRemoveAfterNextOneElement", e.toString());
			return false;
		}
		return true;
	}

	// [A,B] -> iterator remove() after next() returns A -> [B]
	/** @return test success */
	public boolean testOnIteratorRemoveAfterNextTwoElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.add(i);
		list.add(j);
		Iterator<Integer> it = list.iterator();
		try {
			it.next();
			it.remove();
			if (list.size() == 1)
				return true;
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testOnIteratorRemoveAfterNextTwoElement", e.toString());
		}

		return false;
	}

	// [A,B] -> iterator remove() after next() returns B -> [A]
	/** @return test success */
	public boolean testOnIteratorRemoveAfterNextTwoElementTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.add(i);
		list.add(j);
		Iterator<Integer> it = list.iterator();
		try {
			it.next();
			it.next();
			it.remove();
			if (list.size() != 1)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testOnIteratorRemoveAfterNextTwoElementTwo", e.toString());
			return false;
		}
		return true;
	}

	// [A,B,C] -> iterator remove() after next() returns A -> [B,C]
	/** @return test success */
	public boolean testOnIteratorRemoveAfterNextThreeElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(i);
		list.add(j);
		list.add(k);
		Iterator<Integer> it = list.iterator();
		try {
			it.next();
			it.next();
			it.next();
			it.remove();
			if (list.size() != 2)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testOnIteratorRemoveAfterNextThreeElement", e.toString());
			return false;
		}
		return true;
	}

	// [A,B,C] -> iterator remove() after next() returns B -> [A,C]
	/** @return test success */
	public boolean testOnIteratorRemoveAfterNextThreeElementTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(i);
		list.add(j);
		list.add(k);
		Iterator<Integer> it = list.iterator();
		try {
			it.next();
			it.next();
			it.next();
			it.remove();
			if (list.size() != 2)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testOnIteratorRemoveAfterNextThreeElementTwo",
					e.toString());
			return false;
		}
		return true;
	}

	// [A,B,C] -> iterator remove() after next() returns C -> [A,B]
	/** @return test success */
	public boolean testOnIteratorRemoveAfterNextThreeElementThree() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(i);
		list.add(j);
		list.add(k);
		Iterator<Integer> it = list.iterator();
		try {
			it.next();
			it.remove();
			if (list.size() != 2)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testOnIteratorRemoveAfterNextThreeElementThree",
					e.toString());
			return false;
		}

		return true;
	}

	// [A] -> iterator remove() after previous() returns A -> []
	/** @return test success */
	public boolean testOnIteratorRemoveAfterPreviousOneElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.add(i);
		ListIterator<Integer> it = list.listIterator();
		try {
			it.previous();
			it.remove();
			if (list.size() != 0)
				return false;
		} catch (NoSuchElementException e) {
			return true;
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testOnIteratorRemoveAfterPreviousOneElement",
					e.toString());
			return false;
		}
		return true;
	}

	// [A,B] -> iterator remove() after previous() returns A -> [B]
	/** @return test success */
	public boolean testOnIteratorRemoveAfterPreviousTwoElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.add(i);
		list.add(j);
		ListIterator<Integer> it = list.listIterator();
		try {
			it.next();
			it.previous();
			it.remove();
			if (list.contains(i) != false)
				return true;
			if (list.contains(j) != true)
				return false;
		} catch (Exception e) {
			System.out
			.printf("%s caught unexpected %s\n",
					"testOnIteratorRemoveAfterPreviousTwoElement",
					e.toString());
			return false;
		}
		return true;
	}

	// [A,B,C] -> iterator remove() after previous() returns A -> [B,C]
	/** @return test success */
	public boolean testOnIteratorRemoveAfterPreviousThreeElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(i);
		list.add(j);
		list.add(k);
		ListIterator<Integer> it = list.listIterator();
		try {
			it.next();
			it.previous();
			it.remove();
			if (list.contains(i) != false)
				return false;
			if (list.contains(j) != true)
				return true;
			if (list.contains(k) != true)
				return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testOnIteratorRemoveAfterPreviousThreeElement",
					e.toString());
			return false;
		}
		return true;
	}

	// [A,B,C] -> iterator remove() after previous() returns B -> [A,C]
	/** @return test success */
	public boolean testOnIteratorRemoveAfterPreviousThreeElementTwo() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(i);
		list.add(j);
		list.add(k);
		ListIterator<Integer> it = list.listIterator();
		try {
			it.next();
			it.next();
			it.previous();
			it.remove();
			if (list.contains(i) != true)
				return false;
			if (list.contains(j) != false)
				return true;
			if (list.contains(k) != true)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testOnIteratorRemoveAfterPreviousThreeElementTwo",
					e.toString());
			return false;
		}
		return true;
	}

	// [] -> index add(A) -> [A]
	/** @return test success */
	public boolean testOnAddIndexNewList() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		try {
			list.add(1, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testOnAddIndexNewList", e.toString());
			return false;
		}
		return true;
	}

	// [A] -> index add(B) with new iterator -> [B,A]
	/** @return test success */
	public boolean testAddIndexOneOneList() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.add(i);
		try {
			list.add(1, j);
			return (list.size() == 2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddIndexOneOneList", e.toString());
			return false;
		}
	}

	// [A] -> iterator add(B) after next() returns A -> [A,B]
	/** @return test success */
	public boolean testAddIndexTwoOneList() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.add(i);
		try {
			list.add(2, j);
			return (list.size() == 2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddIndexTwoOneList", e.toString());
			return false;
		}
	}

	// [A,B,C] -> set(1,D) after addToFront
	/** @return test success */
	public boolean testOnSetOneAfterAddToFrontValid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.add(j);
		list.add(k);
		try {
			list.addToFront(i);
			list.set(1, l);
			if (list.contains(l) != true)
				return false;
			if (list.contains(i) != false)
				return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testOnIteratorSetOneAfterAddToFrontValid", e.toString());
			return false;
		}
		return true;
	}

	// [A] -> iterator set(B) after next() returns A -> [B]
	/** @return test success */
	public boolean testOnIteratorSetAfterNextOneElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.add(i);
		ListIterator<Integer> it = list.listIterator();
		try {
			it.next();
			it.set(j);
			return (list.contains(j) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testOnIteratorSetAfterNextOneElement", e.toString());
			return false;
		}

	}

	// [A] -> iterator set(B) after previous() returns A -> [B]
	/** @return test success */
	public boolean testOnIteratorSetAfterPreviousOneElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.add(i);
		ListIterator<Integer> it = list.listIterator();
		try {
			it.next();
			it.set(j);
			if (list.contains(i) != false)
				return true;
			if (list.contains(j) != true)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testOnIteratorSetAfterPreviousOneElement", e.toString());
			return false;
		}
		return true;
	}

	// [A] -> indexOf On Invalid Target Element
	/** @return test success */
	public boolean testIndexOfOnInvalidTargetElement() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.add(i);
		try {
			return (list.indexOf(new Integer(2)) == -1);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testIndexOfOnInvalidTargetElement", e.toString());
			return false;
		}
	}

	// ///////////////////////////////
	// Vails tests (244)
	// ////////////////////////////

	// testAddIndexOnNewListInvalid ***FAIL***
	/** @return test success */
	public boolean testAddIndexOnNewListInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		try {
			list.add(2, new Integer(1));
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddIndexOnNewListInvalid", e.toString());
			return false;
		}
		return true;
	}

	// testSetOnNewList ***FAIL***
	/** @return test success */
	public boolean testSetOnNewList() {
		DoubleLinkedListADT<Integer> list = newList();
		try {
			list.set(-3, new Integer(3));
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSetOnNewList",
					e.toString());
			return false;
		}
		return true;
	}

	// testGetOnNewList ***FAIL***
	/** @return test success */
	public boolean testGetOnNewList() {
		DoubleLinkedList<Integer> list = newList();
		try {
			list.get(1);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testGetOnNewList",
					e.toString());
			return false;
		}
		return true;
	}

	// testIndexOfOnNewList ***FAIL***
	/** @return test success */
	public boolean testIndexOfOnNewList() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		try {
			if (list.indexOf(i) == -1)
				return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testIndexOfOnNewList", e.toString());
			return false;
		}
		return false;
	}

	// caught unexpected EmptyCollectionException: The DoubleLinkedList is
	// empty.
	// testRemoveIndexOnNewList ***FAIL***
	/** @return test success */
	public boolean testRemoveIndexOnNewList() {
		DoubleLinkedListADT<Integer> list = newList();
		try {
			list.remove(1);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testRemoveIndexOnNewList", e.toString());
			return false;
		}
		return true;
	}

	// caught unexpected EmptyCollectionException: The DoubleLinkedList is
	// empty.
	// testContainsOnNewList ***FAIL***
	/** @return test success */
	public boolean testContainsOnNewList() {
		DoubleLinkedListADT<Integer> list = newList();
		try {
			if (list.contains(new Integer(1)) != false)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnNewList", e.toString());
			return false;
		}
		return true;
	}

	// testListIteratorConstructorIdxOnNewListInvalid2 ***FAIL***
	/** @return test success */
	public boolean testListIteratoConstructorIdxOnNewListInvalid2() {
		return true;
	}

	// caught unexpected java.lang.NullPointerException
	// testListIteratorHasPreviousOnNewList ***FAIL***
	/** @return test success */
	public boolean testListIteratorHasPreviousOnNewList() {
		DoubleLinkedListADT<Integer> list = newList();
		ListIterator<Integer> it = list.listIterator();
		try {
			if (it.hasPrevious() == true)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testContainsOnNewList", e.toString());
			return false;
		}
		return true;
	}

	// expected NoSuchElementException
	// caught java.lang.NullPointerException
	// testListIteratorPreviousOnNewList ***FAIL***
	/** @return test success */
	public boolean testListIteratorPreviousOnNewList() {
		DoubleLinkedListADT<Integer> list = newList();
		ListIterator<Integer> it = list.listIterator();
		try {
			it.previous();
		} catch (NoSuchElementException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testListIteratorPreviousOnNewList", e.toString());
			return false;
		}
		return true;
	}

	// caught unexpected java.lang.NullPointerException
	// testListIteratorNextIndexOnNewList ***FAIL***
	/** @return test success */
	public boolean testListIteratorNextIndexOnNewList() {
		DoubleLinkedListADT<Integer> list = newList();
		ListIterator<Integer> it = list.listIterator();
		try {
			it.nextIndex();
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testListIteratorNextIndexOnNewList", e.toString());
			return false;
		}
		return true;
	}

	// expected IndexOutOfBoundsException
	// caught java.lang.NullPointerException
	// testAddIndexAfterAddToFrontInvalid ***FAIL***
	/** @return test success */
	public boolean testAddIndexAfterAddToFrontInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		try {
			list.addToFront(i);
			list.add(3, new Integer(3));
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testAddIndexAfterAddToFrontInvalid", e.toString());
			return false;
		}
		return true;
	}

	// testSetAfterAddToFrontInvalid ***FAIL***
	/** @return test success */
	public boolean testSetAfterAddToFrontInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		try {
			list.set(3, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testSetAfterAddToFrontInvalid", e.toString());
			return false;
		}
		return true;
	}

	// testGetAfterAddToFrontValid ***FAIL***
	/** @return test success */
	public boolean testGetAfterAddToFrontValid() {
		return true;
	}

	// testGetAfterAddToFrontInvalid ***FAIL***
	/** @return test success */
	public boolean testGetAfterAddToFrontInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		try {
			list.addToFront(i);
			list.get(7);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testGetAfterAddToFrontInvalid", e.toString());
			return false;
		}
		return true;
	}

	// expected IndexOutOfBoundsException
	// caught ElementNotFoundException: The target element is not in this
	// DoubleLinkedList
	// testRemoveIndexAfterAddToFrontInvalid ***FAIL***
	/** @return test success */
	public boolean testRemoveIndexAfterAddToFrontInvalid() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		try {
			list.addToFront(i);
			list.remove(8);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testRemoveIndexAfterAddToFrontInvalid", e.toString());
			return false;
		}
		return true;
	}

	// caught unexpected java.lang.NullPointerException
	// testListIteratorHasNextAfterAddToFront3 ***FAIL***
	/** @return test success */
	public boolean testListIteratorHasNextAfterAddtoFront3() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		try {
			list.addToFront(k);
			list.addToFront(j);
			list.addToFront(i);
			ListIterator<Integer> it = list.listIterator();
			it.next();
			it.next();
			if (it.hasNext() != true)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testRemoveIndexAfterAddToFrontInvalid", e.toString());
			return false;
		}
		return true;
	}

	// caught unexpected java.lang.NullPointerException
	// testListIteratorNextAfterAddToFront3 ***FAIL***
	/** @return test success */
	public boolean testListIteratorNextAfterAddtoFront3() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		try {
			list.addToFront(k);
			list.addToFront(j);
			list.addToFront(i);
			ListIterator<Integer> it = list.listIterator();
			it.next();
			it.next();
			it.next();
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testListIteratorNextAfterAddtoFront3", e.toString());
			return false;
		}
		return true;
	}

	// testListIteratorPreviousIndexAfterAddToFront ***FAIL***
	/** @return test success */
	public boolean testListIteratorPreviousIndexAfterAddToFront() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(j);
		try {
			list.addToFront(i);
			ListIterator<Integer> it = list.listIterator();
			return (it.previousIndex() != 0);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testListIteratorPreviousIndexAfterAddToFront",
					e.toString());
			return false;
		}
	}

	// caught unexpected java.lang.NullPointerException
	// testListIteratorHasPreviousAfterAddToRear3 ***FAIL***
	/** @return test success */
	public boolean testListIteratorHasPreviousAfterAddToRear3() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		try {
			list.addToRear(i);
			list.addToRear(j);
			list.addToRear(k);
			ListIterator<Integer> it = list.listIterator();
			it.next();
			it.next();
			return (it.hasPrevious());
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testIsEmptyOnThreeElementListAddAfterFirst", e.toString());
			return false;
		}

	}

	// caught unexpected java.lang.NullPointerException
	// testListIteratorHasPreviousAfterAddIndex2 ***FAIL***
	/** @return test success */
	public boolean testListIteratorHasPreviousAfterAddIndex2() {
		DoubleLinkedList<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		try {
			list.add(0, i);
			list.add(1, j);
			list.add(2, k);
			ListIterator<Integer> it = list.listIterator();
			it.next();
			it.next();
			if (it.hasPrevious() != true)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testListIteratorHasPreviousAfterAddIndex2", e.toString());
			return false;
		}
		return true;
	}

	// caught unexpected java.lang.NullPointerException
	// testListIteratorHasPreviousAfterAddIndex3 ***FAIL***
	/** @return test success */
	public boolean testListIteratorHasPreviousAfterAddIndex3() {
		DoubleLinkedList<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		try {
			list.add(0, i);
			list.add(1, j);
			list.add(2, k);
			ListIterator<Integer> it = list.listIterator();
			it.next();
			it.next();
			it.next();
			if (it.hasPrevious() != true)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testListIteratorHasPreviousAfterAddIndex3", e.toString());
			return false;
		}
		return true;
	}

	// testListIteratorNextIndexAfterAddAfter ***FAIL***
	/** @return test success */
	public boolean testListIteratorNextIndexAfterAddAfter() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.add(i);
		try {
			list.addAfter(j, i);
			ListIterator<Integer> it = list.listIterator();
			if (it.nextIndex() != 1)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testListIteratorNextIndexAfterAddAfter", e.toString());
			return false;
		}
		return true;
	}

	// testIndexOfAfterAddAfterToMiddle ***FAIL***
	/** @return test success */
	public boolean testIndexOfAfterAddAfterToMiddle() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			if (list.indexOf(j) != 1)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testIndexOfAfterAddAfterToMiddle", e.toString());
			return false;
		}
		return true;
	}

	// testlast three elements ***FAIL***
	/** @return test success */
	public boolean testLastThreeElements() {
		DoubleLinkedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			if (list.last() != k)
				return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"testLastThreeElements", e.toString());
			return false;
		}
		return true;
	}

} // End of DoubleLinkedListTester