package org.seoultech.fitnesspotential.domain.fitness.exception;

public enum FitnessRoutineErrorMessage {
    FITNESS_ROUTINE_NOT_FOUND("FitnessRoutine was not found"),
    ;
    private final String message;

    FitnessRoutineErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString(){
        return this.message;
    }
}
