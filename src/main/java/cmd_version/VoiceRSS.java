package cmd_version;

import com.voicerss.tts.AudioFormat;
import com.voicerss.tts.VoiceParameters;
import com.voicerss.tts.VoiceProvider;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class VoiceRSS {
    private static final String API_KEY = "ee1a861047db41e3aed6cca75554a826";

    private static final String AUDIO_PATH = "src/main/resources/src/media/audio.wav";


    public static String voiceNameUS;
    public static String voiceNameUK;
    public static String language = "en-gb";
    public static String Name = "Linda";
    public static double speed = 1;

    public VoiceRSS() throws URISyntaxException {
    }

    public static void speakWord(String word) throws Exception {
        VoiceProvider tts = new VoiceProvider(API_KEY);
        VoiceParameters params = new VoiceParameters(word, AudioFormat.Format_44KHZ.AF_44khz_16bit_stereo);
        params.setBase64(false);
        params.setLanguage(language);
        params.setVoice(Name);
        params.setRate((int) Math.round(-2.9936 * speed * speed + 15.2942 * speed - 12.7612));

        byte[] voice = tts.speech(params);

        File audioFile = new File(AUDIO_PATH);
        URI audioURI = audioFile.toURI();

        FileOutputStream fos = new FileOutputStream(AUDIO_PATH);
        fos.write(voice, 0, voice.length);
        fos.flush();
        fos.close();

        Media input = new Media(audioURI.toString());
        MediaPlayer audio = new MediaPlayer(input);
        audio.play();
    }

    public static void main(String[] args) throws Exception {
        speakWord("hi");
    }
}
