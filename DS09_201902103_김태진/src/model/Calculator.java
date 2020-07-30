package model;

import java.util.Arrays;

import view.AppView;

public class Calculator {
	
	//Constants
	private static final int MAX_EXPRESSION_LENGTH=100;
	
	//Private instance variables
	private Stack<Character> _operatorStack;
	private String _infixExpression;
	private String _postfixExpression;
	private PostfixCalculator __postfixCalculator;
	
	//Getters/Setters
	private String infixExpression() {
		return this._infixExpression;
	}
	private void setInfixExpression(String newInfixExpression) {
		this._infixExpression=newInfixExpression;
	}
	
	private String postfixExpression() {
		return this._postfixExpression;
	}
	private void setPostInfixExpression(String newPostfixExpression) {
		this._postfixExpression=newPostfixExpression;
	}
	
	private PostfixCalculator postfixCalculator() {
		return this.__postfixCalculator;
	}
	
	private void setPostfixCalculator(PostfixCalculator newPostfixCalculator) {
		this.__postfixCalculator=newPostfixCalculator;
	}
	
	private Stack<Character> operatorStack(){
		return this._operatorStack;
	}
	
	private void setOperatorStack(Stack<Character> newOperatorStack)
	{
		this._operatorStack=newOperatorStack;
	}
	
	public Calculator() {
		this.setOperatorStack(new ArrayList<Character>(Calculator.MAX_EXPRESSION_LENGTH));
		this.setPostfixCalculator(new PostfixCalculator(Calculator.MAX_EXPRESSION_LENGTH));
	}
	
	private void showTokenAndPostfixExpression(char aToken,char[] aPostfixExpressionArray) {
		AppView.outputDebugMessage(aToken+": (Postfix �������� ���)");
		AppView.outputLineDebugMessage(new String(aPostfixExpressionArray));
	}
	
	private void showTokenAndMessage(char aToken,String aMessage) {
		AppView.outputLineDebugMessage(aToken+ " : ("+aMessage+") ");
	}
	
	private void showOperatorStack(String anOperationLabel) {
		AppView.outputDebugMessage(anOperationLabel+" : OperatorStack <Bottom> ");
		for(int i=0; i<this.operatorStack().size(); i++) {
			AppView.outputDebugMessage(((ArrayList<Character>)this.operatorStack()).elementAt(i).charValue()+" ");
		}
		AppView.outputLineDebugMessage("<Top>");
	}
	
	private int inComingPrecedence(Character aToken) {
		switch(aToken.charValue()) {
		case'(':return 20;
		case')':return 19;
		case'^':return 17;
		case'*':return 13;
		case'/':return 13;
		case'%':return 13;
		case'+':return 12;
		case'-':return 12;
		default:
			return -1;
		}
	}
	
	private int inStackPrecedence(Character aToken) {
		switch(aToken.charValue()) {
		case'(':return 0;
		case')':return 19;
		case'^':return 16;
		case'*':return 13;
		case'/':return 13;
		case'%':return 13;
		case'+':return 12;
		case'-':return 12;
		default:
			return -1;
		}
	}
	
	private CalculatorError infixToPostfix()
	{
		
		char[] postfixExpressionArray=new char[this.infixExpression().length()];
		Arrays.fill(postfixExpressionArray, ' ');
		
		Character currentToken,poppedToken,topToken;
		this.operatorStack().clear();
		
		int p=0;
		
		for(int i=0; i<this.infixExpression().length(); i++) {
			currentToken=this.infixExpression().charAt(i);
			if(Character.isDigit(currentToken.charValue())) {
				postfixExpressionArray[p++]=currentToken;
				this.showTokenAndPostfixExpression(currentToken,postfixExpressionArray);
			}
			else
			{
				if(currentToken==')') {
					this.showTokenAndMessage(currentToken,"���� ��ȣ�� ��Ÿ�� ������ ���ÿ��� ������ ���");
					poppedToken=this.operatorStack().pop();
					while(poppedToken!=null&&poppedToken!='(') {
						postfixExpressionArray[p++]=poppedToken.charValue();
						this.showOperatorStack("Popped");
						this.showTokenAndPostfixExpression(poppedToken, postfixExpressionArray);
						poppedToken=this.operatorStack().pop();
					}
					if(poppedToken==null) {
						return CalculatorError.InfixError_MissingLeftParen;
					}
					this.showOperatorStack("Popped");
				}
				else {
					int inComingPrecedence= this.inComingPrecedence(currentToken.charValue());
					if(inComingPrecedence<0) {
						AppView.outputLineDebugMessage(currentToken+" : (Unknown Operator)");
						return CalculatorError.InfixError_UnKnownOperator;
					}
					this.showTokenAndMessage(currentToken,"�Է� ������� ������ ���� ���� �����ڸ� ���ÿ���  ������ ���");
					topToken=this.operatorStack().peek();
					while(topToken!=null&&this.inStackPrecedence(topToken)>=inComingPrecedence) {
						poppedToken=this.operatorStack().pop();
						postfixExpressionArray[p++]=poppedToken;
						this.showOperatorStack("Popped");
						this.showTokenAndPostfixExpression(poppedToken, postfixExpressionArray);
						topToken=this.operatorStack().peek();
					}
					if(this.operatorStack().isFull()) {
						this.showOperatorStack("Fulled");
						return CalculatorError.InfixError_TooLongExpression;
					}
					this.operatorStack().push(currentToken);
					this.showOperatorStack("Pushed");
					
				}
				
			}
		}
		
		AppView.outputLineDebugMessage("(End of infix expression: ���ÿ��� ��� �����ڸ� ������ ���)");
		
		while(!this.operatorStack().isEmpty()) {
			poppedToken=this.operatorStack().pop();
			this.showOperatorStack("Popped");
			if(poppedToken=='(')
			{
				return CalculatorError.InfixError_MissingRightParen;
			}
			postfixExpressionArray[p++]=poppedToken;
			this.showTokenAndPostfixExpression(poppedToken, postfixExpressionArray);
		}
		this.setPostInfixExpression(new String(postfixExpressionArray).trim());
		return CalculatorError.InfixError_None;
	}
	
	public int evaluate(String anInfixExpression) throws CalculatorException{
		this.setInfixExpression(anInfixExpression);
		AppView.outputLineDebugMessage("[Infix to Postfix] "+anInfixExpression);
		if(this.infixExpression()==null||this.infixExpression().length()==0) {
			throw new CalculatorException(CalculatorError.InfixError_NoExpression);
		}
		
		CalculatorError infixError=this.infixToPostfix();
		if(infixError==CalculatorError.InfixError_None) {
			AppView.outputLineDebugMessage("\n[Evaluate Postfix] "+this.postfixExpression());
			return this.postfixCalculator().evaluate(this.postfixExpression());
		}
		else {
			throw new CalculatorException(infixError);
		}
	}
	
}
