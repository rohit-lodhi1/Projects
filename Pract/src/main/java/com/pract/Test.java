package com.pract;

import java.lang.reflect.InvocationTargetException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

import java.util.TreeSet;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.jdbc.core.metadata.OracleCallMetaDataProvider;

import com.fasterxml.jackson.databind.ser.std.StdArraySerializers.BooleanArraySerializer;

interface DD {

}

class AB implements Comparable<AB> {
	int id = 0;
	String name = "rohit";

	@Override
	public int compareTo(AB o) {
		if (this.id < o.id)
			return 1;

		return -1;
	}

	@Override
	public String toString() {
		return "AB [id=" + id + ", name=" + name + "]";
	}

}

abstract class kd {

}

class Foodsystem {
	public String count;
	public Map<String, Integer> food = new LinkedHashMap<>();

	public String toString() {
		return count + " =" + food;
	}

}

public class Test {

	public Test(int a) {

	}

	public static void main(String[] args) throws Exception {
		// fibonacci(0,1,20);
		// Class<?> clas = Class.forName("com.pract.Test");

		// Constructor<?> to = clas.getConstructor(int.class);
		// Test t = (Test) to.newInstance();
		var a = new Test(8);

		// System.out.println(Integer.toBinaryString(2));

		// new Random().ints(1,999).limit(20).sorted().forEach(System.out::println);
		// List<Integer> list = List.of(1,2,3,4,5);
		// System.out.println(list.stream().mapToInt(v->v).max().getAsInt());
		// list.stream().max(Integer::compare);

//		
//		longestPolindrom("bcac");
//	
//	majorityElement(new  int []{1,2,3,4,5,5});
//		
//	anagram("abcda","bcdaa");
//	String sp="TEST@$QWES 89";
//	sp = sp.replaceAll("\\d+","");
//	System.out.println(sp);

//arrayLeftRotation(new int[] {1,2,3,4,5},4);
//arrayRightRotation(new int[] {1,2,3,4,5},2);
//arraySum(new int[] {1,2,3,4},new int[] {1,2,3});
//uniqueFromArrays(new int[] {1,2,4},new int[] {1,2,3,5});
//wordCount("Hello what are you doing here you fucking bitch bastard");
//String s[]=textToWordsArray("Hello what are you doing here you fucking bitch bastard ab bcd");

//char arr[]=stringToArrayOfCharacters("hello what");

//twoSum(new int[] {2,7,11,15},9);
//		System.out.println(medianOfTwoSortedArray(new int[] {3},new int[] {-2,-1}));
//		System.out.println(longestPolindromSubtString("cbbd"));
		// zigzapConversion("PAYPALISHIRING",4);
//		Date d = new Date();
//		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
//		Date parse = f.parse("12/9/2023");
//		//LocalDate.now().
//		LocalDate l = LocalDate.now();
//		LocalDate l2 = LocalDate.of(2024, 10, 11);
//		Period period = Period.between(l, l2);
//		period.between(l, l2);
//		DayOfWeek dayOfWeek = l2.getDayOfWeek();
//		System.out.println(dayOfWeek.toString());

//		int arr[] = new int[] { 1, 2, 4 };
//		int arr2[] = new int[] { 1, 3, 4 };
		// righRotation(arr, 2);
//inserAtNthPos(arr,3,3);

//arr=insertInSortedArray(arr,6);
//System.out.println(2%5);
//arr=mergeSortedArrays(arr,arr2);
//System.out.println(Arrays.toString(arr))
		// reverserInteger(-1234);
//convertToInteger("  -1234");

		// AB.main(new String[] {"a","b"});
		// AB ab = new AB();
//		ab.hello();
//Comparator<Integer> com = new Comparator<Integer>() {
//
//	@Override
//	public int compare(Integer o1, Integer o2) {
//	   
//		return o1.intValue()>o2.intValue()?o2:o1;
//	}
//	
//};
//com = (c,b) -> c<b?1:-1;
//
//TreeSet<AB>  t = new TreeSet<>(); 
//		AB a1 = new AB();
//		a1.id=10;
//		AB a2 = new AB();
//		a2.id=20;
//		AB a3 = new AB();
//		a3.id=30;
//		AB a4 = new AB();
//		a4.id=40;
//		AB a5 = new AB();
//		a5.id=50;
//		
//		t.add(a1);
//		t.add(a2);
//		t.add(a3);
//		t.add(a4);
//		t.add(a5);
//		System.out.println(t);
		// System.out.println(integerToRoman(400));
		// System.out.println(romanToInteger("D"));
		// System.out.println(nonRepeatingChar("abcabc"));
		// System.out.println(longestPrefix(new String[] {"flow","flowight","flower"}));
//		int arr1[] = { 10, 8, 7, 5, 4, 11, 78 };
//		int arr3[] = { -1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4 };
//		Arrays.sort(arr3);
		// System.out.println(threeSum(arr3));
//		recursionBubbleSort(arr1,0,0);
//		System.out.println(Arrays.toString(arr1));
//		List.of(arr);

//		System.out.println(Arrays.toString(mergeTwoSortedArray(new int[] {1,3,5,7,9},new int[] {2,4,6,7,8})));
//		System.out.println(Arrays.toString(selectionSortRecu(new int[] {7,9,4,3,2,1,54,3},0,1,0)));

//		System.out.println(Arrays.toString(insertionSort(new int[] {9,8,6,5,4,3,5})));
		// System.out.println(uniqueOccurance(new int[] {1,1,1,2,2,2,3,4,4,5,4,5}));;
//		System.out.println(reverseKElements(new int[] {1,2,3,4,5,6,7,8,9},2));

		// System.out.println(isArraySortedOrRotated(new int[] {5,6,7,8,1}));
		// System.out.println(Arrays.toString(twoSum2(new int[] {2 ,7,8,5,2,1},9)));
		// System.out.println(longestPrefixs(new String[] {"ab","aba","ad"}));
		// System.out.println(Arrays.toString(removeDuplicatess(new int[]
		// {1,1,2,2,3,4,4,5,55,5})));
		// System.out.println(firstOccurances("hadbadhad","had"));
		// String s[]= {"aaa","aec","adc","ae"};
//		Arrays.sort(s);
//		System.out.println(lastWordLength("hello world jav   "));
		// System.out.println(Arrays.toString(plusOneOptimized(new int[] {9,9,})));
		// System.out.println(isPolindrom("5?6?7?876?5"));
		// System.out.println(reverseWords("A man, a plan, a canal: Panama"));
//		System.out.println(mostOccurrance("There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc."));   // stuck after 30
//		System.out.println(mostOccurranceInString("There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc."));   // stuck after 30
//		System.out.println(replaceString("a man is one the street"));
//	System.out.println(replaceAllDigitsWithCharacter("a1b2c3"));
		// System.out.println(removeAllSubstring("aabababa","aba"));
//System.out.println(removeAllDuplicates("aabbccdeffghill"));
		// System.out.println(1%2);
//		char ch[]=new char[] {'a','a','a','b','b','a','a'};
//		int n=countLetters(ch);
//		for(int i=0;i<n;i++) {
//			System.out.print(ch[i]+",");
// 		System.out.println(System.currentTimeMillis());
//		}
//		System.out.println(Arrays.toString(mergeSorted(new int[] {1,2,3,4},3,new int[] {2,5,6},2)));
		// int arr[][] = new int[][] { { 1, 2, 3} ,{ 4, 5, 6} ,{7,8,9}};
//		printWave(arr,2,3);
		// System.out.println(reverseVowels("hello"));
//		printSprial(arr);
//		generateMatrix(5);
//		arr = rotateArray90(arr);
//		for(int i=0;i<arr.length;i++) {
//			for(int j=0;j<arr[0].length;j++)
//				System.out.print(arr[i][j]+" ");
//			System.out.println();
//		}

//		int arr []= {1,2};
		// rotateArrayWithK(arr, 3);
//		int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};  
//		List<List<Integer>> shiftGrid = shiftGrid(arr, 2);
//		for(int i =0 ;i<shiftGrid.size();i++) {
//			System.out.println(shiftGrid.get(i));
//		}

//		System.out.println(maximumSumOfTwoSubStringScore("00111"));
//		System.out.println(convertArrayIn2DArray(new int[] {1,2,3,4,5,5,6,200,200}));
//	System.out.println(missingNumber(new int[] {9,6,4,2,3,5,7,0,1}));	
//		System.out.println(unique(new int[] {1,1,2,2,3,3,9}));
		// System.out.println(Arrays.toString(findErrorNums(new int[] {1,2,2,4})));
		// kajuKatli(10);
//		System.out.println(minOperations("110010"));
//		printPrinNumberRange(40);
		// System.out.println(isDuplicatePresent(new int[] { 1, 2, 3, 4 }));
//		System.out.println(isIsomorphic("bbbaaaba","aaabbbba"));
		// System.out.println(replaceAllDigitsWithCharacter("a1b1c2d3"));
//		System.out.println(System.currentTimeMillis());
//		int arr[] = { 7,8,9,1,2,3 };
//		arr = mergeSort(arr);
		// System.out.println(Arrays.toString(mergeSortedArray(new int[] { 2, 5, 7, 9 },
		// new int[] { 1, 3, 6, 8 })));
//		System.out.println(Arrays.toString(arr));
//		System.out.println(findInSortedRotatedArray(arr,3));
//		
//		System.out.println(System.currentTimeMillis());
//		String names[] = new String[] {"Marry","Kimmi","Emma"};
//		int height[] =new int[] {180,165,170};
//		Map<Integer, String>  map = new HashMap<>();
//		for(int i=0;i<names.length ;i++) {
//			map.put( height[i],names[i]);
//		}
//			
//		int[] sortPeople = sortPeople(names,height);
//		String sorted[] = new String[sortPeople.length];
//		for(int i=0;i<sortPeople.length;i++)
//			sorted[i]=map.get(sortPeople[i]);
//		System.out.println(Arrays.toString(sorted));
//		height =new int[] {180,165,170};
//		System.out.println(Arrays.toString(sortPeo[{ple2(names,height)));
//		System.out.println(profitOfStock(new int[] { 7, 1, 5, 3, 6, 4 }));
		String s="prosperity";
		System.out.println(solve(s,0,new ArrayList<>()).size());
		
	}

	public static String swap(String s, int st, int end) {
		char t = s.charAt(st);
		char[] charArray = s.toCharArray();
		charArray[st]=charArray[end];
		charArray[end]=t;
		
		return new String(charArray);
	}

	public static List<String> solve(String s,int index,List<String> ans){
	    if(index>=s.length())
	    ans.add(s);
	    
	    for(int j=index;j<s.length();j++){
	        s = swap(s,j,index);
	        solve(s,index+1,ans);
	        s = swap(s,j,index);
	    }
	    return ans;
	}

	// best time to buy and sell stock

	// max
	public static int max(int r, int[] arr, int st) {
		int max = 0;
		for (; st < arr.length; st++) {
			if (max < arr[st] && arr[st] > r) {
				max = arr[st];
			}
		}
		return max;
	}

	public static int profitOfStock(int arr[]) {
		int profit = 0;
		for (int i = 0; i < arr.length; i++) {
			int m = max(arr[i], arr, i);
			if (m - arr[i] > profit)
				profit = m - arr[i];
			System.out.println(max(arr[i], arr, i) + " " + profit);
		}
		return 0;
	}

	static class A {
		String name;
		int height;

		public A(String name, int height) {
			this.name = name;
			this.height = height;
		}

	}

	public static String[] sortPeople2(String names[], int height[]) {
		List<A> list = new ArrayList<>();
		for (int i = 0; i < names.length; i++)
			list.add(new A(names[i], height[i]));

		List<String> collect = list.stream().sorted(new Comparator<A>() {
			@Override
			public int compare(A o1, A o2) {
				return o2.height - o1.height;
			}

		}).map(a -> a.name).collect(Collectors.toList());

		names = collect.toArray(new String[0]);
		return names;
	}

	public static int[] sortPeople(String names[], int height[]) {
		for (int i = 0; i < names.length; i++) {
			int maxHeight = i;
			for (int j = i + 1; j < height.length; j++) {
				if (height[j] > height[maxHeight])
					maxHeight = j;
			}

			int k = height[maxHeight];
			height[maxHeight] = height[i];
			height[i] = k;
		}
		return height;
	}

	public static int binarySearch(int arr[], int st, int end, int value) {
		if (st > end)
			return -1;
		int mid = (end + st) / 2;
		if (arr[mid] == value)
			return mid;
		if (arr[mid] > value)
			return binarySearch(arr, st, mid - 1, value);
		return binarySearch(arr, mid + 1, end, value);
	}

	public static int findInSortedRotatedArray(int arr[], int value) {
		int st = 0, end = arr.length - 1;

		while (st <= end) {
			int mid = (end + st) / 2;
			System.out.println("st " + st + "   end  " + end + "   mid  " + mid);
			if (arr[mid] == value)
				return mid;
			else if (arr[mid] > value && arr[0] < value || arr[0] > value && arr[0] > arr[mid])
				end = mid - 1;
			else
				st = mid + 1;
		}
		return -1;
	}

	public static int[] mergeSortedArray(int arr[], int arr1[]) {
		int i = 0, j = 0, k = 0;
		int sorted[] = new int[arr.length + arr1.length];

		while (i < arr.length && j < arr1.length) {
			if (arr[i] < arr1[j])
				sorted[k++] = arr1[j++];
			else
				sorted[k++] = arr[i++];
		}

		while (i < arr.length)
			sorted[k++] = arr[i++];

		while (j < arr1.length)
			sorted[k++] = arr1[j++];

		return sorted;
	}

	public static int[] mergeSort(int arr[]) {
		return mergeSort(arr, 0, arr.length - 1);
	}

	public static int[] mergeSort(int arr[], int st, int end) {
		if (st >= end)
			return new int[] { arr[st] };

		int mid = (end + st) / 2;
		return mergeSortedArray(mergeSort(arr, st, mid), mergeSort(arr, mid + 1, end));

	}

	public static void insertionSort1(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			int element = arr[i], j = 0;
			for (j = i - 1; j >= 0; j--) {
				if (arr[j] > element)
					arr[j + 1] = arr[j];
				else
					break;

			}
			arr[j + 1] = element;

		}
	}

	public static void selectionSort1(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIndex] > arr[j])
					minIndex = j;
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}

	public static void bubbleSort1(int arr[]) {
		for (int i = 1; i <= arr.length; i++) {
			for (int j = 0; j < arr.length - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	public static boolean isIsographic(String s, String t) {
		return false;
	}

	public static int count(String s, int index) {
		if (index == s.length() - 1)
			return 1;
		int count = 1;

		for (; index < s.length() - 1; index++) {
			if (s.charAt(index) == s.charAt(index + 1))
				count++;
			else
				return count;
		}
		return count;
	}

	public static boolean isIsomorphic(String s, String t) {
		Map<Character, Integer> countS = new HashMap<>();
		Map<Character, Integer> countT = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			int count = 1;
			if (Objects.isNull(countS.get(ch))) {
				for (int j = i + 1; j < s.length(); j++) {
					if (ch == s.charAt(j))
						count++;
				}
				countS.put(ch, count);
			}
		}

		for (int i = 0; i < t.length(); i++) {
			char ch = t.charAt(i);
			int count = 1;
			if (Objects.isNull(countT.get(ch))) {
				for (int j = i + 1; j < t.length(); j++) {
					if (ch == t.charAt(j))
						count++;
				}
				countT.put(ch, count);
			}
		}
		System.out.println(9 - '0');
		System.out.println(countT);
		for (int i = 0; i < s.length(); i++) {
			if (count(s, i) != count(t, i) || !countS.get(s.charAt(i)).equals(countT.get(t.charAt(i))))
				return false;
		}
		return true;
	}

	public static boolean isDuplicatePresent(int arr[]) {
		int count[] = new int[10];
		for (int i = 0; i < arr.length; i++) {
			if (count[arr[i]] < 1)
				count[arr[i]]++;
			else
				return true;
		}
		return false;
	}

	// An ugly number is a positive integer whose prime factors are limited to 2, 3,
	// and 5
	public static boolean isUglyNumber(int n) {
		// if(n<0)
		return false;

	}

	public static void printPrinNumberRange(int n) {
		boolean[] isPrime = new boolean[n + 1];
		int count = 1;
		for (int i = 2; i <= n; i++) {
			if (!isPrime[i]) {
				count++;
				for (int j = i + i; j <= n; j += i)
					isPrime[j] = true;
			}
		}
	}

	public static int minOperations(String s) {
		int count[] = new int[2];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - '0']++;
		}
		int co = 0;
		if (count[0] > count[1])
			while (count[0] != count[1]) {
				count[0]--;
				count[1]++;
				co++;
			}
		else
			while (count[0] != count[1]) {
				count[0]++;
				count[1]--;
				co++;
			}

		return co;
	}

	public static int[] findErrorNums(int[] arr) {
		Set<Integer> value = new HashSet<>();
		int[] ar = new int[2];
		for (int i = 0; i < arr.length; i++) {
			if (value.contains(arr[i])) {
				ar[0] = arr[i];
				arr[1] = arr[i] + 1;
				System.out.println(arr[i] + 1);
				return ar;
			}
			value.add(arr[i]);
		}
		return ar;
	}

	public static int[] selectionSort(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min])
					min = j;
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;

		}
		return arr;
	}

	public static int[] bubbleSortPr(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

			}
		}
		return arr;
	}

	public static int unique(int arr[]) {
		int xor = 0;
		for (int i = 0; i < arr.length; i++) {
			xor ^= arr[i];
		}
		return xor;
	}

	public static int xorDuplicate(int arr[]) {

		for (int i = 0; i < arr.length; i++) {

		}
		return 0;
	}

	public static int missingNumber(int arr[]) {
		int max = findMaximum(arr);
		int total = max * (max + 1) / 2, sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return total - sum == 0 ? max + 1 : total - sum;
	}

	public static int countNumber(int arr[], int value) {
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value)
				count++;
			if (count > 2)
				return count;
		}
		return count;
	}

	public static int uniqueElement(int arr[]) {
		Set<Integer> value = Arrays.stream(arr).boxed().collect(Collectors.toSet());
		Iterator<Integer> iterator = value.iterator();
		while (iterator.hasNext()) {
			int va = iterator.next();
			if (count(arr, va) < 2)
				return va;
		}
		return -1;
	}

	public static int findMaximum(int arr[]) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		return max;
	}

	public static List<List<Integer>> convertArrayIn2DArray(int arr[]) {
		// int max = findMaximum(arr);
		int count[] = new int[201];
		for (int i = 0; i < arr.length; i++)
			count[arr[i]]++;
//		System.out.println(Arrays.toString(count));
		int max = findMaximum(count);
		List<List<Integer>> response = new ArrayList<>();
		for (int i = 0; i < max; i++) {
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < count.length; j++) {
				if (count[j] > 0) {
					list.add(j);
					count[j]--;
				}
			}
			response.add(list);
		}

		return response;
	}

	public static int count(char arr[], int st, int end, char ch) {
		int count = 0;
		while (st <= end) {
			if (arr[st] == ch)
				count++;
			st++;
		}

		return count;
	}

	public static int maximumSumOfTwoSubStringScore(String s) {
		char[] arr = s.toCharArray();
		int i = 0, j = i + 1, max = 0;
		while (i < j && j < arr.length) {
			int cou = count(arr, i, j - 1, '0') + count(arr, j, arr.length - 1, '1');

			if (cou > max)
				max = cou;
			j++;
		}
		return max;
	}

	public static List<List<Integer>> shiftGrid(int arr[][], int k) {
		int row = arr.length, col = arr[0].length, j = row * col - 1, count = 0;
		while (count++ < k) {
			int ele = arr[arr.length - 1][arr[0].length - 1];
			for (j = row * col - 1; j > 0; j--) {
				arr[j / col][j % col] = arr[(j - 1) / col][(j - 1) % col];
			}
			arr[0][0] = ele;

		}
		List<List<Integer>> ar = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			List<Integer> ro = new ArrayList<>();
			for (j = 0; j < arr[0].length; j++) {
				ro.add(arr[i][j]);
			}
			ar.add(ro);

		}
		return ar;
	}

	public static boolean binarySearch2DInSortedRow(int arr[][], int target) {
		int row = 0, col = arr[0].length - 1;

		while (col >= 0 && row <= arr.length - 1) {
			if (arr[row][col] == target)
				return true;
			if (arr[row][col] < target)
				row++;
			else
				col--;
		}
		return false;
	}

	public static boolean binarySearchIn2D(int arr[][], int target) {
		int row = arr.length;
		int col = arr[0].length;
		int st = 0;
		int end = row * col - 1;

		while (st <= end) {
			int mid = st + (end - st) / 2;
			int element = arr[mid / col][mid % col];
			if (element == target)
				return true;
			if (element < target)
				st = mid + 1;
			else
				end = mid - 1;

		}
		return false;

	}

	public static void rotateArrayWithK(int arr[], int k) {
		int arr2[] = new int[arr.length], l = 0;
		int kIndex = arr.length - k;

		if (k >= arr.length) {
			int count = 0;
			while (count++ <= k) {
				int temp = arr[arr.length - 1];
				System.out.println(Arrays.toString(arr));
				for (int j = arr.length - 1; j > 0; j--) {
					arr[j] = arr[j - 1];
				}
				arr[0] = temp;
			}
			return;
		}

		if (kIndex < 0)
			return;
		for (int i = kIndex; i < arr.length; i++)
			arr2[l++] = arr[i];

		for (int i = 0; i < kIndex; i++)
			arr2[l++] = arr[i];

		for (int i = 0; i < arr.length; i++)
			arr[i] = arr2[i];

	}

	public static int[][] rotateArray90(int arr[][]) {
		int arr3[][] = new int[arr.length][arr[0].length], k = 0;
		for (int col = 0; col < arr[0].length; col++) {
			k = 0;
			for (int row = arr.length - 1; row >= 0; row--) {
				arr3[col][k++] = arr[row][col];
			}

		}
		return arr3;
	}

	public static int[][] generateMatrix(int n) {
		int row = n;
		int col = n;
		int total = n * n;
		int startingCol = 0;
		int startingRow = 0;
		int endingRow = row - 1;
		int endingCol = col - 1;
		int arr[][] = new int[n][n];
		int count = 0;
		while (count < total) {
			// first row
			for (int i = startingCol; count < total && i <= endingCol; i++) {
				arr[startingRow][i] = ++count;
			}

			startingRow++;
			// second row
			for (int i = startingRow; count < total && i <= endingRow; i++) {
				arr[i][endingCol] = ++count;
			}

			endingCol--;
			// third row
			for (int i = endingCol; count < total && i >= startingCol; i--) {
				arr[endingRow][i] = ++count;
			}

			endingRow--;

			// fourth row
			for (int i = endingRow; count < total && i >= startingRow; i--) {
				arr[i][startingCol] = ++count;
			}
			startingCol++;

		}
		return arr;
	}

	public static void printSprial(int arr[][]) {
		int startingCol = 0;
		int startingRow = 0;
		int row = arr.length;
		int col = arr[0].length;
		int endingRow = row - 1;
		int endingCol = col - 1;
		int count = 0;
		int total = row * col;

		while (count < total) {
			// first row
			for (int i = startingCol; count < total && i <= endingCol; i++) {
				System.out.print(arr[startingRow][i]);
				count++;
			}
			System.out.println();
			startingRow++;
			// second row
			for (int i = startingRow; count < total && i <= endingRow; i++) {
				System.out.print(arr[i][endingCol]);
				count++;
			}

			System.out.println();
			endingCol--;
			// third row
			for (int i = endingCol; count < total && i >= startingCol; i--) {
				System.out.print(arr[endingRow][i]);
				count++;
			}

			endingRow--;
			System.out.println();
			// fourth row
			for (int i = endingRow; count < total && i >= startingRow; i--) {
				System.out.print(arr[i][startingCol]);
				count++;
			}
			startingCol++;
			System.out.println();
		}
	}

	public static boolean isVowel(char ch) {
		ch = Character.toLowerCase(ch);
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
			return true;
		return false;
	}

	public static String reverseVowels(String s) {

		char[] arr = s.toCharArray();
		int i = 0, j = arr.length - 1;
		while (i < j) {
			if (isVowel(arr[i]) && isVowel(arr[j])) {
				char t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
				i++;
				j--;
			} else if (isVowel(arr[i]))
				j--;
			else
				i++;
		}
		return new String(arr);
	}

	public static void printWave(int arr[][], int row, int col) {
		for (int j = 0; j < col; j++) {

			for (int i = 0; i < row; i++) {
				System.out.print(arr[i][j]);
			}

			System.out.println();
			j++;
			for (int i = row - 1; i >= 0 && j < col; i--) {
				System.out.print(arr[i][j]);
			}
			System.out.println();

		}
	}

	public static int[] mergeSorted(int arr[], int m, int arr1[], int n) {
		int arr3[] = new int[m + n], i = 0, j = 0, k = 0;

		while (i < arr.length && j < arr1.length) {
			if (arr[i] > arr1[j] && n > 0) {
				arr3[k++] = arr1[j++];
				n--;
			} else if (m > 0) {
				arr3[k++] = arr[i++];
				m--;
			} else
				break;

		}
		System.out.println(Arrays.toString(arr3));
		while (m > 0 && i < arr.length) {
			arr3[k++] = arr[i++];
			m--;
		}
		while (n > 0 && j < arr1.length) {
			arr3[k++] = arr1[j++];
			n--;
		}
		return arr3;
	}

	public static List<Foodsystem> system = new ArrayList<>();

	public void enterData() {
		String food[] = { "kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi" };
		String country[] = { "korean", "japanese", "japanese", "greek", "japanese", "korean" };
		int arr[] = { 9, 12, 8, 15, 14, 7 };
		for (int i = 0; i < country.length; i++) {
			Map<String, Integer> fs = new LinkedHashMap<>();
			Foodsystem s = new Foodsystem();
			s.count = country[i];
			s.food.put(food[i], arr[i]);
			this.add(s);
		}
		System.out.println(system);

	}

	public void add(Foodsystem o) {
		for (int i = 0; i < this.system.size(); i++) {
			if (system.get(i).count.equals(o.count)) {
				system.get(i).food.putAll(o.food);
				return;
			}

		}
		this.system.add(o);
	}

	public void changeRating(String food, int rating) {
		for (int i = 0; i < this.system.size(); i++) {
			Foodsystem f = system.get(i);
			if (f.food.containsKey(food)) {
				f.food.put(food, rating);
				return;
			}

		}

	}

	public String highestRating(String country) {
		String city = "";

		for (int i = 0; i < this.system.size(); i++) {
			Foodsystem s = system.get(i);
			if (s.count.equals(country)) {
				int max = 0;
				Set<Entry<String, Integer>> entrySet = s.food.entrySet();
				System.out.println(entrySet);
				for (Entry<String, Integer> e : entrySet) {
					if (e.getValue() > max) {
						max = e.getValue();
						city = e.getKey();

					}
					if (e.getValue() == max) {
						s.food.put(e.getKey(), e.getValue());
					}
				}
			}

		}

		return city;
	}

	public static int countLetters(char[] s) {
		int k = 0;
		for (int i = 0; i < s.length;) {
			char ch = s[i];
			int j = i + 1, count = 1;

			while (j < s.length && s[j] == ch) {
				count++;
				j++;
			}
			System.out.println(ch + " " + count + " " + j);
			if (count > 1) {
				s[k++] = ch;
				for (char c : Integer.toString(count).toCharArray()) {
					if (k < s.length)
						s[k++] = c;
					else
						return k;
				}
			} else {
				s[k++] = ch;
			}
			i = j;
		}
		return k;
	}

	public static String removeAllDuplicates(String s) {
		StringBuilder sb = new StringBuilder();
		int count[] = new int[26];
		for (int i = 0; i < s.length(); i++) {
			int num = s.charAt(i) - 'a';
			count[num]++;
		}

		for (int i = 0; i < s.length(); i++) {
			if (count[(s.charAt(i) - 'a')] < 2)
				sb.append(s.charAt(i));

		}
		return sb.toString();
	}

	public static String removeAllSubstring(String s, String part) {
		while (s.length() != 0 && s.contains(part))
			s = s.replaceFirst(part, "");

		return s;
	}

	public static String replaceAllDigitsWithCharacter(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
				// sb.append((char) (s.charAt(i - 1) + (s.charAt(i) - 48)));
				sb.append((char) (s.charAt(i - 1) + s.charAt(i) - 48));
			else
				sb.append(s.charAt(i));
		}
		return sb.toString();

	}

	public static String replaceString(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ')
				sb.append("@40");
			else
				sb.append(s.charAt(i));

		}
		return sb.toString();
	}

	public static char mostOccurranceInString(String s) {
		int arr[] = new int[26]; // storing occurance of every letter according to index
		s = s.toLowerCase();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				int num = s.charAt(i) - 'a';
				arr[num]++;
			}
		}

		// finding max
		int max = 0;
		char ch = ' ';
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
				ch = (char) i;
			}

		}
		return (char) (ch + 'a');

	}

	// brute force
	public static char mostOccurrance(String s) {
		int max = 0;
		char ch = ' ';
		for (int i = 0; i < s.length(); i++) {
			int count = 0;
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j) && s.charAt(i) != ' ')
					count++;
			}

			if (count > max) {
				ch = s.charAt(i);
				max = count;
			}
		}
		return ch;
	}

	public static int climbStairs(int n) {

		if (n < 0)
			return 0;
		if (n == 0)
			return 1;
		return climbStairs(n - 1) + climbStairs(n - 2);
	}

	public static void reverseString(char[] ch, int st, int end) {

		while (st < end) {
			char temp = ch[st];
			ch[st] = ch[end];
			ch[end] = temp;
			st++;
			end--;
		}

	}

	public static char[] reverseWords(String s) {
		char ch[] = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ' && s.charAt(i) != ',') {
				int j = i + 1;
				for (; j < s.length(); j++) {
					if (s.charAt(j) == ' ' || s.charAt(j) == ',')
						break;
				}
				reverseString(ch, i, j - 1);
				i = j;
			}
		}
		return ch;
	}

	public static boolean isAlphaNumeric(char c) {
		if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9')
			return true;
		return false;
	}

	public static boolean isPolinromValidAlgo(String s) {
		StringBuilder b = new StringBuilder();
		// remove special characters only left alphanumeric
		for (int i = 0; i < s.length(); i++) {
			if (isAlphaNumeric(s.charAt(i)))
				b.append(s.charAt(i));

		}

		// to lower case
		String str = b.toString().toLowerCase();
		int st = 0, end = str.length() - 1;
		while (st < end) {
			if (str.charAt(st) != str.charAt(end))
				return false;
			st++;
			end--;
		}
		return true;

	}

	public static boolean isPolindrom(String s) {
		int st = 0, end = s.length() - 1;
		while (st < end) {
			if (s.charAt(st) >= '0' && s.charAt(st) <= '9') {
				if (s.charAt(end) >= '0' && s.charAt(end) <= '9') {

					if (s.charAt(st) != s.charAt(end))
						return false;
					else {
						st++;
						end--;
					}
				} else
					end--;
			} else
				st++;
		}
		return true;
	}

	// optimized
	public static int[] plusOneOptimized(int arr[]) {
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] < 9) {
				arr[i]++;
				return arr;
			}
			arr[i] = 0;
		}
		arr = new int[arr.length + 1];
		arr[0] = 1;
		return arr;
	}

	// brute force
	public static int[] plusOne(int arr[]) {
		if (arr.length < 1)
			return arr;
		int carry = 1;
		for (int i = arr.length - 1; i >= 0; i--) {
			arr[i] = arr[i] + carry;
			carry = 0;
			if (arr[i] > 9) {
				arr[i] = 0;
				carry = 1;
			} else
				break;
		}

		if (carry != 0) {
			int ar[] = new int[arr.length + 1];
			ar[0] = carry;
			for (int i = 1; i < ar.length - 1; i++)
				ar[i] = arr[i];
			return ar;
		}
		return arr;
	}

	public static int countLastWordLength(String s, int index) {
		int count = 0;
		for (; index >= 0; index--) {
			if (s.charAt(index) != ' ')
				count++;
			else
				break;
		}
		return count;
	}

	public static int lastWordLength(String s) {
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) != ' ')
				return countLastWordLength(s, i);
		}
		return 0;
	}

	public static int firstOccurances(String s, String value) {
		if (s.contains(value)) {
			return s.indexOf(value);
		}
		return -1;
	}

	public static boolean isMatched(String s, String value) {
		if (s.length() < value.length())
			return false;
		for (int i = 0; i < value.length(); i++) {
			if (s.charAt(i) != value.charAt(i))
				return false;
		}
		return true;
	}

	public static int firstOccurance(String s, String value) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == value.charAt(0)) {
				if (isMatched(s.substring(i), value))
					return i;
			}
		}
		return -1;
	}

	public static int[] removeDuplicatess(int arr[]) {
		int i = 0, j = 1;
		for (i = 1; i < arr.length; i++) {
			if (arr[i - 1] != arr[i])
				arr[j++] = arr[i];
		}
		return arr;
	}

	public static int[] removeDuplicates(int arr[]) {
		Set<Integer> set = new LinkedHashSet<>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		return set.stream().mapToInt(i -> i).toArray();

	}

	public static String longestPrefixs(String arr[]) {
		Arrays.sort(arr);
		StringBuilder b = new StringBuilder();
		String first = arr[0];
		String last = arr[arr.length - 1];
		for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
			if (first.charAt(i) != last.charAt(i))
				return b.toString();
			b.append(first.charAt(i));
		}
		return b.toString();

	}

	public static int[] twoSum2(int[] arr, int target) {
		int f = 0, l = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == target) {
					f = i;
					l = j;
				}
			}
		}
		return new int[] { f, l };
	}

	public static Boolean arraySortedOrRotated(int arr[]) {
		int count = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] > arr[i])
				count++;
		}
		if (arr[0] < arr[arr.length - 1])
			count++;

		return count == 1;
	}

	// brute force
	public static Boolean isArraySortedOrRotated(int arr[]) {
		int i = 0;
		for (i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1])
				break;

		}
		System.out.println(i + " -<");
		i++;
		for (; i < arr.length - 1; i++) {
			System.out.println("->" + i);
			if (arr[0] < arr[i] || arr[i] > arr[i + 1])
				return false;
		}
		if (i < arr.length && arr[0] < arr[i])
			return false;
		return true;
	}

	public static int findUnique(int arr[]) {
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {

			ans = ans ^ arr[i];
		}
		return ans;
	}

	public static int count(int arr[], int value) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (value == arr[i])
				count++;
		}
		return count;

	}

	public static int uniqueOccurance(int arr[]) {
		int arr1[] = new int[arr.length], k = 0;
		for (int i = 0; i < arr.length; i++) {
			if (!isPreExists(arr[i], arr, i - 1)) {

				int count = count(arr, arr[i]);
				arr1[k++] = count;
				System.out.println("count " + count);
			}
		}
		return findUniqueElement(arr1);
	}

	public static int[] reverse(int arr[], int st, int end) {
		if (end < arr.length)
			while (st < end) {
				int k = arr[st];
				arr[st++] = arr[end];
				arr[end--] = k;
			}
		return arr;
	}

	public static int[] reverseKElements(int arr[], int k) {
		int j = 0, count = 0;
		for (int i = 0; i < arr.length; i += k) {

			reverse(arr, i, i + k - 1);
		}
		System.out.println(Arrays.toString(arr));
		return arr;

	}

	public static boolean isPreExists(int value, int arr[], int k) {
		for (int i = k; i >= 0; i--) {
			if (arr[i] == value)
				return true;
		}
		return false;
	}

	public static int findUniqueElement(int arr[]) {
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			if (!isPreExists(arr[i], arr, i - 1))
				for (int j = i; j < arr.length; j++) {

					if (arr[i] == arr[j])
						count++;
				}

			if (count == 1) {
				System.out.println("found " + arr[i]);

				return arr[i];
			}
		}
		return 0;
	}

	public static int[] insertionSort(int arr[]) {
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			int k = arr[i];
			for (j = i - 1; j >= 0; j--) {
				if (arr[j] < k) {
					arr[j + 1] = arr[j];
				} else
					break;
			}
			arr[j + 1] = k;
		}
		return arr;
	}

	public static int[] selectionSortRecu(int arr[], int i, int j, int min) {
		if (i >= arr.length)
			return arr;
		if (j < arr.length) {
			if (arr[min] > arr[j])
				min = j;
			return selectionSortRecu(arr, i, j + 1, min);
		}
		int k = arr[i];
		arr[i] = arr[min];
		arr[min] = k;
		return selectionSortRecu(arr, i + 1, i + 2, i + 1);
	}

	public static int[] mergeTwoSortedArray(int arr[], int arr1[]) {
		int arr3[] = new int[arr.length + arr1.length], k = 0, i = 0, j = 0;

		while (i < arr.length && j < arr1.length) {
			if (arr[i] > arr1[j]) {
				arr3[k++] = arr1[j++];

			} else {
				arr3[k++] = arr[i++];

			}
		}

		while (i < arr.length) {
			arr3[k++] = arr[i++];
		}
		while (j < arr1.length) {
			arr3[k++] = arr1[i++];
		}
		return arr3;
	}

	public static void recursionBubbleSort(int arr[], int i, int j) {
		if (i == arr.length)
			return;
		if (j < arr.length - i - 1 && arr[j] > arr[j + 1]) {

			int k = arr[j];
			arr[j] = arr[j + 1];
			arr[j + 1] = k;
			System.out.println(Arrays.toString(arr));
			recursionBubbleSort(arr, i, j + 1);

		} else {
			System.out.println("----- " + Arrays.toString(arr));
			recursionBubbleSort(arr, i + 1, 0);
		}

	}

	public static void bubbleSort(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int k = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = k;
				}

			}
		}
	}

	public static List<List<Integer>> threeSum(int arr[]) {
		int i = 0, j = 0, k = arr.length - 1;
		Set<List<Integer>> output = new HashSet<>();
		for (i = 0; i < arr.length; i++) {
			j = i + 1;
			k = arr.length - 1;
			while (j < k) {
				System.out.println(arr[i] + "->" + arr[j] + "->" + arr[k] + "=> " + (arr[i] + arr[j] + arr[k]) + " ( "
						+ i + "," + j + "," + k);
				if (arr[i] + arr[j] + arr[k] == 0) {
					List<Integer> list = new ArrayList<>();
					list.add(arr[i]);
					list.add(arr[j]);

					list.add(arr[k]);
					output.add(list);
				} else if (arr[i] + arr[j] + arr[k] > 0) {
					k--;
					j--;
				}
				j++;

			}
		}

		return output.stream().toList();

	}

	public static String longestPrefix(String s[]) {

		String prefix = "";

		for (int i = 0; i < s.length; i++) {
			for (int j = i + 1; j < s.length; j++) {
				if (s[i].length() > s[j].length()) {
					String temp = s[i];
					s[i] = s[j];
					s[j] = temp;
				}
			}
		}

		String st = s[0];
		boolean isMatched = false;
		for (int j = 0; j < st.length(); j++) {
			char ch = st.charAt(j);

			for (int k = 1; k < s.length; k++) {
				isMatched = false;

				if (ch == s[k].charAt(j)) {
					isMatched = true;
				} else
					break;
			}
			if (isMatched)
				prefix += ch;
			else
				break;

		}
		;
		return prefix;

	}

	public static String nonRepeatingChar(String s) {
		for (int i = 0; i < s.length(); i++) {
			boolean isPresent = false;
			for (int j = 0; j < s.length(); j++) {
				if (i != j && s.charAt(i) == s.charAt(j)) {
					isPresent = true;
					break;
				}
			}
			if (!isPresent) {
				return s.charAt(i) + "";
			}
		}
		return "All Are repated";
	}

	public static Integer romanToInteger(String s) {
		int num = 0;
		Map<String, Integer> romans = new HashMap<>();
		romans.put("M", 1000);
		romans.put("CM", 900);
		romans.put("D", 500);
		romans.put("CD", 400);
		romans.put("C", 100);
		romans.put("XC", 90);
		romans.put("L", 50);
		romans.put("XL", 40);
		romans.put("X", 10);
		romans.put("IX", 9);
		romans.put("V", 5);
		romans.put("IV", 4);
		romans.put("I", 1);
//System.out.println(romans.get("M"));
		if (s.length() < 2)
			return romans.get(s.charAt(0) + "");
		for (int i = 0; i < s.length() - 1; i++) {

			if (romans.get(s.charAt(i) + "").intValue() >= romans.get(s.charAt(i + 1) + "").intValue()) {
				num += romans.get(s.charAt(i) + "");
				System.out.println("num -> " + num);
			} else {

				int sum = romans.get(s.charAt(i + 1) + "") - romans.get(s.charAt(i) + "");
				System.out.println("num    => " + num + "  sum => " + sum);
				num += sum;
				i++;
				System.out.println("--------- " + num);
			}
			if (i == s.length() - 2)
				if (romans.get(s.charAt(i + 1) + "").intValue() <= romans.get(s.charAt(i) + "").intValue()) {
					num += romans.get(s.charAt(i + 1) + "");

				}
		}
		return num;
	}

	public static String integerToRoman(int num) {
		Integer number[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String romans[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		String result = "";
		for (int i = 0; i < number.length; i++) {

			while (num >= number[i]) {
				num -= number[i];
				result += romans[i];
			}
		}
		return result;

	}

	public static int convertToInteger(String s) {
		String st = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				st += s.charAt(i);
			} else if (s.charAt(i) == '-')
				st += s.charAt(i);
		}
		System.out.println(Integer.parseInt(st));
		return 0;
	}

	public static int reverserInteger(int n) {
		int rev = 0;
		while (n != 0) {
			int r = n % 10;
			n /= 10;
			rev = rev * 10 + r;
		}
		System.out.println(rev);
		return 0;
	}

	public static int[] mergeSortedArrays(int a1[], int a2[]) {
		int a3[] = new int[a1.length + a2.length], j = 0, k = 0, i = 0;

		Stack<Character> stack = new Stack();
		String s = "a";
		Character c = s.charAt(i);
		System.out.println(c.equals(c));

		while (i < a1.length && j < a2.length) {

			if (a1[i] >= a2[j])
				a3[k++] = a2[j++];
			else
				a3[k++] = a1[i++];

		}
		while (i < a1.length)
			a3[k++] = a1[i++];

		while (j < a2.length)
			a3[k++] = a2[j++];

		return a3;

	}

	public static int[] insertInSortedArray(int arr[], int value) {
		int temp[] = new int[arr.length + 1], j = 0;
		boolean isInserted = false;
		for (int i = 0; i < arr.length; i++) {

			if (!isInserted && arr[i] > value) {
				temp[j++] = value;
				isInserted = true;
			}
			temp[j++] = arr[i];
		}
		if (!isInserted)
			temp[j++] = value;
		return temp;
	}

	public static int[] inserAtNthPos(int arr[], int value, int pos) {
		int j = 0;
		int temp[] = new int[arr.length + 1];
		if (pos < 1)
			return arr;

		for (int i = 0; i < arr.length; i++) {
			if (i == pos - 1)
				temp[j++] = value;

			temp[j++] = arr[i];
		}
		if (pos > arr.length) {
			temp[j++] = value;
		}

//	for(int i=0;i<temp.length;i++)
//		arr[i]=temp[i];
		return temp;
	}

	public static void righRotation(int arr[], int num) {
		int n = arr.length, temp = 0, count = 0;
		while (count++ < num) {
			temp = arr[n - 1];
			for (int i = n - 1; i > 0; i--)
				arr[i] = arr[i - 1];
			arr[0] = temp;
		}

	}

	public static void leftRotation(int arr[], int num) {
		int temp[] = new int[arr.length], n = arr.length, j = 0;

		for (int i = num; i < n; i++)
			temp[j++] = arr[i];
		for (int i = 0; i < num; i++)
			temp[j++] = arr[i];
		for (int i = 0; i < n; i++)
			arr[i] = temp[i];
	}

	public static char[] copyArray(char[] arr) {
		if (arr == null)
			return new char[1];

		char[] a = Arrays.copyOf(arr, arr.length + 1);
		return a;
	}

	public static String zigzapConversion(String s, int num) {
		char[][] arr = new char[num][];
		int k = 0, i = 0, j = 0, t = 0;
		while (k < s.length()) {
			while (i != num - 1) {
				arr[i] = copyArray(arr[i]);
				arr[i][j] = s.charAt(k++);
				i++;
			}
			j++;
			while (i != 0) {
				arr[i] = copyArray(arr[i]);
				arr[i][j] = s.charAt(k++);
				i--;
			}
			j++;

		}
		for (char[] a : arr) {
			for (char tt : a)
				System.out.print(tt);
			System.out.println();
		}
		return "";
	}

	public static String longestPolindromSubtString(String s) {
		String ans = "";
		if (s.length() < 1)
			return s;
		for (int i = 0; i < s.length(); i++) {

			for (int j = s.length() - 1; j >= 0; j--) {
				if (i < j) {
					String sub = s.substring(i, j + 1);
					if (sub.equals(new StringBuilder(sub).reverse().toString())) {
						if (sub.length() > ans.length()) {
							ans = sub;
						}

					}
				}
			}
		}

		return ans;
	}

	public static double medianOfTwoSortedArray(int[] arr1, int[] arr2) {

		int arr3[] = new int[arr1.length + arr2.length], i = 0, j = 0, k = 0;
		while (true) {
			if (i < arr1.length) {
				arr3[k++] = arr1[i++];
			} else if (j < arr2.length) {
				arr3[k++] = arr2[j++];
			} else
				break;

		}
		double ans = 0;
		Arrays.sort(arr3);
		System.out.println(Arrays.toString(arr3));
		if (arr3.length % 2 == 0) {
			int mid = arr3.length / 2;
			ans = (double) (arr3[mid - 1] + arr3[mid]) / 2;
			System.out.println(arr3[mid - 1]);
		} else {
			ans = arr3[arr3.length / 2];
		}

		return ans;
	}
// 4
// 1,1,1,1
// 2,1,1
// 1,1,2
// 2,2

	public static int[] twoSum(int arr[], int target) {
		int f = 0, sec = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] + arr[j] == target && i != j) {

					f = i;
					sec = j;
				}
			}

		}
		System.out.println(f + " " + sec);
		return new int[] { f, sec };
	}

	public static char[] stringToArrayOfCharacters(String s) {
		char arr[] = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			arr[i] = s.charAt(i);
		}
		return arr;
	}

	public static String[] textToWordsArray(String text) {
		List<String> words = new ArrayList<>();
		for (int i = 0; i < text.length(); i++) {

			for (int j = i; j < text.length() - 1; j++) {
				if (i > 0 && text.charAt(i) == ' ' && text.charAt(j + 1) == ' ' && text.charAt(i - 1) != ' ') {
					words.add(text.substring(i + 1, j + 1));
					break;
				} else if (i == 0 && text.charAt(j + 1) == ' ') {
					words.add(text.substring(i, j + 1));
					break;
				} else if (text.charAt(i) == ' ' && j + 1 == text.length() - 1) {
					words.add(text.substring(i + 1, text.length()));
					break;
				}
			}

		}
		String s[] = new String[words.size()];
		int i = 0;
		ListIterator<String> listIterator = words.listIterator();
		while (listIterator.hasNext()) {
			s[i++] = listIterator.next();
		}
		return s;
	}

	public static int wordCount(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i == 0)
				count++;
			else if (s.charAt(i) == ' ')
				for (int j = i; j < s.length() - 1; j++) {
					if (s.charAt(j + 1) == ' ' && s.charAt(i - 1) != ' ') {
						count++;
						System.out.print(s.charAt(i) + " - > " + s.charAt(j) + " = " + count);
						break;
					}
				}
		}
		return count + 1;

	}

	public static void uniqueFromArrays(int arr[], int arr2[]) {

		List<Integer> list1 = List.of(1, 2, 4);
		List<Integer> list2 = List.of(1, 2, 3, 5);
		List<Integer> unique = new ArrayList<>();
		unique.addAll(list1);
		unique.addAll(list2);
		unique = unique.stream().distinct()
				.filter(a -> list1.contains(a) && !list2.contains(a) || !list1.contains(a) && list2.contains(a))
				.collect(Collectors.toList());
		System.out.println(unique);

		int k = 0;
		for (int i = 0; i < arr.length || k < arr2.length; i++, k++) {
			boolean a = false;
			boolean b = false;
			if (i < arr.length)
				for (int j = 0; j < arr2.length; j++) {
					if (arr[i] == arr2[j])
						a = true;
				}
			for (int j = 0; j < arr.length; j++) {
				if (arr2[k] == arr[j])
					b = true;
			}
			if (!a && i < arr.length)
				System.out.println(arr[i]);
			if (!b)
				System.out.println(arr2[k]);
		}
	}

	public static void arraySum(int arr[], int arr2[]) {
		int carry = 0, total = 0, j = 0, k = arr2.length - 1, i;
		List<Integer> sum = new ArrayList<>();

		for (i = arr.length - 1; i >= 0 && k >= 0; i--, k--) {

			total = arr[i] + arr2[k] + carry;
			carry = 0;
			if (total > 9) {
				carry = total % 10;
				total /= 10;
			}
			sum.add(total);

		}

		if (i < 0 && k >= 0) {
			for (int a = k; a >= 0; a--)
				sum.add(arr2[a]);
		}
		if (k < 0 && i >= 0) {
			for (int a = i; a >= 0; a--)
				sum.add(arr[a]);
		}
		Collections.reverse(sum);
		System.out.println(sum);
	}

	public static void arrayRightRotation(int arr[], int n) {
		int j = 0, count = 0;
		for (int i = 0; i < arr.length && count < n; i++) {
			int temp = arr[arr.length - 1];
			for (j = arr.length - 1; j > 0; j--) {
				arr[j] = arr[j - 1];
			}
			count++;
			arr[0] = temp;
		}
		for (int a : arr)
			System.out.print(a + ",");
	}

	public static void arrayLeftRotation(int arr[], int n) {
		int j = 0, count = 0;
		for (int i = 0; i < arr.length && count < n; i++) {
			int temp = arr[0];
			for (j = 0; j < arr.length - 1; j++) {
				arr[j] = arr[j + 1];
			}
			count++;
			arr[j] = temp;
		}
		for (int a : arr)
			System.out.print(a + ",");
	}

	public static boolean anagram(String s, String s1) {

		int count = 0;
		boolean b = false;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			count = 0;
			b = false;
			for (int k = 0; k < s.length(); k++) {
				if (ch == s.charAt(k))
					count++;
			}

			for (int j = 0; j < s1.length(); j++) {
				if (count > 0 && ch == s1.charAt(j))
					count--;
			}
			if (count == 0)
				b = true;
		}

		System.out.println(b ? "yes" : "no");
		return b;
	}

	public static int count(int i, int arr[]) {
		int count = 0;
		for (int a : arr) {
			if (a == i)
				count++;
		}
		System.out.println(count);
		return count;
	}

	public static void majorityElement(int arr[]) {
		int max = 0, count = 0;
		for (int i = 0; i < arr.length; i++) {
			count = count(arr[i], arr);
			if (count >= max && count > arr.length / 2)
				max = arr[i];

		}
		System.out.println(max);
	}

	public static void longestPolindrom(String s) {

		int first = 0, last = s.length() - 1, max = 0;
		for (int i = 0; i < s.length(); i++) {

			for (int j = s.length() - i; j >= 0; j--) {
				if (i < j && j < s.length())
					if (checkPolindrom(i, j + 1, s) && max < s.substring(i, j).length()) {

						max = s.substring(i, j + 1).length();
						first = i;
						last = j + 1;
					}
			}
			System.out.println("------");

		}
		System.out.println(s.substring(first, last));

	}

	public static boolean checkPolindrom(int f, int l, String s) {
		String st = s.substring(f, l);
		System.out.println(st + "444");
		return st.equals(new StringBuffer(st).reverse().toString());

	}

	public void spiralMatrix() throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int a[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int j = 0, k = 0, count = 0, max = 10 - 1;
		// int max=a.length*a.length-1;
		// System.out.println(a.length);

		for (int i = 0; i < a.length - i; i++) {

			if (count == max)
				break;

			for (j = i; j < a.length - i && count <= max; j++) {
				count++;
				System.out.println(a[k][j]);
			}
			j--;

			k++;
			while (k < a.length - i && count <= max) {
				System.out.println(a[k][j]);
				k++;
				count++;
			}
			k--;
			j--;

			while (j >= 0 && count <= max) {
				count++;
				System.out.println(a[k][j--]);
			}

			// k=i+1;
			if (k == a.length / 2 && j == a.length / 2)
				break;
			j++;
			while (k > i + 1 && count <= max) {
				System.out.println(a[--k][j]);
				count++;
			}

			k = i + 1;
			System.out.println("-----------------");
		}

	}

	public static ArrayList<Integer> findIndexes(int arr[], int sum) {
		boolean a = false;
		int f = 0, l = arr.length, s = 0;
		for (int i = 0; i < arr.length; i++) {
			s = 0;
			if (a)
				break;

			for (int j = i; j < arr.length; j++) {
				s += arr[j];
				if (s == sum) {
					f = i;
					l = j;
					a = true;
					break;
				}

			}
			System.out.println(s);
		}

		return a ? new ArrayList<Integer>(Arrays.asList(f, l)) : new ArrayList<Integer>(Arrays.asList(-1));
	}

	public int count(char a, String s) {
		class A {
			static int a;

			public void main() {
				System.out.println("hello");
			}
		}

		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == a)
				count++;
		}
		return count;
	}

	public static boolean isPresent(char a, int indx, String s) {
		for (int i = indx; i >= 0; i--) {
			if (s.charAt(i) == a)
				return true;
		}
		return false;
	}

	public static boolean isPresent(int a, int indx, int ar[]) {
		for (int i = indx; i >= 0; i--) {
			if (ar[i] == a)
				return true;
		}
		return false;
	}

	public static void fibonacci(int t1, int t2, int n) {
		if (n == 0)
			return;
		else {
			int t3 = t1 + t2;
			t1 = t2;
			t2 = t3;
			System.out.println(t3);
			fibonacci(t1, t2, n - 1);
		}

	}

	public static int factorial(int n) {
		if (n == 1)
			return 1;
		else
			n = n * factorial(n - 1);
		return n;

	}

	public static String removeSpaces(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ')
				sb.append(s.charAt(i));

		}
		return sb.toString();
	}

	public static int[] removeDuplicate(int[] a) {
		int arr[] = new int[a.length];
		int j = 0;
		for (int i = 0; i < a.length; i++) {
			if (!isPresent(a[i], i - 1, a))
				arr[j++] = a[i];
		}
		a = new int[j];
		System.out.println(j);
		for (int i = 0; i < j; i++)
			a[i] = arr[i];
		return a;
	}

	class C {
		static int a;
	}
}

class B {
	int a = 10;

	public String toString() {
		System.out.println("askfjal");
		return new String(this.a + "");
	}

	public void hello(int... a) {

	}
}
