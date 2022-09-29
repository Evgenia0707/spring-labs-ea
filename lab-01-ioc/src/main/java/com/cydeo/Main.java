package com.cydeo;
import com.cydeo.account.Current;
import com.cydeo.account.Saving;
import com.cydeo.config.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(Config.class);

        Saving saving = container.getBean(Saving.class);
        Current current = container.getBean(Current.class);

        System.out.println(Arrays.toString(container.getBeanDefinitionNames()));


        saving.initialize();
        current.initialize();
    }
}
