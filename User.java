/**
This class is used to create a User Ship
@author Stefan Knott
@version 1.0.0
*/
public class User extends Ship
{
	/**Constructor for general User Ship
	 * 
	 */
	User()
	{
		super();
		this.setXLoc(225);
		this.setYLoc(20);
	}
	
	/**Method used to draw User Ship
	 * 
	 */
	public void draw()
	{
		StdDraw.filledRectangle(this.getXLoc(), this.getYLoc(), 
				this.getRecW(), this.getRecH());	
	}
	
	/**Method used to add missile
	 * 
	 */
	public void add()
	{
		Missile m = new Missile();
		m.setYv(1);
		m.setXLoc(this.getXLoc());
		m.setYLoc(this.getYLoc());
	}
	
	public boolean intersect(Missile m)
	{       
		if(((m.getYLoc() - m.getMissH()/2) <= (this.getYLoc() + this.getRecH()/2))  && 
				(m.getXLoc() + m.getMissW()/2 >= this.getXLoc() - this.getRecW()/2) &&  	
				(m.getXLoc() - m.getMissW()/2 <= this.getXLoc() + this.getRecW()/2))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	


}
