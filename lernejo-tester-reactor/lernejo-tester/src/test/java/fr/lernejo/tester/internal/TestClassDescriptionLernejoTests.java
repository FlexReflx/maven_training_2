package fr.lernejo.tester.internal;

import fr.lernejo.tester.SomeLernejoTests;

import java.lang.reflect.Method;
import java.util.List;

public class TestClassDescriptionLernejoTests {
    public static void main(String[] args) {
        TestClassDescription t = new TestClassDescription(SomeLernejoTests.class);
        List<Method> list = t.listTestMethods();
        for(Method m:list){
            System.out.println(m.getName());
        }
    }
}
