import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeTest {
    Coffee coffee;
    @BeforeEach
    void init(){
        coffee = new Coffee();
    }


    @Nested
    class CoinsTest{
        Coins coins;

        @BeforeEach
        void init(){
            coins = new Coins();
        }

        @Test
        void testTakeInput(){
            coins.takeInput(3);
            assertEquals(3, coins.totalAmount);
            coins.takeInput(5);
            assertEquals(8, coins.totalAmount);
            coins.takeInput(-1);
            assertEquals(8, coins.totalAmount);
        }

        @Test
        void testCheckNoTotalAmount(){
            assertFalse(coins.check());
        }
        @Test
        void testCheckWithTotalAmount(){
            coins.takeInput(1);
            assertTrue(coins.check());
            coins.takeInput(5);
            assertTrue(coins.check());
        }




    }

    @Nested
    class StockTest{
        Stock stock;

        @BeforeEach
        void init(){
            stock = new Stock();
        }

        @Test
        void testTakeOneCup(){
            stock.amount = 1;
            Integer result = stock.takeOneCup();
            assertEquals(0, result);
            result = stock.takeOneCup();
            assertNull(result);
        }

        @Test
        void testAdd(){
            int result = stock.add(4);
            assertEquals(19, result);
            result = stock.add(-23);
            assertEquals(19, result);
        }
        @Test
        void testCheck(){
            assertTrue(stock.check());
            for(int i =0; i<15; i++){
                stock.takeOneCup();
            }
            assertFalse(stock.check());
        }

    }

    @Test
    void testGetCups(){
        int result = coffee.getCups(4);
        assertEquals(0, result);
        result = coffee.getCups(11);
        assertEquals(0,result);
        result = coffee.getCups(3);
        assertEquals(3, result);
    }

    @Test
    void testRefill(){
        coffee.refill(4);
        assertEquals(19, coffee.stock.amount);
    }

}