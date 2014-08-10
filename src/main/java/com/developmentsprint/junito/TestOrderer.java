package com.developmentsprint.junito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.runners.model.FrameworkMethod;

public final class TestOrderer {

    private TestOrderer() {
        // prevent instantiation
    }

    public static List<FrameworkMethod> orderMethods(List<FrameworkMethod> methodsToOrder) {
        List<FrameworkMethod> copy = new ArrayList<FrameworkMethod>(methodsToOrder);

        // sort the annotated methods to the front of the list
        Collections.sort(copy, new Comparator<FrameworkMethod>() {
            public int compare(FrameworkMethod frameworkMethod, FrameworkMethod otherFrameworkMethod) {
                Order a = otherFrameworkMethod.getAnnotation(Order.class);
                if (a != null) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        // sort the annotated methods
        Collections.sort(copy, new Comparator<FrameworkMethod>() {
            public int compare(FrameworkMethod frameworkMethod, FrameworkMethod otherFrameworkMethod) {
                Order a1 = frameworkMethod.getAnnotation(Order.class);
                Order a2 = otherFrameworkMethod.getAnnotation(Order.class);
                if (a1 != null && a2 != null) {
                    return a1.weight() > a2.weight() ? +1 : a1.weight() < a2.weight() ? -1 : 0;
                } else {
                    return 0;
                }
            }
        });
        return copy;
    }
}
