package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JLayeredPane;

import menu.Menu;
import object.*;

public class Game extends Canvas implements Runnable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4584388369897487885L;
	private static final int W = 820, H = W/11*9;
	private Menu menu = new Menu();
	private Thread thread;
	private Handler handler;
	private boolean running = true;
	private GameState state = GameState.Menu;
	private static final JLayeredPane background = new JLayeredPane();
	
	public Game() {
		handler = new Handler();
		
		new Window(W, H, "Bomberman", this);
		// initialize board
		PlayingBoard board = new PlayingBoard(30,80,31,13);
		board.addWall(2,2);
		board.setUp();
		// add board and display
		handler.addBoard(board);
		// add player
		handler.addObject(new Player(0,0,board));
		// add enemy
		handler.addObject(new Enemy(6,6,board));
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e ) {
				e.printStackTrace();
		}
	}
	
	public void run() {
		// TODO Auto-generated method stub
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			if (state == GameState.Menu) state = menu.getState();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running) 
				render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				handler.enable();
				//System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() {
		if (state==GameState.Game) handler.tick();
		if (state==GameState.Menu) {
			menu.tick();
		}
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, W, H);
		
		if (state==GameState.Game || state==GameState.Pause) handler.render(g);
		if (state==GameState.Menu) menu.render(g);
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Game();
	}

}
