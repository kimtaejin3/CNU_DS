import java.util.Scanner;

public class AppView {
	private static Scanner scanner=new Scanner(System.in);
	
	public static int inputCoinValue()
	{
		int coinValue;
		System.out.print("? ������ ���� �Է��Ͻÿ�:");
		coinValue=scanner.nextInt();
		return coinValue;
	}
	
	//�Է� ���� �����Լ�
	public static int inputMenuNumber()
	{
		int menuNumber;
		System.out.print("\n? �����Ϸ��� �ϴ� �޴� ��ȣ�� �����Ͻÿ� (add: 1, remove: 2, search: 3, frequency: 4, exit: 9) :");
		menuNumber=scanner.nextInt();
		return menuNumber;
	}
		
	//��� ���� ���� �Լ�
	public static void output(String message) {
		System.out.print(message);
	}
	
	// ��� ���� �����Լ�
	public static void outputLine(String message) {
		System.out.println(message);
	}
	
	
}
