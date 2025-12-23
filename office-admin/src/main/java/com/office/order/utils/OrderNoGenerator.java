package com.office.order.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderNoGenerator {

    // 使用AtomicInteger确保线程安全
    private static final AtomicInteger SEQUENCE = new AtomicInteger(0);

    /**
     * 生成订单编号：前缀 + 年月日 + 3位随机数
     * 格式如：PO202401150123
     */
    public static String generateOrderNo(String prefix) {
        // 获取当前日期
        String dateStr = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        // 生成3位随机数
        int randomNum = ThreadLocalRandom.current().nextInt(100, 1000);

        return String.format("%s%s%03d", prefix, dateStr, randomNum);
    }

    /**
     * 生成订单编号（固定前缀PO）
     */
    public static String generateOrderNo() {
        return generateOrderNo("PO");
    }

    /**
     * 带序列号的版本（保证唯一性更好）
     */
    public static String generateOrderNoWithSequence(String prefix) {
        String dateStr = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        int sequence = SEQUENCE.incrementAndGet() % 1000; // 限制在0-999

        return String.format("%s%s%03d", prefix, dateStr, sequence);
    }

//    public static void main(String[] args) {
//        System.out.println(generateOrderNo());
//    }
}
