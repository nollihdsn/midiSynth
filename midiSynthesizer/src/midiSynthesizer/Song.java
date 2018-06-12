package midiSynthesizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Song {
	private static ArrayList<Integer> song =  new ArrayList<Integer>();
	private static ArrayList<Integer> velocity = new ArrayList<Integer>();
	private static int defaultVelocity = 100;
	/*
	 * takes str of note names and converts them to a list of half steps
	 */
	
	public Song(String fileName) throws FileNotFoundException{
		ArrayList<String> songNotes = new ArrayList<String>();
		Scanner s = new Scanner(new File(fileName));
		while (s.hasNext()){
		    songNotes.add(s.next());
		}
		s.close();
		
		newSong(toNoteArr(songNotes));
	}
	
	private ArrayList<Note> toNoteArr(ArrayList<String> songNotes) {
		ArrayList<Note> noteList = new ArrayList<Note>();
		for (String n: songNotes){
			for (int i=0; i<n.length(); i++){
				noteList.add(new Note(n.charAt(0), n.charAt(1), n.charAt(2)));
			}
		}
		return noteList;
		
	}

	public Song(ArrayList<Note> noteList){
		newSong(noteList);
	}
	public void newSong(ArrayList<Note> noteList){
		String note = "  ";
		char[] notes = {'C','D','E','F','G','A','B'};
		int [] noteNums = {1,3,5,6,8,10,12};
		try { 
			for (int i =0; i<=noteList.size()-1; i++){
				int index = indexOf(notes, noteList.get(i).getNote());
				int x = noteNums[index] + (noteList.get(i).getOctave()) + noteList.get(i).getSignValue();
				System.out.println(x);
				song.add(x);
				velocity.add(defaultVelocity);
			}
		} catch(Exception e){
			System.out.println("invalid format please use only capital letters A-G and sharp signs");	
		}
	}

	static int indexOf(char[] notes, char c) throws IllegalArgumentException {
		for (int i=0; i<=notes.length-1; i++){
			if (notes[i]==(c)){
				return i;
			}
		}
		throw new IllegalArgumentException();
	}
	
	public Integer getNote(int i){
		return song.get(i);
	}
	
	public Integer getVelocity(int i){
		return velocity.get(i);
	}
	
	public void set(ArrayList<Integer> song1){
		song = song1;
	}

	public int length() {
		return song.size();
	}
	
}
