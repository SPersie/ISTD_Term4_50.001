//package PS2PartC.piano;
//
//import javax.sound.midi.MidiUnavailableException;
//
//import midi.Instrument;
//import midi.Midi;
//import music.NoteEvent;
//import music.Pitch;
//
//import java.util.ArrayList;
//import java.util.Date;
//
//public class PianoMachine {
//
//	private Midi midi;
//	private Instrument instrument =Instrument.PIANO;
//	private int counter =0;
//	private boolean toggle =false;
//	private ArrayList<NoteEvent> events =new ArrayList();
//
//
//	/**
//	 * constructor for PianoMachine.
//	 *
//	 * initialize midi device and any other state that we're storing.
//	 */
//    public PianoMachine() {
//    	try {
//            midi = Midi.getInstance();
//        } catch (MidiUnavailableException e1) {
//            System.err.println("Could not initialize midi device");
//            e1.printStackTrace();
//            return;
//        }
//    }
//
//    //TODO write method spec
//    public void beginNote(Pitch rawPitch) {
//
//    	//TODO implement for question 1
//        rawPitch =rawPitch.transpose(counter *Pitch.OCTAVE);
//        if (toggle) {
//            NoteEvent event1 =new NoteEvent(rawPitch, (new Date()).getTime(), instrument, NoteEvent.Kind.start);
//            events.add(event1);
//        }
//        midi.beginNote(rawPitch.toMidiFrequency(), instrument);
//    }
//
//    //TODO write method spec
//    public void endNote(Pitch rawPitch) {
//
//    	//TODO implement for question 1
//        rawPitch =rawPitch.transpose(counter *Pitch.OCTAVE);
//        if (toggle) {
//            NoteEvent event2 =new NoteEvent(rawPitch, (new Date()).getTime(), instrument, NoteEvent.Kind.stop);
//            events.add(event2);
//        }
//        midi.endNote(rawPitch.toMidiFrequency(), instrument);
//    }
//
//    //TODO write method spec
//    public void changeInstrument() {
//       	//TODO: implement for question 2
//        instrument =instrument.next();
//    }
//
//    //TODO write method spec
//    public void shiftUp() {
//    	//TODO: implement for question 3
//        if(counter <2) {
//            counter +=1;
//        }
//    }
//
//    //TODO write method spec
//    public void shiftDown() {
//    	//TODO: implement for question 3
//        if(counter >-2) {
//            counter -=1;
//        }
//    }
//
//    //TODO write method spec
//    public boolean toggleRecording() {
//    	if(toggle ==false) {
//    	    toggle =true;
//    	    return true;
//        } else {
//    	    toggle =false;
//    	    return false;
//        }
//    	//TODO: implement for question 4
//    }
//
//    //TODO write method spec
//    public void playback() {
//        //TODO: implement for question 4
//        int len =events.size();
//        for(int i =0; i <len; i ++) {
//            if(events.get(i).getKind() == NoteEvent.Kind.start) {
//                midi.beginNote(events.get(i).getPitch().toMidiFrequency(), instrument);
//                Midi.rest((int) (events.get(i +1).getTime() -  events.get(i).getTime()) /10);
//            } else {
//                midi.endNote(events.get(i).getPitch().toMidiFrequency(), instrument);
//                if(i <len -1) {
//                    Midi.rest((int) (events.get(i + 1).getTime() - events.get(i).getTime()));
//                }
//            }
//        }
//
//    }
//}
