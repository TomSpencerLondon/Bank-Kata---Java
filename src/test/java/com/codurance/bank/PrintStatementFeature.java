package com.codurance.bank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PrintStatementFeature {
  @Mock
  Console console;

  private Account account;

  @BeforeEach
  void setUp() {
    account = new Account();
  }

  @Test
  public void print_statement_containing_all_transactions(){
    account.deposit(1000);
    account.withdraw(100);
    account.deposit(500);

    account.printStatement();

    InOrder inOrder = inOrder(console);

    inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE");
    inOrder.verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
    inOrder.verify(console).printLine("02/04/2014 | -100.00 | 900.00");
    inOrder.verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");
  }
}
