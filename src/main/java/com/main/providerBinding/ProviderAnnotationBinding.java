package com.main.providerBinding;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provides;

public class ProviderAnnotationBinding {
		public static void main(String[] args)
		{
			Injector injector=Guice.createInjector(new Stdata());
			TextData textdata=injector.getInstance(TextData.class);
			textdata.printsdata();
		}
}
interface data{
	void display();
}
class Student implements data{
	private int no;
	private String name;
	private double per;
	
	@Inject
	public Student(int no, String name, double per) {
		super();
		this.no = no;
		this.name = name;
		this.per = per;
	}


	public void display() {
		System.out.println("Student [no=" + no + ", name=" + name + ", per=" + per + "]");
	}

}

class Stdata extends AbstractModule
{
	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		super.configure();
	}
	@Provides
	public Student providedata()
	{
		
		int n=10;
		String name="rahul";
		double per=70.20;		
		Student s=new Student(n,name,per);
		return s;
		
	}	
}

class TextData {

	private Student p;
   
	@Inject
	public TextData(Student p) {
		super();
		this.p = p;
	}
	public void printsdata()
	{
		p.display();
	}
	
}
