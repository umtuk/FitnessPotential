package org.seoultech.fitnesspotential.domain.fitness.exception;

public enum FitnessUnitErrorMessage {
    FITNESS_UNIT_NOT_FOUND("FitnessUnit was not found"),
    ;

    private final String message;


    FitnessUnitErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString(){
        return this.message;
    }
}
