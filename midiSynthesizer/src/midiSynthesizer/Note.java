package midiSynthesizer;

public class Note {
	private static char note;
	private static int octave;
	private static char sign;
	private static int signValue = setSignValue();
	
	public Note(char note, char sign, int octave){
		this.setNote(note);
		this.setSign(sign);
		this.setOctave(octave);
	}
	
	public int getNoteValue(){
		char[] notes = {'C','D','E','F','G','A','B'};
		int [] noteNums = {1,3,5,6,8,10,12};
		try { 
			int index = Song.indexOf(notes, note);
			int x = noteNums[index] + octave + signValue;
			System.out.println(x + "is a note");
			return x;
		} catch(Exception e){
			System.out.println("thats not a note");	
			return 0;
		}
	}

	public char getNote() {
		return note;
	}

	public void setNote(char note) {
		Note.note = note;
	}

	public char getSign() {
		return sign;
	}

	public void setSign(char sign) {
		Note.sign = sign;
	}

	public int getOctave() {
		return octave;
	}

	public void setOctave(int octave) {
		Note.octave = octave;
	}

	public int getSignValue() {
		return signValue;
	}
	
	private static int setSignValue(){
		if (sign == '#'){
			return 1;
		}
		else if (sign == 'b'){
			return -1;
		}
		else{
			return 0;
		}
	}
}
