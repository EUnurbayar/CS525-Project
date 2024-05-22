package edu.miu.cs525.banking.utils;

import edu.miu.cs525.framework.ui.UIControl;
import edu.miu.cs525.banking.dto.AccountDTO;

public class AccountDTOCreator {
    public static AccountDTO create(UIControl control){
        return AccountDTO.builder()
                .accountNumber(control.getAccountNumber())
                .accountType(control.getAccountType())
                .customer(control.getCustomer()).build();
    }
}
