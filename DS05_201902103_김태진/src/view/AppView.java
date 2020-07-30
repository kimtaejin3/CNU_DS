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
		//정수가 아닌 경우의 에러 처리를 보완할 것: exception throws
		return Integer.parseInt(AppView.scanner.next());	
	}
}
