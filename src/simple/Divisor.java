package simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Divisor {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number : ");
		int n = scanner.nextInt();
		if (n <= 0) {
			throw new IllegalArgumentException("Argument shoud be greater then 0.");
		}
		for (int i : findFactors(n)) {
			System.out.printf("  %d  ", i);
		}
	}

	private static List<Integer> findFactors(int number) {
		List<Integer> result = new ArrayList<>();
		int increment = 1;
		if (number % 2 != 0) {
			// skip checking even numbers
			increment = 2;
		}
		for (int i = 1; i <= number / 2; i += increment) {
			if (number % i == 0) {
				result.add(i);
			}
		}
		result.add(number);
		return result;

	}

}
