package com.duffiye.core.utils;

public class NumberUtils {

    public static Integer safeAdd(Integer n1, Integer n2) {
        n1 = safe(n1);
        n2 = safe(n2);
        return n1 + n2;
    }

    public static Integer safeSubtract(Integer n1, Integer n2) {
        n1 = safe(n1);
        n2 = safe(n2);
        return n1 - n2;
    }

    public static Integer safe(Integer n1) {
        return null == n1 ? 0 : n1;

    }

    public static Long safeAdd(Long l1, Long l2) {
        l1 = safe(l1);
        l2 = safe(l2);
        return l1 + l2;
    }

    public static Long safe(Long l1) {
        return null == l1 ? 0 : l1;
    }

    public static Long min(Long n1, Long n2) {
        if (n1 == null && n2 == null) {
            return null;
        }
        n1 = null == n1 ? Integer.MAX_VALUE : n1;
        n2 = null == n2 ? Integer.MAX_VALUE : n2;
        return Math.min(n1, n2);
    }

    public static Integer min(Integer n1, Integer n2) {
        n1 = null == n1 ? Integer.MAX_VALUE : n1;
        n2 = null == n2 ? Integer.MAX_VALUE : n2;
        return Math.min(n1, n2);
    }

    public static boolean isEmpty(Number n) {
        return null == n || 0 == n.doubleValue();
    }

    public static boolean isNotEmpty(Number n) {
        return null != n && n.doubleValue() != 0;
    }
}
