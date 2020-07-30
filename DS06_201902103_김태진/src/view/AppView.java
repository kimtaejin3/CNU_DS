package view;

public class AppView {

	
	//The Constructor should be "private"
	private AppView() {}
	
	//public OUTPUT methods
	
	public static void outputLine(String message) {
		System.out.println(message);
	}
	
	public static void output(String message) {
		System.out.print(message);
	}
	
	public static void outputResults(int size, long durationForAdd, long durationForMax)
	{
		AppView.outputLine (
		"[ũ��: " + String.format("%5d", size) + "] " +
		"����: " + String.format("%8d", durationForAdd) + ", " +
		"�ִ밪: " + String.format("%8d", durationForMax)
		) ;
	}

	
}
