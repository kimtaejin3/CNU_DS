package controller;

import model.DataGenerator;
import model.InsertionSort;
import model.ListOrder;
import model.QuickSort;
import model.Sort;
import view.AppView;

public class AppController {
	
	private static final int TEST_SIZE=10000;
	private static final int FIRST_PART_SIZE=100;
	private static final InsertionSort<Integer> INSERTION_SORT=new InsertionSort<Integer>();
	private static final QuickSort<Integer> QUICK_SORT=new QuickSort<Integer>();
	
	private Integer[] _list;
	private ListOrder _listOrder;
	
	private Integer[] list() {
		return this._list;
	}
	
	private void setList(Integer[] newList) {
		this._list=newList;
	}
	
	private ListOrder listOrder() {
		return this._listOrder;
	}
	
	private void setListOrder(ListOrder newListOrder) {
		this._listOrder=newListOrder;
	}
	
	private void validateWithAscendingList() {
		this.setListOrder(ListOrder.Ascending);
		this.setList(DataGenerator.ascendingList(AppController.TEST_SIZE));
		this.showFirstPartOfDataList();
		this.validateSortsAndShowResult();
	}
	
	private void validateWithDscendingList() {

		this.setListOrder(ListOrder.Descending);
		this.setList(DataGenerator.descendingList(AppController.TEST_SIZE));
		this.showFirstPartOfDataList();
		this.validateSortsAndShowResult();
	}
	
	private void validateWithRandomList() {

		this.setListOrder(ListOrder.Random);
		this.setList(DataGenerator.randomList(AppController.TEST_SIZE));
		this.showFirstPartOfDataList();
		this.validateSortsAndShowResult();
	}
	
	private void showFirstPartOfDataList() {
		AppView.output("["+this.listOrder().orderName()+" ����Ʈ] �� �� �κ�: ");
		for(int i=0; i<AppController.FIRST_PART_SIZE; i++) {
			System.out.print(this.list()[i]+" ");
		}
		AppView.outputLine("");
	}
	
	private void validateSortsAndShowResult() {
		this.validateSort(AppController.INSERTION_SORT);
		this.validateSort(AppController.QUICK_SORT);
		AppView.outputLine("");
	}
	
	private void validateSort(Sort<Integer> aSort) {
		Integer[] list=this.copyList(this._list);
		//������ ����Ʈ�� ������(�����δ� 2��) �����ϰ� �ȴ�.
		//�Ź� ���� ����Ʈ�� �����Ͽ� �����Ѵ�.
		aSort.sort(list, list.length);
		this.showValidationMessage(aSort,list);
	}
	
	private Integer[] copyList(Integer[] aList) {
		//�־��� �迭 ��ü aList[]�� ���纻�� ����� �����ش�.
		//aList[] ��ü�� �������ڹ�,
		//�迭�� ���� ��ü�� �������� �ʰ� �����Ѵ�.
		Integer[] copiedList=new Integer[aList.length];
		int i=0;
		for(Integer copyElement:aList) {
			copiedList[i++]=copyElement;
		}
		return copiedList;
	}
	
	private boolean sortedListIsValid(Integer[] aList) {
		//�־��� ����Ʈ�� ���ҵ��� ���������̸� true
		for(int i=0; i<(aList.length-1); i++) {
			if(aList[i].compareTo(aList[i+1])>0) {
				return false;
			}
		}
		return true;
	}
	
	private void showValidationMessage(Sort<Integer> aSort, Integer[] aList) {
		AppView.output("["+this.listOrder().orderName()+" ����Ʈ]�� ["+aSort.getClass().getSimpleName()+"] �� ����� ");
		if(this.sortedListIsValid(aList)) {
			AppView.outputLine("�ùٸ��ϴ�. ");
		}
		else
		{
			AppView.outputLine("�ùٸ��� �ʽ��ϴ�.. ");
		}
	}
	
	public void run() {
		AppView.outputLine("<<< ���� �˰����� ���� ����� �����ϴ� ���α׷��� �����մϴ� >>>");
		AppView.outputLine("");
		AppView.outputLine("> ���� ����� ����:");
		AppView.outputLine("");
		
		this.validateWithAscendingList();
		this.validateWithDscendingList();
		this.validateWithRandomList();
		
		AppView.outputLine("<<< ���� �˰����� ���� ����� �����ϴ� ���α׷��� �����մϴ� >>>");
		
	}
}
