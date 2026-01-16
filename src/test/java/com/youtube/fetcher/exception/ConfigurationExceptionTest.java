package com.youtube.fetcher.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigurationExceptionTest {

    @Test
    void apiKeyMissingMatchesConfigKey() {
        ConfigurationException exception = new ConfigurationException("Missing", "YOUTUBE_API_KEY");
        assertTrue(exception.isApiKeyMissing());
    }

    @Test
    void pathConfigErrorMatchesConfigKey() {
        ConfigurationException pathError = new ConfigurationException("Missing", "output_path");
        assertTrue(pathError.isPathConfigError());

        ConfigurationException dirError = new ConfigurationException("Missing", "cache_directory");
        assertTrue(dirError.isPathConfigError());
    }
}
