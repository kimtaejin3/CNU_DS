
public class MagicSquare {
	private static final int DEFAULT_MAX_ORDER=99;
	private int _maxOrder;
	
	//공개함수
	public int maxOrder()
	{
		//마방진의 현 상태의 최대 차수를 얻는다.
		return this._maxOrder;
	}
	
	public void setMaxOrder(int newMaxOrder) {
		this._maxOrder=newMaxOrder;
	}
	//기본 생성자
	public MagicSquare()
	{
		this.setMaxOrder(MagicSquare.DEFAULT_MAX_ORDER);
	}
	
	//최대 차수를 사용자가 지정하는 생성자
	public MagicSquare(int givenMaxOrder)
	{
		this.setMaxOrder(givenMaxOrder);
	}
	
	public Board solve(int anOrder)
	{
		if(OrderValidity.validityOf(anOrder)!=OrderValidity.Valid)
		{
			return null;
		}
		else {
			Board board=new Board(anOrder);
				//차수와 함께 Board 객체 생성자를 call하여, Board객체를 생성한다.
			CellLocation currentLoc=new CellLocation(0,anOrder/2);
				//출발 위치 (보드의 맨 윗줄 한 가운데)를 현재의 위치로 설정한다.
			CellLocation nextLoc=new CellLocation();
			board.setCellValue(currentLoc, 1);//보드의 출발위치에 1을 세운다.
			
			int lastValue=anOrder*anOrder;
			for(int cellValue=2; cellValue<=lastValue; cellValue++)
			{
				//현재위치로부터 다음 위치를 계산(오츤쪽 위)
				if(currentLoc.row()-1<0) {
					nextLoc.setRow(anOrder-1);
				}else {
					nextLoc.setRow(currentLoc.row()-1);
				}
				
				if(currentLoc.col()+1>=anOrder) {
					nextLoc.setCol(0);
				}else {
					nextLoc.setCol(currentLoc.col()+1);
				}
				//다음 위치가 채워져 있다면 바로 한 줄 아래칸 위치로 수정
				if(!board.cellIsEmpty(nextLoc))
				{
					if(currentLoc.row()+1>=anOrder) {
						nextLoc.setRow(0);
					}else {
						nextLoc.setRow(currentLoc.row()+1);
					}
					nextLoc.setCol(currentLoc.col());
				}
				//다음위치를 현재위치로 한다.
				currentLoc.setRow(nextLoc.row());
				currentLoc.setCol(nextLoc.col());
				//새로운 현재위치에 새로운 값을 넣는다.
				board.setCellValue(currentLoc, cellValue);
			}
			return board;
		}
	}
}
