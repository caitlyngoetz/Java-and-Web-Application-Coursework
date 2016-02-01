import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A unit test class for UnorderedListADT.
 * This is a set of black box tests that should work for
 *  any implementation of UnorderedListADT.
 * 
 * NOTE: One set of example tests is given for the scenario of
 * a creating a new, empty list to get you started.
 * 
 * Method newList() returns one of two (or more) alternate
 * implementations to all tests, so you don't have to do a
 * search and replace on constructor calls in every test.
 *  
 * @author cgoetz: testing framework and empty list scenario
 */
public class ListTester {
	private int passes = 0;
	private int failures = 0;
	private int total = 0;

	/** @param args not used */
	public static void main(String[] args) {
		//to avoid every method being static
		ListTester tester = new ListTester();
		tester.runTests();
	}

	/**
	 * Returns an UnorderedListADT so the implementation can be changed
	 * in this one location rather than in every test.
	 * @return a new UnorderedListADT
	 */
	  private SingleLinkedList<Integer> newList() {
          return new SingleLinkedList<Integer>();
      }
	  
	  private SingleLinkedList<Integer> newList1() {
          SingleLinkedList<Integer> list = newList();
          list.add(1);
		  return list;
      }

	/** Print test results in a consistent format
	 * @param testDesc description of the test
	 * @param result indicates if the test passed or failed
	 */
	private void printTest(String testDesc, boolean result) {
		total++;
		if (result) {
			passes++;
		} else {
			failures++;
		}
		System.out.printf("%-46s\t%s\n", testDesc, (result ? "   PASS" : "***FAIL***"));
	}

	/** Print a final summary */
	private void printFinalSummary() {
		System.out.printf("\nTotal Tests: %d,  Passed: %d,  Failed: %d\n", total, passes, failures);
	}

	/**
	 * Run tests to confirm required functionality from list constructors and methods
	 */
	private void runTests() {
		/////////////////////////////////
		//UNORDERED ARRAY LIST TEST
		/////////////////////////////////
		
		// TESTS ON A NEW, EMPTY LIST
		printTest("testAddToFrontOnNewList", testAddToFrontOnNewList());
		printTest("testAddToRearOnNewList", testAddToRearOnNewList());
		printTest("testAddAfterOnNewList", testAddAfterOnNewList());
		printTest("testRemoveFirstOnNewList", testRemoveFirstOnNewList());
		printTest("testRemoveLastOnNewList", testRemoveLastOnNewList());
		printTest("testRemoveElementOnNewList", testRemoveElementOnNewList());
		printTest("testFirstOnNewList", testFirstOnNewList());
		printTest("testLastOnNewList", testLastOnNewList());
		printTest("testContainsOnNewList", testContainsOnNewList());
		printTest("testIsEmptyOnNewList", testIsEmptyOnNewList());
		printTest("testSizeOnNewList", testSizeOnNewList());
		printTest("testIteratorOnNewList", testIteratorOnNewList());
		printTest("testToStringOnNewList", testToStringOnNewList());

		//TEST ON A ONE ELEMENT LIST USING ADD TO FRONT 
		printTest("testAddToFrontOnOneElementListAddToFront", testAddToRearOnOneElementListAddToFront());
		printTest("testAddToRearOnOneElementListAddToFront", testAddToRearOnOneElementListAddToFront());
		printTest("testAddAfterOnOneElementListAddToFrontValid", testAddAfterOnOneElementListAddToFrontValid());
		printTest("testAddAfterOnOneElementListAddToFrontInvalid", testAddAfterOnOneElementListAddToFrontInvalid());
		printTest("testRemoveFirstOnOneElementListAddToFront", testRemoveFirstOnOneElementListAddToFront());
		printTest("testRemoveLastOnOneElementListAddToFront", testRemoveLastOnOneElementListAddToFront());
		printTest("testRemoveElementOnOneElementListAddToFrontValid", testRemoveElementOnOneElementListAddToFrontValid());
		printTest("testRemoveElementOnOneElementListAddToFrontInvalid", testRemoveElementOnOneElementListAddToFrontInvalid());
		printTest("testFirstOnOneElementListAddToFront", testFirstOnOneElementListAddToFront());
		printTest("testLastOnOneElementListAddToFront", testLastOnOneElementListAddToFront());
		printTest("testContainsOnOneElementListAddToFrontValid", testContainsOnOneElementListAddToFrontValid());
		printTest("testContainsOnOneElementListAddToFrontInvalid", testContainsOnOneElementListAddToFrontInvalid());
		printTest("testIsEmptyOnOneElementListAddToFront", testIsEmptyOnOneElementListAddToFront());
		printTest("testSizeOnOneElementListAddToFront", testSizeOnOneElementListAddToFront());
		printTest("testIteratorOnOneElementListAddToFront", testIteratorOnOneElementListAddToFront());
		printTest("testToStringOnOneElementListAddToFront", testToStringOnOneElementListAddToFront());

		//TEST ON A ONE ELEMENT LIST USING ADD TO REAR
		printTest("testAddToFrontOnOneElementListAddToRear", testAddToFrontOnOneElementListAddToRear());
		printTest("testAddToRearOnOneElementListAddToRear", testAddToRearOnOneElementListAddToRear());
		printTest("testAddAfterOnOneElementListAddToRearValid", testAddAfterOnOneElementListAddToRearValid());
		printTest("testAddAfterOnOneElementListAddToRearInvalid", testAddAfterOnOneElementListAddToRearInvalid());
		printTest("testRemoveFirstOnOneElementListAddToRear", testRemoveFirstOnOneElementListAddToRear());
		printTest("testRemoveLastOnOneElementListAddToRear", testRemoveLastOnOneElementListAddToRear());
		printTest("testRemoveElementOnOneElementListAddToRearValid", testRemoveElementOnOneElementListAddToRearValid());
		printTest("testRemoveElementOnOneElementListAddToRearInvalid", testRemoveElementOnOneElementListAddToRearInvalid());
		printTest("testFirstOnOneElementListAddToRear", testFirstOnOneElementListAddToRear());
		printTest("testLastOnOneElementListAddToRear", testLastOnOneElementListAddToRear());
		printTest("testContainsOnOneElementListAddToRearValid", testContainsOnOneElementListAddToRearValid());
		printTest("testContainsOnOneElementListAddToRearInvalid", testContainsOnOneElementListAddToRearInvalid());
		printTest("testIsEmptyOnOneElementListAddToRear", testIsEmptyOnOneElementListAddToRear());
		printTest("testSizeOnOneElementListAddToRear", testSizeOnOneElementListAddToRear());
		printTest("testIteratorOnOneElementListAddToRear", testIteratorOnOneElementListAddToRear());
		printTest("testToStringOnOneElementListAddToRear", testToStringOnOneElementListAddToRear());

		//TEST ON A ONE ELEMENT LIST USING REMOVE FIRST
		printTest("testAddToFrontOnOneElementListRemoveFirst", testAddToFrontOnOneElementListRemoveFirst());
		printTest("testAddToRearOnOneElementListRemoveFirst", testAddToRearOnOneElementListRemoveFirst());
		printTest("testAddAfterOnOneElementListRemoveFirstValid", testAddAfterOnOneElementListRemoveFirstValid());
		printTest("testAddAfterOnOneElementListRemoveFirstInvalid", testAddAfterOnOneElementListRemoveFirstInvalid());
		printTest("testRemoveFirstOnOneElementListRemoveFirst", testRemoveFirstOnOneElementListRemoveFirst());
		printTest("testRemoveLastOnOneElementListRemoveFirst", testRemoveLastOnOneElementListRemoveFirst());
		printTest("testRemoveElementOnOneElementListRemoveFirstValid", testRemoveElementOnOneElementListRemoveFirstValid());
		printTest("testRemoveElementOnOneElementListRemoveFirstInvalid", testRemoveElementOnOneElementListRemoveFirstInvalid());
		printTest("testFirstOnOneElementListRemoveFirst", testFirstOnOneElementListRemoveFirst());
		printTest("testLastOnOneElementListRemoveFirst", testLastOnOneElementListRemoveFirst());
		printTest("testContainsOnOneElementListRemoveFirstValid", testContainsOnOneElementListRemoveFirstValid());
		printTest("testContainsOnOneElementListRemoveFirstInvalid", testContainsOnOneElementListRemoveFirstInvalid());
		printTest("testIsEmptyOnOneElementListRemoveFirst", testIsEmptyOnOneElementListRemoveFirst());
		printTest("testSizeOnOneElementListRemoveFirst", testSizeOnOneElementListRemoveFirst());
		printTest("testIteratorOnOneElementListRemoveFirst", testIteratorOnOneElementListRemoveFirst());
		printTest("testToStringOnOneElementListRemoveFirst", testToStringOnOneElementListRemoveFirst());

		//TEST ON A ONE ELEMENT LIST USING REMOVE LAST
		printTest("testAddToFrontOnOneElementListRemoveLast", testAddToFrontOnOneElementListRemoveLast());
		printTest("testAddToRearOnOneElementListRemoveLast", testAddToRearOnOneElementListRemoveLast());
		printTest("testAddAfterOnOneElementListRemoveLastValid", testAddAfterOnOneElementListRemoveLastValid());
		printTest("testAddAfterOnOneElementListRemoveLastInvalid", testAddAfterOnOneElementListRemoveLastInvalid());
		printTest("testRemoveFirstOnOneElementListRemoveLast", testRemoveFirstOnOneElementListRemoveLast());
		printTest("testRemoveLastOnOneElementListRemoveLast", testRemoveLastOnOneElementListRemoveLast());
		printTest("testRemoveElementOnOneElementListRemoveLastValid", testRemoveElementOnOneElementListRemoveLastValid());
		printTest("testRemoveElementOnOneElementListRemoveLastInvalid", testRemoveElementOnOneElementListRemoveLastInvalid());
		printTest("testFirstOnOneElementListRemoveLast", testFirstOnOneElementListRemoveLast());
		printTest("testLastOnOneElementListRemoveLast", testLastOnOneElementListRemoveLast());
		printTest("testContainsOnOneElementListRemoveLastValid", testContainsOnOneElementListRemoveLastValid());
		printTest("testContainsOnOneElementListRemoveLastInvalid", testContainsOnOneElementListRemoveLastInvalid());
		printTest("testIsEmptyOnOneElementListRemoveLast", testIsEmptyOnOneElementListRemoveLast());
		printTest("testSizeOnOneElementListRemoveLast", testSizeOnOneElementListRemoveLast());
		printTest("testIteratorOnOneElementListRemoveLast", testIteratorOnOneElementListRemoveLast());
		printTest("testToStringOnOneElementListRemoveLast", testToStringOnOneElementListRemoveLast());

		//TEST ON A ONE ELEMENT LIST USING REMOVE
		printTest("testAddToFrontOnOneElementListRemove", testAddToFrontOnOneElementListRemove());
		printTest("testAddToRearOnOneElementListRemove", testAddToRearOnOneElementListRemove());
		printTest("testAddAfterOnOneElementListRemoveValid", testAddAfterOnOneElementListRemoveValid());
		printTest("testAddAfterOnOneElementListRemoveInvalid", testAddAfterOnOneElementListRemoveInvalid());
		printTest("testRemoveFirstOnOneElementListRemove", testRemoveFirstOnOneElementListRemove());
		printTest("testRemoveLastOnOneElementListRemove", testRemoveLastOnOneElementListRemove());
		printTest("testRemoveElementOnOneElementListRemoveValid", testRemoveElementOnOneElementListRemoveValid());
		printTest("testRemoveElementOnOneElementListRemoveInvalid", testRemoveElementOnOneElementListRemoveInvalid());
		printTest("testFirstOnOneElementListRemove", testFirstOnOneElementListRemove());
		printTest("testLastOnOneElementListRemove", testLastOnOneElementListRemove());
		printTest("testContainsOnOneElementListRemoveValid", testContainsOnOneElementListRemoveValid());
		printTest("testContainsOnOneElementListRemoveInvalid", testContainsOnOneElementListRemoveInvalid());
		printTest("testIsEmptyOnOneElementListRemove", testIsEmptyOnOneElementListRemove());
		printTest("testSizeOnOneElementListRemove", testSizeOnOneElementListRemove());
		printTest("testIteratorOnOneElementListRemove", testIteratorOnOneElementListRemove());
		printTest("testToStringOnOneElementListRemove", testToStringOnOneElementListRemove());

		//TEST ON A ONE ELEMENT LIST USING ADD AFTER
		printTest("testAddToFrontOnOneElementListAddAfter", testAddToFrontOnOneElementListAddAfter());
		printTest("testAddToRearOnOneElementListAddAfter", testAddToRearOnOneElementListAddAfter());
		printTest("testAddAfterOnOneElementListAddAfterValid", testAddAfterOnOneElementListAddAfterValid());
		printTest("testAddAfterOnOneElementListAddToAfterInvalid", testAddAfterOnOneElementListAddAfterInvalid());
		printTest("testRemoveFirstOnOneElementListAddAfter", testRemoveFirstOnOneElementListAddAfter());
		printTest("testRemoveLastOnOneElementListAddAfter", testRemoveLastOnOneElementListAddAfter());
		printTest("testRemoveElementOnOneElementListAddAfterValid", testRemoveElementOnOneElementListAddAfterValidOne());
		printTest("testRemoveElementOnOneElementListAddAfterValid", testRemoveElementOnOneElementListAddAfterValidTwo());
		printTest("testRemoveElementOnOneElementListAddAfterInvalid", testRemoveElementOnOneElementListAddAfterInvalid());
		printTest("testFirstOnOneElementListAddAfter", testFirstOnOneElementListAddAfter());
		printTest("testLastOnOneElementListAddAfter", testLastOnOneElementListAddAfter());
		printTest("testContainsOnOneElementListAddAfterValid", testContainsOnOneElementListAddAfterValidOne());
		printTest("testContainsOnOneElementListAddAfterValid", testContainsOnOneElementListAddAfterValidTwo());
		printTest("testContainsOnOneElementListAddAfterInvalid", testContainsOnOneElementListAddAfterInvalid());
		printTest("testIsEmptyOnOneElementListAddAfter", testIsEmptyOnOneElementListAddAfter());
		printTest("testSizeOnOneElementListAddAfter", testSizeOnOneElementListAddAfter());
		printTest("testIteratorOnOneElementListAddAfter", testIteratorOnOneElementListAddAfter());
		printTest("testToStringOnOneElementListAddAfter", testToStringOnOneElementListAddAfter());

		//TEST ON A TWO ELEMENT LIST USING ADD TO FRONT FOR FIRST ELEMENT
		printTest("testAddToFrontOnTwoElementListAddToFrontFirstElement", testAddToFrontOnTwoElementListAddToFrontFirstElement());
		printTest("testAddToRearOnTwoElementListAddToFrontFirstElement", testAddToRearOnTwoElementListAddToFrontFirstElement());
		printTest("testAddAfterOnTwoElementListAddToFrontFirstElementValidOne", testAddAfterOnTwoElementListAddToFrontFirstElementValidOne());
		printTest("testAddAfterOnTwoElementListAddToFrontFirstElementValidTwo", testAddAfterOnTwoElementListAddToFrontFirstElementValidTwo());
		printTest("testAddAfterOnTwoElementListAddToFrontFirstElementInvalid", testAddAfterOnTwoElementListAddToFrontFirstElementInvalid());
		printTest("testRemoveFirstOnTwoElementListAddToFrontFirstElement", testRemoveFirstOnTwoElementListAddToFrontFirstElement());
		printTest("testRemoveLastOnTwoElementListAddToFrontFirstElement", testRemoveLastOnTwoElementListAddToFrontFirstElement());
		printTest("testRemoveElementOnTwoElementListAddToFrontFirstElementValidOne", testRemoveElementOnTwoElementListAddToFrontFirstElementValidOne());
		printTest("testRemoveElementOnTwoElementListAddToFrontFirstElementValidTwo", testRemoveElementOnTwoElementListAddToFrontFirstElementValidTwo());
		printTest("testRemoveElementOnTwoElementListAddToFrontFirstElementInvalid", testRemoveElementOnTwoElementListAddToFrontFirstElementInvalid());
		printTest("testFirstOnTwoElementListAddToFrontFirstElement", testFirstOnTwoElementListAddToFrontFirstElement());
		printTest("testLastOnTwoElementListAddToFrontFirstElement", testLastOnTwoElementListAddToFrontFirstElement());
		printTest("testContainsOnTwoElementListAddToFrontFirstElementValidOne", testContainsOnTwoElementListAddToFrontFirstElementValidOne());
		printTest("testContainsOnTwoElementListAddToFrontFirstElementValidTwo", testContainsOnTwoElementListAddToFrontFirstElementValidTwo());
		printTest("testContainsOnTwoElementListAddToFrontFirstElementInvalid", testContainsOnTwoElementListAddToFrontFirstElementInvalid());
		printTest("testIsEmptyOnTwoElementListAddToFrontFirstElement", testIsEmptyOnTwoElementListAddToFrontFirstElement());
		printTest("testSizeOnTwoElementListAddToFrontFirstElement", testSizeOnTwoElementListAddToFrontFirstElement());
		printTest("testIteratorOnTwoElementListAddToFrontFirstElement", testIteratorOnTwoElementListAddToFrontFirstElement());
		printTest("testToStringOnTwoElementListAddToFrontFirstElement", testToStringOnTwoElementListAddToFrontFirstElement());

		//TEST ON A TWO ELEMENT LIST USING ADD TO REAR ON SECOND ELEMENT
		printTest("testAddToFrontOnTwoElementListAddToRearSecondElement", testAddToFrontOnTwoElementListAddToRearSecondElement());
		printTest("testAddToRearOnTwoElementListAddToRearSecondElement", testAddToRearOnTwoElementListAddToRearSecondElement());
		printTest("testAddAfterOnTwoElementListAddToRearSecondElementValidOne", testAddAfterOnTwoElementListAddToRearSecondElementValidOne());
		printTest("testAddAfterOnTwoElementListAddToRearSecondElementValidTwo", testAddAfterOnTwoElementListAddToRearSecondElementValidTwo());
		printTest("testAddAfterOnTwoElementListAddToRearSecondElementInvalid", testAddAfterOnTwoElementListAddToRearSecondElementInvalid());
		printTest("testRemoveFirstOnTwoElementListAddToRearSecondElement", testRemoveFirstOnTwoElementListAddToRearSecondElement());
		printTest("testRemoveLastOnTwoElementListAddToRearSecondElement", testRemoveLastOnTwoElementListAddToRearSecondElement());
		printTest("testRemoveElementOnTwoElementListAddToRearSecondElementValidOne", testRemoveElementOnTwoElementListAddToRearSecondElementValidOne());
		printTest("testRemoveElementOnTwoElementListAddToRearSecondElementValidTwo", testRemoveElementOnTwoElementListAddToRearSecondElementValidTwo());
		printTest("testRemoveElementOnTwoElementListAddToRearSecondElementInvalid", testRemoveElementOnTwoElementListAddToRearSecondElementInvalid());
		printTest("testFirstOnTwoElementListAddToRearSecondElement", testFirstOnTwoElementListAddToRearSecondElement());
		printTest("testLastOnTwoElementListAddToRearSecondElement", testLastOnTwoElementListAddToRearSecondElement());
		printTest("testContainsOnTwoElementListAddToRearSecondElementValidOne", testContainsOnTwoElementListAddToRearSecondElementValidOne());
		printTest("testContainsOnTwoElementListAddToRearSecondElementValidTwo", testContainsOnTwoElementListAddToRearSecondElementValidTwo());
		printTest("testContainsOnTwoElementListAddToRearSecondElementInvalid", testContainsOnTwoElementListAddToRearSecondElementInvalid());
		printTest("testIsEmptyOnTwoElementListAddToRearSecondElement", testIsEmptyOnTwoElementListAddToRearSecondElement());
		printTest("testSizeOnTwoElementListAddToRearSecondElement", testSizeOnTwoElementListAddToRearSecondElement());
		printTest("testIteratorOnTwoElementListAddToRearSecondElement", testIteratorOnTwoElementListAddToRearSecondElement());
		printTest("testToStringOnTwoElementListAddToRearSecondElement", testToStringOnTwoElementListAddToRearSecondElement());

		//TEST ON A TWO ELEMENT LIST USING REMOVE FIRST
		printTest("testAddToFrontOnTwoElementListRemoveFirstElement", testAddToFrontOnTwoElementListRemoveFirstElement());
		printTest("testAddToRearOnTwoElementListRemoveFirstElement", testAddToRearOnTwoElementListRemoveFirstElement());
		printTest("testAddAfterOnTwoElementListRemoveFirstElementValidOne", testAddAfterOnTwoElementListRemoveFirstElementValidOne());
		printTest("testAddAfterOnTwoElementListRemoveFirstElementValidTwo", testAddAfterOnTwoElementListRemoveFirstElementValidTwo());
		printTest("testAddAfterOnTwoElementListRemoveFirstElementInvalid", testAddAfterOnTwoElementListRemoveFirstElementInvalid());
		printTest("testRemoveFirstOnTwoElementListRemoveFirstElement", testRemoveFirstOnTwoElementListRemoveFirstElement());
		printTest("testRemoveLastOnTwoElementListRemoveFirstElement", testRemoveLastOnTwoElementListRemoveFirstElement());
		printTest("testRemoveElementOnTwoElementListRemoveFirstElementValidOne", testRemoveElementOnTwoElementListRemoveFirstElementValidOne());
		printTest("testRemoveElementOnTwoElementListRemoveFirstElementInvalid", testRemoveElementOnTwoElementListRemoveFirstElementInvalid());
		printTest("testFirstOnTwoElementListRemoveFirstElement", testFirstOnTwoElementListRemoveFirstElement());
		printTest("testLastOnTwoElementListRemoveFirstElement", testLastOnTwoElementListRemoveFirstElement());
		printTest("testContainsOnTwoElementListRemoveFirstElementValidOne", testContainsOnTwoElementListRemoveFirstElementValidOne());
		printTest("testContainsOnTwoElementListRemoveFirstElementValidTwo", testContainsOnTwoElementListRemoveFirstElementValidTwo());
		printTest("testContainsOnTwoElementListRemoveFirstElementInvalid", testContainsOnTwoElementListRemoveFirstElementInvalid());
		printTest("testIsEmptyOnTwoElementListRemoveFirstElement", testIsEmptyOnTwoElementListRemoveFirstElement());
		printTest("testSizeOnTwoElementListRemoveFirstElement", testSizeOnTwoElementListRemoveFirstElement());
		printTest("testIteratorOnTwoElementListRemoveFirstElement", testIteratorOnTwoElementListRemoveFirstElement());
		printTest("testToStringOnTwoElementListRemoveFirstElement", testToStringOnTwoElementListRemoveFirstElement());

		//TEST ON A TWO ELEMENT LIST USING REMOVE ON FIRST ELEMENT
		printTest("testAddToFrontOnTwoElementListRemoveFirst", testAddToFrontOnTwoElementListRemoveFirst());
		printTest("testAddToRearOnTwoElementListRemoveFirst", testAddToRearOnTwoElementListRemoveFirst());
		printTest("testAddAfterOnTwoElementListRemoveFirstValidOne", testAddAfterOnTwoElementListRemoveFirstValidOne());
		printTest("testAddAfterOnTwoElementListRemoveFirstValidTwo", testAddAfterOnTwoElementListRemoveFirstValidTwo());
		printTest("testAddAfterOnTwoElementListRemoveFirstInvalid", testAddAfterOnTwoElementListRemoveFirstInvalid());
		printTest("testRemoveFirstOnTwoElementListRemoveFirst", testRemoveFirstOnTwoElementListRemoveFirst());
		printTest("testRemoveLastOnTwoElementListRemoveFirst", testRemoveLastOnTwoElementListRemoveFirst());
		printTest("testRemoveElementOnTwoElementListRemoveFirstValidOne", testRemoveElementOnTwoElementListRemoveFirstValidOne());
		printTest("testRemoveElementOnTwoElementListRemoveFirstInvalid", testRemoveElementOnTwoElementListRemoveFirstInvalid());
		printTest("testFirstOnTwoElementListRemoveFirst", testFirstOnTwoElementListRemoveFirst());
		printTest("testLastOnTwoElementListRemoveFirst", testLastOnTwoElementListRemoveFirst());
		printTest("testContainsOnTwoElementListRemoveFirstValidOne", testContainsOnTwoElementListRemoveFirstValidOne());
		printTest("testContainsOnTwoElementListRemoveFirstValidTwo", testContainsOnTwoElementListRemoveFirstValidTwo());
		printTest("testContainsOnTwoElementListRemoveFirstInvalid", testContainsOnTwoElementListRemoveFirstInvalid());
		printTest("testIsEmptyOnTwoElementListRemoveFirst", testIsEmptyOnTwoElementListRemoveFirst());
		printTest("testSizeOnTwoElementListRemoveFirst", testSizeOnTwoElementListRemoveFirst());
		printTest("testIteratorOnTwoElementListRemoveFirst", testIteratorOnTwoElementListRemoveFirst());
		printTest("testToStringOnTwoElementListRemoveFirst", testToStringOnTwoElementListRemoveFirst());

		//TEST ON A TWO ELEMENT LIST USING ADD AFTER TO ADD MIDDLE ELEMENT
		printTest("testAddToFrontOnTwoElementListAddAfterSecondElement", testAddToFrontOnTwoElementListAddAfterSecondElement());
		printTest("testAddToRearOnTwoElementListAddAfterSecondElement", testAddToRearOnTwoElementListAddAfterSecondElement());
		printTest("testAddAfterOnTwoElementListAddAfterSecondElementValidOne", testAddAfterOnTwoElementListAddAfterSecondElementValidOne());
		printTest("testAddAfterOnTwoElementListAddAfterSecondElementValidTwo", testAddAfterOnTwoElementListAddAfterSecondElementValidTwo());
		printTest("testAddAfterOnTwoElementListAddAfterSecondElementValidThree", testAddAfterOnTwoElementListAddAfterSecondElementValidThree());
		printTest("testAddAfterOnTwoElementListAddAfterSecondElementInvalid", testAddAfterOnTwoElementListAddAfterSecondElementInvalid());
		printTest("testRemoveFirstOnTwoElementListAddAfterSecondElement", testRemoveFirstOnTwoElementListAddAfterSecondElement());
		printTest("testRemoveLastOnTwoElementListAddAfterSecondElement", testRemoveLastOnTwoElementListAddAfterSecondElement());
		printTest("testRemoveElementOnTwoElementListAddAfterSecondElementValidOne", testRemoveElementOnTwoElementListAddAfterSecondElementValidOne());
		printTest("testRemoveElementOnTwoElementListAddAfterSecondElementValidTwo", testRemoveElementOnTwoElementListAddAfterSecondElementValidTwo());
		printTest("testRemoveElementOnTwoElementListAddAfterSecondElementValidThree", testRemoveElementOnTwoElementListAddAfterSecondElementValidThree());
		printTest("testRemoveElementOnTwoElementListAddAfterSecondElementInvalid", testRemoveElementOnTwoElementListAddAfterSecondElementInvalid());
		printTest("testFirstOnTwoElementListAddAfterSecondElement", testFirstOnTwoElementListAddAfterSecondElement());
		printTest("testLastOnTwoElementListAddAfterSecondElement", testLastOnTwoElementListAddAfterSecondElement());
		printTest("testContainsOnTwoElementListAddAfterSecondElementValidOne", testContainsOnTwoElementListAddAfterSecondElementValidOne());
		printTest("testContainsOnTwoElementListAddAfterSecondElementValidTwo", testContainsOnTwoElementListAddAfterSecondElementValidTwo());
		printTest("testContainsOnTwoElementListAddAfterSecondElementValidThree", testContainsOnTwoElementListAddAfterSecondElementValidThree());
		printTest("testContainsOnTwoElementListAddAfterSecondElementInvalid", testContainsOnTwoElementListAddAfterSecondElementInvalid());
		printTest("testIsEmptyOnTwoElementListAddAfterSecondElement", testIsEmptyOnTwoElementListAddAfterSecondElement());
		printTest("testSizeOnTwoElementListAddAfterSecondElement", testSizeOnTwoElementListAddAfterSecondElement());
		printTest("testIteratorOnTwoElementListAddAfterSecondElement", testIteratorOnTwoElementListAddAfterSecondElement());
		printTest("testToStringOnTwoElementListAddAfterSecondElement", testToStringOnTwoElementListAddAfterSecondElement());

		//TEST ON A TWO ELEMENT LIST USING REMOVE ON LAST ELEMENT
		printTest("testAddToFrontOnTwoElementListRemoveLastElement", testAddToFrontOnTwoElementListRemoveLastElement());
		printTest("testAddToRearOnTwoElementListRemoveLastElement", testAddToRearOnTwoElementListRemoveLastElement());
		printTest("testAddAfterOnTwoElementListRemoveLastElementValidOne", testAddAfterOnTwoElementListRemoveLastElementValidOne());
		printTest("testAddAfterOnTwoElementListRemoveLastElementValidTwo", testAddAfterOnTwoElementListRemoveLastElementValidTwo());
		printTest("testAddAfterOnTwoElementListRemoveLastElementInvalid", testAddAfterOnTwoElementListRemoveLastElementInvalid());
		printTest("testRemoveFirstOnTwoElementListRemoveLastElement", testRemoveFirstOnTwoElementListRemoveLastElement());
		printTest("testRemoveLastOnTwoElementListRemoveLastElement", testRemoveLastOnTwoElementListRemoveLastElement());
		printTest("testRemoveElementOnTwoElementListRemoveLastElementValidOne", testRemoveElementOnTwoElementListRemoveLastElementValidOne());
		printTest("testRemoveElementOnTwoElementListRemoveLastElementInvalid", testRemoveElementOnTwoElementListRemoveLastElementInvalid());
		printTest("testFirstOnTwoElementListRemoveLastElement", testFirstOnTwoElementListRemoveLastElement());
		printTest("testLastOnTwoElementListRemoveLastElement", testLastOnTwoElementListRemoveLastElement());
		printTest("testContainsOnTwoElementListRemoveLastElementValidOne", testContainsOnTwoElementListRemoveLastElementValidOne());
		printTest("testContainsOnTwoElementListRemoveLastElementValidTwo", testContainsOnTwoElementListRemoveLastElementValidTwo());
		printTest("testContainsOnTwoElementListRemoveLastElementInvalid", testContainsOnTwoElementListRemoveLastElementInvalid());
		printTest("testIsEmptyOnTwoElementListRemoveLastElement", testIsEmptyOnTwoElementListRemoveLastElement());
		printTest("testSizeOnTwoElementListRemoveLastElement", testSizeOnTwoElementListRemoveLastElement());
		printTest("testIteratorOnTwoElementListRemoveLastElement", testIteratorOnTwoElementListRemoveLastElement());
		printTest("testToStringOnTwoElementListRemoveLastElement", testToStringOnTwoElementListRemoveLastElement());

		//TEST ON A TWO ELEMENT LIST USING REMOVE LAST
		printTest("testAddToFrontOnTwoElementListRemoveLast", testAddToFrontOnTwoElementListRemoveLast());
		printTest("testAddToRearOnTwoElementListRemoveLast", testAddToRearOnTwoElementListRemoveLast());
		printTest("testAddAfterOnTwoElementListRemoveLastValidOne", testAddAfterOnTwoElementListRemoveLastValidOne());
		printTest("testAddAfterOnTwoElementListRemoveLastValidTwo", testAddAfterOnTwoElementListRemoveLastValidTwo());
		printTest("testAddAfterOnTwoElementListRemoveLastInvalid", testAddAfterOnTwoElementListRemoveLastInvalid());
		printTest("testRemoveFirstOnTwoElementListRemoveLast", testRemoveFirstOnTwoElementListRemoveLast());
		printTest("testRemoveLastOnTwoElementListRemoveLast", testRemoveLastOnTwoElementListRemoveLast());
		printTest("testRemoveElementOnTwoElementListRemoveLastValidOne", testRemoveElementOnTwoElementListRemoveLastValidOne());
		printTest("testRemoveElementOnTwoElementListRemoveLastInvalid", testRemoveElementOnTwoElementListRemoveLastInvalid());
		printTest("testFirstOnTwoElementListRemoveLast", testFirstOnTwoElementListRemoveLast());
		printTest("testLastOnTwoElementListRemoveLast", testLastOnTwoElementListRemoveLast());
		printTest("testContainsOnTwoElementListRemoveLastValidOne", testContainsOnTwoElementListRemoveLastValidOne());
		printTest("testContainsOnTwoElementListRemoveLastValidTwo", testContainsOnTwoElementListRemoveLastValidTwo());
		printTest("testContainsOnTwoElementListRemoveLastInvalid", testContainsOnTwoElementListRemoveLastInvalid());
		printTest("testIsEmptyOnTwoElementListRemoveLast", testIsEmptyOnTwoElementListRemoveLast());
		printTest("testSizeOnTwoElementListRemoveLast", testSizeOnTwoElementListRemoveLast());
		printTest("testIteratorOnTwoElementListRemoveLast", testIteratorOnTwoElementListRemoveLast());
		printTest("testToStringOnTwoElementListRemoveLast", testToStringOnTwoElementListRemoveLast());

		//TEST ON A THREE ELEMENT LIST USING ADD TO FRONT ON FIRST ELEMENT
		printTest("testAddToFrontOnThreeElementListAddToFrontFirstElement", testAddToFrontOnThreeElementListAddToFrontFirstElement());
		printTest("testAddToRearOnThreeElementListAddToFrontFirstElement", testAddToRearOnThreeElementListAddToFrontFirstElement());
		printTest("testAddAfterOnThreeElementListAddToFrontFirstElementValidOne", testAddAfterOnThreeElementListAddToFrontFirstElementValidOne());
		printTest("testAddAfterOnThreeElementListAddToFrontFirstElementValidTwo", testAddAfterOnThreeElementListAddToFrontFirstElementValidTwo());
		printTest("testAddAfterOnThreeElementListAddToFrontFirstElementValidThree", testAddAfterOnThreeElementListAddToFrontFirstElementValidThree());
		printTest("testAddAfterOnThreeElementListAddToFrontFirstElementInvalid", testAddAfterOnThreeElementListAddToFrontFirstElementInvalid());
		printTest("testRemoveFirstOnThreeElementListAddToFrontFirstElement", testRemoveFirstOnThreeElementListAddToFrontFirstElement());
		printTest("testRemoveLastOnThreeElementListAddToFrontFirstElement", testRemoveLastOnThreeElementListAddToFrontFirstElement());
		printTest("testRemoveElementOnThreeElementListAddToFrontFirstElementValidOne", testRemoveElementOnThreeElementListAddToFrontFirstElementValidOne());
		printTest("testRemoveElementOnThreeElementListAddToFrontFirstElementValidTwo", testRemoveElementOnThreeElementListAddToFrontFirstElementValidTwo());
		printTest("testRemoveElementOnThreeElementListAddToFrontFirstElementValidThree", testRemoveElementOnThreeElementListAddToFrontFirstElementValidThree());
		printTest("testRemoveElementOnThreeElementListAddToFrontFirstElementInvalid", testRemoveElementOnThreeElementListAddToFrontFirstElementInvalid());
		printTest("testFirstOnThreeElementListAddToFrontFirstElement", testFirstOnThreeElementListAddToFrontFirstElement());
		printTest("testLastOnThreeElementListAddToFrontFirstElement", testLastOnThreeElementListAddToFrontFirstElement());
		printTest("testContainsOnThreeElementListAddToFrontFirstElementValidOne", testContainsOnThreeElementListAddToFrontFirstElementValidOne());
		printTest("testContainsOnThreeElementListAddToFrontFirstElementValidTwo", testContainsOnThreeElementListAddToFrontFirstElementValidTwo());
		printTest("testContainsOnThreeElementListAddToFrontFirstElementValidThree", testContainsOnThreeElementListAddToFrontFirstElementValidThree());
		printTest("testContainsOnThreeElementListAddToFrontFirstElementInvalid", testContainsOnThreeElementListAddToFrontFirstElementInvalid());
		printTest("testIsEmptyOnThreeElementListAddToFrontFirstElement", testIsEmptyOnThreeElementListAddToFrontFirstElement());
		printTest("testSizeOnThreeElementListAddToFrontFirstElement", testSizeOnThreeElementListAddToFrontFirstElement());
		printTest("testIteratorOnThreeElementListAddToFrontFirstElement", testIteratorOnThreeElementListAddToFrontFirstElement());
		printTest("testToStringOnThreeElementListAddToFrontFirstElement", testToStringOnThreeElementListAddToFrontFirstElement());

		//TEST ON A THREE ELEMENT LIST USING ADD AFTER ON SECONED ELEMENT
		printTest("testAddToFrontOnThreeElementListAddAfterSecondElement", testAddToFrontOnThreeElementListAddAfterSecondElement());
		printTest("testAddToRearOnThreeElementListAddAfterSecondElement", testAddToRearOnThreeElementListAddAfterSecondElement());
		printTest("testAddAfterOnThreeElementListAddAfterSecondElementValidOne", testAddAfterOnThreeElementListAddAfterSecondElementValidOne());
		printTest("testAddAfterOnThreeElementListAddAfterSecondElementValidTwo", testAddAfterOnThreeElementListAddAfterSecondElementValidTwo());
		printTest("testAddAfterOnThreeElementListAddAfterSecondElementValidThree", testAddAfterOnThreeElementListAddAfterSecondElementValidThree());
		printTest("testAddAfterOnThreeElementListAddAfterSecondElementInvalid", testAddAfterOnThreeElementListAddAfterSecondElementInvalid());
		printTest("testRemoveFirstOnThreeElementListAddAfterSecondElement", testRemoveFirstOnThreeElementListAddAfterSecondElement());
		printTest("testRemoveLastOnThreeElementListAddAfterSecondElement", testRemoveLastOnThreeElementListAddAfterSecondElement());
		printTest("testRemoveElementOnThreeElementListAddAfterSecondElementValidOne", testRemoveElementOnThreeElementListAddAfterSecondElementValidOne());
		printTest("testRemoveElementOnThreeElementListAddAfterSecondElementValidTwo", testRemoveElementOnThreeElementListAddAfterSecondElementValidTwo());
		printTest("testRemoveElementOnThreeElementListAddAfterSecondElementValidThree", testRemoveElementOnThreeElementListAddAfterSecondElementValidThree());
		printTest("testRemoveElementOnThreeElementListAddAfterSecondElementInvalid", testRemoveElementOnThreeElementListAddAfterSecondElementInvalid());
		printTest("testFirstOnThreeElementListAddAfterSecondElement", testFirstOnThreeElementListAddAfterSecondElement());
		printTest("testLastOnThreeElementListAddAfterSecondElement", testLastOnThreeElementListAddAfterSecondElement());
		printTest("testContainsOnThreeElementListAddAfterSecondElementValidOne", testContainsOnThreeElementListAddAfterSecondElementValidOne());
		printTest("testContainsOnThreeElementListAddAfterSecondElementValidTwo", testContainsOnThreeElementListAddAfterSecondElementValidTwo());
		printTest("testContainsOnThreeElementListAddAfterSecondElementValidThree", testContainsOnThreeElementListAddAfterSecondElementValidThree());
		printTest("testContainsOnThreeElementListAddAfterSecondElementInvalid", testContainsOnThreeElementListAddAfterSecondElementInvalid());
		printTest("testIsEmptyOnThreeElementListAddAfterSecondElement", testIsEmptyOnThreeElementListAddAfterSecondElement());
		printTest("testSizeOnThreeElementListAddAfterSecondElement", testSizeOnThreeElementListAddAfterSecondElement());
		printTest("testIteratorOnThreeElementListAddAfterSecondElement", testIteratorOnThreeElementListAddAfterSecondElement());
		printTest("testToStringOnThreeElementListAddAfterSecondElement", testToStringOnThreeElementListAddAfterSecondElement());

		//TEST ON A THREE ELEMENT LIST USING ADD TO REAR ON THE THIRD ELEMENT
		printTest("testAddToFrontOnThreeElementListAddToRearThirdElement", testAddToFrontThreeElementListAddToRearThirdElement());
		printTest("testAddToRearOnThreeElementListAddToRearThirdElement", testAddToRearOnThreeElementListAddToRearOnThirdElement());
		printTest("testAddAfterOnThreeElementListAddToRearThirdElementValidOne", testAddAfterOnThreeElementListAddToRearThirdElementValidOne());
		printTest("testAddAfterOnThreeElementListAddToRearThirdElementValidTwo", testAddAfterOnThreeElementListAddToRearThirdElementValidTwo());
		printTest("testAddAfterOnThreeElementListAddToRearThirdElementValidThree", testAddAfterOnThreeElementListAddToRearThirdElementValidThree());
		printTest("testAddAfterOnThreeElementListAddToRearThirdElementInvalid", testAddAfterOnThreeElementListAddToRearThirdElementInvalid());
		printTest("testRemoveFirstOnThreeElementListAddToRearThirdElement", testRemoveFirstOnThreeElementListAddToRearThirdElement());
		printTest("testRemoveLastOnThreeElementListAddToRearThirdElement", testRemoveLastOnThreeElementListAddToRearThirdElement());
		printTest("testRemoveElementOnThreeElementListAddToRearThirdElementValidOne", testRemoveElementOnThreeElementListAddToRearThirdElementValidOne());
		printTest("testRemoveElementOnThreeElementListAddToRearThirdElementValidTwo", testRemoveElementOnThreeElementListAddToRearThirdElementValidTwo());
		printTest("testRemoveElementOnThreeElementListAddToRearThirdElementValidThree", testRemoveElementOnThreeElementListAddToRearThirdElementValidThree());
		printTest("testRemoveElementOnThreeElementListAddToRearThirdElementInvalid", testRemoveElementOnThreeElementListAddToRearThirdElementInvalid());
		printTest("testFirstOnThreeElementListAddToRearThirdElement", testFirstOnThreeElementListAddToRearThirdElement());
		printTest("testLastOnThreeElementListAddToRearThirdElement", testLastOnThreeElementListAddToRearThirdElement());
		printTest("testContainsOnThreeElementListAddToRearThirdElementValidOne", testContainsOnThreeElementListAddToRearThirdElementValidOne());
		printTest("testContainsOnThreeElementListAddToRearThirdElementValidTwo", testContainsOnThreeElementListAddToRearThirdElementValidTwo());
		printTest("testContainsOnThreeElementListAddToRearThirdElementValidThree", testContainsOnThreeElementListAddToRearThirdElementValidThree());
		printTest("testContainsOnThreeElementListAddToRearThirdElementInvalid", testContainsOnThreeElementListAddToRearThirdElementInvalid());
		printTest("testIsEmptyOnThreeElementListAddToRearThirdElement", testIsEmptyOnThreeElementListAddToRearThirdElement());
		printTest("testSizeOnThreeElementListAddToRearThirdElement", testSizeOnThreeElementListAddToRearThirdElement());
		printTest("testIteratorOnThreeElementListAddToRearThirdElement", testIteratorOnThreeElementListAddToRearThirdElement());
		printTest("testToStringOnThreeElementListAddToRearThirdElement", testToStringOnThreeElementListAddToRearThirdElement());

		//TEST ON A THREE ELEMENT LIST USING ADD AFTER TO ADD AN ELEMENT IN BETWEEN FIRST AND SECOND
		printTest("testAddToFrontOnThreeElementListAddAfterFirst", testAddToFrontThreeElementListAddAfterFirst());
		printTest("testAddToRearOnThreeElementListAddAfterFirst", testAddToRearOnThreeElementListAddAfterFirst());
		printTest("testAddAfterOnThreeElementListAddAfterFirstValidOne", testAddAfterOnThreeElementListAddAfterFirstValidOne());
		printTest("testAddAfterOnThreeElementListAddAfterFirstValidTwo", testAddAfterOnThreeElementListAddAfterFirstValidTwo());
		printTest("testAddAfterOnThreeElementListAddAfterFirstValidThree", testAddAfterOnThreeElementListAddAfterFirstValidThree());
		printTest("testAddAfterOnThreeElementListAddAfterFirstValidFour", testAddAfterOnThreeElementListAddAfterFirstValidFour());
		printTest("testAddAfterOnThreeElementListAddAfterFirstInvalid", testAddAfterOnThreeElementListAddAfterFirstInvalid());
		printTest("testRemoveFirstOnThreeElementListAddAfterFirst", testRemoveFirstOnThreeElementListAddAfterFirst());
		printTest("testRemoveLastOnThreeElementListAddAfterFirst", testRemoveLastOnThreeElementListAddAfterFirst());
		printTest("testRemoveElementOnThreeElementListAddAfterFirstValidOne", testRemoveElementOnThreeElementListAddAfterFirstValidOne());
		printTest("testRemoveElementOnThreeElementListAddAfterFirstValidTwo", testRemoveElementOnThreeElementListAddAfterFirstValidTwo());
		printTest("testRemoveElementOnThreeElementListAddAfterFirstValidThree", testRemoveElementOnThreeElementListAddAfterFirstValidThree());
		printTest("testRemoveElementOnThreeElementListAddAfterFirstValidThree", testRemoveElementOnThreeElementListAddAfterFirstValidFour());
		printTest("testRemoveElementOnThreeElementListAddAfterFirstInvalid", testRemoveElementOnThreeElementListAddAfterFirstInvalid());
		printTest("testFirstOnThreeElementListAddAfterFirst", testFirstOnThreeElementListAddAfterFirst());
		printTest("testLastOnThreeElementListAddAfterFirst", testLastOnThreeElementListAddAfterFirst());
		printTest("testContainsOnThreeElementListAddAfterFirstValidOne", testContainsOnThreeElementListAddAfterFirstValidOne());
		printTest("testContainsOnThreeElementListAddAfterFirstValidTwo", testContainsOnThreeElementListAddAfterFirstValidTwo());
		printTest("testContainsOnThreeElementListAddAfterFirstValidThree", testContainsOnThreeElementListAddAfterFirstValidThree());
		printTest("testContainsOnThreeElementListAddAfterFirstValidFour", testContainsOnThreeElementListAddAfterFirstValidFour());
		printTest("testContainsOnThreeElementListAddAfterFirstInvalid", testContainsOnThreeElementListAddAfterFirstInvalid());
		printTest("testIsEmptyOnThreeElementListAddAfterFirst", testIsEmptyOnThreeElementListAddAfterFirst());
		printTest("testSizeOnThreeElementListAddAfterFirst", testSizeOnThreeElementListAddAfterFirst());
		printTest("testIteratorOnThreeElementListAddAfterFirst", testIteratorOnThreeElementListAddAfterFirst());
		printTest("testToStringOnThreeElementListAddAfterFirst", testToStringOnThreeElementListAddAfterFirst());

		//TEST ON A THREE ELEMENT LIST USING ADD AFTER TO ADD AN ELEMENT IN BETWEEN SECOND AND THIRD
		printTest("testAddToFrontOnThreeElementListAddAfterSecond", testAddToFrontThreeElementListAddAfterSecond());
		printTest("testAddToRearOnThreeElementListAddAfterSecond", testAddToRearOnThreeElementListAddAfterSecond());
		printTest("testAddAfterOnThreeElementListAddAfterSecondValidOne", testAddAfterOnThreeElementListAddAfterSecondValidOne());
		printTest("testAddAfterOnThreeElementListAddAfterSecondValidTwo", testAddAfterOnThreeElementListAddAfterSecondValidTwo());
		printTest("testAddAfterOnThreeElementListAddAfterSecondValidThree", testAddAfterOnThreeElementListAddAfterSecondValidThree());
		printTest("testAddAfterOnThreeElementListAddAfterSecondValidFour", testAddAfterOnThreeElementListAddAfterSecondValidFour());
		printTest("testAddAfterOnThreeElementListAddAfterSecondInvalid", testAddAfterOnThreeElementListAddAfterSecondInvalid());
		printTest("testRemoveFirstOnThreeElementListAddAfterSecond", testRemoveFirstOnThreeElementListAddAfterSecond());
		printTest("testRemoveLastOnThreeElementListAddAfterSecond", testRemoveLastOnThreeElementListAddAfterSecond());
		printTest("testRemoveElementOnThreeElementListAddAfterSecondValidOne", testRemoveElementOnThreeElementListAddAfterSecondValidOne());
		printTest("testRemoveElementOnThreeElementListAddAfterSecondValidTwo", testRemoveElementOnThreeElementListAddAfterSecondValidTwo());
		printTest("testRemoveElementOnThreeElementListAddAfterSecondValidThree", testRemoveElementOnThreeElementListAddAfterSecondValidThree());
		printTest("testRemoveElementOnThreeElementListAddAfterSecondValidThree", testRemoveElementOnThreeElementListAddAfterSecondValidFour());
		printTest("testRemoveElementOnThreeElementListAddAfterSecondInvalid", testRemoveElementOnThreeElementListAddAfterSecondInvalid());
		printTest("testFirstOnThreeElementListAddAfterSecond", testFirstOnThreeElementListAddAfterSecond());
		printTest("testLastOnThreeElementListAddAfterSecond", testLastOnThreeElementListAddAfterSecond());
		printTest("testContainsOnThreeElementListAddAfterSecondValidOne", testContainsOnThreeElementListAddAfterSecondValidOne());
		printTest("testContainsOnThreeElementListAddAfterSecondValidTwo", testContainsOnThreeElementListAddAfterSecondValidTwo());
		printTest("testContainsOnThreeElementListAddAfterSecondValidThree", testContainsOnThreeElementListAddAfterSecondValidThree());
		printTest("testContainsOnThreeElementListAddAfterSecondValidFour", testContainsOnThreeElementListAddAfterSecondValidFour());
		printTest("testContainsOnThreeElementListAddAfterSecondInvalid", testContainsOnThreeElementListAddAfterSecondInvalid());
		printTest("testIsEmptyOnThreeElementListAddAfterSecond", testIsEmptyOnThreeElementListAddAfterSecond());
		printTest("testSizeOnThreeElementListAddAfterSecond", testSizeOnThreeElementListAddAfterSecond());
		printTest("testIteratorOnThreeElementListAddAfterSecond", testIteratorOnThreeElementListAddAfterSecond());
		printTest("testToStringOnThreeElementListAddAfterSecond", testToStringOnThreeElementListAddAfterSecond());
		
		//TEST ON A THREE ELEMENT LIST USING ADD AFTER TO ADD AN ELEMENT AFTER THE THIRD ELEMENT 
		printTest("testAddToFrontOnThreeElementListAddAfterThird", testAddToFrontThreeElementListAddAfterThird());
		printTest("testAddToRearOnThreeElementListAddAfterThird", testAddToRearOnThreeElementListAddAfterThird());
		printTest("testAddAfterOnThreeElementListAddAfterThirdValidOne", testAddAfterOnThreeElementListAddAfterThirdValidOne());
		printTest("testAddAfterOnThreeElementListAddAfterThirdValidTwo", testAddAfterOnThreeElementListAddAfterThirdValidTwo());
		printTest("testAddAfterOnThreeElementListAddAfterThirdValidThree", testAddAfterOnThreeElementListAddAfterThirdValidThree());
		printTest("testAddAfterOnThreeElementListAddAfterThirdValidFour", testAddAfterOnThreeElementListAddAfterThirdValidFour());
		printTest("testAddAfterOnThreeElementListAddAfterThirdInvalid", testAddAfterOnThreeElementListAddAfterThirdInvalid());
		printTest("testRemoveFirstOnThreeElementListAddAfterThird", testRemoveFirstOnThreeElementListAddAfterThird());
		printTest("testRemoveLastOnThreeElementListAddAfterThird", testRemoveLastOnThreeElementListAddAfterThird());
		printTest("testRemoveElementOnThreeElementListAddAfterThirdValidOne", testRemoveElementOnThreeElementListAddAfterThirdValidOne());
		printTest("testRemoveElementOnThreeElementListAddAfterThirdValidTwo", testRemoveElementOnThreeElementListAddAfterThirdValidTwo());
		printTest("testRemoveElementOnThreeElementListAddAfterThirdValidThree", testRemoveElementOnThreeElementListAddAfterThirdValidThree());
		printTest("testRemoveElementOnThreeElementListAddAfterThirdValidThree", testRemoveElementOnThreeElementListAddAfterThirdValidFour());
		printTest("testRemoveElementOnThreeElementListAddAfterThirdInvalid", testRemoveElementOnThreeElementListAddAfterThirdInvalid());
		printTest("testFirstOnThreeElementListAddAfterThird", testFirstOnThreeElementListAddAfterThird());
		printTest("testLastOnThreeElementListAddAfterThird", testLastOnThreeElementListAddAfterThird());
		printTest("testContainsOnThreeElementListAddAfterThirdValidOne", testContainsOnThreeElementListAddAfterThirdValidOne());
		printTest("testContainsOnThreeElementListAddAfterThirdValidTwo", testContainsOnThreeElementListAddAfterThirdValidTwo());
		printTest("testContainsOnThreeElementListAddAfterThirdValidThree", testContainsOnThreeElementListAddAfterThirdValidThree());
		printTest("testContainsOnThreeElementListAddAfterThirdValidFour", testContainsOnThreeElementListAddAfterThirdValidFour());
		printTest("testContainsOnThreeElementListAddAfterThirdInvalid", testContainsOnThreeElementListAddAfterThirdInvalid());
		printTest("testIsEmptyOnThreeElementListAddAfterThird", testIsEmptyOnThreeElementListAddAfterThird());
		printTest("testSizeOnThreeElementListAddAfterThird", testSizeOnThreeElementListAddAfterThird());
		printTest("testIteratorOnThreeElementListAddAfterThird", testIteratorOnThreeElementListAddAfterThird());
		printTest("testToStringOnThreeElementListAddAfterThird", testToStringOnThreeElementListAddAfterThird());

		//TEST ON A THREE ELEMENT LIST USING REMOVE FIRST (21)
		printTest("testAddToFrontOnThreeElementListRemoveFirst", testAddToFrontOnThreeElementListRemoveFirst());
		printTest("testAddToRearOnThreeElementListRemoveFirst", testAddToRearOnThreeElementListRemoveFirst());
		printTest("testAddAfterOnThreeElementListRemoveFirstValidOne", testAddAfterOnThreeElementListRemoveFirstValidOne());
		printTest("testAddAfterOnThreeElementListRemoveFirstValidTwo", testAddAfterOnThreeElementListRemoveFirstValidTwo());
		printTest("testAddAfterOnThreeElementListRemoveFirstValidThree", testAddAfterOnThreeElementListRemoveFirstValidThree());
		printTest("testAddAfterOnThreeElementListRemoveFirstInvalid", testAddAfterOnThreeElementListRemoveFirstInvalid());
		printTest("testRemoveFirstOnThreeElementListRemoveFirst", testRemoveFirstOnThreeElementListRemoveFirst());
		printTest("testRemoveLastOnThreeElementListRemoveFirst", testRemoveLastOnThreeElementListRemoveFirst());
		printTest("testRemoveElementOnThreeElementListRemoveFirstValidOne", testRemoveElementOnThreeElementListRemoveFirstValidOne());
		printTest("testRemoveElementOnThreeElementListRemoveFirstValidTwo", testRemoveElementOnThreeElementListRemoveFirstValidTwo());
		printTest("testRemoveElementOnThreeElementListRemoveFirstInvalid", testRemoveElementOnThreeElementListRemoveFirstInvalid());
		printTest("testFirstOnThreeElementListRemoveFirst", testFirstOnThreeElementListRemoveFirst());
		printTest("testLastOnThreeElementListRemoveFirst", testLastOnThreeElementListRemoveFirst());
		printTest("testContainsOnThreeElementListRemoveFirstValidOne", testContainsOnThreeElementListRemoveFirstValidOne());
		printTest("testContainsOnThreeElementListRemoveFirstValidTwo", testContainsOnThreeElementListRemoveFirstValidTwo());
		printTest("testContainsOnThreeElementListRemoveFirstValidThree", testContainsOnThreeElementListRemoveFirstValidThree());
		printTest("testContainsOnThreeElementListRemoveFirstInvalid", testContainsOnThreeElementListRemoveFirstInvalid());
		printTest("testIsEmptyOnThreeElementListRemoveFirst", testIsEmptyOnThreeElementListRemoveFirst());
		printTest("testSizeOnThreeElementListRemoveFirst", testSizeOnThreeElementListRemoveFirst());
		printTest("testIteratorOnThreeElementListRemoveFirst", testIteratorOnThreeElementListRemoveFirst());
		printTest("testToStringOnThreeElementListRemoveFirst", testToStringOnThreeElementListRemoveFirst());

		//TEST ON A THREE ELEMENT LIST USING REMOVE ON FIRST ELEMENT (21)
		printTest("testAddToFrontOnThreeElementListRemoveFirstElement", testAddToFrontOnThreeElementListRemoveFirstElement());
		printTest("testAddToRearOnThreeElementListRemoveFirstElement", testAddToRearOnThreeElementListRemoveFirstElement());
		printTest("testAddAfterOnThreeElementListRemoveFirstElementValidOne", testAddAfterOnThreeElementListRemoveFirstElementValidOne());
		printTest("testAddAfterOnThreeElementListRemoveFirstElementValidTwo", testAddAfterOnThreeElementListRemoveFirstElementValidTwo());
		printTest("testAddAfterOnThreeElementListRemoveFirstElementValidThree", testAddAfterOnThreeElementListRemoveFirstElementValidThree());
		printTest("testAddAfterOnThreeElementListRemoveFirstElementInvalid", testAddAfterOnThreeElementListRemoveFirstElementInvalid());
		printTest("testRemoveFirstOnThreeElementListRemoveFirstElement", testRemoveFirstOnThreeElementListRemoveFirstElement());
		printTest("testRemoveLastOnThreeElementListRemoveFirstElement", testRemoveLastOnThreeElementListRemoveFirstElement());
		printTest("testRemoveElementOnThreeElementListRemoveFirstElementValidOne", testRemoveElementOnThreeElementListRemoveFirstElementValidOne());
		printTest("testRemoveElementOnThreeElementListRemoveFirstElementValidTwo", testRemoveElementOnThreeElementListRemoveFirstElementValidTwo());
		printTest("testRemoveElementOnThreeElementListRemoveFirstElementInvalid", testRemoveElementOnThreeElementListRemoveFirstElementInvalid());
		printTest("testFirstOnThreeElementListRemoveFirstElement", testFirstOnThreeElementListRemoveFirstElement());
		printTest("testLastOnThreeElementListRemoveFirstElement", testLastOnThreeElementListRemoveFirstElement());
		printTest("testContainsOnThreeElementListRemoveFirstElementValidOne", testContainsOnThreeElementListRemoveFirstElementValidOne());
		printTest("testContainsOnThreeElementListRemoveFirstElementValidTwo", testContainsOnThreeElementListRemoveFirstElementValidTwo());
		printTest("testContainsOnThreeElementListRemoveFirstElementValidThree", testContainsOnThreeElementListRemoveFirstElementValidThree());
		printTest("testContainsOnThreeElementListRemoveFirstElementInvalid", testContainsOnThreeElementListRemoveFirstElementInvalid());
		printTest("testIsEmptyOnThreeElementListRemoveFirstElement", testIsEmptyOnThreeElementListRemoveFirstElement());
		printTest("testSizeOnThreeElementListRemoveFirstElement", testSizeOnThreeElementListRemoveFirstElement());
		printTest("testIteratorOnThreeElementListRemoveFirstElement", testIteratorOnThreeElementListRemoveFirstElement());
		printTest("testToStringOnThreeElementListRemoveFirstElement", testToStringOnThreeElementListRemoveFirstElement());

		//TEST ON A THREE ELEMENT LIST USING REMOVE ON SECOND ELEMENT (21)
		printTest("testAddToFrontOnThreeElementListRemoveSecondElement", testAddToFrontOnThreeElementListRemoveSecondElement());
		printTest("testAddToRearOnThreeElementListRemoveSecondElement", testAddToRearOnThreeElementListRemoveSecondElement());
		printTest("testAddAfterOnThreeElementListRemoveSecondElementValidOne", testAddAfterOnThreeElementListRemoveSecondElementValidOne());
		printTest("testAddAfterOnThreeElementListRemoveSecondElementValidTwo", testAddAfterOnThreeElementListRemoveSecondElementValidTwo());
		printTest("testAddAfterOnThreeElementListRemoveSecondElementValidThree", testAddAfterOnThreeElementListRemoveSecondElementValidThree());
		printTest("testAddAfterOnThreeElementListRemoveSecondElementInvalid", testAddAfterOnThreeElementListRemoveSecondElementInvalid());
		printTest("testRemoveFirstOnThreeElementListRemoveSecondElement", testRemoveFirstOnThreeElementListRemoveSecondElement());
		printTest("testRemoveLastOnThreeElementListRemoveSecondElement", testRemoveLastOnThreeElementListRemoveSecondElement());
		printTest("testRemoveElementOnThreeElementListRemoveSecondElementValidOne", testRemoveElementOnThreeElementListRemoveSecondElementValidOne());
		printTest("testRemoveElementOnThreeElementListRemoveSecondElementValidTwo", testRemoveElementOnThreeElementListRemoveSecondElementValidTwo());
		printTest("testRemoveElementOnThreeElementListRemoveSecondElementInvalid", testRemoveElementOnThreeElementListRemoveSecondElementInvalid());
		printTest("testFirstOnThreeElementListRemoveSecondElement", testFirstOnThreeElementListRemoveSecondElement());
		printTest("testLastOnThreeElementListRemoveSecondElement", testLastOnThreeElementListRemoveSecondElement());
		printTest("testContainsOnThreeElementListRemoveSecondElementValidOne", testContainsOnThreeElementListRemoveSecondElementValidOne());
		printTest("testContainsOnThreeElementListRemoveSecondElementValidTwo", testContainsOnThreeElementListRemoveSecondElementValidTwo());
		printTest("testContainsOnThreeElementListRemoveSecondElementValidThree", testContainsOnThreeElementListRemoveSecondElementValidThree());
		printTest("testContainsOnThreeElementListRemoveSecondElementInvalid", testContainsOnThreeElementListRemoveSecondElementInvalid());
		printTest("testIsEmptyOnThreeElementListRemoveSecondElement", testIsEmptyOnThreeElementListRemoveSecondElement());
		printTest("testSizeOnThreeElementListRemoveSecondElement", testSizeOnThreeElementListRemoveSecondElement());
		printTest("testIteratorOnThreeElementListRemoveSecondElement", testIteratorOnThreeElementListRemoveSecondElement());
		printTest("testToStringOnThreeElementListRemoveSecondElement", testToStringOnThreeElementListRemoveSecondElement());

		//TEST ON A THREE ELEMENT LIST USING REMOVE ON THRID ELEMENT (22)
		printTest("testAddToFrontOnThreeElementListRemoveThirdElement", testAddToFrontOnThreeElementListRemoveThirdElement());
		printTest("testAddToRearOnThreeElementListRemoveThirdElement", testAddToRearOnThreeElementListRemoveThirdElement());
		printTest("testAddAfterOnThreeElementListRemoveThirdElementValidOne", testAddAfterOnThreeElementListRemoveThirdElementValidOne());
		printTest("testAddAfterOnThreeElementListRemoveThirdElementValidTwo", testAddAfterOnThreeElementListRemoveThirdElementValidTwo());
		printTest("testAddAfterOnThreeElementListRemoveThirdElementValidThree", testAddAfterOnThreeElementListRemoveThirdElementValidThree());
		printTest("testAddAfterOnThreeElementListRemoveThirdElementInvalid", testAddAfterOnThreeElementListRemoveThirdElementInvalid());
		printTest("testRemoveFirstOnThreeElementListRemoveThirdElement", testRemoveFirstOnThreeElementListRemoveThirdElement());
		printTest("testRemoveLastOnThreeElementListRemoveThirdElement", testRemoveLastOnThreeElementListRemoveThirdElement());
		printTest("testRemoveElementOnThreeElementListRemoveThirdElementValidOne", testRemoveElementOnThreeElementListRemoveThirdElementValidOne());
		printTest("testRemoveElementOnThreeElementListRemoveThirdElementValidTwo", testRemoveElementOnThreeElementListRemoveThirdElementValidTwo());
		printTest("testRemoveElementOnThreeElementListRemoveThirdElementInvalid", testRemoveElementOnThreeElementListRemoveThirdElementInvalid());
		printTest("testFirstOnThreeElementListRemoveThirdElement", testFirstOnThreeElementListRemoveThirdElement());
		printTest("testLastOnThreeElementListRemoveThirdElement", testLastOnThreeElementListRemoveThirdElement());
		printTest("testContainsOnThreeElementListRemoveThirdElementValidOne", testContainsOnThreeElementListRemoveThirdElementValidOne());
		printTest("testContainsOnThreeElementListRemoveThirdElementValidTwo", testContainsOnThreeElementListRemoveThirdElementValidTwo());
		printTest("testContainsOnThreeElementListRemoveThirdElementValidThree", testContainsOnThreeElementListRemoveThirdElementValidThree());
		printTest("testContainsOnThreeElementListRemoveThirdElementInvalid", testContainsOnThreeElementListRemoveThirdElementInvalid());
		printTest("testIsEmptyOnThreeElementListRemoveThirdElement", testIsEmptyOnThreeElementListRemoveThirdElement());
		printTest("testSizeOnThreeElementListRemoveThirdElement", testSizeOnThreeElementListRemoveThirdElement());
		printTest("testIteratorOnThreeElementListRemoveThirdElement", testIteratorOnThreeElementListRemoveThirdElement());
		printTest("testToStringOnThreeElementListRemoveThirdElement", testToStringOnThreeElementListRemoveThirdElement());

		//TEST ON THREE ELEMENT LIST USING REMOVE LAST (21)
		printTest("testAddToFrontOnThreeElementListRemoveLast", testAddToFrontOnThreeElementListRemoveLast());
		printTest("testAddToRearOnThreeElementListRemoveLast", testAddToRearOnThreeElementListRemoveLast());
		printTest("testAddAfterOnThreeElementListRemoveLastValidOne", testAddAfterOnThreeElementListRemoveLastValidOne());
		printTest("testAddAfterOnThreeElementListRemoveLastValidTwo", testAddAfterOnThreeElementListRemoveLastValidTwo());
		printTest("testAddAfterOnThreeElementListRemoveLastValidThree", testAddAfterOnThreeElementListRemoveLastValidThree());
		printTest("testAddAfterOnThreeElementListRemoveLastInvalid", testAddAfterOnThreeElementListRemoveLastInvalid());
		printTest("testRemoveFirstOnThreeElementListRemoveLast", testRemoveFirstOnThreeElementListRemoveLast());
		printTest("testRemoveLastOnThreeElementListRemoveLast", testRemoveLastOnThreeElementListRemoveLast());
		printTest("testRemoveElementOnThreeElementListRemoveLastValidOne", testRemoveElementOnThreeElementListRemoveLastValidOne());
		printTest("testRemoveElementOnThreeElementListRemoveLastValidTwo", testRemoveElementOnThreeElementListRemoveLastValidTwo());
		printTest("testRemoveElementOnThreeElementListRemoveLastInvalid", testRemoveElementOnThreeElementListRemoveLastInvalid());
		printTest("testFirstOnThreeElementListRemoveLast", testFirstOnThreeElementListRemoveLast());
		printTest("testLastOnThreeElementListRemoveLast", testLastOnThreeElementListRemoveLast());
		printTest("testContainsOnThreeElementListRemoveLastValidOne", testContainsOnThreeElementListRemoveLastValidOne());
		printTest("testContainsOnThreeElementListRemoveLastValidTwo", testContainsOnThreeElementListRemoveLastValidTwo());
		printTest("testContainsOnThreeElementListRemoveLastValidThree", testContainsOnThreeElementListRemoveLastValidThree());
		printTest("testContainsOnThreeElementListRemoveLastInvalid", testContainsOnThreeElementListRemoveLastInvalid());
		printTest("testIsEmptyOnThreeElementListRemoveLast", testIsEmptyOnThreeElementListRemoveLast());
		printTest("testSizeOnThreeElementListRemoveLast", testSizeOnThreeElementListRemoveLast());
		printTest("testIteratorOnThreeElementListRemoveLast", testIteratorOnThreeElementListRemoveLast());
		printTest("testToStringOnThreeElementListRemoveLast", testToStringOnThreeElementListRemoveLast());

		
		//////////////////////////////
		//INDEXED LIST TESTS (20)
		//////////////////////////////
		
		//TEST ON A NEW, EMPTY LIST USING ADD(A)
		printTest("testAddOnNewList", testAddOnNewList());
		
		//TEST ON A NEW EMPTY LIST USING ADD(0,A)
		printTest("testAddUsingIndexOnNewList", testAddUsingIndexOnNewList());
		
		
		//TEST ON AN ONE ELEMENT LIST USING SET(0,B)
		printTest("testSetOnOneElementList()", testSetOnOneElementList());
		
		//TEST ON AN ONE ELEMENT LIST USING ADD(0,B)
		printTest("testAddOnOneElementListOne()", testAddOnOneElementListOne());
		
		//TEST ON AN ONE ELEMENT LIST USING ADD(1,B)
		printTest("testAddOnOneElementListTwo()", testAddOnOneElementListTwo());
		
	
		//TEST ON A TWO ELEMENT LIST USING SET(0,C)
		printTest("testSetOnTwoElementListOne()", testSetOnTwoElementListOne());
		
		//TEST ON A TWO ELEMENT LIST USING SET(1,C)
		printTest("testSetOnTwoElementListTwo()", testSetOnTwoElementListTwo());
		
		//TEST ON A TWO ELEMENT LIST USING ADD(C)
		printTest("testAddOnTwoElementListOne()",testAddOnTwoElementListOne());
		
		//TEST ON A TWO ELEMENT LIST USING ADD(0,C)
		printTest("testAddOnTwoElementListTwo()", testAddOnTwoElementListTwo());
		
		//TEST ON A TWO ELEMENT LIST USING ADD(1,C)
		printTest("testAddOnTwoElementListThree()", testAddOnTwoElementListThree());
		
		//TEST ON A TWO ELEMENT LIST USING ADD(2, C)
		printTest("testAddOnTwoElementListFour()", testAddOnTwoElementListFour());
		
		//TEST ON A THREE ELEMENT LIST USING REMOVE(0)
		printTest("testRemoveOnThreeElementListOne()", testRemoveOnThreeElementListOne());
		
		//TEST ON A THREE ELEMENT LIST USING REMOVE(1)
		printTest("testRemoveOnThreeElementListTwo()", testRemoveOnThreeElementListTwo());
		
		//TEST ON A THREE ELEMENT LIST USING REMOVE(2)
		printTest("testRemoveOnThreeElementListThree()", testRemoveOnThreeElementListThree());
		
		//TEST ON A THREE ELEMENT LIST USING SET(0,D)
		printTest("testSetOnThreeElementListOne()", testSetOnThreeElementListOne());
		
		//TEST ON A THREE ELEMENT LIST USING SET(1,D)
		printTest("testSetOnThreeElementListTwo()", testSetOnThreeElementListTwo());
	
		//TEST ON A THREE ELEMENT LIS USING SET(2,D)
		printTest("testSetOnThreeElementListThree()", testSetOnThreeElementListThree());
		
		////////////////////////////
		//Single Linked List Tests
		////////////////////////////
		
		//TEST ADD TO FRONT ON AN EMPTY LIST
		printTest("testAddToFrontOnEmptyLList", testAddToFrontOnEmptyLList());
		
		//TEST ADD TO REAR ON AN EMPTY LIST
		printTest("testAddToRearOnEmptyLList", testAddToRearOnEmptyLList());
		
		//TEST ADD AFTER ON ONE ELEMENT LIST LINKED LIST
		printTest("testAddAfterOnOneElementList", testAddAfterOnOneElementLList());
		
		//TEST FIRST ON A NEW EMPTY LIST
		printTest("testFirstOnNewLList", testFirstOnNewLList());
		
		//TEST FIRST ON A ONE ELEMENT LINKED LIST
		printTest("testFirstOnOneElementLList", testFirstOnOneElementLList());
		
		//TEST SIZE ON A NEW LINKED LIST
		printTest("testSizeOnEmptyLList", testSizeOnEmptyLList());
		
		//TEST SIZE ON A ONE ELEMENT LIST
		printTest("testSizeOnOneElementLList", testSizeOnOneElementLList());
		
		//TEST IS EMPTY ON A EMPTY LIST
		printTest("testIsEmptyOnEmptyLList", testIsEmptyOnEmptyLList());;
		
		//TEST IS EMPTY ON ONE ELEMENT LIST
		printTest("testIsEmptyOnOneElementLList", testIsEmptyOnOneElementLList());
		
		/////////////////
		//final verdict
		/////////////////
		printFinalSummary();
	}

	///////////////////////////////
	//UNORDERED LIST TESTS
	//////////////////////////////
	
	
	////////////////////////////
	//SCENARIO: NEW, EMPTY LIST TODO
	////////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnNewList() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		try {
			list.addToFront(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnNewList", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnNewList() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		try {
			list.addToRear(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnNewList", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnNewList() {
		UnorderedListADT<Integer> list = newList();
		try {
			list.addAfter(new Integer(1), new Integer(2));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnNewList", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnNewList() {
		UnorderedListADT<Integer> list = newList();
		try {
			list.removeFirst();
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnNewList", "EmptyCollectionException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveLastOnNewList() {
		UnorderedListADT<Integer> list = newList();
		try {
			list.removeLast();
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnNewList", "EmptyCollectionException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveElementOnNewList() {
		UnorderedListADT<Integer> list = newList();
		try {
			list.remove(new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnNewList", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnNewList() {
		UnorderedListADT<Integer> list = newList();
		try {
			list.first(); //exception expected
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnNewList", "EmptyCollectionException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testLastOnNewList() {
		UnorderedListADT<Integer> list = newList();
		try {
			list.last(); //exception expected
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnNewList", "EmptyCollectionException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testContainsOnNewList() {
		AbstractLinkedList<Integer> list = newList();
		try {
			return (list.contains(new Integer(3)) == false);
		}catch (EmptyCollectionException e){
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnNewList", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnNewList() {
		UnorderedListADT<Integer> list = newList();
		try {
			return (list.isEmpty() == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnNewList", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnNewList() {
		UnorderedListADT<Integer> list = newList();
		try {
			return (list.size() == 0);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnNewList", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnNewList() {
		UnorderedListADT<Integer> list = newList();
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == true) { //should be false
				return false;
			}
			try {
				it.next(); //NoSuchElementException expected
			} catch (NoSuchElementException e) {
				//iterator() returned an Iterator<Integer>,
				//hasNext() returned false,
				//and next() threw a NoSuchElementException
				return true;
			}
			//next() did not throw an exception
			return false;
		} catch (Exception e) {
			//iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnNewList", e.toString());
			return false;
		}
	}

	/** toString() is difficult to test - would like to confirm that
	 * the default address output has been overridden
	 * @return test success */
	private boolean testToStringOnNewList() {
		UnorderedListADT<Integer> list = newList();
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
//			if (str.length() == 0) {
//				return false;
//			}
//			char lastChar = str.charAt(str.length()-1);
//			if (str.contains("@")
//					&& !str.contains(" ")
//					&& Character.isLetter(str.charAt(0)) 
//					&& (Character.isDigit(lastChar)
//							||
//							(lastChar >= 'a' && lastChar <= 'f'))) {
//				return false; //looks like default toString()
//			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	////////////////////////////
	//SCENARIO: TESTS ON A ONE ELEMENT LIST USING ADD TO FRONT TODO
	////////////////////////////


	/** @return test success */
	private boolean testAddToRearOnOneElementListAddToFront() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addToRear(j);
			if(list.last() != j) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnOneElementListAddToFront", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnOneElementListAddToFrontValid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(j, i);
			if(list.last() != j) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnOneElementListAddToFrontValid", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAfterOnOneElementListAddToFrontInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(i, j);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnOneElementListAddToFrontInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnOneElementListAddToFront() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		try {
			if(list.removeFirst() != i) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnOneElementListAddToFront", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnOneElementListAddToFront() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		try {
			if(list.removeLast() != i) return false;

		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnOneElementListAddToFront", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnOneElementListAddToFrontValid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		try {
			if(list.remove(i) != i) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnOneElementListAddToFrontValid", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnOneElementListAddToFrontInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		try {
			list.remove(new Integer(2));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnOneElementListAddToFrontInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnOneElementListAddToFront() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		try {
			if(list.first() != i) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnOneElementListAddToFront", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnOneElementListAddToFront() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		try {
			if(list.last() != i) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnNewList", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnOneElementListAddToFrontValid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		try {
			return (list.contains(i) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnOneElementListAddToFrontValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnOneElementListAddToFrontInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		try {
			return (list.contains(new Integer(2)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnOneElementListAddToFrontInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnOneElementListAddToFront() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		try {
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnOneElementListAddToFront", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnOneElementListAddToFront() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		try {
			return (list.size() == 1);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnOneElementListAddToFront", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnOneElementListAddToFront() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { //should be false
				return true;
			}
			try {
				it.next(); //NoSuchElementException expected
			} catch (NoSuchElementException e) {
				//iterator() returned an Iterator<Integer>,
				//hasNext() returned false,
				//and next() threw a NoSuchElementException
				return true;
			}
			//next() did not throw an exception
			return true;
		} catch (Exception e) {
			//iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnOneElementListAddToFront", e.toString());
			return false;
		}
	}

	/** toString() is difficult to test - would like to confirm that
	 * the default address output has been overridden
	 * @return test success */
	private boolean testToStringOnOneElementListAddToFront() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length()-1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0)) 
					&& (Character.isDigit(lastChar)
							||
							(lastChar >= 'a' && lastChar <= 'f'))) {
				return false; //looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	////////////////////////////
	//SCENARIO: TESTS ON A ONE ELEMENT LIST USING ADD TO REAR TODO
	////////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnOneElementListAddToRear() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToRear(i);
		try {
			list.addToFront(j);
			if(list.first() != j) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnOneElementListAddToRear", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnOneElementListAddToRear() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToRear(i);
		try {
			list.addToRear(j);
			if(list.last() != j) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnOneElementListAddToRear", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnOneElementListAddToRearValid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToRear(i);
		try {
			list.addAfter(j, i);
			if(list.last() != j) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnOneElementListAddToRearValid", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAfterOnOneElementListAddToRearInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToRear(i);
		try {
			list.addAfter(new Integer(2), new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnOneElementListAddToRearInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnOneElementListAddToRear() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToRear(i);
		try {
			if(list.removeFirst() != i) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnOneElementListAddToRear", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnOneElementListAddToRear() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToRear(i);
		try {
			if(list.removeLast() != i) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnOneElementListAddToRear", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnOneElementListAddToRearValid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToRear(i);
		try {
			if(list.remove(i) != i) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnOneElementListAddToRearValid", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnOneElementListAddToRearInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToRear(i);
		try {
			list.remove(new Integer(2));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnOneElementListAddToRearInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnOneElementListAddToRear() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToRear(i);
		try {
			if(list.first() != i) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnOneElementListAddToRear", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnOneElementListAddToRear() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToRear(i);
		try {
			if(list.last() != i) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnOneElementListAddToRear", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnOneElementListAddToRearValid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToRear(i);
		try {
			return (list.contains(i) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnOneElementListAddToRearValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnOneElementListAddToRearInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToRear(i);
		try {
			return (list.contains(new Integer(2)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnOneELementListAddToRearInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnOneElementListAddToRear() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToRear(i);
		try {
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnOneElementListAddToRear", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnOneElementListAddToRear() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToRear(i);
		try {
			return (list.size() == 1);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnOneElementListAddToRear", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnOneElementListAddToRear() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToRear(i);
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { //should be false
				return true;
			}
			try {
				it.next(); //NoSuchElementException expected
			} catch (NoSuchElementException e) {
				//iterator() returned an Iterator<Integer>,
				//hasNext() returned false,
				//and next() threw a NoSuchElementException
				return true;
			}
			//next() did not throw an exception
			return true;
		} catch (Exception e) {
			//iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnOneElementListAddToRear", e.toString());
			return false;
		}
	}

	/** toString() is difficult to test - would like to confirm that
	 * the default address output has been overridden
	 * @return test success */
	private boolean testToStringOnOneElementListAddToRear() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToRear(i);
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length()-1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0)) 
					&& (Character.isDigit(lastChar)
							||
							(lastChar >= 'a' && lastChar <= 'f'))) {
				return false; //looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	////////////////////////////
	//SCENARIO: TESTS ON A ONE ELEMENT LIST USING REMOVE FIRST TODO
	////////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnOneElementListRemoveFirst() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.removeFirst();
		try {
			list.addToFront(j);
			if(list.first() != j) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnOneElementListRemoveFirst", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnOneElementListRemoveFirst() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.removeFirst();
		try {
			list.addToRear(j);
			if(list.last() != j) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnOneElementListRemoveFirst", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnOneElementListRemoveFirstValid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.removeFirst();
		try {
			list.addAfter(j, i);
			if(list.last() != j) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnOneElementListRemoveFirstValid", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAfterOnOneElementListRemoveFirstInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeFirst();
		try {
			list.addAfter(new Integer(2), new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnOneElementListRemoveFirstInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnOneElementListRemoveFirst() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeFirst();
		try {
			if(list.removeFirst() != i) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnOneElementListRemoveFirst", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnOneElementListRemoveFirst() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeFirst();
		try {
			if(list.removeLast() != i) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnOneElementListRemoveFirst", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnOneElementListRemoveFirstValid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeFirst();
		try {
			if(list.remove(i) != i) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnOneElementListRemoveFirstValid", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnOneElementListRemoveFirstInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeFirst();
		try {
			list.remove(new Integer(2));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnOneElementListRemoveFirstInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnOneElementListRemoveFirst() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeFirst();
		try {
			if(list.first() != i) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnOneElementListRemoveFirst", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnOneElementListRemoveFirst() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeFirst();
		try {
			if(list.last() != i) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnOneElementListRemoveFirst", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnOneElementListRemoveFirstValid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeFirst();
		try {
			return (list.contains(i) == false);
		}catch (EmptyCollectionException e) {
			return true;
		}
		catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnOneELementListRemoveFirstValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnOneElementListRemoveFirstInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeFirst();
		try {
			return (list.contains(new Integer(2)) == false);
		 }catch (EmptyCollectionException e) {
			return true;
		} 
		catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnONeElementListRemoveFirstInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnOneElementListRemoveFirst() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeFirst();
		try {
			return (list.isEmpty() == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnOneElementListRemoveFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnOneElementListRemoveFirst() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeFirst();
		try {
			return (list.size() == 0);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnOneElementListRemoveFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnOneElementListRemoveFirst() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeFirst();
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { //should be false
				return true;
			}
			try {
				it.next(); //NoSuchElementException expected
			} catch (NoSuchElementException e) {
				//iterator() returned an Iterator<Integer>,
				//hasNext() returned false,
				//and next() threw a NoSuchElementException
				return true;
			}
			//next() did not throw an exception
			return true;
		} catch (Exception e) {
			//iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnOneElementListRemoveFirst", e.toString());
			return false;
		}
	}

	/** toString() is difficult to test - would like to confirm that
	 * the default address output has been overridden
	 * @return test success */
	private boolean testToStringOnOneElementListRemoveFirst() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		try {
			list.removeFirst();
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
//			if (str.length() == 0) {
//				return true;
//			}
//			char lastChar = str.charAt(str.length()-1);
//			if (str.contains("@")
//					&& !str.contains(" ")
//					&& Character.isLetter(str.charAt(0)) 
//					&& (Character.isDigit(lastChar)
//							||
//							(lastChar >= 'a' && lastChar <= 'f'))) {
//				return false; //looks like default toString()
//			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	////////////////////////////
	//SCENARIO: TESTS ON A ONE ELEMENT LIST USING REMOVE LAST TODO
	////////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnOneElementListRemoveLast() {
		UnorderedListADT<Integer> list = newList1();
		Integer j = new Integer(1);
		try {
			list.removeLast();
			list.addToFront(j);
			
			if(list.first() == j) 
				return true;
			else{
				return false;
			}
			
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnOneElementListRemoveLast", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testAddToRearOnOneElementListRemoveLast() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.removeLast();
		try {
			list.addToRear(j);
			if(list.last() != j) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnOneElementListRemoveLast", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnOneElementListRemoveLastValid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.removeLast();
		try {
			list.addAfter(j, i);
			if(list.last() != j) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnOneElementListRemoveLastValid", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAfterOnOneElementListRemoveLastInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeLast();
		try {
			list.addAfter(new Integer(2), new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnOneElementListRemoveLastInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnOneElementListRemoveLast() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeLast();
		try {
			if(list.removeFirst() != i) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnOneElementListRemoveLast", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnOneElementListRemoveLast() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeLast();
		try {
			if(list.removeLast() != i) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnOneElementListRemoveLast", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnOneElementListRemoveLastValid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeLast();
		try {
			if(list.remove(i) != i) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnOneElementListRemoveLastValid", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnOneElementListRemoveLastInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeLast();
		try {
			list.remove(new Integer(2));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnOneElementListRemoveLastInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnOneElementListRemoveLast() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeLast();
		try {
			if(list.first() != i) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnOneElementListRemoveLast", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnOneElementListRemoveLast() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeLast();
		try {
			if(list.last() != i) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnOneElementListRemoveLast", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnOneElementListRemoveLastValid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeLast();
		try {
			return (list.contains(i) == false);
		}catch (EmptyCollectionException e){
			return true;
		}
		catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnOneELementListRemoveLastValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnOneElementListRemoveLastInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeLast();
		try {
			return (list.contains(new Integer(2)) == false);
		}catch (EmptyCollectionException e){ 
			return true;
		}
		catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnOneElementListRemoveLastInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnOneElementListRemoveLast() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeLast();
		try {
			return (list.isEmpty() == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnOneElementListRemoveLast", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnOneElementListRemoveLast() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeLast();
		try {
			return (list.size() == 0);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnOneElementListRemoveLast", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnOneElementListRemoveLast() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeLast();
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { //should be false
				return true;
			}
			try {
				it.next(); //NoSuchElementException expected
			} catch (NoSuchElementException e) {
				//iterator() returned an Iterator<Integer>,
				//hasNext() returned false,
				//and next() threw a NoSuchElementException
				return true;
			}
			//next() did not throw an exception
			return true;
		} catch (Exception e) {
			//iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnOneElementListRemoveLast", e.toString());
			return false;
		}
	}

	/** toString() is difficult to test - would like to confirm that
	 * the default address output has been overridden
	 * @return test success */
	private boolean testToStringOnOneElementListRemoveLast() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.removeLast();
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
//			if (str.length() == 0) {
//				return false;
//			}
//			char lastChar = str.charAt(str.length()-1);
//			if (str.contains("@")
//					&& !str.contains(" ")
//					&& Character.isLetter(str.charAt(0)) 
//					&& (Character.isDigit(lastChar)
//							||
//							(lastChar >= 'a' && lastChar <= 'f'))) {
//				return false; //looks like default toString()
//			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	////////////////////////////
	//SCENARIO: TESTS ON A ONE ELEMENT LIST USING REMOVE  TODO
	////////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnOneElementListRemove() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.remove(i);
		try {
			list.addToFront(j);
			if(list.first() != j) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnOneElementListRemove", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnOneElementListRemove() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.remove(i);
		try {
			list.addToRear(j);
			if(list.last() != j) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnOneElementListRemove", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnOneElementListRemoveValid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.remove(i);
		try {
			list.addAfter(j, i);
			if(list.last() != j) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnOneElementListRemoveValid", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAfterOnOneElementListRemoveInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.remove(i);
		try {
			list.addAfter(new Integer(2), new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnOneElementListRemoveInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnOneElementListRemove() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.remove(i);
		try {
			if(list.removeFirst() != i) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnOneElementListRemove", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnOneElementListRemove() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.remove(i);
		try {
			if(list.removeLast() != i) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnOneElementListRemove", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnOneElementListRemoveValid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.remove(i);
		try {
			if(list.remove(i) != i) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnOneElementListRemoveValid", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnOneElementListRemoveInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.remove(i);
		try {
			list.remove(new Integer(2));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnOneElementListRemoveInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnOneElementListRemove() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.remove(i);
		try {
			if(list.first() != i) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnOneElementListRemove", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnOneElementListRemove() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.remove(i);
		try {
			if(list.last() != i) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnOneElementListRemove", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnOneElementListRemoveValid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.remove(i);
		try {
			return (list.contains(i) == false);
		}catch (EmptyCollectionException e) {
			return true;
		}
		catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnOneElementListRemoveValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnOneElementListRemoveInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.remove(i);
		try {
			return (list.contains(new Integer(2)) == false);
		}catch (EmptyCollectionException e){ 
			return true;
		}
		catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnOneElementListRemoveInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnOneElementListRemove() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.remove(i);
		try {
			return (list.isEmpty() == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnOneElementListRemove", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnOneElementListRemove() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.remove(i);
		try {
			return (list.size() == 0);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnOneElementListRemove", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnOneElementListRemove() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.remove(i);
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { //should be false
				return true;
			}
			try {
				it.next(); //NoSuchElementException expected
			} catch (NoSuchElementException e) {
				//iterator() returned an Iterator<Integer>,
				//hasNext() returned false,
				//and next() threw a NoSuchElementException
				return true;
			}
			//next() did not throw an exception
			return true;
		} catch (Exception e) {
			//iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnOneElementListRemove", e.toString());
			return false;
		}
	}

	/** toString() is difficult to test - would like to confirm that
	 * the default address output has been overridden
	 * @return test success */
	private boolean testToStringOnOneElementListRemove() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.remove(i);
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
//			if (str.length() == 0) {
//				return false;
//			}
//			char lastChar = str.charAt(str.length()-1);
//			if (str.contains("@")
//					&& !str.contains(" ")
//					&& Character.isLetter(str.charAt(0)) 
//					&& (Character.isDigit(lastChar)
//							||
//							(lastChar >= 'a' && lastChar <= 'f'))) {
//				return false; //looks like default toString()
//			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	////////////////////////////
	//SCENARIO: TESTS ON A ONE ELEMENT LIST USING ADD AFTER TODO
	////////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnOneElementListAddAfter() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(j, i);
			if(list.last() != j) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnOneElementListAddAfter", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnOneElementListAddAfter() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(j, i);
			if(list.last() != j) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnOneElementListAddAfter", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnOneElementListAddAfterValid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(j, i);
			if(list.last() != j) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnOneElementListAddAfterValid", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAfterOnOneElementListAddAfterInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		try {
			list.addAfter(new Integer(2), new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnOneElementListAddAfterInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnOneElementListAddAfter() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(j,  i);
			if(list.removeFirst() != i) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnOneElementListAddAfter", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnOneElementListAddAfter() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(j,i);
			if(list.removeLast() != j) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnOneElementListAddAfter", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnOneElementListAddAfterValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(j, i);
			if(list.remove(i) != i) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnOneElementListAddAfterValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnOneElementListAddAfterValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(j, i);
			if(list.remove(j) != j) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnOneElementListAddAfterValidTwo", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnOneElementListAddAfterInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(j, i);
			list.remove(new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnOneElementListAddAfterInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnOneElementListAddAfter() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(j, i);
			if(list.first() != i) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnOneElementListAddAfter", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnOneElementListAddAfter() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(j, i);
			if(list.last() != j) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnOneElementListAddAfter", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnOneElementListAddAfterValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(j, i);
			return (list.contains(i) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnOneElementListAddAfterValidOne", e.toString());
			return false;
		}
	}

	private boolean testContainsOnOneElementListAddAfterValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(j, i);
			return (list.contains(j) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnOneElemetnListAddAfterValidTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnOneElementListAddAfterInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(j, i);
			return (list.contains(new Integer(3)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnOneElementListAddAfterInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnOneElementListAddAfter() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(j, i);
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnOneElementListAddAfter", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnOneElementListAddAfter() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		try {
			list.addAfter(j, i);
			return (list.size() == 2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnOneElementListAddAfter", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnOneElementListAddAfter() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addAfter(j, i);
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { //should be false
				return true;
			}
			try {
				it.next(); //NoSuchElementException expected
			} catch (NoSuchElementException e) {
				//iterator() returned an Iterator<Integer>,
				//hasNext() returned false,
				//and next() threw a NoSuchElementException
				return true;
			}
			//next() did not throw an exception
			return true;
		} catch (Exception e) {
			//iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnOneElementListAddAfter", e.toString());
			return false;
		}
	}

	/** toString() is difficult to test - would like to confirm that
	 * the default address output has been overridden
	 * @return test success */
	private boolean testToStringOnOneElementListAddAfter() {
		UnorderedListADT<Integer> list = newList();
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
			char lastChar = str.charAt(str.length()-1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0)) 
					&& (Character.isDigit(lastChar)
							||
							(lastChar >= 'a' && lastChar <= 'f'))) {
				return false; //looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}


	////////////////////////////
	//SCENARIO: TESTS ON A TWO ELEMENT LIST ADDING 1ST ELEMENT TO FRONT TODO
	////////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnTwoElementListAddToFrontFirstElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.addToFront(k);
			if(list.first() != k) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnTwoElementListAddToFrontFirstElement", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnTwoElementListAddToFrontFirstElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.addToRear(k);
			if(list.last() != k) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnTwoElementListAddToFrontFirstElement", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListAddToFrontFirstElementValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.addAfter(k, i);
			if(list.contains(k) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnTwoElementListAddToFrontFirstElementValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListAddToFrontFirstElementValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.addAfter(k, j);
			if(list.contains(k) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnTwoElementListAddToFrontFirstElementValidTwo", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAfterOnTwoElementListAddToFrontFirstElementInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.addAfter(new Integer(4), new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnTwoElementListAddToFrontFirstElementInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnTwoElementListAddToFrontFirstElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			if(list.removeFirst() != i) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnTwoElementListAddToFrontFirstElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnTwoElementListAddToFrontFirstElement() {
		UnorderedListADT<Integer> list = newList1();
		Integer j = new Integer(2);
		list.addToRear(j);
		try {
			if(list.removeLast() != j) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnTwoElementListAddToFrontFirstElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnTwoElementListAddToFrontFirstElementValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			if(list.remove(i) != i) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnTwoElementListAddToFrontFirstElementValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnTwoElementListAddToFrontFirstElementValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			if(list.remove(j) != j) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnTwoElementListAddToFrontFirstElementValidTwo", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}
	/** @return test success */
	private boolean testRemoveElementOnTwoElementListAddToFrontFirstElementInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnTwoElementListAddToFrontFirstElementInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnTwoElementListAddToFrontFirstElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			if(list.first() != i) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnTwoElementListAddToFrontFirstElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnTwoElementListAddToFrontFirstElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			if(list.last() != j) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnTwoElementListAddToFrontFirstElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListAddToFrontFirstElementValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			return (list.contains(i) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnTwoElementListAddToFrontFirstElementValidOne", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListAddToFrontFirstElementValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			return (list.contains(j) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnTwoElementListAddToFrontFirstElementValidTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListAddToFrontFirstElementInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			return (list.contains(new Integer(3)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnTwoElementListAddToFrontFirstElementInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnTwoElementListAddToFrontFirstElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnTwoElementListAddToFrontFirstElement", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnTwoElementListAddToFrontFirstElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			return (list.size() == 2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnTwoElementListAddToFrontFirstElement", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnTwoElementListAddToFrontFirstElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { //should be false
				return true;
			}
			try {
				it.next(); //NoSuchElementException expected
			} catch (NoSuchElementException e) {
				//iterator() returned an Iterator<Integer>,
				//hasNext() returned false,
				//and next() threw a NoSuchElementException
				return true;
			}
			//next() did not throw an exception
			return true;
		} catch (Exception e) {
			//iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnTwoElementListAddToFrontFirstElement", e.toString());
			return false;
		}
	}

	/** toString() is difficult to test - would like to confirm that
	 * the default address output has been overridden
	 * @return test success */
	private boolean testToStringOnTwoElementListAddToFrontFirstElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length()-1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0)) 
					&& (Character.isDigit(lastChar)
							||
							(lastChar >= 'a' && lastChar <= 'f'))) {
				return false; //looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	////////////////////////////
	//SCENARIO: TESTS ON A TWO ELEMENT LIST USING ADD TO REAR ON SECOND ELEMENT TODO
	////////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnTwoElementListAddToRearSecondElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.addToFront(k);
			if(list.first() != k) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnTwoElementListAddToRearSecondElement", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnTwoElementListAddToRearSecondElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.addToRear(k);
			if(list.last() != k) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnTwoElementListAddToRearSecondElement", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListAddToRearSecondElementValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.addAfter(k, i);
			if(list.contains(k) == true) return true; 
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnTwoElementListAddToRearSecondElementValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListAddToRearSecondElementValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.addAfter(k, j);
			if(list.contains(k) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnTwoElementListAddToRearSecondElementValidTwo", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAfterOnTwoElementListAddToRearSecondElementInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.addAfter(new Integer(4), new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnTwoElementListAddToRearSecondElementInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnTwoElementListAddToRearSecondElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			if(list.removeFirst() != i) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnTwoElementListAddToRearSecondElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnTwoElementListAddToRearSecondElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			if(list.removeLast() != j) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnTwoElementListAddToRearSecondElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnTwoElementListAddToRearSecondElementValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			if(list.remove(i) != i) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnTwoElementListAddToRearSecondElementValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnTwoElementListAddToRearSecondElementValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			if(list.remove(j) != j) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnTwoElementListAddToRearSecondElementValidTwo", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}
	/** @return test success */
	private boolean testRemoveElementOnTwoElementListAddToRearSecondElementInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnTwoElementListAddToRearSecondElementInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnTwoElementListAddToRearSecondElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			if(list.first() != i) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnTwoElementListAddToRearSecondElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnTwoElementListAddToRearSecondElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			if(list.last() != j) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnTwoElementListAddToRearSecondElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListAddToRearSecondElementValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			return (list.contains(i) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnTwoElementListAddToRearSecondElementValidOne", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListAddToRearSecondElementValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			return (list.contains(j) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnTwoElementListAddToRearSecondElementValidTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListAddToRearSecondElementInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			return (list.contains(new Integer(3)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnTwoElementListAddToRearSecondElementInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnTwoElementListAddToRearSecondElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnTwoElementListAddToRearSecondElement", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnTwoElementListAddToRearSecondElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			return (list.size() == 2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnTwoElementListAddToRearSecondElement", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnTwoElementListAddToRearSecondElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { //should be false
				return true;
			}
			try {
				it.next(); //NoSuchElementException expected
			} catch (NoSuchElementException e) {
				//iterator() returned an Iterator<Integer>,
				//hasNext() returned false,
				//and next() threw a NoSuchElementException
				return true;
			}
			//next() did not throw an exception
			return true;
		} catch (Exception e) {
			//iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnTwoElementListAddToRearSecondElement", e.toString());
			return false;
		}
	}

	/** toString() is difficult to test - would like to confirm that
	 * the default address output has been overridden
	 * @return test success */
	private boolean testToStringOnTwoElementListAddToRearSecondElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length()-1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0)) 
					&& (Character.isDigit(lastChar)
							||
							(lastChar >= 'a' && lastChar <= 'f'))) {
				return false; //looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	////////////////////////////
	//SCENARIO: TESTS ON A TWO ELEMENT LIST REMOVING FIRST ELEMENT TODO
	////////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnTwoElementListRemoveFirstElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			list.addToFront(k);
			if(list.first() != k) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnTwoElementListRemoveFirstElement", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnTwoElementListRemoveFirstElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			list.addToRear(k);
			if(list.last() != k) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnTwoElementListRemoveFirstElement", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListRemoveFirstElementValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			list.addAfter(k, i);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnTwoElementListRemoveFirstElementValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListRemoveFirstElementValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			list.addAfter(k, j);
			if(list.contains(k) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnTwoElementListRemoveFirstElementValidTwo", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAfterOnTwoElementListRemoveFirstElementInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			list.addAfter(new Integer(4), new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnTwoElementListRemoveFirstElementInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnTwoElementListRemoveFirstElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			if(list.removeFirst() != j) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnTwoElementListRemoveFirstElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnTwoElementListRemoveFirstElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			if(list.removeLast() != j) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnTwoElementListRemoveFirstElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}


	/** @return test success */
	private boolean testRemoveElementOnTwoElementListRemoveFirstElementValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			if(list.remove(j) != j) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnTwoElementListRemoveFirstElementValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}
	/** @return test success */
	private boolean testRemoveElementOnTwoElementListRemoveFirstElementInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			list.remove(new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnTwoElementListRemoveFirstElementInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnTwoElementListRemoveFirstElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			if(list.first() != j) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnTwoElementListRemoveFirstElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnTwoElementListRemoveFirstElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			if(list.last() != j) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnTwoElementListRemoveFirstElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListRemoveFirstElementValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			return (list.contains(i) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnTwoElementListRemoveFirstElementValidOne", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListRemoveFirstElementValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			return (list.contains(j) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnTwoElementListRemoveFirstElementValidTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListRemoveFirstElementInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			return (list.contains(new Integer(3)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnTwoElementListRemoveFirstElementInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnTwoElementListRemoveFirstElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnTwoElementListRemoveFirstElement", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnTwoElementListRemoveFirstElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			return (list.size() == 1);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnTwoElementListRemoveFirstElement", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnTwoElementListRemoveFirstElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(i);
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { //should be false
				return true;
			}
			try {
				it.next(); //NoSuchElementException expected
			} catch (NoSuchElementException e) {
				//iterator() returned an Iterator<Integer>,
				//hasNext() returned false,
				//and next() threw a NoSuchElementException
				return true;
			}
			//next() did not throw an exception
			return true;
		} catch (Exception e) {
			//iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnTwoElementListRemoveFirstElement", e.toString());
			return false;
		}
	}

	/** toString() is difficult to test - would like to confirm that
	 * the default address output has been overridden
	 * @return test success */
	private boolean testToStringOnTwoElementListRemoveFirstElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
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
			char lastChar = str.charAt(str.length()-1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0)) 
					&& (Character.isDigit(lastChar)
							||
							(lastChar >= 'a' && lastChar <= 'f'))) {
				return false; //looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	////////////////////////////
	//SCENARIO: TESTS ON A TWO ELEMENT LIST USING REMOVE FIRST TODO
	////////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnTwoElementListRemoveFirst() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			list.addToFront(k);
			if(list.first() != k) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnTwoElementListRemoveFirst", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnTwoElementListRemoveFirst() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			list.addToRear(k);
			if(list.last() != k) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnTwoElementListRemoveFirst", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListRemoveFirstValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			list.addAfter(k, i);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnTwoElementListRemoveFirstValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListRemoveFirstValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			list.addAfter(k, j);
			if(list.contains(k) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnTwoElementListRemoveFirstValidTwo", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAfterOnTwoElementListRemoveFirstInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			list.addAfter(new Integer(4), new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnTwoElementListRemoveFirstInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnTwoElementListRemoveFirst() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			if(list.removeFirst() != j) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnTwoElementListRemoveFirst", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnTwoElementListRemoveFirst() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			if(list.removeLast() != j) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnTwoElementListRemoveFirst", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}


	/** @return test success */
	private boolean testRemoveElementOnTwoElementListRemoveFirstValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			if(list.remove(j) != j) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnTwoElementListRemoveFirstValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}
	/** @return test success */
	private boolean testRemoveElementOnTwoElementListRemoveFirstInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			list.remove(new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnTwoElementListRemoveFirstInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnTwoElementListRemoveFirst() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			if(list.first() != j) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnTwoElementListRemoveFirst", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnTwoElementListRemoveFirst() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			if(list.last() != j) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnTwoElementListRemoveFirst", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListRemoveFirstValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			return (list.contains(i) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnTwoElementListRemoveFirstValidOne", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListRemoveFirstValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			return (list.contains(j) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnTwoElementListRemoveFirstValidTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListRemoveFirstInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			return (list.contains(new Integer(3)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnTwoElementListRemoveFirstInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnTwoElementListRemoveFirst() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnTwoElementListRemoveFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnTwoElementListRemoveFirst() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			return (list.size() == 1);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnTwoElementListRemoveFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnTwoElementListRemoveFirst() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeFirst();
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { //should be false
				return true;
			}
			try {
				it.next(); //NoSuchElementException expected
			} catch (NoSuchElementException e) {
				//iterator() returned an Iterator<Integer>,
				//hasNext() returned false,
				//and next() threw a NoSuchElementException
				return true;
			}
			//next() did not throw an exception
			return true;
		} catch (Exception e) {
			//iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnTwoElementListRemoveFirst", e.toString());
			return false;
		}
	}

	/** toString() is difficult to test - would like to confirm that
	 * the default address output has been overridden
	 * @return test success */
	private boolean testToStringOnTwoElementListRemoveFirst() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
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
			char lastChar = str.charAt(str.length()-1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0)) 
					&& (Character.isDigit(lastChar)
							||
							(lastChar >= 'a' && lastChar <= 'f'))) {
				return false; //looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	////////////////////////////
	//SCENARIO: TESTS ON A TWO ELEMENT LIST USING ADD AFTER FOR SECOND ELEMENT TODO
	////////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnTwoElementListAddAfterSecondElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addToRear(k); 
		try {
			list.addAfter(j, i);
			list.addToFront(l);
			if(list.first() != l) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnTwoElementListAddAfterSecondElement", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnTwoElementListAddAfterSecondElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToRear(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			list.addToRear(l);
			if(list.last() != l) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnTwoElementListAddAfterSecondElement", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListAddAfterSecondElementValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			list.addAfter(l, i);
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnTwoElementListAddAfterSecondElementValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListAddAfterSecondElementValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			list.addAfter(l, j);
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnTwoElementListAddAfterSecondElementValidTwo", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListAddAfterSecondElementValidThree() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			list.addAfter(l, k);
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnTwoElementListAddAfterSecondElementValidThree", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAfterOnTwoElementListAddAfterSecondElementInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
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
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnTwoElementListAddAfterSecondElementInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnTwoElementListAddAfterSecondElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			if(list.removeFirst() != i) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnTwoElementListAddAfterSecondElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnTwoElementListAddAfterSecondElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			if(list.removeLast() != k) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnTwoElementListAddAfterSecondElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnTwoElementListAddAfterSecondElementValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			if(list.remove(i) != i) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnTwoElementListAddAfterSecondElementValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnTwoElementListAddAfterSecondElementValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			if(list.remove(j) != j) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnTwoElementListAddAfterSecondElementValidTwo", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testRemoveElementOnTwoElementListAddAfterSecondElementValidThree() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			if(list.remove(k) != k) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnNewList", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}
	/** @return test success */
	private boolean testRemoveElementOnTwoElementListAddAfterSecondElementInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.addAfter(j, i);
			list.remove(new Integer(4));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnTwoElementListAddAfterSecondElementInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnTwoElementListAddAfterSecondElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			if(list.first() != i) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnTwoElementListAddAfterSecondElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnTwoElementListAddAfterSecondElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			if(list.last() != k) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnTwoElementListAddAfterSecondElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListAddAfterSecondElementValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			return (list.contains(i) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnTwoElementListAddAfterSecondElementValidOne", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListAddAfterSecondElementValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			return (list.contains(j) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnTwoElementListAddAfterSecondElementValidTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListAddAfterSecondElementValidThree() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			return (list.contains(k) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnTwoElementListAddAfterSecondElementValidThree", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListAddAfterSecondElementInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			return (list.contains(new Integer(4)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnTwoElementListAddAfterSecondElementInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnTwoElementListAddAfterSecondElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnTwoElementListAddAfterSecondElement", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnTwoElementListAddAfterSecondElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(k);
		try {
			list.addAfter(j, i);
			return (list.size() == 3);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnTwoElementListAddAfterSecondElement", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnTwoElementListAddAfterSecondElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { //should be false
				return true;
			}
			try {
				it.next(); //NoSuchElementException expected
			} catch (NoSuchElementException e) {
				//iterator() returned an Iterator<Integer>,
				//hasNext() returned false,
				//and next() threw a NoSuchElementException
				return true;
			}
			//next() did not throw an exception
			return true;
		} catch (Exception e) {
			//iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnTwoElementListAddAfterSecondElement", e.toString());
			return false;
		}
	}
	/** toString() is difficult to test - would like to confirm that
	 * the default address output has been overridden
	 * @return test success */
	private boolean testToStringOnTwoElementListAddAfterSecondElement() {
		UnorderedListADT<Integer> list = newList();
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
			char lastChar = str.charAt(str.length()-1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0)) 
					&& (Character.isDigit(lastChar)
							||
							(lastChar >= 'a' && lastChar <= 'f'))) {
				return false; //looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	////////////////////////////
	//SCENARIO: TESTS ON A TWO ELEMENT LIST USING REMOVE ON LAST ELEMENT  TODO
	////////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnTwoElementListRemoveLastElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(j);
			list.addToFront(k);
			if(list.first() != k) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnTwoElementListRemoveLastElement", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnTwoElementListRemoveLastElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(j);
			list.addToRear(k);
			if(list.last() != k) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnTwoElementListRemoveLastElement", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListRemoveLastElementValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(j);
			list.addAfter(k, i);
			if(list.contains(k) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnTwoElementListRemoveLastElementValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListRemoveLastElementValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(j);
			list.addAfter(k, j);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnTwoElementListRemoveLastElementValidTwo", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAfterOnTwoElementListRemoveLastElementInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(j);
			list.addAfter(new Integer(4), new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnTwoElementListRemoveLastElementInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnTwoElementListRemoveLastElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(j);
			if(list.removeFirst() != i) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnTwoElementListRemoveLastElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnTwoElementListRemoveLastElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(j);
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnTwoElementListRemoveLastElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnTwoElementListRemoveLastElementValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(j);
			if(list.remove(i) != i) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnTwoElementListRemoveLastElementValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnTwoElementListRemoveLastElementInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(j);
			list.remove(new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnTwoElementListRemoveLastElementInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnTwoElementListRemoveLastElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(j);
			if(list.first() != i) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnTwoElementListRemoveLastElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnTwoElementListRemoveLastElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(j);
			if(list.last() != i) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnTwoElementListRemoveLastElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListRemoveLastElementValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(j);
			return (list.contains(i) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnTwoElementListRemoveLastElementValidOne", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListRemoveLastElementValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(j);
			return (list.contains(j) ==	false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnTwoElementListRemoveLastElementValidTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListRemoveLastElementInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(j);
			return (list.contains(new Integer(3)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnTwoElementListRemoveLastElementInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnTwoElementListRemoveLastElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(j);
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnTwoElementListRemoveLastElement", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnTwoElementListRemoveLastElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(j);
			return (list.size() == 1);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnTwoElementListRemoveLastElement", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnTwoElementListRemoveLastElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		list.remove(j);
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { //should be false
				return true;
			}
			try {
				it.next(); //NoSuchElementException expected
			} catch (NoSuchElementException e) {
				//iterator() returned an Iterator<Integer>,
				//hasNext() returned false,
				//and next() threw a NoSuchElementException
				return true;
			}
			//next() did not throw an exception
			return true;
		} catch (Exception e) {
			//iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnTwoElementListRemoveLastElement", e.toString());
			return false;
		}
	}

	/** toString() is difficult to test - would like to confirm that
	 * the default address output has been overridden
	 * @return test success */
	private boolean testToStringOnTwoElementListRemoveLastElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
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
			char lastChar = str.charAt(str.length()-1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0)) 
					&& (Character.isDigit(lastChar)
							||
							(lastChar >= 'a' && lastChar <= 'f'))) {
				return false; //looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	////////////////////////////
	//SCENARIO: TESTS ON A TWO ELEMENT LIST USING REMOVE ON LAST ELEMENT  TODO
	////////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnTwoElementListRemoveLast() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeLast();
			list.addToFront(k);
			if(list.first() != k) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnTwoElementListRemoveLast", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnTwoElementListRemoveLast() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeLast();
			list.addToRear(k);
			if(list.last() != k) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnTwoElementListRemoveLast", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListRemoveLastValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeLast();
			list.addAfter(k, i);
			if(list.contains(k) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnTwoElementListRemoveLastValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListRemoveLastValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeLast();
			list.addAfter(k, j);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnTwoElementListRemoveLastValidTwo", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAfterOnTwoElementListRemoveLastInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeLast();
			list.addAfter(new Integer(4), new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnTwoElementListRemoveLastInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnTwoElementListRemoveLast() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeLast();
			if(list.removeFirst() != i) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnTwoElementListRemoveLast", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnTwoElementListRemoveLast() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeLast();
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnTwoElementListRemoveLast", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnTwoElementListRemoveLastValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeLast();
			if(list.remove(i) != i) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnTwoElementListRemoveLastValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnTwoElementListRemoveLastInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeLast();
			list.remove(new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnTwoElementListRemoveLastInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnTwoElementListRemoveLast() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeLast();
			if(list.first() != i) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnTwoElementListRemoveLast", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnTwoElementListRemoveLast() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeLast();
			if(list.last() != i) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnTwoElementListRemoveLast", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListRemoveLastValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeLast();
			return (list.contains(i) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnTwoElementListRemoveLastValidOne", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListRemoveLastValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeLast();
			return (list.contains(j) ==	false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnTwoElementListRemoveLastValidTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnTwoElementListRemoveLastInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeLast();
			return (list.contains(new Integer(3)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnTwoElementListRemoveLastInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnTwoElementListRemoveLast() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeLast();
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnTwoElementListRemoveLast", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnTwoElementListRemoveLast() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.removeLast();
			return (list.size() == 1);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnTwoElementListRemoveLast", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnTwoElementListRemoveLast() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		list.removeLast();
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { //should be false
				return true;
			}
			try {
				it.next(); //NoSuchElementException expected
			} catch (NoSuchElementException e) {
				//iterator() returned an Iterator<Integer>,
				//hasNext() returned false,
				//and next() threw a NoSuchElementException
				return true;
			}
			//next() did not throw an exception
			return true;
		} catch (Exception e) {
			//iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnTwoElementListRemoveLast", e.toString());
			return false;
		}
	}

	/** toString() is difficult to test - would like to confirm that
	 * the default address output has been overridden
	 * @return test success */
	private boolean testToStringOnTwoElementListRemoveLast() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
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
			char lastChar = str.charAt(str.length()-1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0)) 
					&& (Character.isDigit(lastChar)
							||
							(lastChar >= 'a' && lastChar <= 'f'))) {
				return false; //looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}



	////////////////////////////
	//SCENARIO: TESTS ON A THREE ELEMENT LIST USING ADD TO FRONT ON FIRST ELEMENT TODO
	////////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnThreeElementListAddToFrontFirstElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k); 
		try {
			list.addToFront(l);
			if(list.first() != l) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnThreeElementListAddToFrontFirstElement", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnThreeElementListAddToFrontFirstElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addToRear(l);
			if(list.last() != l) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnThreeElementListAddToFrontFirstElement", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddToFrontFirstElementValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, i);
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListAddToFrontFirstElementValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddToFrontFirstElementValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, j);
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListAddToFrontFirstElementValidTwo", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddToFrontFirstElementValidThree() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(4, k);
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListAddToFrontFirstElementValidThree", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAfterOnThreeElementListAddToFrontFirstElementInvalid() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListAddToFrontFirstElementInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnThreeElementListAddToFrontFirstElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if(list.removeFirst() != i) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnThreeElementListAddToFrontFirstElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnThreeElementListAddToFrontFirstElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if(list.removeLast() != k) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnThreeElementListAddToFrontFirstElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddToFrontFirstElementValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if(list.remove(i) != i) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListAddToFrontFirstElementValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddToFrontFirstElementValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if(list.remove(j) != j) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListAddToFrontFirstElementValidTwo", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testRemoveElementOnThreeElementListAddToFrontFirstElementValidThree() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if(list.remove(k) != k) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListAddToFrontFirstElementValidThree", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}
	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddToFrontFirstElementInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(new Integer(4));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListAddToFrontFirstElementInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnThreeElementListAddToFrontFirstElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if(list.first() != i) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnThreeElementListAddToFrontFirstElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnThreeElementListAddToFrontFirstElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if(list.last() != k) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnThreeElementListAddToFrontFirstElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddToFrontFirstElementValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.contains(i) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListAddToFrontFirstElementValidOne", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddToFrontFirstElementValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.contains(j) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListAddToFrontFirstElementValidTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddToFrontFirstElementValidThree() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.contains(k) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListAddToFrontFirstElementValidThree", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddToFrontFirstElementInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.contains(new Integer(4)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListAddToFrontFirstElementInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnThreeElementListAddToFrontFirstElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnNewList", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnThreeElementListAddToFrontFirstElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.size() == 3);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnNewList", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnThreeElementListAddToFrontFirstElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { //should be false
				return true;
			}
			try {
				it.next(); //NoSuchElementException expected
			} catch (NoSuchElementException e) {
				//iterator() returned an Iterator<Integer>,
				//hasNext() returned false,
				//and next() threw a NoSuchElementException
				return true;
			}
			//next() did not throw an exception
			return true;
		} catch (Exception e) {
			//iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnNewList", e.toString());
			return false;
		}
	}

	/** toString() is difficult to test - would like to confirm that
	 * the default address output has been overridden
	 * @return test success */
	private boolean testToStringOnThreeElementListAddToFrontFirstElement() {
		UnorderedListADT<Integer> list = newList();
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
			char lastChar = str.charAt(str.length()-1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0)) 
					&& (Character.isDigit(lastChar)
							||
							(lastChar >= 'a' && lastChar <= 'f'))) {
				return false; //looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	////////////////////////////
	//SCENARIO: TESTS ON A THREE ELEMENT LIST USING ADD AFTER FOR SECOND ELEMENT TODO
	////////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnThreeElementListAddAfterSecondElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k); 
		try {
			list.addToFront(l);
			if(list.first() != l) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnThreeElementListAddAfterSecondElement", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnThreeElementListAddAfterSecondElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToRear(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addToRear(l);
			if(list.last() != l) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnThreeElementListAddAfterSecondElement", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddAfterSecondElementValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, i);
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListAddAfterSecondElementValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddAfterSecondElementValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, j);
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListAddAfterSecondElementValidTwo", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddAfterSecondElementValidThree() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, k);
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListAddAfterSecondElementValidThree", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAfterOnThreeElementListAddAfterSecondElementInvalid() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListAddAfterSecondElementInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnThreeElementListAddAfterSecondElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if(list.removeFirst() != i) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnThreeElementListAddAfterSecondElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnThreeElementListAddAfterSecondElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if(list.removeLast() != k) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnThreeElementListAddAfterSecondElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddAfterSecondElementValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if(list.remove(i) != i) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListAddAfterSecondElementValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddAfterSecondElementValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if(list.remove(j) != j) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListAddAfterSecondElementValidTwo", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testRemoveElementOnThreeElementListAddAfterSecondElementValidThree() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if(list.remove(k) != k) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListAddAfterSecondElementValidThree", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}
	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddAfterSecondElementInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.remove(new Integer(4));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListAddAfterSecondElementInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnThreeElementListAddAfterSecondElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if(list.first() != i) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnThreeElementListAddAfterSecondElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnThreeElementListAddAfterSecondElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if(list.last() != k) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnThreeElementListAddAfterSecondElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterSecondElementValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.contains(i) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListAddAfterSecondElementValidOne", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterSecondElementValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.contains(j) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListAddAfterSecondElementValidTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterSecondElementValidThree() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.contains(k) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListAddAfterSecondElementValidThree", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterSecondElementInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.contains(new Integer(4)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListAddAfterSecondElementInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnThreeElementListAddAfterSecondElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnThreeElementListAddAfterSecondElement", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnThreeElementListAddAfterSecondElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.size() == 3);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnThreeElementListAddAfterSecondElement", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnThreeElementListAddAfterSecondElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { //should be false
				return true;
			}
			try {
				it.next(); //NoSuchElementException expected
			} catch (NoSuchElementException e) {
				//iterator() returned an Iterator<Integer>,
				//hasNext() returned false,
				//and next() threw a NoSuchElementException
				return true;
			}
			//next() did not throw an exception
			return true;
		} catch (Exception e) {
			//iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnThreeElementListAddAfterSecondElement", e.toString());
			return false;
		}
	}

	/** toString() is difficult to test - would like to confirm that
	 * the default address output has been overridden
	 * @return test success */
	private boolean testToStringOnThreeElementListAddAfterSecondElement() {
		UnorderedListADT<Integer> list = newList();
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
			char lastChar = str.charAt(str.length()-1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0)) 
					&& (Character.isDigit(lastChar)
							||
							(lastChar >= 'a' && lastChar <= 'f'))) {
				return false; //looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	////////////////////////////
	//SCENARIO: TESTS ON A THREE ELEMENT LIST USING ADD TO REAR ON THIRD ELEMENT TODO
	////////////////////////////

	/** @return test success */
	private boolean testAddToFrontThreeElementListAddToRearThirdElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k); 
		try {
			list.addToFront(l);
			if(list.first() != l) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontThreeElementListAddToRearThirdElement", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnThreeElementListAddToRearOnThirdElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToRear(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addToRear(l);
			if(list.last() != l) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnThreeElementListAddToRearOnThirdElement", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddToRearThirdElementValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, i);
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListAddToRearThirdElementValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddToRearThirdElementValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, j);
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListAddToRearThirdElementValidTwo", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddToRearThirdElementValidThree() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, k);
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListAddToRearThirdElementValidThree", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAfterOnThreeElementListAddToRearThirdElementInvalid() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListAddToRearThirdElementInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnThreeElementListAddToRearThirdElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if(list.removeFirst() != i) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnThreeElementListAddToRearThirdElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnThreeElementListAddToRearThirdElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if(list.removeLast() != k) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnThreeElementListAddToRearThirdElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddToRearThirdElementValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if(list.remove(i) != i)  return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListAddToRearThirdElementValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddToRearThirdElementValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if(list.remove(j) != j) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListAddToRearThirdElementValidTwo", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testRemoveElementOnThreeElementListAddToRearThirdElementValidThree() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if(list.remove(k) != k) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListAddToRearThirdElementValidThree", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}
	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddToRearThirdElementInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j,  i);
		list.addToRear(k);
		try {
			list.remove(new Integer(4));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListAddToRearThirdElementInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnThreeElementListAddToRearThirdElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if(list.first() != i) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnThreeElementListAddToRearThirdElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnThreeElementListAddToRearThirdElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			if(list.last() != k) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnThreeElementListAddToRearThirdElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddToRearThirdElementValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.contains(i) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListAddToRearThirdElementValidOne", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddToRearThirdElementValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.contains(j) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListAddToRearThirdElementValidTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddToRearThirdElementValidThree() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.contains(k) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListAddToRearThirdElementValidThree", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddToRearThirdElementInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.contains(new Integer(4)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListAddToRearThirdElementInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnThreeElementListAddToRearThirdElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnThreeElementListAddToRearThirdElement", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnThreeElementListAddToRearThirdElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			return (list.size() == 3);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnThreeElementListAddToRearThirdElement", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnThreeElementListAddToRearThirdElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { //should be false
				return true;
			}
			try {
				it.next(); //NoSuchElementException expected
			} catch (NoSuchElementException e) {
				//iterator() returned an Iterator<Integer>,
				//hasNext() returned false,
				//and next() threw a NoSuchElementException
				return true;
			}
			//next() did not throw an exception
			return true;
		} catch (Exception e) {
			//iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnThreeElementListAddToRearThirdElement", e.toString());
			return false;
		}
	}

	/** toString() is difficult to test - would like to confirm that
	 * the default address output has been overridden
	 * @return test success */
	private boolean testToStringOnThreeElementListAddToRearThirdElement() {
		UnorderedListADT<Integer> list = newList();
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
			char lastChar = str.charAt(str.length()-1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0)) 
					&& (Character.isDigit(lastChar)
							||
							(lastChar >= 'a' && lastChar <= 'f'))) {
				return false; //looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	////////////////////////////
	//SCENARIO: TESTS ON A THREE ELEMENT LIST USING ADD AFTER THE FIRST ELEMENT TODO
	////////////////////////////

	/** @return test success */
	private boolean testAddToFrontThreeElementListAddAfterFirst() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.first() != l) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontThreeElementListAddAfterFirst", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnThreeElementListAddAfterFirst() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.last() != l) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnThreeElementListAddAfterFirst", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddAfterFirstValidOne() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListAddAfterFirstValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddAfterFirstValidTwo() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListAddAfterFirstValidTwo", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddAfterFirstValidThree() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListAddAfterFirstValidThree", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}
	
	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddAfterFirstValidFour() {
		UnorderedListADT<Integer> list = newList();
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
			list.addAfter(new Integer(6), m);
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListAddAfterFirstValidFour", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAfterOnThreeElementListAddAfterFirstInvalid() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListAddAfterFirstInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnThreeElementListAddAfterFirst() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, i);
			if(list.removeFirst() != i) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnThreeElementListAddAfterFirst", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnThreeElementListAddAfterFirst() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, i);
			if(list.removeLast() != k) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnThreeElementListAddAfterFirst", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddAfterFirstValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, i);
			if(list.remove(i) != i)  return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListAddAfterFirstValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddAfterFirstValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, i);
			if(list.remove(j) != j) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListAddAfterFirstValidTwo", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testRemoveElementOnThreeElementListAddAfterFirstValidThree() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, i);
			if(list.remove(k) != k) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListAddAfterFirstValidThree", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}
	private boolean testRemoveElementOnThreeElementListAddAfterFirstValidFour() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, i);
			if(list.remove(l) != l) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListAddAfterFirstValidFour", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}
	
	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddAfterFirstInvalid() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListAddAfterFirstInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnThreeElementListAddAfterFirst() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, i);
			if(list.first() != i) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnThreeElementListAddAfterFirst", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnThreeElementListAddAfterFirst() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, i);
			if(list.last() != k) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnThreeElementListAddAfterFirst", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterFirstValidOne() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListAddAfterFirstValidOne", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterFirstValidTwo() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListAddAfterFirstValidTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterFirstValidThree() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListAddAfterFirstValidThree", e.toString());
			return false;
		}
	}
	
	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterFirstValidFour() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListAddAfterFirstValidFour", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterFirstInvalid() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListAddAfterFirstInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnThreeElementListAddAfterFirst() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnThreeElementListAddAfterFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnThreeElementListAddAfterFirst() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l,  i);
			return (list.size() == 4);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnThreeElementListAddAfterFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnThreeElementListAddAfterFirst() {
		UnorderedListADT<Integer> list = newList();
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
			if (it.hasNext() == false) { //should be false
				return true;
			}
			try {
				it.next(); //NoSuchElementException expected
			} catch (NoSuchElementException e) {
				//iterator() returned an Iterator<Integer>,
				//hasNext() returned false,
				//and next() threw a NoSuchElementException
				return true;
			}
			//next() did not throw an exception
			return true;
		} catch (Exception e) {
			//iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnThreeElementListAddAfterFirst", e.toString());
			return false;
		}
	}

	/** toString() is difficult to test - would like to confirm that
	 * the default address output has been overridden
	 * @return test success */
	private boolean testToStringOnThreeElementListAddAfterFirst() {
		UnorderedListADT<Integer> list = newList();
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
			char lastChar = str.charAt(str.length()-1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0)) 
					&& (Character.isDigit(lastChar)
							||
							(lastChar >= 'a' && lastChar <= 'f'))) {
				return false; //looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	////////////////////////////
	//SCENARIO: TESTS ON A THREE ELEMENT LIST USING ADD AFTER THE SECOND ELEMENT TODO
	////////////////////////////

	/** @return test success */
	private boolean testAddToFrontThreeElementListAddAfterSecond() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.first() != l) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontThreeElementListAddAfterSecond", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnThreeElementListAddAfterSecond() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.last() != l) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnThreeElementListAddAfterSecond", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddAfterSecondValidOne() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListAddAfterSecondValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddAfterSecondValidTwo() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListAddAfterSecondValidTwo", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddAfterSecondValidThree() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListAddAfterSecondValidThree", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}
	
	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddAfterSecondValidFour() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListAddAfterSecondValidFour", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAfterOnThreeElementListAddAfterSecondInvalid() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListAddAfterSecondInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnThreeElementListAddAfterSecond() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, j);
			if(list.removeFirst() != i) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnThreeElementListAddAfterSecond", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnThreeElementListAddAfterSecond() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, j);
			if(list.removeLast() != k) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnThreeElementListAddAfterSecond", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddAfterSecondValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, j);
			if(list.remove(i) != i)  return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListAddAfterSecondValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddAfterSecondValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, j);
			if(list.remove(j) != j) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListAddAfterSecondValidTwo", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testRemoveElementOnThreeElementListAddAfterSecondValidThree() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, j);
			if(list.remove(k) != k) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListAddAfterSecondValidThree", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}
	private boolean testRemoveElementOnThreeElementListAddAfterSecondValidFour() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, j);
			if(list.remove(l) != l) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListAddAfterSecondValidFour", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}
	
	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddAfterSecondInvalid() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListAddAfterSecondInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnThreeElementListAddAfterSecond() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, j);
			if(list.first() != i) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnThreeElementListAddAfterSecond", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnThreeElementListAddAfterSecond() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, j);
			if(list.last() != k) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnThreeElementListAddAfterSecond", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterSecondValidOne() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListAddAfterSecondValidOne", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterSecondValidTwo() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListAddAfterSecondValidTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterSecondValidThree() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListAddAfterSecondValidThree", e.toString());
			return false;
		}
	}
	
	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterSecondValidFour() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListAddAfterSecondValidFour", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterSecondInvalid() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListAddAfterSecondInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnThreeElementListAddAfterSecond() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnThreeElementListAddAfterSecond", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnThreeElementListAddAfterSecond() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l,  j);
			return (list.size() == 4);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnThreeElementListAddAfterSecond", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnThreeElementListAddAfterSecond() {
		UnorderedListADT<Integer> list = newList();
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
			if (it.hasNext() == false) { //should be false
				return true;
			}
			try {
				it.next(); //NoSuchElementException expected
			} catch (NoSuchElementException e) {
				//iterator() returned an Iterator<Integer>,
				//hasNext() returned false,
				//and next() threw a NoSuchElementException
				return true;
			}
			//next() did not throw an exception
			return true;
		} catch (Exception e) {
			//iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnThreeElementListAddAfterSecond", e.toString());
			return false;
		}
	}

	/** toString() is difficult to test - would like to confirm that
	 * the default address output has been overridden
	 * @return test success */
	private boolean testToStringOnThreeElementListAddAfterSecond() {
		UnorderedListADT<Integer> list = newList();
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
			char lastChar = str.charAt(str.length()-1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0)) 
					&& (Character.isDigit(lastChar)
							||
							(lastChar >= 'a' && lastChar <= 'f'))) {
				return false; //looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	////////////////////////////
	//SCENARIO: TESTS ON A THREE ELEMENT LIST USING ADD AFTER THE THIRD ELEMENT TODO
	////////////////////////////

	/** @return test success */
	private boolean testAddToFrontThreeElementListAddAfterThird() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.first() != l) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontThreeElementListAddAfterThird", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnThreeElementListAddAfterThird() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.last() != l) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnThreeElementListAddAfterThird", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddAfterThirdValidOne() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListAddAfterThirdValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddAfterThirdValidTwo() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListAddAfterThirdValidTwo", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddAfterThirdValidThree() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListAddAfterThirdValidThree", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}
	
	/** @return test success */
	private boolean testAddAfterOnThreeElementListAddAfterThirdValidFour() {
		UnorderedListADT<Integer> list = newList();
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
			list.addAfter(new Integer(6), m);
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListAddAfterThirdValidFour", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAfterOnThreeElementListAddAfterThirdInvalid() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListAddAfterThirdInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnThreeElementListAddAfterThird() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, k);
			if(list.removeFirst() != i) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnThreeElementListAddAfterThird", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnThreeElementListAddAfterThird() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, k);
			if(list.removeLast() != l) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnThreeElementListAddAfterThird", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddAfterThirdValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, k);
			if(list.remove(i) != i)  return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListAddAfterThirdValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddAfterThirdValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, k);
			if(list.remove(j) != j) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListAddAfterThirdValidTwo", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testRemoveElementOnThreeElementListAddAfterThirdValidThree() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, k);
			if(list.remove(k) != k) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListAddAfterThirdValidThree", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}
	private boolean testRemoveElementOnThreeElementListAddAfterThirdValidFour() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, k);
			if(list.remove(l) != l) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListAddAfterThirdValidFour", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}
	
	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddAfterThirdInvalid() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListAddAfterThirdInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnThreeElementListAddAfterThird() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, k);
			if(list.first() != i) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnThreeElementListAddAfterThird", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnThreeElementListAddAfterThird() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l, k);
			if(list.last() != l) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnThreeElementListAddAfterThird", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterThirdValidOne() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListAddAfterThirdValidOne", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterThirdValidTwo() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListAddAfterThirdValidTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterThirdValidThree() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListAddAfterThirdValidThree", e.toString());
			return false;
		}
	}
	
	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterThirdValidFour() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListAddAfterThirdValidFour", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListAddAfterThirdInvalid() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListAddAfterThirdInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnThreeElementListAddAfterThird() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnThreeElementListAddAfterThird", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnThreeElementListAddAfterThird() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(l,  k);
			return (list.size() == 4);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnThreeElementListAddAfterThird", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnThreeElementListAddAfterThird() {
		UnorderedListADT<Integer> list = newList();
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
			if (it.hasNext() == false) { //should be false
				return true;
			}
			try {
				it.next(); //NoSuchElementException expected
			} catch (NoSuchElementException e) {
				//iterator() returned an Iterator<Integer>,
				//hasNext() returned false,
				//and next() threw a NoSuchElementException
				return true;
			}
			//next() did not throw an exception
			return true;
		} catch (Exception e) {
			//iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnThreeElementListAddAfterThird", e.toString());
			return false;
		}
	}

	/** toString() is difficult to test - would like to confirm that
	 * the default address output has been overridden
	 * @return test success */
	private boolean testToStringOnThreeElementListAddAfterThird() {
		UnorderedListADT<Integer> list = newList();
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
			char lastChar = str.charAt(str.length()-1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0)) 
					&& (Character.isDigit(lastChar)
							||
							(lastChar >= 'a' && lastChar <= 'f'))) {
				return false; //looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	////////////////////////////
	//SCENARIO: TESTS ON A THREE ELEMENT LIST USING REMOVE FIRST TODO
	////////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnThreeElementListRemoveFirst() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.first() != l) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnThreeElementListRemoveFirst", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnThreeElementListRemoveFirst() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.last() != l) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnThreeElementListRemoveFirst", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListRemoveFirstValidOne() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListRemoveFirstValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListRemoveFirstValidTwo() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListRemoveFirstValidTwo", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListRemoveFirstValidThree() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeFirst();
			list.addAfter(new Integer (5), k);
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListRemoveFirstValidThree", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAfterOnThreeElementListRemoveFirstInvalid() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListRemoveFirstInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnThreeElementListRemoveFirst() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeFirst();
			if(list.removeFirst() != j) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnThreeElementListRemoveFirst", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnThreeElementListRemoveFirst() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeFirst();
			if(list.removeLast() != k) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnThreeElementListRemoveFirst", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListRemoveFirstValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeFirst();
			if(list.remove(j) != j) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListRemoveFirstValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListRemoveFirstValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeFirst();
			if(list.remove(k) != k) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListRemoveFirstValidTwo", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}


	/** @return test success */
	private boolean testRemoveElementOnThreeElementListRemoveFirstInvalid() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListRemoveFirstInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnThreeElementListRemoveFirst() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeFirst();
			if(list.first() != j) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnThreeElementListRemoveFirst", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnThreeElementListRemoveFirst() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeFirst();
			if(list.last() != k) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnThreeElementListRemoveFirst", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveFirstValidOne() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListRemoveFirstValidOne", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveFirstValidTwo() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListRemoveFirstValidTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveFirstValidThree() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListRemoveFirstValidThree", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveFirstInvalid() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListRemoveFirstInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnThreeElementListRemoveFirst() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnThreeElementListRemoveFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnThreeElementListRemoveFirst() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testSizeOnThreeElementListRemoveFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnThreeElementListRemoveFirst() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeFirst();
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { //should be false
				return true;
			}
			try {
				it.next(); //NoSuchElementException expected
			} catch (NoSuchElementException e) {
				//iterator() returned an Iterator<Integer>,
				//hasNext() returned false,
				//and next() threw a NoSuchElementException
				return true;
			}
			//next() did not throw an exception
			return true;
		} catch (Exception e) {
			//iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnThreeElementListRemoveFirst", e.toString());
			return false;
		}
	}

	/** toString() is difficult to test - would like to confirm that
	 * the default address output has been overridden
	 * @return test success */
	private boolean testToStringOnThreeElementListRemoveFirst() {
		UnorderedListADT<Integer> list = newList();
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
			char lastChar = str.charAt(str.length()-1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0)) 
					&& (Character.isDigit(lastChar)
							||
							(lastChar >= 'a' && lastChar <= 'f'))) {
				return false; //looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	////////////////////////////
	//SCENARIO: TESTS ON A THREE ELEMENT LIST USING REMOVE FIRST ELEMENT TODO
	////////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnThreeElementListRemoveFirstElement() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.first() != l) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnThreeElementListRemoveFirstElement", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnThreeElementListRemoveFirstElement() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.last() != l) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnThreeElementListRemoveFirstElement", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListRemoveFirstElementValidOne() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListRemoveFirstElementValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListRemoveFirstElementValidTwo() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListRemoveFirstElementValidTwo", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListRemoveFirstElementValidThree() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(i);
			list.addAfter(new Integer (5), k);
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListRemoveFirstElementValidThree", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAfterOnThreeElementListRemoveFirstElementInvalid() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListRemoveFirstElementInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnThreeElementListRemoveFirstElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(i);
			if(list.removeFirst() != j) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnThreeElementListRemoveFirstElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnThreeElementListRemoveFirstElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(i);
			if(list.removeLast() != k) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnThreeElementListRemoveFirstElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListRemoveFirstElementValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(i);
			if(list.remove(j) != j) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListRemoveFirstElementValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListRemoveFirstElementValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(i);
			if(list.remove(k) != k) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListRemoveFirstElementValidTwo", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}


	/** @return test success */
	private boolean testRemoveElementOnThreeElementListRemoveFirstElementInvalid() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListRemoveFirstElementInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnThreeElementListRemoveFirstElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(i);
			if(list.first() != j) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnThreeElementListRemoveFirstElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnThreeElementListRemoveFirstElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(i);
			if(list.last() != k) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnThreeElementListRemoveFirstElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveFirstElementValidOne() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListRemoveFirstElementValidOne", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveFirstElementValidTwo() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListRemoveFirstElementValidTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveFirstElementValidThree() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListRemoveFirstElementValidThree", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveFirstElementInvalid() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListRemoveFirstElementInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnThreeElementListRemoveFirstElement() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnThreeElementListRemoveFirstElement", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnThreeElementListRemoveFirstElement() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testSizeOnThreeElementListRemoveFirstElement", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnThreeElementListRemoveFirstElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(i);
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { //should be false
				return true;
			}
			try {
				it.next(); //NoSuchElementException expected
			} catch (NoSuchElementException e) {
				//iterator() returned an Iterator<Integer>,
				//hasNext() returned false,
				//and next() threw a NoSuchElementException
				return true;
			}
			//next() did not throw an exception
			return true;
		} catch (Exception e) {
			//iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnThreeElementListRemoveFirstElement", e.toString());
			return false;
		}
	}

	/** toString() is difficult to test - would like to confirm that
	 * the default address output has been overridden
	 * @return test success */
	private boolean testToStringOnThreeElementListRemoveFirstElement() {
		UnorderedListADT<Integer> list = newList();
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
			char lastChar = str.charAt(str.length()-1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0)) 
					&& (Character.isDigit(lastChar)
							||
							(lastChar >= 'a' && lastChar <= 'f'))) {
				return false; //looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	////////////////////////////
	//SCENARIO: TESTS ON A THREE ELEMENT LIST USING REMOVE SECOND ELEMENT TODO
	////////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnThreeElementListRemoveSecondElement() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.first() != l) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnThreeElementListRemoveSecondElement", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnThreeElementListRemoveSecondElement() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.last() != l) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnThreeElementListRemoveSecondElement", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListRemoveSecondElementValidOne() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListRemoveSecondElementValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListRemoveSecondElementValidTwo() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListRemoveSecondElementValidTwo", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListRemoveSecondElementValidThree() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(j);
			list.addAfter(new Integer (5), k);
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListRemoveSecondElementValidThree", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAfterOnThreeElementListRemoveSecondElementInvalid() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListRemoveSecondElementInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnThreeElementListRemoveSecondElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(j);
			if(list.removeFirst() != i) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnThreeElementListRemoveSecondElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnThreeElementListRemoveSecondElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(j);
			if(list.removeLast() != k) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnThreeElementListRemoveSecondElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListRemoveSecondElementValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(j);
			if(list.remove(i) != i) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListRemoveSecondElementValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListRemoveSecondElementValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(j);
			if(list.remove(k) != k) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListRemoveSecondElementValidTwo", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}


	/** @return test success */
	private boolean testRemoveElementOnThreeElementListRemoveSecondElementInvalid() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListRemoveSecondElementInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnThreeElementListRemoveSecondElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(j);
			if(list.first() != i) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnThreeElementListRemoveSecondElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnThreeElementListRemoveSecondElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(j);
			if(list.last() != k) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnThreeElementListRemoveSecondElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveSecondElementValidOne() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListRemoveSecondElementValidOne", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveSecondElementValidTwo() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListRemoveSecondElementValidTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveSecondElementValidThree() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListRemoveSecondElementValidThree", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveSecondElementInvalid() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListRemoveSecondElementInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnThreeElementListRemoveSecondElement() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnThreeElementListRemoveSecondElement", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnThreeElementListRemoveSecondElement() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testSizeOnThreeElementListRemoveSecondElement", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnThreeElementListRemoveSecondElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(j);
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { //should be false
				return true;
			}
			try {
				it.next(); //NoSuchElementException expected
			} catch (NoSuchElementException e) {
				//iterator() returned an Iterator<Integer>,
				//hasNext() returned false,
				//and next() threw a NoSuchElementException
				return true;
			}
			//next() did not throw an exception
			return true;
		} catch (Exception e) {
			//iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnThreeElementListRemoveSecondElement", e.toString());
			return false;
		}
	}

	/** toString() is difficult to test - would like to confirm that
	 * the default address output has been overridden
	 * @return test success */
	private boolean testToStringOnThreeElementListRemoveSecondElement() {
		UnorderedListADT<Integer> list = newList();
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
			char lastChar = str.charAt(str.length()-1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0)) 
					&& (Character.isDigit(lastChar)
							||
							(lastChar >= 'a' && lastChar <= 'f'))) {
				return false; //looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	////////////////////////////
	//SCENARIO: TESTS ON A THREE ELEMENT LIST USING REMOVE THIRD ELEMENT TODO
	////////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnThreeElementListRemoveThirdElement() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.first() != l) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnThreeElementListRemoveThirdElement", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnThreeElementListRemoveThirdElement() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.last() != l) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnThreeElementListRemoveThirdElement", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListRemoveThirdElementValidOne() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListRemoveThirdElementValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListRemoveThirdElementValidTwo() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListRemoveThirdElementValidTwo", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListRemoveThirdElementValidThree() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(k);
			list.addAfter(new Integer (5), j);
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListRemoveThirdElementValidThree", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAfterOnThreeElementListRemoveThirdElementInvalid() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListRemoveThirdElementInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnThreeElementListRemoveThirdElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(k);
			if(list.removeFirst() != i) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnThreeElementListRemoveThirdElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnThreeElementListRemoveThirdElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(k);
			if(list.removeLast() != j) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnThreeElementListRemoveThirdElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListRemoveThirdElementValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(k);
			if(list.remove(i) != i) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListRemoveThirdElementValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListRemoveThirdElementValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(k);
			if(list.remove(j) != j) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListRemoveThirdElementValidTwo", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}


	/** @return test success */
	private boolean testRemoveElementOnThreeElementListRemoveThirdElementInvalid() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListRemoveThirdElementInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnThreeElementListRemoveThirdElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(k);
			if(list.first() != i) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnThreeElementListRemoveThirdElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnThreeElementListRemoveThirdElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(k);
			if(list.last() != j) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnThreeElementListRemoveThirdElement", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveThirdElementValidOne() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListRemoveThirdElementValidOne", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveThirdElementValidTwo() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListRemoveThirdElementValidTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveThirdElementValidThree() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(k);
			return (list.contains(k) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListRemoveThirdElementValidThree", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveThirdElementInvalid() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListRemoveThirdElementInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnThreeElementListRemoveThirdElement() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnThreeElementListRemoveThirdElement", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnThreeElementListRemoveThirdElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(k);;
			return (list.size() == 2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnThreeElementListRemoveThirdElement", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnThreeElementListRemoveThirdElement() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.remove(k);
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { //should be false
				return true;
			}
			try {
				it.next(); //NoSuchElementException expected
			} catch (NoSuchElementException e) {
				//iterator() returned an Iterator<Integer>,
				//hasNext() returned false,
				//and next() threw a NoSuchElementException
				return true;
			}
			//next() did not throw an exception
			return true;
		} catch (Exception e) {
			//iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnThreeElementListRemoveThirdElement", e.toString());
			return false;
		}
	}

	/** toString() is difficult to test - would like to confirm that
	 * the default address output has been overridden
	 * @return test success */
	private boolean testToStringOnThreeElementListRemoveThirdElement() {
		UnorderedListADT<Integer> list = newList();
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
			char lastChar = str.charAt(str.length()-1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0)) 
					&& (Character.isDigit(lastChar)
							||
							(lastChar >= 'a' && lastChar <= 'f'))) {
				return false; //looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	////////////////////////////
	//SCENARIO: TESTS ON A THREE ELEMENT LIST USING REMOVE LAST TODO
	////////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnThreeElementListRemoveLast() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.first() != l) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnThreeElementListRemoveLast", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnThreeElementListRemoveLast() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.last() != l) return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnThreeElementListRemoveLast", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListRemoveLastValidOne() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListRemoveLastValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListRemoveLastValidTwo() {
		UnorderedListADT<Integer> list = newList();
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
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListRemoveLastValidTwo", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnThreeElementListRemoveLastValidThree() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeLast();
			list.addAfter(new Integer (5), j);
			if(list.contains(l) == true) return true;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListRemoveLastValidThree", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAfterOnThreeElementListRemoveLastInvalid() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnThreeElementListRemoveLastInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnThreeElementListRemoveLast() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeLast();
			if(list.removeFirst() != i) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnThreeElementListRemoveLast", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnThreeElementListRemoveLast() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeLast();
			if(list.removeLast() != j) return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnThreeElementListRemoveLast", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListRemoveLastValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeLast();
			if(list.remove(i) != i) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListRemoveLastValidOne", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveElementOnThreeElementListRemoveLastValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeLast();
			if(list.remove(j) != j) return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListRemoveLastValidTwo", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}


	/** @return test success */
	private boolean testRemoveElementOnThreeElementListRemoveLastInvalid() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnThreeElementListRemoveLastInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnThreeElementListRemoveLast() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeLast();
			if(list.first() != i) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnThreeElementListRemoveLast", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testLastOnThreeElementListRemoveLast() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeLast();
			if(list.last() != j) return false; 
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnThreeElementListRemoveLast", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveLastValidOne() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListRemoveLastValidOne", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveLastValidTwo() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListRemoveLastValidTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveLastValidThree() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListRemoveLastValidThree", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnThreeElementListRemoveLastInvalid() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnThreeElementListRemoveLastInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnThreeElementListRemoveLast() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeLast();
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnThreeElementListRemoveLast", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnThreeElementListRemoveLast() {
		UnorderedListADT<Integer> list = newList();
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
			System.out.printf("%s caught unexpected %s\n", "testSizeOnThreeElementListRemoveLast", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnThreeElementListRemoveLast() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeLast();
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == false) { //should be false
				return true;
			}
			try {
				it.next(); //NoSuchElementException expected
			} catch (NoSuchElementException e) {
				//iterator() returned an Iterator<Integer>,
				//hasNext() returned false,
				//and next() threw a NoSuchElementException
				return true;
			}
			//next() did not throw an exception
			return true;
		} catch (Exception e) {
			//iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnThreeElementListRemoveLast", e.toString());
			return false;
		}
	}

	/** toString() is difficult to test - would like to confirm that
	 * the default address output has been overridden
	 * @return test success */
	private boolean testToStringOnThreeElementListRemoveLast() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.removeLast();;
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length()-1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0)) 
					&& (Character.isDigit(lastChar)
							||
							(lastChar >= 'a' && lastChar <= 'f'))) {
				return false; //looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	////////////////////////////////
	//INDEXED LIST TESTS
	///////////////////////////////
	
	//TEST ON A NEW, EMPTY LIST USING ADD(A) TODO
	/** @return test success */
	private boolean testAddOnNewList() {
		IndexedListADT<Integer> list = newList1();
		Integer i = new Integer(1);
		try {
			list.add(i);
			if(list.indexOf(i) == 0) return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnNewList", e.toString());
			return false;
		}
		return true;
	}

	
	//TEST ON A NEW EMPTY LIST USING ADD(0,A)TODO
	/** @return test success */
	private boolean testAddUsingIndexOnNewList() {
		IndexedListADT<Integer> list = newList1();
		Integer i = new Integer(1);
		try {
			list.add(0,i);
			if(list.indexOf(i) == 0) return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddUsingIndexOnNewList", e.toString());
			return false;
		}
		return true;
	}
	

	
	//TEST ON AN ONE ELEMENT LIST USING SET(0,B) TODO
	/** @return test success*/
	private boolean testSetOnOneElementList() {
		IndexedListADT<Integer> list = newList1();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.add(i);
		try {
			list.set(0,j);
			if(list.indexOf(j) == 0) return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSetOnOneElementList", e.toString());
			return false;
		}
		return true;
	}

	
	//TEST ON AN ONE ELEMENT LIST USING ADD(0,B)TODO
	/** @return test success*/
	private boolean testAddOnOneElementListOne() {
		IndexedListADT<Integer> list = newList1();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.add(i);
		try {
			list.add(0,j);
			if(list.indexOf(j) == 0 && list.indexOf(i) == 1) return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddOnOneElementListOne", e.toString());
			return false;
		}
		return true;
	}
	
	//TEST ON AN ONE ELEMENT LIST USING ADD(1,B) TODO
	/** @return test success*/
	private boolean testAddOnOneElementListTwo() {
		IndexedListADT<Integer> list = newList1();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.add(i);
		try {
			list.add(1,j);
			if(list.indexOf(j) == 1 && list.indexOf(i) == 0) return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddOnOneElementListTwo", e.toString());
			return false;
		}
		return true;
	}
	

	
	//TEST ON A TWO ELEMENT LIST USING SET(0,C) TODO
	/** @return test success*/
	private boolean testSetOnTwoElementListOne() {
		IndexedListADT<Integer> list = newList1();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(i);
		list.add(1,j);
		try {
			list.set(0, k);
			if(list.indexOf(k) == 0  && list.indexOf(j) == 1) return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSetOnTwoElementListOne", e.toString());
			return false;
		}
		return true;
	}
	
	//TEST ON A TWO ELEMENT LIST USING SET(1,C) TODO
	/** @return test success*/
	private boolean testSetOnTwoElementListTwo() {
		IndexedListADT<Integer> list = newList1();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);

		list.add(1,j);
		try {
			list.set(1, k);
			if(list.indexOf(k) == 1  && list.indexOf(i) == 0) return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSetOnTwoElementListTwo", e.toString());
			return false;
		}
		return true;
	}
	
	//TEST ON A TWO ELEMENT LIST USING ADD(C) TODO
	/** @return test success*/
	private boolean testAddOnTwoElementListOne() {
		IndexedListADT<Integer> list = newList1();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(i);
		list.add(1,j);
		try {
			list.add(k);
			if(list.indexOf(k) == 2 && list.indexOf(i) == 0 && list.indexOf(j) ==1) return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddOnTwoElementListOne", e.toString());
			return false;
		}
		return true;
	}
	
	//TEST ON A TWO ELEMENT LIST USING ADD(0,C) TODO
	/** @return test success*/
	private boolean testAddOnTwoElementListTwo() {
		IndexedListADT<Integer> list = newList1();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(i);
		list.add(1,j);
		try {
			list.add(1,k);
			if(list.indexOf(k) == 0 && list.indexOf(i) == 1 && list.indexOf(j) ==2) return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddOnTwoElementListTwo", e.toString());
			return false;
		}
		return true;
	}
	
	//TEST ON A TWO ELEMENT LIST USING ADD(1,C) TODO
	/** @return test success*/
	private boolean testAddOnTwoElementListThree() {
		IndexedListADT<Integer> list = newList1();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(i);
		list.add(1,j);
		try {
			list.add(1,k);
			if(list.indexOf(k) == 1 && list.indexOf(i) == 0 && list.indexOf(j) ==2) return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddOnTwoElementListThree", e.toString());
			return false;
		}
		return true;
	}
	
	//TEST ON A TWO ELEMENT LIST USING ADD(2, C) TODO
	/** @return test success*/
	private boolean testAddOnTwoElementListFour() {
		IndexedListADT<Integer> list = newList1();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(i);
		list.add(1,j);
		try {
			list.add(2,k);
			if(list.indexOf(k) == 2 && list.indexOf(i) == 0 && list.indexOf(j) ==1) return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddOnTwoElementListFour", e.toString());
			return false;
		}
		return true;
	}
	
	//TEST ON A THREE ELEMENT LIST USING REMOVE(0) TODO
	/** @return test success*/
	private boolean testRemoveOnThreeElementListOne() {
		IndexedListADT<Integer> list = newList1();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(i);
		list.add(1,j);
		list.add(2,k);
		try {
			list.remove(0);
			if(list.indexOf(j) == 0 && list.indexOf(k) == 1) return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveOnThreeElementListOne", e.toString());
			return false;
		}
		return true;
	}
	
	//TEST ON A THREE ELEMENT LIST USING REMOVE(1) TODO
	/** @return test success*/
	private boolean testRemoveOnThreeElementListTwo() {
		IndexedListADT<Integer> list = newList1();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(i);
		list.add(1,j);
		list.add(2,k);
		try {
			list.remove(1);
			if(list.indexOf(i) == 0 && list.indexOf(k) == 1) return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveOnThreeElementListTwo", e.toString());
			return false;
		}
		return true;
	}
	
	
	//TEST ON A THREE ELEMENT LIST USING REMOVE(2) TODO
	/** @return test success*/
	private boolean testRemoveOnThreeElementListThree() {
		IndexedListADT<Integer> list = newList1();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		list.add(i);
		list.add(1,j);
		list.add(2,k);
		try {
			list.remove(2);
			if(list.indexOf(i) == 0 && list.indexOf(j) == 1) return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveOnThreeElementListThree", e.toString());
			return false;
		}
		return true;
	}
	
	//TEST ON A THREE ELEMENT LIST USING SET(0,D) TODO
	/** @return test success*/
	private boolean testSetOnThreeElementListOne() {
		IndexedListADT<Integer> list = newList1();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.add(i);
		list.add(1,j);
		list.add(2,k);
		try {
			list.set(0,l);
			if(list.indexOf(l) == 0 && list.indexOf(j) == 1 && list.indexOf(k) == 2) return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSetOnThreeElementListOne", e.toString());
			return false;
		}
		return true;
	}
	
	
	//TEST ON A THREE ELEMENT LIST USING SET(1,D) TODO
	/** @return test success*/
	private boolean testSetOnThreeElementListTwo() {
		IndexedListADT<Integer> list = newList1();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.add(i);
		list.add(1,j);
		list.add(2,k);
		try {
			list.set(1,l);
			if(list.indexOf(l) == 1 && list.indexOf(i) == 0 && list.indexOf(k) == 2) return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSetOnThreeElementListTwo", e.toString());
			return false;
		}
		return true;
	}
	

	//TEST ON A THREE ELEMENT LIS USING SET(2,D) TODO
	/** @return test success*/
	private boolean testSetOnThreeElementListThree() {
		IndexedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		Integer k = new Integer(3);
		Integer l = new Integer(4);
		list.add(i);
		list.add(j);
		list.add(k);
		try {
			list.set(2,l);
			if(list.indexOf(l) == 2 && list.indexOf(i) == 0 && list.indexOf(j) == 1) return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSetOnThreeElementListThree", e.toString());
			return false;
		}
		return true;
	}
	
	
	////////////////////////////////////
	//LINKED LIST TESTS
	/////////////////////////////////////
	
	//TEST ADD TO FRONT ON NEW, EMPTY LINKED LIST
	/** @return test success*/
	private boolean testAddToFrontOnEmptyLList() {
		SingleLinkedList<Integer> list = newList1();
		Integer i = new Integer(1);
		try {
			list.addToFront(i);
			if(list.size() == 1) return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnEmptyLList", e.toString());
			return false;
		}
		return true;
	}
	
	//TEST ADD TO REAR ON EMPTY LINKED LIST
	/** @return test success*/
	private boolean testAddToRearOnEmptyLList() {
		SingleLinkedList<Integer> list = newList1();
		Integer i = new Integer(2);
		try {
			list.addToRear(i);
			if(list.size() == 1) return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnEmptyLList", e.toString());
			return false;
		}
		return true;
	}
	
	//TEST ADD AFTER ON A ONE ELEMENT LIST
	/** @return test success*/
	private boolean testAddAfterOnOneElementLList() {
		SingleLinkedList<Integer> list = newList1();
		Integer i = new Integer(2);
		try {
			list.addAfter(i, 1);
			if(list.size() == 1) return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddAfterOneElementLList", e.toString());
			return false;
		}
		return true;
	}
	
	//TEST FIRST ON NEW LINKED LIST
	/** @return test success*/
	private boolean testFirstOnNewLList() {
		SingleLinkedList<Integer> list = newList();
		try{
			list.first();
		}catch (EmptyCollectionException e){
			return true;
		}catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnEmptyLList", e.toString());
			return false;
		}
		return true;
	}
	
	//TEST FIRST ON ONE ELEMENT LIST
	/**@return test success*/
	private boolean testFirstOnOneElementLList(){
		SingleLinkedList<Integer> list = newList1();
		try{
			if(list.first() != 1) return false;
		}catch (EmptyCollectionException e){
			return true;
		}catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnEmptyLList", e.toString());
			return false;
		}
		return true;
	}
	
	//TEST SIZE ON EMPTY LLIST
	/** @return test succes*/
	private boolean testSizeOnEmptyLList(){
		SingleLinkedList<Integer> list = newList();
		try{
			if(list.size() != 0) return false;
		}catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnEmptyLList", e.toString());
			return false;
		}
		return true;
	}
	
	//TEST SIZE ON ONE ELEMENT LLIST
	/**@return test succes*/
	private boolean testSizeOnOneElementLList(){
		SingleLinkedList<Integer> list = newList1();
		try{
			if(list.size() != 1) return false;
		}catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnOneElementLList", e.toString());
			return false;
		}
		return true;
	}
	
	//TEST IS EMPTY ON EMPTY LIST
	/**@return test success*/
	private boolean testIsEmptyOnEmptyLList(){
		SingleLinkedList<Integer> list = newList();
		try{
			if(list.isEmpty() != true) return false;
		}catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnEmptyLList", e.toString());
			return false;
		}
		return true;
	}
	
	//TEST IS EMPTY ON ONE ELEMENT LIST
	/**@return test success*/
	private boolean testIsEmptyOnOneElementLList(){
		SingleLinkedList<Integer> list = newList1();
		try{
			if(list.isEmpty() != false) return false;
		}catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnOneElementLList", e.toString());
			return false;
		}
		return true;
	}

}//end class ListTester 