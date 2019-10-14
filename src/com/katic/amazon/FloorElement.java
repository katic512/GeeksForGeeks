package com.katic.amazon;

import java.util.Scanner;

public class FloorElement {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t > 0) {
			t--;
			int size = in.nextInt();
			int element = in.nextInt();
			int arr[] = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = in.nextInt();
			}

			if (element < arr[0]) {
				System.out.println(-1);
			} else if (element >= arr[size - 1]) {
				System.out.println(size - 1);
			} else {
				int startIndex = 0;
				int endIndex = size;
				while (true) {
					int mid = (startIndex + endIndex) / 2;
					if (element == arr[mid]) {
						System.out.println(mid);
						break;
					} else if (element > arr[mid]) {
						if (element < arr[mid + 1]) {
							System.out.println(mid);
							break;
						} else {
							startIndex = mid;
						}
					} else {
						endIndex = mid;
					}
				}
			}
		}
	}
}
