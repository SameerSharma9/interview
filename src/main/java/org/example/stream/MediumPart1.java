package org.example.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//https://medium.com/@mehar.chand.cloud/java-stream-coding-interview-questions-part-1-dc39e3575727
public class MediumPart1 {
    public static void main(String[] args) {

        //Find the longest string in a list of strings using Java streams
        List<String> strings = Arrays
                .asList("apple", "banana", "cherry", "date", "grapefruit");
        String res1 = strings.stream().max(Comparator.comparing(x->x.length())).get();
        System.out.println(res1);

        // Calculate the average age of a list of Person objects using Java streams:
        List<Person> persons = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 35));
        double res2 = persons.stream().mapToInt(x->x.age).average().orElse(0);
        System.out.println(res2);

        //Check if a list of integers contains a prime number using Java streams
        List<Integer> numbers = Arrays.asList( 4, 6, 8, 10, 12, 14);
        boolean res3 = numbers.stream().anyMatch(MediumPart1::isPrime);
        System.out.println(res3);

        // Merge two sorted lists into a single sorted list using Java streams:
        List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 10);
        List<Integer> res4 = Stream.concat(list1.stream(), list2.stream()).sorted().collect(Collectors.toList());
        System.out.println(res4);

        // Find the intersection of two lists using Java streams:
        List<Integer> list12 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list22 = Arrays.asList(3, 4, 5, 6, 7);
        List<Integer> res5 = list12.stream().filter(x-> list22.contains(x)).collect(Collectors.toList());
        System.out.println(res5);

        // Remove duplicates from a list while preserving the order using Java streams:
        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 6, 5);
        System.out.println(numbersWithDuplicates.stream().distinct().collect(Collectors.toList()));

        //Given a list of transactions, find the sum of transaction amounts for each day using Java streams
        List<Transaction> transactions = Arrays.asList(
                new Transaction("2022-01-01", 100),
                new Transaction("2022-01-01", 200),
                new Transaction("2022-01-02", 300),
                new Transaction("2022-01-02", 400),
                new Transaction("2022-01-03", 500)
        );
        Map<String, Integer> res6 = transactions.stream().collect(Collectors.groupingBy(x->x.date, LinkedHashMap::new, Collectors.summingInt(y->y.amt)));
        System.out.println(res6);

        //  Find the kth smallest element in an array using Java streams
        int[] array = {4, 2, 7, 1, 5, 3, 6};
        int k = 3; // Find the 3rd smallest element
        System.out.println(Arrays.stream(array).sorted().skip(k-1).findFirst().getAsInt());

        //Given a list of strings, find the frequency of each word using Java streams:
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry",
                "banana", "apple");
        System.out.println(words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));

        //Implement a method to partition a list into two groups based on a predicate using Java streams
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

    }

    static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}

class Person {
    String name;
    int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Transaction {
    public String date;
    public int amt;
    public Transaction(String date, int amt) {
        this.date = date;
        this.amt = amt;
    }
}
