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
    private static int firstDayOfYear(int year) {
        int x = 2025;
        int i = 3;
        if (x > year) {
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
        if (x < year) {
            while (x < year) {
                x++;
                if (i >= 6) {
                    i = -1;
                }
                if (isLeapYear(x)) {
                    if (i == 5) {
                        i = -2;
                    }
                    i += 2;
                }
                else i++;
            }
        }
        return i;
    }
    private static int dayOfYear(int month, int day, int year) {
        int days = 0;
        int months = 1;
        while ((month - months) > 0 && (months < 12)) {
            if (months == 2) {
                if (isLeapYear(year)) {
                    days += 29;
                }
                else {
                    days += 28;
                }
            }
            else {
                if (((months % 2 == 1) && (months < 8)) || ((months % 2 == 0) && (months >= 8))) {
                    days += 31;
                }
                if (((months % 2 == 0) && (months < 8)) || ((months % 2 == 1) && (months >= 8))) {
                    days += 30;
                }
            }
            months++;
        }
        days += day;
        return days;
    }
    public static int dayOfWeek (int month, int day, int year) {
        int days = dayOfYear(month, day, year) % 7;
        return firstDayOfYear(year) + days - 1;
    }
}
