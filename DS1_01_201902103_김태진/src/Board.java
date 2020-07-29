
public class Board {
	//���
	private static int EMPTY_CELL=-1;
	
	private int _order;
	private int[][] _cells;
	
	// �⺻ ������ 
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
	/*���������� ��ȯ*/
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
	
	/*�迭 �ʱ�ȭ�� ��ȯ*/
	private int[][] cells()
	{
		return this._cells;
	}
	
	private void setCells(int[][] newCells) {
		this._cells=newCells;
	}
	
	/*cellValue�� ������ ��ȯ*/
	public int cellValue(CellLocation location) {
		// �־��� location �� cell ���� ��´�.
		return this.cells()[location.row()][location.col()];
	}
	
	public void setCellValue(CellLocation location, int value)
	{
		// �־��� location �� cell �� �־��� value �� �ִ´�. 
		this.cells()[location.row()][location.col()]=value;
	}
	
	private void setCellValue(int row, int col, int value)
	{
		// �� method �� class ���ο����� ����Ѵ�. 
		// �־��� ��ġ �� (row, col)�� cell �� �־��� �� value �� �ִ´�.
		this._cells[row][col]=value;
	}
}
