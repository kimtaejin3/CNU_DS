package model;

public class Student implements Comparable<Student>{

	//constants
	private static final int DEFAULT_SCORE=0;
	
	//private instance
	private int _score;
	private String _studentId;
	private char _grade;
	
	//getters and setters
	public int score() {
		return this._score;
	}
	
	public void setScore(int newScore) {
		this._score=newScore;
	}
	
	public char grade() {
		return this._grade;
	}
	
	public void setGrade(char newGrade) {
		this._grade=newGrade;
	}
	
	public void setStudentId(String newStudentId) {
		this._studentId=newStudentId;
	}
	
	public String studentId() {
		return this._studentId;
	}
	
	//Constructor
	public Student() {
		this.setScore(DEFAULT_SCORE);
	}
	
	public Student(int givenScore) {
		this.setScore(givenScore);
	}
	
	@Override
	public int compareTo(Student other) {
		if(this.score()<other.score()) {
			return -1;
		}
		else if(this.score()==other.score()) {
			return 0;
		}
		else {
			return 1;
		}
	}
	
}
