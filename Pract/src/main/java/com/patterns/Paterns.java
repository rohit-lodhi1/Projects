package com.patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Paterns {

	public static void test(int a) {
		System.out.println(a);
	}

	public static void main(String[] args) {
		// starwithThree(11);
		// starwithTwo(5);
		// diamond(10);
		// diamondWithTwo(20);
//		EDCBA(6);
//		random4(5);
		// diamondWithPract(10);
		// random5(7);

		// random6(5);
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		// System.out.println(list.stream().max(Integer::compare).get());
//		System.out.println(list.stream().max(Comparator.naturalOrder()).get());
//		System.out.println(list.stream().mapToInt(v -> v).max());

//		random18(5);
		// starwithTwo(5);
		pattern17(10);
	}

	public static void pattern17(int n) {
		for (int i = 1; i < n * 2; i++) {
			for (int j = 1; j < n + i; j++) {
				if (i <=n)
					if (j == n - i+1 || j == n + i-1)
						System.out.print(i);
					else
						System.out.print(" ");

				else {
				//	System.out.println("sdfsd  "+((n*2-1)-i));
					if(j==i-n+1 || j==(n*2-1)+n-i)
						System.out.print(n*2-i);
					else
						System.out.print(" ");
				}

			}
			System.out.println();
		}
	}

	public static void pattern16(int n) {
		int k = 1, val = 1;

		for (int i = 1; i <= n; i++) {
			val = 1;
			for (int j = 1; j <= n + i - 1; j++) {
				if (j <= n - i)
					System.out.print(" ");
				else {
					System.out.print(val);
					if (j < n)
						val++;
					else
						val--;
				}
			}
			k += 2;
			System.out.println();
		}
	}

	public static void pattern15(int n) {
		int val = 1;
		for (int i = 1; i <= n; i++) {
			val = i;
			for (int j = 1; j <= i; j++) {
				System.out.print(val);
				val += n - j;
			}
			System.out.println();
		}
	}

	public static void pattern14(int n) {
		for (int i = 0; i < n; i++) {
			boolean star = true;
			for (int j = 0; j < n * (n / 2 + 1) + n / 2; j++) {
				// System.out.print(n*(n/2));
				// System.out.println(j> (n*n/2)-i && j<(n*n/2)+i);
				if (j >= (n * (n / 2)) - i - 2 && j < (n * (n / 2)) + i && !star) {
					System.out.print(i + 1);
					star = true;
				} else {
					star = false;
					System.out.print("*");

				}

			}
			System.out.println();
		}

	}

	public static void pattern13(int n) {
		int k = 1, val = 1;

		for (int i = 1; i <= n; i++) {
			val = i;
			for (int j = 0; j < k; j++) {

				System.out.print((char) (64 + val));
				if (j < k / 2)
					val--;
				else
					val++;
			}
			k += 2;
			System.out.println();
		}
	}

	public static void pattern12(int n) {
		int k = 1, val = 1;

		for (int i = 0; i < n; i++) {
			val = 1;
			for (int j = 0; j < k; j++) {
				System.out.print(val++);
			}
			k += 2;
			System.out.println();
		}
	}

	public static void pattern11(int n) {
		int st = 1, end = n * (n / 2 + 1);
		boolean isFirstLine = false;
		for (int i = 0; i < n; i++) {
			isFirstLine = !isFirstLine;
			for (int j = 0; j < n - i; j++) {
				if (isFirstLine)
					System.out.print(st++);
				else
					System.out.print(end--);
			}
			System.out.println();
		}
	}

	public static void pattern10(int n) {
		int val = 1, k = 1, modif = 1;
		for (int i = 0; i < n; i++) {

			val = 0;
			modif = 1;
			for (int j = 0; j < k; j++) {
				val = val + modif;
				System.out.print(val);
				modif += 2;
			}
			k += 2;
			System.out.println();
		}

	}

	public static void pattern9(int n) {
		boolean isStart = false;
		int k = 0;
		for (int i = 0; i <= n; i++) {
			isStart = !isStart;
			if (i % 2 == 0)
				k++;
			for (int j = 0; j < k; j++) {
				if (isStart)
					System.out.print("#");
				else
					System.out.print("@");
			}
			System.out.println();
		}
	}

	public static void pattern8(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				System.out.print(j + 1);

			}
			System.out.println();
		}
	}

	public static void pattern7(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(i);
			}
			System.out.println();
		}
	}

	public static void pattern6(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(j + 1);
			}
			System.out.println();
		}
	}

	public static void pattern5(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(i);
			}
			System.out.println();
		}
	}

	public static void pattern4(int n) {
		for (int i = 5; i > 0; i--) {
			for (int j = 0; j < n; j++) {
				System.out.print(i);
			}
			System.out.println();
		}
	}

	public static void pattern3(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 5; j > 0; j--) {
				System.out.print(j);
			}
			System.out.println();
		}
	}

	public static void pattern2(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("#");
			}
			System.out.println();
		}
	}

	public static void pattern1(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i; j++) { // j=i+1 ;j<=n;
				System.out.print("#");
			}
			System.out.println();
		}
	}

	public static void kajuKatli(int n) {
		int k = 1, l = 1;
		for (int i = 0; i < n * 2 - 1; i++) {

			for (int j = 0; j < n * 2; j++) {
				if (i < n) {
					if (j < n - i - 1) {
						System.out.print(" ");
					} else if (k-- > 0)
						System.out.print("*");
				} else {
					if (j < i - n + 1)
						System.out.print(" ");
					else if (k-- > 0)
						System.out.print("*");
				}

			}
			System.out.println();
			if (i < n - 1)
				l += 2;
			else
				l -= 2;
			k = l;
		}
	}

	public static void diagonalLine(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i + j == n - 1 || i == j)
					System.out.print("*");
				else
					System.out.print(" ");

			}
			System.out.println();
		}
	}

	public static void random18(int n) {

		for (int i = 0; i < n * 2; i++) {
			for (int j = 0; j <= n + i; j++) {
				if (i <= n) {
					if (j == n - i || j == n + i)
						System.out.print("*");
					else
						System.out.print(" ");
				} else {
					if (j == i - n || j == i + n)
						System.out.print("*");
					else
						System.out.print(" ");

				}

			}
			System.out.println();
		}
	}

	public static void random17(int n) {

		for (int i = 1; i <= n * 2; i++) {
			for (int j = 1; j <= n; j++) {
				if (i <= n) {
					if (j <= n - i)
						System.out.print(" ");
					else
						System.out.print("* ");
				} else {
					if (j <= i - n - 1)
						System.out.print(" ");
					else
						System.out.print("* ");
				}

			}
			System.out.println();
		}
	}

	public static void random16(int n) {
		boolean star = true;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n * 3 + 2; j++) {
				if (j > n * 2 - i - 1 && j < n * 2 + i && star) {
					star = false;
					System.out.print(i);
				} else {
					star = true;
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

	public static void random15(int n) {
		int k = 1;
		for (int i = 1; i <= n; i++) {
			k = 1;
			for (int j = 1; j < n + i; j++) {
				if (j <= n - i)
					System.out.print(" ");
				else
					System.out.print(j >= n ? k : k++);
				if (j >= n)
					k--;
			}
			System.out.println();
		}
	}

	public static void random14(int n) {
		int k = -1, m = 65;
		for (int i = 1; i <= n; i++) {
			k += 2;
			m = 65;
			for (int j = 1; j <= k; j++) {

				System.out.print((char) (j > k / 2 ? m : m++));
				if (j > k / 2)
					m--;

			}
			System.out.println();
		}

	}

	public static void random13(int n) {
		int k = 1;
		for (int i = 0; i < n; i++) {
			k = i + 1;
			for (int j = 0; j < n; j++) {

				if (i == 0 || j == 0 || j == n - i - 1)
					System.out.print(k);
				else
					System.out.print(" ");
				k++;
			}
			System.out.println();
		}

	}

	public static void random12(int n) {
		int k = 1;
		for (int i = 0; i < n; i++) {
			k = 1;
			for (int j = 0; j < n + i; j++) {
				if (j == n - i - 1 && i != n - 1 || j == n + i - 1 && i != n - 1)
					System.out.print(k);
				else
					System.out.print(" ");
				if (i == n - 1 && j < n)
					System.out.print(k++);
				if (j >= n - 1)
					k++;

			}
			System.out.println();
		}
	}

	public static void random11(int n) {
		int k = 1;
		for (int i = 1; i <= n; i++) {
			k = i;
			for (int j = 1; j <= n + i; j++) {
				if (j <= n - i + 1)
					System.out.print(" ");
				else
					System.out.print((j > n ? k : k++));

				if (j > n)
					k--;

			}

			System.out.println();
		}
	}

	public static void random10(int n) {
		for (int i = 0; i < n; i++) {

			for (int j = 1; j <= i + 1; j++) {
				if (j == i + 1 && i != n - 1 || j == 1 && i != n - 1)
					System.out.print(j);
				else if (i != n - 1)
					System.out.print(" ");
				if (i == n - 1)
					System.out.print(j);

			}
			System.out.println();
		}
	}

	public static void random9(int n) {
		for (int i = 0; i <= n; i++) {

			for (int j = 0; j < n * 2; j++) {
				if (j == n - i && i != n || j == n + i)
					System.out.print("*");
				else if (i != n)
					System.out.print(" ");
				if (i == n && j <= n)
					System.out.print("* ");
			}
			System.out.println();
		}
	}

	public static void random8(int n) {
		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {
				if (j < n - i - 1)
					System.out.print(" ");
				else
					System.out.print("* ");
			}
			System.out.println();
		}
	}

	public static void random7(int n) {
		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {
				if (j < i)
					System.out.print(" ");
				else
					System.out.print("* ");
			}
			System.out.println();
		}
	}

	public static void random6(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0 || j == n - i - 1)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}

	private static void diamondPract(int size) {
		int i, j;
		for (i = 0; i < size; i++) {

			for (j = 0; j <= size; j++) {

				System.out.print(j < size - i ? " " : "* ");

			}
			System.out.println();
		}
		for (i = 1; i <= size; i++) {
			for (j = size; j >= 0; j--) {
				System.out.print(j > size - i ? " " : "* ");
			}
			System.out.println();
		}

	}

	private static void diamondWithPract(int size) {

		for (int i = 0; i < size * 2 - 1; i++) {

			for (int j = 0; j < size; j++) {

				if (i < size)
					if (j < size - i - 1)
						System.out.print(" ");
					else
						System.out.print(" *");

				if (i >= size)
					if (j > i - size)
						System.out.print(" *");
					else
						System.out.print(" ");
			}
			System.out.println();
		}

	}

	// <-----Star----->
	public static void star() {
		int a = 0;
		char ar[] = { 'I', 'N', 'D', 'I', 'A', 'L' };
		int size = ar.length;
		for (int i = 0; i < size * 2 - 1; i++) {
			a = i;
			if (i >= size)
				a = size * 2 - i - 2;
			for (int j = 0; j <= a; j++)
				System.out.print(ar[j]);

			System.out.println();
		}
	}

	public static void star(int size) {

		for (int i = 0; i < size; i++) {

			for (int k = 0; k < size - i; k++)
				System.out.print(" ");

			for (int j = 0; j <= i; j++)
				System.out.print("* ");

			System.out.println();
		}
		for (int i = size; i >= 0; i--) {

			for (int k = size - i; k > 0; k--)
				System.out.print(" ");

			for (int j = i; j >= 0; j--)
				System.out.print("* ");

			System.out.println();
		}
	}

	public static void starwithThree(int size) {
		int a, l;
		for (int i = 0; i <= size * 2; i++) {
			a = size - i;
			if (i > size - 1)
				a = i - size;
			for (int k = 0; k < a; k++)
				System.out.print(" ");

			l = i;
			if (i > size - 1)
				l = size * 2 - i;
			for (int j = 0; j <= l; j++)
				System.out.print("* ");
			System.out.println();
		}
	}

	public static void starwithTwo(int size) {
		int a = 0, l;
		for (int i = 0; i < size; i++) {
			a = 0;

			for (int j = 0; j < size; j++) {

				if (a++ < size - i - 1) {
					System.out.print(" ");
				} else
					System.out.print("* ");

			}
			System.out.println();
		}
	}

	public static void diamond(int size) {
		int a = 0, l, i, j;
		for (i = 0; i < size; i++) {
			a = 0;

			for (j = 0; j < size; j++) {

				if (a++ < size - i - 1)
					System.out.print(" ");
				else
					System.out.print("* ");

			}
			System.out.println();
		}

		for (i = 0; i < size; i++) {
			a = size;

			for (j = 0; j < size; j++) {

				if (a-- > size - i - 1)
					System.out.print(" ");
				else
					System.out.print("* ");
			}
			System.out.println();
		}
	}

	public static void diamondWithTwo(int size) {
		int a = 0, l;
		for (int i = 0; i < size * 2; i++) {
			a = 0;
			l = size;
			for (int j = 0; j < size; j++) {

				if (i < size)
					if (a++ < size - i - 1)
						System.out.print(" ");
					else
						System.out.print("* ");

				if (i >= size)
					if (l-- > size * 2 - i - 1)
						System.out.print(" ");
					else
						System.out.print("* ");
			}

			System.out.println();
		}
	}

	public static void EDCBA(int size) {

		for (int i = 0; i < size; i++) {
			int ch = 64 + size;
			for (int j = 0; j < size - i; j++) {
				System.out.printf("%c ", ch);
				ch--;
			}
			System.out.println();
		}
	}

	public static void random(int size) {
		int c = 1;
		for (int i = 0; i < size * 2; i++) {
			c = i;
			if (i >= size)
				c = i - size;
			for (int j = 0; i < size ? j < size - c : j <= c; j++) {
				System.out.print(j + 1 + " ");
			}
			System.out.println();
		}
	}

	public static void random1(int size) {
		int c;
		for (int i = 0; i < size * 2; i++) {
			c = i;

			int ch = i <= size ? 64 + size - i : 65;
			if (i >= size) {
				c = i - size;
				ch = 64 + i - size + 1;
			}
			for (int j = 0; i < size ? j < size - c : j <= c; j++) {

				System.out.printf("%c ", ch);
				ch--;

			}
			System.out.println();
		}
	}

	public static void random2(int size) {
		int k = 0, c = -3;
		for (int i = 0; i < size * 2 - 1; i++) {
			System.out.print("* ");
			c += 2;
			k = 0;
			if (i >= size)
				c -= 4;

			for (int j = 0; j < c; j++) {
				System.out.print((j <= c / 2 ? ++k : --k) + " ");
			}
			System.out.println(c < 0 ? "" : "* ");
		}
	}

	public static void random3(int size) {
		for (int i = 0; i < size; i++) {

			for (int j = 0; j < size; j++) {
				if (i == 0 || j == size - 1 || i == j)
					System.out.print("*");
				else
					System.out.print(" ");

			}
			System.out.println();
		}

	}

	public static void random4(int size) {
		int k = 5;
		for (int i = 0; i < size; i++) {

			k = 1;
			for (int j = 0; j < size; j++) {

				System.out.print(j < size - i - 1 ? " " : (char) (k++ + 64));

			}
			System.out.println();
		}
	}

	public static void random5(int size) {
		int k = 0;
		for (int i = 0; i < size; i++) {

			for (int j = 0; j < size + size / 2; j++) {
				if (j == size / 2 + 1 - k || j == size / 2 + 1 + k) {
					System.out.print("*");
				} else if (i == size - 1 && j < size - 1)
					System.out.print("* ");
				else
					System.out.print(" ");

			}
			k++;
			System.out.println();
		}
	}

}
