package controller;

import model.ArrayList;

import view.AppView;

public class AppController {

	//상수
	private static final int STACK_CAPACITY=5;
	
	//PRIVATE 
	private int _inputChars;//입력된 문자의 개수
	private int _pushedChars;//삽입된 문자의 개수
	private int _ignoredChars;//무시된 문자의 개수
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
	
	// 비공개 함수
	// 횟수 계산
	private void countInputChar() {
		this.setInputChars(this.inputChars()+1);
	}
	
	private void countIgnoredChar() {
		this.setIgnoredChars (this.ignoredChars()+1) ;
	}
	
	private void countPushedChar() {
		this.setPushedChars (this.pushedChars()+1) ;
	}
	
	// 스택 수행 관련
	private void pushToStack (char aCharForPush) {
		
		if ( this.stack().isFull() ) {
			AppView.outputLine("(오류) 스택이 꽉 차서, 더 이상 넣을 수 없습니다.") ;
		}
		else {
			Character charObjectForAdd = Character.valueOf (aCharForPush);
			
			if ( this.stack().push (charObjectForAdd) ) {
				AppView.outputLine("[Push] 삽입된 원소는 '" + aCharForPush + "' 입니다.") ;
			}
			else {
				AppView.outputLine ("(오류) 스택에 넣는 동안에 오류가 발생하였습니다.") ;
			}
		}
	}
	
	private void popOne() {
		if(this.stack().isEmpty()) {
			AppView.outputLine("[Pops.Empty] 스택에 삭제할 원소가 없습니다.");
		}
		else {
			Character poppedChar=this.stack().pop();
			if(poppedChar==null) {
				AppView.outputLine("(오류) 스택에서 삭제하는 동안에 오류가 발생하였습니다."); 
			}
			else {
				AppView.outputLine("[pop] 삭제된 원소는 '"+poppedChar+"' 입니다.");
			}
		}
	}
	private void popN (int numberOfCharsToBePopped) {
		
		if(numberOfCharsToBePopped==0) {
			AppView.outputLine("[Pops] 삭제할 원소의 개수가 0개 입니다.");
		}
		else {
			int count=0;
			while(count<numberOfCharsToBePopped&&(!this.stack().isEmpty())) {
				Character poppedChar=this.stack().pop();
				if(poppedChar==null) {
					AppView.outputLine("(오류) 스택에서 삭제하는 동안에 오류가 발생하였습니다."); 
				}
				else {
					AppView.outputLine("[pop] 삭제된 원소는 '"+poppedChar+"' 입니다.");
				}
				count++;
			}
			if(count<numberOfCharsToBePopped) {
				AppView.outputLine("[Pops.empty] 스택에 더이상 삭제할 원소가 없습니다.");
			}
		}
	}
	
	private void quitStackProcessing() {
		AppView.outputLine("");
		AppView.outputLine("<스택을 비우고 사용을 종료합니다>");
		this.showAllFromBottom();
		this.popN(this.stack().size());
	}
	
	// 출력 관련
	private void showAllFromBottom() {
		//스택의 모든 원소를 Bottom부터 Top까지 출력한다.
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
			AppView.outputLine("[Pops.Empty] 스택에 비어서 Top 원소가 존재하지 않습니다.");
		}
		else {
			Character topElement=this.stack().peek();
			AppView.outputLine("[Top] 스택의 Top원소는 '"+topElement+"'입니다.");
		}
	}
	private void showStackSize() {
		AppView.outputLine("[Size] 스택에는  현재 "+this.stack().size()+" 개의 원소가 있습니다.");
	}
	
	private void showStatistics() {
		AppView.outputLine("");
		AppView.outputLine("<스택 사용 통계>");
		AppView.outputLine("- 입력된 문자는 "+this.inputChars()+" 개 입니다.");
		AppView.outputLine("- 정상 처리 된 문자는 "+(this.inputChars()-this.ignoredChars())+"게 입니다.");
		AppView.outputLine("- 무시된 문자는 "+this.ignoredChars()+" 개 입니다.");
		AppView.outputLine("- 삽입된 문자는 "+this.pushedChars()+" 개 입니다.");
	}
	
	// 입력 관련
	private char inputChar() {
		AppView.output("? 문자를 입력하시오: ");
		return AppView.inputChar();
	} 
	
	
	public void run() {
		AppView.outputLine("<<< 스택 기능 확인 프로그램을 시작합니다 >>>");
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
				AppView.outputLine("[Ignore] 의미 없는 문자가 입력되었습니다.");
				this.countIgnoredChar();
			}
			input=this.inputChar();
		}
			this.quitStackProcessing();

			this.showStatistics();
			AppView.outputLine("");
			AppView.outputLine("<<< 스택 기능 확인 프로그램을 시작합니다 >>>");
			
		
	}
}
