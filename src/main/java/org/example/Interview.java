package org.example;

import javax.security.auth.Subject;
import java.net.InterfaceAddress;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Interview {
    public static void main(String[] args) {
        new Interview().method(130);
    }

    void method(int ls) {
        System.out.println("hellolist");
    }
    void method(Integer ls) {
        System.out.println("helloArraylist");
    }
}