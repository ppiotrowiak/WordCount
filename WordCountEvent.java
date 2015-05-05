/**
 *	City&Guilds
 *	
 *	Assignment D
 *	@author Przemyslaw Piotrowiak
 */
 
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
 
public class WordCountEvent implements ActionListener {
	
	WordCount gui;
	
	public WordCountEvent (WordCount in) {
		gui = in;
	}
	
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		if (command.equals("Find Word")) {
			// if any of textfields empty, do nothing, else start searching from index 0
			if ((!gui.textArea.getText().equals("")) && (!gui.textField1.getText().equals(""))) 
			findWord(0);
		}
		if (command.equals("Clear")) {
			clear();
		}
		if (command.equals("Word Count")) {
			if (!gui.textArea.getText().equals("")) {
				wordCount();
			}
		}
	}
	
	public void clear() {
		System.out.println("Clearing");
		gui.textArea.setText("");
		gui.textField1.setText("");
		gui.textField2.setText("");
		gui.count1.setText("");
		gui.count2.setText("");
		gui.count3.setText("");
		gui.count4.setText("");
	}
	
	public void findWord(int index) {
		System.out.println("Find Word");
		String text = gui.textArea.getText();
		// trimming spaces from searched word
		String word = gui.textField1.getText().trim();
		
		// remove any highlighters
		unhighlight();
		// searching for word
		System.out.println("Search for word");
		if ((index = text.indexOf(word, index)) != -1) {
			if ((index + word.length()) >= text.length()) { // if the found occurence is the last string in text we found the word
				highlight(index, index + word.length());
				wordFound(index);
			}
			else { //if it is not at the end of text, it is possible that it is only a part of another word
				if (Character.isLetter(text.charAt(index + word.length()))) {
					System.out.println("Checking character at position " + (index + word.length()));
					findWord(index + 1);
					
				}
				else {
					highlight(index, index + word.length());
					wordFound(index);
				}
			}
			
		}
		else {
			notFound();
		}
	}
	
	public void wordCount() {
		// find total number of words by creating an array of those
		String text = gui.textArea.getText();
		// if text field empty, do not execude the rest of the code
		
		gui.count1.setText(Integer.toString(numOfWords(text))); // number of words works
		gui.count2.setText(Integer.toString(numOfChars(text)));
		// find number of characters excluding a regex (white spaces in our case)
		gui.count3.setText(Integer.toString(numOfChars(text, "\\s")));
		gui.count4.setText(Integer.toString(numOfParagraphs(text)));
		
	}
	
	// return number of words (space is the delimiter)
	public int numOfWords(String text) {
		String[] words = text.split("\\s+");
		return words.length;
	}
	
	// return total number of characters including all white spaces
	public int numOfChars(String text) {
		return text.length();
	}
	
	// return number of characters excluding a string (space in our case)
	public int numOfChars(String text, String excluded) {
		return text.length() - (text.length() - text.replaceAll(excluded, "").length());
	}
	
	public int numOfParagraphs(String text) {
		
		int paragraphs = 1;
		
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == '\n') {
				paragraphs++;
			}
		}
		
		return paragraphs;
	}
	
	public void wordFound(int position) {
		System.out.println("Word found at position " + position);
		gui.textField2.setForeground(Color.BLUE);
		gui.textField2.setText("Word found at: " + position);
	}
	
	public void notFound() {
		System.out.println("Word not found");
		gui.textField2.setForeground(Color.RED);
		gui.textField2.setText("Word not found");
	}
	private void highlight(int start, int end) {
		System.out.println("Highlighting");
		try{
	       	gui.textArea.getHighlighter().addHighlight(start, end, DefaultHighlighter.DefaultPainter);
	    }
	    catch(BadLocationException ble){
		    	ble.printStackTrace();
	    }
	}
	
	private void unhighlight() {
		System.out.println("Unhighlighting");
	
		try {
			gui.textArea.getHighlighter().removeAllHighlights();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
