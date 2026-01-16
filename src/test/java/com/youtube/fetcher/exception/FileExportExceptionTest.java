package com.youtube.fetcher.exception;

import org.junit.jupiter.api.Test;

import java.security.AccessControlException;

import static org.junit.jupiter.api.Assertions.*;

class FileExportExceptionTest {

    @Test
    void permissionErrorMatchesCauseOrMessage() {
        FileExportException causeError = new FileExportException("Denied", new AccessControlException("nope"));
        assertTrue(causeError.isPermissionError());

        FileExportException messageError = new FileExportException("Permission denied");
        assertTrue(messageError.isPermissionError());
    }

    @Test
    void diskSpaceErrorMatchesMessage() {
        FileExportException noSpace = new FileExportException("No space left on device");
        assertTrue(noSpace.isDiskSpaceError());

        FileExportException diskFull = new FileExportException("Disk full while writing");
        assertTrue(diskFull.isDiskSpaceError());
    }
}
