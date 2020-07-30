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
					results[i].durationForAdd() / 1000, // Nano �� Micro �� ��ȯ
					results[i].durationForMax() / 1000 // Nano �� Micro �� ��ȯ
			) ;
		}
	}
	
	public AppController() {
		this.setExperiment(new Experiment());
		this.experiment().generateData();
	}
	
	public void run() {
		AppView.outputLine ("<<<����Ʈ ���� ���� ���α׷��� �����մϴ�.>>>");
		AppView.outputLine ("! ����Ʈ�� ������ ���� �ð��� ���̸� �˾ƺ��ϴ�: (����: Micro Second)");
		
		//UnSorted Array List
		AppView.outputLine("");
		AppView.outputLine("<UnSorted Array List>");
		this.experiment().measureForUnSortedArrayList();
		this.showExperimentResults();
		
		//sorted Array List
		AppView.outputLine ("");
		AppView.outputLine ("<Sorted Array List>");
		this.experiment().measureForSortedArrayList();//���谴ü���� ���ĵ� ����Ʈ ���� ������ �����ϰ� ��.
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
		
		AppView.outputLine("<<<����Ʈ ���� ���� ���α׷��� �����մϴ�.>>>"); 
	}
}
