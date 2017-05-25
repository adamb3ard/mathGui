import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * 
 * @author Adam Beard
 * A class that creates a GUI that generates 4 random numbers and does various math operations on them
 *
 */
public class MathEngine implements ActionListener, MouseListener{
	
	JFrame mainFrame = new JFrame();
	JMenuBar menu = new JMenuBar();
	JMenu file, edit, help;
	JMenuItem reset, close, copy, about ;
	JPanel text,numbers, buttons, result;
	JLabel message, num1, num2, num3, num4, answer;
	JButton gen, add, sub, mult, div, max, min, avg;
	String mainText = "<html><center>Welcome! Please click on the \"Generate\" button to get some random numbers, then click on an appropiate button to perform operations.</center></html>";
	Random rand = new Random();
	int r , g, b, int1, int2, int3, int4;
	
	Math math=new Math();
	
	public MathEngine(){
		//MAIN FRAME
		mainFrame.setTitle("Random Math Engine!");
		mainFrame.setLayout(new GridLayout(4,1));
		mainFrame.setSize(500, 500);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setResizable(false);
		
		//FILE 
		file = new JMenu("File");
		
		reset = new JMenuItem("Reset");
		reset.addActionListener(this);
		
		close = new JMenuItem("Close");
		close.addActionListener(this);
		
		file.add(reset);
		file.add(close);
		
		//EDIT
		edit = new JMenu("Edit");
		
		copy = new JMenuItem("Copy");
		copy.addActionListener(this);
		
		edit.add(copy);
		
		//HELP
		help = new JMenu("Help");
		
		about = new JMenuItem("About");
		about.addActionListener(this);
		
		help.add(about);
		
		//ADD MENU TO MENUBAR
		menu.add(file);
		menu.add(edit);
		menu.add(help);
		
		//ADD MENUBAR TO FRAME
		mainFrame.setJMenuBar(menu);
		
		//TOP TEXT PANEL
		text = new JPanel();
		text.setLayout(new GridLayout(1,1));
		
		message = new JLabel(mainText);
		message.setHorizontalAlignment(JLabel.CENTER);
		message.setVerticalAlignment(JLabel.CENTER);
		message.setFont(new Font("Arial",0,15));
		
		text.add(message);
		
		//PANEL WITH NUMBERS
		numbers = new JPanel();
		numbers.setLayout(new GridLayout(1,4));
		
		int1 = 0;
		num1 = new JLabel(int1+"");
		num1.addMouseListener(this);
		num1.setFont(new Font("Arial",0,50));
		num1.setHorizontalAlignment(JLabel.CENTER);
		num1.setForeground(Color.white);
		setColorRandom();
		num1.setBackground(new Color(r,g,b));
		num1.setOpaque(true);
		
		int2 = 0;
		num2 = new JLabel(int2+"");
		num2.addMouseListener(this);
		num2.setFont(new Font("Arial",0,50));
		num2.setHorizontalAlignment(JLabel.CENTER);
		num2.setForeground(Color.white);
		setColorRandom();
		num2.setBackground(new Color(r,g,b));
		num2.setOpaque(true);
		
		int3 = 0;
		num3 = new JLabel(int3+"");
		num3.addMouseListener(this);
		num3.setFont(new Font("Arial",0,50));
		num3.setHorizontalAlignment(JLabel.CENTER);
		num3.setForeground(Color.white);
		setColorRandom();
		num3.setBackground(new Color(r,g,b));
		num3.setOpaque(true);
		
		int4 = 0;
		num4 = new JLabel(int4+"");
		num4.addMouseListener(this);
		num4.setFont(new Font("Arial",0,50));
		num4.setHorizontalAlignment(JLabel.CENTER);
		num4.setForeground(Color.white);
		setColorRandom();
		num4.setBackground(new Color(r, g, b));
		num4.setOpaque(true);
		
		numbers.add(num1);
		numbers.add(num2);
		numbers.add(num3);
		numbers.add(num4);
		
		//PANEL WITH BUTTONS
		buttons = new JPanel();
		buttons.setLayout(new GridLayout(2,4));
		
		gen = new JButton("Generate");
		gen.setFont(new Font("Arial",1,14));
		gen.addActionListener(this);
		
		add = new JButton("Add");
		add.addActionListener(this);
		
		sub = new JButton("Subtract");
		sub.addActionListener(this);
		
		mult = new JButton("Multiply");
		mult.addActionListener(this);
		
		div = new JButton("Divide");
		div.addActionListener(this);
		
		max = new JButton("Find Max");
		max.addActionListener(this);
		
		min = new JButton("Find Min");
		min.addActionListener(this);
		
		avg = new JButton("Average");
		avg.addActionListener(this);
		
		buttons.add(gen);
		buttons.add(add);
		buttons.add(sub);
		buttons.add(mult);
		buttons.add(div);
		buttons.add(max);
		buttons.add(min);
		buttons.add(avg);
		
		//BOTTOM RESULT PANEL
		result = new JPanel();
		result.setLayout(new GridLayout(1,1));
		
		answer = new JLabel("0.0");
		answer.setFont(new Font("Arial",0,30));
		answer.setHorizontalAlignment(JLabel.CENTER);
		answer.setVerticalAlignment(JLabel.CENTER);
		
		result.add(answer);
		
		
		//ADD PANELS
		mainFrame.add(text);
		mainFrame.add(numbers);
		mainFrame.add(buttons);
		mainFrame.add(result);
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}
	
	/**
	 * Sets int r, g, b to a random int between 0-255 to be used
	 * for generating a random color.
	 */
	public void setColorRandom(){
		r = rand.nextInt(256);
		g = rand.nextInt(256);
		b = rand.nextInt(256);
		
		
	}
	
	/**
	 * Listener for menuBar and Buttons
	 */
	@Override
	public void actionPerformed(ActionEvent e){
		
		//MENUBAR ACTIONS
		if(e.getActionCommand().equals("Reset")){
			
			gen.setText("Generate");
			
			setColorRandom();
			num1.setBackground(new Color(r,g,b));
			num1.setText("0");
			
			setColorRandom();
			num2.setBackground(new Color(r,g,b));
			num2.setText("0");
			
			setColorRandom();
			num3.setBackground(new Color(r,g,b));
			num3.setText("0");
			
			setColorRandom();
			num4.setBackground(new Color(r,g,b));
			num4.setText("0");
			
			answer.setText("0.0");
			
		}
		
		else if(e.getActionCommand().equals("Close")){
			
			System.exit(0);
			
		}
		else if(e.getActionCommand().equals("Copy")){
			
			String copyNumb = answer.getText();//num1.getText() + " " + num2.getText() + " " + num3.getText() + " " + num4.getText() + " " ;
			StringSelection select = new StringSelection(copyNumb);
			Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
			clip.setContents(select, null);
			
		}
		else if(e.getActionCommand().equals("About")){
			
			JOptionPane.showMessageDialog(mainFrame, "This is a (just for fun) random number generator and calculator. \nThank you for using it!.");
			
		}
		
		//BUTTON ACTIONS
		else if(e.getActionCommand().equals("Generate") || e.getActionCommand().equals("Re-generate")){
			
			gen.setText("Re-generate");
			
			setColorRandom();
			int1 = rand.nextInt(49);
			num1.setBackground(new Color(r,g,b));
			num1.setText(int1+1+"");
			
			setColorRandom();
			int2 = rand.nextInt(49);
			num2.setBackground(new Color(r,g,b));
			num2.setText(int2+1+"");
			
			setColorRandom();
			int3 = rand.nextInt(49);
			num3.setBackground(new Color(r,g,b));
			num3.setText(int3+1+"");
			
			setColorRandom();
			int4 = rand.nextInt(49);
			num4.setBackground(new Color(r,g,b));
			num4.setText(int4+1+"");
		}
		
		else if(e.getActionCommand().equals("Add")){
			
			answer.setText(math.addition(Integer.parseInt(num1.getText()),Integer.parseInt(num2.getText()),Integer.parseInt(num3.getText()),Integer.parseInt(num4.getText()))+"");
		
		}
		
		else if(e.getActionCommand().equals("Subtract")){
			
			answer.setText(math.subtraction(Integer.parseInt(num1.getText()),Integer.parseInt(num2.getText()),Integer.parseInt(num3.getText()),Integer.parseInt(num4.getText()))+"");
			
		}
		
		else if(e.getActionCommand().equals("Multiply")){
			
			answer.setText(math.multiplication(Integer.parseInt(num1.getText()),Integer.parseInt(num2.getText()),Integer.parseInt(num3.getText()),Integer.parseInt(num4.getText()))+"");
			
		}
		else if(e.getActionCommand().equals("Divide")){
			
			answer.setText(math.division(Integer.parseInt(num1.getText()),Integer.parseInt(num2.getText()),Integer.parseInt(num3.getText()),Integer.parseInt(num4.getText()))+"");
			
		}
		else if(e.getActionCommand().equals("Find Max")){
			
			answer.setText(math.findMax(Integer.parseInt(num1.getText()),Integer.parseInt(num2.getText()),Integer.parseInt(num3.getText()),Integer.parseInt(num4.getText()))+"");
			
		}
		else if(e.getActionCommand().equals("Find Min")){
			
			answer.setText(math.findMin(Integer.parseInt(num1.getText()),Integer.parseInt(num2.getText()),Integer.parseInt(num3.getText()),Integer.parseInt(num4.getText()))+"");
			
		}
		else if(e.getActionCommand().equals("Average")){
			
			answer.setText(math.getAverage(Integer.parseInt(num1.getText()),Integer.parseInt(num2.getText()),Integer.parseInt(num3.getText()),Integer.parseInt(num4.getText()))+"");
			
		}
		
	}
	
	/**
	 * Listener for JLabels with numbers in the numbers panel
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getComponent().equals(num1)){
			
			num1.setText(JOptionPane.showInputDialog("Enter your number:"));
		}
		
		else if(e.getComponent().equals(num2)){
			
			num2.setText(JOptionPane.showInputDialog("Enter your number:"));
		}
		
		else if(e.getComponent().equals(num3)){
			
			num3.setText(JOptionPane.showInputDialog("Enter your number:"));
		}
		
		else if(e.getComponent().equals(num4)){
			
			num4.setText(JOptionPane.showInputDialog("Enter your number:"));
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
	/*
	 * Main method
	 */
	public static void main(String[] args){
		new MathEngine();
	}

}
