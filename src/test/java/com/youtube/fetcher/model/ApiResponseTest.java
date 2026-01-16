package com.youtube.fetcher.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApiResponseTest {

    @Test
    void successResponseSetsDefaults() {
        ApiResponse<String> response = ApiResponse.success(List.of("a", "b"));

        assertTrue(response.isSuccess());
        assertEquals(2, response.getDataSize());
        assertEquals(ApiResponse.Status.SUCCESS, response.getStatus());
        assertEquals("Request completed successfully", response.getMessage());
    }

    @Test
    void successResponseWithPagingTracksNextPage() {
        ApiResponse<String> response = ApiResponse.success(List.of("a"), "token-1", 42);

        assertTrue(response.hasNextPage());
        assertEquals("token-1", response.getNextPageToken());
        assertEquals(42, response.getTotalResults());
    }

    @Test
    void errorResponseSetsStatusAndMessage() {
        ApiResponse<String> response = ApiResponse.error("Bad request", "ERR-1");

        assertFalse(response.isSuccess());
        assertEquals(ApiResponse.Status.ERROR, response.getStatus());
        assertEquals("Bad request", response.getMessage());
        assertEquals("ERR-1", response.getErrorCode());
        assertEquals(0, response.getDataSize());
    }
}
