package midiSynthesizer;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
public class IsKeyPressedFull {
	public static void main(String[] argv) throws Exception {
		JTextField textField = new JTextField();
		textField.addKeyListener(new MKeyListener());
		JFrame jframe = new JFrame();
		jframe.add(textField);
		jframe.setSize(400, 350);
		jframe.setVisible(true);
	}
}
class MKeyListener extends KeyAdapter {
	@Override
	public void keyPressed(KeyEvent event) {
		char ch = event.getKeyChar();
		System.out.println(ch);
		int octave = 60;
		char[] keyboardNotes = {'a','s','d','f','g','h','j','k','l', ';','\'','w','e','r','t','y','u','i','o','p','[',']'};
		String[] notes = {"C-","D-","E-","F-","G-","A-","B-","C-","D-","E-","F-","C#","D#","E#","F#","G#","A#","B#","C#","D#","E#","F#"};
		int index = Song.indexOf(keyboardNotes, ch);//find index of the key pressed
		if (index>6&&index<11||index>17){
			octave+=12;
		}
		char noteName=notes[index].charAt(0);//assign not value based on index of key pressed
		char sign = notes[index].charAt(1);
		Note note = new Note(noteName, sign, octave);
		System.out.print(note.getNoteValue());
		int velocity = 100;
		int time = 10;
		int channel = 4;
		Synth.play(note.getNoteValue(), channel, time, velocity);
		/*if (event.getKeyCode() == KeyEvent.VK_HOME) {
			System.out.println("Key codes: " + event.getKeyCode());
		}*/
	}
	
	static int indexOf(String[] notes, String c) throws IllegalArgumentException {
		for (int i=0; i<=notes.length-1; i++){
			if (notes[i]==(c)){
				return i;
			}
		}
		throw new IllegalArgumentException();
	}
}