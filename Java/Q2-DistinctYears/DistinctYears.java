import java.util.HashSet;
import java.util.Set;

// Java Program to find the total
// number of distinct years
public class DistinctYears {

// function to find the total
// number of distinct years
	static int distinct_year(String input1) {
		String str2 = "";

		Set<String> uniqueDates = new HashSet<>();

		for (int i = 0; i < input1.length(); i++) {

			if (Character.isDigit(input1.charAt(i))) {
				str2 += (input1.charAt(i));
			}

			// if we found - then clear the str2
			if (input1.charAt(i) == '-') {
				str2 = "";
			}

			// if length of str2 becomes 4
			// then store it in a set
			if (str2.length() == 4) {
				uniqueDates.add(str2);
				str2 = "";
			}
		}

		// return the size of set
        int totalUniqueDates = uniqueDates.size();
		return totalUniqueDates;
	}

// Driver code
	static public void main(String[] args) {
		String str = "UN was established on 02-09-1947. India got freedom on 20-10-1945.";

		System.out.println(distinct_year(str));
	}
}
