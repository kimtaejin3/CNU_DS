package Timer;

public class MeasuredResult {
	
	private int size;
	private long _durationForAdd;
	private long _durationForMax;
	
	// Getters/Setters
	public int size() {
		return this.size;
	}
	public void setSize (int newSize ) {
		 this.size=newSize;
	}
	
	public long durationForAdd() {
		return this._durationForAdd;
	}
	public void setDurationForAdd (long newDurationForAdd) {
		this._durationForAdd=newDurationForAdd;
	}
	public long durationForMax() {
		return this._durationForMax;
	}
	public void setDurationForMax (long newDurationForMax) {
		this._durationForMax=newDurationForMax;
	}
	// Constructors
	
	public MeasuredResult () {
		this (0, 0, 0) ;
	}
	
	public MeasuredResult(int givenSize, long givenDurationForAdd, long givenDurationForMax)
	{
		this.setSize(givenSize);
		this.setDurationForAdd (givenDurationForAdd) ;
		this.setDurationForMax (givenDurationForMax) ;
	}
}
