package com.youtube.fetcher.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class VideoDataTest {

    @Test
    void isValidRequiresVideoIdAndTitle() {
        VideoData data = new VideoData();
        assertFalse(data.isValid());

        data.setVideoId("abc123");
        assertFalse(data.isValid());

        data.setTitle("Test Video");
        assertTrue(data.isValid());
    }

    @Test
    void getVideoUrlUsesVideoId() {
        VideoData data = new VideoData("xyz987", "Title", LocalDateTime.now());
        assertEquals("https://www.youtube.com/watch?v=xyz987", data.getVideoUrl());
    }

    @Test
    void equalsAndHashCodeUseVideoId() {
        VideoData first = new VideoData("id-1", "Title A", LocalDateTime.now());
        VideoData second = new VideoData("id-1", "Title B", LocalDateTime.now().minusDays(1));
        VideoData third = new VideoData("id-2", "Title C", LocalDateTime.now());

        assertEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());
        assertNotEquals(first, third);
    }
}
