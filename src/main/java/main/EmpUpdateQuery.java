package main;

import config.AppCtx;
import models.emp.Emp;
import models.emp.EmpDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class EmpUpdateQuery {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
        EmpDao empDao = ctx.getBean(EmpDao.class);

        Scanner sc = new Scanner(System.in);
        System.out.println("수정할 대상 ENAME 입력 :");
        String Ename = sc.next();
        System.out.println("수정할 값 JOB 입력 :");
        String Job = sc.next();

        Emp emp = new Emp();
        emp.setENAME(Ename);
        emp.setJOB(Job);

        empDao.updateEmpJob(emp);


        ctx.close();

    }

}
