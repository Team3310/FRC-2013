/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rhhs.frc.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author bselle
 */
public abstract class PneumaticSubsystem extends Subsystem {

    public static final int RETRACT = 0;
    public static final int EXTEND = 1;
    protected static final String RETRACTED = "Retracted";
    protected static final String EXTENDED = "Extended";   

    protected String m_position = RETRACTED;
    
    public PneumaticSubsystem() {
    }
        
    public void initDefaultCommand() {
    }
    
    public abstract void extend();
    public abstract void retract();
    
    public void setPosition(int position) {
        if (position == EXTEND) {
            extend();
        }
        else {
            retract();
        }
    }
}
