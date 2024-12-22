package org.knit.lab11.task25;

class FileSpecification {
    private final String fileName;
    private final long sizeInBytes;

    public FileSpecification(String fileName, long sizeInBytes) {
        this.fileName = fileName;
        this.sizeInBytes = sizeInBytes;
    }

    public String getFileName() {
        return fileName;
    }

    public long getSizeInBytes() {
        return sizeInBytes;
    }
}

