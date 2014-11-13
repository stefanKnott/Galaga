
/**
This class is used to create any MovingObject in the game.
Serves as parent class for Npc, User, and Missile
@author Stefan Knott
@version 1.0.0
*/
public class MovingObject 
{		
	public double xV;
	public double yV;
	public double xLoc;
	public double yLoc;
	
	/**Constructs generic MovingObject
	 * 
	 */
	MovingObject()
	{
		xV = 1;
		yV = 1;
		xLoc = 0;
		yLoc = 0;
	}
	
	/**Returns X Velocity
	 * 
	 * @return X Velocity of this.MovingObject
	 */
	public double getXv()
	{
		return xV;
	}
	
	/**Returns Y Velocity
	 * 
	 * @return Y Velocity of this.MovingObject
	 */
	public double getYv()
	{
		return yV;
	}
	
	/**Returns X Location
	 * 
	 * @return X Location of this.MovingObject
	 */
	public double getXLoc()
	{
		return xLoc;
	}
	
	/**Returns Y Location
	 * 
	 * @return Y Location of this.MovingObject
	 */
	public double getYLoc()
	{
		return yLoc;
	}
	
	/**Sets X Velocity
	 * 
	 * @param a desired double to set this.Xv to
	 */
	public void setXv(double a)
	{
		xV = a;
	}
	
	/**Sets Y Velocity
	 * 
	 * @param b desired double to set this.Yv to
	 */
	public void setYv(double b)
	{
		yV = b;
	}
	
	/**Sets X Location
	 * 
	 * @param c desired double to set this.XLoc to
	 */
	public void setXLoc(double c)
	{
		xLoc = c;
	}
	
	/**Sets Y Location
	 * 
	 * @param d desired double to set this.YLoc to
	 */
	public void setYLoc(double d)
	{
		yLoc = d;
	}
}
