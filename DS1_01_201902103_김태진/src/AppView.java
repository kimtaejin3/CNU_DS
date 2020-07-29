import java.util.Scanner;

public class AppView {
	
	private static Scanner sc=new Scanner(System.in);
	
	/*�Է°� ���*/
	public static int inputOrder() {
		return sc.nextInt();
	}
	
	/*���� ���ڰ� ���Ե��� ����.*/
	public static void output(String message)
	{
		System.out.print(message);
	}
	
	/*���� ���ڰ� ���Ե�.*/
	public static void outputLine(String message)
	{
		System.out.println(message);
	}
	
	/*�������� ������ ������ ���*/
	public static void outputTitleWithOrder(int order)
	{
		System.out.println("!Magic Square Board: Order "+order);
	}
	/* �࿡ ������ �ε����� ����Ѵ�. */
	public static void outputRowNumber(int number)
	{
		System.out.printf("[%3d] ", number);
	}
	
	public static void outputCellValue(int value)
	{
		/*columnIndex�� ������ ���߷��� �� �տ� 2���� ���� �� �ڿ� 1���� ������ �ش�.*/
		System.out.printf("  %4d ", value);
	}
}
