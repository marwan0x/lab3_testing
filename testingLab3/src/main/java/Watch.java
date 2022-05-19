public class Watch {

    public enum GeneralState{
        NORMAL,
        UPDATE,
        ALARM
    }
    public enum InternalState{
        DATE,
        TIME,
        MIN,
        HOUR,
        DAY,
        MONTH,
        YEAR,
        ALARM,
        CHIME
    }

    private GeneralState generalState = GeneralState.NORMAL;
    private InternalState internalState = InternalState.TIME;

    private int min = 0;
    private int hour = 0;
    private int day = 1;
    private int month = 1;
    private int year = 1;


    public void input(String inputString){
        char[] chars = inputString.toCharArray();
        for(char c: chars){
            processChar(c);
        }
    }

    private void processChar(char c){
        switch (generalState) {
            case NORMAL -> {
                if (c == 'a') {
                    if (internalState == InternalState.TIME) {
                        internalState = InternalState.DATE;
                    } else
                        internalState = InternalState.TIME;
                }
                if (c == 'b') {
                    generalState = GeneralState.ALARM;
                    internalState = InternalState.ALARM;
                }
                if (c == 'c') {
                    generalState = GeneralState.UPDATE;
                    internalState = InternalState.MIN;
                }
            }
            case UPDATE -> {
                if (c == 'a') {
                    switch (internalState) {
                        case MIN -> internalState = InternalState.HOUR;
                        case HOUR -> internalState = InternalState.DAY;
                        case DAY -> internalState = InternalState.MONTH;
                        case MONTH -> internalState = InternalState.YEAR;
                        case YEAR -> {
                            generalState = GeneralState.NORMAL;
                            internalState = InternalState.TIME;
                        }
                    }
                }
                if (c == 'b') {
                    switch (internalState) {
                        case MIN -> min = (min + 1) % 60;
                        case HOUR -> hour = (hour + 1) % 24;
                        case DAY -> day = (day % 31) + 1;
                        case MONTH -> month = (month  % 12) + 1;
                        case YEAR -> year = (year  % 100) + 1;
                    }
                }
                if (c == 'd') {
                    generalState = GeneralState.NORMAL;
                    internalState = InternalState.TIME;
                }
            }
            case ALARM -> {
                internalState = InternalState.ALARM;
                if (c == 'a') {
                    internalState = InternalState.CHIME;
                }
                if(c == 'd'){
                    generalState = GeneralState.NORMAL;
                    internalState = InternalState.TIME;
                }
            }
        }
    }


    public GeneralState getGeneralState() {
        return generalState;
    }

    public InternalState getInternalState() {
        return internalState;
    }

    public int getMin() {
        return min;
    }

    public int getHour() {
        return hour;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
