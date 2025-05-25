package com.youtube.fetcher.exception;

/**
 * YouTube API相关异常
 * 封装YouTube API调用过程中发生的各种异常情况
 * 
 * @author YouTube Fetcher Team
 * @version 1.0.0
 */
public class YouTubeApiException extends Exception {
    
    private final String errorCode;
    private final int httpStatusCode;
    
    /**
     * 默认构造函数
     * @param message 错误消息
     */
    public YouTubeApiException(String message) {
        super(message);
        this.errorCode = null;
        this.httpStatusCode = 0;
    }
    
    /**
     * 带错误代码的构造函数
     * @param message 错误消息
     * @param errorCode 错误代码
     */
    public YouTubeApiException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
        this.httpStatusCode = 0;
    }
    
    /**
     * 带HTTP状态码的构造函数
     * @param message 错误消息
     * @param errorCode 错误代码
     * @param httpStatusCode HTTP状态码
     */
    public YouTubeApiException(String message, String errorCode, int httpStatusCode) {
        super(message);
        this.errorCode = errorCode;
        this.httpStatusCode = httpStatusCode;
    }
    
    /**
     * 带原始异常的构造函数
     * @param message 错误消息
     * @param cause 原始异常
     */
    public YouTubeApiException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = null;
        this.httpStatusCode = 0;
    }
    
    /**
     * 完整构造函数
     * @param message 错误消息
     * @param errorCode 错误代码
     * @param httpStatusCode HTTP状态码
     * @param cause 原始异常
     */
    public YouTubeApiException(String message, String errorCode, int httpStatusCode, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
        this.httpStatusCode = httpStatusCode;
    }
    
    public String getErrorCode() {
        return errorCode;
    }
    
    public int getHttpStatusCode() {
        return httpStatusCode;
    }
    
    /**
     * 检查是否为API配额超限错误
     * @return 如果是403错误或错误代码包含quota则返回true
     */
    public boolean isQuotaExceeded() {
        return httpStatusCode == 403 || 
               (errorCode != null && errorCode.toLowerCase().contains("quota"));
    }
    
    /**
     * 检查是否为API密钥错误
     * @return 如果是401错误或错误代码包含key则返回true
     */
    public boolean isInvalidApiKey() {
        return httpStatusCode == 401 || 
               (errorCode != null && errorCode.toLowerCase().contains("key"));
    }
    
    /**
     * 检查是否为网络错误
     * @return 如果是5xx错误或网络相关异常则返回true
     */
    public boolean isNetworkError() {
        return httpStatusCode >= 500 || 
               (getCause() != null && getCause() instanceof java.net.ConnectException);
    }
}