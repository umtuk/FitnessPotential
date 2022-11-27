package org.seoultech.fitnesspotential.domain.fitness.dto.info;

import lombok.AccessLevel;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Component
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class FitnessInfoPutRequest {
    @NotNull
    @Size(min = 5, max = 64)
    private String title;

    @NotNull
    @Size(min = 5, max = 64)
    private String summary;

    @NotNull
    @Size(max = 1024)
    private String content;

    @NotNull
    private Long thumbnail;

    @NotNull
    @Size(min = 1, max = 32)
    private String majorCategory;

    @NotNull
    @Size(min = 1, max = 32)
    private String detailedCategory;
}
