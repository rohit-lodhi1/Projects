package com.pract;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.dataStructure.linklist.LinkList;
import com.dataStructure.linklist.Node;

public class Recursions {

	public static void main(String[] args) {

		// System.out.println(power(2,3));
		LinkList list = new LinkList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		// reverseLinkList(list);
// 	 System.out.println(list);  
//	 	  list.start=reverseLinkList4(null,list.start);

		// System.out.println(list);

		// System.out.println(fibonacciOfNthTerm(5));
		// System.out.println( countNoOfWaysToReachNthStairs(45));
//	 	 System.out.println(powTrial(2, 2));
		// System.out.println(factorialTrail(5));
		// convertNumToWords(8765);

		// System.out.println( isSorted(new int[]{2},0,1));
		// System.out.println( arraySum(new int[] {},0));
//  System.out.println(linearSearch(new int[] {1,2,3,4},0,9));
		// int arr[] = new int[] { 2,3,4,5 };
		// System.out.println(binarySearch(arr, 0, arr.length-1, 5));
		// sqrt(25,1);

		// System.out.println(Arrays.toString(mergeSort(arr,0,arr.length-1)));;
//		System.out.println(searchInRotatedArray(arr, 3, 7));
//		System.out.println((int)sqrt(2147395599,0,2147395599,0));
		// System.out.println(sqrt(2147395599));
//binarySearching(arr, 0, arr.length-1, 13);
		// System.out.println(System.currentTimeMillis());
//System.out.println(Arrays.toString(firstAndLastIndexOfElement(arr,12)));
///System.out.println(System.currentTimeMillis());
		// System.out.println(sqrtMorePrecise(37,3));
		// System.out.println((double)2/(10*(0+1)));

		// System.out.println(searchingInRotatedArray(arr, 2, 8));;

		// System.out.println(Arrays.toString(firstAndLastOccurRecursion(arr, 3)));

//	System.out.println(frequencyCountOfElement(arr,0));;
//		System.out.println(findLargest(arr,0,Integer.MIN_VALUE));
		// System.out.println(peakMountain(arr));
//		System.out.println(getPivot(arr));

//		System.out.println(System.currentTimeMillis());
//		System.out.println("abcde".equals(reverse("abcde")));
//		System.out.println(System.currentTimeMillis());
//		System.out.println(isPolindrom("abcde", 0, 2));
//		System.out.println(System.currentTimeMillis());

//		System.out.println(powerOptimized(3,11 ));
//		System.out.println(sqrtMorePrecise(101,3));
		// System.out.println(Arrays.toString(bubbleSort(new int[]
		// {9,7,8,6,4,5,2,3,1,0},0,0)));
		// System.out.println(Arrays.toString(selectionSort(new int[]
		// {0,2,4,6,8,9,1,3,5,7,9},0,1,0)));

		// System.out.println(Arrays.toString(selectionSorts(new int[]
		// {9,8,7,6,5,4,3,2}, 0, 1, 0)));

		// insertionSort(new int[] {9,7,6,10,11,15,1,2,0});
		// System.out.println(Arrays.toString(insertionSort( new int []
		// {9,8,7,6,5,4},1,0,9)));
//		insertionSort(new int[] {9,7,8,6,10,11,15});
//		int arr[] = { 9, 7, 8, 6, 10, 11, 15 };
//		quickSort(arr, 0, 4);
		// System.out.println(Arrays.toString(arr));
//		List<List<Integer>> array = new ArrayList<>();
//		List<Integer> sub = new ArrayList<>();
//		array = subSequence(new Integer[] { 1, 2, 3 }, sub, 0, array);
//		array.stream().forEach(f -> {
//			System.out.println(f);
//		});

//		System.err.println(array);
//		List<String> ar = new ArrayList<>();
//		subSequenceString("abc", "", 0, ar).sort(new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				return o1.length() > o2.length() ? 1 : -1;
//			}
//		});
		// System.out.println(slowestKeys(new int[] { 10, 20, 21, 22, 23, 33, 43, 45,
		// 46, 47, 57, 67 }, "aeodzyabcdxk"));

//		System.out.println(combinations("abc"));
//    System.out.println(combinations("abcd").size());
//		List<List<Integer>> subsequencesArray = subsequencesArray(new int[] {1, 2,3}, new ArrayList<>(), 0,new ArrayList<>());
//		System.out.println(subsequencesArray.stream().sorted(new Comparator<List<Integer>>() {
//
//			@Override
//			public int compare(List<Integer> o1, List<Integer> o2) {
//				
//				return o1.size()-o2.size();
//			}
//			
//		}).collect(Collectors.toList())); 
//		String mapping[]= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
//		System.out.println(keypadProblem("36","", 0,mapping , new ArrayList<>()));
		System.out.println(isSubSequence("axc","ahbgdc"));
	}
	
	public static boolean isSubSequence(String s,String t) {
		int count[] = new int[26];
		for(int i=0;i<s.length();i++) {
		  count[s.charAt(i)-'a']++;
		}
		
		for(int i=0;i<t.length();i++)
			count[t.charAt(i)-'a']--;
		
		for(int i=0;i<count.length;i++)
			if(count[i]>0)
				return false;
		
		return true;
	}

	public static List<String> keypadProblem(String input, String output, int index, String mapping[],
			List<String> ans) {
        // base case
		if (index == input.length()) {
			ans.add(output);
			return ans;
		}
		
		// get the letters of key
		String letters = mapping[input.charAt(index)-'0'];
		for(int i=0;i<letters.length();i++) {
			output+=letters.charAt(i);
			keypadProblem(input, output, index+1, mapping, ans);
			output=output.substring(0, output.length()-1);
		}
		return ans;

	}

	static List<Integer[]> list = new ArrayList<>();

	public static List<List<Integer>> subsequencesArray(int arr[], List<Integer> sub, int i, List<List<Integer>> list) {
		if (i == arr.length) {
			list.add(sub);
			return list;
		}
		// not include
		subsequencesArray(arr, sub, i + 1, list);

		// include sub
		List<Integer> newSub = new ArrayList<>(sub);
		// copy values
		newSub.add(arr[i]);
		subsequencesArray(arr, newSub, i + 1, list);
		return list;
	}

	public static Set<String> combinations(String s) {
		Set<String> list = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			String join = s.substring(0, i);
			String join2 = s.substring(i + 1);
			System.out.println(join + " " + join2);
			String[] permutationCombination = permutationCombination(s, join + join2, i);
			for (String st : permutationCombination) {
				list.add(st + ch);
				list.add(ch + st);
			}
			System.out.println("list  ====> " + list);
		}

		return list;
	}

	public static String[] permutationCombination(String s, String join, int index) {
		System.out.println(join + " " + index);
		if (join.length() <= 0)
			return new String[] { join };

		char ch = join.charAt(0);
		String a = join.substring(0, 1);
		String b = join.substring(1);
		String arr[] = permutationCombination(s, a + b, index);
		String newArray[] = new String[arr.length * 2];
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			newArray[j++] = arr[i] + ch;
			newArray[j++] = ch + arr[i];
		}
		System.out.println(Arrays.toString(newArray));
		return newArray;
	}

	public static char slowestKeys(int[] releaseTime, String s) {
		Map<Character, Integer> map = new LinkedHashMap<>();
		map.put(s.charAt(0), releaseTime[0]);
		for (int i = 1; i < s.length(); i++) {
			int time = releaseTime[i] - releaseTime[i - 1];
			Integer check = map.get(s.charAt(i));
			if (check != null) {
				if (check.intValue() <= time)
					map.put(s.charAt(i), time);
			} else
				map.put(s.charAt(i), time);
		}
		int max = map.get(s.charAt(0));
		char ch = s.charAt(0);
		for (Entry<Character, Integer> entry : map.entrySet())
			if (entry.getValue() > max) {
				max = entry.getValue();
				ch = entry.getKey();
			}
		return ch;
	}

	public static int segments(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++)
			if (s.charAt(i) == ' ' && i != s.length() && s.charAt(i + 1) != ' ')
				count++;
		return count + 1;
	}

	public static List<String> subSequenceString(String s, String sub, int i, List<String> list) {
		if (i == s.length()) {
			list.add(sub);
			return list;
		}
		// exclude
		subSequenceString(s, sub, i + 1, list);

		// include
		sub = sub + s.charAt(i);
		subSequenceString(s, sub, i + 1, list);
		return list;
	}

	public static List<List<Integer>> subSequence(Integer arr[], List<Integer> sub, int i, List<List<Integer>> list) {

		if (i == arr.length)
			list.add(sub);

		if (i == arr.length)
			return list;

		// exclude
		subSequence(arr, sub, i + 1, list);

		// include
		List<Integer> sub2 = new ArrayList<>(sub);

		sub2.add(arr[i]);
		subSequence(arr, sub2, i + 1, list);
		return list;
	}

// -------------------- Sorting ------------------

	public static int partition(int arr[], int st, int end) {
		int pivot = arr[st];
		int count = 0, i = st;
		while (i <= end)
			if (arr[i++] < pivot)
				count++;

		int pivotIndex = st + count, j = end;
		int t = arr[st];
		arr[st] = arr[pivotIndex];
		arr[pivotIndex] = t;
		i = st;
		while (i < pivotIndex && j > pivotIndex) {
			while (arr[i] <= pivot)
				i++;
			while (arr[j] > pivot)
				j--;
			if (i < pivotIndex && j > pivotIndex) {
				int k = arr[i];
				arr[i] = arr[j];
				arr[j] = k;
				System.out.println(pivotIndex);
			}
		}
		return pivotIndex;
	}

	// quick sort
	public static void quickSort(int arr[], int st, int end) {
		if (st >= end)
			return;
		int pivotIndex = partition(arr, st, end);

		// for left part
		quickSort(arr, st, pivotIndex - 1);

		// for right part
		quickSort(arr, pivotIndex + 1, end);
	}

	public static int[] insertionSort(int arr[], int i, int j, int value) {
		if (i == arr.length)
			return arr;
		if (j >= 0) {
			if (arr[j] > value) {
				arr[j + 1] = arr[j];
			} else if (i + 1 < arr.length)
				return insertionSort(arr, i + 1, i, arr[i + 1]);

			return insertionSort(arr, i, j - 1, value);
		}
		arr[j + 1] = value;
		if (i + 1 < arr.length)
			return insertionSort(arr, i + 1, i, arr[i + 1]);
		else
			return arr;
	}

//              Insertion Sort  ( O(n) )        

	public static int[] insertionSort(int arr[]) {
		int j = 0;
		System.out.println(Arrays.toString(arr));
		for (int i = 1; i < arr.length; i++) {
			int k = arr[i];
			for (j = i - 1; j >= 0; j--) {
				System.out.println("j -" + arr[j] + "  i -" + arr[i]);
				if (arr[j] > k)
					arr[j + 1] = arr[j];
				else {

					break;
				}

			}
			System.out.println(Arrays.toString(arr));
			arr[j + 1] = k;
		}

		System.out.println(Arrays.toString(arr));
		return null;
	}

	public static int[] selectionSorts(int arr[], int i, int j, int min) {

		if (i == arr.length)
			return arr;
		if (j < arr.length) {
			if (arr[min] > arr[j])
				min = j;
			return selectionSorts(arr, i, j + 1, min);
		}
		int k = arr[min];
		arr[min] = arr[i];
		arr[i] = k;

		return selectionSorts(arr, i + 1, i + 2, i + 1);
	}

//                Selection Sort  ( O(n) )

	public static int[] selectionSort(int arr[], int i, int j, int min) {
		// System.out.println("i -"+i+" j -"+j+" min = "+arr[min]+" min -"+min);
		if (i == arr.length)
			return arr;
		if (j < arr.length) {
			if (arr[min] > arr[j])
				min = j;
			return selectionSort(arr, i, j + 1, min);
		}
		int k = arr[i];
		arr[i] = arr[min];
		arr[min] = k;
		return selectionSort(arr, i + 1, i + 2, i + 1);
	}

//                 Bubble Sort  ( O(n) )	          
	public static int[] bubbleSort(int arr[], int i, int j) {
		System.out.println("i - " + i + " j  - " + j);
		if (i == arr.length)
			return arr;
		if (j < arr.length - i - 1) {
			if (arr[j] > arr[j + 1]) {
				int k = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = k;
			}
			return bubbleSort(arr, i, j + 1);
		}
		return bubbleSort(arr, i + 1, 0);

	}

	public static int powerOptimized(int n, int pow) {
		System.out.println("1");
		if (pow == 0)
			return 1;
		if (pow == 1)
			return n;
		int ans = powerOptimized(n, pow / 2);
		if (pow % 2 == 0)
			return ans * ans;
		return n * (ans * ans);
	}

	public static int powerRecur(int n, int pow) {
		if (pow == 1)
			return n;
		return n * power(n, pow - 1);

	}

	public static boolean isPolindrom(String s, int i, int j) {
		if (i >= j)
			return true;
		if (s.charAt(i) != s.charAt(j))
			return false;
		return isPolindrom(s, i + 1, j - 1);

	}

	public static String reverse(String s) {
		if (s.length() <= 1)
			return s;
		char last = s.charAt(s.length() - 1);
		return last + reverse(s.substring(0, s.length() - 1));

	}

	public static int pivot(int arr[]) {
		int st = 0, end = arr.length - 1;
		while (st < end) {
			int mid = (st + end) / 2;
			System.out.println("st -" + st + " end -" + end + " mid= " + mid);
//			 try{if( arr[mid-1]>arr[mid])
//				return arr[mid];
//			 }catch(ArrayIndexOutOfBoundsException e) {
//				 e.printStackTrace();
//				 return arr[end];
//			 }
			if (arr[0] <= arr[mid])
				st = mid + 1;
			else
				end = mid;
		}
		return arr[st];
	}

	public static int getPivot(int arr[]) {
		int st = 0, end = arr.length - 1;
		while (st < end) {
			int mid = st + (end - st) / 2;
			if (arr[0] <= arr[mid])
				st = mid + 1;
			else
				end = mid;
		}
		return st;
	}

	public static int search(int[] arr, int target) {
		int k = getPivot(arr);
		System.out.println(arr.length);
		if (arr[k] <= target && target <= arr[arr.length - 1])
			return binarySearching(arr, k, arr.length - 1, target);
		else
			return binarySearching(arr, 0, k - 1, target);

	}

	public static int peakMountain(int arr[]) {
		int st = 0, end = arr.length - 1;
		while (st < end) {
			int mid = (st + end) / 2;

			if (arr[mid] < arr[mid + 1])
				st = mid + 1;
			else
				end = mid;
		}

		return arr[st];
	}

	public static int peakMountainRecur(int arr[], int st, int end) {
		if (st >= end)
			return st;
		int mid = (end + st) / 2;
		if (arr[mid] < arr[mid + 1])
			return peakMountainRecur(arr, mid + 1, end);
		return peakMountainRecur(arr, st, mid);
	}

	public static int findLargest(int arr[], int i, int max) {
		if (i == arr.length)
			return max;
		if (arr[i] > max)
			max = arr[i];
		return findLargest(arr, i + 1, max);
	}

	public static int countInArray(int arr[], int st, int end, int value, int count) {
		if (st > end)
			return count;
		int mid = (st + end) / 2;
		if (arr[mid] == value) {
			count++;
			count = countInArray(arr, st, mid - 1, value, count);
			count = countInArray(arr, mid + 1, end, value, count);
			return count;
		}
		if (arr[mid] > value)
			return countInArray(arr, st, mid - 1, value, count);
		return countInArray(arr, mid + 1, end, value, count);
	}

	public static int frequencyCountOfElement(int arr[], int value) {
		return countInArray(arr, 0, arr.length - 1, value, 0);
	}

	public static int firstOccurInArrayRecur(int arr[], int st, int end, int value, int ans) {
		if (st > end)
			return ans;
		int mid = (st + end) / 2;
		if (arr[mid] == value) {
			ans = mid;
			ans = firstOccurInArrayRecur(arr, st, mid - 1, value, ans);
			// return firstOccurInArrayRecur(arr, st, mid-1, value, ans);
		} else if (arr[mid] > value)
			ans = firstOccurInArrayRecur(arr, st, mid - 1, value, ans);
//			return firstOccurInArrayRecur(arr, st, mid-1, value, ans);
		else
			ans = firstOccurInArrayRecur(arr, mid + 1, end, value, ans);
		// return firstOccurInArrayRecur(arr, mid+1, end, value, ans);
		return ans;

	}

	public static int lastOccurInArrayRecur(int arr[], int st, int end, int value, int ans) {
		if (st > end)
			return ans;
		int mid = (st + end) / 2;
		if (arr[mid] == value) {
			ans = mid;
			return lastOccurInArrayRecur(arr, mid + 1, end, value, ans);
		}

		if (arr[mid] > value)
			return lastOccurInArrayRecur(arr, st, mid - 1, value, ans);

		return lastOccurInArrayRecur(arr, mid + 1, end, value, ans);

	}

	public static int[] firstAndLastOccurRecursion(int arr[], int value) {
		int first = -1, last = -1;
		first = firstOccurInArrayRecur(arr, 0, arr.length - 1, value, first);
		last = lastOccurInArrayRecur(arr, 0, arr.length - 1, value, last);

		return new int[] { first, last };
	}

	public static int firstOccuranceInArray(int arr[], int value) {
		int st = 0;
		int end = arr.length - 1;
		int first = -1;
		while (st <= end) {
			int mid = (st + end) / 2;
			if (arr[mid] == value) {
				first = mid;
				end = mid - 1;
			} else if (arr[mid] > value)
				end = mid - 1;
			else
				st = mid + 1;

			System.out.println(st + " " + end);
		}
		return first;
	}

	public static int lastOccuranceInArray(int arr[], int value) {
		int st = 0;
		int end = arr.length - 1, ans = -1;
		while (st <= end) {
			int mid = (st + end) / 2;
			if (arr[mid] == value) {
				ans = mid;
				st = mid + 1;
			} else if (arr[mid] > value)
				end = mid - 1;
			else
				st = mid + 1;
		}
		return ans;
	}

	public static int[] firstAndLastOccuranceInArray(int arr[], int value) {
		int first = -1;
		int last = -1;
		first = firstOccuranceInArray(arr, value);
		last = lastOccuranceInArray(arr, value);

		return new int[] { first, last };
	}

	public static double sqrtMorePrecise(int n, int precise) {
		double sqrt = sqrt(n);
		double factor = 1;
		for (double i = 0; i < precise; i++) {
			factor = factor / 10;
			for (double j = sqrt; j * j < n; j = j + factor) {
				sqrt = j;
			}
		}
		return sqrt;
	}

	public static boolean binarySearch(int arr[], int value) {
		return binarySearch(arr, 0, arr.length - 1, value);
	}

	public static int binarySearchIndex(int arr[], int value) {
		return binarySearching(arr, 0, arr.length - 1, value);
	}

	public static int searchingInRotatedArray(int arr[], int k, int value) {
		int pivot = k;
		if (arr[k] <= value && value <= arr[arr.length - 1])
			return binarySearching(arr, k, arr.length - 1, value);
		else
			return binarySearching(arr, 0, pivot - 1, value);

	}

	public static int[] firstAndLastIndexOfElement(int arr[], int value) {
		int st = 0, first = -1, last = -1, end = arr.length - 1;
		while (st < arr.length) {
			if (arr[st] == value) {
				first = st;
				break;
			}
			st++;

		}
		while (end >= first) {
			if (arr[end] == value) {
				last = end;
				break;
			}
			end--;

		}

		return new int[] { first, last };
	}

	public static int sqrt(int num, long st, long end, long ans) {
		if (st > end)
			return (int) ans;

		long mid = (st + end) / 2;

		if (mid * mid == num)
			return (int) mid;
		if (mid * mid < num) {
			return (int) sqrt(num, mid + 1, end, mid);
		}
		return (int) sqrt(num, st, mid - 1, ans);

	}

	public static long sqrt(int num) {
		long st = 0, end = num, ans = 0;
		while (st <= end) {
			long mid = st + (end - st) / 2;

			if (mid * mid == num)
				return mid;
			if (mid * mid < num) {
				ans = mid;
				st = mid + 1;
			} else
				end = mid - 1;

		}
		return ans;
	}

	public static int binarySearching(int arr[], int st, int end, int value) {

		System.out.println(st + "->" + end);
		if (st > end)
			return -1;
		int mid = (st + end) / 2;
		if (arr[mid] == value)
			return mid;
		if (arr[mid] > value)
			return binarySearching(arr, st, mid - 1, value);
		return binarySearching(arr, mid + 1, end, value);

	}

	public static boolean searchInRotatedArray(int arr[], int k, int value) {
		int ll = k;
		int lr = arr.length - 1;
		int rl = 0;
		int rr = k - 1;

		if (arr[rl] > value)
			return binarySearching(arr, ll, lr, value) >= 0 ? true : false;
		return binarySearching(arr, rl, rr, value) >= 0 ? true : false;

	}

	public static int[] mergeTwoSortedArray(int arr1[], int arr2[]) {
		int i = 0, j = 0, k = 0;
		int sorted[] = new int[arr1.length + arr2.length];
		while (i < arr1.length && j < arr2.length) {

			if (arr1[i] < arr2[j])
				sorted[k++] = arr1[i++];
			else
				sorted[k++] = arr2[j++];

		}
		while (i < arr1.length)
			sorted[k++] = arr1[i++];

		while (j < arr2.length)
			sorted[k++] = arr2[j++];
		return sorted;
	}

	public static int[] mergeSort(int arr[], int st, int end) {
		if (st >= end)
			return new int[] { arr[st] };

		int mid = (st + end) / 2;

		// left side
		int arr1[] = mergeSort(arr, st, mid);

		// right side
		int arr2[] = mergeSort(arr, mid + 1, end);

		return mergeTwoSortedArray(arr1, arr2);

	}

	public static int sqrt(int n, int i) {
		return 0;

	}

	public static boolean binarySearch(int arr[], int left, int right, int value) {
		System.out.println(left + "-> " + right);
		if (left > right)
			return false;
		int middle = (right + left) / 2;
		if (arr[middle] == value)
			return true;
		if (arr[middle] < value)
			return binarySearch(arr, middle + 1, right, value);
		return binarySearch(arr, left, middle - 1, value);
	}

	public static boolean linearSearch(int arr[], int i, int value) {

		if (i >= arr.length)
			return false;
		if (arr[i] == value)
			return true;
		return linearSearch(arr, i + 1, value);
	}

	public static int arraySum(int arr[], int i) {
		if (arr.length == 0)
			return 0;

		if (i >= arr.length - 1)
			return arr[i];
		return arr[i] + arraySum(arr, i + 1);
	}

	public static boolean isSorted(int arr[], int i, int j) {
		if (j >= arr.length)
			return true;
		if (arr[i] > arr[j])
			return false;
		return isSorted(arr, i + 1, j + 1);

	}

	public static String arr[] = { "zero", "One", "Two", "Three", "Four", "Five", "SIx", "Seven", "Eight", "Nine" };

	public static void convertNumToWords(int n) {
		if (n == 0)
			return;

		convertNumToWords(n / 10);
		System.out.println(arr[n % 10]);

	}

	public static int factorialTrail(int n) {
		if (n == 1)
			return 1;
		return n * factorial(n - 1);
	}

	public static int powTrial(int n, int pow) {
		if (pow == 1)
			return n;
		return n * powTrial(n, pow - 1);
	}

	public static int countNoOfWaysToReachNthStairs(int n) {
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;
		int ans = countNoOfWaysToReachNthStairs(n - 1) + countNoOfWaysToReachNthStairs(n - 2);
		return ans;

	}

	public static int fibonacciOfNthTerm(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fibonacciOfNthTerm(n - 1) + fibonacciOfNthTerm(n - 2);

	}

	public static Node reverseLinkList4(Node prev, Node curr) {
		if (curr == null) {

			return prev;
		}
		Node recur = reverseLinkList4(curr, curr.getNext());
		curr.setNext(prev);
		return recur;

	}

	public static void reverseLinkList3(LinkList l, Node prev, Node curr) {
		if (curr == null) {
			l.start = prev;
			return;
		}
		reverseLinkList3(l, curr, curr.getNext());
		curr.setNext(prev);
	}

	public static void reverseLinkList2(LinkList l, Node prev, Node curr) {
		if (curr == null) {
			l.start = prev;
			return;
		}
		Node next = curr.getNext();
		curr.setNext(prev);
		prev = curr;
		curr = next;
		reverseLinkList2(l, prev, curr);

	}

	public static void reverseLinkList(LinkList list) {
		list.start = reverseLinkList(null, list.start);
		reverseLinkList2(list, null, list.start);
	}

	public static Node reverseLinkList(Node prev, Node curr) {

		if (curr == null)
			return prev;

		Node next = curr.getNext();
		curr.setNext(prev);
		prev = curr;
		curr = next;

		return reverseLinkList(prev, curr);

	}

	public static int power(int n, int pow) {
		if (pow == 0)
			return 1;
		return n * power(n, pow - 1);
	}

	public static void fibonacci(int k, int k1, int n) {
		if (n == 0) {
			return;
		}
		int k3 = k + k1;

		System.out.println(k3);
		fibonacci(k1, k3, n - 1);
	}

	public static int factorial(int n) {
		if (n == 1)
			return 1;
		return n * factorial(n - 1);
	}

	public static void table(int n, int time) {
		if (time == 10) {
			System.out.println(n * time);
			return;
		}
		System.out.println(n * time);
		table(n, time + 1);

	}

}
