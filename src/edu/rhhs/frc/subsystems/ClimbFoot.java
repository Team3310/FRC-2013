/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rhhs.frc.subsystems;

import edu.rhhs.frc.RobotMap;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author bselle
 */
public class ClimbFoot extends PneumaticSubsystem {

    private Relay m_relay;
    
    public ClimbFoot() {
        try {
            m_relay = new Relay(RobotMap.CLIMB_FOOT_PNEUMATIC_VALVE_DSC_RELAY_ID, Relay.Direction.kBoth);
            retract();
        } catch (Exception e) {
            System.out.println("Unknown error initializing climb foot.  Message = " + e.getMessage());
        }
    }
        
    public void extend() {
        m_relay.set(Relay.Value.kForward);
        m_position = EXTENDED;
    }
    
    public void retract() {
        m_relay.set(Relay.Value.kReverse);
        m_position = RETRACTED;
    }
    
        /*
     * This function is called to update the SmartBoard display
     */
    public void updateStatus() {
        SmartDashboard.putString("Climb Foot Position", m_position);
    }
}
