package mainApp;

import java.util.ArrayList;
import java.util.List;

public class TestClass {

	
	// 3 & 5 worked ...
	public static void main(String args[]) {
		/*
		 * List<Integer> entryItems = new ArrayList(); // entryItems.add(9); //
		 * entryItems.add(5); // entryItems.add(3);
		 * 
		 * entryItems.add(8); entryItems.add(5); entryItems.add(2);
		 * 
		 * int input = 19;
		 * 
		 * int calculated = 0; for (int i = 0; i <= entryItems.size() - 1; i++) { if
		 * (input >= entryItems.get(i)) { // Now divide input by each array item int
		 * divideQuotient = input / entryItems.get(i); int divideReminder = input %
		 * entryItems.get(i);
		 * 
		 * System.out.println( input + " divided by " + entryItems.get(i) +
		 * " and the quotient  is " + divideQuotient); System.out.println( input +
		 * " divided by " + entryItems.get(i) + " and the reminder  is " +
		 * divideReminder);
		 * 
		 * // Scenario -- where first item gets matched. if (entryItems.get(i) *
		 * divideQuotient == input) { System.out.println("Matched ... ");
		 * System.out.println(entryItems.get(i) + " * " + divideQuotient); break; }
		 * 
		 * if (checkIfNextItemPresent(entryItems, i + 1)) {
		 * 
		 * if (entryItems.get(i + 1) > divideReminder) { // skip doing this division
		 * continue; } else { int count = entryItems.get(i) * divideQuotient;
		 * System.out.println(entryItems.get(i) + " * " + divideQuotient); calculated =
		 * entryItems.get(i) * divideQuotient; input = input - calculated; } } else {
		 * 
		 * if (divideReminder == 0) { System.out.println(entryItems.get(i) + " * " +
		 * divideQuotient); } } } }
		 */
		
		String s1 = "3 * 4";
		String s4[] = s1.split("\\*");
		System.out.println(s4[0]);
				
	
	}

	private static boolean checkIfNextItemPresent(List<Integer> entryItems, int i) {
		if (i <= entryItems.size() - 1) {
			return true;
		}
		return false;
	}
}
