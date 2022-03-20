package net.eugenpaul.mathutils.cyclicgroup;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import net.eugenpaul.mathutils.comp.Algos;

public class Cyclicgroup {
    private Cyclicgroup() {

    }

    public static List<Integer> getGeneratorOfGroup(int modulo) {
        List<Integer> responseGenerators = new LinkedList<>();

        for (int i = 2; i < modulo; i++) {
            if (getOrger(i, modulo) == modulo - 1) {
                responseGenerators.add(i);
            }
        }

        return responseGenerators;
    }

    public static Integer getFirstGeneratorOfGroup(int from, int modulo) {
        Integer responseGenerator = null;

        for (int i = from; i < modulo; i++) {
            if (getOrger(i, modulo) == modulo - 1) {
                responseGenerator = i;
                break;
            }
        }

        return responseGenerator;
    }

    public static Integer getFirstGeneratorOfGroup(int modulo) {
        return getFirstGeneratorOfGroup(2, modulo);
    }

    public static int getOrger(int generator, int modulo) {
        Map<Integer, Integer> elements = new HashMap<>(modulo);

        for (int i = 0; i < modulo; i++) {
            int nextElement = (int) Algos.modularExponentiation(generator, i, modulo);
            if (elements.containsKey(nextElement)) {
                return i - elements.get(nextElement);
            }
            elements.put(nextElement, i);
        }
        return modulo;
    }

    public static List<Integer> getGroup(int generator, int modulo) {
        TreeMap<Integer, Integer> elements = new TreeMap<>();

        int currentElement = generator;
        int begin = 0;

        for (int i = 1; i < modulo; i++) {
            if (elements.containsKey(currentElement)) {
                begin = elements.get(currentElement);
                break;
            }
            elements.put(currentElement, i);
            currentElement = (int) (((long) currentElement * (long) generator) % modulo);
        }

        int from = begin;
        return elements.entrySet().stream()//
                .sorted((a, b) -> a.getValue() - b.getValue())//
                .filter(v -> v.getValue() >= from)//
                .mapToInt(Entry::getKey)//
                .boxed()//
                .collect(Collectors.toCollection(LinkedList::new));
    }
}
