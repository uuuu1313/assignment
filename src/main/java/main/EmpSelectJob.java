package main;

import config.AppCtx;
import models.emp.Emp;
import models.emp.EmpDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class EmpSelectJob {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
        EmpDao empDao = ctx.getBean(EmpDao.class);


        Emp emp = empDao.get(7369);
        System.out.println(emp);


        ctx.close();
    }
}
