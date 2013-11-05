package grid;

import javax.swing.JFrame;

public class MainClass {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Grid");
		frame.setSize(800, 530);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new GridPanel());
		frame.revalidate();
		
		
	}

}
