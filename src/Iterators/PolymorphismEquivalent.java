package Iterators;

import java.util.Arrays;
import java.util.List;

public class PolymorphismEquivalent {

    public static void main(String[] args) {

        // POLYMORPHISM WORKS AS BEFORE
        // Vankrat Subramaniam  / Get a Taste of (30:00)

        SuperClass[] supArr = new SuperClass[2];
        supArr[0] = new SuperClass(1);
        supArr[1] = new DerivedClass(1);
        List<SuperClass> supList = Arrays.asList(supArr);

        for (SuperClass sc : supArr) {
            sc.printField();
        }

        for (SuperClass sc : supList) {
            sc.printField();
        }

        supList.forEach(SuperClass::printField);

        for(int i = 0; i<supList.size(); i++) {
            SuperClass sc = supList.get(i);
            sc.printField();
        }


        /*
                    Advantages:

                    - you (have to) control the iteration yourself
        */


    }

    static class SuperClass {

        protected int i;

        public SuperClass(int i) {
            this.i = i;
        }

        public void printField() {
            System.out.println("Super Implementation prints value " + i);
        }

    }

    static class DerivedClass extends SuperClass {

        public DerivedClass(int i) {
            super(i);
        }

        public void printField() {
            System.out.println("Override Implementation prints twice the value " + 2 * i);
        }

    }


}

