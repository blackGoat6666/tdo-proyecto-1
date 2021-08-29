package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Student yo = new Student (130045, "Vera", "Iara", "iaravera3333@gmail.com", "https://github.com/blackGoat6666", null);
            	SimplePresentationScreen a = new SimplePresentationScreen(yo);
            	a.setVisible(true);
            }
        });
    }
}