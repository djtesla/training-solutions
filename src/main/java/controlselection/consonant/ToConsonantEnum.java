package controlselection.consonant;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public enum ToConsonantEnum {
    A(0), Á(0), B(1), C(1), D(1), E(0), É(0),
    F(1), G(1), H(1), I(0), J(1),
    K(1), L(1), M(1), N(1), O(0), Ö(0),
    P(1), Q(1), R(1), S(1), T(1),
    U(0), V(1), W(1), X(1), Y(1), Z(1);


    private int index;


    ToConsonantEnum(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

}
