/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rhhs.frc.subsystems;

import edu.wpi.first.wpilibj.Solenoid;

/**
 *
 * @author bselle
 */
public abstract class PneumaticSubsystemOneValve extends PneumaticSubsystem {

    protected Solenoid m_solenoidExtend; 
    
    public PneumaticSubsystemOneValve() {
        super();
    }
        
    public void initDefaultCommand() {
    }
    
    public void extend() {
        m_solenoidExtend.set(true);
        m_position = EXTENDED;
    }
    
    public void retract() {
        m_solenoidExtend.set(false);
        m_position = RETRACTED;
    }
}
