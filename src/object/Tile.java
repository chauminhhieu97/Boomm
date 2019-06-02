package object;

import java.awt.Graphics;

import game.*;

public abstract class Tile extends GameObject{
	protected static int size;
	protected TitleState state;
	
	
	public Tile(int x, int y, TitleState state, ID id) {
		super(x, y, id);
		this.state = state;
		// TODO Auto-generated constructor stub
	}

	public static void setSize(int input_size) {
		size = input_size;
	}

	public static int getSize() {
		return size;
	}
	public TitleState getState() {
		return state;
	}

	public void setState(TitleState state) {
		this.state = state;
	}
	public int getFireVer() {
		return 0;
	}
	public int getFireHor() {
		return 0;
	}
	public abstract void setFire(int fireSize);
}
