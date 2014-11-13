
/**
This class is used to create a NPC Ship
@author Stefan Knott
@version 1.0.0
*/
public abstract class Npc extends Ship
{
	/**Constructor for general Npc
	 * 
	 */
	Npc()
	{
		super();
		this.setXv(Math.random() - 1);
		this.setYv(Math.random() - 1);
		this.setXLoc(20 + ((int)Math.random()*25));
		this.setYLoc(400 - ((int)Math.random()*5));
	}
	
	/**Method used to move Npc
	 * 
	 */
	public void move()
	{
		this.setXLoc(this.getXLoc() + this.getXv());
		this.setYLoc(this.getYLoc() + this.getYv());
		if(this.getXLoc() <= 0 || this.getXLoc() >= 500)
		{
			this.setXv(this.getXv() * -1);
		}
		if(this.getYLoc() <= 250 || this.getYLoc() >= 500)
		{
			this.setYv(this.getYv() * -1);
		}
	}
	public boolean intersect(Missile m)
	{       
		if(((m.getYLoc() + m.getMissH()/2) >= (this.getYLoc() - this.getRecH()/2))  && 
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
	/**Abstract Class
	 * 
	 */
	public abstract void draw();
	/**Abstract Class
	 * 
	 */
	public abstract int getShootCounter();
	/**Abstract Class
	 * 
	 */
	public abstract void setShootCounter(int a);
}
