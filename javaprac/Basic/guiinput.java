import java.util.*;
import javax.swing.*;

public class guiinput{
	public static void main(String[] args){
		//Scanner in = new Scanner(System.in);
		/*
		int count = 1;
		for(int i = 0; i < args.length; i++){
			JOptionPane.showMessageDialog(null, count + " args = " +  args[i]);	
			count++;
		}
		*/
		
		String degree, batch, section, id;
		
		degree = JOptionPane.showInputDialog("Enter your degree : ");
		batch = JOptionPane.showInputDialog("Enter your batch : ");
		section = JOptionPane.showInputDialog("Enter your section : ");
		id = JOptionPane.showInputDialog("Enter your id : ");
		
		JOptionPane.showMessageDialog(null, "Your Roll No : " + degree+batch+section+id);
	}
}
