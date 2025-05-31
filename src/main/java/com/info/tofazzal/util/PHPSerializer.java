package com.info.tofazzal.util;

import java.util.Map;

public class PHPSerializer {

    public static String serialize(Map<String, String> data) {
        StringBuilder sb = new StringBuilder();
        sb.append("a:").append(data.size()).append(":{");
        for (Map.Entry<String, String> entry : data.entrySet()) {
            sb.append("s:").append(entry.getKey().length()).append(":\"").append(entry.getKey()).append("\";");
            String value = entry.getValue() != null ? entry.getValue() : "";
            sb.append("s:").append(value.length()).append(":\"").append(value).append("\";");
        }
        sb.append("}");
        return sb.toString();
    }
}

