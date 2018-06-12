package midiSynthesizer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class KeyboardInput {
	public static String keyPressed="";
	public static final String escapeKey = "w";
	public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
		while (keyPressed!=escapeKey){
			keyPressed = scanner.next();
			if(keyPressed!= null){
				System.out.println("test");
			}
		}
		
	}
}
