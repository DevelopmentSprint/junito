Junit OCD
============

JUnit does not specify or ensure the execution order of test method invocations. 

JUnit 4.11 allows for specifying execution order according to a predefined list of MethodSorters, but even these are fairly inflexible. JUnit-OCD provides a mechanism for ensuring that tests are run in a specific order defined by the test writer.

To configure the test execution order simply annotate your test methods using `@OrderedTest(N)` where N is the order in which you want to run the test in. You also need to specify the test runner to be `OrderedJUnit4ClassRunner` for a standard unit test, or OrderedSpringJUnit4ClassRunner to provide spring functionality if you are using Spring-enhanced tests.

Any methods annotated with the same value for N will execute according to JUnit's method for ordering within the matching set. Any methods within a test class that are not annotated will be run after the annotated tests according to JUnit's method for ordering. 