package thread1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

class Thread1 extends Thread {

	private final JTextField textField;

	public Thread1(final JTextField textField) {
		this.textField = textField;
	}

	@Override
	public void run() {
		textField.setText("start...");
		mySleep(1000);
		textField.setText("elszámolunk 10-ig...");
		mySleep(1000);
		for (int i = 1; i < 11; ++i) {
			textField.setText("" + i);
			mySleep(1000);
		}
		textField.setText("vége...");
	}

	private void mySleep(final int msec) {
		try { Thread.sleep(msec); }
		catch (InterruptedException ex) {}
	}

}

public class View extends JFrame {

	private final AbstractAction buttonClick = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent ae) {
			((JButton) ae.getSource()).setEnabled(false);
			thread1.start();
		}
	};

	private final AbstractAction button2Click = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent ae) {
			final int num = Integer.valueOf(textField2.getText());
			textField2.setText("" + (num + 1));
		}
	};

	private final JButton button = new JButton(buttonClick);
	private final JTextField textField = new JTextField();

	private final Thread1 thread1 = new Thread1(textField);

	private final JButton button2 = new JButton(button2Click);
	private final JTextField textField2 = new JTextField();

	public View() {
		super("Szálak");
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setSize(400, 100);
		super.setLocationRelativeTo(null);

		button.setText("szálak indítása");
		textField.setEditable(false);
		textField.setHorizontalAlignment(JTextField.CENTER);

		button2.setText("ezt lehet közben nyomkodni");
		textField2.setEditable(false);
		textField2.setHorizontalAlignment(JTextField.CENTER);
		textField2.setText("0");

		super.add(button, BorderLayout.PAGE_START);
		super.add(button2, BorderLayout.LINE_START);
		super.add(textField2, BorderLayout.CENTER);
		super.add(textField, BorderLayout.PAGE_END);
	}

}
