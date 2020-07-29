package view;

import java.util.Scanner;

public class AppView {
	private static Scanner scanner=new Scanner(System.in);
	
	//������
	public AppView() {
		
	}
	
	//����Լ�
	public static void output(String aMessage)
	{
		System.out.print(aMessage);
	}
	
	public static void outputLine(String aMessage)
	{
		System.out.println(aMessage);
	}
	
	public static void outputNumberOfStudents(int aStudentNumber) {
		AppView.outputLine("�б� �л� ��: "+aStudentNumber);
	}
	
	
	public static void outputHighestScore(int aScore)
	{
		AppView.outputLine("�б� �ְ� ����: "+aScore);
	}
	
	public static void outputLowestScore(int aScore)
	{
		AppView.outputLine("�б� ���� ����: "+aScore);
					
	}
	
	public static void outputAverageScore(double anAverageScore)
	{
		AppView.outputLine("�б� ���: "+anAverageScore);	
	}
	
	public static void ouputNumberOfStudentsAboveAverage(int aNumberOfStudents)
	{
		AppView.outputLine("��� �̻��� �л� ��: "+aNumberOfStudents);	
	}
	
	public static void outputNumberOfStudents(char grade, int gradeCount) {
		AppView.outputLine(grade+" ������ �л� ���� "+gradeCount+" �Դϴ�.");
	}
		
	public static void outputStudent(String aStudentID, int aScore) {
		AppView.outputLine("�й�:"+aStudentID+", ����:"+aScore);
	}
	
	public static void outputStudentInfo(String aStudentID, int aScore, char aGrade) {
		AppView.outputLine("�й�:"+aStudentID+", ����:"+aScore+" , ����:"+aGrade);
	}
	
	//�Է��Լ�
	public static int inputInt() throws NumberFormatException {
		return Integer.parseInt(AppView.scanner.nextLine());
	}
	
	public static int inputScore() {
		while(true) {
			try {
				AppView.output("- ������ �Է��Ͻÿ�:");
				
				int score=AppView.inputInt();
				return score;
			} catch (Exception e) {
				AppView.outputLine("(����) ������ �Էµ��� �ʾҽ��ϴ�.");
			}
		}
	}
	
	public static String inputStudentID() {
		
		AppView.output("- �й��� �Է��Ͻÿ�:");
		String studentID=AppView.scanner.nextLine();
		return studentID;
	}
	
	public static boolean doesContinueToInputStudent() {
		AppView.output("\n? �л������� �Է��Ϸ��� 'Y' �Ǵ� 'y'��, �����Ϸ��� �ٸ� �ƹ�Ű�� ġ�ÿ�: ");
		String line=null;
	 
		do {
		line=AppView.scanner.nextLine();
		
		}while(line.equals(""));    
	//	char answer=AppView.scanner.nextLine().charAt(0);-> �̷��� �ڵ��ϸ� ���Է��� ����� ���� ����.
		char answer=line.charAt(0);
		return ((answer=='Y')||(answer=='y'));
	}
}
