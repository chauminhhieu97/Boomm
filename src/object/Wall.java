package object;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import game.ID;
import spriteSheet.MyShape;
import spriteSheet.SpriteSheet;

public class Wall extends Tile {
	private MyShape shape;
	private MyShape extraBomb;
	private MyShape extraFire;
	private boolean deleted = false;
	private int bonusType = 1;
	public Wall(int x, int y) {
		super(x, y, TitleState.block, ID.Wall);
		shape=SpriteSheet.getWall(size);
		extraBomb=SpriteSheet.getXBomb(size);
		extraFire=SpriteSheet.getXFire(size);
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g, int dx, int dy) {
		shape.drawShapeAt(g, x+dx, y+dy);
		if (state == TitleState.bonus) 
			if (bonusType==1){
				extraBomb.drawShapeAt(g, x+dx, y+dy);
			}
			else if (bonusType==2) {
				extraFire.drawShapeAt(g, x+dx, y+dy);
			}
	}

	@Override
	public void setFire(int fireSize) {
		// TODO Auto-generated method stub
		if (state == TitleState.bonus) {
			deleted = true;
		}
		// bonus after breaking a wall
		state = TitleState.bonus;
		Random rand = new Random();
		bonusType = rand.nextInt(2)+1;
	}
	
	public boolean isDeleted() {
		return deleted;
	}
	
	public int getBonusType() {
		return bonusType;
	}
}
