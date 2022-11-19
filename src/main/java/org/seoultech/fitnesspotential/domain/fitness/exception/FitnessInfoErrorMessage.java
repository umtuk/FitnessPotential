package org.seoultech.fitnesspotential.domain.fitness.exception;

public enum FitnessInfoErrorMessage {
    FITNESS_INFO_NOT_FOUND("FitnessInfo was not found"),
    ;

    private final String message;

    FitnessInfoErrorMessage(final String message){
        this.message = message;
    }

    @Override
    public String toString(){
        return message;
    }
}
