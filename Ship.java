/**
This class is used to create a Ship
@author Stefan Knott
@version 1.0.0
*/
public class Ship extends MovingObject
{
	public double recH;
	public double recW;
	
	/**Constructor for basic ship
	 * 
	 */
	Ship()
	{
		super();
		recH = 10;
		recW = 10;
	}
	
	/**Returns Rectangle Width
	 * 
	 * @return recW
	 */
	public double getRecW()
	{
		return recW;
	}
	
	/**Returns Rectangle Height
	 * 
	 * @return recH
	 */
	public double getRecH()
	{
		return recH;
	}
	
	/**Sets Rectangle Width
	 * 
	 * @param a desired integer to set this.RecW to
	 */
	public void setRecW(int a)
	{
		recW = a;
	}
	
	/**Sets Rectangle Height
	 * 
	 * @param b desired integer to set this.RecH to
	 */
	public void setRecH(int b)
	{
		recH = b;
	}
	
	/**Boolean method used to determine if passed missile is 
	 * in intersection with this.Ship
	 * @param m passed missile to check intersection with
	 * @return true if intersecting, false otherwise
	 */
/*	public boolean intersect(Missile m)
	{       
		if(((m.getYLoc()-m.getMissH()/2) <= (this.getYLoc() + this.getRecH()/2))  && 
				(m.getXLoc() + m.getMissW()/2 >= this.getXLoc() - this.getRecW()/2) &&  	
				(m.getXLoc() - m.getMissW()/2 <= this.getXLoc() + this.getRecW()/2))
		{
			return true;
		}
		else
		{
			return false;
		}
	}*/
}
