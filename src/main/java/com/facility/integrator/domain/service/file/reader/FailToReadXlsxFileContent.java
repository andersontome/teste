package com.facility.integrator.domain.service.file.reader;

import java.io.File;

public class FailToReadXlsxFileContent extends RuntimeException {

    private static final long serialVersionUID = 8279539043389491741L;

    FailToReadXlsxFileContent(final File file, final Throwable throwable) {
        super("An exception occurred while reading the content of the file " + file.getName(), throwable);
    }
}
