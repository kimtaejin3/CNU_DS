
public class AppController {
	
	private static final int MENU_ADD=1;
	private static final int MENU_REMOVE=2;
	private static final int MENU_SEARCH=3;
	private static final int MENU_FREQUENCY=4;
	private static final int MENU_END_OF_RUN=9;
	private LinkedBag<Coin> _coinBag;
	
	// ����� �Լ��� ����
	private LinkedBag<Coin>coinBag()
	{
		return this._coinBag;
	}
	private void setCoinBag(LinkedBag<Coin> newCoinBag)
	{
		this._coinBag=newCoinBag;
	}
	private void addCoin () {
		if(this.coinBag().isFull()) {
			AppView.outputLine("- ���� ������ �� ���� ���� �� �����ϴ�. ");//�޸� �ʰ��ϴ� ��츦 �������� �ʾ��� ��, ����Ǵ� ���� ������ ����.
		}
		else
		{
			int coinValue=AppView.inputCoinValue();//�Է°��� ����ó�� �ʿ�
			
			//addCoin����  ���� �ֱ⸦ ������� ������ �ٸ� ������ ���� �ʿ����.
			while(coinValue<0) 
			{
				AppView.outputLine("������ �Է����� ������."); 
				coinValue=AppView.inputCoinValue(); 
			}
			
			if(this.coinBag().add(new Coin(coinValue))) {
				AppView.outputLine("- �־��� ���� ���� ������ ���濡 �ִµ� �����߽��ϴ�.");
			}
			else {
				AppView.outputLine("- �־��� ���� ���� ������ ���濡 �ִµ� �����Ͽ����ϴ�.");
			}
		}
	}
	private void removeCoin () {
		int coinValue=AppView.inputCoinValue();
		if(!this.coinBag().remove(new Coin(coinValue))) {
			AppView.outputLine("- �־��� ���� ���� ������ ���� �ȿ� �������� �ʽ��ϴ�.") ;
		}
		else
		{
			AppView.outputLine ("- �־��� ���� ���� ���� �ϳ��� ���濡�� ���������� �����Ǿ����ϴ�.") ;
		}
	}
	
	private void searchForCoin () {
		int coinValue=AppView.inputCoinValue();
		if(this.coinBag().doesContain(new Coin(coinValue)))
		{
			AppView.outputLine ("- �־��� ���� ���� ������ ���� �ȿ� �����մϴ�.") ;
		}
		else
		{
			AppView.outputLine("- �־��� ���� ���� ������ ���� �ȿ� �������� �ʽ��ϴ�.") ;
		}
	}
	private void frequencyOfCoin () {
		int coinValue=AppView.inputCoinValue();
		int frequency=this.coinBag().frequencyOf(new Coin(coinValue));
		AppView.outputLine("- �־��� ���� ���� ������ ������ "+frequency+" �� �Դϴ�.");
	}
	private void undefinedMenuNumber (int amenuNumber) {
		AppView.outputLine("- ���õ� �޴� ��ȣ "+amenuNumber+" �� �߸��� ��ȣ�Դϴ�.");
	}
	private int sumOfCoinValue()
	{
		int sum=0;
		for(int i=0; i<this.coinBag().size(); i++)
		{
			sum+=this.coinBag().elementAt(i).value();
		}
		return sum;
	}
	
	private int maxCoinValue() {
		int maxValue=0;
		for(int i=0; i<this.coinBag().size(); i++)
		{
			if(maxValue<this.coinBag().elementAt(i).value()) {
				maxValue=this.coinBag().elementAt(i).value();
			}
		}
		return maxValue;
	}
	
	private void showStatistics () {
		AppView.outputLine("���濡 ��� �ִ� ������ ����: "+this.coinBag().size());
		AppView.outputLine("���� �� ���� ū ��:"+this.maxCoinValue());
		AppView.outputLine("��� ���� ���� ��:"+this.sumOfCoinValue());
	}
	
	
	//�����Լ�
	public void run() {
		AppView.outputLine("<<< ���� ���� ���α׷��� �����մϴ� >>>");
		AppView.outputLine("");
		
		this.setCoinBag(new LinkedBag<Coin>());
	
		int menuNumber=AppView.inputMenuNumber();
		while(menuNumber!=MENU_END_OF_RUN) {
			switch(menuNumber) {
			case MENU_ADD:
				this.addCoin();
				break;
			case MENU_REMOVE:
				this.removeCoin();
				break;
			case MENU_SEARCH:
				this.searchForCoin();
				break;
			case MENU_FREQUENCY:
				this.frequencyOfCoin();
				break;
			default:
				this.undefinedMenuNumber(menuNumber);	
			}
			
			menuNumber=AppView.inputMenuNumber();
		}
		AppView.outputLine("- ���濡 ���� ������ �����մϴ�.");
		this.showStatistics();
		AppView.outputLine("");
		AppView.outputLine("<<< ���� ���� ���α׷��� �����մϴ� >>>");
	}
	
	
}
