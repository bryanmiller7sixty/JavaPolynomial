package edu.miracosta.cs113;
import java.util.*;
public class PolynomialDriver {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int input;
        int input2;
        int inputCo;
        int inputEx;
        Polynomial poly1 = new Polynomial();
        Polynomial poly2 = new Polynomial();
        Term termTemp;
        boolean condition = true;

        System.out.println("Hello");
        while (condition) {
            System.out.println("Press 1 to edit first polynomial");
            System.out.println("Press 2 to edit the second polynomial");
            System.out.println("Press 3 to add your polynomials");
            System.out.println("Press 4 to exit the program");
            input = scan.nextInt();
            if(input == 1){
                System.out.println("Press 1 to add a term to the first polynomial");
                System.out.println("Press 2 to clear the polynomial");
                input2 = scan.nextInt();
                if(input2 == 1) {
                    System.out.println("Add your coefficient now:");
                    inputCo = scan.nextInt();
                    System.out.println("Add your exponent now");
                    inputEx = scan.nextInt();
                    termTemp = new Term(inputCo, inputEx);
                    poly1.addTerm(termTemp);
                }
                if(input2 == 2) {
                    poly1.clear();
                }
            }
            if(input == 2){
                System.out.println("Press 1 to add a term to the second polynomial");
                System.out.println("Press 2 to clear the polynomial");
                input2 = scan.nextInt();
                if(input2 == 1) {
                    System.out.println("Add your coefficient now:");
                    inputCo = scan.nextInt();
                    System.out.println("Add your exponent now");
                    inputEx = scan.nextInt();
                    termTemp = new Term(inputCo, inputEx);
                    poly2.addTerm(termTemp);
                }
                if(input2 == 2) {
                    poly1.clear();
                }
            }
            if(input == 3){
                poly1.add(poly2);
                System.out.println("Current polynomial after adding: ");
                System.out.println(poly1);
            }
            if(input == 4){
                condition = false;
            }
        }
    }
}
