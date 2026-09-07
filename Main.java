import javax.sound.sampled.*;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String filePath = "C:\\Users\\hp\\Downloads\\anirudh.wav";

        File file = new File(filePath);

        try(Scanner input = new Scanner(System.in);AudioInputStream audioStream =  AudioSystem.getAudioInputStream(file);){
Clip clip = AudioSystem.getClip();
clip.open(audioStream);



String response = "";
while(!response.equals("Q")){
    System.out.println("P : pause");
    System.out.println("S : start");
    System.out.println("R : reset");
    System.out.println("q : quit");
    System.out.print("Enter your choice: ");
    response = input.nextLine().toUpperCase();

    switch(response){
        case "P" -> clip.stop();
        case "S" -> clip.start();
        case "R" -> clip.setMicrosecondPosition(0);
        case "Q" -> clip.close();
        default -> System.out.println("Wrong choice");
    }
}

        }
        catch(LineUnavailableException e){
            System.out.println("Line Unavailable Exception");
        }
        catch(IOException e){
            System.out.println("something went wrong");
        }
        catch(UnsupportedAudioFileException e){
            System.out.println("audio not found");
        }
    }

}