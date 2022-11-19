package org.seoultech.fitnesspotential.domain.community.exception;

public enum CommunityErrorMessage {

    COMMUNITY_NOT_FOUND("Community is not found."),
    ;

    private final String text;

    CommunityErrorMessage(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
