package tasks;

import lombok.*;
import lombok.extern.slf4j.Slf4j;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class StringUtils {

    @Builder.Default
    String delimiter = " ";

    public String reverse(String s) {
        Stream<String> stream = Stream.of(s);
        List<String> list =  stream
                .flatMap(value -> {
                    /*
                    String[] split = value.split(delimiter);
                    Arrays.sort(split,Collections.reverseOrder());//lexicographic order
                return Arrays.asList(split).stream();
                    */
                    List<String> split = Arrays.asList(value.split(delimiter));
                    Collections.reverse(split);
                return split.stream();
                })
                .collect(Collectors.toList());
        return String.join(String.valueOf(delimiter),list);
    }

    /**
     // Написать функцию boolean isPalindrome(String str), проверяющую является ли строка str палиндромом
     // (без учета регистра и небуквенных символов).
     // Например: abcba -> true
     // abdc -> false
     */
    boolean isPalindrome(String s) {
        String str = s.replaceAll("[^\\p{L}]+", "").toLowerCase();
        int index = str.length() / 2;
        char[] array = str.toCharArray();
        for (int i = 0; i < index; i++) {
            if (array[i] != array[array.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    boolean isPalindrome2(String s) {
        String str = s.chars()
                .filter(Character::isLetter)
                .mapToObj(c -> String.valueOf((char) c).toLowerCase())
                .collect(Collectors.joining());
        int index = str.length() / 2;
        char[] array = str.toCharArray();
        for (int i = 0; i < index; i++) {
            if (array[i] != array[array.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        StringUtils build = new StringUtils().toBuilder().build();
        log.info(build.reverse("мама мыла раму и сосала хуй"));
        log.info(String.valueOf(build.isPalindrome("Аргентина манит негра")));
        log.info(String.valueOf(build.isPalindrome2("Аргентина манит негра")));
    }
}
