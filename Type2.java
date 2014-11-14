/**
This class is used to create a NPC Ship of Type 2
@author Stefan Knott
@version 1.0.0
*/
public class Type2 extends Npc
{
	public int shootCounter = 70;
	/**Constructor for generic Type 2
	 * 
	 */
	Type2()
	{
		super();
		this.setYLoc(this.getYLoc() + 85);
		this.setRecW(8);
		this.setRecH(10);
	}
	
	/**Method to draw Type2 Npc
	 * 
	 */
	public void draw()
	{
		StdDraw.filledRectangle(this.getXLoc() + ((int)Math.random() * 30), 
				this.getYLoc() + ((int)Math.random() * 20), this.getRecW(), this.getRecH());
	}
	
	/**Sets shootCounter of this.Type2
	 * 
	 * @param a desired int to set this.shootCounter to
	 */
	public void setShootCounter(int a)
	{
		shootCounter = a;
	}
	
	/**Gets shootCounter of this.Type2
	 * 
	 * @return shootCounter
	 */
	public int getShootCounter()
	{
		return shootCounter;
	}
}
