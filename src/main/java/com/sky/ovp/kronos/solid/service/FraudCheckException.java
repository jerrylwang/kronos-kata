package com.sky.ovp.kronos.solid.service;

public class FraudCheckException extends Exception{

    boolean suspicious = false;
    private String[] problems = null;

    public FraudCheckException( String[] problems){
        this.problems = problems;
        suspicious = true;
    }

    public String[] getProblems(){
        return problems;
    }
}
