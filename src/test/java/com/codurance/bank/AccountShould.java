package com.codurance.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;

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
}
