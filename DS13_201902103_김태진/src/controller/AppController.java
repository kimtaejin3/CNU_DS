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
			AppView.outputLine("[오류] 학번의 길이가 너무 깁니다. 최대 9 입니다.");	
			error=0;
		}
		if(!AppController.scoreIsValid(score)) {
			AppView.outputLine("[오류]"+AppController.VALID_MIN_SCORE+" 보다 작거나 "+AppController.VALID_MAX_SCORE+" 보다 커서, 정상적인 점수가 아닙니다.");
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
				AppView.outputLine("(경고) 입력에 오류가 있습니다. 학급에 더이상 학생을 넣을 공간이 없습니다.");
				storingAStudentWasSuccessful=false;
			}
			
		}
		AppView.outputLine("! 성적 입력을 마칩니다.");
		return true;
	}
	
	private void showStatistics() {
		AppView.outputLine("");
		AppView.outputLine("[학급 성적 처리 결과]");
		
		AppView.outputNumberOfStudents(this.ban().size());
		AppView.outputHighestScore(this.ban().highest().score());
		AppView.outputLowestScore(this.ban().lowest().score());
		AppView.outputAverageScore(this.ban().average());
		AppView.ouputNumberOfStudentsAboveAverage(this.ban().numberOfStudentsAboveAverage());
	}
	
	private void showGradeCounts() {
		AppView.outputLine("");
		AppView.outputLine("[학점별 학생수}");
		
		this.setGradeCounter(this.ban().countGrades());
		AppView.outputNumberOfStudents('A',this.gradeCounter().numberOfA());
		AppView.outputNumberOfStudents('B',this.gradeCounter().numberOfB());
		AppView.outputNumberOfStudents('C',this.gradeCounter().numberOfC());
		AppView.outputNumberOfStudents('D',this.gradeCounter().numberOfD());
		AppView.outputNumberOfStudents('F',this.gradeCounter().numberOfF());
	}
	
	private void showStudentAll() {
		AppView.output("\n");
		AppView.outputLine("[학생목록]");
		
		Iterator<DictionaryElement<String,Student>> iterator=this.ban().iterator();
		
		Student student=null;
		while(iterator.hasNext()){
			student=iterator.next().object();
			AppView.outputStudent(student.studentId(),student.score());
		}
	}
	
	private void showStudentsSortedByScore() {
		AppView.outputLine("");
		AppView.outputLine("[학생들의 성적순 목록}");
		
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
		AppView.outputLine("<<< 학급 성적 처리를 시작합니다 >>>");
		
		
		this.setBan(new Ban());
		boolean inuputAndStoreWasSuccessful=this.inputAndStoreStudnets();
		
		if(inuputAndStoreWasSuccessful) {
		if(this.ban().isEmpty()) {
			AppView.outputLine("");
			AppView.outputLine("(오류) 학생의 정보가 전혀 입력되지 않았습니다.");
		}
		else {
			this.showStudentAll();
			this.showStatistics();
			this.showGradeCounts();
			this.showStudentsSortedByScore();
		}
		
		AppView.outputLine("\n<<< 학급 성적 처리를 종료합니다 >>>");
		}
	}
	
}
