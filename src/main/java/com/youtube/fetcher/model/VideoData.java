package com.youtube.fetcher.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * YouTube视频数据模型
 * 封装单个视频的基本信息
 * 
 * @author YouTube Fetcher Team
 * @version 1.0.0
 */
public class VideoData {
    
    @JsonProperty("video_id")
    private String videoId;
    
    @JsonProperty("title")
    private String title;
    
    @JsonProperty("published_at")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime publishedAt;
    
    @JsonProperty("description")
    private String description;
    
    @JsonProperty("duration")
    private String duration;
    
    @JsonProperty("view_count")
    private Long viewCount;
    
    @JsonProperty("like_count")
    private Long likeCount;
    
    @JsonProperty("comment_count")
    private Long commentCount;
    
    @JsonProperty("thumbnail_url")
    private String thumbnailUrl;
    
    @JsonProperty("channel_id")
    private String channelId;
    
    /**
     * 默认构造函数
     */
    public VideoData() {
    }
    
    /**
     * 基本构造函数
     * @param videoId 视频ID
     * @param title 视频标题
     * @param publishedAt 发布时间
     */
    public VideoData(String videoId, String title, LocalDateTime publishedAt) {
        this.videoId = videoId;
        this.title = title;
        this.publishedAt = publishedAt;
    }
    
    /**
     * 完整构造函数
     */
    public VideoData(String videoId, String title, LocalDateTime publishedAt, 
                    String description, String duration, Long viewCount, 
                    Long likeCount, Long commentCount, String thumbnailUrl, String channelId) {
        this.videoId = videoId;
        this.title = title;
        this.publishedAt = publishedAt;
        this.description = description;
        this.duration = duration;
        this.viewCount = viewCount;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.thumbnailUrl = thumbnailUrl;
        this.channelId = channelId;
    }
    
    // Getters and Setters
    public String getVideoId() {
        return videoId;
    }
    
    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }
    
    public void setPublishedAt(LocalDateTime publishedAt) {
        this.publishedAt = publishedAt;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getDuration() {
        return duration;
    }
    
    public void setDuration(String duration) {
        this.duration = duration;
    }
    
    public Long getViewCount() {
        return viewCount;
    }
    
    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }
    
    public Long getLikeCount() {
        return likeCount;
    }
    
    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }
    
    public Long getCommentCount() {
        return commentCount;
    }
    
    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }
    
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
    
    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
    
    public String getChannelId() {
        return channelId;
    }
    
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
    
    /**
     * 获取视频URL
     * @return YouTube视频链接
     */
    public String getVideoUrl() {
        return "https://www.youtube.com/watch?v=" + videoId;
    }
    
    /**
     * 检查是否为有效的视频数据
     * @return 如果视频ID和标题都不为空则返回true
     */
    public boolean isValid() {
        return videoId != null && !videoId.trim().isEmpty() && 
               title != null && !title.trim().isEmpty();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideoData videoData = (VideoData) o;
        return Objects.equals(videoId, videoData.videoId);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(videoId);
    }
    
    @Override
    public String toString() {
        return "VideoData{" +
                "videoId='" + videoId + '\'' +
                ", title='" + title + '\'' +
                ", publishedAt=" + publishedAt +
                ", viewCount=" + viewCount +
                '}';
    }
}