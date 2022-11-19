package org.seoultech.fitnesspotential.domain.user.exception;

public enum UserErrorMessage {

    USER_NOT_FOUND("User is not found."),
    ;

    private final String text;

    UserErrorMessage(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
