/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rhhs.frc.subsystems;

import edu.rhhs.frc.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author bselle
 */
public class FloorIntake extends PneumaticSubsystemTwoValve {
    
    private Victor m_motorController;
    
    public FloorIntake() {
        super();
        try {
            m_motorController = new Victor(RobotMap.FLOOR_INTAKE_DSC_SLOT_ID, RobotMap.FLOOR_INTAKE_DSC_PWM_ID);
            
            m_solenoidExtend = new Solenoid(RobotMap.FLOOR_INTAKE_EXTEND_PNEUMATIC_RELAY_ID);
            m_solenoidRetract = new Solenoid(RobotMap.FLOOR_INTAKE_RETRACT_PNEUMATIC_RELAY_ID);
        } catch (Exception e) {
            System.out.println("Unknown error initializing floor intake.  Message = " + e.getMessage());
        }
    }
    
    public void setRollerSpeed(double speed) {
        m_motorController.set(speed);
    }
            
    public void stopRoller() {
        m_motorController.stopMotor();
    }
            
    /*
     * This function is called to update the SmartBoard display
     */
    public void updateStatus() {
//        SmartDashboard.putString("Floor Intake Position", m_position);
    }
}
