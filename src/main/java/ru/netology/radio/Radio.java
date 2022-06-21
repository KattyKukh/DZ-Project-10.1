package ru.netology.radio;

public class Radio {

    private int currentStation;
    private int currentVolume;

    public int getCurrentStation() {
        return currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setNewStation(int newCurrentStation) {
//        Обычно набрать отрицательное число обычно с пульта невозможно,
//        но в ДЗ не описано, где клиент будет набирать номер станции, поэтому отсаемся на текущей станции.
        if (newCurrentStation < 0) {
            return;
        }

        if (newCurrentStation > 9) {

            // я думаю, что в случае набора на пульте станции больше, чем 9, логично выдавать самую максимальную из возможных, т.е. 9.
            // Но в ДЗ этот исход не оговорен, поэтому отстаемся на текущей станции.
            return;
        }

        currentStation = newCurrentStation;
    }

    public void nextStation() {
        if (currentStation < 9) {
            currentStation = currentStation + 1;
        } else {
            currentStation = 0;
        }
    }

    public void prevStation() {
        if (currentStation > 0) {
            currentStation = currentStation - 1;
        } else {
            currentStation = 9;
        }
    }


    public void setVolume(int newCurrentVolume) {

        if (newCurrentVolume < 0) {
            return;
        }
        if (newCurrentVolume > 10) {
            return;
        }

        currentVolume = newCurrentVolume;
    }

    public void increaseVolume() {
        if (currentVolume < 10) {
            currentVolume = currentVolume + 1;
        } else {
            currentVolume = 10;
        }
    }

    public void reduceVolume() {
        if (currentVolume > 0) {
            currentVolume = currentVolume - 1;
        } else {
            currentVolume = 0;
        }
    }
}
