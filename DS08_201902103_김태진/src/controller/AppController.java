package controller;

import model.ArrayList;

import view.AppView;

public class AppController {

	//���
	private static final int STACK_CAPACITY=5;
	
	//PRIVATE 
	private int _inputChars;//�Էµ� ������ ����
	private int _pushedChars;//���Ե� ������ ����
	private int _ignoredChars;//���õ� ������ ����
	private ArrayList<Character> _stack;
	
	private ArrayList<Character> stack() {
		return this._stack;
	}
	
	private void setStack (ArrayList<Character> newStack) {
		this._stack=newStack;
	}
	
	private int inputChars() {
		return this._inputChars;
	}
	
	private void setInputChars(int newInputChars) {
		this._inputChars=newInputChars;
	}
	
	private int pushedChars() {
		return this._pushedChars;
	}
	
	private void setPushedChars(int newPushedChars) {
		this._pushedChars=newPushedChars;
	}
	
	private int ignoredChars() {
		return this._ignoredChars;
	}
	
	private void setIgnoredChars(int newIgnoredChars) {
		this._ignoredChars=newIgnoredChars;
	}
	
	public AppController() {
		this.setStack (new ArrayList<Character>(AppController.STACK_CAPACITY)) ;
		this.setInputChars (0) ;
		this.setPushedChars (0) ;
		this.setIgnoredChars (0) ;
		
	}
	
	// ����� �Լ�
	// Ƚ�� ���
	private void countInputChar() {
		this.setInputChars(this.inputChars()+1);
	}
	
	private void countIgnoredChar() {
		this.setIgnoredChars (this.ignoredChars()+1) ;
	}
	
	private void countPushedChar() {
		this.setPushedChars (this.pushedChars()+1) ;
	}
	
	// ���� ���� ����
	private void pushToStack (char aCharForPush) {
		
		if ( this.stack().isFull() ) {
			AppView.outputLine("(����) ������ �� ����, �� �̻� ���� �� �����ϴ�.") ;
		}
		else {
			Character charObjectForAdd = Character.valueOf (aCharForPush);
			
			if ( this.stack().push (charObjectForAdd) ) {
				AppView.outputLine("[Push] ���Ե� ���Ҵ� '" + aCharForPush + "' �Դϴ�.") ;
			}
			else {
				AppView.outputLine ("(����) ���ÿ� �ִ� ���ȿ� ������ �߻��Ͽ����ϴ�.") ;
			}
		}
	}
	
	private void popOne() {
		if(this.stack().isEmpty()) {
			AppView.outputLine("[Pops.Empty] ���ÿ� ������ ���Ұ� �����ϴ�.");
		}
		else {
			Character poppedChar=this.stack().pop();
			if(poppedChar==null) {
				AppView.outputLine("(����) ���ÿ��� �����ϴ� ���ȿ� ������ �߻��Ͽ����ϴ�."); 
			}
			else {
				AppView.outputLine("[pop] ������ ���Ҵ� '"+poppedChar+"' �Դϴ�.");
			}
		}
	}
	private void popN (int numberOfCharsToBePopped) {
		
		if(numberOfCharsToBePopped==0) {
			AppView.outputLine("[Pops] ������ ������ ������ 0�� �Դϴ�.");
		}
		else {
			int count=0;
			while(count<numberOfCharsToBePopped&&(!this.stack().isEmpty())) {
				Character poppedChar=this.stack().pop();
				if(poppedChar==null) {
					AppView.outputLine("(����) ���ÿ��� �����ϴ� ���ȿ� ������ �߻��Ͽ����ϴ�."); 
				}
				else {
					AppView.outputLine("[pop] ������ ���Ҵ� '"+poppedChar+"' �Դϴ�.");
				}
				count++;
			}
			if(count<numberOfCharsToBePopped) {
				AppView.outputLine("[Pops.empty] ���ÿ� ���̻� ������ ���Ұ� �����ϴ�.");
			}
		}
	}
	
	private void quitStackProcessing() {
		AppView.outputLine("");
		AppView.outputLine("<������ ���� ����� �����մϴ�>");
		this.showAllFromBottom();
		this.popN(this.stack().size());
	}
	
	// ��� ����
	private void showAllFromBottom() {
		//������ ��� ���Ҹ� Bottom���� Top���� ����Ѵ�.
		AppView.output ("[Stack] <Bottom> ") ;
		for ( int order = 0 ; order < this.stack().size() ; order++ ) {
			AppView.output (this.stack().elementAt(order).toString() + " " ) ;
		}
		AppView.outputLine (" <Top>") ;
	}
	
	private void showAllFromTop(){
		AppView.output ("[Stack] <Top> ") ;
		for ( int order = this.stack().size()-1; order >= 0 ; order-- ) {
			AppView.output (this.stack().elementAt(order).toString() + " " ) ;
		}
		AppView.outputLine (" <Bottom>") ;
	
	}
	private void showTopElement() {
		
		if(this.stack().isEmpty()) {
			AppView.outputLine("[Pops.Empty] ���ÿ� �� Top ���Ұ� �������� �ʽ��ϴ�.");
		}
		else {
			Character topElement=this.stack().peek();
			AppView.outputLine("[Top] ������ Top���Ҵ� '"+topElement+"'�Դϴ�.");
		}
	}
	private void showStackSize() {
		AppView.outputLine("[Size] ���ÿ���  ���� "+this.stack().size()+" ���� ���Ұ� �ֽ��ϴ�.");
	}
	
	private void showStatistics() {
		AppView.outputLine("");
		AppView.outputLine("<���� ��� ���>");
		AppView.outputLine("- �Էµ� ���ڴ� "+this.inputChars()+" �� �Դϴ�.");
		AppView.outputLine("- ���� ó�� �� ���ڴ� "+(this.inputChars()-this.ignoredChars())+"�� �Դϴ�.");
		AppView.outputLine("- ���õ� ���ڴ� "+this.ignoredChars()+" �� �Դϴ�.");
		AppView.outputLine("- ���Ե� ���ڴ� "+this.pushedChars()+" �� �Դϴ�.");
	}
	
	// �Է� ����
	private char inputChar() {
		AppView.output("? ���ڸ� �Է��Ͻÿ�: ");
		return AppView.inputChar();
	} 
	
	
	public void run() {
		AppView.outputLine("<<< ���� ��� Ȯ�� ���α׷��� �����մϴ� >>>");
		AppView.outputLine("");
		
		char input=this.inputChar();
		
		while(input!='!') {
			this.countInputChar();
			if(Character.isAlphabetic(input)) {
				this.pushToStack(input);
				this.countPushedChar();
			}
			else if(Character.isDigit(input)) {
				this.popN(Character.getNumericValue(input));
			}
			else if(input=='-') {
				this.popOne();
			}
			else if(input=='#') {
				this.showStackSize();
			}
			else if(input=='/') {
				this.showAllFromBottom();
			}
			else if(input=='\\') {
				this.showAllFromTop();
			}
			else if(input=='^') {
				this.showTopElement();
			}
			else {
				AppView.outputLine("[Ignore] �ǹ� ���� ���ڰ� �ԷµǾ����ϴ�.");
				this.countIgnoredChar();
			}
			input=this.inputChar();
		}
			this.quitStackProcessing();

			this.showStatistics();
			AppView.outputLine("");
			AppView.outputLine("<<< ���� ��� Ȯ�� ���α׷��� �����մϴ� >>>");
			
		
	}
}
