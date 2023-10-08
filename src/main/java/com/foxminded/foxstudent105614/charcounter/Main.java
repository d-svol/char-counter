package com.foxminded.foxstudent105614.charcounter;

public class Main {
	public static void main(String[] args) {
		Logic logic = new Logic();
        logic.logica("");
        String out = new PrettyPrinter().print(logic);
        System.out.println(out);
	}
}

