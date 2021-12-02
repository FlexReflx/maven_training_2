package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

public class TestClassDescription {
    Class<?> c;
    public TestClassDescription(Class<?> c){
        this.c = c;
    }

    public List<Method> listTestMethods(){
        List<Method> list = new ArrayList(List.of(c.getDeclaredMethods()));
        List<Method> correct_list = new ArrayList<>();
        for(Method method:list){
            if(Modifier.isPublic(method.getModifiers())
                    && method.getReturnType().equals(Void.TYPE)
                    && method.isAnnotationPresent(TestMethod.class)
                    && method.getParameterCount()==0){
                correct_list.add(method);
            }

        }
        return correct_list;
    }

}
