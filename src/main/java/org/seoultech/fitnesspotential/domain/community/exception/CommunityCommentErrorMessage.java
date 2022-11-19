package org.seoultech.fitnesspotential.domain.community.exception;

public enum CommunityCommentErrorMessage {

    COMMUNITY_NOT_FOUND("Community where comment is posted is not found."),
    COMMUNITY_COMMENT_NOT_FOUND("Community comment is not found."),
    COMMUNITY_PARENT_COMMENT_NOT_FOUND("Community comment's parent where comment is sub-posted is not found."),
    ;

    private final String text;

    CommunityCommentErrorMessage(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
