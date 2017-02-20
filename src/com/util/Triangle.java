package com.util;

import org.newdawn.slick.geom.Polygon;

public class Triangle extends Polygon {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5767195853274891019L;
	
	
	public Triangle(float x, float y,float width, float height,boolean upside) {
		super();
		if(!upside){
	addPoint(0, height);
	addPoint(width, height);
	addPoint((width)/2, 0);
	}else{
		addPoint(0, 0);
		addPoint(width, 0);
		addPoint(width/2, height);
		
	}
	setX(x);
	setY(y);
		// TODO Auto-generated constructor stub
	}
	
	

}
