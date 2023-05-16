package main;

import config.AppCtx;
import models.emp.Emp;
import models.emp.EmpDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class EmpDeleteEmpno {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
        EmpDao empDao = ctx.getBean(EmpDao.class);

        Scanner sc = new Scanner(System.in);

        System.out.println("삭제 할 EMPNO 입력 :");
        int empNo = sc.nextInt();

        empDao.deleteEmpNo(empNo);


        ctx.close();

    }
}
