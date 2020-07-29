import java.util.Scanner;

public class AppView {
	private static Scanner scanner=new Scanner(System.in);
	
	//생성자. 현 클래스에서 쓸일이 없음.
	private AppView()
	{
		
	}
	
	public static int inputCapacityOfCoinBag()
	{
		int capacity;
		System.out.print("? 동전 가방의 크기, 즉 가방에 들어갈 동전의 최대 개수를 입력하시오:");
		capacity=scanner.nextInt();
		return capacity;
	}
	
	public static int inputCoinValue()
	{
		int coinValue;
		System.out.print("? 동전의 값을 입력하시오:");
		coinValue=scanner.nextInt();
		return coinValue;
	}
	
	//입력 관련 공개함수
	public static int inputMenuNumber()
	{
		int menuNumber;
		System.out.print("? 수행하려고 하는 메뉴 번호를 선택하시오 (add: 1, remove: 2, search: 3, frequency: 4, exit: 9) :");
		menuNumber=scanner.nextInt();
		return menuNumber;
	}
		
	//출력 관련 공개 함수
	public static void output(String message) {
		System.out.print(message);
	}
	
	// 출력 관련 공개함수
	public static void outputLine(String message) {
		System.out.println(message);
	}
	
	
}
