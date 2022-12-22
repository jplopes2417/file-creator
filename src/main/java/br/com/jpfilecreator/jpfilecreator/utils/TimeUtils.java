package br.com.jpfilecreator.jpfilecreator.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TimeUtils {

    public static LocalDateTime convertStringToLocalDateTime(String stringToFormat){
        return LocalDateTime.parse(stringToFormat, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }


}
