package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T03LambdaTest {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		list1.add("김민강");
		list1.add("이현수");
		list1.add("권기혁");
		
		// 리스트를 출력하는 방법 1
		for (String str : list1) {
			System.out.println(str);
		}
		
		System.out.println("--------------------------");
		
		// 리스트를 출력하는 방법 2
		// T02LambdaTest 참고 (lam5)
		
		/* 자바 ::더블콜론 이란?
		메소드 레퍼런스라고도 불린다. 자바8 버전에서 소개되었다. 람다식과 똑같은 기능을 한다.
		람다식과 차이점이 있다면 인스턴스를 활용하여 메소드를 전달하는데에 있다.
		
		list.forEach(item -> System.out.println(item));
		=> list.forEach(System.out::println);
		
		자바의 더블콜론은 위 람다식을 아래와 같이 더욱 간결하게 해준다
		즉 람다식이 이미 존재하는 메소드와 동일한 기능이면 메소드 레퍼런스로 람다식을 대체할 수 있다.
		
		2. 더블콜론의 사용처
		사용하는 람다식이 기존에 있는 인스턴스의 메소드와 동일하면 메소드 레퍼런스로 대체 가능하다
		스태틱 메소드, 인스턴스의 메소드의 메소드 레퍼런스로 사용가능하다
		*/
		
		list1.forEach(name -> System.out.println(name));
		System.out.println("--------------------------");
		
		list1.forEach(System.out::println); // 메서드 참조
		System.out.println("--------------------------");
		
		
		
		/* 
		   메서드 참조의 일반적인 형태
		   
		   참조변수::인스턴스메서드명
		   클래스명::정적메서드명
		   클래스명::인스턴스메서드명
		   생성자명::new   
		*/	
		
		MyPrint mp = new MyPrint();
		
		System.out.println("참조변수::인스턴스메서드명 ...");
		list1.forEach(mp::printName);
		
		System.out.println("클래스명::정적메서드명 ...");
		list1.forEach(MyPrint::printName2);
		
		System.out.println("생성자명::new  ...");
		list1.forEach(MyPrint::new);
		
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
