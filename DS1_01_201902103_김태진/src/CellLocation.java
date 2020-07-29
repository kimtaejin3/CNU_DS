
public class CellLocation {
	private static final int UndefinedIndex=-1;
	
	//private instance variables
	private int _row;
	private int _col;
	
	//�⺻ ������: cell��ǥ�� �־����� �ʴ´�.
	public CellLocation() {
		//cell ��ǥ�� �־����� ������ (-1,-1)�� �����ϱ�� �Ѵ�.
		this.setRow(UndefinedIndex);
		this.setCol(UndefinedIndex);
	}
	
	public CellLocation(int givenRow, int givenCol)
	{
		this.setRow(givenRow);
		this.setCol(givenCol);
	}
	/*��� ���� �ʱ�ȭ �� ��ȯ*/
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
