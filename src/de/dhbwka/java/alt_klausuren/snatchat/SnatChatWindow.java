package de.dhbwka.java.alt_klausuren.snatchat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class SnatChatWindow extends JFrame implements SnatChatFrontend {
	
	private SnatChatRoom room;
	private Account account;
	private ChatMessagesComponent messages = new ChatMessagesComponent();
	private JTextField txtMsg = new JTextField();
	private JButton btnSend = new JButton();
	

	public SnatChatWindow(SnatChatRoom room, Account account) {
		super(account.getName() + " (" + room.getRoomName() + ")");
		this.room = room;
		this.account = account;
		
		this.setLayout(new BorderLayout(5,5));
		JLabel lblUsername = new JLabel(account.getName() + ")");
		lblUsername.setForeground(account.getColor());
		this.add(lblUsername, BorderLayout.NORTH);
		
		this.add(this.messages, BorderLayout.CENTER);
		
		JPanel panSouth = new JPanel(new GridLayout(2, 1, 5, 5));
		this.add(panSouth, BorderLayout.SOUTH);
		
		JPanel panRadio = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ButtonGroup grp = new ButtonGroup();
		for (State state : State.values()) {
			JRadioButton btnRadio = new JRadioButton(state.getLabel());
			grp.add(btnRadio);
			panRadio.add(btnRadio);
			if (account.getState().equals(state)) {
				btnRadio.setSelected(true);
			}
			
			btnRadio.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					room.sendMessage(String.format("State of user '%s' is now '%s'", state.getLabel()));
					account.setState(state);
				}
			});
		}
				
		JPanel panText = new JPanel(new BorderLayout(5, 5));
		panText.add(this.txtMsg, BorderLayout.CENTER);
		panText.add(this.btnSend, BorderLayout.EAST);

		btnSend.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if (txtMsg.getText().isEmpty()) {
					JOptionPane.showMessageDialog(btnSend, "Dear " + account.getName() + ", please enter a message");
				}
				else {
					Message msg = new Message(txtMsg.getText(), account);
					room.sendMessage(msg);
					txtMsg.setText(new String());
				}
					
			}
		});
		
		panSouth.add(panText);
		panSouth.add(panRadio);
		
		this.pack();
		this.setSize(500,600);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

	@Override
	public void receiveMessage(Message msg) {
		JLabel lbl = new JLabel(msg.getSender().getName() + ": "+ msg.getText());
		lbl.setForeground(Color.GRAY);
		
		addLabelWithCountdown(lbl);
	}
	
	private void addLabelWithCountdown(JLabel lbl) {
		String orig = lbl.getText();
		messages.add(lbl);
		
		Runnable r = new Runnable() {
			
			public void run() {
				int value = 10;
				while(value >= 0) {
					lbl.setText(orig + " [ " + value + " ]");
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					value--;
				}
				messages.remove(lbl);
			}
		};
		
		new Thread(r).start();
	}

	@Override
	public void receiveMessage(String text) {
		JLabel lbl = new JLabel(text);
		lbl.setForeground(Color.GRAY);
		
		addLabelWithCountdown(lbl);
	}

	@Override
	public Account getAccount() {
		return this.account;
	}

	@Override
	public SnatChatRoom getRoom() {
		return this.room;
	}

}
