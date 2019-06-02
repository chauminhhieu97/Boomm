package object;

import java.awt.Color;
import java.awt.Graphics;

import game.ID;
import spriteSheet.MyShape;
import spriteSheet.SpriteSheet;

public class Pole extends Tile{
	private MyShape shape;
	public Pole(int x, int y) {
		super(x, y, TitleState.block, ID.Pole);
		shape=SpriteSheet.getPole(size);
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g, int dx, int dy) {
		shape.drawShapeAt(g, x+dx, y+dy);
	}

	@Override
	public void setFire(int fireSize) {
		// TODO Auto-generated method stub
		
	}
}
