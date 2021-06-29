package com.example.how_to_use_ramda_and_stream.vo;

import lombok.Data;

@Data
public class Student {
	String name;

	int age;

	String grade;

	public Student(Person person) {
		this.name=person.getName();
		this.age=person.getAge();
	}
}
