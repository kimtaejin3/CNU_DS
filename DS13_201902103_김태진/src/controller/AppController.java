package controller;

import model.Ban;
import model.DictionaryElement;
import model.GradeCounter;
import model.Iterator;
import model.Student;
import view.AppView;

public class AppController {

	private static final int VALID_MAX_SCORE=100;
	private static final int VALID_MIN_SCORE=0;
	
	
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
	
	private static boolean studentIdIsValid(String aStudentId) {
		return (aStudentId.length()<=9);
	}
	
	private static Student inputStudent() {
		
		String studentId=AppView.inputStudentID();
		int score=AppView.inputScore();
		int error=1;
		if(!AppController.studentIdIsValid(studentId)) {
			AppView.outputLine("[����] �й��� ���̰� �ʹ� ��ϴ�. �ִ� 9 �Դϴ�.");	
			error=0;
		}
		if(!AppController.scoreIsValid(score)) {
			AppView.outputLine("[����]"+AppController.VALID_MIN_SCORE+" ���� �۰ų� "+AppController.VALID_MAX_SCORE+" ���� Ŀ��, �������� ������ �ƴմϴ�.");
			error=0;
		}
		if(error==0) {
			return null;
		}
		char grade=Ban.scoreToGrade(score);
		Student student=new Student();
		student.setScore(score);
		student.setStudentId(studentId);
		student.setGrade(grade);
		return student;
	}
	
	private boolean inputAndStoreStudnets() {
		AppView.outputLine("");
		boolean storingAStudentWasSuccessful=true;
		while(storingAStudentWasSuccessful&&AppView.doesContinueToInputStudent()) {
			Student student=AppController.inputStudent();
			if(student==null) {continue;}
			if(!this.ban().addKeyAndObject(student.studentId(),student)) {
				AppView.outputLine("(���) �Է¿� ������ �ֽ��ϴ�. �б޿� ���̻� �л��� ���� ������ �����ϴ�.");
				storingAStudentWasSuccessful=false;
			}
			
		}
		AppView.outputLine("! ���� �Է��� ��Ĩ�ϴ�.");
		return true;
	}
	
	private void showStatistics() {
		AppView.outputLine("");
		AppView.outputLine("[�б� ���� ó�� ���]");
		
		AppView.outputNumberOfStudents(this.ban().size());
		AppView.outputHighestScore(this.ban().highest().score());
		AppView.outputLowestScore(this.ban().lowest().score());
		AppView.outputAverageScore(this.ban().average());
		AppView.ouputNumberOfStudentsAboveAverage(this.ban().numberOfStudentsAboveAverage());
	}
	
	private void showGradeCounts() {
		AppView.outputLine("");
		AppView.outputLine("[������ �л���}");
		
		this.setGradeCounter(this.ban().countGrades());
		AppView.outputNumberOfStudents('A',this.gradeCounter().numberOfA());
		AppView.outputNumberOfStudents('B',this.gradeCounter().numberOfB());
		AppView.outputNumberOfStudents('C',this.gradeCounter().numberOfC());
		AppView.outputNumberOfStudents('D',this.gradeCounter().numberOfD());
		AppView.outputNumberOfStudents('F',this.gradeCounter().numberOfF());
	}
	
	private void showStudentAll() {
		AppView.output("\n");
		AppView.outputLine("[�л����]");
		
		Iterator<DictionaryElement<String,Student>> iterator=this.ban().iterator();
		
		Student student=null;
		while(iterator.hasNext()){
			student=iterator.next().object();
			AppView.outputStudent(student.studentId(),student.score());
		}
	}
	
	private void showStudentsSortedByScore() {
		AppView.outputLine("");
		AppView.outputLine("[�л����� ������ ���}");
		
		this.ban().studentsSortedByScore();
		
		Iterator<DictionaryElement<String,Student>> iterator=this.ban().iterator();
		
		Student student=null;
		while(iterator.hasNext()){
			student=iterator.next().object();
			AppView.outputStudentInfo(student.studentId(),student.score(),student.grade());
		}
	}
	public void run() {
		
		AppView.outputLine("");
		AppView.outputLine("<<< �б� ���� ó���� �����մϴ� >>>");
		
		
		this.setBan(new Ban());
		boolean inuputAndStoreWasSuccessful=this.inputAndStoreStudnets();
		
		if(inuputAndStoreWasSuccessful) {
		if(this.ban().isEmpty()) {
			AppView.outputLine("");
			AppView.outputLine("(����) �л��� ������ ���� �Էµ��� �ʾҽ��ϴ�.");
		}
		else {
			this.showStudentAll();
			this.showStatistics();
			this.showGradeCounts();
			this.showStudentsSortedByScore();
		}
		
		AppView.outputLine("\n<<< �б� ���� ó���� �����մϴ� >>>");
		}
	}
	
}
