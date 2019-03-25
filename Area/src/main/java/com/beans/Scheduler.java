package com.beans;

import com.getter.*;
import com.poster.*;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.*;

class Tuple<F, S, T> {
    private final F first;
    private final S second;
    private final T third;

    public Tuple(F f, S s, T t) {
        first = f;
        second = s;
        third = t;
    }

    public F getFirst() { return first; }
    public S getSecond() { return second; }
    public T getThird() { return third; }
}

@Singleton
@Startup
public class Scheduler {

    static private Map<String, Tuple<AGet, APost, String>> map = new TreeMap<String, Tuple<AGet, APost, String>>();
    static private Map<String, String> oldDatas = new TreeMap<String, String>();

    @Schedule(second="*/10", minute = "*", hour = "*", persistent = false)
    public void loop() {
        System.out.println("Loop");
        for (Map.Entry<String, Tuple<AGet, APost, String>> pair : map.entrySet())
        {
            System.out.println("Iterate");
            pair.getValue().getFirst().update();
            String data = pair.getValue().getFirst().getDataString();
            if (!data.equals(oldDatas.get(pair.getKey()))) {
                pair.getValue().getSecond().send(pair.getValue().getThird(), pair.getKey().split(":")[0], data);
                oldDatas.put(pair.getKey(), data);
            }
        }
    }

    public static boolean addSchedule(String name, AGet get, APost post, String opt) {
        if (map.containsKey(name))
            return false;
        map.put(name, new Tuple<AGet, APost, String>(get, post, opt));
        oldDatas.put(name, "");
        return true;
    }

    public static boolean removeSchedule(String name) {
        if (map.containsKey(name)) {
            map.remove(name);
            return true;
        }
        return false;
    }

    public static Map<String, Tuple<AGet, APost, String>> getMap() {
        return map;
    }
}
