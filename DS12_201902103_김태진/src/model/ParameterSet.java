package model;

public class ParameterSet {
	
	//Private instance variables
	private int _startingSize;
	private int _numberOfSizeIncreasingSteps;
	private int _incrementSize;
	
	public int startingSize() {
		return this._startingSize;
	}
	
	public void setStartingSize(int newStartingSize) {
		this._startingSize = newStartingSize;
	}
	
	public int numberOfSizeIncreasingSteps() {
		return this._numberOfSizeIncreasingSteps;
	}
	
	public void setNumberOfSizeIncreasingSteps(int newNumberOfSizeIncreasingSteps) {
		this._numberOfSizeIncreasingSteps = newNumberOfSizeIncreasingSteps;
	}
	
	public int incrementSize() {
		return this._incrementSize;
	}
	
	public void setIncrementSize(int newIncrementSize) {
		this._incrementSize = newIncrementSize;
	}
	
	public int maxDataSize() {
		return (this.startingSize()+(this.incrementSize()*(this.numberOfSizeIncreasingSteps()-1)));
	}
	
	public ParameterSet(int givenStartingSize, int givenNumberOfSizeIncreasingSteps,int givenIncrementSize) {
		this.setIncrementSize(givenIncrementSize);
		this.setNumberOfSizeIncreasingSteps(givenNumberOfSizeIncreasingSteps);
		this.setStartingSize(givenStartingSize);
	}
}
