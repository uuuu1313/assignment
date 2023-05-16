package main;

import config.AppCtx;
import models.emp.Emp;
import models.emp.EmpDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class EmpInsertQuery {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
        EmpDao empDao = ctx.getBean(EmpDao.class);

        Scanner sc = new Scanner(System.in);
        System.out.println("추가할 이름 입력 : ");
        String Ename = sc.next();
        System.out.println("추가할 직업 입력 : ");
        String Job = sc.next();

        Emp emp = new Emp();
        emp.setENAME(Ename);
        emp.setJOB(Job);

        long EMPNO = empDao.insertEmp(emp);
        System.out.println("EMPNO : " + EMPNO + ", ENAME : " + Ename + ", JOB : " + Job);

        ctx.close();
    }
}
