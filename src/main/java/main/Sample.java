package main;

import java.util.Arrays;

import testMap.LongMap;

public class Sample {

    public static void main(String[] args) {

        LongMap<String> lm = new LongMap<String>(9);
        System.out.println("Empty LongMap, isEmpty: " + lm.isEmpty());

        lm.put(34213, "sdgsd");
        System.out.println("put(34213, 'sdgsd');");
        System.out.println("LongMap size(); : " + lm.size());
        System.out.println("LongMap after put, isEmpty: " + lm.isEmpty());
        System.out.println("LongMap containsKey 34213: " + lm.containsKey(34213));
        System.out.println("LongMap containsKey 313: " + lm.containsKey(313));
        System.out.println("LongMap containsValue sdgsd: " + lm.containsValue("sdgsd"));
        lm.remove(34213);
        System.out.println("LongMap remove(34213);");
        System.out.println("LongMap size(); : " + lm.size());
        System.out.println("LongMap containsKey 34213 after removing: " + lm.containsKey(34213));
        System.out.println("LongMap containsValue sdgsd after removing: " + lm.containsValue("sdgsd"));

        lm.put(542, "sdsd");
        lm.put(232, "yikl");

        System.out.println("LongMap keys(); : " + Arrays.toString(lm.keys()));
        System.out.println("LongMap Values(); : " + lm.values());

        System.out.println("LongMap get(); null(non.exist.) value: " + lm.get(0));
        System.out.println("LongMap get(); existing value: " + lm.get(232));

        lm.clear();
        System.out.println("LongMap clear();");
        System.out.println("LongMap size(); : " + lm.size());

    }
}
