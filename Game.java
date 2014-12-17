import java.util.ArrayList;
import java.awt.event.KeyEvent; //imported to check for keys pressed

/**
This class is used to create and maintain a game of "Galaga"
@author Stefan Knott
@version 1.0.0
*/
public class Game 
{
    private boolean gameOn = true;
    private int shootCounter = 0;
    private static int userShootCounter = 0;
    private static User user = new User();
    private static ArrayList<Npc> npcs = new ArrayList<Npc>();
    private static ArrayList<Missile> missiles = new ArrayList<Missile>();
	

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
	
	/**Displays the end result of the game
	 * @param s End game result to display
	 */
	private static void endGame(String s)
	{
		while(true)
		{
			StdDraw.clear();
			StdDraw.text(250, 250, "Game Over! You " + s);
			StdDraw.show(10);
		}
	}


	/**Moves and draws NPCs, as well as fires their missiles
	*/
	private static void npc_act()
	{
		//Sanity check
		if(npcs.size() > 0)
		{
			//Act upon NPC array list
			for(int i = 0; i < npcs.size(); i++)
			{
				npcs.get(i).move();
				npcs.get(i).draw();
				npcs.get(i).setShootCounter(npcs.get(i).getShootCounter() + 1);
				if(npcs.get(i).getShootCounter() == 100 || npcs.get(i).getShootCounter() == 200)
				{
					addMissile(npcs.get(i), -1);
					npcs.get(i).setShootCounter(0);
				}
			}
		}
	}

	/**Checks if a NPC missile has hit User ship
	 * @return userLives Remaining user lives (-1 per hit by NPC missile)
	*/
	private static int handle_npc_missiles(int userLives)
	{
		//Sanity check
		if(missiles.size() >= 0)
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
				//Remove out of bounds missiles
				if(m.getYLoc() < 0 || m.getYLoc() > 500)
				{
					missiles.remove(missiles.get(j));
				}
			}
			return userLives;
	}

	/**Checks if a User missile has hit a NPC ship
	 * @return userScore Current user score (+50 per NPC ship shot)
	*/
	private static int handle_usr_missiles(int userScore)
	{
		//Sanity check
		if(missiles.size() >= 0 && npcs.size() > 0)
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
		return userScore;
	}
	
	/**Holds main loop of the game
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
			

		//Add NPCs
		Type1 npc1 = new Type1();
		npcs.add(npc1);
		Type2 npc2 = new Type2();
		npcs.add(npc2);
		Type3 npc3 = new Type3();
		npcs.add(npc3);

		while(true)
		{
			StdDraw.clear(StdDraw.CYAN);	
			StdDraw.text(25, 25, "Lives: " + userLives);
			StdDraw.text(25, 425, "Score: " + userScore);
			user.draw();
		
			//Move and draw NPCs
			npc_act();
			//Handle npc missiles
			userLives = handle_npc_missiles(userLives);
			//Handle User's missles
			userScore = handle_usr_missiles(userScore);
			//Read user's control input
			userControl();
			//Firing cooldown
			userShootCounter++;
			StdDraw.show(10);
		}
	}
}
	
