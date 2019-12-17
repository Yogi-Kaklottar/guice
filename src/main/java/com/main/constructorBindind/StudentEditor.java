package com.main.constructorBindind;

import com.google.inject.Inject;

public class StudentEditor {
		private Student student;
		
		@Inject
		public StudentEditor(Student student) {
			super();
			this.student = student;
		}

		void PrintStudent()
		{
			
			System.out.println("printdata call");
			student.display();
		}
}
