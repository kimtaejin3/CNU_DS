package view;

import java.util.Scanner;

public class AppView {
	
	private static Scanner scanner=new Scanner(System.in);
	
	// 공개함수의 구현
	// 출력을 위한 공개함수
	public static void output(String aMessage) {
		System.out.print(aMessage);
	}
	
	public static void outputLine(String aMessage) {
		System.out.println(aMessage);
	}
	
	// 입력을 위한 공개함수
	public static char inputChar() {
		String line=AppView.scanner.nextLine().trim();
		
		while(line.equals("")) {
			line=AppView.scanner.nextLine().trim();
		}
		return line.charAt(0);
	}
}
