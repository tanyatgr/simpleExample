package simple;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class MaxLineLength {

	public static void main(String[] args) {

		// read from file
		int[] onesAndzeros = new int[100];
		try (BufferedReader buffer = new BufferedReader(
				new InputStreamReader(new FileInputStream("input.txt"), Charset.forName("UTF-8")))) {
			int c;
			int inc = 0;
			while ((c = buffer.read()) != -1 || inc < 100) {
				onesAndzeros[inc] = Character.getNumericValue((char) c);
				inc++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// find length
		int maxlength = 0;
		int currentCounter = 0;
		for (int i = 0; i < onesAndzeros.length; i++) {
			if (onesAndzeros[i] == 1) {
				currentCounter += 1;
			}
			if (onesAndzeros[i] == 0) {
				if (currentCounter > maxlength) {
					maxlength = currentCounter;

				}
				currentCounter = 0;
			}
		}

		// write in file
		try {
			File file = new File("output.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(String.valueOf(maxlength));
			bw.close();
			System.out.println("Done.");

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
