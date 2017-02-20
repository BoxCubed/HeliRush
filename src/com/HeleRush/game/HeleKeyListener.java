package com.HeleRush.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.geom.Rectangle;

public class HeleKeyListener implements KeyListener,MouseListener{
	Rectangle hele;
	GameContainer gc;
	GameState game;
	public HeleKeyListener(Rectangle hele,GameContainer gc,GameState game) {
		// TODO Auto-generated constructor stub
		this.hele=hele;
		this.gc=gc;
		this.game=game;
	}

	@Override
	public void inputEnded() {
		// TODO Auto-generated method stub
//System.out.println("ended");
	}

	@Override
	public void inputStarted() {
		// TODO Auto-generated method stub
	//	System.out.println("Started");

	}

	@Override
	public boolean isAcceptingInput() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void setInput(Input arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(int code, char arg1) {
		// TODO Auto-generated method stub
        
        	 
         
	}

	@Override
	public void keyReleased(int arg0, char arg1) {
		// TODO Auto-generated method stub
		if(!game.isCrashed()){
game.h.frames=0;
game.h.elapsedtime=0;
}
	}

	@Override
	public void mouseWheelMoved(int change) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(int button, int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(int button, int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
		// TODO Auto-generated method stub
		game.h.useMouse=true;
		
	}

	@Override
	public void mouseDragged(int oldx, int oldy, int newx, int newy) {
		// TODO Auto-generated method stub
		
	}

}
