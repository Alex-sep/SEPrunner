package gameObject.player;

import gameObject.AnimatedObject;


public class Player extends AnimatedObject implements Runnable {
	
	private static Player player;
	
	private Player() {
		
	}
	
	public static Player getInstance() {
		if(player == null)
			player = new Player();
		return player;
	}
	
	public static Player resetInstance() {
		return player = new Player();
	}

	
	public void run() {
		
	}
	
}
