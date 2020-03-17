package com.codurance.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AccountShould {
  @Mock
  TransactionRepository transactionRepository;
  private Account account;

  @BeforeEach
  void setUp() {
    account = new Account(transactionRepository);
  }

  @Test
  public void store_a_deposit_transaction() {
    account.deposit(100);
    verify(transactionRepository).addDeposit(100);
  }

  @Test
  void store_a_withdrawal_transaction() {
    account.withdraw(100);
    verify(transactionRepository).addWithdrawal(100);
  }
}
