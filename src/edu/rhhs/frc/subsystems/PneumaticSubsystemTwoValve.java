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
public abstract class PneumaticSubsystemTwoValve extends PneumaticSubsystem {

    protected Solenoid m_solenoidExtend; 
    protected Solenoid m_solenoidRetract; 
    
    public PneumaticSubsystemTwoValve() {
        super();
    }
        
    public void initDefaultCommand() {
    }
    
    public void extend() {
        m_solenoidExtend.set(true);
        m_solenoidRetract.set(false);
        m_position = EXTENDED;
    }
    
    public void retract() {
        m_solenoidExtend.set(false);
        m_solenoidRetract.set(true);
        m_position = RETRACTED;
    }
}
