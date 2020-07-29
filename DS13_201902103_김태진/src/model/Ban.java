package model;

public class Ban extends DictionaryByBinarySearchTree<String,Student>{
	
	private int sum=0;
	
	public static char scoreToGrade(int aScore)
	{
		if(aScore>=90) {
			return 'A';
		}
		else if(aScore>=80) {
			return 'B';
		}
		else if(aScore>=70) {
			return 'C';
		}
		else if(aScore>=60) {
			return 'D';
		}
		else{
			return 'F';
		}
	}
	
	public Ban() {
		super();
	}
	
	private DictionaryElement<String,Student> lowestRecursively(BinaryNode<DictionaryElement<String,Student>> aRoot) {
	
		DictionaryElement<String,Student> lowest= aRoot.element();
		if(aRoot.left()!=null) {
			DictionaryElement<String,Student> lowestOfLeftSubtree=this.lowestRecursively(aRoot.left());
			if(lowestOfLeftSubtree.object().score()<lowest.object().score()) {
				lowest=lowestOfLeftSubtree;
			}
		}
		
		if(aRoot.right()!=null) {
			DictionaryElement<String,Student> lowestOfRightSubtree=this.lowestRecursively(aRoot.right());
			if(lowestOfRightSubtree.object().score()<lowest.object().score()) {
				lowest=lowestOfRightSubtree;
			}
		}
		return lowest;
	}
	
	public Student lowest() {
		if(this.isEmpty()) {
			return null;
		}
		else {

			DictionaryElement<String,Student> lowest=this.lowestRecursively(this.root());
			return lowest.object();
		}
	}
	
	private DictionaryElement<String,Student> highestRecursively(BinaryNode<DictionaryElement<String,Student>> aRoot) {
		
		DictionaryElement<String,Student> highest=aRoot.element();
		
		if(aRoot.left()!=null) {
			DictionaryElement<String,Student> lowestOfLeftSubtree=this.lowestRecursively(aRoot.left());
			if(lowestOfLeftSubtree.object().score()>highest.object().score()) {
				highest=lowestOfLeftSubtree;
			}
		}
		
		if(aRoot.right()!=null) {
			DictionaryElement<String,Student> lowestOfRightSubtree=this.lowestRecursively(aRoot.right());
			if(lowestOfRightSubtree.object().score()>highest.object().score()) {
				highest=lowestOfRightSubtree;
			}
		}
		return highest;
		
		
	}
	
	public Student highest() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			DictionaryElement<String,Student> highest=highestRecursively(this.root());
			return highest.object();
		}
	}
	
	private int sumOfScoresRecursively(BinaryNode<DictionaryElement<String,Student>> aRoot)
	{
		
		if(aRoot!=null) {
			sumOfScoresRecursively(aRoot.left());
			sum+=aRoot.element().object().score();
			sumOfScoresRecursively(aRoot.right());
		}
		return sum;
	}
	
	public int sum() {
		return this.sumOfScoresRecursively(this.root());
	}
	
	public double average() {
		if(this.isEmpty()) {
			return 0;
		}
		else {
			System.out.println("%%%%%%%%"+this.size());
			System.out.println("%%%%%%%%"+(this.sum())/(double)this.size());
			return (this.sum())/(double)this.size();
		}
	}
	
	public int numberOfStudentsAboveAverage() {
		double average=this.average();
		int numberOfStudentsAboveAverage=0;
		Iterator<DictionaryElement<String,Student>> iterator=this.iterator();
		while(iterator.hasNext()) {
			DictionaryElement<String,Student> element=iterator.next();
			
			System.out.println("***********"+element.object().score()+", "+average);
			if(element.object().score()>=average) {
				numberOfStudentsAboveAverage++;
			}
			System.out.println("******************"+numberOfStudentsAboveAverage);
		}
		return numberOfStudentsAboveAverage;
	}
	
	public Student[]  studentsSortedByScore() { 
		Student[] students = new Student[this.size()]; 
		Iterator<DictionaryElement<String,Student>> iterator = this.iterator(); 
		for(int i = 0;  iterator.hasNext();  i++) 
		{ 
			students[i] = iterator.next().object(); 
		} 
		Sort<Student>  quicksort = new QuickSort<Student>();
		quicksort.sort(students, students.length); 
		return students; 
	}
	

	public GradeCounter countGrades()
	{
		char grade;
		GradeCounter gradeCounter=new GradeCounter();
		Iterator<DictionaryElement<String,Student>> iterator=this.iterator();
		while(iterator.hasNext()) {
			
			grade=Ban.scoreToGrade(iterator.next().object().score());
			
			gradeCounter.count(grade);
		}
		return gradeCounter;
	}
	
	
}
