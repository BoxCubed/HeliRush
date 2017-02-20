package com.HeleRush.game.objects;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import com.HeleRush.game.GameState;

public class Background {

	GameState game;
	Image bg;
	float nx=-10000,nx2,x,y;
	int bgend;
	
	
	public Background(GameState game){
		this.game=game;
		
		try {
			bg=new Image("res/bg.png");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			Logger.getLogger("Slick2D").log(Level.WARNING, "Failed to load Background", e);
			return;
		}
		bgend=-(1000-bg.getWidth());
		
		
		
		
		
	}
	
	//boolean first=true;
	public void update(int delta){
		x-=delta*0.2;
		nx-=delta*0.2;
		if(x<=bgend&&x>=-bgend+delta*0.2){nx=1000;}
		else if(nx<=bgend&&nx>=-bgend+delta*0.2){x=1000;
			
		}
	
	
	
	
	}
		
	
	
	
	public void render(Graphics g){
		
bg.draw(x, y, bg.getWidth(), 720);
		
bg.draw(nx, y, bg.getWidth(), 720);


}
	}
