package com.pb.action;

import java.util.Base64;

public class AAA {

	public static void main(String[] args) {
		String abc = Base64.getEncoder().encodeToString("123456".getBytes());
		System.out.println(abc);
	}

}
