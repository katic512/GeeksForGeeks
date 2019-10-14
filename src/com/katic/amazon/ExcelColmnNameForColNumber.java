package com.katic.amazon;

import java.util.Scanner;

public class ExcelColmnNameForColNumber {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t > 0) {
			t--;
			long n = in.nextLong();
			String result = "";
			while (n > 0) {
				long reminder = n % 26;
				long quotient = n / 26;
				if (reminder == 0) {
					result = "Z" + result;
					quotient--;
				} else {
					char c = (char) (reminder + 64);
					result = c + result;
				}

				if (quotient > 0 && quotient <= 26) {
					char c = (char) (quotient + 64);
					result = c + result;
					break;
				}
				n =quotient;
			}
			System.out.println(result);
		}
	}
}
