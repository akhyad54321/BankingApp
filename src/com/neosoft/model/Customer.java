package com.neosoft.model;

import java.util.ArrayList;

public class Customer {

	private int accNo;
	private int age;
	private String name;
	private double balance;
	
	ArrayList<Transaction> transactions = new ArrayList<>(); 
	
	public Customer() {
		super();
		System.out.println("This is Default Constructor : ");
	}
	public Customer(int accNo, int age, String name, double balance) {
		super();
		this.accNo = accNo;
		this.age = age;
		this.name = name;
		this.balance = balance;
	}
	
	public Customer(int accNo, int age, String name, double balance, ArrayList<Transaction> transactions) {
		super();
		this.accNo = accNo;
		this.age = age;
		this.name = name;
		this.balance = balance;
		this.transactions = transactions;
	}
	
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}
	@Override
	public String toString() {
		return "Customer [accNo=" + accNo + ", age=" + age + ", name=" + name + ", balance=" + balance + "]";
	}
	
	
}
