package edu.miracosta.cs113;
import java.util.*;

public class Polynomial {
    public LinkedList<Term> list;

    public Polynomial() {
        list = new LinkedList<Term>();
    }


    public Polynomial(Polynomial poly) {
        //this();
        //Polynomial copy = new Polynomial();
        list = new LinkedList<Term>();
        Term temp;
       if(poly == null){
            return;
        }
        for(int i = 0; i < poly.getNumTerms(); i ++){
            temp = new Term(poly.getTerm(i));
            list.add(temp);
        }
    }

    int getNumTerms() {
        return list.size();
    }
    public LinkedList<Term> setList(LinkedList<Term> list){
        return this.list = list;
    }

    public LinkedList<Term> getList() {
        return list;
    }

    public void clear() {
        list.clear();
    }
    public Term getTerm(int index) {
        return list.get(index);
    }

    public void addTerm(Term term) {
        if (list.size() == 0) {
            list.add(term);
        } else {
            for (int x = 0; x < list.size(); x++) {
                if (list.get(x).getExponent() < term.getExponent()) {
                    list.add(x, term);
                    return;
                }
                if (list.get(x).getExponent() == term.getExponent()) {
                    if(list.get(x).getCoefficient() + term.getCoefficient() == 0){
                        list.remove(x);
                    }
                    else{
                        list.get(x).setCoefficient(list.get(x).getCoefficient() + term.getCoefficient());
                    }
                    return;
                }
            }
            list.add(term);
        }
    }

    void add(Polynomial secondPoly) {
        LinkedList<Term> secondList = secondPoly.getList();
        for(int x = 0; x < secondList.size(); x++){
            this.addTerm(secondPoly.getTerm(x));
        }
    }

    public String toString() {
        String poly = "";
        if(list.size() == 0){
            return "" + 0;
        }
        for (int x = 0; x < list.size(); x++) {
            if (poly.isEmpty()) {
                String sub = list.get(x).toString().substring(1, list.get(x).toString().length());
                poly += sub;
                System.out.println(poly);
            } else {
                poly += list.get(x).toString();
                System.out.println(poly);
            }
        }
    return poly;
    }
}



