package org.seoultech.fitnesspotential.domain.food.exception;

public enum FoodInfoErrorMessage {
    FOOD_INFO_NOT_FOUND("FoodInfo was not found"),
    ;
    private final String message;

    FoodInfoErrorMessage(String message){
        this.message = message;
    }
    @Override
    public String toString(){
        return message;
    }
}
