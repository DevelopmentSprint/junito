package org.junit.ocd.spring;

import java.util.List;

import org.junit.ocd.TestOrderer;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class OrderedSpringJUnit4ClassRunner extends SpringJUnit4ClassRunner {

    public OrderedSpringJUnit4ClassRunner(Class<?> cls) throws InitializationError {
        super(cls);
    }

    @Override
    protected List<FrameworkMethod> computeTestMethods() {
        return TestOrderer.orderMethods(super.computeTestMethods());
    }

}
