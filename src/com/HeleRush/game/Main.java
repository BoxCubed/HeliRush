package com.HeleRush.game;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;


public class Main {
	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			
			appgc = new AppGameContainer(new States("Suck Me"));
			//System.out.println(appgc.getAspectRatio());
			appgc.setDisplayMode(1000, 720, false);
			appgc.start();
			//appgc.setAlwaysRender(true);
		}
		catch (SlickException ex)
		{
			Logger.getLogger(States.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
