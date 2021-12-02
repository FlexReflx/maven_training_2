package fr.lernejo.tester.internal;

import java.util.List;

public class TestClassDiscovererLernejoTests {

    public static void main(String[] args) {
        TestClassDiscoverer disc = new TestClassDiscoverer("fr.lernejo.tester");
        List<TestClassDescription> list = disc.listTestClasses();
        for(TestClassDescription d:list){

        }
    }
}
