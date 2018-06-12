package midiSynthesizer;

import javax.sound.midi.*;
import java.applet.*;
import java.io.FileNotFoundException;

public class MidiTest{
	private static int[] majorScale= {2,2,1,2,2,2,1,1};
	private static int[] minorScale= {2,1,2,2,1,3,1,1};
	private static String[] song1 = {"B","A#","G#","G#","G#","G#"};


	public static void main(String[] args) throws FileNotFoundException { 
		try{
			/* Create a new Sythesizer and open it. Most of 
			 * the methods you will want to use to expand on this 
			 * example can be found in the Java documentation here: 
			 * https://docs.oracle.com/javase/7/docs/api/javax/sound/midi/Synthesizer.html
			 */
			Synthesizer midiSynth = MidiSystem.getSynthesizer(); 
			midiSynth.open();

			//get and load default instrument and channel lists
			Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
			MidiChannel[] mChannels = midiSynth.getChannels();

			midiSynth.loadInstrument(instr[0]);//load an instrument
			//playScale(mChannels, 60, majorScale);
			//playScale(mChannels, 60, minorScale);
			String[] song1 = {"B","A#","G#","G#","G#","G#"};
			Song song = new Song("test-song.txt");
			playSong(mChannels, song, 60);

			//AudioClip ac = getAudioClip(getCodeBase(), "Cricket-sound-effect");
			//ac.play();   //play once
			//ac.stop();   //stop playing
			//ac.loop();   //play continuously

		} catch (MidiUnavailableException e) {}
	}

	public static void playSong(MidiChannel[] mChannels,Song song, int startNote){
		for (int i=0; i<=song1.length-1; i++){
			int note = song.getNote(i);
			int velocity = song.getVelocity(i);
			mChannels[4].noteOn(note, velocity);//On channel 4, play note i with velocity
			try { Thread.sleep(1000); // wait time in milliseconds to control duration
			} catch( InterruptedException e ) { }
			mChannels[4].noteOff(note);//turn of the note
		}
	}


public static void playScale(MidiChannel[] mChannels, int note, int[] Scale){
	for (int i=0; i<=24; i++){
		mChannels[4].noteOn(note, 100);//On channel 0, play note number 60 with velocity 100 
		note+=Scale[i];
		try { Thread.sleep(1000); // wait time in milliseconds to control duration
		} catch( InterruptedException e ) { }
		mChannels[3].noteOff(60);//turn of the note
	}
}



}    
