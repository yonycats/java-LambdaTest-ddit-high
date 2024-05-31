package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T03LambdaTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("김민강");
		list.add("이현수");
		list.add("권기혁");
		
		// 리스트를 출력하는 방법 1
		for (String str : list) {
			System.out.println(str);
		}
		
		System.out.println("--------------------------");
		
		// 리스트를 출력하는 방법 2
		// T02LambdaTest 참고
		list.forEach(name -> System.out.println(name));
		
		
		
		/////////////////////////////////////

		list.forEach(System.out::println); // 메서드 참조
		
		/////////////////////////////////////
		
		/* 
		   메서드 참조의 일반적인 형태
		   
		   참조변수::인스턴스메서드명
		   클래스명::정적메서드명
		   클래스명::인스턴스메서드명
		   생성자명::new   
		*/	
		
		MyPrint mp = new MyPrint();
		
		System.out.println("참조변수::인스턴스메서드명 ...");
		list.forEach(mp::printName);
		
		System.out.println("클래스명::정적메서드명 ...");
		list.forEach(MyPrint::printName2);
		
		System.out.println("생성자명::new  ...");
		list.forEach(MyPrint::new);
		
		
		
	}
}


class MyPrint {
	public MyPrint() {
	}
	
	public MyPrint(String name) {
		System.out.println("생성자에서 출력함... : " + name);
	}
	
	public void printName(String name) {
		System.out.println("name : " + name);
	}
	
	public static void printName2(String name) {
		System.out.println("name2 : " + name);
	}
}

















