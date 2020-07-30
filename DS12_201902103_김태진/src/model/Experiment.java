package model;

public class Experiment {

	private final ParameterSet _parameterSet;
	
	private ParameterSet parameterSet() {
		return this._parameterSet;
	}
	
	public Experiment(ParameterSet givenParameterSet) {
		this._parameterSet=givenParameterSet;
	}
	
	private Integer[] copyListOfGivenSize(Integer[] aList, int copiedSize) {
		Integer[] copiedList=null;
		if(copiedSize<=aList.length) {
			copiedList=new Integer[copiedSize];
			for(int i=0; i<copiedSize; i++) {
				copiedList[i]=aList[i];
			}
		}
		return copiedList;
	}
	
	private long durationOfSingleSort(Sort<Integer> aSort, Integer[] aList) {
		Timer timer=new Timer();
		timer.start();
		{
			aSort.sort(aList, aList.length);
		}
		timer.stop();
		return timer.duration();
	}
		
	public long[] durationsOfSort(Sort<Integer> aSort, Integer[] experimentList) {
		
		int numberOfSteps=this.parameterSet().numberOfSizeIncreasingSteps();
			//크기 별로 실행할 측정 횟수
		long[] durations=new long[numberOfSteps];
		
		int sortingSize=this.parameterSet().startingSize();
		int incrementSize=this.parameterSet().incrementSize();
		
		for(int step=0; step<numberOfSteps; step++) {
			Integer[] listForSorting=this.copyListOfGivenSize(experimentList, sortingSize);
			durations[step]=this.durationOfSingleSort(aSort, listForSorting);
			sortingSize+=incrementSize;
		}
		return durations;
	}
}
