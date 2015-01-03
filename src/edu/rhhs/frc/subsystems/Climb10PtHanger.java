/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rhhs.frc.subsystems;

import edu.rhhs.frc.RobotMap;
import edu.wpi.first.wpilibj.Relay;

/**
 *
 * @author bselle
 */
public class Climb10PtHanger extends PneumaticSubsystem {

    private Relay m_relayRetract;
    private Relay m_relayExtend;
    
    public Climb10PtHanger() {
        try {
            m_relayRetract = new Relay(RobotMap.CLIMB_10PT_HANGER_RETRACT_PNEUMATIC_VALVE_DSC_SLOT_ID, RobotMap.CLIMB_10PT_HANGER_RETRACT_PNEUMATIC_VALVE_DSC_RELAY_ID);
            m_relayExtend = new Relay(RobotMap.CLIMB_10PT_HANGER_EXTEND_PNEUMATIC_VALVE_DSC_SLOT_ID, RobotMap.CLIMB_10PT_HANGER_EXTEND_PNEUMATIC_VALVE_DSC_RELAY_ID);
       } catch (Exception e) {
            System.out.println("Unknown error initializing climb foot.  Message = " + e.getMessage());
        }
    }
        
    public void extend() {
        m_relayRetract.set(Relay.Value.kOff);
        m_relayExtend.set(Relay.Value.kForward);
        m_position = EXTENDED;
    }
    
    public void retract() {
        m_relayRetract.set(Relay.Value.kForward);
        m_relayExtend.set(Relay.Value.kOff);
        m_position = RETRACTED;
    }
    
        /*
     * This function is called to update the SmartBoard display
     */
    public void updateStatus() {
//        SmartDashboard.putString("Climb 10pt Hangar Position", m_position);
    }
}
