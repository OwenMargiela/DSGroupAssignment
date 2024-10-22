package Objects;


public class Config {
    private int batchSize;                // The batch size for processing
    private boolean directFileWrite;      // Flag for direct file write option
    private int walWriteFrequency;         // Write-Ahead Log write frequency

    // Constructor to initialize the Config object
    public Config(int batchSize, boolean directFileWrite, int walWriteFrequency) {
        this.batchSize = batchSize;
        this.directFileWrite = directFileWrite;
        this.walWriteFrequency = walWriteFrequency;
    }

    // Getter for batchSize
    public int getBatchSize() {
        return batchSize;
    }

    // Setter for batchSize
    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }

    // Getter for directFileWrite
    public boolean isDirectFileWrite() {
        return directFileWrite;
    }

    // Setter for directFileWrite
    public void setDirectFileWrite(boolean directFileWrite) {
        this.directFileWrite = directFileWrite;
    }

    // Getter for walWriteFrequency
    public int getWalWriteFrequency() {
        return walWriteFrequency;
    }

    // Setter for walWriteFrequency
    public void setWalWriteFrequency(int walWriteFrequency) {
        this.walWriteFrequency = walWriteFrequency;
    }
}
