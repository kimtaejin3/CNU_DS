
public class MagicSquare {
	private static final int DEFAULT_MAX_ORDER=99;
	private int _maxOrder;
	
	//�����Լ�
	public int maxOrder()
	{
		//�������� �� ������ �ִ� ������ ��´�.
		return this._maxOrder;
	}
	
	public void setMaxOrder(int newMaxOrder) {
		this._maxOrder=newMaxOrder;
	}
	//�⺻ ������
	public MagicSquare()
	{
		this.setMaxOrder(MagicSquare.DEFAULT_MAX_ORDER);
	}
	
	//�ִ� ������ ����ڰ� �����ϴ� ������
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
				//������ �Բ� Board ��ü �����ڸ� call�Ͽ�, Board��ü�� �����Ѵ�.
			CellLocation currentLoc=new CellLocation(0,anOrder/2);
				//��� ��ġ (������ �� ���� �� ���)�� ������ ��ġ�� �����Ѵ�.
			CellLocation nextLoc=new CellLocation();
			board.setCellValue(currentLoc, 1);//������ �����ġ�� 1�� �����.
			
			int lastValue=anOrder*anOrder;
			for(int cellValue=2; cellValue<=lastValue; cellValue++)
			{
				//������ġ�κ��� ���� ��ġ�� ���(������ ��)
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
				//���� ��ġ�� ä���� �ִٸ� �ٷ� �� �� �Ʒ�ĭ ��ġ�� ����
				if(!board.cellIsEmpty(nextLoc))
				{
					if(currentLoc.row()+1>=anOrder) {
						nextLoc.setRow(0);
					}else {
						nextLoc.setRow(currentLoc.row()+1);
					}
					nextLoc.setCol(currentLoc.col());
				}
				//������ġ�� ������ġ�� �Ѵ�.
				currentLoc.setRow(nextLoc.row());
				currentLoc.setCol(nextLoc.col());
				//���ο� ������ġ�� ���ο� ���� �ִ´�.
				board.setCellValue(currentLoc, cellValue);
			}
			return board;
		}
	}
}
