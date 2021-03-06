package controller;
import model.*;
import view.*;

public class AppController {

	private LinkedList<Student> _list;
	
	public LinkedList<Student> list(){
		return this._list;
	}
	
	public void setList(LinkedList<Student> list) {
		this._list=list;
	}
	
	public AppController() {
		this.setList(new LinkedList<Student>());
	}
	
	private void doesContain () {
		AppView.outputLine("");
		AppView.outputLine("! doesContain 작업을 시작합니다.");
		
		int score=this.inputScore();
		
		if(this.list().doesContain(new Student(score))) {
			AppView.outputLine("! 입력된 점수 ("+score+")의 학생이 리스트에 존재합니다.");
		}
		else {
			AppView.outputLine("! 입력된 점수 ("+score+")의 학생이 리스트에 존재하지 않습니다.");
		}
	}
	
	private void elementAt () {
		AppView.outputLine("");
		AppView.outputLine("! elementAt 작업을 시작합니다.");
		int order=this.inputOrder();
		if(order<0||order>this.list().size()) {
			AppView.outputLine("! 입력된 순서 ["+order+"]가 정상 범위 [0.."+this.list().size()+"]에 있지 않습니다.");
		}
		
		if(this.list().elementAt(order)!=null)
		{
			AppView.outputLine("! 입력된 순서 ["+order+"]의 학생의 점수는  ("+this.list().elementAt(order).score()+")입니다.");
		}
		else
		{
			AppView.outputLine("! 입력된 순서 ["+order+"] 에 존재하는 학생은 없습니다.");			
		}
		
	}
		
	private void first() {
		AppView.outputLine("");
		AppView.outputLine("! firstElement 작업을 시작합니다.");
		
		if(this.list().isEmpty()) {
			AppView.outputLine("! 리스트가 비어있어 first작업을 할 수 없습니다.");
		}
		else
		{
			AppView.outputLine("! [맨 앞] 학생의 점수는 ("+this.list().firstElement().score()+") 입니다.");
		}
	}
	
	private void last() {
		AppView.outputLine("");
		AppView.outputLine("! lastElement 작업을 시작합니다.");
		
		if(this.list().isEmpty()) {
			AppView.outputLine("! 리스트가 비어있어  last작업을 할 수 없습니다.");
		}
		else
		{
			AppView.output("! [맨 뒤] 학생의 점수는 ("+this.list().lastElement().score()+") 입니다.");
		}
	}
	
	private void replaceAt () {
		AppView.outputLine("");
		AppView.outputLine("! replaceAt 작업을 시작합니다.");
		
		int order=this.inputOrder();
		if(order<0||order>this.list().size()) {
			AppView.outputLine("! 입력된 순서 ["+order+"]가 정상 범위 [0.."+this.list().size()+"]에 있지 않습니다.");
		}
		else {
			int score=this.inputScore();
			if(this.list().replaceAt(new Student(score), order)) {
				AppView.outputLine("주어진 순서 ["+order+"] 의 학생의 점수가 ("+score+")로 바뀌었습니다.");
			}
			else {
				// order가 범위를 벗어나면 false를 리턴한다.없어도 되나 확인차 쓴다.
				AppView.outputLine("주어진 순서 ["+order+"] 의 학생의 점수가 ("+score+")로 바꾸는데 실패했습니다.");
			}
		}
	}
	
	private void orderOf() {
		AppView.outputLine("");
		AppView.outputLine("! orderOf 작업을 시작합니다.");
		
		int score=this.inputScore();
		int order=this.list().orderOf(new Student(score));
		if(order!=-1) {
			AppView.outputLine("! 입력된 ("+score+")의 학생의 순서는  ["+order+"] 입니다.");
		}
		else {
			AppView.outputLine("! 입력된 ("+score+")의 학생이 리스트에 존재하지 않습니다.");
			
		}
	}
	
	private void addTo() {
		AppView.outputLine("");
		AppView.outputLine("! addTo 작업을 시작합니다.");
		if(this.list().isFull()) {
			AppView.outputLine("! 리스트가 꽉 차 있어서 삽입 작업을 할 수 없습니다.");
		}
		else {
			int order=this.inputOrder();
			if(order<0||order>this.list().size()) {
				AppView.outputLine("! 입력된 순서 ["+order+"]가 정상 범위 [0.."+this.list().size()+"]에 있지 않습니다.");
			}
			else {
				int score=this.inputScore();
				if(this.list().addTo(new Student(score), order)) {
					AppView.outputLine("! 입력된 순서 ["+order+"]에 입력된 점수 ("+score+")의 학생을 삽입하는 작업을 성공하였습니다.");
				}
				else
				{
					AppView.outputLine("! 입력된 순서 ["+order+"]에 입력된 점수 ("+score+")의 학생을 삽입하는 작업을 실패하였습니다.");
				}
			}
		}
	}
	
	private void addToFirst() {
		AppView.outputLine("");
		AppView.outputLine("! addToFirst 작업을 시작합니다.");
		if(this.list().isFull()) {
			AppView.outputLine("! 리스트가 꽉 차 있어서 삽입 작업을 할 수 없습니다.");
		}
		else {
	
				int score=this.inputScore();
				if(this.list().addToFirst(new Student(score))) {
					AppView.outputLine("! 입력된 점수 ("+score+")의 학생을 [맨 앞]에 삽입하는 작업을 성공하였습니다.");
				}
				else
				{
					AppView.outputLine("! 입력된 점수 ("+score+")의 학생을 [맨 앞]에 삽입하는 작업을 실패하였습니다.");
				}
			}
		
	}
	
	private void addToLast() {
		AppView.outputLine("");
		AppView.outputLine("! addToLast 작업을 시작합니다.");
		if(this.list().isFull()) {
			AppView.outputLine("! 리스트가 꽉 차 있어서 삽입 작업을 할 수 없습니다.");
		}
		else {
	
				int score=this.inputScore();
				if(this.list().addToLast(new Student(score))) {
					AppView.outputLine("! 입력된 점수 ("+score+")의 학생을 [맨 뒤]에 삽입하는 작업을 성공하였습니다.");
				}
				else
				{
					AppView.outputLine("! 입력된 점수 ("+score+")의 학생을 [맨 뒤]에 삽입하는 작업을 실패하였습니다.");
				}
			}
	}
	
	private void add() {
		AppView.outputLine("");
		AppView.outputLine("! add 작업을 시작합니다.");
		if(this.list().isFull()) {
			AppView.outputLine("! 리스트가 꽉 차 있어서 삽입 작업을 할 수 없습니다.");
		}
		else {
	
				int score=this.inputScore();
				if(this.list().add(new Student(score))) {
					AppView.outputLine("! 입력된 점수 ("+score+")의 학생을 [임의의 순서]에 삽입하는 작업을 성공하였습니다.");
				}
				else
				{
					AppView.outputLine("! 입력된 점수 ("+score+")의 학생을 [임의의 순서]에 삽입하는 작업을 실패하였습니다.");
				}
			}
	}
	
	private void removeFrom() {
		AppView.outputLine("");
		AppView.outputLine("! removeFrom 작업을 시작합니다.");
		if(this.list().isEmpty()) {
			AppView.outputLine("! 리스트가 비어 있어서 삭제 작업을 할 수 없습니다.");
		}
		else {
			int order=this.inputOrder();
			if(order<0||order>this.list().size()) {
				AppView.outputLine("! 입력된 순서 ["+order+"]가 정상 범위 [0.."+this.list().size()+"]에 있지 않습니다.");
			}
			else {
				Student student=this.list().removeFrom(order);
				if(student!=null) {
					AppView.outputLine("! 입력된 순서 ["+order+"]에서 삭제된 학생의 성적은  ("+student.score()+") 입니다.");
				}
				else {
					AppView.outputLine("! 입력된 순서 ["+order+"]에서 학생을 삭제하는 작업을 실패하였습니다.");
				}
			}
		}
	}
	
	private void removeFirst() {
		AppView.outputLine("");
		AppView.outputLine("! removeFirst 작업을 시작합니다.");
		if(this.list().isEmpty()) {
			AppView.outputLine("! 리스트가 비어 있어서 삭제 작업을 할 수 없습니다.");
		}
		else {
			
			Student student=this.list().removeFirst();
			if(student!=null) {
				AppView.outputLine("! 삭제된 [맨 앞] 학생의 성적은  ("+student.score()+") 입니다.");
			}
			else {
				AppView.outputLine("! [맨 앞] 학생을 삭제하는 작업을 실패하였습니다.");
			}	
		}
	}
	
	private void removeLast() {
		AppView.outputLine("");
		AppView.outputLine("! removeLast() 작업을 시작합니다.");
		if(this.list().isEmpty()) {
			AppView.outputLine("! 리스트가 비어 있어서 삭제 작업을 할 수 없습니다.");
		}
		else {
			
			Student student=this.list().removeLast();
			if(student!=null) {
				AppView.outputLine("! 삭제된 [맨 뒤] 학생의 성적은  ("+student.score()+") 입니다.");
			}
			else {
				AppView.outputLine("! [맨 뒤] 학생을 삭제하는 작업을 실패하였습니다.");
			}	
		}
	}
	
	private void removeAny() {
		AppView.outputLine("");
		AppView.outputLine("! removeAny() 작업을 시작합니다.");
		if(this.list().isEmpty()) {
			AppView.outputLine("! 리스트가 비어 있어서 삭제 작업을 할 수 없습니다.");
		}
		else {
			
			Student student=this.list().removeAny();
			if(student!=null) {
				AppView.outputLine("! 삭제된 [임의] 학생의 성적은  ("+student.score()+") 입니다.");
			}
			else {
				AppView.outputLine("! [임의] 학생을 삭제하는 작업을 실패하였습니다.");
			}	
		}
	}
	
	private void showList () { // 틀만 잡아 둔다
		
		AppView.output("! 현재의 리스트 원소들: [");
		Student student=null;
		Iterator<Student> iterator=this.list().iterator();
		while(iterator.hasNext()) {
			student=iterator.next();
			AppView.output(" "+student.score());
		}
		AppView.outputLine("]");
	}
		
	private void showStatistics () { // 틀만 잡아 둔다
		AppView.outputLine("");
		AppView.outputLine("> 리스트 정보 입니다:");
		AppView.outputLine("! 학생 수: "+this.list().size());
		this.showList();
	}
	
	private int inputScore() {
		int score;
		while(true) {
			try {
				AppView.output("? 점수를 입력하시오: ");
				score=AppView.inputInteger();
				return score;
			}catch(NumberFormatException e) {
				AppView.outputLine("[오류] 입력된 점수는 정수가 아닙니다.");
			}
		}
	}
	
	
	private int inputOrder() {
		int score;
		while(true) {
			try {
				AppView.output("? 리스트에서의 순서 번호를 입력하시오 : ");
				score=AppView.inputInteger();
				return score;
			}catch(NumberFormatException e) {
				AppView.outputLine("[오류] 입력된 순서 번호는 정수가 아닙니다.");
			}
		}
	}
	
	private void showMenu() {
		AppView.outputLine("> 해야 할 작업의 번호를 선택해야 합니다.");
		AppView.outputLine("> DoesContain=1, ElementAt=2, First=3, Last=4, OrderOf=5,");
		AppView.outputLine("  AddTo=6, AddToFirst=7, AddToLast=8, Add=9, ");
		AppView.outputLine("  RemoveFrom=10, RemoveFirst=11, RemoveLast=12, RemoveAny=13, ReplaceAt=14, EndOfRun=99");
		AppView.output("? 작업 번호를 입력하시오: ");
	}
	
	public MainMenu selectMenu() {
		AppView.outputLine("");
		
		this.showList();
		this.showMenu();
	
		try {
			
			int selectedMenuNumber=AppView.inputInteger();
			
			MainMenu selectedMenuValue=MainMenu.value(selectedMenuNumber);
			if(selectedMenuValue==MainMenu.Error) {
				AppView.outputLine("!오류: 작업 선택이 잘못되었습니다. (잘못된 메뉴 번호: "+selectedMenuNumber+")");
			}
			
			return selectedMenuValue;
			
		}catch(NumberFormatException e) {
			AppView.outputLine("!오류: 입력된 메뉴 번호가 정수 숫자가 아닙니다.");
			return MainMenu.Error;
		}
	}
	
	public void run() {
		AppView.outputLine("<<< 리스트 기능 확인 프로그램을 시작합니다 >>>");
		
		MainMenu selectedMenuValue=this.selectMenu();
		while(selectedMenuValue!=MainMenu.EndOfRun) {
			switch(selectedMenuValue) {
			case DoesContain:
				this.doesContain();
				break;
			case ElementAt:
				this.elementAt();
				break;
			case First:
				this.first();
				break;
			case Last:
				this.last();
				break;
			case OrderOf:
				this.orderOf();
				break;	
			case AddTo:
				this.addTo();
				break;
			case AddToFirst:
				this.addToFirst();
				break;
			case AddToLast:
				this.addToLast();
				break;
			case Add:
				this.add();
				break;
			case RemoveFrom:
				this.removeFrom();
				break;
			case RemoveFirst:
				this.removeFirst();
				break;
			case RemoveLast:
				this.removeLast();
				break;
			case RemoveAny:
				this.removeAny();
				break;
			case ReplaceAt:
				this.replaceAt();
				break;
				
			default:
				break;	
			}
			selectedMenuValue=this.selectMenu();
		}
		this.showStatistics();
		
		AppView.output("");
		AppView.outputLine("<<< 리스트 기능 확인 프로그램을 종료합니다 >>>");
	}
	
}
