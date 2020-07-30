package view;

import java.util.Scanner;

public class AppView {
	
	private static Scanner scanner=new Scanner(System.in);
	
	// �����Լ��� ����
	// ����� ���� �����Լ�
	public static void output(String aMessage) {
		System.out.print(aMessage);
	}
	
	public static void outputLine(String aMessage) {
		System.out.println(aMessage);
	}
	
	// �Է��� ���� �����Լ�
	public static char inputChar() {
		String line=AppView.scanner.nextLine().trim();
		
		while(line.equals("")) {
			line=AppView.scanner.nextLine().trim();
		}
		return line.charAt(0);
	}
}
