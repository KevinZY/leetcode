package com.zhangyang.leetcode.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangyang on 2018/12/28.
 */
public class HierarchyMap {
    public static final String DEFAULT_SPLITER = "\\.";
    private Map<Object, Object> map = new HashMap<>();

    private String spliter = DEFAULT_SPLITER;

    public void put(String key, String value) {
        if (key == null) return;
        String[] split = key.split(spliter);
        arrayPut(split, value);
    }

    private void arrayPut(String[] keys, String value) {
        Map current = map;
        int iterateLength = keys.length - 1;
        for (int i = 0; i < iterateLength; i++) {
            String key = keys[i];
            current = (Map) current.computeIfAbsent(key, (k) -> new HashMap<>());
        }
    }
}
