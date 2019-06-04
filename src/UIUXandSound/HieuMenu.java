package UIUXandSound;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import game.Handler;
import game.KeyInput;
import object.Enemy;
import object.Player;
import object.PlayingBoard;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.Color;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.awt.Window.Type;
import java.awt.Point;

public class HieuMenu extends JFrame {

	private JPanel contentPane;
	private HashMap<String, AudioPlayer> sfx;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HieuMenu frame = new HieuMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HieuMenu() {
		sfx = new HashMap<String, AudioPlayer>();
		sfx.put("jump", new AudioPlayer("/SFX/jump.mp3"));
		sfx.put("theme", new AudioPlayer("/Music/theme.mp3"));
		sfx.get("theme").play();
		
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 820/11*9);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnQuit = new JButton("QUIT");
		btnQuit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				sfx.get("jump").play();
				System.exit(0);
				
			}
		});
		btnQuit.setBackground(Color.WHITE);
		btnQuit.setBounds(647, 557, 135, 45);
		contentPane.add(btnQuit);
		
		JButton btnStart = new JButton("START");
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				sfx.get("jump").play();
			}
		});
		btnStart.setBounds(647, 443, 135, 45);
		btnStart.setBackground(Color.WHITE);
		contentPane.add(btnStart);
		
		JButton btnHelp = new JButton("HELP");
		btnHelp.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				sfx.get("jump").play();
			}
		});
		btnHelp.setBackground(Color.WHITE);
		btnHelp.setBounds(647, 500, 135, 45);
		contentPane.add(btnHelp);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-12, -9, 844, 650);
		contentPane.add(lblNewLabel);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(HieuMenu.class.getResource("/Backgrounds/background.jpg")));
	    

		
	}
}
