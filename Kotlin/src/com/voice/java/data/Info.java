package com.voice.java.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Info {
    @SerializedName("status")
    private String status;
    @SerializedName("data")
    private DataDTO data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public static class DataDTO {
        @SerializedName("token")
        private String token;
        @SerializedName("ip")
        private String ip;
        @SerializedName("region")
        private String region;
        @SerializedName("weatherData")
        private WeatherDataDTO weatherData;
        @SerializedName("tags")
        private List<String> tags;
        @SerializedName("beijingTime")
        private String beijingTime;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public WeatherDataDTO getWeatherData() {
            return weatherData;
        }

        public void setWeatherData(WeatherDataDTO weatherData) {
            this.weatherData = weatherData;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public String getBeijingTime() {
            return beijingTime;
        }

        public void setBeijingTime(String beijingTime) {
            this.beijingTime = beijingTime;
        }

        public static class WeatherDataDTO {
            @SerializedName("temperature")
            private Integer temperature;
            @SerializedName("windDirection")
            private String windDirection;
            @SerializedName("windPower")
            private Integer windPower;
            @SerializedName("humidity")
            private Integer humidity;
            @SerializedName("updateTime")
            private String updateTime;
            @SerializedName("weather")
            private String weather;
            @SerializedName("visibility")
            private String visibility;
            @SerializedName("rainfall")
            private Integer rainfall;
            @SerializedName("pm25")
            private Integer pm25;

            public Integer getTemperature() {
                return temperature;
            }

            public void setTemperature(Integer temperature) {
                this.temperature = temperature;
            }

            public String getWindDirection() {
                return windDirection;
            }

            public void setWindDirection(String windDirection) {
                this.windDirection = windDirection;
            }

            public Integer getWindPower() {
                return windPower;
            }

            public void setWindPower(Integer windPower) {
                this.windPower = windPower;
            }

            public Integer getHumidity() {
                return humidity;
            }

            public void setHumidity(Integer humidity) {
                this.humidity = humidity;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public String getVisibility() {
                return visibility;
            }

            public void setVisibility(String visibility) {
                this.visibility = visibility;
            }

            public Integer getRainfall() {
                return rainfall;
            }

            public void setRainfall(Integer rainfall) {
                this.rainfall = rainfall;
            }

            public Integer getPm25() {
                return pm25;
            }

            public void setPm25(Integer pm25) {
                this.pm25 = pm25;
            }
        }
    }
}
