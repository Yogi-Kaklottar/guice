package com.main.inbuiltBiding;

import java.util.logging.Logger;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class InbuiltBindinds {
	public static void main(String[] args)
	{
	   Injector injector=Guice.createInjector(new DemoModule());
	   Demodata demodata=injector.getInstance(Demodata.class);
	   demodata.display();
	}
}
class Demodata{
	private Logger l;

	@Inject
	public Demodata(Logger l) {
		super();
		this.l = l;
	}

	public void display()
	{
		l.info("login Information");
	}	
}
class DemoModule extends AbstractModule{
	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		super.configure();
	}
}