
public class Coin {
	
	//���
	private static final int DEFAULT_VALUE=0;
	//private instance variables
	private int _value;//������ �ݾ�
	
	public Coin()
	{
		setValue(DEFAULT_VALUE);
	}
	
	public Coin(int givenValue) {
		setValue(givenValue);
	}
	
	public int value()
	{
		return this._value;
	}
	
	public void setValue(int newValue)
	{
		this._value=newValue;
	}
	
	@Override
	public boolean equals(Object otherCoin)
	{
		//otherCoin�� ����Ŭ���� ��
		if(otherCoin.getClass()!=Coin.class) {
			return false;
		}
		else// aCoin�� class�� �����ϰ� Coin class�� ����ȯ����
		{
			return (this.value()==((Coin)otherCoin).value());
		}
	}
}
