
public class AppController {
	
	private static final int MENU_ADD=1;
	private static final int MENU_REMOVE=2;
	private static final int MENU_SEARCH=3;
	private static final int MENU_FREQUENCY=4;
	private static final int MENU_END_OF_RUN=9;
	private LinkedBag<Coin> _coinBag;
	
	// 비공개 함수의 구현
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
			AppView.outputLine("- 동전 가방이 꽉 차서 넣을 수 없습니다. ");//메모리 초과하는 경우를 생각하지 않았을 때, 실행되는 경우는 없지만 쓴다.
		}
		else
		{
			int coinValue=AppView.inputCoinValue();//입력값의 오류처리 필요
			
			//addCoin에만  음수 넣기를 허용하지 않으면 다른 값들은 넣을 필요없음.
			while(coinValue<0) 
			{
				AppView.outputLine("음수를 입력하지 마세요."); 
				coinValue=AppView.inputCoinValue(); 
			}
			
			if(this.coinBag().add(new Coin(coinValue))) {
				AppView.outputLine("- 주어진 값을 갖는 동전을 가방에 넣는데 성공했습니다.");
			}
			else {
				AppView.outputLine("- 주어진 값을 갖는 동전을 가방에 넣는데 실패하였습니다.");
			}
		}
	}
	private void removeCoin () {
		int coinValue=AppView.inputCoinValue();
		if(!this.coinBag().remove(new Coin(coinValue))) {
			AppView.outputLine("- 주어진 값을 갖는 동전은 가방 안에 존재하지 않습니다.") ;
		}
		else
		{
			AppView.outputLine ("- 주어진 값을 갖는 동전 하나가 가방에서 정상적으로 삭제되었습니다.") ;
		}
	}
	
	private void searchForCoin () {
		int coinValue=AppView.inputCoinValue();
		if(this.coinBag().doesContain(new Coin(coinValue)))
		{
			AppView.outputLine ("- 주어진 값을 갖는 동전이 가방 안에 존재합니다.") ;
		}
		else
		{
			AppView.outputLine("- 주어진 값을 갖는 동전은 가방 안에 존재하지 않습니다.") ;
		}
	}
	private void frequencyOfCoin () {
		int coinValue=AppView.inputCoinValue();
		int frequency=this.coinBag().frequencyOf(new Coin(coinValue));
		AppView.outputLine("- 주어진 값을 갖는 동전의 개수는 "+frequency+" 개 입니다.");
	}
	private void undefinedMenuNumber (int amenuNumber) {
		AppView.outputLine("- 선택된 메뉴 번호 "+amenuNumber+" 는 잘못된 번호입니다.");
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
		AppView.outputLine("가방에 들어 있는 동전의 개수: "+this.coinBag().size());
		AppView.outputLine("동전 중 가장 큰 값:"+this.maxCoinValue());
		AppView.outputLine("모든 동전 값의 합:"+this.sumOfCoinValue());
	}
	
	
	//공개함수
	public void run() {
		AppView.outputLine("<<< 동전 가방 프로그램을 시작합니다 >>>");
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
		AppView.outputLine("- 가방에 대한 수행을 종료합니다.");
		this.showStatistics();
		AppView.outputLine("");
		AppView.outputLine("<<< 동전 가방 프로그램을 종료합니다 >>>");
	}
	
	
}
