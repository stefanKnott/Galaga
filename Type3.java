/**
This class is used to create a NPC Ship of Type 3
@author Stefan Knott
@version 1.0.0
*/
public class Type3 extends Npc
{
	private int shootCounter = 140;
	
	/**Constructor for generic Type 3
	 * 
	 */
	Type3()
	{
		super();
		this.setXLoc(this.getXLoc() + 45);
		this.setRecW(20);
		this.setRecH(15);
	}
	
	/**Method to draw Type3 Npc
	 * 
	 */
	public void draw()
	{
		StdDraw.filledRectangle(this.getXLoc(), this.getYLoc(), this.getRecW(), this.getRecH());
	}
	
	/**Sets shootCounter of this.Type3
	 * 
	 * @param a desired int to set this.shootCounter to
	 */
	public void setShootCounter(int a)
	{
		shootCounter = a;
	}
	
	/**Gets shootCounter of this.Type3
	 * 
	 * @return shootCounter
	 */
	public int getShootCounter()
	{
		return shootCounter;
	}
}
