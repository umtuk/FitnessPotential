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
public class CommunityCommentPutRequest {

    @NotNull
    @Size(max = 512)
    @ReplaceAllSize(min = 5, max = 150, regex = HtmlRegex.HTML_TAG_REGEX, replacement = "")
    private String content;

    @Builder
    public CommunityCommentPutRequest(String content) {
        this.content = content;
    }
}
