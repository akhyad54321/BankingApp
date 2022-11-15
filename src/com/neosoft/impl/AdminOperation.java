package com.neosoft.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.neosoft.NeosoftBank;
import com.neosoft.dao.AdminDao;
import com.neosoft.dao.Common;
import com.neosoft.model.Customer;
import com.neosoft.model.Transaction;
import com.neosoft.model.TransactionType;

public class AdminOperation implements AdminDao, Common {
	
//	ArrayList<Customer> allCustomers = new ArrayList<>();
	NeosoftBank neosoftBank = new NeosoftBank();
	
	int accno, age;
	String name, username, password;
	double amount;
	static Scanner scanner = new Scanner(System.in);
	
	public void login() {
		System.out.println("Enter Username For Login : ");
		username = scanner.nextLine();
		System.out.println("Enter Password For Login : ");
		password = scanner.nextLine();
//		if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
		if(username.equals("admin") && password.equals("admin")) {
			System.out.println("*****Login Successfully Done*****");
			selectAdminOperation();
		}
		else {
			System.out.println("Enter Valid Username & Password : ");
		}
	}

	@Override
	public void openNewAccount() {
		System.out.println("Enter AccountNo : ");
		accno = scanner.nextInt();
		System.out.println("Enter Name : ");
		name = scanner.next();
		System.out.println("Enter the Age : ");
		age = scanner.nextInt();
		if(age>=21) {
			Customer newCustomer = new Customer(accno, age, name, 0);
			neosoftBank.allCustomers.add(newCustomer);
			System.out.println("*****Account Opened Successfully*****");
		}
		else {
			System.out.println("*****Age Criteria Doesnot Match*****");
		}
		
	}

	@Override
	public void deposit() {
		Customer depositCustomer = getCustomerbyAccno();
		System.out.println("Enter Amount to Depositee : ");
		amount = scanner.nextDouble();
		double balance = depositCustomer.getBalance();
		balance = balance + amount;
		depositCustomer.setBalance(balance);
		
		Transaction transaction = new Transaction(new Date(), TransactionType.DEPOSIT.toString(), amount, depositCustomer.getBalance());
		depositCustomer.getTransactions().add(transaction);
//		depositCustomer.setBalance(depositCustomer.getBalance() + amount);

		System.out.println("*****Your Amount has been Credited Successfully*****");
		
	}

	@Override
	public void withdraw() {
		Customer withdrawCustomer = getCustomerbyAccno();
		System.out.println("Enter amount to Withdrawee : ");
		amount = scanner.nextDouble();
		double balance = withdrawCustomer.getBalance();
		balance = balance - amount;
		withdrawCustomer.setBalance(balance);
		
		Transaction transaction = new Transaction(new Date(), TransactionType.WITHDRAW.toString(), amount, withdrawCustomer.getBalance());
		withdrawCustomer.getTransactions().add(transaction);
		
//		withdrawCustomer.setBalance(withdrawCustomer.getBalance() - amount);
		
		System.out.println("*****Your Amount has been Debited Successfully*****");
		
	}

	@Override
	public void deleteAccount() {
		Customer deleteCustomer = getCustomerbyAccno();
		if(deleteCustomer == null) {
			System.out.println("Customer Doesnot Found : ");
		}
		else {
			neosoftBank.allCustomers.remove(deleteCustomer);
			System.out.println("Customer Removed Successfully : ");
		}
		
	}

	@Override
	public void getAllAccounts() {
		for(Customer ele : neosoftBank.allCustomers) {
			System.out.println("Name = " + ele.getName() + "  AccountNo = " + ele.getAccNo() + "  Age = " + ele.getAge() + "  Balance = " + ele.getBalance());;
			System.out.println(" ");
		}
		
	}

	@Override
	public void logout() {
		System.out.println("*****Logout Done Successfully*****");
		try {
			NeosoftBank.main(null);
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Customer getCustomerbyAccno() {
		System.out.println("Enter AccountNo for Individual Customer : ");
		int accountNo =scanner.nextInt();
		Customer customerByAccno = null;
		for(Customer ele : neosoftBank.allCustomers) {
			if(ele.getAccNo()==accountNo) {
				customerByAccno = ele;
				System.out.println(customerByAccno);
				return customerByAccno;
			}
		}
		return customerByAccno;
	}

	
	public void selectAdminOperation() {
		int choice = 0;
		do {
			System.out.println("----------------------------------------");
			System.out.println("Hello Admin  --> Plz Choose Options : ");
			System.out.println("1. Open an account for new Customer\r\n"
					+ "2. Deposit\r\n"
					+ "3. Withdraw\r\n"
					+ "4. Delete an account\r\n"
					+ "5. View all the customers of the bank\r\n"
					+ "6. Log Out");
			
			choice = scanner.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Open New Account :-----> ");
				openNewAccount();
				break;
			case 2:
				System.out.println("Deposit :-----> ");
				deposit();
				break;
			case 3:
				System.out.println("Withdraw :-----> ");
				withdraw();
				break;
			case 4:
				System.out.println("Delete an account :-----> ");
				deleteAccount();
				break;
			case 5:
				System.out.println("View all the customers of the bank :-----> ");
				getAllAccounts();
				break;
			case 6:
				System.out.println("Logout User :-----> ");
				logout();
				break;
			default : 
				System.out.println("Invalid Choice Entered :-----> ");

		}
			
		}while(choice < 7);
		
	}


}
