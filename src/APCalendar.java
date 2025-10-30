public class APCalendar {
    private static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        if (year % 4 == 0) {
            return true;
        }
        return false;
    }
    public static int numberOfLeapYears(int year1, int year2) {
        int x = 0;
        int i = year1;
        while (i <= year2) {
            if (isLeapYear(i)) {
                x++;
            }
            i++;
        }
        return x;
    }
    public static int firstDayOfYear(int year) {
        int x = 2025;
        int i = 3;
        if (x >= 0) {
            while (x > year){
                x-=1;
                if (i <= 0) {
                    i = 7;
                }
                if (isLeapYear(x)) {
                    if (i == 1) {
                        i = 8;
                    }
                    i -= 2;
                }
                else i -= 1;
            }
        }
        return i;
    }
    private static int dayOfYear(int month, int day, int year) {
        return 0;
    }
    public static int dayOfWeek (int month, int day, int year) {
        return 0;
    }
}
