package src.dcnr;

//import com.sun.speech.freetts.Voice;
//import com.sun.speech.freetts.VoiceManager;

//public class TextToSpeech {
//    private final Voice voice;
//
//    public TextToSpeech() {
//        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
//
//        voice = VoiceManager.getInstance().getVoice("kevin16");
//        if (voice != null) {
//            voice.setRate(150); // Adjust speech rate for clarity (e.g., 150 is slower)
//            voice.setPitch(120); // Adjust pitch for better quality (e.g., 120 is typical)
//            voice.setVolume(3.0F); // Adjust volume for better audibility (e.g., 3.0 is louder)
//            voice.allocate();
//        }
//    }
//
//    public void speakWord(String text) {
//        if (voice != null) {
//            voice.speak(text);
//        }
//    }
//}
