package org.seoultech.fitnesspotential.domain.community.dto;

import lombok.*;
import org.seoultech.fitnesspotential.global.util.regex.HtmlRegex;
import org.seoultech.fitnesspotential.global.util.validation.constraints.ReplaceAllSize;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Component
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class CommunityCommentPostRequest {

    @NotNull
    private Long communityId;
    private Long parentCommentId;

    @NotNull
    @Size(min = 5, max = 512)
    @ReplaceAllSize(min = 5, max = 150, regex = HtmlRegex.HTML_TAG_REGEX, replacement = "")
    private String content;

    @Builder
    public CommunityCommentPostRequest(Long communityId, Long parentCommentId, String content) {
        this.communityId = communityId;
        this.parentCommentId = parentCommentId;
        this.content = content;
    }
}
