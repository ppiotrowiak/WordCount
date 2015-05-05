/**	
 *	My attempt on the official city&guilds assignment
 *
 *	@author Przemyslaw Piotrowiak
 */
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;


public class WordCount extends JFrame {
	
	// pass the reference to WordCountEvent
	WordCountEvent event = new WordCountEvent(this);
	
	// define elements to be displayed in the frame
	JPanel panel1 = new JPanel();
	JLabel textAreaL= new JLabel("Enter text");
	JTextArea textArea = new JTextArea(15,40);
	
	
	JPanel panel2 = new JPanel();
	JLabel textField1L = new JLabel("Enter word");
	JTextField textField1 = new JTextField(20);
	JLabel textField2L = new JLabel("Status");
	JTextField textField2 = new JTextField(20);
	JButton find = new JButton("Find Word");
	JButton clear = new JButton("Clear");
	
	
	JPanel panel3 = new JPanel();
	JLabel countOfWords = new JLabel("Count of words and characters");
	JLabel count1L = new JLabel("Number of words");
	JLabel count2L = new JLabel("Number of characters including spaces");
	JLabel count3L = new JLabel("Number of characters without spaces");
	JLabel count4L = new JLabel("Number of paragraphs");
	
	JTextField count1 = new JTextField(8);
	JTextField count2 = new JTextField(8);
	JTextField count3 = new JTextField(8);
	JTextField count4 = new JTextField(8);
	
	JPanel panel4 = new JPanel();
	JButton count = new JButton("Word Count");
	
	
	public WordCount() {
		// calling constructor of the parent class, Window will have title "Word Count"
		super("Word Count");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750,500);
		// set the layout to have two rows and two columns
		setLayout( new FlowLayout());
		
		// positioning the window in the middle of the screen
		setLocationRelativeTo(null);
		
		// add listeners
		count.addActionListener(event);
		find.addActionListener(event);
		clear.addActionListener(event);
		
		
		// defining panels 01 and 02
		JPanel panel01 = new JPanel();
		panel01.setLayout(new BoxLayout(panel01, BoxLayout.Y_AXIS));
		JPanel panel02 = new JPanel();
		panel02.setLayout(new BoxLayout(panel02, BoxLayout.Y_AXIS));
		
		// add elements of gui to the frame
		// panel1

		Font fontTextAreaL = new Font("Courier", Font.BOLD,18);
		textAreaL.setFont(fontTextAreaL);
		JPanel panel11 = new JPanel();
		JPanel panel12 = new JPanel();
		panel11.add(textAreaL);
		panel12.add(textArea);
		// set text area wrapping on
		textArea.setLineWrap(true);
		panel1.setLayout(new BorderLayout());
		panel1.add(panel11, BorderLayout.NORTH);
		panel1.add(panel12, BorderLayout.CENTER);
		panel01.add(panel1);
		
		panel2.setLayout(new GridLayout(5,1));
		JPanel panel21 = new JPanel();
		JPanel panel22 = new JPanel();
		JPanel panel23 = new JPanel();
		JPanel panel24 = new JPanel();
		JPanel panel25 = new JPanel();
		Font fontBoldSmaller = new Font("Times New Roman", Font.BOLD,14);
		textField1L.setFont(fontBoldSmaller);
		panel21.add(textField1L);
		panel22.add(textField1);
		
		textField2L.setFont(fontBoldSmaller);
		panel23.add(textField2L);
		textField2.setEditable(false);
		panel24.add(textField2);
		panel25.add(find);
		panel25.add(clear);		
		panel21.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel22.setLayout(new FlowLayout(FlowLayout.LEFT));	
		panel23.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel24.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel25.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel2.add(panel21);
		panel2.add(panel22);
		panel2.add(panel23);
		panel2.add(panel24);
		panel2.add(panel25);
		panel02.add(panel2);
		
		panel3.setLayout(new BorderLayout());
		JPanel panel31 = new JPanel();
		panel31.setLayout(new GridLayout(4,1,0,15));
		JPanel panel32 = new JPanel();
		panel32.setLayout(new GridLayout(4,1,0,15));

		JPanel panelC = new JPanel();
		
		JPanel panel3N = new JPanel();
		panel3N.setLayout(new FlowLayout(FlowLayout.CENTER));
		countOfWords.setFont(fontBoldSmaller);
		panel3N.add(countOfWords);
		panel3.add(panel3N, BorderLayout.NORTH);


		panel31.add(count1L);
		count1.setEditable(false);
		panel32.add(count1);
		
		panel31.add(count2L);
		count2.setEditable(false);
		panel32.add(count2);

		panel31.add(count3L);
		count3.setEditable(false);
		panel32.add(count3);

		panel31.add(count4L);
		count4.setEditable(false);
		panel32.add(count4);
		
		JLabel emptyL = new JLabel("");
		panelC.add(emptyL);
		panel3.add(panelC, BorderLayout.CENTER);				

		panel3.add(panel31, BorderLayout.WEST);
		panel3.add(panel32, BorderLayout.EAST);
		
		
		panel01.add(panel3);
		
		panel4.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel4.add(count);
		panel02.add(panel4);
		
		add(panel01);
		add(panel02);
		// setting the frame to be visible
		setVisible(true);
		
	}
	
	
}