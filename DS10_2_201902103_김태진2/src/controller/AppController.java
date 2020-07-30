package controller;

import model.CircularlyLinkedQueue;
import model.Iterator;
import model.Queue;
import view.AppView;

public class AppController {

	
	private Queue<Character> _queue;
	
	private int _inputChars;
	private int _addedChars;
	private int _ignoredChars;
	
	public AppController() {
		this.setQueue(new CircularlyLinkedQueue<Character>());
	}
	
	private Queue<Character> queue(){
		return this._queue;
	}
	
	private void setQueue(Queue<Character> newQueue) {
		this._queue=newQueue;
	}
	
	private int inputChars() {
		return this._inputChars;
	}
	
	private void setInputChars(int newInputChars) {
		this._inputChars=newInputChars;
	}
	
	private int addedChars() {
		return this._addedChars;
	}
	
	private void setAddedChars(int newAddedChars) {
		this._addedChars=newAddedChars;
	}
	
	private int ignoredChars() {
		return this._ignoredChars;
	}
	
	private void setIgnoredChars(int newIgnoredChars) {
		this._ignoredChars=newIgnoredChars;
	}
	
	private void countInputChar() {
		this.setInputChars(this.inputChars()+1);
	}
	
	private void countIgnoredChar() {
		this.setIgnoredChars(this.ignoredChars()+1);
	}
	
	private void countAddedChar() {
		this.setAddedChars(this.addedChars()+1);
	}
	
	private void addToQueue(Character anElement)
	{
		if(this.queue().isFull()) {
			AppView.outputLine("[EnQ.Empty] ť�� �� ���� �� �̻� ���� ���� �����ϴ�.");
		}
		else {
			this.queue().enQueue(anElement);
			AppView.outputLine("[EnQ} ���Ե� ���Ҵ� '"+anElement+"' �Դϴ�.");
		}
	}
	
	private void removeOne() {
		if(this.queue().isEmpty()) {
			AppView.outputLine("[DeQ. Empty] ť�� ������ ���Ұ� �����ϴ�.");
		}
		else {
			Character removedChar=this.queue().deQueue();
			if(removedChar==null) {
				AppView.outputLine("(����) ť���� �����ϴ� ���� ������ �߻��Ͽ����ϴ�."); 
			}
			else {
				AppView.outputLine("[DeQ] ������ ���Ҵ� '"+removedChar+"' �Դϴ�.");
			}
		}
	}
	
	private void removeN(int numberOfCharsToBeRemoved) {
		
		if( numberOfCharsToBeRemoved==0) {
			AppView.outputLine("[DeQs] ������ ������ ������ 0�� �Դϴ�.");
		}
		else {
			for(int i=0; i<numberOfCharsToBeRemoved; i++) {
				if(this.queue().isEmpty()) {
					AppView.outputLine("[DeQs.Empty] ť�� �� �̻� ������ ���Ұ� �����ϴ�.");
					break;
				}
				else
				{
					Character removedChar=this.queue().deQueue();
					if(removedChar==null) {
						AppView.outputLine("(����) ť���� �����ϴ� ���� ������ �߻��Ͽ����ϴ�."); 
					}
					else {
						AppView.outputLine("[DeQ] ������ ���Ҵ� '"+removedChar+"' �Դϴ�.");
					}
				}
			}
		}
	}
	
	private void quitQueueProcessing() {
		
		AppView.outputLine("\n<ť�� ���� ����� �����մϴ�>");
		this.showAllFromFront();
		this.removeN(this.queue().size());
	}
	
	private void showAllFromFront() {
		AppView.output("[Queue] <Front> ");
		Iterator<Character> queueIterator=this.queue().iterator();
		while(queueIterator.hasNext()) {
			Character element=queueIterator.next();
			AppView.output(element.toString()+" ");
		}
		AppView.outputLine("<Rear>");
	}
	
	private void showAllFromRear() {
		AppView.output("[Queue] <Rear> ");
		for(int order=this.queue().size()-1; order>=0; order--) {
			AppView.output(this.queue().elementAt(order).toString()+" ");
		}
		AppView.outputLine("<Front>");
	}
	
	private void showFrontElement() {
		if(this.queue().isEmpty()) {
			AppView.outputLine("[Front.Empty] ť�� �� �� �� ���Ұ� �������� �ʽ��ϴ�.");
		}
		else {
			Character frontElement=this.queue().front();
			AppView.outputLine("[Front] ť�� �� �� ���Ҵ� '"+frontElement+"' �Դϴ�.");
		}
	}
	
	private void showRearElement() {
		if(this.queue().isEmpty()) {
			AppView.outputLine("[Front.Empty] ť�� �� �� �� ���Ұ� �������� �ʽ��ϴ�.");
		}
		else {
			Character rearElement=this.queue().rear();
			AppView.outputLine("[Front] ť�� �� �� ���Ҵ� '"+rearElement+"' �Դϴ�.");
		}
	}
	
	private void showQueueSize() {
		AppView.outputLine("[Size] ť���� ���� "+this.queue().size()+" ���� ���Ұ� �ֽ��ϴ�.");
	}
	
	private void showStatistics() {
		AppView.outputLine("");
		AppView.outputLine("< ť ��� ���>");
		AppView.outputLine("- �Էµ� ���ڴ� "+this.inputChars()+" �� �Դϴ�.");
		AppView.outputLine("- ���� ó���� ���ڴ� "+(this.inputChars()-this.ignoredChars())+"�� �Դϴ�.");
		AppView.outputLine("- ���õ� ���ڴ� "+this.ignoredChars()+" �� �Դϴ�.");
		AppView.outputLine("- ���Ե� ���ڴ� "+this.addedChars()+" �� �Դϴ�.");
	}
	
	private char inputChar() {
		AppView.output("? ���ڸ� �Է��Ͻÿ�: ");
		return AppView.inputChar();
	} 
	
	public void run() {
		
		AppView.outputLine("<<< ť ��� Ȯ�� ���α׷��� �����մϴ� >>>");
		AppView.outputLine("");
		
		char input=this.inputChar();
		while(input != '!') {
			this.countInputChar();
			if(Character.isAlphabetic(input)) {
				this.addToQueue(Character.valueOf(input));
				this.countAddedChar();
			}
			else if(Character.isDigit(input)) {
				this.removeN(Character.getNumericValue(input));
			}
			else if(input=='-') {
				this.removeOne();
			}
			else if(input=='#') {
			 this.showQueueSize();
			}
			else if(input=='/') {
				this.showAllFromFront();
			}
			else if(input=='\\') {
				this.showAllFromRear();
			}
			else if(input=='<') {
				this.showFrontElement();
			}
			else if(input=='>') {
				this.showRearElement();
			}
			else {
				AppView.outputLine("[Ignore] �ǹ� ���� ���ڰ� �ԷµǾ����ϴ�.");
				this.countIgnoredChar();
			}
			input=this.inputChar();
		}
		
		this.quitQueueProcessing();
		
		this.showStatistics();
		AppView.outputLine("");
		AppView.outputLine("<<< ť ��� Ȯ�� ���α׷��� �����մϴ�.");
		
	}
}
