import java.util.ArrayList;
import java.awt.event.KeyEvent; //imported to check for keys pressed

/**
This class is used to create and maintain a game of "Galaga"
@author Stefan Knott
@version 1.0.0
*/
public class Game 
{
    int gameLevel = 1;
    boolean gameOn = true;
    int shootCounter = 0;
    static int userShootCounter = 0;
    static User user = new User();
    static ArrayList<Npc> npcs = new ArrayList<Npc>();
    static ArrayList<Missile> missiles = new ArrayList<Missile>();
	/**Main Loop that adds, removes, draws and moves Ships and
	 * determines if the game has ended.
	 * @param args
	 */
	public static void main(String[] args)
	{	
		int userLives = 5;
		int userScore = 0;

		//Setup canvas
		StdDraw.setCanvasSize(500, 500);
		StdDraw.setXscale(0, 500);
		StdDraw.setYscale(0, 500);

		//Adds NPCs
		Type1 npc1 = new Type1();
		npcs.add(npc1);
		Type2 npc2 = new Type2();
		npcs.add(npc2);
		Type3 npc3 = new Type3();
		npcs.add(npc3);

		//Game loop
		while(true)
		{	
			StdDraw.clear(StdDraw.CYAN);
			
			user.draw();
			StdDraw.text(25, 25, "Lives: " + userLives);
			StdDraw.text(25, 425, "Score: " + userScore);
			
			//Act upon NPC array list
			for(int i = 0; i < npcs.size(); i++)
			{
				npcs.get(i).move();
				npcs.get(i).draw();
				npcs.get(i).setShootCounter(npcs.get(i).getShootCounter() + 1);
				if(npcs.get(i).getShootCounter() == 100 || 
							npcs.get(i).getShootCounter() == 200)
				{
					addMissile(npcs.get(i), -1);
					npcs.get(i).setShootCounter(0);
				}
			}

			//Act upon missile array list
			for(int j = 0; j < missiles.size(); j++)
			{
				StdDraw.rectangle(missiles.get(j).getXLoc(), missiles.get(j).getYLoc(), missiles.get(j).getMissW(), missiles.get(j).getMissH());
				missiles.get(j).move();
				
				//Check for collision of NPC missile to User
				if(user.intersect(missiles.get(j)) && missiles.get(j).getYv() != 1)
				{
					userLives--;
					missiles.remove(missiles.get(j));
					if(userLives == 0)
					{
						user.setXLoc(700);
						endGame("Lost");
					}
				}
				Missile m = missiles.get(j);
				if(m.getYLoc() < 0 || m.getYLoc() > 500) //Remove missiles out of bounds
				{
					missiles.remove(missiles.get(j));
				}
			}

			//Handle User's missles
			if(missiles.size() != 0)
			{   
				int i, k;
				for(i = 0; i < npcs.size(); i++)
				{
					for(k = 0; k < missiles.size(); k++)
					{
						//Check for collision of User missile to a NPC
						if(npcs.get(i).intersect(missiles.get(k)) && missiles.get(k).getYv() >= 0)
						{
							userScore += 50;
							npcs.remove(npcs.get(i));
							if(npcs.size() == 0)
							{
								StdDraw.clear();
								endGame("Won");
							}
							break;
						}
					}
				}
			}

			userControl(); //Pass control to user
			userShootCounter++; //Firing cool-down

			StdDraw.show(10);
		}
	}
	
	/**Method for User Control of the User Ship
	 * 
	 */
	private static void userControl()
	{
		if(StdDraw.isKeyPressed(KeyEvent.VK_LEFT))
		{
			user.setXLoc(user.getXLoc() - 10);
		}
		if(StdDraw.isKeyPressed(KeyEvent.VK_RIGHT))
		{
			user.setXLoc(user.getXLoc() + 10);
		}
		if(StdDraw.isKeyPressed(KeyEvent.VK_SPACE) && 
								userShootCounter >= 40)
		{
			userShootCounter = 0;//Reset cool-down
			user.add();
			addMissile(user, 1);//Fire
		}
	}
	
	/**Adds missile to missile array at Ship specific (x,y)
	 * 
	 * @param b Ship passed, used to set missile (x,y)
	 * @param a Desired Y Velocity for fired missile, this is
	 * 			 used to distinguish between user/npc missiles
	 */
	private static void addMissile(Ship b, int a)
	{
		Missile v = new Missile();
		v.setXLoc(b.getXLoc());
		v.setYLoc(b.getYLoc());
		v.setYv(a);
		missiles.add(v);
	}
	
	private static void endGame(String s)
	{
		while(true)
		{
			StdDraw.clear();
			StdDraw.text(250, 250, "Game Over! You " + s);
			StdDraw.show(10);
		}
	}
	
}
