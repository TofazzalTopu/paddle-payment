package com.info.tofazzal.util;

import java.util.Map;
import java.util.TreeMap;

public class PaddleUtils {
    public static String getSortedQueryStringWithoutSignature(Map<String, String> params) {
        Map<String, String> sortedMap = new TreeMap<>(params);
        sortedMap.remove("p_signature");

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue());
        }
        return sb.toString();
    }
}
