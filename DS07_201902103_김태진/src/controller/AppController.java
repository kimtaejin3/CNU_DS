package controller;

import model.Ban;
import model.GradeCounter;
import model.Iterator;
import model.Student;
import view.AppView;

public class AppController {

	private static final int VALID_MAX_SCORE=100;
	private static final int VALID_MIN_SCORE=0;
	
	private static final int BAN_CAPACITY=10;
	
	private Ban _ban;
	private GradeCounter _gradeCounter;
	
	private Ban ban() {
		return this._ban;
	}
	
	private void setBan(Ban newBan) {
		this._ban=newBan;
	}
	
	private GradeCounter gradeCounter() {
		return this._gradeCounter;
	}
	
	private void setGradeCounter(GradeCounter newGradeCounter) {
		this._gradeCounter=newGradeCounter;
	}
	
	private static boolean scoreIsValid(int aScore) {
		return (aScore>=VALID_MIN_SCORE&&aScore<=VALID_MAX_SCORE);
	}
	
	private static Student inputStudent() {
		int score=AppView.inputScore();
		while(!AppController.scoreIsValid(score)) {
			AppView.outputLine("[����]"+AppController.VALID_MIN_SCORE+" ���� �۰ų� "+AppController.VALID_MAX_SCORE+" ���� Ŀ��, �������� ������ �ƴմϴ�.");
			score=AppView.inputScore();
		}
		Student student=new Student();
		student.setScore(score);
		return student;
	}
	
	private void inputAndStoreStudnets() {
		AppView.outputLine("");
		boolean storingAStudentWasSuccessful=true;
		while(storingAStudentWasSuccessful&&AppView.doesContinueToInputStudent()) {
			Student student=AppController.inputStudent();
			if(!this.ban().add(student)) {
				AppView.outputLine("(���) �Է¿� ������ �ֽ��ϴ�. �б޿� ���̻� �л��� ���� ������ �����ϴ�.");
				storingAStudentWasSuccessful=false;
			}
		}
		AppView.outputLine("! ���� �Է��� ��Ĩ�ϴ�.");
	}
	
	private void showStatistics() {
		AppView.outputLine("");
		AppView.outputLine("[�б� ���� ���]");
		
		AppView.outputNumberOfStudents(this.ban().size());
		AppView.outputHighestScore(this.ban().highest().score());
		AppView.outputLowestScore(this.ban().lowest().score());
		AppView.outputAverageScore(this.ban().average());
		AppView.ouputNumberOfStudentsAboveAverage(this.ban().numberOfStudentsAboveAverage());
	}
	
	private void showGradeCounts() {
		AppView.outputLine("");
		AppView.outputLine("[�л��� �л���}");
		
		this.setGradeCounter(this.ban().countGrades());
		AppView.outputNumberOfStudents('A',this.gradeCounter().numberOfA());
		AppView.outputNumberOfStudents('B',this.gradeCounter().numberOfB());
		AppView.outputNumberOfStudents('C',this.gradeCounter().numberOfC());
		AppView.outputNumberOfStudents('D',this.gradeCounter().numberOfD());
		AppView.outputNumberOfStudents('F',this.gradeCounter().numberOfF());
	}
	
	private void showStudentsSortedByScore() {
		AppView.outputLine("");
		AppView.outputLine("[�л����� ������ ���}");
		
		this.ban().sortByScore();
		
		Iterator<Student> iterator=this.ban().iterator();
		
		Student student=null;
		while(iterator.hasNext()){
			student=iterator.next();
			AppView.outputScore(student.score());
		}
	}
	public void run() {
		
		AppView.outputLine("");
		AppView.outputLine("<<< �б� ���� ó���� �����մϴ� >>>");
		
		this.setBan(new Ban(AppController.BAN_CAPACITY));
		this.inputAndStoreStudnets();
		
		if(this.ban().isEmpty()) {
			AppView.outputLine("");
			AppView.outputLine("(���) �Էµ� ������ �����ϴ�.");
		}
		else {
			this.showStatistics();
			this.showGradeCounts();
			this.showStudentsSortedByScore();
		}
		AppView.outputLine("\n<<< �б� ���� ó���� �����մϴ� >>>");
		
	}
	
}
