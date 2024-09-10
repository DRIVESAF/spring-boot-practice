package io.drivesaf.springboot.quickstart.service;

import io.drivesaf.springboot.quickstart.entity.Account;
import io.drivesaf.springboot.quickstart.entity.CreditAccount;
import io.drivesaf.springboot.quickstart.entity.SavingsAccount;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccountService {
    public List<Account> getAccounts() {
        return List.of(
            new SavingsAccount("SA123", 1500.00),
            new CreditAccount("CA456", 3000.00)
        );
    }
}
