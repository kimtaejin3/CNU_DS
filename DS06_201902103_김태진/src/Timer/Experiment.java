package Timer;

import java.util.Random;

import model.Coin;
import model.SortedArrayList;
import model.SortedLinkedList;
import model.UnSortedArrayList;
import model.UnSortedLinkedList;

public class Experiment {
	// Constants
	private static final int DEFAULT_NUMBER_OF_ITRATION = 5 ;
	private static final int DEFAULT_FIRST_SIZE = 10000 ; // 첫 번째 실험 데이터 크기
	private static final int DEFAULT_SIZE_INCREMENT = 10000 ; // 실험 데이터 크기 증가량

	// Private instances
	private int _numberOfIteration ;
	private int _firstSize ;
	private int _sizeIncrement ;
	private Coin[] _data ;
	private MeasuredResult[] _measuredResults;

	public int numberOfIteration() {
		return this._numberOfIteration;
	}
	public void setNumberOfIteration (int newNumberOfIteration) {
		this._numberOfIteration=newNumberOfIteration;
	}
	
	public int firstSize() {
		return this._firstSize;
	}
	public void setFirstSize(int newFirstSize) {
		this._firstSize=newFirstSize;
	}
	
	public int sizeIncrement() {
		return this._sizeIncrement;
	}
	public void setSizeIncrement (int newSizeIncrement) {
		this._sizeIncrement=newSizeIncrement;
	}
	
	public int maxSize() {
		return this.firstSize()+this.sizeIncrement()*(this.numberOfIteration());
	}
	public Coin[] data() {
		return this._data;
	}
	public void setData (Coin[] newData) {
		this._data=newData;
	}
	
	public MeasuredResult[] measuredResults() {
		return this._measuredResults;
	}
	
	public void setMeasuredResults(MeasuredResult[] newMeasuredResults) {
		this._measuredResults=newMeasuredResults;
	}
	
	public Experiment() {
		this(DEFAULT_NUMBER_OF_ITRATION, DEFAULT_FIRST_SIZE, DEFAULT_SIZE_INCREMENT);
	
	}
	
	public Experiment(int givenNumberOfIteration, int givenFirstSize, int givenSizeIncrement)
	{
		this.setNumberOfIteration(givenNumberOfIteration) ;
		this.setFirstSize(givenFirstSize) ;
		this.setSizeIncrement(givenSizeIncrement) ;
		this.setData (new Coin[this.maxSize()]) ; // 실험 데이터를 담을 배열 공간 확보
		this.setMeasuredResults (new MeasuredResult[this.numberOfIteration()]) ;
		// 실험 결과를 저장할 배열 공간 확보
	}
		
	public void generateData() {
		
		Random random = new Random() ;
		
		for (int i = 0 ; i < this.maxSize() ; i++ ) {
			int randomCoinValue = random.nextInt(this.maxSize()) ;
			this.data()[i] = new Coin(randomCoinValue) ;
		}
	}
	
	public void measureForSortedArrayList() {
		// 정렬된 arraylist의 성능을 측정한다.
		
		@SuppressWarnings("unused")
		Coin maxCoin;
		
		long durationForAdd, durationForMax;
		long start, stop;
		int dataSize = this.firstSize() ;
		
		for ( int iteration = 0 ; iteration < this.numberOfIteration() ; iteration ++ ) {
			SortedArrayList<Coin> list = new SortedArrayList<Coin>(dataSize);
			durationForAdd = 0;
			durationForMax = 0;
			for (int i = 0; i < dataSize ; i++) {
				start = System.nanoTime();
				list.add(this.data()[i]);
				stop = System.nanoTime();
				durationForAdd += (stop - start);
				start = System.nanoTime();
				maxCoin = list.max();
				stop = System.nanoTime();
				durationForMax+= (stop - start);
			}
			
			
			this.measuredResults()[iteration] =new MeasuredResult(dataSize, durationForAdd, durationForMax);
			dataSize += this.sizeIncrement() ;
		}
	}
	
	public void measureForUnSortedArrayList() {
		@SuppressWarnings("unused")
		Coin maxCoin;
		
		long durationForAdd, durationForMax;
		long start, stop;
		int dataSize = this.firstSize() ;
		
		for ( int iteration = 0 ; iteration < this.numberOfIteration() ; iteration ++ ) {
			UnSortedArrayList<Coin> list = new UnSortedArrayList<Coin>(dataSize);
			durationForAdd = 0;
			durationForMax = 0;
			for (int i = 0; i < dataSize ; i++) {
				start = System.nanoTime();
				list.add(this.data()[i]);
				stop = System.nanoTime();
				durationForAdd += (stop - start);
				start = System.nanoTime();
				maxCoin = list.max();
				stop = System.nanoTime();
				durationForMax+= (stop - start);
			}
			
			
			this.measuredResults()[iteration] =new MeasuredResult(dataSize, durationForAdd, durationForMax);
			dataSize += this.sizeIncrement() ;
		}
	}
	
	public void measureForUnSortedLinkedList()
	{
		@SuppressWarnings("unused")
		Coin maxCoin;
		
		long durationForAdd, durationForMax;
		long start, stop;
		int dataSize = this.firstSize() ;
		
		for ( int iteration = 0 ; iteration < this.numberOfIteration() ; iteration++ ) {
			UnSortedLinkedList<Coin> list = new UnSortedLinkedList<Coin>();
			durationForAdd = 0;
			durationForMax = 0;
			for (int i = 0; i < dataSize ; i++) {
				start = System.nanoTime();
				list.add(this.data()[i]);
				stop = System.nanoTime();
				durationForAdd += (stop - start);
				start = System.nanoTime();
				maxCoin = list.max();
				stop = System.nanoTime();
				durationForMax+= (stop - start);
			}
			
			
			this.measuredResults()[iteration] =new MeasuredResult(dataSize, durationForAdd, durationForMax);
			dataSize += this.sizeIncrement() ;
		}
	}
	
	public void measureForSortedLinkedList() {
		@SuppressWarnings("unused")
		Coin maxCoin;
		
		long durationForAdd, durationForMax;
		long start, stop;
		int dataSize = this.firstSize() ;
		
		for ( int iteration = 0 ; iteration < this.numberOfIteration() ; iteration++ ) {
			SortedLinkedList<Coin> list = new SortedLinkedList<Coin>();
			durationForAdd = 0;
			durationForMax = 0;
			for (int i = 0; i < dataSize ; i++) {
				start = System.nanoTime();
				list.add(this.data()[i]);
				stop = System.nanoTime();
				durationForAdd += (stop - start);
				start = System.nanoTime();
				maxCoin = list.max();
				stop = System.nanoTime();
				durationForMax+= (stop - start);
			}
			
			
			this.measuredResults()[iteration] =new MeasuredResult(dataSize, durationForAdd, durationForMax);
			dataSize += this.sizeIncrement() ;
		}
	}
	

}
