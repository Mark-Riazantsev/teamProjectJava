package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {
    @Test
    public void testConstructor_WithNegativeRate() {
        int initialBalance = 1_000;
        int creditLimit = 5_000;
        int rate = -5;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(initialBalance, creditLimit, rate);
        });
    }

    @Test
    public void testConstructor_WithNegativeInitialBalance() {
        int initialBalance = -1_000;
        int creditLimit = 5_000;
        int rate = 5;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(initialBalance, creditLimit, rate);
        });
    }

    @Test
    public void testConstructor_WithNegativeCreditLimit() {
        int initialBalance = 1_000;
        int creditLimit = -5_000;
        int rate = 5;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(initialBalance, creditLimit, rate);
        });
    }

    @Test
    public void testConstructor_WithZeroRate() {
        int initialBalance = 1_000;
        int creditLimit = 5_000;
        int rate = 0;

        Assertions.assertDoesNotThrow(() -> {
            new CreditAccount(initialBalance, creditLimit, rate);
        });
    }

    @Test
    public void testConstructor_WithZeroInitialBalance() {
        int initialBalance = 0;
        int creditLimit = 5_000;
        int rate = 5;

        Assertions.assertDoesNotThrow(() -> {
            new CreditAccount(initialBalance, creditLimit, rate);
        });
    }

    @Test
    public void testConstructor_WithZeroCreditLimit() {
        int initialBalance = 1_000;
        int creditLimit = 0;
        int rate = 5;

        Assertions.assertDoesNotThrow(() -> {
            new CreditAccount(initialBalance, creditLimit, rate);
        });
    }

    @Test
    public void testConstructor_WithPositiveRate() {
        int initialBalance = 1000;
        int creditLimit = 5_000;
        int rate = 150;

        Assertions.assertDoesNotThrow(() -> {
            new CreditAccount(initialBalance, creditLimit, rate);
        });
    }

    @Test
    public void testConstructor_WithPositiveInitialBalance() {
        int initialBalance = 0;
        int creditLimit = 5_000;
        int rate = 5;

        Assertions.assertDoesNotThrow(() -> {
            new CreditAccount(initialBalance, creditLimit, rate);
        });
    }

    @Test
    public void testConstructor_WithPositiveCreditLimit() {
        int initialBalance = 1_000;
        int creditLimit = 0;
        int rate = 5;

        Assertions.assertDoesNotThrow(() -> {
            new CreditAccount(initialBalance, creditLimit, rate);
        });
    }

    @Test
    public void shouldPayWithPositiveBalance() {
        CreditAccount creditAccount = new CreditAccount(
                5_000,
                5_000,
                15
        );

        Assertions.assertTrue(creditAccount.pay(3_000));
        Assertions.assertEquals(2_000, creditAccount.getBalance());
    }
    @Test
    public void shouldPayWithZeroInitialBalance() {
        CreditAccount creditAccount = new CreditAccount(
                0,
                5_000,
                15
        );

        boolean result = creditAccount.pay(5_000);

        Assertions.assertTrue(result);
        Assertions.assertEquals(-5_000, creditAccount.getBalance());
    }

    @Test
    public void shouldPayWithZeroFinalBalance() {
        CreditAccount creditAccount = new CreditAccount(
                5_000,
                5_000,
                15
        );

        boolean result = creditAccount.pay(5_000);

        Assertions.assertTrue(result);
        Assertions.assertEquals(0, creditAccount.getBalance());
    }

    @Test
    public void shouldPayWithNegativeBalance() {
        CreditAccount creditAccount = new CreditAccount(
                5_000,
                6_000,
                15
        );

        boolean result = creditAccount.pay(6_000);

        Assertions.assertEquals(true, result);
        Assertions.assertEquals(-1_000, creditAccount.getBalance());
    }
    @Test
    public void shouldNegativePay() {
        CreditAccount creditAccount = new CreditAccount(
                5_000,
                5_000,
                15
        );

        boolean result = creditAccount.pay(-1_000);

        Assertions.assertEquals(false, result);
        Assertions.assertEquals(5_000, creditAccount.getBalance());
    }

    @Test
    public void shouldPayWithExcessCreditLimit() {
        CreditAccount creditAccount = new CreditAccount(
                5_000,
                5_000,
                15
        );

        boolean result = creditAccount.pay(12_000);

        Assertions.assertEquals(false, result);
        Assertions.assertEquals(5000, creditAccount.getBalance());
    }
    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount creditAccount = new CreditAccount(
                5_000,
                5_000,
                15
        );

        boolean result = creditAccount.add(3_000);

        Assertions.assertTrue(result);
        Assertions.assertEquals(8_000, creditAccount.getBalance());
    }
    @Test
    public void shouldNegativeAdd() {
        CreditAccount creditAccount = new CreditAccount(
                0,
                5_000,
                15
        );

        boolean result = creditAccount.add(-3_000);

        Assertions.assertEquals(false, result);
        Assertions.assertEquals(0, creditAccount.getBalance());
    }
    @Test
    public void shouldAddToZeroBalance() {
        CreditAccount creditAccount = new CreditAccount(
                0,
                5000,
                15
        );

        boolean result = creditAccount.add(3_000);

        Assertions.assertTrue(result);
        Assertions.assertEquals(3_000, creditAccount.getBalance());
    }

    @Test
    public void shouldCalculatedInterestWithPositiveBalance() {
        CreditAccount creditAccount = new CreditAccount(
                1_000,
                5_000,
                15
        );

        int result = creditAccount.yearChange();

        Assertions.assertEquals(0, result);
    }
    @Test
    public void shouldCalculatedInterestWithNegativeBalance() {
        CreditAccount creditAccount = new CreditAccount(
                1000,
                5_000,
                15
        );

        creditAccount.pay(2_000);


        Assertions.assertEquals(150, creditAccount.yearChange());
    }
    @Test
    public void shouldCalculatedInterestWithZeroBalance() {
        CreditAccount creditAccount = new CreditAccount(
                0,
                5_000,
                15
        );

        int result = creditAccount.yearChange();

        Assertions.assertEquals(0, result);
    }
}