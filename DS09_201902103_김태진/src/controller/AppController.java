package controller;

import model.*;
import view.AppView;

public class AppController {
	// Constants
	private static final char END_OF_CALCULATION = '!' ;
	private static final boolean DEBUG_MODE = true ;
	// ����� ������
	private Calculator _calculator ;
	
	// Getter/Setter
	private Calculator calculator() {
		return this._calculator;
	}
	
	private void setCalculator(Calculator newCalculator) {
		this._calculator=newCalculator;
	}
	
	// ������
	public AppController() {
		this.setCalculator(new Calculator()) ;
		AppView.setDebugMode (AppController.DEBUG_MODE) ;
	}
	
	// ������Լ��� ����
	private String inputExpression() {
		AppView.outputLine("");
		AppView.output("? ����� ������ �Է��Ͻÿ� (�����Ϸ��� "+
		END_OF_CALCULATION+" �� �Է��Ͽ���): "
				);
		return AppView.inputLine();
	}
	
	private void showCalculatorErrorMessage(CalculatorError anError) {
		switch(anError) {
		case InfixError_NoExpression:
			AppView.outputLine("[����] ���� ������ �־����� �ʾҽ��ϴ�.");
			break;
		case InfixError_TooLongExpression:
			AppView.outputLine("[����] ���� ������ �ʹ� ��� ó�� �� �� �����ϴ�.");
			break;
		case InfixError_MissingLeftParen:
			AppView.outputLine("[����] ���� ��ȣ�� �������ϴ�.");
			break;
		case InfixError_MissingRightParen:
			AppView.outputLine("[����] ������ ��ȣ�� �������ϴ�.");
			break;
		case InfixError_UnKnownOperator:
			AppView.outputLine("[����] ���� ���Ŀ� �� �� ���� �����ڰ� �ֽ��ϴ�.");
			break;
		case PostfixError_NoExpression:
			AppView.outputLine("[����] ���� ������ �־����� �ʾҽ��ϴ�.");
			break;
		case PostfixError_TooLongExpression:
			AppView.outputLine("[����] ���� ������ �ʹ� ��� ó�� �� �� �����ϴ�.");
			break;
		case PostfixError_TooFewValues:
			AppView.outputLine("[����] �����ڿ� ���� ���갪�� ���� �����ϴ�.");
			break;
		case PostfixError_TooManyValues:
			AppView.outputLine("[����] �����ڿ� ���� ���갪�� ���� �����ϴ�.");
			break;
		case PostfixError_UnknownOperator:
			AppView.outputLine("[����] ���� ���Ŀ� �� �� ���� �����ڰ� �ֽ��ϴ�.");
			break;
		case PostfixError_DivideByZero:
			AppView.outputLine("[����] �������� �и� 0�Դϴ�.");
		default:
			break;	
		
		}
	}
	
	// �����Լ��� ����
	
	public void run() {
		AppView.outputLine("<<< ���� ���α׷��� �����մϴ� >>>");
		
		String infixExpression=this.inputExpression();
		while(infixExpression.charAt(0)!=AppController.END_OF_CALCULATION) {
			try {
				int result=this.calculator().evaluate(infixExpression);
				AppView.outputLine("> ��갪: "+result);
			} catch (CalculatorException exception) {
				this.showCalculatorErrorMessage(exception.error());
			}
			infixExpression=this.inputExpression();
		}
		AppView.outputLine("");
		AppView.outputLine("<<< ���� ���α׷��� �����մϴ� >>>");
		
	}
	
	
}