package model;

public class Student implements Comparable<Student>{
	
	//Constants
	private static final int DEFAULT_SCORE=0;
	
	//private instance variables
	private int _score;
	
	//Getters/Setters
	public int score() {
		return this._score;
	}
	
	public void setScore(int newScore) {
		this._score=newScore;
	}
	
	//Construct
	public Student() {
		this.setScore(Student.DEFAULT_SCORE);
	}
	
	public Student(int givenScore) {
		this.setScore(givenScore);
	}
	
	public boolean equals(Object aStudent) {
		if(aStudent.getClass()!=Student.class) {
			return false;
		}
		else {
			return (this.score()==((Student)aStudent).score());
		}
	}
	
	@Override
	public int compareTo(Student aCoin) {
		if ( this.score() < aCoin.score() ) {
			return -1;
		}
		else if (this.score() > aCoin.score() ) {
			return +1 ;
		}
		else {
			return 0 ;
		}
	}
}
