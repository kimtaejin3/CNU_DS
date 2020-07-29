
public class AppController {//실질적인 메인클래스
	public static final int MIN_ORDER=3;
	public static final int MAX_ORDER=99;
	
	private MagicSquare _magicSquare;
	
	public AppController()//생성자
	{
		//모델객체 생성
		this._magicSquare=new MagicSquare(AppController.MAX_ORDER);//magicSquare의 생성
	}
	
	/*프로그램의 전체 실행을 담당하는 메서드*/
	public void run()
	{
		AppView.outputLine("<<< 마방진 풀이를 시작합니다 >>>");
		AppView.outputLine("");
		
		AppView.output("? 마방진 차수를 입력하시오 (음수를 입력하면 종료합니다):");
		int currentOrder=AppView.inputOrder();// 메세지를 내보내고 차수를 입력 받음
		OrderValidity currentValidity=OrderValidity.validityOf(currentOrder);
		while(currentValidity!=OrderValidity.EndOfRun){//차수가 음수이면 프로그램 종료
			if(currentValidity==OrderValidity.Valid) {
				AppView.outputTitleWithOrder(currentOrder);
				Board solvedBoard=this._magicSquare.solve(currentOrder);
					//객체에게 주어진 차수의 마방진을 풀도록 시킨다.
					//결과로 마방진 판을 얻는다.
				this.showBoard(solvedBoard);//마방진은 화면에 보여준다.
			}else {
				this.showOrderValidityErrorMessage(currentValidity);
			}
			AppView.output("? 마방진 차수를 입력하시오 (음수를 입력하면 종료합니다):");
			currentOrder=AppView.inputOrder();//다음 마방진을 위해 차수를 입력받음.
			currentValidity=OrderValidity.validityOf(currentOrder);
		}
		AppView.outputLine("");
		AppView.outputLine("<<< 마방진 풀이를 종료합니다.>>>");
	}
	
	/*model의 요소인 본 메소드를 통해 view에게 오류메세지를 출력하도록 지시간다.*/
	private void showOrderValidityErrorMessage(OrderValidity orderValidity)//인자로는 enum클래스를 받는다.
	{
		switch(orderValidity)
		{
			case TooSmall:
				AppView.outputLine("[오류] 차수가 너무 작습니다."+AppController.MIN_ORDER+
						"보다 크거나 같아야 합니다.\n");
				break;
			case TooLarge:
				AppView.outputLine("[오류] 차수가 너무 큽니다."+AppController.MAX_ORDER+
				"보다 작거나 같아야 합니다.\n");
				break;
			case NotOddNumber:
				AppView.outputLine("[오규] 차수가 짝수입니다. 홀수이어야 합니다.\n");
				break;
			default:
				break;
		}
		
	}
	
	private void showBoard(Board board)//마방진 출력
	{
		CellLocation currentLoc=new CellLocation();
		this.showTitleForColumnIndexes(board.order());
		for(int row=0; row<board.order(); row++) {
			AppView.outputRowNumber(row);// 한 행에 표지 출력
			for(int col=0; col<board.order(); col++)
			{
				currentLoc.setRow(row);
				currentLoc.setCol(col);
				AppView.outputCellValue(board.cellValue(currentLoc));
			}
			AppView.outputLine("");
		}
		AppView.outputLine("");
	}

	/*column인덱스를 출력하기 위한 함수이다. 역시 view에게 값을 준다.*/
	private void showTitleForColumnIndexes(int order) {//인덱스 출력
		AppView.output("      ");//ouputLine()보다 적합하다.
		for(int col=0; col<order; col++)
		{
			AppView.output(String.format(" [%4d]", col));//3
		}
		AppView.outputLine("");
	}
}
