/**
This class is used to create a Ship
@author Stefan Knott
@version 1.0.0
*/
public class Ship extends MovingObject
{
	protected double recH;
	protected double recW;
	
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
	protected double getRecW()
	{
		return recW;
	}
	
	/**Returns Rectangle Height
	 * 
	 * @return recH
	 */
	protected double getRecH()
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
}
