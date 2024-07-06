package com.cognifyz.randomPasswordGenerator;

import java.security.SecureRandom;
import java.util.Scanner;

public class RandomPasswordGenerator {
	//method for Generator Password
	private static String generatePassword(int length, boolean includeNo, boolean includeUpcase,
            boolean includeLocase, boolean includeSpChar)
	{
		SecureRandom random = new SecureRandom();
		StringBuilder password = new StringBuilder();
		
		
		String numbers = "0123456789";
		String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
		String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String specialCharacters = "!@#$%^&*()_-+=";

	
		StringBuilder validChars = new StringBuilder();
		if (includeNo) {
		validChars.append(numbers);
		}
		if (includeLocase) {
		validChars.append(lowercaseLetters);
		}
		if (includeUpcase) {
		validChars.append(uppercaseLetters);
		}
		if (includeSpChar) {
		validChars.append(specialCharacters);
		}
		
		
		for (int i = 0; i < length; i++) {
		int randomIndex = random.nextInt(validChars.length());
		password.append(validChars.charAt(randomIndex));
		}
		
		return password.toString();
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n ----->>> Welcome to Random Password Generator <<<----- \n");
		System.out.print("\tEnter the desired length of passward: ");
		int length = sc.nextInt();
		System.out.println();
		System.out.println(" \t-->Include the following type of character<-- \n");
		System.out.print("\t1. Numbers [0-9] (Yes/no) : ");
		boolean includeNo = sc.next().equalsIgnoreCase("yes");
		System.out.print("\t2. Uppercase letter [A-Z] (Yes/no) : ");
		boolean includeUpcase = sc.next().equalsIgnoreCase("yes");
		System.out.print("\t3. Lowercase letter [a-z] (Yes/no) : ");
		boolean includeLocase = sc.next().equalsIgnoreCase("yes");
		System.out.print("\t4. Special Characters [!@#$%^&*()_-+=] (Yes/no) : ");
		boolean includeSpChar = sc.next().equalsIgnoreCase("yes");
		
		if (!includeNo && !includeUpcase && !includeLocase && !includeSpChar) {
            System.out.println("\n\tError: You must include at least one type of characters.");
            return;
        }

        String password = generatePassword(length, includeNo, includeUpcase, includeLocase, includeSpChar);

        System.out.println("\n\tGenerated Password: " + password);

	}

}
