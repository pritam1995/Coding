import java.util.*;
import java.util.stream.IntStream;

public class SiblingSearch {

	public static int[] findSiblings(int input1, int[] input2, int input3) {
		int[] result = new int[] {-1};
		if (input2[0] == input3) {
			return result;
		}
	   int pos=0;
	   for(int i=0 ; i < input2.length ; i++){
	   if(input2[i] == input3){
	   pos = i +1;
		}
		}
	  int start = Integer.highestOneBit(pos);
	 int end = start*2 -1 >= input2.length ? input2.length: start*2 -1;
	 return IntStream.range((start - 1), end).map(i -> input2[i]).filter(v -> v!=input3).toArray();
	 }

    public static void main(String[] args) {
        int input1 = 5;
        int[] input2 = {1,2, 3, 4, 5, 6};
        int input3 = 5;

		int[] result = findSiblings(input1, input2, input3);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}


    }
}
