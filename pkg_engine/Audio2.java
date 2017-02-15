package pkg_engine;

import  java.io.*;
import javax.sound.sampled.*;
import java.net.URL;

public  class Audio2{

    //Want to credit me? Elliot B. N-No? Delete this comment then meanie.

    private static AudioInputStream audioStream = null;
    private static DataLine.Info info;
    private static Clip clip;
    private static AudioFormat format;
    private static File file;

    public void stop(){
        clip.stop();
    }

    public void playLoop(String s){
        file = new File(s);
        try {
            audioStream = AudioSystem.getAudioInputStream(file);
            format = audioStream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }

        try{
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void play(String s){
        file = new File(s);
        try {
            audioStream = AudioSystem.getAudioInputStream(file);
            format = audioStream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }

        try{
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

}