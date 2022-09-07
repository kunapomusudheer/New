package com.rmgyantra.genericLibrary;

import java.util.Random;

public class JavaUtility {
public int random() {
	Random r=new Random();
	int getRnumber = r.nextInt(100);
	return getRnumber;
}
}
