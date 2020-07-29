package controller;

import java.util.Random;

public final class DataGenerator {
	//객체 인스턴스를 필요로 하지 않고, 오로지 static constant, static variavle만 존재하게 된다.
	
	private DataGenerator() {}
	
	//모든 상수, 변수, 함수는 "Static"으로 선언.
	
	public static Integer[] ascendingList(int aSize) {
		Integer[] list=null;
		if(aSize>0) {
			list=new Integer[aSize];
			for(int i=0; i<aSize; i++) {
				list[i]=i;
			}
		}
		return list;
	}
	
	public static Integer[] descendingList(int aSize) {
		Integer[] list=null;
		if(aSize>0) {
			list=new Integer[aSize];
			for(int i=0; i<aSize; i++) {
				list[i]=aSize-i;
			}
		}
		return list;
	}
	
	public static Integer[] randomList(int aSize) {
		Integer[] list=null;
		if(aSize>0) {
			//일단 Ascending order list를 만든다.
			list=new Integer[aSize];
			for(int i=0; i<aSize; i++) {
				list[i]=i;
			}
			
			Random random=new Random();
			for(int i=0; i<aSize; i++) {
				int r=random.nextInt(aSize);
				Integer temp=list[i];
				list[i]=list[r];
				list[r]=temp;
			}
		}
		return list;
	}
	
	public static Integer[] randomListWithoutDuplication(int aSize) {
		Integer[] list = null ;
		if ( aSize > 0 ) {
			// 일단 Ascending order list 를 만든다
			list = DataGenerator.ascendingList(aSize);
			// 각 원소 list[i] 에 대해 무작위 위치 r 을 생성하여 list[i] 와 list[r] 를 맞바꾼다.
			Random random = new Random();
			for ( int i = 0 ; i < aSize; i++ ) {
				int randomIndex = random.nextInt (aSize);
				Integer temp = list[i];
				list[i] = list[randomIndex];
				list[randomIndex] = temp;
			}
		}
		return list ;

	}
}
