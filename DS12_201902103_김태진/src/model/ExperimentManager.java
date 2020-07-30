package model;

public class ExperimentManager {

	private static final int DEFAULT_NUMBER_OF_SIZE_INCREASING_STEPS=10;
	private static final int DEFAULT_INCREMENT_SIZE=1000;
	private static final int DEFAULT_STARTING_SIZE=DEFAULT_INCREMENT_SIZE;
	
	private static final InsertionSort<Integer> INSERTION_SORT=new InsertionSort<Integer>();
	private static final QuickSort<Integer> QUICK_SORT=new QuickSort<Integer>();
	
	private Experiment _experiment; //���� �Ǹ��� �ǽ��� ��ü
	private ParameterSet _parameterSet;//���� ���迡 ����� �Ű����� ����
	private Integer[] _ascendingList;// �������� ���Ŀ� ����� �������� ������ ����Ʈ
	private Integer[] _descendingList;// �������� ���Ŀ� ����� �������� ������ ����Ʈ
	private Integer[] _randomList;//�������� ���Ŀ� ����� ������ ������ ����Ʈ
	private long[] _measuredResultForInsertionSort;//���� ������ ���� ��� ������ ��
	private long[] _measuredResultForQuickSort;// �� ������ ���� ��� ������ ��
	
	private Experiment experiment() {
		return this._experiment;
	}
	private void setExperiment(Experiment newExperiment) {
		this._experiment=newExperiment;
	}
	
	public ParameterSet parameterSet() {
		return this._parameterSet;
	}
	
	private void setParameterSet(ParameterSet newParameterSet) {
		this._parameterSet=newParameterSet;
	}
	
	private Integer[] ascendingList() {
		return this._ascendingList;
	}
	
	private void setAscendingList(Integer[] newAscendingList) {
		this._ascendingList=newAscendingList;
	}
	
	private Integer[] descendingList() {
		return this._descendingList;
	}
	
	private void setDescendingList(Integer[] newDescendingList) {
		this._descendingList=newDescendingList;
	}
	
	private Integer[] ramdomList() {
		return this._randomList;
	}
	
	private void setRandomList(Integer[] newRandomList) {
		this._randomList=newRandomList;
	}
	
	private long[] measuredResultForInsertionSort() {
		return this._measuredResultForInsertionSort;
	}
	
	private void setMeasuredResultForInsertionSort(long[] newMeasuredResultForInsertionSort) {
		this._measuredResultForInsertionSort=newMeasuredResultForInsertionSort;
	}
	
	private long[] measuredResultForQuickSort() {
		return this._measuredResultForQuickSort;
	}
	
	private void setMeasuredResultForQuickSort(long[] newMeasuredResultForQuickSort) {
		this._measuredResultForQuickSort=newMeasuredResultForQuickSort;
	}
	
	public ExperimentManager() {
		this.setParameterSetWithDefaults();
	}
	
	private void setParameterSetWithDefaults() {
		this.setParameterSet(new ParameterSet(DEFAULT_STARTING_SIZE,DEFAULT_NUMBER_OF_SIZE_INCREASING_STEPS,DEFAULT_INCREMENT_SIZE));
	}
	
	private void prepareExperimentLists() {
		int maxDataSize=this.parameterSet().maxDataSize();
		
		this.setAscendingList(DataGenerator.ascendingList(maxDataSize));
		this.setDescendingList(DataGenerator.descendingList(maxDataSize));
		this.setRandomList(DataGenerator.randomList(maxDataSize));
	}
	
	private Integer[] experimentListOfOrder(ListOrder anOrder) {
		switch(anOrder) {
			case Ascending:
				return this.ascendingList();
			case Descending:
				return this.descendingList();
			default:
				return this.ramdomList();
		}
	}
	
	public void prepareExperiment(ParameterSet aParameterSet) {
		
		if(aParameterSet!=null) {
			this.setParameterSet(aParameterSet);
		}
		
		this.setExperiment(new Experiment(this.parameterSet()));
		this.prepareExperimentLists();

		//���� ����ȭ
		this.performExperiment(ListOrder.Random);
		this.performExperiment(ListOrder.Random);
		
	}
	
	public long measuredResultForInsertionSortAt(int sizeStep) {
		return this.measuredResultForInsertionSort()[sizeStep];
	}
	
	public long measuredResultForQuickSortAt(int sizeStep) {
		return this.measuredResultForQuickSort()[sizeStep];
	}
	
	public void performExperiment(ListOrder anOrder) {
		Integer[] experimentList=this.experimentListOfOrder(anOrder);
		
		this.setMeasuredResultForInsertionSort(this.experiment().durationsOfSort(INSERTION_SORT,experimentList));
		this.setMeasuredResultForQuickSort(this.experiment().durationsOfSort(QUICK_SORT,experimentList));
	}
	

}
