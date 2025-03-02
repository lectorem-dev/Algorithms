package ru.ya;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;

        int start = nums[0];  // Начало текущего диапазона

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {  // Если нашли разрыв
                if (start == nums[i - 1]) {
                    res.add(String.valueOf(start));  // Одиночное число
                } else {
                    res.add(start + "->" + nums[i - 1]);  // Диапазон
                }
                start = nums[i];  // Начинаем новый диапазон
            }
        }

        // Добавление последнего диапазона
        if (start == nums[nums.length - 1]) {
            res.add(String.valueOf(start));
        } else {
            res.add(start + "->" + nums[nums.length - 1]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
        System.out.println(summaryRanges(nums));  // Ожидаемый вывод: ["0->2", "4->5", "7"]
    }
}
