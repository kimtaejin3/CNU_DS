
public class CellLocation {
	private static final int UndefinedIndex=-1;
	
	//private instance variables
	private int _row;
	private int _col;
	
	//기본 생성자: cell좌표가 주어지지 않는다.
	public CellLocation() {
		//cell 좌표가 주어지지 않으면 (-1,-1)로 설정하기로 한다.
		this.setRow(UndefinedIndex);
		this.setCol(UndefinedIndex);
	}
	
	public CellLocation(int givenRow, int givenCol)
	{
		this.setRow(givenRow);
		this.setCol(givenCol);
	}
	/*행과 열의 초기화 및 반환*/
	public void setRow(int newRow) {
		this._row=newRow;
	}
	
	public int row() {
		return this._row;
	}
	
	public void setCol(int newCol) {
		this._col=newCol;
	}
	
	public int col() {
		return this._col;
	}
}
