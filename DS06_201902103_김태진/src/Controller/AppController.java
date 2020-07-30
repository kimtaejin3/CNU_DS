package Controller;

import Timer.Experiment;
import Timer.MeasuredResult;
import view.AppView;

public class AppController {

	private Experiment _experiment;
	
	public Experiment experiment() {
		return this._experiment;
	}
	
	private void setExperiment(Experiment newExperiment) {
		this._experiment=newExperiment;
	}
	
	private void showExperimentResults() {
		MeasuredResult[] results=this.experiment().measuredResults();
		for ( int i = 0; i < this.experiment().numberOfIteration () ; i++ ) {
			AppView.outputResults (
					results[i].size(),
					results[i].durationForAdd() / 1000, // Nano 를 Micro 로 변환
					results[i].durationForMax() / 1000 // Nano 를 Micro 로 변환
			) ;
		}
	}
	
	public AppController() {
		this.setExperiment(new Experiment());
		this.experiment().generateData();
	}
	
	public void run() {
		AppView.outputLine ("<<<리스트 성능 측정 프로그램을 시작합니다.>>>");
		AppView.outputLine ("! 리스트의 구현에 따른 시간의 차이를 알아봅니다: (단위: Micro Second)");
		
		//UnSorted Array List
		AppView.outputLine("");
		AppView.outputLine("<UnSorted Array List>");
		this.experiment().measureForUnSortedArrayList();
		this.showExperimentResults();
		
		//sorted Array List
		AppView.outputLine ("");
		AppView.outputLine ("<Sorted Array List>");
		this.experiment().measureForSortedArrayList();//실험객체에게 정렬된 리스트 성능 측정을 수행하게 함.
		this.showExperimentResults();
		
		//UnSorted Linked List
		AppView.outputLine("");
		AppView.outputLine("<UnSorted Linked List>");
		this.experiment().measureForUnSortedLinkedList();
		this.showExperimentResults();
		
		//Sorted Linked List
		AppView.outputLine("");
		AppView.outputLine("<Sorted Linked List>");
		this.experiment().measureForSortedLinkedList();
		this.showExperimentResults();
		
		AppView.outputLine("<<<리스트 성능 측정 프로그램을 종료합니다.>>>"); 
	}
}
