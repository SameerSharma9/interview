package org.example.company.coursera;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.text.*;
import java.math.*;

// IMPORTANT: All code must be in this file or it will not be submitted

public class VotingSystem {

    private static final String SPACE = " ";
    private static final String EMPTY_STRING = "";

    public static void main(String args[]) throws Exception
    {
        test();
        // Sample Test Case
        final Map<List<String>, Integer> case2 = new HashMap<>();
        case2.put(Arrays.asList("B", "A"), 2);
        case2.put(Arrays.asList("A", "B"), 2);

        final Map<List<String>, Integer> case3 = new HashMap<>();
        case3.put(Arrays.asList("A", "B", "C"), 1);
        case3.put(Arrays.asList("B", "A", "C"), 2);
        case3.put(Arrays.asList("C", "A", "B"), 1);

        final Map<List<String>, Integer> case4 = new HashMap<>();
        case4.put(Arrays.asList("A", "B"), 5);
        case4.put(Arrays.asList("B"), 4);
        case4.put(Arrays.asList("C"), 3);
        case4.put(Arrays.asList("D"), 2);

        final Map<List<String>, Integer> case5 = new HashMap<>();
        case5.put(Arrays.asList("B", "A", "C", "D"), 1);
        case5.put(Arrays.asList("C", "A", "B", "D"), 1);
        case5.put(Arrays.asList("D", "A", "B", "C"), 1);

        System.out.println("The plurality winner 2 is: " + getPluralityWinner(case2));
        System.out.println("The plurality winner 3 is: " + getPluralityWinner(case3));
        System.out.println("The plurality winner 4 is: " + getPluralityWinner(case4));
        System.out.println("The plurality winner 5 is: " + getPluralityWinner(case5));

        System.out.println("The ranked choice winner 2 is: " + getRankedChoiceWinner(case2));
        System.out.println("The ranked choice winner 3 is: " + getRankedChoiceWinner(case3));
        System.out.println("The ranked choice winner 4 is: " + getRankedChoiceWinner(case4));
        System.out.println("The ranked choice winner 5 is: " + getRankedChoiceWinner(case5));
    }

    public static String getPluralityWinner(Map<List<String>, Integer> ballots)
    {
        TreeMap<String, Integer> map = new TreeMap<>();
        sortBallots(getModifiableballot(ballots), map);

        Map.Entry<String, Integer> winnerEntry = map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).findFirst().get();

        return winnerEntry.getKey();
    }

    // implement this method for Part 2
    public static String getRankedChoiceWinner(Map<List<String>, Integer> ballots)
    {
        return getRCWinner(getModifiableballot(ballots));
    }

    private static Map<List<String>, Integer> getModifiableballot(Map<List<String>, Integer> ballots) {
        Map<List<String>, Integer> newBallots = new HashMap<>();
        for (Map.Entry<List<String>, Integer> entry : ballots.entrySet()) {
            List<String> ballotList = entry.getKey().stream().map(s -> s.replace(SPACE, EMPTY_STRING)).collect(Collectors.toCollection(
                    LinkedList::new));
            newBallots.put(ballotList, entry.getValue());
        }
        return newBallots;
    }

    private static void sortBallots(Map<List<String>, Integer> ballots, Map<String, Integer> map) {
        for (Map.Entry<List<String>, Integer> entry : ballots.entrySet()) {

            String tmp = entry.getKey().size() > 0?entry.getKey().get(0):null;
            if(tmp == null) continue;
            if (map.containsKey(tmp)) {
                map.put(tmp, map.get(tmp) + entry.getValue());
            } else {
                map.put(tmp, entry.getValue());
            }
        }
    }

    private static String getRCWinner(Map<List<String>, Integer> ballots) {
        TreeMap<String, Integer> map = new TreeMap<>();
        sortBallots(ballots, map);
        int totalVotes = map.values().stream().mapToInt(Integer::valueOf).sum();
        int majorityVotes = totalVotes / 2 + 1;
        Map.Entry<String, Integer> winner = map.entrySet().stream().filter(x -> x.getValue() >= majorityVotes)
                .findFirst().orElse(null);
        if (winner == null) {
            int lowestVotes = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).findFirst().get().getValue();
            TreeSet<String> lowestScoredSubMap = new TreeSet<>(Comparator.reverseOrder());
            map.forEach((k, val) -> {
                if (val.equals(lowestVotes)) {
                    lowestScoredSubMap.add(k);
                }
            });
            for (Map.Entry<List<String>, Integer> x : ballots.entrySet()) {
                if (x.getKey().size() > 0 && x.getKey().get(0).equals(lowestScoredSubMap.first())) {
                    x.getKey().remove(0);
                }
            }
            //ballots.entrySet().removeIf(entry -> lowestScoredSubMap.first().equals(entry.getKey().get(0)));
            map.remove(lowestScoredSubMap.first());
            Iterator<Map.Entry<List<String>, Integer>> iter = ballots.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<List<String>, Integer> entry = iter.next();
                Iterator<String> listIterator = entry.getKey().iterator();
                while (listIterator.hasNext()) {
                    if (!map.containsKey(listIterator.next())) {
                        listIterator.remove();
                    }
                }
                if (entry.getKey().size() == 0) {
                    iter.remove();
                    ballots.remove(entry.getKey());
                }
            }
            return getRCWinner(ballots);
        } else {
            return winner.getKey();
        }
    }

    private static void test() {
        HashSet<List<String>> set = new HashSet<>();
        List<String> s = new LinkedList<>(Arrays.asList("a","b"));
        List<String> s1 = new LinkedList<>(Arrays.asList("C","D"));
        System.out.println(s.hashCode());
        System.out.println(s1.hashCode());
        set.add(s);
        set.add(s1);
        s.remove(1);
        System.out.println(s.hashCode());
        Iterator<List<String>> i = set.iterator();
        while(i.hasNext()) {
            List<String> ls = i.next();
            ls.remove(0);
            if(ls.size() == 0) {
                i.remove();
            }
        }
        System.out.println(s.hashCode());
        System.out.println(s1.hashCode());
    }
}