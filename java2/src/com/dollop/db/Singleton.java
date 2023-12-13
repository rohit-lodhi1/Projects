package com.dollop.db;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// time conversion

//class Singleton{
//	
//	 public static void main(String[]args) {
//		 String s="12:05:45PM";
//	   System.out.println(timeConvert(s));
//	 }
//
//	private static String timeConvert(String s) {
//      String hr= s.substring(0,2);
//      
//      if(s.contains("AM") && hr.equals("12")) {
//    	   hr="00";
//      }
//      if(s.contains("PM")) {
//    	  int h = Integer.parseInt(hr);
//         if(h!=12)
//    	  h+=12;
//    	  hr=Integer.toString(h);
//      }
//      String time = hr+s.substring(2,8);
//return time;
//	}
//}
//
//class Singleton{
//	public static void main(String[] args) {
//		List<Integer> l = new ArrayList<>();
//		l.add(71);
//		l.add(67);
//		l.add(38);
//		l.add(33);
//		grades(l);
//	}
//	public static void grades(List<Integer> l) {
//		List<Integer> finl= new ArrayList<>();
//		for(int i=0;i<l.size();i++) {
//			if(l.get(i)<34) {
//				finl.add(l.get(i));
//			}
//			else if(l.get(i)>33){
//				
//				 int pl = l.get(i);
//				 while(pl%5!=0) {
//					 pl++;
//				 }
//				 if(pl-l.get(i)<3)
//			    	 finl.add(pl);
//				 else if(pl-l.get(i)>=3)
//					 finl.add(l.get(i));
//			}
//			
//		}
//		System.out.println(finl);
//	}
////}
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


interface  Hello{
	static  int h=0;
	public int hel(int a,int b);
	public static int sort() {
		System.out.println("hello");
		return 0;
	}
	
}
class BubbleSort{
	public static int sum(int a,int b) {
		return a+b;
	}
}

public class Singleton{
	&nbsp;static int i =0;
	
	public static void main(String[] args) {
		
		
		List<Integer>li = List.of(1,2,3,4,5,6);
		
		
//		Hello h = (a,b)->{
//			return a+b;
//		};
//		System.out.println(h.hel(10, 20));
		
		// ------ Stream Api------
		                  
		                        //-- Lambda expression  --collect is used to collect the filtered elements
  //   li=(List) li.stream().filter(i->i%2==0).collect(Collectors.toList());
   //  System.out.println(li);
		
	//	
	// -- to convert list to stream
//		Stream stream=li.stream();
//		stream.forEach(System.out::print);
// 
		String[] str = {"bnkit","callow","dallow","aallow"};
//		
		Stream<String> stream = Stream.of(str);
                stream=stream.sorted();
		stream.forEach(e->{
			str[i++]=e;
			
		});
		for(String s:str)
              System.out.println(s);
    	                                                 
//		
//		List<String> list= List.of("abc","aab","abb","bca","aaa");
//             //  list = list.stream().filter(e->e.startsWith("A")||e.startsWith("a")).collect(Collectors.toList());
//               System.out.println(list);
//               
//               Stream<String> stream=list.stream().sorted();
//                list=stream.toList();
//               Comparator<String> com = new Comparator<String>() {
//
//				@Override
//				public int compare(String o1, String o2) {
//					if(o1.charAt(0)>o2.charAt(0))
//						return -1;
//					if(o1.charAt(0)<o2.charAt(0))
//						return 1;
//				  return 0;
//				}   
//			};
//               Stream<String> stream=list.stream().sorted(com);
//             list=stream.toList();
//                System.out.println(list);
//            
//                Hello h = BubbleSort::sum;
//            System.out.println(h.hel(10, 30));
//            
  //              System.out.println(Hello.h=1);
               
               
	}
}