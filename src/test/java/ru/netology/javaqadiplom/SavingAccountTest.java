package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    //Операции по счету

    //Пополнение счета

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    //Пополнение на 0 руб
    @Test
    public void shouldAddNullAmount() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(0);

        int expected = 2_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    //Пополнение баланса на отрицательное число
    @Test
    public void shouldAddNegativeAmount() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(-2_000);

        int expected = 2_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    //Пополнение на сумму больше максимального баланса
    @Test
    public void shouldAddNewBalanceMoreMax() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(15_000);

        int expected = 2_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }


    //Покупка на сумму в пределах текущего баланса на положительную сумму
    @Test
    public void shouldPayLessThanInitialBalance() {
        SavingAccount account = new SavingAccount(
                5_000,
                0,
                10_000,
                5
        );

        account.pay(3_000);

        int expected = 2_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    //Покупка на положительное число, равное текущему балансу
    @Test
    public void shouldPayEqualInitialBalance() {
        SavingAccount account = new SavingAccount(
                5_000,
                0,
                10_000,
                5
        );

        account.pay(5_000);

        int expected = 0;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    //Покупка на 0 руб
    @Test
    public void shouldPayNullAmount() {
        SavingAccount account = new SavingAccount(
                5_000,
                0,
                10_000,
                5
        );

        account.pay(0);

        int expected = 5_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    // Покупка на отрицательное число
    @Test
    public void shouldPayNegativeAmount() {
        SavingAccount account = new SavingAccount(
                5_000,
                0,
                10_000,
                5
        );

        account.pay(-5_000);

        int expected = 5_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    SavingAccount account = new SavingAccount(
            2_000,
            1_000,
            10_000,
            5
    );

    // Вывод начального баланса
    @Test
    public void shouldGetInitialBalance() {
        int expected = 2_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    //Вывод минимального баланса
    @Test
    public void shouldGetMinBalance() {
        int expected = 1_000;
        int actual = account.getMinBalance();

        Assertions.assertEquals(expected, actual);
    }

    // Вывод максимального баланса
    @Test
    public void shouldGetMaxBalance() {
        int expected = 10_000;
        int actual = account.getMaxBalance();

        Assertions.assertEquals(expected, actual);
    }
    //Минимальный баланс больше максимального

    @Test
    public void shouldMinBalanceMoreMax() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    SavingAccount account = new SavingAccount(
                            2_000,
                            15_000,
                            10_000,
                            5
                    );
                }
        );
    }

    //Начальный баланс меньше минимального
    @Test
    public void shouldInitialBalanceLessMin() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    SavingAccount account = new SavingAccount(
                            500,
                            1_000,
                            10_000,
                            5
                    );
                }
        );
    }

    //Начальный баланс больше максимального
    @Test
    public void shouldInitialBalanceMoreMax() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    SavingAccount account = new SavingAccount(
                            15_000,
                            1_000,
                            10_000,
                            5
                    );
                }
        );
    }

    //Отрицательный процент
    @Test
    public void shouldNegativePercent() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    SavingAccount account = new SavingAccount(
                            2_000,
                            1_000,
                            10_000,
                            -5
                    );
                }
        );
    }

    //Отрицательный начальный баланс
    @Test
    public void shouldNegativeInitialBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    SavingAccount account = new SavingAccount(
                            -2_000,
                            1_000,
                            10_000,
                            5);
                }
        );
    }

    //Отрицательный минимальный баланс
    @Test
    public void shouldNegativeMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    SavingAccount account = new SavingAccount(
                            2_000,
                            -1_000,
                            10_000,
                            5);
                }
        );
    }

    //Отрицательный максимальный баланс
    @Test
    public void shouldNegativeMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    SavingAccount account = new SavingAccount(
                            2_000,
                            1_000,
                            -10_000,
                            5);
                }
        );
    }

    //Расчет % на остаток
    @Test
    public void shouldCalculateOfPercentOnYearChange() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        int expected = 100;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }
}