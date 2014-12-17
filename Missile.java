
/**
This class is used to create a missile
@author Stefan Knott
@version 1.0.0
*/
public class Missile extends MovingObject
{	
	private int recH; 
	private int recW; 
	
	/**Constructor for generic missile
	 * 
	 */
	Missile()
	{
		super();
		recW = 2;
		recH = 15;
	}
	
	/**Sets Missile Height
	 * 
	 * @param a desired integer to set this.recH to
	 */
	public void setMissH(int a)
	{
		recH = a;
	}
	
	/**Sets Missile Width
	 * 
	 * @param b desired integer to set this.recW to
	 */
	public void setMissW(int b)
	{
		recW = b;
	}
	
	/**Gets Missile Height
	 * 
	 * @return recH
	 */
	public int getMissH()
	{
		return recH;
	}
	
	/**Gets Missile Width
	 * 
	 * @return recW
	 */
	public int getMissW()
	{
		return recW;
	}
	
	/**Moves this missile
	 * 
	 */
	public void move()
	{
		setYLoc(getYLoc() + getYv());
	}
}
