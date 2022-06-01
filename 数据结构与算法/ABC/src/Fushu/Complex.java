package Fushu;

public class Complex {
	double real, imag;
    Complex(double real, double imag) 
    {
        this.real=real;
        this.imag=imag;
    }
    public void add(Complex complex)
    {
        this.real+=complex.real;
        this.imag+=complex.imag;
    }
    public void sub(Complex complex)
    {
        this.real-=complex.real;
        this.imag-=complex.imag;
    }
    public String toString()
    {
    	return this.real+"+"+this.imag+"i";
    }
	
}
