package com.neosoft.model;

import java.util.Date;

public class Transaction {

	private Date date;
	private String transactionType;
	private double amount;
	private double balance;
	
	public Transaction() {
		super();
		System.out.println("Default Constructor : ");
	}
	
	public Transaction(Date date, String transactionType, double amount, double balance) {
		super();
		this.date = date;
		this.transactionType = transactionType;
		this.amount = amount;
		this.balance = balance;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "Transaction [date=" + date + ", transactionType=" + transactionType + ", amount=" + amount
				+ ", balance=" + balance + "]";
	}
	
	
}
