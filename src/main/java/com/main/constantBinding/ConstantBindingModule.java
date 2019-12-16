package com.main.constantBinding;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

public class ConstantBindingModule {
	
	public static void main(String[] args)
	{
		Injector injector=Guice.createInjector(new UrlModule());
		ConncetionSet con=injector.getInstance(ConncetionSet.class);
		con.printUrl();
	}

}
class ConncetionSet{
	private String url;
	
	@Inject
	public void getUrlString(@Named("uri")String s)
	{
		url=s;
	}
	public void printUrl()
	{
		System.out.println("URL :"+url);
	}
}

class UrlModule extends AbstractModule{
	
	@Override
	protected void configure() {
		// TODO Auto-generated method stub
			bind(String.class).annotatedWith(Names.named("uri")).toInstance("http://localhost/test");
	}
	
}