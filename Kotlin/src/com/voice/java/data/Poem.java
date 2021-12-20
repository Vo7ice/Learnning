package com.voice.java.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Poem {
    @SerializedName("status")
    private String status;
    @SerializedName("data")
    private DataDTO data;
    @SerializedName("token")
    private String token;
    @SerializedName("ipAddress")
    private String ipAddress;

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public static class DataDTO {
        @SerializedName("id")
        private String id;
        @SerializedName("content")
        private String content;
        @SerializedName("popularity")
        private Integer popularity;
        @SerializedName("origin")
        private OriginDTO origin;
        @SerializedName("matchTags")
        private List<String> matchTags;
        @SerializedName("recommendedReason")
        private String recommendedReason;
        @SerializedName("cacheAt")
        private String cacheAt;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Integer getPopularity() {
            return popularity;
        }

        public void setPopularity(Integer popularity) {
            this.popularity = popularity;
        }

        public OriginDTO getOrigin() {
            return origin;
        }

        public void setOrigin(OriginDTO origin) {
            this.origin = origin;
        }

        public List<String> getMatchTags() {
            return matchTags;
        }

        public void setMatchTags(List<String> matchTags) {
            this.matchTags = matchTags;
        }

        public String getRecommendedReason() {
            return recommendedReason;
        }

        public void setRecommendedReason(String recommendedReason) {
            this.recommendedReason = recommendedReason;
        }

        public String getCacheAt() {
            return cacheAt;
        }

        public void setCacheAt(String cacheAt) {
            this.cacheAt = cacheAt;
        }

        public static class OriginDTO {
            @SerializedName("title")
            private String title;
            @SerializedName("dynasty")
            private String dynasty;
            @SerializedName("author")
            private String author;
            @SerializedName("content")
            private List<String> content;
            @SerializedName("translate")
            private List<String> translate;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDynasty() {
                return dynasty;
            }

            public void setDynasty(String dynasty) {
                this.dynasty = dynasty;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public List<String> getContent() {
                return content;
            }

            public void setContent(List<String> content) {
                this.content = content;
            }

            public List<String> getTranslate() {
                return translate;
            }

            public void setTranslate(List<String> translate) {
                this.translate = translate;
            }
        }
    }
}
