package com.example.pageadmin.generator.model;

public class GeneratorJavaModel {

    private  String suffix = ".java";

    private  String path;

    private GeneratorJavaModel() {
    }

    public GeneratorJavaModel(String suffix, String path) {
        this.suffix = suffix;
        this.path = path;
    }

    public GeneratorJavaModel(String path) {
        this.path = path;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
