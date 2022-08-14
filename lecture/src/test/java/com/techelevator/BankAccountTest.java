package com.techelevator;

import org.junit.Test;

import static org.junit.Assert.*;

public class BankAccountTest {

    @Test
    public void getAccountHolderName() {
    }

    @Test
    public void getAccountNumber() {
    }

    @Test
    public void getBalance() {
    }

    @Test
    public void deposit() {
    }

    @Test
    public void withdraw() {
        //arrange
        BankAccount bankAccount = new BankAccount("Test", "666666", 100);

        //act

        int newBalance = bankAccount.withdraw(15);

        //Assert

        assertEquals(85, newBalance);



    }

    @Test
    public void transferTo() {
        // Arrange
        BankAccount source = new BankAccount("Test1", "666666", 100);
        BankAccount destination = new BankAccount("Test2", "666656", 100);

        //Act

        int newBalance = source.transferTo(destination, 10);

        // Assert
        assertEquals(90, newBalance);
        assertEquals(110, destination.getBalance());


    }
    @Test
    public void transferTo_over500() {
        // Arrange
        BankAccount source = new BankAccount("Test1", "666666", 600);
        BankAccount destination = new BankAccount("Test2", "666656", 100);

        //Act

        int newBalance = source.transferTo(destination, 510);


        // Assert
        assertEquals(600, newBalance);
        assertEquals(100, destination.getBalance());


    }
}