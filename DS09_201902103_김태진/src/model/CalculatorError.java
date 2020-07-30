package model;

public enum CalculatorError {
	Undefined,
	InfixError_None,
	InfixError_NoExpression,
	InfixError_TooLongExpression,
	InfixError_MissingLeftParen,
	InfixError_MissingRightParen,
	InfixError_UnKnownOperator,
	
	PostfixError_None,
	PostfixError_NoExpression,
	PostfixError_TooLongExpression,
	PostfixError_TooFewValues,
	PostfixError_TooManyValues,
	PostfixError_UnknownOperator,
	PostfixError_DivideByZero,
	
}
