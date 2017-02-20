package com.HeleRush.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.HeleRush.game.objects.Background;
import com.HeleRush.game.objects.Helicopter;
import com.HeleRush.game.objects.Pillar;

public class GameState extends BasicGameState {
Rectangle hele;
 int frames=0;
public float speed=0.4f;
public Helicopter h;
Background bg;

List<Pillar> l;


private boolean crashed=false;
	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		// TODO Auto-generated method stub
		new Background(this);
		l=new ArrayList<Pillar>();
h=new Helicopter(this);
bg=new Background(this);
gc.getGraphics().setBackground(Color.blue);
HeleKeyListener l=new HeleKeyListener(hele,gc,this);
gc.getInput().addKeyListener(l);
gc.getInput().addMouseListener(l);
setCrashed(false);


//gc.setVSync(true);

	}

	
	 long elapsedtime;
	 Random r=new Random();
	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
		// TODO Auto-generated method stub
		for(int i=0;i<l.size();i++){
			Pillar p=l.get(i);
			if(h.getCBox().intersects(p.getCBox()))setCrashed(true);
			if(p.getCBox().getX()<=-50)l.remove(p);
			else p.update(delta);
		}
		
		if(elapsedtime>=r.nextInt(1000)+900){l.add(new Pillar(this));
		elapsedtime=0;
		}
		else elapsedtime+=delta;
		
		h.update(delta,gc);
		//p.update(delta);
		if(gc.getInput().isKeyPressed(Input.KEY_R))
			init(gc,game);
		bg.update(delta);
		
		
		

	}

	
	
	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		bg.render(g);
		
		
		for(Pillar p:l){
			p.render(g);
		}
h.render(g);




	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}
	/**
	 * Ease in out equations with the help of the following website: 
	 * {@link http://gizma.com/easing/#quint3}
	 * @param t current time or frame count since start
	 * @param b start value 
	 * @param c change in value/how far to travel like b-100
	 * @param d how long to last
	 * @return the float value to reach desired affect
	 */
	float easeInOutQuint(float t, float b,float   c,float d) {
		t /= d/2;
		if (t < 1) return c/2*t*t*t*t*t + b;
		t -= 2;
		return c/2*(t*t*t*t*t + 2) + b;
	}
	/**
	
	 * {@link #easeInOutQuint(int, int, int, int)}
	 
	 */
	float easeInQuint(float t,float b, float c,float d) {
		t /= d;
		return c*t*t*t*t*t + b;
	}
    /**
	
	 @see #easeInOutQuint(int, int, int, int)
	 
	 */
	float easeOutQuint(int t,int  b, int c,int d) {
		t /= d;
		t--;
		return c*(t*t*t*t*t + 1) + b;
	}
	float myParab(){
		double ret=Math.pow(-(frames/500*0.6-2.6), 2)+6.5;
		
		return (float)ret;
	}



	public boolean isCrashed() {
		return crashed;
	}



	public void setCrashed(boolean crashed) {
		this.crashed = crashed;
		
	}

}
