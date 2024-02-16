package com.pract;

import java.util.Arrays;

public class BitManipulation {

	// int to binary
	public static int[] intToBinary(int n) {
		int binary[] = new int[32], j = binary.length - 1;

		while (n != 0) {
			int r = n % 2;
			n /= 2;
			binary[j--] = r;
		}
//		int binarySort[] = new int[binary.length-j],i=0;
//		while(j<binary.length) {
//			binarySort[i++]=binary[j++];
//		}
		return binary;
	}

	// convert the binary to negative

	// apply 2's compliment
	// step 1 - Invert the binary 1->0 AND 0->1
	// step 2 - add one hints = 1+1=0,carry=1,1+1+1=1,carry=1

	public static int[] convertToNegative(int arr[]) {

		// invert the binary
		for (int i = 0; i < arr.length; i++)
			if (arr[i] == 1)
				arr[i] = 0;
			else
				arr[i] = 1;

		// add one to binary
		int carry = 1;
		for (int i = arr.length - 1; i >= 0; i--) {
			int val = arr[i] + carry;
			carry = 0;
			if (val == 2) {
				arr[i] = 0;
				carry = 1;
			} else
				arr[i] = val;
		}

		return arr;

	}

	// pow of num
	public static int pow(int num, int pow) {
		int result = 1;
		for (int i = 1; i <= pow; i++) {
			result *= num;
		}
		return result;
	}

	// binary to int
	public static int binaryToInt(int arr[]) {
		int num = 0, j = 0;
		for (int i = arr.length - 1; i >= 0; i--, j++) {
			if (arr[i] == 1)
				num += pow(2, j);
		}
		return num;
	}

	// add two number by bit manipulation (adding bitwise)
	public static int addInBinary(int n1, int n2) {
		int binary1[] = intToBinary(n1);
		int binary2[] = intToBinary(n2);
		int carry = 0;

		for (int i = binary1.length - 1; i >= 0; i--) {
			int val = binary1[i] + binary2[i] + carry;
			carry = 0;

			switch (val) {
			case 1:
				binary2[i] = val;
				break;
			case 2:
				binary2[i] = 0;
				carry = 1;
				break;
			case 3:
				binary2[i] = 1;
				carry = 1;
			}
		}

		return binaryToInt(binary2);

	}

	// add two binary by bit manipulation (adding bitwise)
	public static int addInBinary(int num[], int num2[]) {
		int carry = 0;
		for (int i = num.length - 1; i >= 0; i--) {
			int val = num[i] + num2[i] + carry;
			carry = 0;

			switch (val) {
			case 1:
				num2[i] = val; // 1+0 = 1
				break;
			case 2:
				num2[i] = 0; // 1+1 = 10 (in binary)
				carry = 1;
				break;
			case 3:
				num2[i] = 1; // 1+1+1 = 011 (in binary)
				carry = 1;
			}
		}

		return binaryToInt(num2);

	}

	// substract two numbers by bit manipulation (subtracting bitwise)
	public static int subtractBitWise(int n1, int n2) {
		int binary1[] = intToBinary(n1);
		int binary2[] = intToBinary(n2);

		binary2 = convertToNegative(binary2);

		return addInBinary(binary1, binary2);
	}

	public static void main(String[] args) {

//		System.out.println(Arrays.toString(intToBinary(4)));
//	System.out.println(convertToNegative(new int[] {1,0,1,0}));
//		System.out.println(pow(2, 2));
//		System.out.println(binaryToInt(new int[] { 1, 0, 1 }));
//		System.out.println(addInBinary(3, 4));
//		System.out.println(addInBinary(binaryToInt(new int[] { 1, 0, 1, 0 }), binaryToInt(new int[] { 1, 0, 1, 0 })));
//		System.out.println(subtractBitWise(19, 11));
//		System.out.println(Arrays.toString(convertToNegative(intToBinary(-10))));
	}
}
