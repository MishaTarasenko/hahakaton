package lol1;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class ComposeTune {

        private MidiChannel[] channels = null;
        private Synthesizer synth = null;

        public ComposeTune() {
            try {
                synth = MidiSystem.getSynthesizer();
                synth.open();
                channels = synth.getChannels();
                channels[0].programChange(41);
            } catch (MidiUnavailableException ex) {
                Logger.getLogger(ComposeTune.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public void close() {
            synth.close();
        }

        public void playSound(int channel, int duration, int volume, int... notes) {
            for (int note : notes) {
                channels[channel].noteOn(note, volume);
            }
            try {
                Thread.sleep(duration);
            } catch (InterruptedException ex) {
                Logger.getLogger(ComposeTune.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (int note : notes) {
                channels[channel].noteOff(note);
            }
        }
    public static void main(String[] args) {
        int notes[][] = {{470, 81}, {230, 80}, {470, 81}, {250, -1}, {230, 80}, {470, 81}, {230, 69}, {230, 76}, {470, 81}, {230, 69}, {470, 74}, {470, 73}, {470, 74}, {470, 76}, {470, 73}, {470, 71}, {970, -1}, {230, 69}, {230, 68}, {470, 69}, {730, -1}, {230, 64}, {230, 69}, {230, 71}, {470, 73}, {970, -1}, {230, 73}, {230, 74}, {470, 76}, {730, -1}, {230, 69}, {230, 74}, {230, 73}, {470, 71}, {1450, -1}, {470, 81}, {230, 80}, {470, 81}, {250, -1}, {230, 80}, {470, 81}, {230, 69}, {230, 76}, {470, 81}, {230, 69}, {470, 74}, {470, 73}, {470, 74}, {470, 76}, {470, 73}, {470, 71}, {970, -1}, {230, 69}, {230, 68}, {470, 69}, {730, -1}, {230, 64}, {230, 69}, {230, 71}, {470, 73}, {970, -1}, {230, 73}, {230, 74}, {470, 76}, {730, -1}, {230, 69}, {230, 74}, {230, 73}, {470, 71}, {250, -1}};
        ComposeTune composeTune = new ComposeTune();
        for (int[] note : notes) {
            if (note[1] != -1) {
                composeTune.playSound(0, note[0], 80, note[1]);
            } else {
                try {
                    Thread.sleep(note[0]);
                } catch (InterruptedException ex) {
                    //Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        composeTune.close();
    }
}
