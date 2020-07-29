
public class Board {
	//상수
	private static int EMPTY_CELL=-1;
	
	private int _order;
	private int[][] _cells;
	
	// 기본 생성자 
	public Board(int givenOrder)
	{
		this.setOrder(givenOrder);
		this.setCells(new int[givenOrder][givenOrder]);
		for(int row=0; row<givenOrder; row++)
		{
			for(int col=0; col<givenOrder; col++)
			{
				this.setCellValue(row, col, Board.EMPTY_CELL);
			}
		}
	}
	/*차수설정과 반환*/
	public int order() {
		return this._order;
	}
	
	private void setOrder(int newOrder)
	{
		this._order=newOrder;
	}
	
	// public method
	public boolean cellIsEmpty(CellLocation location)
	{
		return(this.cellValue(location)==EMPTY_CELL);
	}
	
	/*배열 초기화와 반환*/
	private int[][] cells()
	{
		return this._cells;
	}
	
	private void setCells(int[][] newCells) {
		this._cells=newCells;
	}
	
	/*cellValue의 설정과 반환*/
	public int cellValue(CellLocation location) {
		// 주어진 location 의 cell 값을 얻는다.
		return this.cells()[location.row()][location.col()];
	}
	
	public void setCellValue(CellLocation location, int value)
	{
		// 주어진 location 의 cell 에 주어진 value 를 넣는다. 
		this.cells()[location.row()][location.col()]=value;
	}
	
	private void setCellValue(int row, int col, int value)
	{
		// 이 method 는 class 내부에서만 사용한다. 
		// 주어진 위치 의 (row, col)의 cell 에 주어진 값 value 를 넣는다.
		this._cells[row][col]=value;
	}
}
