package view;

import java.util.Scanner;

public class AppView {
	
	private static Scanner scanner=new Scanner(System.in);
	private static boolean debugMode=false;
	public AppView() {}
	
	public static boolean debugMode() {
		return AppView.debugMode;
	}
	
	public static void setDebugMode(boolean newDebugMode) {
		AppView.debugMode=newDebugMode;
	}
	
	public static void outputDebugMessage(String aMessage)
	{
		if(AppView.debugMode()) {
			System.out.print(aMessage);
		}
	}
	
	public static void outputLineDebugMessage(String aMessage)
	{
		if(AppView.debugMode()) {
			System.out.println(aMessage);
		}
	}
	
	public static void output(String aMessage)
	{
		System.out.print(aMessage);
	}
	
	public static void outputLine(String aMessage)
	{
		System.out.println(aMessage);
	}
	
	public static String inputLine() {
		String line=AppView.scanner.nextLine().trim();
		while(line.equals("")) {
			line=AppView.scanner.nextLine().trim();
		}
		return line;
	}
	
}
