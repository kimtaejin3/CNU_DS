package model;

public class CalculatorException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//private instance Variables
	private CalculatorError _error;
	
	//getters/setters
	public CalculatorError error() {
		return this._error;
	}
	
	public void setError(CalculatorError newError) {
		this._error=newError;
	}
	
	//Constructor
	public CalculatorException() {
		this.setError(CalculatorError.Undefined);
	}
	public CalculatorException(CalculatorError givenError) {
		this.setError(givenError);
	}
	
	
}
