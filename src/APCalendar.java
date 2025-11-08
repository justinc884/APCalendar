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
        int counter_leapyear = 0;
        int i = year1;
        while (i <= year2) {
            if (isLeapYear(i)) {
                counter_leapyear++;
            }
            i++;
        }
        return counter_leapyear;
    }

    private static int firstDayOfYear(int year) {
        int base_year = 2025;
        int day_of_week = 3; //0 = Sunday
        if (base_year > year) {
            while (base_year > year) {
                base_year -= 1;
                if (day_of_week <= 0) {
                    day_of_week = 7;
                }
                if (isLeapYear(base_year)) {
                    if (day_of_week == 1) {
                        day_of_week = 8;
                    }
                    day_of_week -= 2;
                } else day_of_week -= 1;
            }
        }
        if (base_year < year) {
            while (base_year < year) {
                base_year++;
                if (day_of_week >= 6) {
                    day_of_week = -1;
                }
                if (isLeapYear(base_year)) {
                    if (day_of_week == 5) {
                        day_of_week = -2;
                    }
                    day_of_week += 2;
                } else day_of_week++;
            }
        }
        return day_of_week;
    }

    private static int dayOfYear(int month, int day, int year) {
        int days = 0;
        int months = 1;
        while ((month - months) > 0 && (months < 12)) {
            if (months == 2) {
                if (isLeapYear(year)) {
                    days += 29;
                } else {
                    days += 28;
                }
            } else {
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

    public static int dayOfWeek(int month, int day, int year) {
        int days = dayOfYear(month, day, year) % 7;
        return firstDayOfYear(year) + days - 1;
    }
}
