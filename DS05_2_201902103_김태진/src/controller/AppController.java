package controller;
import model.*;
import view.*;

public class AppController {

	private static final int LIST_CAPACITY=5;
	private ArrayList<Student> _list;
	
	private ArrayList<Student> list(){
		return this._list;
	}
	
	private void setList(ArrayList<Student> newList)
	{
		this._list=newList;
	}
	
	
	public AppController() {
		this.setList(new ArrayList<Student>(AppController.LIST_CAPACITY));
	}
	
	private void doesContain () {
		AppView.outputLine("");
		AppView.outputLine("! doesContain �۾��� �����մϴ�.");
		
		int score=this.inputScore();
		
		if(this.list().doesContain(new Student(score))) {
			AppView.outputLine("! �Էµ� ���� ("+score+")�� �л��� ����Ʈ�� �����մϴ�.");
		}
		else {
			AppView.outputLine("! �Էµ� ���� ("+score+")�� �л��� ����Ʈ�� �������� �ʽ��ϴ�.");
		}
	}
	
	private void elementAt () {
		AppView.outputLine("");
		AppView.outputLine("! elementAt �۾��� �����մϴ�.");
		int order=this.inputOrder();
		if(order<0||order>this.list().size()) {
			AppView.outputLine("! �Էµ� ���� ["+order+"]�� ���� ���� [0.."+this.list().size()+"]�� ���� �ʽ��ϴ�.");
		}
		
		if(this.list().elementAt(order)!=null)
		{
			AppView.outputLine("! �Էµ� ���� ["+order+"]�� �л��� ������  ("+this.list().elementAt(order).score()+")�Դϴ�.");
		}
		else
		{
			AppView.outputLine("! �Էµ� ���� ["+order+"] �� �����ϴ� �л��� �����ϴ�.");			
		}
		
	}
		
	private void first() {
		AppView.outputLine("");
		AppView.outputLine("! firstElement �۾��� �����մϴ�.");
		
		if(this.list().isEmpty()) {
			AppView.outputLine("! ����Ʈ�� ����־� first�۾��� �� �� �����ϴ�.");
		}
		else
		{
			AppView.output("! [�� ��] �л��� ������ ("+this.list().first().score()+") �Դϴ�.");
		}
	}
	
	private void last() {
		AppView.outputLine("");
		AppView.outputLine("! lastElement �۾��� �����մϴ�.");
		
		if(this.list().isEmpty()) {
			AppView.outputLine("! ����Ʈ�� ����־�  last�۾��� �� �� �����ϴ�.");
		}
		else
		{
			AppView.output("! [�� ��] �л��� ������ ("+this.list().last().score()+") �Դϴ�.");
		}
	}
	
	private void replaceAt () {
		AppView.outputLine("");
		AppView.outputLine("! replaceAt �۾��� �����մϴ�.");
		
		int order=this.inputOrder();
		if(order<0||order>this.list().size()) {
			AppView.outputLine("! �Էµ� ���� ["+order+"]�� ���� ���� [0.."+this.list().size()+"]�� ���� �ʽ��ϴ�.");
		}
		else {
			int score=this.inputScore();
			if(this.list().replaceAt(new Student(score), order)) {
				AppView.outputLine("�־��� ���� ["+order+"] �� �л��� ������ ("+score+")�� �ٲ�����ϴ�.");
			}
			else {
				// order�� ������ ����� false�� �����Ѵ�.��� �ǳ� Ȯ���� ����.
				AppView.outputLine("�־��� ���� ["+order+"] �� �л��� ������ ("+score+")�� �ٲٴµ� �����߽��ϴ�.");
			}
		}
	}
	
	private void orderOf() {
		AppView.outputLine("");
		AppView.outputLine("! orderOf �۾��� �����մϴ�.");
		
		int score=this.inputScore();
		int order=this.list().orderOf(new Student(score));
		if(order!=-1) {
			AppView.outputLine("! �Էµ� ("+score+")�� �л��� ������  ["+order+"] �Դϴ�.");
		}
		else {
			AppView.outputLine("! �Էµ� ("+score+")�� �л��� ����Ʈ�� �������� �ʽ��ϴ�.");
			
		}
	}
	
	private void addTo() {
		AppView.outputLine("");
		AppView.outputLine("! addTo �۾��� �����մϴ�.");
		if(this.list().isFull()) {
			AppView.outputLine("! ����Ʈ�� �� �� �־ ���� �۾��� �� �� �����ϴ�.");
		}
		else {
			int order=this.inputOrder();
			if(order<0||order>this.list().size()) {
				AppView.outputLine("! �Էµ� ���� ["+order+"]�� ���� ���� [0.."+this.list().size()+"]�� ���� �ʽ��ϴ�.");
			}
			else {
				int score=this.inputScore();
				if(this.list().addTo(new Student(score), order)) {
					AppView.outputLine("! �Էµ� ���� ["+order+"]�� �Էµ� ���� ("+score+")�� �л��� �����ϴ� �۾��� �����Ͽ����ϴ�.");
				}
				else
				{
					AppView.outputLine("! �Էµ� ���� ["+order+"]�� �Էµ� ���� ("+score+")�� �л��� �����ϴ� �۾��� �����Ͽ����ϴ�.");
				}
			}
		}
	}
	
	private void addToFirst() {
		AppView.outputLine("");
		AppView.outputLine("! addToFirst �۾��� �����մϴ�.");
		if(this.list().isFull()) {
			AppView.outputLine("! ����Ʈ�� �� �� �־ ���� �۾��� �� �� �����ϴ�.");
		}
		else {
	
				int score=this.inputScore();
				if(this.list().addToFirst(new Student(score))) {
					AppView.outputLine("! �Էµ� ���� ("+score+")�� �л��� [�� ��]�� �����ϴ� �۾��� �����Ͽ����ϴ�.");
				}
				else
				{
					AppView.outputLine("! �Էµ� ���� ("+score+")�� �л��� [�� ��]�� �����ϴ� �۾��� �����Ͽ����ϴ�.");
				}
			}
		
	}
	
	private void addToLast() {
		AppView.outputLine("");
		AppView.outputLine("! addToLast �۾��� �����մϴ�.");
		if(this.list().isFull()) {
			AppView.outputLine("! ����Ʈ�� �� �� �־ ���� �۾��� �� �� �����ϴ�.");
		}
		else {
	
				int score=this.inputScore();
				if(this.list().addToLast(new Student(score))) {
					AppView.outputLine("! �Էµ� ���� ("+score+")�� �л��� [�� ��]�� �����ϴ� �۾��� �����Ͽ����ϴ�.");
				}
				else
				{
					AppView.outputLine("! �Էµ� ���� ("+score+")�� �л��� [�� ��]�� �����ϴ� �۾��� �����Ͽ����ϴ�.");
				}
			}
	}
	
	private void add() {
		AppView.outputLine("");
		AppView.outputLine("! add �۾��� �����մϴ�.");
		if(this.list().isFull()) {
			AppView.outputLine("! ����Ʈ�� �� �� �־ ���� �۾��� �� �� �����ϴ�.");
		}
		else {
	
				int score=this.inputScore();
				this.list().add(new Student(score));
				
			}
	}
	
	private void removeFrom() {
		AppView.outputLine("");
		AppView.outputLine("! removeFrom �۾��� �����մϴ�.");
		if(this.list().isEmpty()) {
			AppView.outputLine("! ����Ʈ�� ��� �־ ���� �۾��� �� �� �����ϴ�.");
		}
		else {
			int order=this.inputOrder();
			if(order<0||order>this.list().size()) {
				AppView.outputLine("! �Էµ� ���� ["+order+"]�� ���� ���� [0.."+this.list().size()+"]�� ���� �ʽ��ϴ�.");
			}
			else {
				Student student=this.list().removeFrom(order);
				if(student!=null) {
					AppView.outputLine("! �Էµ� ���� ["+order+"]���� ������ �л��� ������  ("+student.score()+") �Դϴ�.");
				}
				else {
					AppView.outputLine("! �Էµ� ���� ["+order+"]���� �л��� �����ϴ� �۾��� �����Ͽ����ϴ�.");
				}
			}
		}
	}
	
	private void removeFirst() {
		AppView.outputLine("");
		AppView.outputLine("! removeFirst �۾��� �����մϴ�.");
		if(this.list().isEmpty()) {
			AppView.outputLine("! ����Ʈ�� ��� �־ ���� �۾��� �� �� �����ϴ�.");
		}
		else {
			
			Student student=this.list().removeFirst();
			if(student!=null) {
				AppView.outputLine("! ������ [�� ��] �л��� ������  ("+student.score()+") �Դϴ�.");
			}
			else {
				AppView.outputLine("! [�� ��] �л��� �����ϴ� �۾��� �����Ͽ����ϴ�.");
			}	
		}
	}
	
	private void removeLast() {
		AppView.outputLine("");
		AppView.outputLine("! removeLast() �۾��� �����մϴ�.");
		if(this.list().isEmpty()) {
			AppView.outputLine("! ����Ʈ�� ��� �־ ���� �۾��� �� �� �����ϴ�.");
		}
		else {
			
			Student student=this.list().removeLast();
			if(student!=null) {
				AppView.outputLine("! ������ [�� ��] �л��� ������  ("+student.score()+") �Դϴ�.");
			}
			else {
				AppView.outputLine("! [�� ��] �л��� �����ϴ� �۾��� �����Ͽ����ϴ�.");
			}	
		}
	}
	
	private void removeAny() {
		AppView.outputLine("");
		AppView.outputLine("! removeAny() �۾��� �����մϴ�.");
		if(this.list().isEmpty()) {
			AppView.outputLine("! ����Ʈ�� ��� �־ ���� �۾��� �� �� �����ϴ�.");
		}
		else {
			
			Student student=this.list().removeAny();
			if(student!=null) {
				AppView.outputLine("! ������ [����] �л��� ������  ("+student.score()+") �Դϴ�.");
			}
			else {
				AppView.outputLine("! [����] �л��� �����ϴ� �۾��� �����Ͽ����ϴ�.");
			}	
		}
	}
	
	private void showList () { // Ʋ�� ��� �д�
		
		AppView.output("! ������ ����Ʈ ���ҵ�: [");
		Student student=null;
		Iterator<Student> iterator=this.list().iterator();
		while(iterator.hasNext()) {
			student=iterator.next();
			AppView.output(" "+student.score());
		}
		AppView.outputLine("]");
	}
		
	private void showStatistics () { // Ʋ�� ��� �д�
		AppView.outputLine("");
		AppView.outputLine("> ����Ʈ ���� �Դϴ�:");
		AppView.outputLine("! �л� ��: "+this.list().size());
		this.showList();
	}
	
	private int inputScore() {
		int score;
		while(true) {
			try {
				AppView.output("? ������ �Է��Ͻÿ�: ");
				score=AppView.inputInteger();
				return score;
			}catch(NumberFormatException e) {
				AppView.outputLine("[����] �Էµ� ������ ������ �ƴմϴ�.");
			}
		}
	}
	
	
	private int inputOrder() {
		int score;
		while(true) {
			try {
				AppView.output("? ����Ʈ������ ���� ��ȣ�� �Է��Ͻÿ� : ");
				score=AppView.inputInteger();
				return score;
			}catch(NumberFormatException e) {
				AppView.outputLine("[����] �Էµ� ���� ��ȣ�� ������ �ƴմϴ�.");
			}
		}
	}
	
	private void showMenu() {
		AppView.outputLine("> �ؾ� �� �۾��� ��ȣ�� �����ؾ� �մϴ�.");
		AppView.outputLine("> DoesContain=1, ElementAt=2, First=3, Last=4, OrderOf=5,");
		AppView.outputLine("  AddTo=6, AddToFirst=7, AddToLast=8, Add=9, ");
		AppView.outputLine("  RemoveFrom=10, RemoveFirst=11, RemoveLast=12, RemoveAny=13, ReplaceAt=14, EndOfRun=99");
		AppView.output("? �۾� ��ȣ�� �Է��Ͻÿ�: ");
	}
	
	public MainMenu selectMenu() {
		AppView.outputLine("");
		
		this.showList();
		this.showMenu();
	
		try {
			
			int selectedMenuNumber=AppView.inputInteger();
			
			MainMenu selectedMenuValue=MainMenu.value(selectedMenuNumber);
			if(selectedMenuValue==MainMenu.Error) {
				AppView.outputLine("!����: �۾� ������ �߸��Ǿ����ϴ�. (�߸��� �޴� ��ȣ: "+selectedMenuNumber+")");
			}
			
			return selectedMenuValue;
			
		}catch(NumberFormatException e) {
			AppView.outputLine("!����: �Էµ� �޴� ��ȣ�� ���� ���ڰ� �ƴմϴ�.");
			return MainMenu.Error;
		}
	}
	
	public void run() {
		AppView.outputLine("<<< ����Ʈ ��� Ȯ�� ���α׷��� �����մϴ� >>>");
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
		AppView.outputLine("<<< ����Ʈ ��� Ȯ�� ���α׷��� �����մϴ� >>>");
	}
	
}
