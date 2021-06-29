package com.example.how_to_use_ramda_and_stream;

import com.example.how_to_use_ramda_and_stream.vo.Person;
import com.example.how_to_use_ramda_and_stream.vo.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.how_to_use_ramda_and_stream.vo.Person.Gender.man;

@SpringBootApplication
public class HowToUseRamdaAndStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(HowToUseRamdaAndStreamApplication.class, args);

		//stream 예시
		List<String> strList = Arrays.asList("a", "b", "c", "d");
		Boolean isEqualC = false;
		// 기존에 List와 같은 Collection류의 객체 내부 데이터를 순회하는 방법
		for (String str : strList) {
			if (str.equals("c")) {
				System.out.println("c");
			}
		}

		// JDK 1.8부터 도입된 Stream을 이용한 데이터 순회 방식
		//Iterator 를 통한 일반적인 사용
		strList.stream()
				.filter(x -> x.equals("c"))
				.forEach(name -> System.out.println(name));

		List ages = new ArrayList();

		ages.add(1);
		ages.add(2);
		ages.add(3);

		Object result = ages.stream().reduce((b, c) -> (int) b + (int) c).get();
		System.out.println(result);

		/*람다와 스트림을 통해 원하는 값만 추출*/
		List<Person> people = new ArrayList<>();

		Person person1 = new Person();

		person1.setName("한신");
		person1.setAge(25);
		person1.setGender(man);
		person1.setMoney(1000);

		people.add(person1);

		Person person2 = new Person();
		person2.setName("한신1");
		person2.setAge(25);
		person2.setGender(man);
		person2.setMoney(9000);

		people.add(person2);

		List<Student> list = people.stream()
				.map(p -> new Student(p))
				.collect(Collectors.toList());

		System.out.println(list);
	}

	//TODO 람다 표현식을 간단히 정의하면 메서드를 하나의 식으로 표현한 것.
	public int add(int a, int b) {
		return a + b;
	}
// 위의 메서드를 람다 표현식으로 나타내면 아래와 같다.
//		(a, b) -> a + b;
}
