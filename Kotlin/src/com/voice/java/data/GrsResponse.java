package com.voice.java.data;

import com.google.gson.annotations.SerializedName;

public class GrsResponse {
    @SerializedName("resultCode")
    private Integer resultCode;
    @SerializedName("services")
    private ServicesDTO services;

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public ServicesDTO getServices() {
        return services;
    }

    public void setServices(ServicesDTO services) {
        this.services = services;
    }

    public static class ServicesDTO {
        @SerializedName("com.huawei.elfkidwatch")
        private DTO dto;// FIXME check this code

        public DTO getDto() {
            return dto;
        }

        public void setDto(DTO dto) {
            this.dto = dto;
        }

        public static class DTO {
            @SerializedName("kidWatch")
            private String kidWatch;
            @SerializedName("sltLogBussiness")
            private String sltLogBussiness;
            @SerializedName("sltLogUpload")
            private String sltLogUpload;
            @SerializedName("nickName")
            private String nickName;
            @SerializedName("classForbidden")
            private String classForbidden;
            @SerializedName("healthCommon")
            private String healthCommon;
            @SerializedName("mtsTrs")
            private String mtsTrs;
            @SerializedName("qrCode")
            private String qrCode;
            @SerializedName("sltLocation")
            private String sltLocation;
            @SerializedName("pushMessage")
            private String pushMessage;
            @SerializedName("sportRanking")
            private String sportRanking;
            @SerializedName("sns")
            private String sns;
            @SerializedName("ota")
            private String ota;
            @SerializedName("pushTrsToken")
            private String pushTrsToken;

            public String getKidWatch() {
                return kidWatch;
            }

            public void setKidWatch(String kidWatch) {
                this.kidWatch = kidWatch;
            }

            public String getSltLogBussiness() {
                return sltLogBussiness;
            }

            public void setSltLogBussiness(String sltLogBussiness) {
                this.sltLogBussiness = sltLogBussiness;
            }

            public String getSltLogUpload() {
                return sltLogUpload;
            }

            public void setSltLogUpload(String sltLogUpload) {
                this.sltLogUpload = sltLogUpload;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getClassForbidden() {
                return classForbidden;
            }

            public void setClassForbidden(String classForbidden) {
                this.classForbidden = classForbidden;
            }

            public String getHealthCommon() {
                return healthCommon;
            }

            public void setHealthCommon(String healthCommon) {
                this.healthCommon = healthCommon;
            }

            public String getMtsTrs() {
                return mtsTrs;
            }

            public void setMtsTrs(String mtsTrs) {
                this.mtsTrs = mtsTrs;
            }

            public String getQrCode() {
                return qrCode;
            }

            public void setQrCode(String qrCode) {
                this.qrCode = qrCode;
            }

            public String getSltLocation() {
                return sltLocation;
            }

            public void setSltLocation(String sltLocation) {
                this.sltLocation = sltLocation;
            }

            public String getPushMessage() {
                return pushMessage;
            }

            public void setPushMessage(String pushMessage) {
                this.pushMessage = pushMessage;
            }

            public String getSportRanking() {
                return sportRanking;
            }

            public void setSportRanking(String sportRanking) {
                this.sportRanking = sportRanking;
            }

            public String getSns() {
                return sns;
            }

            public void setSns(String sns) {
                this.sns = sns;
            }

            public String getOta() {
                return ota;
            }

            public void setOta(String ota) {
                this.ota = ota;
            }

            public String getPushTrsToken() {
                return pushTrsToken;
            }

            public void setPushTrsToken(String pushTrsToken) {
                this.pushTrsToken = pushTrsToken;
            }
        }
    }
}
