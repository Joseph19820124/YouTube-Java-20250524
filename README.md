# YouTube视频获取工具 - Java版本

这是一个使用Java重构的YouTube频道视频信息获取工具，采用了模块化架构和多种设计模式，具有更好的可扩展性和可维护性。

## 🏗️ 项目架构

本项目采用了以下设计模式和架构原则：

- **工厂模式 (Factory Pattern)**: 用于创建不同类型的文件导出器
- **策略模式 (Strategy Pattern)**: 用于支持多种文件输出格式
- **建造者模式 (Builder Pattern)**: 用于构建YouTube API客户端
- **单例模式 (Singleton Pattern)**: 用于配置管理
- **观察者模式 (Observer Pattern)**: 用于进度监控
- **模板方法模式 (Template Method)**: 用于抽象文件导出流程

## 📁 项目结构

```
src/main/java/com/youtube/fetcher/
├── Application.java                 # 主应用程序入口
├── config/
│   ├── ApiConfiguration.java        # API配置管理 (Singleton)
│   └── ApplicationProperties.java   # 应用程序属性
├── model/
│   ├── VideoData.java              # 视频数据模型
│   ├── ChannelInfo.java            # 频道信息模型
│   └── ApiResponse.java            # API响应包装类
├── service/
│   ├── YouTubeService.java         # YouTube API服务接口
│   ├── YouTubeServiceImpl.java     # YouTube API服务实现
│   └── ChannelAnalyzer.java        # 频道分析服务
├── client/
│   ├── YouTubeApiClient.java       # YouTube API客户端接口
│   ├── YouTubeApiClientImpl.java   # YouTube API客户端实现
│   └── ApiClientBuilder.java       # API客户端建造者 (Builder)
├── export/
│   ├── FileExporter.java           # 文件导出器接口
│   ├── ExporterFactory.java        # 导出器工厂 (Factory)
│   ├── strategy/
│   │   ├── ExportStrategy.java      # 导出策略接口 (Strategy)
│   │   ├── TxtExportStrategy.java   # TXT导出策略
│   │   ├── JsonExportStrategy.java  # JSON导出策略
│   │   └── CsvExportStrategy.java   # CSV导出策略
│   └── AbstractFileExporter.java   # 抽象文件导出器 (Template Method)
├── observer/
│   ├── ProgressObserver.java        # 进度观察者接口 (Observer)
│   ├── ConsoleProgressObserver.java # 控制台进度观察者
│   └── ProgressEvent.java          # 进度事件
├── exception/
│   ├── YouTubeApiException.java    # YouTube API异常
│   ├── FileExportException.java    # 文件导出异常
│   └── ConfigurationException.java # 配置异常
└── util/
    ├── ChannelIdValidator.java      # 频道ID验证器
    ├── FileUtil.java               # 文件工具类
    └── StringUtil.java             # 字符串工具类
```

## ✨ 功能特性

- 🎯 **模块化设计**: 清晰的分层架构，职责分离
- 🏭 **设计模式**: 使用多种设计模式提高代码质量
- 📊 **多格式导出**: 支持TXT、JSON、CSV三种格式
- 🔄 **自动分页**: 自动处理API分页，获取所有视频
- 📈 **进度监控**: 实时显示获取进度（观察者模式）
- 🛡️ **异常处理**: 完善的异常处理体系
- 🔧 **配置管理**: 统一的配置管理（单例模式）
- ⚡ **性能优化**: 连接池和缓存机制
- 🧪 **易于测试**: 良好的可测试性设计

## 🚀 快速开始

### 1. 环境要求

- Java 11+
- Maven 3.6+
- YouTube Data API v3 密钥

### 2. 设置API密钥

```bash
# Linux/Mac
export YOUTUBE_API_KEY='你的API密钥'

# Windows
set YOUTUBE_API_KEY=你的API密钥

# PowerShell
$env:YOUTUBE_API_KEY='你的API密钥'
```

### 3. 编译运行

```bash
# 编译项目
mvn clean compile

# 运行主程序
mvn exec:java -Dexec.mainClass="com.youtube.fetcher.Application"

# 或者打包后运行
mvn clean package
java -jar target/youtube-fetcher-1.0.0.jar
```

## 💡 使用示例

### 基本使用

```java
// 创建YouTube服务
YouTubeService youTubeService = new YouTubeServiceImpl();

// 获取频道视频
String channelId = "UCMUnInmOkrWN4gof9KlhNmQ";
List<VideoData> videos = youTubeService.getChannelVideos(channelId);

// 导出为不同格式
FileExporter exporter = ExporterFactory.createExporter("json");
exporter.export(videos, "videos.json");
```

### 使用进度监控

```java
// 添加进度观察者
ProgressObserver progressObserver = new ConsoleProgressObserver();
youTubeService.addProgressObserver(progressObserver);

// 执行获取操作
List<VideoData> videos = youTubeService.getChannelVideos(channelId);
```

## 🔧 配置选项

项目支持通过`application.properties`文件进行配置：

```properties
# API配置
api.youtube.maxResults=50
api.youtube.timeout=30000
api.youtube.retryAttempts=3

# 导出配置
export.defaultFormat=json
export.outputDirectory=./output

# 日志配置
logging.level=INFO
```

## 🧪 测试

```bash
# 运行所有测试
mvn test

# 运行特定测试
mvn test -Dtest=YouTubeServiceTest

# 生成测试报告
mvn surefire-report:report
```

## 📋 依赖项

- Google APIs Client Library for Java
- Jackson (JSON处理)
- Apache Commons CSV (CSV处理)
- SLF4J + Logback (日志)
- JUnit 5 (测试)
- Mockito (模拟测试)

## 🤝 贡献指南

1. Fork 本仓库
2. 创建特性分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 开启 Pull Request

## 📄 许可证

MIT License - 详见 [LICENSE](LICENSE) 文件

## 🔗 相关链接

- [原Python版本](https://github.com/Joseph19820124/YouTube-20250524)
- [YouTube Data API v3 文档](https://developers.google.com/youtube/v3)
- [Google API Java客户端](https://github.com/googleapis/google-api-java-client)

## 📞 支持

如有问题或建议，请创建 [Issue](https://github.com/Joseph19820124/YouTube-Java-20250524/issues)。