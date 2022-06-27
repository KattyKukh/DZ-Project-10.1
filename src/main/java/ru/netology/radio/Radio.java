package ru.netology.radio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Radio {
    private int currentStation;
    private int quantityStation = 10;
    private int currentVolume;
    private int maxVolume = 100;

    public Radio(int quantityStation) {
        if (quantityStation <= 0) {
            quantityStation = this.quantityStation;
        } else {
            this.quantityStation = quantityStation;
        }

    }

    public void setNewStation(int newCurrentStation) {
        if (newCurrentStation >= 0 && newCurrentStation <= this.quantityStation - 1) {
            this.currentStation = newCurrentStation;
        }

    }

    public void nextStation() {
        if (this.currentStation < this.quantityStation - 1) {
            ++this.currentStation;
        } else {
            this.currentStation = 0;
        }

    }

    public void prevStation() {
        if (this.currentStation > 0) {
            --this.currentStation;
        } else {
            this.currentStation = this.quantityStation - 1;
        }

    }

    public void setVolume(int newCurrentVolume) {
        if (newCurrentVolume >= 0 && newCurrentVolume <= this.maxVolume) {
            this.currentVolume = newCurrentVolume;
        }

    }

    public void increaseVolume() {
        if (this.currentVolume < this.maxVolume) {
            ++this.currentVolume;
        } else {
            this.currentVolume = this.maxVolume;
        }

    }

    public void reduceVolume() {
        if (this.currentVolume > 0) {
            --this.currentVolume;
        } else {
            this.currentVolume = 0;
        }

    }

    public int getCurrentStation() {
        return this.currentStation;
    }

    public int getQuantityStation() {
        return this.quantityStation;
    }

    public int getCurrentVolume() {
        return this.currentVolume;
    }

}