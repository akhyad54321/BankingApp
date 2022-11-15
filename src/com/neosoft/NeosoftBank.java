package com.neosoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import com.neosoft.impl.AdminOperation;
import com.neosoft.impl.CustomerOperation;
import com.neosoft.model.Customer;

public class NeosoftBank {
	
	public static  ArrayList<Customer> allCustomers = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		AdminOperation adminOperation = new AdminOperation();
		CustomerOperation customerOperation = new CustomerOperation();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice = 0;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("----------------------------------");
			System.out.println("Welcome to Neosoft Bank : ");
			System.out.println("1. Login as Admin : ");
			System.out.println("2. Login as Customer : ");
			System.out.println("3. Exit : ");
			
			try {
				System.out.println("Enter Choice : ");
				choice =Integer.parseInt(br.readLine());
			}
			catch(NumberFormatException e) {
				e.printStackTrace();
				System.out.println("Enter the Input in INTEGER Format : ");
			}
			
			switch(choice) {
			case 1:
				System.out.println("---------------------------------");
				System.out.println("Welcome to Admin Console : ");
				adminOperation.login();
				break;
			case 2:
				System.out.println("Welcome to Customer Console : ");
				customerOperation.selectCustomerOperation();
				break;
			case 3:
				System.out.println("Exit");
				break;
			default : 
				System.out.println("Invalid Choice Entered : ");
				System.out.println("End of Program : ");
			
			}
			
		}while(choice<4);
	}
}
