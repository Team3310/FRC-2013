/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rhhs.frc.subsystems;

import edu.rhhs.frc.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;

/**
 *
 * @author bselle
 */
public class Transmission extends PneumaticSubsystemTwoValve {

    public static final int HI_GEAR = 0;
    public static final int LO_GEAR = 1;
    
    public Transmission() {
        super();
        try {
            m_solenoidExtend = new Solenoid(RobotMap.SHIFT_EXTEND_PNEUMATIC_RELAY_ID);
            m_solenoidRetract = new Solenoid(RobotMap.SHIFT_RETRACT_PNEUMATIC_RELAY_ID);
        } catch (Exception e) {
            System.out.println("Unknown error initializing transmission.  Message = " + e.getMessage());
        }
    }
        
    public void shift(int gearPosition) {
        if (gearPosition == HI_GEAR) {
            retract();
        }
        else if (gearPosition == LO_GEAR) {
            extend();
        }
    }
}
