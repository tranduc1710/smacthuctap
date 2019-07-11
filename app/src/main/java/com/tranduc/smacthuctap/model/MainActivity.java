package com.tranduc.smacthuctap.model;

public class MainActivity {
    public interface menuScreen{
        String DayOne = "DayOne";
        String DayTwo = "DayTwo";
        String DayThree = "DayThree";
        String DayFour = "DayFour";
        String DayFive = "DayFive";
        String DaySix = "DaySix";
        String DaySeven = "DaySeven";
        String DayEight = "DayEight";
        String DayNine = "DayNine";
        String Canvas = "CanvasActivity";
        String DataBinding = "DataBinding";
    }
    private String screen, name;

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MainActivity(String screen, String name) {
        this.screen = screen;
        this.name = name;
    }
}
