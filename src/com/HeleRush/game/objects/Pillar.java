package com.HeleRush.game.objects;

import java.util.Random;

import org.newdawn.slick.Graphics;

import com.HeleRush.game.GameState;
import com.util.Triangle;

public class Pillar {
	GameState game;
	Random ran=new Random();
	boolean upside=ran.nextBoolean();
	float x=1000,h=ran.nextInt(175)+200,y=720-h;
	Triangle t;
	
	public Pillar(GameState game) {
		this.game=game;
		if(upside)
			y=0;
		t=new Triangle(x, y, 50, h,upside);
		
	
		// TODO Auto-generated constructor stub
	}
	
public void update(int delta){
	if(game.isCrashed()==false)
		x-=game.speed*delta;
	getCBox().setX(x);
	
	
	
}
public void render(Graphics g){
	if(getCBox().getX()>=-50)
	//g.fill(getCBox());
	g.fill(t);
	
}
public Triangle getCBox() {
	return t;
}
public void setCBox(Triangle t) {
	this.t = t;
}


















}
