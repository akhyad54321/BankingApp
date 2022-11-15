package com.neosoft.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import com.neosoft.NeosoftBank;
import com.neosoft.dao.Common;
import com.neosoft.dao.CustomerDao;
import com.neosoft.model.Customer;
import com.neosoft.model.Transaction;
import com.neosoft.model.TransactionType;

public class CustomerOperation implements CustomerDao, Common{

	static Scanner scanner = new Scanner(System.in);
	NeosoftBank neosoftBank = new NeosoftBank();
	AdminOperation adminOperation = new AdminOperation();
	Customer currentAccount = null;
	
	@Override
	public void viewAccountDetails() {
		Customer currentAccount = getCustomerbyAccno();
		for(Customer ele : neosoftBank.allCustomers) {
			System.out.println("AccountNo = " + currentAccount.getAccNo() + "  Name = "  + currentAccount.getName()  + "  Balance" + currentAccount.getBalance());
			System.out.println(" ");
		}
		
	}

	@Override
	public void viewAllTransaction() {
		try {
			System.out.println(currentAccount.getTransactions());
		}
		catch(NullPointerException e) {
			System.out.println("No Transaction Data Found : ");
		}
		
	}

	@Override
	public void transferMoney() {

		currentAccount=getCustomerbyAccno();
		Customer beneficiaryAccount = getCustomerbyAccno();
		System.out.println("Enter the amount to be Transfed : ");
		int amount = scanner.nextInt();
		
		beneficiaryAccount.setBalance(beneficiaryAccount.getBalance() + amount);
		currentAccount.setBalance(currentAccount.getBalance() - amount);
		
		Transaction currenTransaction = new Transaction(new Date(), TransactionType.WITHDRAW.toString(), amount, currentAccount.getBalance());
		Transaction benefeciaryTransaction = new Transaction(new Date(), TransactionType.DEPOSIT.toString(), amount, beneficiaryAccount.getBalance());
		
		currentAccount.getTransactions().add(currenTransaction);
		beneficiaryAccount.getTransactions().add(benefeciaryTransaction);
		
		System.out.println("*****Money Transfer Done Successfully*****");
		
	}

	@Override
	public void lastFiveTransaction() {
		
		List<Transaction> trList=new ArrayList<>();
		for(Transaction tr:currentAccount.getTransactions()) {
			trList.add(tr);
		}
		if(trList.size()>5) {
			Collections.reverse(trList);
			System.out.println(trList.subList(trList.size()-5, trList.size()));
		}else {
			Collections.reverse(trList);
			System.out.println(trList);
		}
		
		
	}

	@Override
	public void logout() {
		System.out.println("*****LOGOUT*****");
		try {
			neosoftBank.main(null);
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
	
	public void selectCustomerOperation() {
		int choice = 0;
		do {
			System.out.println("---------------------------------------");
			System.out.println("1. View account details  \r\n"
					+ "2.View All Transaction\r\n"
					+ "3. Transfer Money \r\n"
					+ "4. View last 5 transactions\r\n"
					+ "5. Log Out");
			
			System.out.println("Enter Choice : ");
			choice = scanner.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("View account details ----->");
				viewAccountDetails();
				break;
			case 2:
				System.out.println("View All Transaction ----->");
				viewAllTransaction();
				break;
			case 3:
				System.out.println("Transfer Money ----->");
				transferMoney();
				break;
			case 4:
				System.out.println("View last 5 transactions ----->");
				lastFiveTransaction();
				break;
			case 5:
				System.out.println("Log Out ----->");
				logout();
				break;
				
			}
		}while(choice < 6);
		
	}

}
