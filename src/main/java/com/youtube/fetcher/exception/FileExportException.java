package com.youtube.fetcher.exception;

/**
 * 文件导出异常
 * 封装文件导出过程中发生的各种异常情况
 * 
 * @author YouTube Fetcher Team
 * @version 1.0.0
 */
public class FileExportException extends Exception {
    
    private final String filePath;
    private final String exportFormat;
    
    /**
     * 默认构造函数
     * @param message 错误消息
     */
    public FileExportException(String message) {
        super(message);
        this.filePath = null;
        this.exportFormat = null;
    }
    
    /**
     * 带文件路径的构造函数
     * @param message 错误消息
     * @param filePath 文件路径
     */
    public FileExportException(String message, String filePath) {
        super(message);
        this.filePath = filePath;
        this.exportFormat = null;
    }
    
    /**
     * 带文件路径和导出格式的构造函数
     * @param message 错误消息
     * @param filePath 文件路径
     * @param exportFormat 导出格式
     */
    public FileExportException(String message, String filePath, String exportFormat) {
        super(message);
        this.filePath = filePath;
        this.exportFormat = exportFormat;
    }
    
    /**
     * 带原始异常的构造函数
     * @param message 错误消息
     * @param cause 原始异常
     */
    public FileExportException(String message, Throwable cause) {
        super(message, cause);
        this.filePath = null;
        this.exportFormat = null;
    }
    
    /**
     * 完整构造函数
     * @param message 错误消息
     * @param filePath 文件路径
     * @param exportFormat 导出格式
     * @param cause 原始异常
     */
    public FileExportException(String message, String filePath, String exportFormat, Throwable cause) {
        super(message, cause);
        this.filePath = filePath;
        this.exportFormat = exportFormat;
    }
    
    public String getFilePath() {
        return filePath;
    }
    
    public String getExportFormat() {
        return exportFormat;
    }
    
    /**
     * 检查是否为文件权限错误
     * @return 如果是权限相关异常则返回true
     */
    public boolean isPermissionError() {
        return getCause() instanceof java.security.AccessControlException ||
               (getMessage() != null && getMessage().toLowerCase().contains("permission"));
    }
    
    /**
     * 检查是否为磁盘空间不足错误
     * @return 如果是磁盘空间相关异常则返回true
     */
    public boolean isDiskSpaceError() {
        return getMessage() != null && 
               (getMessage().toLowerCase().contains("no space") ||
                getMessage().toLowerCase().contains("disk full"));
    }
}