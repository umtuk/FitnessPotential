package org.seoultech.fitnesspotential.domain.community.dto;

import lombok.*;
import org.seoultech.fitnesspotential.global.util.regex.HtmlRegex;
import org.seoultech.fitnesspotential.global.util.validation.constraints.ReplaceAllSize;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Component
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class CommunityPostRequest {

    @NotNull
    @Size(min = 5, max = 64)
    private String title;

    @NotNull
    @Size(max = 1024)
    @ReplaceAllSize(min = 10, max = 300, regex = HtmlRegex.HTML_TAG_REGEX, replacement = "")
    private String content;

    @NotNull
    @Size(min = 1, max = 10)
    private List<@Size(min = 4, max = 32) String> tags;

    @Builder
    public CommunityPostRequest(String title, String content, List<String> tags) {
        this.title = title;
        this.content = content;
        this.tags = tags;
    }
}
