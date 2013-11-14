package org.junit.ocd;

import java.util.List;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

public class OrderedJUnit4ClassRunner extends BlockJUnit4ClassRunner {

    public OrderedJUnit4ClassRunner(final Class<?> cls) throws InitializationError {
        super(cls);
    }

    @Override
    protected List<FrameworkMethod> computeTestMethods() {
        return TestOrderer.orderMethods(computeTestMethods());
    }

}
