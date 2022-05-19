import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WatchTest {
    Watch watch;

    @BeforeEach
    void initWatch(){
        watch = new Watch();
    }
    @AfterEach
    void cleanUp(){
        watch = null;
    }

    @Test
    void EdgeCoverageTest(){
        //"aabadcbababababacd" tested string

        assertEquals(Watch.GeneralState.NORMAL, watch.getGeneralState());
        assertEquals(Watch.InternalState.TIME, watch.getInternalState());
        watch.input("a");
        assertEquals(Watch.GeneralState.NORMAL, watch.getGeneralState());
        assertEquals(Watch.InternalState.DATE, watch.getInternalState());
        watch.input("a");
        assertEquals(Watch.GeneralState.NORMAL, watch.getGeneralState());
        assertEquals(Watch.InternalState.TIME, watch.getInternalState());
        watch.input("b");
        assertEquals(Watch.GeneralState.ALARM, watch.getGeneralState());
        assertEquals(Watch.InternalState.ALARM, watch.getInternalState());
        watch.input("a");
        assertEquals(Watch.GeneralState.ALARM, watch.getGeneralState());
        assertEquals(Watch.InternalState.CHIME, watch.getInternalState());
        watch.input("d");
        assertEquals(Watch.GeneralState.NORMAL, watch.getGeneralState());
        assertEquals(Watch.InternalState.TIME, watch.getInternalState());
        watch.input("c");
        assertEquals(Watch.GeneralState.UPDATE, watch.getGeneralState());
        assertEquals(Watch.InternalState.MIN, watch.getInternalState());
        watch.input("b");
        assertEquals(Watch.GeneralState.UPDATE, watch.getGeneralState());
        assertEquals(Watch.InternalState.MIN, watch.getInternalState());
        watch.input("a");
        assertEquals(Watch.GeneralState.UPDATE, watch.getGeneralState());
        assertEquals(Watch.InternalState.HOUR, watch.getInternalState());
        watch.input("b");
        assertEquals(Watch.GeneralState.UPDATE, watch.getGeneralState());
        assertEquals(Watch.InternalState.HOUR, watch.getInternalState());
        watch.input("a");
        assertEquals(Watch.GeneralState.UPDATE, watch.getGeneralState());
        assertEquals(Watch.InternalState.DAY, watch.getInternalState());
        watch.input("b");
        assertEquals(Watch.GeneralState.UPDATE, watch.getGeneralState());
        assertEquals(Watch.InternalState.DAY, watch.getInternalState());
        watch.input("a");
        assertEquals(Watch.GeneralState.UPDATE, watch.getGeneralState());
        assertEquals(Watch.InternalState.MONTH, watch.getInternalState());
        watch.input("b");
        assertEquals(Watch.GeneralState.UPDATE, watch.getGeneralState());
        assertEquals(Watch.InternalState.MONTH, watch.getInternalState());
        watch.input("a");
        assertEquals(Watch.GeneralState.UPDATE, watch.getGeneralState());
        assertEquals(Watch.InternalState.YEAR, watch.getInternalState());
        watch.input("b");
        assertEquals(Watch.GeneralState.UPDATE, watch.getGeneralState());
        assertEquals(Watch.InternalState.YEAR, watch.getInternalState());
        watch.input("a");
        assertEquals(Watch.GeneralState.NORMAL, watch.getGeneralState());
        assertEquals(Watch.InternalState.TIME, watch.getInternalState());
        watch.input("c");
        assertEquals(Watch.GeneralState.UPDATE, watch.getGeneralState());
        assertEquals(Watch.InternalState.MIN, watch.getInternalState());
        watch.input("d");
        assertEquals(Watch.GeneralState.NORMAL, watch.getGeneralState());
        assertEquals(Watch.InternalState.TIME, watch.getInternalState());
    }

    @Test
    void testMinADUP(){
        assertEquals(0, watch.getMin());
        watch.input("cb") ;
        assertEquals(1, watch.getMin());
        watch.input("b");
        assertEquals(2, watch.getMin());
    }

    @Test
    void testHourADUP(){
        assertEquals(0,watch.getHour());
        watch.input("cab");
        assertEquals(1, watch.getHour());
        watch.input("b");
        assertEquals(2, watch.getHour());
    }

    @Test
    void testDayADUP(){
        assertEquals(1, watch.getDay());
        watch.input("caab");
        assertEquals(2, watch.getDay());
        watch.input("b");
        assertEquals(3, watch.getDay());
    }

    @Test
    void testMonthADUP(){
        assertEquals(1, watch.getMonth());
        watch.input("caaab");
        assertEquals(2, watch.getMonth());
        watch.input("b");
        assertEquals(3, watch.getMonth());
    }

    @Test
    void testYearADUP(){
        assertEquals(1, watch.getYear());
        watch.input("caaaab");
        assertEquals(2, watch.getYear());
        watch.input("b");
        assertEquals(3, watch.getYear());
    }


}