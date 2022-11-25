package org.seoultech.fitnesspotential.domain.food.dto;

import lombok.*;
import org.seoultech.fitnesspotential.domain.food.entity.FoodInfoCategory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class FoodInfoCategoryResponse {

    private Map<String, List<String>> categories;

    @Builder
    public FoodInfoCategoryResponse(Map<String, List<String>> categories) {
        this.categories = categories;
    }

    public static class FoodInfoCategoryResponseBuilder {

        private Map<String, List<String>> categories;

        public FoodInfoCategoryResponseBuilder foodInfoCategories(Iterable<FoodInfoCategory> foodInfoCategories) {
            categories = new HashMap<>();
            for (FoodInfoCategory foodInfoCategory : foodInfoCategories) {
                categories.computeIfAbsent(foodInfoCategory.getMajorCategory(), k -> new ArrayList<>());
                categories.get(foodInfoCategory.getMajorCategory()).add(foodInfoCategory.getDetailedCategory());
            }
            return this;
        }
    }
}
