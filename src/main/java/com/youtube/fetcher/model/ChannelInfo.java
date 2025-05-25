package com.youtube.fetcher.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * YouTube频道信息模型
 * 封装频道的基本信息和统计数据
 * 
 * @author YouTube Fetcher Team
 * @version 1.0.0
 */
public class ChannelInfo {
    
    @JsonProperty("channel_id")
    private String channelId;
    
    @JsonProperty("channel_name")
    private String channelName;
    
    @JsonProperty("description")
    private String description;
    
    @JsonProperty("created_at")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime createdAt;
    
    @JsonProperty("subscriber_count")
    private Long subscriberCount;
    
    @JsonProperty("video_count")
    private Long videoCount;
    
    @JsonProperty("view_count")
    private Long viewCount;
    
    @JsonProperty("uploads_playlist_id")
    private String uploadsPlaylistId;
    
    @JsonProperty("custom_url")
    private String customUrl;
    
    @JsonProperty("country")
    private String country;
    
    @JsonProperty("default_language")
    private String defaultLanguage;
    
    @JsonProperty("thumbnail_url")
    private String thumbnailUrl;
    
    @JsonProperty("banner_url")
    private String bannerUrl;
    
    /**
     * 默认构造函数
     */
    public ChannelInfo() {
    }
    
    /**
     * 基本构造函数
     * @param channelId 频道ID
     * @param channelName 频道名称
     */
    public ChannelInfo(String channelId, String channelName) {
        this.channelId = channelId;
        this.channelName = channelName;
    }
    
    // Getters and Setters
    public String getChannelId() {
        return channelId;
    }
    
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
    
    public String getChannelName() {
        return channelName;
    }
    
    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public Long getSubscriberCount() {
        return subscriberCount;
    }
    
    public void setSubscriberCount(Long subscriberCount) {
        this.subscriberCount = subscriberCount;
    }
    
    public Long getVideoCount() {
        return videoCount;
    }
    
    public void setVideoCount(Long videoCount) {
        this.videoCount = videoCount;
    }
    
    public Long getViewCount() {
        return viewCount;
    }
    
    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }
    
    public String getUploadsPlaylistId() {
        return uploadsPlaylistId;
    }
    
    public void setUploadsPlaylistId(String uploadsPlaylistId) {
        this.uploadsPlaylistId = uploadsPlaylistId;
    }
    
    public String getCustomUrl() {
        return customUrl;
    }
    
    public void setCustomUrl(String customUrl) {
        this.customUrl = customUrl;
    }
    
    public String getCountry() {
        return country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getDefaultLanguage() {
        return defaultLanguage;
    }
    
    public void setDefaultLanguage(String defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }
    
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
    
    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
    
    public String getBannerUrl() {
        return bannerUrl;
    }
    
    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }
    
    /**
     * 获取频道URL
     * @return YouTube频道链接
     */
    public String getChannelUrl() {
        return "https://www.youtube.com/channel/" + channelId;
    }
    
    /**
     * 检查是否为有效的频道信息
     * @return 如果频道ID不为空则返回true
     */
    public boolean isValid() {
        return channelId != null && !channelId.trim().isEmpty();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChannelInfo that = (ChannelInfo) o;
        return Objects.equals(channelId, that.channelId);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(channelId);
    }
    
    @Override
    public String toString() {
        return "ChannelInfo{" +
                "channelId='" + channelId + '\'' +
                ", channelName='" + channelName + '\'' +
                ", subscriberCount=" + subscriberCount +
                ", videoCount=" + videoCount +
                '}';
    }
}