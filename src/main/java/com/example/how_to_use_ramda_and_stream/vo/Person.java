package com.example.how_to_use_ramda_and_stream.vo;

import lombok.Data;

@Data
public class Person {

	String name;

	int age;

	Gender gender;

	int money;

	public enum Gender {
		man, women
	}

}
