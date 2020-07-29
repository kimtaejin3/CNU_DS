
public class AppController {//�������� ����Ŭ����
	public static final int MIN_ORDER=3;
	public static final int MAX_ORDER=99;
	
	private MagicSquare _magicSquare;
	
	public AppController()//������
	{
		//�𵨰�ü ����
		this._magicSquare=new MagicSquare(AppController.MAX_ORDER);//magicSquare�� ����
	}
	
	/*���α׷��� ��ü ������ ����ϴ� �޼���*/
	public void run()
	{
		AppView.outputLine("<<< ������ Ǯ�̸� �����մϴ� >>>");
		AppView.outputLine("");
		
		AppView.output("? ������ ������ �Է��Ͻÿ� (������ �Է��ϸ� �����մϴ�):");
		int currentOrder=AppView.inputOrder();// �޼����� �������� ������ �Է� ����
		OrderValidity currentValidity=OrderValidity.validityOf(currentOrder);
		while(currentValidity!=OrderValidity.EndOfRun){//������ �����̸� ���α׷� ����
			if(currentValidity==OrderValidity.Valid) {
				AppView.outputTitleWithOrder(currentOrder);
				Board solvedBoard=this._magicSquare.solve(currentOrder);
					//��ü���� �־��� ������ �������� Ǯ���� ��Ų��.
					//����� ������ ���� ��´�.
				this.showBoard(solvedBoard);//�������� ȭ�鿡 �����ش�.
			}else {
				this.showOrderValidityErrorMessage(currentValidity);
			}
			AppView.output("? ������ ������ �Է��Ͻÿ� (������ �Է��ϸ� �����մϴ�):");
			currentOrder=AppView.inputOrder();//���� �������� ���� ������ �Է¹���.
			currentValidity=OrderValidity.validityOf(currentOrder);
		}
		AppView.outputLine("");
		AppView.outputLine("<<< ������ Ǯ�̸� �����մϴ�.>>>");
	}
	
	/*model�� ����� �� �޼ҵ带 ���� view���� �����޼����� ����ϵ��� ���ð���.*/
	private void showOrderValidityErrorMessage(OrderValidity orderValidity)//���ڷδ� enumŬ������ �޴´�.
	{
		switch(orderValidity)
		{
			case TooSmall:
				AppView.outputLine("[����] ������ �ʹ� �۽��ϴ�."+AppController.MIN_ORDER+
						"���� ũ�ų� ���ƾ� �մϴ�.\n");
				break;
			case TooLarge:
				AppView.outputLine("[����] ������ �ʹ� Ů�ϴ�."+AppController.MAX_ORDER+
				"���� �۰ų� ���ƾ� �մϴ�.\n");
				break;
			case NotOddNumber:
				AppView.outputLine("[����] ������ ¦���Դϴ�. Ȧ���̾�� �մϴ�.\n");
				break;
			default:
				break;
		}
		
	}
	
	private void showBoard(Board board)//������ ���
	{
		CellLocation currentLoc=new CellLocation();
		this.showTitleForColumnIndexes(board.order());
		for(int row=0; row<board.order(); row++) {
			AppView.outputRowNumber(row);// �� �࿡ ǥ�� ���
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

	/*column�ε����� ����ϱ� ���� �Լ��̴�. ���� view���� ���� �ش�.*/
	private void showTitleForColumnIndexes(int order) {//�ε��� ���
		AppView.output("      ");//ouputLine()���� �����ϴ�.
		for(int col=0; col<order; col++)
		{
			AppView.output(String.format(" [%4d]", col));//3
		}
		AppView.outputLine("");
	}
}
