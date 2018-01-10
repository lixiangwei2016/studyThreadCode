package lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by lixiangwei2 on 2018/1/10.
 */
public class Lambdatest {

    @Test
    public void test1(){
        new Thread(()-> System.out.println("hello lambda")).start();
    }

    @Test
    public void test2(){
        List<String> lists = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        lists.forEach(n-> System.out.println(n));
    }

    @Test
    public void test3(){
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        String G7Countries = languages.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(G7Countries);
    }

    @Test
    public void test4(){
        List<String> lists = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        lists.stream().map((n)->n+"12").forEach(System.out::println);
    }

    @Test
    public void test5(){
        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};
        Arrays.sort(players,(String s1,String s2)->(s1.compareTo(s2)));

        Arrays.stream(players).forEach(n-> System.out.println(n));
    }


}
