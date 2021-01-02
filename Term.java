package edu.miracosta.cs113;

public class Term implements Cloneable, Comparable{
    int coefficient;
    int exponent;
    public Term(int co, int ex){
        coefficient = co;
        exponent = ex;
    }
    public Term(){
        this.coefficient = 1;
        this.exponent = 1;
    }
    public Term(Term term){
        this.coefficient = term.getCoefficient();
        this.exponent = term.getExponent();
    }
    public Term(String term){
        int expLastIndex;
        int expBeginIndex;
        int coEndIndex;
        int coBegIndex;
        int exp;
        int co;
        String exponent;
        String coefficient;
        if(term == null || term.isEmpty()){
            this.exponent = 0;
            this.coefficient = 0;
        }
        if (term.contains("^") && term.contains("x")) {
            if(term.contains("+")) {
                if(term.charAt(1) != 'x') {
                    coEndIndex = term.indexOf('x');
                    expBeginIndex = term.indexOf('^');
                    exponent = term.substring(expBeginIndex + 1);
                    coefficient = term.substring(1, coEndIndex);
                    co = Integer.parseInt(coefficient);
                    exp = Integer.parseInt(exponent);
                    this.coefficient = co;
                    this.exponent = exp;
                }else{
                    coEndIndex = term.indexOf('x');
                    expBeginIndex = term.indexOf('^');
                    exponent = term.substring(expBeginIndex + 1);
                    exp = Integer.parseInt(exponent);
                    this.coefficient = 1;
                    this.exponent = exp;
                }
            }
            else if(term.contains("-")) {
                if(term.charAt(1) != 'x') {
                    coEndIndex = term.indexOf('x');
                    expBeginIndex = term.indexOf('^');
                    exponent = term.substring(expBeginIndex + 1);
                    coefficient = term.substring(0, coEndIndex);
                    co = Integer.parseInt(coefficient);
                    exp = Integer.parseInt(exponent);
                    this.coefficient = co;
                    this.exponent = exp;
                }else{
                    expBeginIndex = term.indexOf('^');
                    exponent = term.substring(expBeginIndex + 1);
                    exp = Integer.parseInt(exponent);
                    this.coefficient = -1;
                    this.exponent = exp;
                }
            }else{

            }
        }
        if (term.contains("x") && !term.contains("^")) {
            if(term.contains("+")) {
                if(term.charAt(1) != 'x') {
                    coEndIndex = term.indexOf('x');
                    coefficient = term.substring(1, coEndIndex);
                    co = Integer.parseInt(coefficient);
                    this.coefficient = co;
                    this.exponent = 1;
                }else{
                    this.coefficient = 1;
                    this.exponent = 1;
                }
            }
            if (term.contains("-")){
                if(term.charAt(1) != 'x') {
                    coEndIndex = term.indexOf('x');
                    coefficient = term.substring(0, coEndIndex);
                    co = Integer.parseInt(coefficient);
                    this.coefficient = co;
                    this.exponent = 1;
                }else{
                    this.coefficient = -1;
                    this.exponent = 1;
                }
            }
        }
        if (!term.contains("x") && !term.contains("^")) {
            co = Integer.parseInt(term);
            this.coefficient = co;
            this.exponent = 0;
        }
    }
    public Object clone(){
        return new Term(this);
    }
    public int compareTo(Object o){
        Term term = (Term)o;
        if(this.getExponent() == term.getExponent()){
            return 0;
        }
        else if(this.getExponent() < term.getExponent()){
            return -1;
        }
        else{
            return 1;
        }
    }
    void setExponent(int ex){
        exponent = ex;
    }
    void setCoefficient(int co){
        coefficient = co;
    }
    void setAll(int co, int ex){
        coefficient = co;
        exponent = ex;
    }
    int getExponent(){
        return exponent;
    }
    int getCoefficient(){
        return coefficient;
    }
    public String toString() {
        if (getCoefficient() == 0) {
            return "";
        }
        if (getExponent() == 0 && getCoefficient() > 0) {
            return "+" + getCoefficient();
        }
        if(getExponent() == 0 && getCoefficient() < 0){
            return "" + getCoefficient();
        }
        if(getCoefficient() == 1 && getExponent() < 1){
            return "" + "+x^" + getExponent();
        }
        if(getCoefficient() == -1 && getExponent() < -1){
            return "" +  "-x^" + getExponent();
        }
        if(getExponent() >1 && getCoefficient() == -1){
            return "" + "-x^" + getExponent();
        }
        if(getExponent() == 1 && getCoefficient() == -1){
            return "" + "-x";
        }
        if(getExponent() == 1 && getCoefficient() == 1){
            return "" + "+" + "x";
        }
        if(getExponent() == 1 && getCoefficient() > 1){
            return "" + "+" + getCoefficient() + "x";
        }
        if(getExponent() == 1 && getCoefficient() == -1){
            return "" + "-x";
        }
        if(getCoefficient() == 1 && getExponent() > 1){
            return "" + "+x^" + getExponent();
        }
        if(getExponent() == 1 && getCoefficient() < -1){
            return "" + getCoefficient() + "x";
        }
        else if(getExponent() > 0 && getCoefficient() == 1){
            return "" + getCoefficient() + " x^" + getExponent();
        }
        else {
            String co = "" + getCoefficient();
            if (co.contains("-")) {
                String sub = co.substring(1, co.length());
                System.out.println(sub);
                String ex = "" + getExponent();
                System.out.println(ex);
                return " - " + sub + "x^" + ex;
            } else {
                return "" + "+" + getCoefficient() + "x^" + getExponent();
            }
        }
    }
    public boolean equals(Object o){
        if (o == null){
            return false;
        }
        else if(o instanceof Term){
            Term temp = (Term)o;
            return (this.exponent == temp.exponent && this.coefficient == temp.coefficient);
        }
        else {
            return false;
        }
    }
}
