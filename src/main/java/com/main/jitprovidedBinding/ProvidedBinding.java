package com.main.jitprovidedBinding;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.ProvidedBy;
import com.google.inject.Provider;

public class ProvidedBinding {
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new StudModul());
		StudEditor studEditor = injector.getInstance(StudEditor.class);
		studEditor.printData();
	}
}

@ProvidedBy(StudentProvider.class)
interface data {
	void display();
}

class Student implements data {

	String name;
	int no;
	double persantage;
    @Inject
	public Student(String name, int no, double persantage) {
		//super();
		this.name = name;
		this.no = no;
		this.persantage = persantage;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("name=" + name + "  roll no:" + no + "   persantage:" + persantage);
	}

}

class StudentProvider implements Provider<data> {
	@Override
	public data get() {
		// TODO Auto-generated method stub

		data d = new Student("ravi", 2, 70.25);
		return d;
	}
}

class StudModul extends AbstractModule {
	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		super.configure();
	}

}

class StudEditor {
	private StudentProvider s;

	@Inject
	public StudEditor(StudentProvider s) {
		super();
		this.s = s;
	}

	public void printData() {
		s.get().display();
	}

}