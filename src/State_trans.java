
public class State_trans {
	private String oldState;
	private char trans;
	private String newState;
	private char transchar;
	private String direction;
	State_trans(String oldState,char trans,String newState,char transchar,String direction)
	{
		this.oldState=oldState;
		this.trans=trans;
		this.newState=newState;
		this.transchar=transchar;
		this.direction=direction;
	}
	public String getOldState()
	{
		return this.oldState;
	}
	public void setOldState(String oldState)
	{
		this.oldState=oldState;
	}
	public String getNewState()
	{
		return this.newState;
	}
	public void setNewState(String newState)
	{
		this.oldState=newState;
	}
	public char getTrans()
	{
		return this.trans;
	}
	public void setTrans(char trans)
	{
		this.trans=trans;
	}
	public char getTranschar()
	{
		return this.transchar;
	}
	public void setTranschar(char transchar)
	{
		this.transchar=transchar;
	}
	public String getDirection()
	{
		return this.direction;
	}
	public void setDirection(String direction)
	{
		this.direction=direction;
	}
	
}
