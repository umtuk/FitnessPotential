package org.seoultech.fitnesspotential.domain.food.exception;

public enum FoodDiaryErrorMessage {
    FOOD_DIARY_NOT_FOUND("FoodDiary was not found"),
    ;
    private final String message;

    FoodDiaryErrorMessage(String message){
        this.message = message;
    }
    @Override
    public String toString(){
        return message;
    }
}
