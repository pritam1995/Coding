import java.util.Arrays;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        // Given
        // String original = "Little Lamb, I'll tell thee,";
        Scanner sc = new Scanner(System.in);
        String original = sc.nextLine();
        
        int number_of_operations = sc.nextInt();
        sc.nextLine();

        int[][] intervals = new int[number_of_operations][2];
        for (int i = 0; i < number_of_operations; i++) {
        String s[] = sc.nextLine().split(" ");
        intervals[i][0] = Integer.parseInt(s[0]);
        intervals[i][1] = Integer.parseInt(s[1]);
        }

        sc.close();

        // Prepare Input
        char[] original_string_array = original.toCharArray();

        int length_of_input = original.length();

        for (int i = 0; i < number_of_operations; i++) {
            for (int j = 0; j < 2; j++) {
                intervals[i][j] = perform_modulo(intervals[i][j], length_of_input);
            }
        }

        for (int i = 0; i < number_of_operations; i++) {
            Arrays.sort(intervals[i]);
            int start_index = intervals[i][0];
            int stop_index = intervals[i][1] - 1;

            while (start_index < stop_index) {
                char temp = original_string_array[start_index];
                original_string_array[start_index] = original_string_array[stop_index];
                original_string_array[stop_index] = temp;
                start_index++;
                stop_index--;
            }
        }

        String finalString = String.valueOf(original_string_array);
        System.out.println(finalString);
    }

    public static int perform_modulo(int dividend, int divisor) {
        return (((dividend % divisor) + divisor) % divisor);
    }
}