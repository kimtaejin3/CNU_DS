package model;

public class Timer {

	private long _startTime;//¥‹¿ß : nano second
	private long _stopTime;
	
	public Timer() {
		this._startTime=0;
		this._stopTime=0;
	}
	
	public void start() {
		this._startTime=System.nanoTime();
	}
	
	public void stop() {
		this._stopTime=System.nanoTime();
	}
	
	public long duration() {
		return (this._stopTime-this._startTime);
	}
}
