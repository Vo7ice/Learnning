package com.voice.java.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WxMessage {
    @SerializedName("msgtype")
    private String msgtype;
    @SerializedName("markdown")
    private TextDTO markdown;
    @SerializedName("text")
    private TextDTO text;

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public TextDTO getMarkdown() {
        return markdown;
    }

    public void setMarkdown(TextDTO markdown) {
        this.markdown = markdown;
    }

    public TextDTO getTextX() {
        return text;
    }

    public void setTextX(TextDTO text) {
        this.text = text;
    }

    public String toMarkDown() {
        StringBuilder sb = new StringBuilder();
        StringBuilder mentionedList = new StringBuilder();
        List<String> list = markdown.mentionedList;
        sb.append("{")
          .append("\"msgtype\": \"markdown\",\"markdown\": {\"content\":\"")
          .append(markdown.content)
          .append("\"}}");
        return sb.toString();
    }

    public String toText() {
        StringBuilder sb = new StringBuilder();
        sb.append("{")
                .append("\"msgtype:\": \"text\",\"text\": {\"content\":\"")
                .append(text.content)
                .append("\"}}");
        return sb.toString();
    }

    public static class TextDTO {
        @SerializedName("content")
        private String content;
        @SerializedName("mentioned_list")
        private List<String> mentionedList;
        @SerializedName("mentioned_mobile_list")
        private List<String> mentionedMobileList;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public List<String> getMentionedList() {
            return mentionedList;
        }

        public void setMentionedList(List<String> mentionedList) {
            this.mentionedList = mentionedList;
        }

        public List<String> getMentionedMobileList() {
            return mentionedMobileList;
        }

        public void setMentionedMobileList(List<String> mentionedMobileList) {
            this.mentionedMobileList = mentionedMobileList;
        }
    }
}
