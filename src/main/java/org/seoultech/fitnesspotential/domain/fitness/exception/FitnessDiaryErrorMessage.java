package org.seoultech.fitnesspotential.domain.fitness.exception;

public enum FitnessDiaryErrorMessage {
    FITNESS_DIARY_NOT_FOUND("FitenssDiary was not found"),
    ;

    private final String message;

    FitnessDiaryErrorMessage(String message) {
        this.message = message;
    }
    @Override
    public String toString(){
        return message;
    }
}
