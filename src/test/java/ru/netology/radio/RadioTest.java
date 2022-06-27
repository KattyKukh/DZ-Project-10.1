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
            "-1,10",
            "0,10",
            "5,5",
            "100,100",
    })

    public void shouldSetQuantityStation(int quantityStation, int expected) {
        Radio radio = new Radio(quantityStation);
        assertEquals(expected, radio.getQuantityStation());
    }

    @ParameterizedTest
    @CsvSource({
//   Количество станций не установлено и берется по умолчанию
            "-1,0",
            "0,0",
            "5,5",
            "9,9",
            "10,0",
    })

    public void shouldSetStationIFQuantityStationIsNull(int newStation, int expected) {
        Radio radio = new Radio();
        radio.setNewStation(newStation);
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({

//   Количество станций установлено пользователем
            "100,-1,0",
            "100,0,0",
            "100,7,7",
            "100,99,99",
            "100,100,0"
    })

    public void shouldSetStationIFQuantityStationIsNotNull(int quantityStation, int newStation, int expected) {
        Radio radio = new Radio(quantityStation);
        radio.setNewStation(newStation);
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0,1",
            "3,4",
            "9,0"
    })

    public void shouldSetNextStationIFQuantityStationIsNull(int currentStation, int expected) {
        Radio radio = new Radio();
        radio.setNewStation(currentStation);
        radio.nextStation();
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "50,0,1",
            "50,25,26",
            "50,49,0"
    })

    public void shouldSetNextStationIFQuantityStationIsNotNull(int quantityStation, int currentStation, int expected) {
        Radio radio = new Radio(quantityStation);
        radio.setNewStation(currentStation);
        radio.nextStation();
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0,9",
            "3,2",
            "9,8",
    })

    public void shouldSetPrevStationIFQuantityStationIsNull(int currentStation, int expected) {
        Radio radio = new Radio();
        radio.setNewStation(currentStation);
        radio.prevStation();
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "40,0,39",
            "40,15,14",
            "40,39,38",
    })

    public void shouldSetPrevStationIFQuantityStationIsNotNull(int quantityStation, int currentStation, int expected) {
        Radio radio = new Radio(quantityStation);
        radio.setNewStation(currentStation);
        radio.prevStation();
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "-1,0",  //Здесь ожидаемый результат 0, потому что мы ещё не запоминаем в какой момент клиент выберет <0 и возвращаем "по умолчанию".
            "0,0",
            "5,5",
            "100,100",
            "101,0"  //Здесь ожидаемый результат 0, потому что мы ещё не запоминаем в какой момент клиент выберет >100 и возвращаем "по умолчанию".
    })

    public void shouldSetVolume(int newVolume, int expected) {
        Radio radio = new Radio();
        radio.setVolume(newVolume);
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0,1",
            "52,53",
            "99,100",
            "100,100",
    })

    public void shouldIncreaseVolume(int levelVolume, int expected) {
        Radio radio = new Radio();
        radio.setVolume(levelVolume);
        radio.increaseVolume();
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0,0",
            "1,0",
            "63,62",
            "100,99",
    })

    public void shouldReduceVolume(int levelVolume, int expected) {
        Radio radio = new Radio();
        radio.setVolume(levelVolume);
        radio.reduceVolume();
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }
}
