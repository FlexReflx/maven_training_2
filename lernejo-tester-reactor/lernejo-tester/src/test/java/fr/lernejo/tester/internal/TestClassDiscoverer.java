package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestClassDiscoverer {
    String nom;

    public TestClassDiscoverer(String nom){
        this.nom = nom;
    }
    public List<TestClassDescription> listTestClasses(){
        List<TestClassDescription> list = new ArrayList<>();
        Reflections reflections = new Reflections(this.nom, new SubTypesScanner(false));
        Set<Class<?>> allTypes = reflections.getSubTypesOf(Object.class);
        for(Class<?> method:allTypes){

                Method[] m = method.getMethods();
                for(Method meth:m){
                    if(meth.isAnnotationPresent(TestMethod.class)
                            && meth.getClass().getPackage().endsWith("LernejoTests")){
                    list.add(new TestClassDescription(method));
                }
            }
        }
        return list;
    }

}
