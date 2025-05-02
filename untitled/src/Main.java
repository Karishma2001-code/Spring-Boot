import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
   /* public static void oprate(int a, int b, Anonymous obj) {
        System.out.println(obj.oprate(a,b));
    }*/
    public static void main(String[] args) {
        /*oprate(50,60,(a,b)->a*b);*/

        /*Anonymous lm=(a,b)->(a+b);
        System.out.println(lm.show(88,24));
        lm.printdef();
        Anonymous.print();*/

       /* List<String> al= Arrays.asList("karishma","amruta","rachna","komal");
        al.sort((a,b)->a.compareTo(b));
        System.out.println(al);*/

        /*List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> even=nums.stream().filter((a)->a%2==0).toList();
        System.out.println(even);*/

        /*List<String> names = Arrays.asList("john", "doe", "alice");
        List<String> upperCase= names.stream().map(String::toUpperCase).toList();
        System.out.println(upperCase);*/

        /*List<String> words = Arrays.asList("hi", "apple", "to", "code");
        List<String> slength=words.stream().filter((a)->a.length()>3).toList();
        System.out.println(slength);
*/
        /*List<String> names = Arrays.asList("Alice", "Bob", "Ankit", "Brian");
        List<String> aStarting=names.stream().filter((a)->a.startsWith("A")).toList();
        System.out.println(aStarting);*/

    /*    List<Integer> numbers = Arrays.asList(12, 5, 8, 22, 7);
        Optional<Integer> max= numbers.stream().max((a, b)->a-b);
        Optional<Integer> min= numbers.stream().max((a, b)->b-a);
        System.out.println(max);
        System.out.println(min);
*/
        List<String> words = Arrays.asList("Java", "Lambda", "Stream");
        List<Integer> length= words.stream().map(String::length).toList();
        System.out.println(length);

        /*List<String> items = Arrays.asList("dog", "elephana", "any", "bat");
        List<String> sorted=  items.stream().
        sorted((a,b)->a.charAt(a.length()-1)-b.charAt(b.length()-1)).toList();
        System.out.println(sorted);*/

      /*  List<String> words = Arrays.asList("Java", "Go", "Python", "C", "Ruby");
        Map<Integer, List<String>> groupedByLength =
                words.stream()
                        .collect(Collectors.groupingBy(word -> word.length()));
        System.out.println(groupedByLength);
*/
      /*  List<Integer> words = Arrays.asList(2,3,4);
       List<Integer> sList= words.stream().map((a)-> a*a).toList();
        System.out.println(sList);*/

          /*List<String> words = Arrays.asList("Java", "Python", "C");
       List<String> sList= words.stream().sorted((a,b)->a.length()-b.length()).toList();
        System.out.println(sList);
*/

        /*List<String> words = Arrays.asList("Java", "Stream");
        List<Character> s=words.stream()
                .flatMap(a->a.chars().mapToObj(c->(char) c))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(s);*/

       /*  List<String> words = Arrays.asList("Java", "Stream");
        int s=words.stream().mapToInt((a)->a.length()).sum();
        System.out.println(s);*/
        /*List<String> words = Arrays.asList("Code", "Java", "Python", "JS");

        Map<Boolean, List<String>> partitioned = words.stream()
                .collect(Collectors.partitioningBy(word -> word.length() > 4));

        System.out.println(partitioned);*/

        /*List<String> words = Arrays.asList("Java", "Stream");
        String s=words.stream().collect(Collectors.joining(" "));
        System.out.println(s);*/
        int arr[]={20, 50, 5, 10};
        leet.optimalStrategyOfGame(arr,3);

    }
}