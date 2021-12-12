package ru.netology.stats;

public class StatsService {

    // Сумма всех продаж
    public int calculateAllSum(int[] sales) {
        int sum = 0;
        for (int sale : sales) {
            sum += sale;
        }
        return sum;
    }

    // Средняя сумма продаж в месяц
    public int calculateAverageSum(int[] average) {
        int sum = calculateAllSum(average);
        return sum / average.length;
    }

    // Номер месяца, в котором был пик продаж (осуществлены продажи на максимальную сумму)
    public int maxSales(int[] sales) {

        int maxMonth = 0;
        int month = 0;
        for (int sale : sales) {
            if (sale >= sales[maxMonth]) {
                maxMonth = month;
            }
            month = month + 1;
        }
        return maxMonth + 1;
    }


    // Номер месяца, в котором был минимум продаж (осуществлены продажи на минимальную сумму)
    public int minSales(int[] sales) {

        int minMonth = 0;
        int month = 0;
        for (int sale : sales) {
            // sales[minMonth] - продажи в месяце minMonth
            // sale - продажи в рассматриваемом месяце
            if (sale <= sales[minMonth]) {
                minMonth = month;
            }
            month = month + 1; // следующий рассматриваемый месяц имеет номер на 1 больше
        }
        return minMonth + 1;
    }

    //Кол-во месяцев, в которых продажи были ниже среднего
    public int belowTheAverage(int[] sales) {

        int avSales = calculateAverageSum(sales);
        int belowNumbers = 0;

        for (int value : sales) {
            if (avSales > value) {
                belowNumbers++;
            }
        }

        return belowNumbers;
    }

    //    Кол-во месяцев, в которых продажи были выше среднего
    public int aboveTheAverage(int[] sales) {

        int avSales = calculateAverageSum(sales);
        int aboveNumbers = 0;

        for (int value : sales) {
            if (avSales < value) {
                aboveNumbers++;
            }
        }
        return aboveNumbers;
    }
}
