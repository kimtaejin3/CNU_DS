package view;
import java.util.Scanner;

public class AppView {

	private static Scanner scanner=new Scanner(System.in);
	
	//The constructer should be "private"
	private AppView() {
		
	}
	
	//public OUTPUT methods
	public static void outputDebugMessage(String message) {
		
	}
	
	public static void outputLine(String message) {
		System.out.println(message);
	}
	
	public static void output(String message) {
		System.out.print(message);
	}
	
	public static int inputInteger() throws NumberFormatException{		
		//������ �ƴ� ����� ���� ó���� ������ ��: exception throws
		return Integer.parseInt(AppView.scanner.next());	
	}
}
