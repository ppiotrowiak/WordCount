import java.awt.EventQueue;

public class TestWordCount {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new WordCount();
			}
		});
	}
}