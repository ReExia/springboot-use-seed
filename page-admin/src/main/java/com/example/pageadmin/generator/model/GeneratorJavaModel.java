package com.example.pageadmin.generator.model;

public class GeneratorJavaModel {

    private  String suffix = ".java";

    public GeneratorJavaModel(String suffix) {
        this.suffix = suffix;
    }

    public GeneratorJavaModel() {
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
