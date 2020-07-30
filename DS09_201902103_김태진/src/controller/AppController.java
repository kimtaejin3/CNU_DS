package controller;

import model.*;
import view.AppView;

public class AppController {
	// Constants
	private static final char END_OF_CALCULATION = '!' ;
	private static final boolean DEBUG_MODE = true ;
	// 비공개 변수들
	private Calculator _calculator ;
	
	// Getter/Setter
	private Calculator calculator() {
		return this._calculator;
	}
	
	private void setCalculator(Calculator newCalculator) {
		this._calculator=newCalculator;
	}
	
	// 생성자
	public AppController() {
		this.setCalculator(new Calculator()) ;
		AppView.setDebugMode (AppController.DEBUG_MODE) ;
	}
	
	// 비공개함수의 구현
	private String inputExpression() {
		AppView.outputLine("");
		AppView.output("? 계산할 수식을 입력하시오 (종료하려면 "+
		END_OF_CALCULATION+" 를 입력하에요): "
				);
		return AppView.inputLine();
	}
	
	private void showCalculatorErrorMessage(CalculatorError anError) {
		switch(anError) {
		case InfixError_NoExpression:
			AppView.outputLine("[오류] 중위 계산식이 주어지지 않았습니다.");
			break;
		case InfixError_TooLongExpression:
			AppView.outputLine("[오류] 중위 계산식이 너무 길어 처리 할 수 없습니다.");
			break;
		case InfixError_MissingLeftParen:
			AppView.outputLine("[오류] 왼쪽 괄호가 빠졌습니다.");
			break;
		case InfixError_MissingRightParen:
			AppView.outputLine("[오류] 오른쪽 괄호가 빠졌습니다.");
			break;
		case InfixError_UnKnownOperator:
			AppView.outputLine("[오류] 중위 계산식에 알 수 없는 연산자가 있습니다.");
			break;
		case PostfixError_NoExpression:
			AppView.outputLine("[오류] 후위 계산식이 주어지지 않았습니다.");
			break;
		case PostfixError_TooLongExpression:
			AppView.outputLine("[오류] 후위 계산식이 너무 길어 처리 할 수 없습니다.");
			break;
		case PostfixError_TooFewValues:
			AppView.outputLine("[오류] 연산자에 비해 연산값의 수가 적습니다.");
			break;
		case PostfixError_TooManyValues:
			AppView.outputLine("[오류] 연산자에 비해 연산값의 수가 많습니다.");
			break;
		case PostfixError_UnknownOperator:
			AppView.outputLine("[오류] 후위 계산식에 알 수 없는 연산자가 있습니다.");
			break;
		case PostfixError_DivideByZero:
			AppView.outputLine("[오류] 나눗셈의 분모가 0입니다.");
		default:
			break;	
		
		}
	}
	
	// 공개함수의 구현
	
	public void run() {
		AppView.outputLine("<<< 계산기 프로그램을 시작합니다 >>>");
		
		String infixExpression=this.inputExpression();
		while(infixExpression.charAt(0)!=AppController.END_OF_CALCULATION) {
			try {
				int result=this.calculator().evaluate(infixExpression);
				AppView.outputLine("> 계산값: "+result);
			} catch (CalculatorException exception) {
				this.showCalculatorErrorMessage(exception.error());
			}
			infixExpression=this.inputExpression();
		}
		AppView.outputLine("");
		AppView.outputLine("<<< 계산기 프로그램을 종료합니다 >>>");
		
	}
	
	
}