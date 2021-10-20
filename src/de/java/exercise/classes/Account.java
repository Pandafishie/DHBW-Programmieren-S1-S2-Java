package de.z_musterloesungen.java.exercise.classes;

/**
 * @author DHBW lecturer
 * @version 1.0
 *
 *          Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 *          Cooperative State University.
 *
 *          (C) 2018 by J. Sidler, T. Schlachter, C. Schmitt, W. Süß
 */
public class Account {
	private int number;
	private String holder;
	private int balance;
	private int limit; // limit is a positive value

	public Account() {
		this(-1, "n/n", 0, 0);
	}

	public Account(int number, String holder, int balance, int limit) {
		super();
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.limit = limit;
	}

	public int getBalance() {
		return balance;
	}

	public void processDeposit(int amount) {
		if (amount > 0)
			this.balance += amount;
	}

	public void processPayment(int amount) {
		if (amount > 0 && balance - amount >= -limit)
			this.balance -= amount;
		else
			System.err.println("Deckung nicht ausreichend!");
	}

	@Override
	public String toString() {
		return "Konto Nr. " + number + " (" + holder + "), " + "Stand: " + balance + " ct, " + "Limit " + limit + " ct";
	}

	public static void main(String[] args) {
		Account account = new Account(4711, "Donald Duck", 500, 1000);
		System.out.println(account);
		account.processDeposit(200);
		System.out.println(account);
		account.processPayment(400);
		System.out.println(account);
		account.processPayment(2000);
		System.out.println(account);
	}
}