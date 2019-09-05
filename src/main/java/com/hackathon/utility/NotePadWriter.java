package com.hackathon.utility;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class NotePadWriter {

	public static void writeNotePad(String str)
	{
		FileWriter fr;
		try {
			fr = new FileWriter("C:\\Users\\sanchari.b\\Pictures\\Sanchari\\3rdSept\\writer.txt");
		
		BufferedWriter br=new BufferedWriter(fr);
       br.write(str);
	
		br.newLine();
		br.write("");

		//br.close();
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
