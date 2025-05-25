package com.youtube.fetcher.model;

import java.util.List;
import java.util.Objects;

/**
 * API响应包装类
 * 封装API调用的结果，包括数据、状态和分页信息
 * 
 * @param <T> 响应数据类型
 * @author YouTube Fetcher Team
 * @version 1.0.0
 */
public class ApiResponse<T> {
    
    /**
     * 响应状态枚举
     */
    public enum Status {
        SUCCESS,    // 成功
        ERROR,      // 错误
        PARTIAL     // 部分成功
    }
    
    private Status status;
    private String message;
    private List<T> data;
    private String nextPageToken;
    private Integer totalResults;
    private Integer resultsPerPage;
    private Long requestCount;
    private String errorCode;
    
    /**
     * 默认构造函数
     */
    public ApiResponse() {
    }
    
    /**
     * 成功响应构造函数
     * @param data 响应数据
     */
    public ApiResponse(List<T> data) {
        this.status = Status.SUCCESS;
        this.data = data;
        this.message = "Request completed successfully";
    }
    
    /**
     * 错误响应构造函数
     * @param message 错误消息
     * @param errorCode 错误代码
     */
    public ApiResponse(String message, String errorCode) {
        this.status = Status.ERROR;
        this.message = message;
        this.errorCode = errorCode;
    }
    
    /**
     * 创建成功响应
     * @param data 响应数据
     * @param <T> 数据类型
     * @return 成功的API响应
     */
    public static <T> ApiResponse<T> success(List<T> data) {
        return new ApiResponse<>(data);
    }
    
    /**
     * 创建成功响应（带分页信息）
     * @param data 响应数据
     * @param nextPageToken 下一页令牌
     * @param totalResults 总结果数
     * @param <T> 数据类型
     * @return 成功的API响应
     */
    public static <T> ApiResponse<T> success(List<T> data, String nextPageToken, Integer totalResults) {
        ApiResponse<T> response = new ApiResponse<>(data);
        response.setNextPageToken(nextPageToken);
        response.setTotalResults(totalResults);
        return response;
    }
    
    /**
     * 创建错误响应
     * @param message 错误消息
     * @param <T> 数据类型
     * @return 错误的API响应
     */
    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(message, null);
    }
    
    /**
     * 创建错误响应
     * @param message 错误消息
     * @param errorCode 错误代码
     * @param <T> 数据类型
     * @return 错误的API响应
     */
    public static <T> ApiResponse<T> error(String message, String errorCode) {
        return new ApiResponse<>(message, errorCode);
    }
    
    /**
     * 检查响应是否成功
     * @return 如果状态为SUCCESS则返回true
     */
    public boolean isSuccess() {
        return status == Status.SUCCESS;
    }
    
    /**
     * 检查是否有更多页面
     * @return 如果有下一页令牌则返回true
     */
    public boolean hasNextPage() {
        return nextPageToken != null && !nextPageToken.trim().isEmpty();
    }
    
    /**
     * 获取数据大小
     * @return 数据列表的大小，如果为null则返回0
     */
    public int getDataSize() {
        return data != null ? data.size() : 0;
    }
    
    // Getters and Setters
    public Status getStatus() {
        return status;
    }
    
    public void setStatus(Status status) {
        this.status = status;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public List<T> getData() {
        return data;
    }
    
    public void setData(List<T> data) {
        this.data = data;
    }
    
    public String getNextPageToken() {
        return nextPageToken;
    }
    
    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }
    
    public Integer getTotalResults() {
        return totalResults;
    }
    
    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }
    
    public Integer getResultsPerPage() {
        return resultsPerPage;
    }
    
    public void setResultsPerPage(Integer resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }
    
    public Long getRequestCount() {
        return requestCount;
    }
    
    public void setRequestCount(Long requestCount) {
        this.requestCount = requestCount;
    }
    
    public String getErrorCode() {
        return errorCode;
    }
    
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiResponse<?> that = (ApiResponse<?>) o;
        return status == that.status &&
                Objects.equals(message, that.message) &&
                Objects.equals(data, that.data) &&
                Objects.equals(nextPageToken, that.nextPageToken);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(status, message, data, nextPageToken);
    }
    
    @Override
    public String toString() {
        return "ApiResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", dataSize=" + getDataSize() +
                ", hasNextPage=" + hasNextPage() +
                '}';
    }
}