/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rhhs.frc.subsystems;

import edu.rhhs.frc.RobotMap;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author bselle
 */
public class ShooterPitchSelector extends Subsystem {

    // Constants for preset positions 
    public static final double SHOOTER_SELECTOR_ANGLE_CENTER = 60.0; 
    public static final double SHOOTER_SELECTOR_ANGLE_CORNER = 15.0; 
    private static final double ANGLE_TOLERANCE = 2.0;
    
    private Servo m_servo;
    private double m_setAngleDeg = 0;
    
    public ShooterPitchSelector() {
        m_servo = new Servo(RobotMap.SHOOTER_PITCH_SELECTOR_DSC_SLOT_ID, RobotMap.SHOOTER_PITCH_SELECTOR_DSC_PWM_ID);
    }

    public void initDefaultCommand() {
    }
    
    public void setSelectorAngle(double degrees) {
        m_setAngleDeg = degrees;
        m_servo.setAngle(degrees);
    }
    
    public double getSelectorAngle() {
        return m_servo.getAngle();
    }
    
    public boolean isAtSetAngle() {
        if (Math.abs(m_setAngleDeg - m_servo.getAngle()) < ANGLE_TOLERANCE) {
            return true;
        }
        return false;
    }
}
