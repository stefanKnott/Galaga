/**
This class is used to create a NPC Ship of Type 1
@author Stefan Knott
@version 1.0.0
*/
public class Type1 extends Npc 
{
	private int shootCounter = 0;
	/**Constructor for generic Type 1
	 * 
	 */
	Type1()
	{
		super();
		this.setRecW(15);
		this.setRecH(3);
	}
	
	/**Method to draw Type1 Npc
	 * 
	 */
	public void draw()
	{
		StdDraw.filledRectangle(this.getXLoc(), this.getYLoc(), this.getRecW(), this.getRecH());
	}
	
	/**Sets shootCounter of this.Type1
	 * 
	 * @param a desired int to set this.shootCounter to
	 */
	public void setShootCounter(int a)
	{
		shootCounter = a;
	}

	/**Gets shootCounter of this.Type1
	 * 
	 * @return shootCounter
	 */
	public int getShootCounter()
	{
		return shootCounter;
	}
}
