package com.youtube.fetcher.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChannelInfoTest {

    @Test
    void isValidRequiresChannelId() {
        ChannelInfo info = new ChannelInfo();
        assertFalse(info.isValid());

        info.setChannelId("channel-123");
        assertTrue(info.isValid());
    }

    @Test
    void getChannelUrlUsesChannelId() {
        ChannelInfo info = new ChannelInfo("channel-999", "Channel Name");
        assertEquals("https://www.youtube.com/channel/channel-999", info.getChannelUrl());
    }

    @Test
    void equalsAndHashCodeUseChannelId() {
        ChannelInfo first = new ChannelInfo("id-1", "Name A");
        ChannelInfo second = new ChannelInfo("id-1", "Name B");
        ChannelInfo third = new ChannelInfo("id-2", "Name C");

        assertEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());
        assertNotEquals(first, third);
    }
}
