package com.leanh;

public class ComplexNumber {
    private double real;
    private double imaginary;

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public void add (double real, double imaginary) {
        this.real += real;
        this.imaginary += imaginary;
    }

    public void add (ComplexNumber anotherComplexNumber) {
        this.real += anotherComplexNumber.real;
        this.imaginary += anotherComplexNumber.imaginary;
    }

    public void subtract (double real, double imaginary) {
        this.real -= real;
        this.imaginary -= imaginary;
    }

    public void subtract (ComplexNumber anotherComplexNumber) {
        this.real -= anotherComplexNumber.real;
        this.imaginary -= anotherComplexNumber.imaginary;
    }
}
