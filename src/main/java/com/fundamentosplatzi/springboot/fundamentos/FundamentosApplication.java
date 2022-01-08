package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentos.bean2practice.*;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependecy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependecy componentDependecy;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private ToPractice toPractice;
	private MySubtract mySubtract;
	private MySubtractWithDependency mySubtractWithDependency;


	public FundamentosApplication(@Qualifier("componentThreeImplement") ComponentDependecy componentDependecy,
								  MyBean myBean, MyBeanWithDependency myBeanWithDependency,
								  ToPractice toPractice,
								  MySubtractWithDependency mySubtractWithDependency){
		this.componentDependecy = componentDependecy;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.toPractice = toPractice;
		this.mySubtractWithDependency = mySubtractWithDependency;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependecy.saludar();
		myBean.print();
		myBeanWithDependency.printWhitDependency();
		toPractice.message();
		mySubtractWithDependency.printDepdendency();
	}
}
