package com.voice.java.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OffDay {

    @SerializedName("years")
    private List<YearsDTO> years;

    public List<YearsDTO> getYears() {
        return years;
    }

    public void setYears(List<YearsDTO> years) {
        this.years = years;
    }

    public static class YearsDTO {
        @SerializedName("year")
        private String year;
        @SerializedName("offDay")
        private List<String> offDay;
        @SerializedName("weekDay")
        private List<String> weekDay;
        @SerializedName("exchangeDay")
        private List<String> exchangeDay;
        @SerializedName("specialDay")
        private List<String> specialDay;

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public List<String> getOffDay() {
            return offDay;
        }

        public void setOffDay(List<String> offDay) {
            this.offDay = offDay;
        }

        public List<String> getWeekDay() {
            return weekDay;
        }

        public void setWeekDay(List<String> weekDay) {
            this.weekDay = weekDay;
        }

        public List<String> getExchangeDay() {
            return exchangeDay;
        }

        public void setExchangeDay(List<String> exchangeDay) {
            this.exchangeDay = exchangeDay;
        }

        public List<String> getSpecialDay() {
            return specialDay;
        }

        public void setSpecialDay(List<String> specialDay) {
            this.specialDay = specialDay;
        }
    }
}
