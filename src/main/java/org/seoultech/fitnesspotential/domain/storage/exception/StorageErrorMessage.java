package org.seoultech.fitnesspotential.domain.storage.exception;

public enum StorageErrorMessage {

    STORAGE_NOT_FOUND("Storage is not found."),
    ;

    private final String text;

    StorageErrorMessage(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
