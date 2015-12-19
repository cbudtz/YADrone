package dtu.cdio.tutorial.programs;

import dtu.cdio.tutorial.listeners.DroneListener;

/**
 * 
 * @author Runi
 * Program used for executing programs in new thread from gui.
 */
public interface Program extends Runnable, DroneListener {

}
