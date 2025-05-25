package com.youtube.fetcher.exception;

/**
 * 配置异常
 * 封装应用程序配置相关的异常情况
 * 
 * @author YouTube Fetcher Team
 * @version 1.0.0
 */
public class ConfigurationException extends Exception {
    
    private final String configKey;
    
    /**
     * 默认构造函数
     * @param message 错误消息
     */
    public ConfigurationException(String message) {
        super(message);
        this.configKey = null;
    }
    
    /**
     * 带配置键的构造函数
     * @param message 错误消息
     * @param configKey 配置键名
     */
    public ConfigurationException(String message, String configKey) {
        super(message);
        this.configKey = configKey;
    }
    
    /**
     * 带原始异常的构造函数
     * @param message 错误消息
     * @param cause 原始异常
     */
    public ConfigurationException(String message, Throwable cause) {
        super(message, cause);
        this.configKey = null;
    }
    
    /**
     * 完整构造函数
     * @param message 错误消息
     * @param configKey 配置键名
     * @param cause 原始异常
     */
    public ConfigurationException(String message, String configKey, Throwable cause) {
        super(message, cause);
        this.configKey = configKey;
    }
    
    public String getConfigKey() {
        return configKey;
    }
    
    /**
     * 检查是否为API密钥缺失错误
     * @return 如果配置键为API密钥相关则返回true
     */
    public boolean isApiKeyMissing() {
        return configKey != null && configKey.toLowerCase().contains("api") && 
               configKey.toLowerCase().contains("key");
    }
    
    /**
     * 检查是否为文件路径配置错误
     * @return 如果配置键为路径相关则返回true
     */
    public boolean isPathConfigError() {
        return configKey != null && 
               (configKey.toLowerCase().contains("path") || 
                configKey.toLowerCase().contains("directory"));
    }
}