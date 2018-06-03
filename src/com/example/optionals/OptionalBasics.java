package com.example.optionals;

import java.util.Optional;

public class OptionalBasics {

	public OptionalBasics() {

		final Optional<String> maleOptional = Optional.of("Male");
		final String answer1 = "Yes";
		final String answer2 = null;

		System.out.println("Print non empty optional " + maleOptional);
		System.out.println("Value of male optional " + maleOptional.get());
		System.out.println("Empty optional " + Optional.empty());

		// is present returns true or false
		Optional<String> optionalWithoutNullable = Optional.ofNullable(answer1);
		if (optionalWithoutNullable.isPresent())
			System.out.println(optionalWithoutNullable.get());

		Optional<String> ofNullable2 = Optional.ofNullable(answer2);
		if (ofNullable2.isPresent())
			System.out.println(ofNullable2.get());
		// if present executes a method provided the value is present in the optional
		optionalWithoutNullable.ifPresent(val -> System.out.println("value is present " + val));
		
		System.out.println("Test orElse with maleOptional, value " + maleOptional.orElse("N/A"));
		System.out.println("Test orElse with optionalOfNullable, value " + ofNullable2.orElse("N/A"));
		
		//optionalorget method, called if optional is nullable
		System.out.println("Testing orElseGet with empty nullable "+ ofNullable2.orElseGet(() -> "N/A"));
//		maleOptional.flatMap(s -> s.toUpperCase());
	}

	public static void main(final String[] args) {
		new OptionalBasics();
	}

}
