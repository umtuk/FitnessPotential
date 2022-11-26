package org.seoultech.fitnesspotential.domain.fitness.dto.diary;

import lombok.AccessLevel;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.*;
import java.util.List;

@Component
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class FitnessDiaryPutRequest {

    @NotNull
    @Size(min = 5, max = 64)
    private String title;

    @NotNull
    @Size(min = 1, max = 10)
    private List<@Positive Integer> breakTimesPerSet;

    @NotNull
    @Size(min = 1, max = 10)
    private List<@Positive Integer> reps;

    @NotNull
    @Size(min = 1, max = 10)
    private List<@Positive Integer> weights;

    @NotNull
    @Min(1)
    @Max(30)
    private Integer sets;

    @NotNull
    @PositiveOrZero
    private Integer year;

    @NotNull
    @Min(1)
    @Max(12)
    private Integer month;

    @NotNull
    @Min(1)
    @Max(31)
    private Integer day;
}
