import java.util.Scanner;

public class AppView {
	
	private static Scanner sc=new Scanner(System.in);
	
	/*입력과 출력*/
	public static int inputOrder() {
		return sc.nextInt();
	}
	
	/*개행 문자가 포함되지 않음.*/
	public static void output(String message)
	{
		System.out.print(message);
	}
	
	/*개행 문자가 포함됨.*/
	public static void outputLine(String message)
	{
		System.out.println(message);
	}
	
	/*마방진의 차수가 얼마인지 출력*/
	public static void outputTitleWithOrder(int order)
	{
		System.out.println("!Magic Square Board: Order "+order);
	}
	/* 행에 마방진 인덱스를 출력한다. */
	public static void outputRowNumber(int number)
	{
		System.out.printf("[%3d] ", number);
	}
	
	public static void outputCellValue(int value)
	{
		/*columnIndex와 정렬을 맞추려면 값 앞에 2개의 공백 값 뒤에 1개의 공백을 준다.*/
		System.out.printf("  %4d ", value);
	}
}
