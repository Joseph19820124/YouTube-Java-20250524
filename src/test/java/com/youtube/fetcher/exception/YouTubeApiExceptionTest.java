package com.youtube.fetcher.exception;

import org.junit.jupiter.api.Test;

import java.net.ConnectException;

import static org.junit.jupiter.api.Assertions.*;

class YouTubeApiExceptionTest {

    @Test
    void quotaExceededUsesStatusOrErrorCode() {
        YouTubeApiException statusError = new YouTubeApiException("Quota", "quotaExceeded", 403);
        assertTrue(statusError.isQuotaExceeded());

        YouTubeApiException codeError = new YouTubeApiException("Quota", "quota", 200);
        assertTrue(codeError.isQuotaExceeded());
    }

    @Test
    void invalidApiKeyUsesStatusOrErrorCode() {
        YouTubeApiException statusError = new YouTubeApiException("Invalid", "ignored", 401);
        assertTrue(statusError.isInvalidApiKey());

        YouTubeApiException codeError = new YouTubeApiException("Invalid", "apiKeyInvalid");
        assertTrue(codeError.isInvalidApiKey());
    }

    @Test
    void networkErrorUsesStatusOrCause() {
        YouTubeApiException statusError = new YouTubeApiException("Server error", "server", 503);
        assertTrue(statusError.isNetworkError());

        YouTubeApiException causeError = new YouTubeApiException("Network down", new ConnectException("timeout"));
        assertTrue(causeError.isNetworkError());
    }
}
