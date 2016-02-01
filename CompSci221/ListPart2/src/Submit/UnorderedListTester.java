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
 * @author mvail: testing framework and empty list scenario
 */
public class UnorderedListTester {
	private int passes = 0;
	private int failures = 0;
	private int total = 0;

	/** @param args not used */
	public static void main(String[] args) {
		//to avoid every method being static
		UnorderedListTester tester = new UnorderedListTester();
		tester.runTests();
	}

	/**
	 * Returns an UnorderedListADT so the implementation can be changed
	 * in this one location rather than in every test.
	 * @return a new UnorderedListADT
	 */
	private UnorderedListADT<Integer> newList() {
		//TODO: enable only one of the two following
		// lines or add a new implementation to test
		return new GoodUnorderedList<Integer>();
		//	return new BadUnorderedList<Integer>();
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


		/////////////////
		//final verdict
		/////////////////
		printFinalSummary();
	}

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
		UnorderedListADT<Integer> list = newList();
		try {
			return (list.contains(new Integer(3)) == false);
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
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnNewList", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnOneElementListAddToFrontValid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		try {
			list.addAfter(new Integer(2), i);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnNewList", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAfterOnOneElementListAddToFrontInvalid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		try {
			list.addAfter(new Integer(2), new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnNewList", "EmptyCollectionException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnNewList", "EmptyCollectionException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnNewList", "EmptyCollectionException", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnNewList", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnNewList", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnNewList", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testSizeOnNewList", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnNewList", e.toString());
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
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnNewList", e.toString());
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
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnNewList", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnOneElementListAddToRearValid() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToRear(i);
		try {
			list.addAfter(new Integer(2), i);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnNewList", "EmptyCollectionException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnNewList", "EmptyCollectionException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnNewList", "EmptyCollectionException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testLastOnNewList", "EmptyCollectionException", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnNewList", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnNewList", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnNewList", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testSizeOnNewList", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnNewList", e.toString());
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
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnNewList", e.toString());
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
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnNewList", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListAddToFrontFirstElementValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.addAfter(new Integer(3), i);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnNewList", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}
	
	/** @return test success */
	private boolean testAddAfterOnTwoElementListAddToFrontFirstElementValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.addAfter(new Integer(3), j);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnNewList", "EmptyCollectionException", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveLastOnTwoElementListAddToFrontFirstElement() {
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnNewList", "EmptyCollectionException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnNewList", "EmptyCollectionException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testLastOnNewList", "EmptyCollectionException", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnNewList", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnNewList", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnNewList", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnNewList", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testSizeOnNewList", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnNewList", e.toString());
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
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnNewList", e.toString());
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
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnNewList", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnTwoElementListAddToRearSecondElementValidOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.addAfter(new Integer(3), i);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnNewList", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}
	
	/** @return test success */
	private boolean testAddAfterOnTwoElementListAddToRearSecondElementValidTwo() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		list.addToFront(i);
		list.addToRear(j);
		try {
			list.addAfter(new Integer(3), j);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnNewList", "EmptyCollectionException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnNewList", "EmptyCollectionException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnNewList", "EmptyCollectionException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testLastOnNewList", "EmptyCollectionException", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnNewList", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnNewList", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnNewList", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnNewList", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testSizeOnNewList", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnNewList", e.toString());
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
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnNewList", e.toString());
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
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnNewList", e.toString());
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
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(new Integer(4), i);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnNewList", "ElementNotFoundException", e.toString());
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
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(new Integer(4), j);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnNewList", "ElementNotFoundException", e.toString());
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
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(new Integer(4), k);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnNewList", "EmptyCollectionException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnNewList", "EmptyCollectionException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnNewList", "EmptyCollectionException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testLastOnNewList", "EmptyCollectionException", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnNewList", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnNewList", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnNewList", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnNewList", e.toString());
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
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnNewList", e.toString());
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
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnNewList", e.toString());
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
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(new Integer(4), i);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnNewList", "ElementNotFoundException", e.toString());
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
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(new Integer(4), j);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnNewList", "ElementNotFoundException", e.toString());
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
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(new Integer(4), k);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnNewList", "EmptyCollectionException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnNewList", "EmptyCollectionException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnNewList", "EmptyCollectionException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testLastOnNewList", "EmptyCollectionException", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnNewList", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnNewList", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnNewList", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnNewList", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnNewList", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testSizeOnNewList", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnNewList", e.toString());
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
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnNewList", e.toString());
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
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnNewList", e.toString());
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
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(new Integer(4), i);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnNewList", "ElementNotFoundException", e.toString());
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
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(new Integer(4), j);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnNewList", "ElementNotFoundException", e.toString());
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
		list.addToFront(i);
		list.addAfter(j, i);
		list.addToRear(k);
		try {
			list.addAfter(new Integer(4), k);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnNewList", "EmptyCollectionException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnNewList", "EmptyCollectionException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnNewList", "ElementNotFoundException", e.toString());
			return false;
		}
		return true;
	}
	/** @return test success */
	private boolean testRemoveElementOnThreeElementListAddToRearThirdElementInvalid() {
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
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnNewList", "ElementNotFoundException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnNewList", "EmptyCollectionException", e.toString());
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
			System.out.printf("%s expected %s, caught %s\n", "testLastOnNewList", "EmptyCollectionException", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnNewList", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnNewList", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnNewList", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testContainsOnNewList", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnNewList", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testSizeOnNewList", e.toString());
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
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnNewList", e.toString());
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
}//end class UnorderedListTester