package edu.miu.cs525.banking;

import edu.miu.cs525.banking.domain.Account;
import edu.miu.cs525.banking.dto.AccountDTO;
import edu.miu.cs525.banking.service.AccountService;
import edu.miu.cs525.banking.service.BankAccountServiceImpl;
import edu.miu.cs525.framework.domain.PersonalAccount;
import edu.miu.cs525.banking.domain.AccountEntry;
import edu.miu.cs525.banking.domain.Customer;
import edu.miu.cs525.banking.log.Log;

import java.time.LocalDate;

public class Tester {
    public static void main(String[] args) {
        AccountService accountService = BankAccountServiceImpl.getInstance();

        Customer eegii = new PersonalAccount(1, "Eegii", "1000N Fourth Street",
                "Fairfield", "Iowa", 52557, "eegiimiu.edu", LocalDate.of(2024, 4, 5));
        Customer bob = new PersonalAccount(2, "Bob", "404 Avenue",
                "Ottumwa", "Iowa", 06110, "bob@.com", LocalDate.of(2024, 5, 10));
        // create 2 accounts;
        AccountDTO accountDTO1 = AccountDTO.builder()
                .accountNumber("1263862")
                .accountType("SAVINGS")
                .customer(eegii).build();

        AccountDTO accountDTO2 = AccountDTO.builder()
                .accountNumber("4253892")
                .accountType("CHECKING")
                .customer(bob).build();
        accountService.createAccount(accountDTO1);
        accountService.createAccount(accountDTO2);
        // use account 1;
        accountService.deposit("1263862", 240);
        accountService.deposit("1263862", 529);
        accountService.withdraw("1263862", 230);
        // use account 2;
        accountService.deposit("4253892", 12450);
        // show balances

        for (Account account : accountService.getAllAccounts()) {
            Customer customer = account.getCustomer();
            Log.getLogger().write("Statement for Account: " + account.getAccountNumber());
            Log.getLogger().write("Account Holder: " + customer.getName());

            Log.getLogger().write("-Date-------------------------"
                    + "-Description------------------"
                    + "-Amount-------------");

            for (AccountEntry entry : account.getAccountEntries()) {
                System.out.printf("%30s%30s%20.2f\n",
                        entry.getDate().toString(),
                        entry.getDescription(),
                        entry.getAmount());
            }

            Log.getLogger().write("----------------------------------------" + "----------------------------------------");
            System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
        }
    }

}
