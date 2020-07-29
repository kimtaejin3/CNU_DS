
public enum OrderValidity {// 열거형 클래스
	EndOfRun, 
	Valid, 
	TooSmall, 
	TooLarge, 
	NotOddNumber; 
	
					//반환형은 OrderValidity
	public static OrderValidity validityOf(int order)
	{
		if(order<0) {
			return OrderValidity.EndOfRun;
		}
		else if(order<AppController.MIN_ORDER) {
			return OrderValidity.TooSmall;
		}
		else if(order>AppController.MAX_ORDER) {
			return OrderValidity.TooLarge;
		}
		else if(order%2==0) {
			return OrderValidity.NotOddNumber;
		}
		else {
			return OrderValidity.Valid;
		}
	}
}
