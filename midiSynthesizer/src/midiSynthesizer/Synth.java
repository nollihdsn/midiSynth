package midiSynthesizer;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class Synth {
	private static int note;
	//private static int velocity = 100;
	public Synth(Note n){
		note=n.getNoteValue();
	}
	public static void play(int note, int channel, int time, int velocity){
		try{

			Synthesizer midiSynth = MidiSystem.getSynthesizer(); 
			midiSynth.open();
			//get and load default instrument and channel lists
			Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
			MidiChannel[] mChannels = midiSynth.getChannels();
			midiSynth.loadInstrument(instr[0]);//load an instrument
			
			mChannels[channel].noteOn(note, velocity);//On channel 4, play note i with velocity
			try { Thread.sleep(time); // wait time in milliseconds to control duration
			} catch( InterruptedException e ) { }
			mChannels[channel].noteOff(note);//turn of the note
		} catch (MidiUnavailableException e) {}
	}
}
