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
public class ShooterKicker extends PneumaticSubsystemTwoValve {

    public ShooterKicker() {
        super();
        try {
            m_solenoidExtend = new Solenoid(RobotMap.SHOOTER_KICKER_EXTEND_PNEUMATIC_RELAY_ID);
            m_solenoidRetract = new Solenoid(RobotMap.SHOOTER_KICKER_RETRACT_PNEUMATIC_RELAY_ID);
        } catch (Exception e) {
            System.out.println("Unknown error initializing shooter kicker.  Message = " + e.getMessage());
        }
    }
            
    /*
     * This function is called to update the SmartBoard display
     */
    public void updateStatus() {
//        SmartDashboard.putString("Shooter Kicker Position", m_position);
    }
}
