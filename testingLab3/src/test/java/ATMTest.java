import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {
    ATM atm;
    @BeforeEach
    void init(){
        atm = new ATM();
    }


    @Nested
    class testDeposit{
        Deposit d;
        @BeforeEach
        void init(){
            d = new Deposit();
        }
        @Test
        void testPositiveMoney(){
           double result = d.add(3, 5);
           assertEquals(8, result);
        }
        @Test
        void testNegativeMoney(){
            double result = d.add(-3, 5);
            assertEquals(5, result);
        }
        @Test
        void testZeroMoney(){
            double result = d.add(0, 5);
            assertEquals(5, result);
        }


    }

    @Nested
    class testWithdraw{
        Withdraw w;
        @BeforeEach
        void init(){
            w = new Withdraw();
        }
        @Test
        void testPositiveMoney(){
            Double result = w.take(3, 5);
            assertEquals(2, result);
        }
        @Test
        void testNegativeMoney(){
            Double result = w.take(-3, 5);
            assertEquals(5, result);
        }
        @Test
        void testZeroMoney(){
            Double result = w.take(0, 5);
            assertEquals(5, result);
        }
        @Test
        void testMoneyMoreThanBalance(){
            Double result = w.take(5, 3);
            assertNull(result);
        }

    }

    @Test
    void testATMDeposit(){
        double result = atm.deposit(3, 15);
        assertEquals(18, result);
        result = atm.deposit(-3, 15);
        assertEquals(15, result);
        result = atm.deposit(0, 32);
        assertEquals(32, result);
    }

    @Test
    void testATMWithdraw(){
        Double result = atm.withdraw(4, 18);
        assertEquals(14, result);
        result = atm.withdraw(-3, 15);
        assertEquals(15, result);
        result = atm.deposit(0, 32);
        assertEquals(32, result);
        result = atm.withdraw(10, 2);
        assertNull(result);
    }

}