package ru.netology.radio;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class RadioTest {
    // я не убрала параметры в файлы для того, чтобы было проще проверить тесты (сразу все видно). Но я умею убирать данные для тестов в файлы, если надо.
    @ParameterizedTest
    @CsvSource({
            "0,-1", //Здесь ожидаемый результат 0, потому что мы ещё не запоминаем в какой момент клиент выберет <0 и возвращаем "по умолчанию".
            "0,0",
            "5,5",
            "9,9",
            "0,10" //Здесь ожидаемый результат 0, потому что мы ещё не запоминаем в какой момент клиент выберет >9 и возвращаем "по умолчанию".
    })

    public void shouldSetStation(int expected, int newStation) {
        Radio radio = new Radio();
        radio.setNewStation(newStation);
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "1,0",
            "4,3",
            "0,9"
    })

    public void shouldSetNextStation(int expected, int currentStation) {
        Radio radio = new Radio();
        radio.setNewStation(currentStation);
        radio.nextStation();
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "9,0",
            "2,3",
            "8,9",
    })

    public void shouldSetPrevStation(int expected, int currentStation) {
        Radio radio = new Radio();
        radio.setNewStation(currentStation);
        radio.prevStation();
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0,-1",  //Здесь ожидаемый результат 0, потому что мы ещё не запоминаем в какой момент клиент выберет <0 и возвращаем "по умолчанию".
            "0,0",
            "5,5",
            "10,10",
            "0,11"  //Здесь ожидаемый результат 0, потому что мы ещё не запоминаем в какой момент клиент выберет >10 и возвращаем "по умолчанию".
    })

    public void shouldSetVolume(int expected, int newVolume) {
        Radio radio = new Radio();
        radio.setVolume(newVolume);
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "1,0",
            "4,3",
            "10,10",
    })

    public void shouldIncreaseVolume(int expected, int levelVolume) {
        Radio radio = new Radio();
        radio.setVolume(levelVolume);
        radio.increaseVolume();
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0,0",
            "2,3",
            "9,10"
    })

    public void shouldReduseVolume(int expected, int levelVolume) {
        Radio radio = new Radio();
        radio.setVolume(levelVolume);
        radio.reduceVolume();
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

}
