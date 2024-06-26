package edu.miu.cs525.banking.domain;


import edu.miu.cs525.framework.InterestComputationStrategy;
import edu.miu.cs525.banking.domain.AccountEntry;
import edu.miu.cs525.banking.domain.Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Account {
	private Customer customer;

	private String accountNumber;

	private String accountType;

	//For Test Purpose: Report Generate
	private static long day = 0l;



	private List<AccountEntry> accountEntries;

	private InterestComputationStrategy interestComputationStrategy;

	public Account(InterestComputationStrategy interestComputationStrategy) {
		this.interestComputationStrategy = interestComputationStrategy;
		this.accountEntries = new ArrayList<>();
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		double balance = 0;
		for (AccountEntry entry : accountEntries) {
			balance += entry.getAmount();
		}
		return balance;
	}

	public void deposit(double amount) {
		AccountEntry entry = new AccountEntry(amount, "deposit", "", "");
		accountEntries.add(entry);
	}

	public void withdraw(double amount) {
		AccountEntry entry = new AccountEntry(-amount, "withdraw", "", "");
		accountEntries.add(entry);
	}

	private void addEntry(AccountEntry entry) {
		accountEntries.add(entry);
	}

	public double addInterest(){
		double interest =  interestComputationStrategy.computeInterest(getBalance());
		AccountEntry entry =  new AccountEntry(interest,"interest added","","");


		accountEntries.add(entry);
		return interest;
	}


	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Collection<AccountEntry> getAccountEntries() {
		return accountEntries;
	}

	public abstract String getAccountType();

	public void setAccountType(String accountType){
		this.accountType = accountType;
	}

}
