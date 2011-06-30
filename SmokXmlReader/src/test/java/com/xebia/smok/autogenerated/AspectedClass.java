package com.xebia.smok.autogenerated;

import org.springframework.beans.DirectFieldAccessor;

import com.xebia.smok.SmokContainer;
import com.xebia.smok.SmokContext;
import com.xebia.smok.aspect.RecordingAspected;

public class AspectedClass {
	public int add(int no1, int no2) {
		System.out.println("Doing addition");
		return no1 + no2;
	}

	public void sub(int firstNo, int secondNo) {
		System.out.println("Doing substraction");
	}

	public void print() {
		System.out.println("In print");
	}

	public static void main(String[] args) {
		SmokContext smokContext = SmokContainer.getSmokContext();
		DirectFieldAccessor dfa = new DirectFieldAccessor(
				SmokContainer.getSmokContext());
		dfa.setPropertyValue("recordingDirectory", "c:\\sandy\\recording\\test");

		AspectedClass aspected = new AspectedClass();
		aspected.add(13, 25);
		aspected.sub(13, 25);
		aspected.print();
	}
}
