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
public class ShooterLoader extends PneumaticSubsystemTwoValve {
    
    public ShooterLoader() {
        super();
        try {
            m_solenoidExtend = new Solenoid(RobotMap.SHOOTER_LOADER_EXTEND_PNEUMATIC_RELAY_ID);
            m_solenoidRetract = new Solenoid(RobotMap.SHOOTER_LOADER_RETRACT_PNEUMATIC_RELAY_ID);
        } catch (Exception e) {
            System.out.println("Unknown error initializing shooter loader.  Message = " + e.getMessage());
        }
    }
            
    /*
     * This function is called to update the SmartBoard display
     */
    public void updateStatus() {
//        SmartDashboard.putString("Shooter Loader Position", m_position);
    }
}
