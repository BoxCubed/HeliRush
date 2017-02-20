package com.HeleRush.game.objects;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.PackedSpriteSheet;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import com.HeleRush.game.GameState;
import com.util.easingLib.*;

public class Helicopter {
	GameState game;
	PackedSpriteSheet sheet;
	Animation move,explode;
	Image[] movei,explodei;
	public boolean useMouse=true;
	 private Rectangle hele=new Rectangle(100, 720/2, 180, 95);
	
	public Helicopter(GameState game ) {
		this.game=game;
		try {
			sheet=new PackedSpriteSheet("res/helicopter.def");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		movei=new Image[7];
		explodei=new Image[7];
		for(int i=0;i<=6;i++){
			movei[i]=sheet.getSprite("rotate/"+i);
			movei[i].rotate(20);
		}
		for(int i=0;i<=6;i++){
			explodei[i]=sheet.getSprite("Explode/"+i);
		
		}
		explodei[5]=explodei[5].getFlippedCopy(true, false);
		explodei[6]=explodei[6].getFlippedCopy(true, false);
		move=new Animation(movei, 100);
		explode=new Animation(explodei,250);
		
		
		
				
		// TODO Auto-generated constructor stub
	}
	 float b=0;
	 float c=500;
	 int d;
	public int frames=0;
	boolean resetcrash=false;
	public long elapsedtime,melapsedtime;
	public void update(int delta,GameContainer gc){
		
		d=2000;
		if(game.isCrashed()){
			if(!resetcrash){
				frames=0;
				elapsedtime=0;
				resetcrash=true;
			}
			if(frames<d)
				frames++;
				if(elapsedtime<d)
					elapsedtime+=delta;
			   
				if(frames==1){b=getCBox().getY();}
				getCBox().setY(Bounce.easeOut(elapsedtime, b, 720-b-getCBox().getHeight(), d));
				//c+=10;
				return;
		}
		move.update(delta);
		explode.update(delta);
		Input i=gc.getInput();
		if(i.isKeyDown(Input.KEY_DOWN)&&i.isKeyDown(Input.KEY_UP))return;
		
		if(i.isKeyDown(Input.KEY_DOWN)){
			useMouse=false;
			melapsedtime=0;
			if(frames<d)
			frames++;
			if(elapsedtime<d)
				elapsedtime+=delta;
		   
			if(frames==1){b=getCBox().getY();}
			getCBox().setY(Quad.easeOut(elapsedtime, b, 720-b-getCBox().getHeight(), d));
			//c+=10;
			return;
		}
		else if(i.isKeyDown(Input.KEY_UP)){
			useMouse=false;
			melapsedtime=0;
			if(frames<d)
			frames++;
			else return;
			if(elapsedtime<d)
				elapsedtime+=delta;
		   
			if(frames==1){b=getCBox().getY();}
			getCBox().setY(Quad.easeOut(elapsedtime, b, -b, d));
			return;
		}
		
		
		
		
		
		
		
		if(i.getMouseY()!=getCBox().getCenterY()&&useMouse){
			//System.out.println("mousemoove");
			
			/*if(frames<d)
				
				else return;*/
			frames++;
				if(melapsedtime<d)
					melapsedtime+=delta;
			   
				if(frames==1)b=getCBox().getY();
				
				getCBox().setCenterY(Quad.easeOut(melapsedtime, b,i.getMouseY()-b, d));
				
				return;
		}else {melapsedtime=0; b=i.getMouseY();}
		
		//explode.update(delta);
	}
	int frame;
	public void render(Graphics g){
		
		if(game.isCrashed()){
			
		explode.draw(getCBox().getX(), getCBox().getY());
		explode.stopAt(6);
		}
		
		else move.draw(getCBox().getX(), getCBox().getY());
		
		g.draw(getCBox());
		g.drawString("press r to restart", 50, 50);
				
	}
	public Rectangle getCBox() {
		return hele;
	}
	public void setCBox(Rectangle hele) {
		this.hele = hele;
	}
	
	

}
