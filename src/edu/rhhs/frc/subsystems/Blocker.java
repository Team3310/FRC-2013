/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rhhs.frc.subsystems;

import edu.rhhs.frc.RobotMap;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author bselle
 */
public class Blocker extends PIDSubsystem {
   
    public static final double WHEEL_CIRCUM_IN = 8.926;
   
    // PID Constants
    private final static double KP = 0.000; //0.015
    private final static double KI = 0.008; //0.0002
    private final static double KD = 0.00; //0.10
    
    private final static double MAX_ALLOWABLE_ERROR_DISTANCE_IN = 1.0;
    private final static int    NUM_CYCLES_REQUIRED_AT_SETPOINT = 1;

    private double m_error = 0;
    private boolean m_enabled = false;
    private double m_maxSpeed;
    
    private int m_atSetPointCycleCount = 0;

    private RPMEncoder m_encoder;
    private Victor m_motorController;
    
    public Blocker() {
        super(KP, KI, KD);

        try {
            m_motorController = new Victor(RobotMap.BLOCKER_DSC_SLOT_ID, RobotMap.BLOCKER_DSC_PWM_ID);
            m_encoder = new RPMEncoder(
                    RobotMap.BLOCKER_ENCODER_A_DSC_SLOT_ID, RobotMap.BLOCKER_ENCODER_A_DSC_DIO_ID, 
                    RobotMap.BLOCKER_ENCODER_B_DSC_SLOT_ID, RobotMap.BLOCKER_ENCODER_B_DSC_DIO_ID, true, 360, 5);
            m_encoder.setDistancePerPulse(WHEEL_CIRCUM_IN/360);
            m_encoder.resetDistance();
        } catch (Exception e) {
            System.out.println("Unknown error initializing blocker.  Message = " + e.getMessage());
        }
    }

    public void stop() {
        setMoveMotorSpeed(0);
        this.disable();
        m_enabled = false;
    }
    
    public void setSpeed(double speed) {
        m_motorController.set(speed);
    }
    
    public void reset() {
    	m_encoder.resetDistance();
    }
    
    // Methods for PID control to a position
    public void startPID() {
        this.enable();
        m_enabled = true;
    }
    
    public boolean isEnabled() {
        return m_enabled;
    }
    
    public void setDistance(double distance, double maxSpeed) {
        m_maxSpeed = maxSpeed;
        m_atSetPointCycleCount = 0;
        this.setSetpoint(distance);
    }
    
    public boolean atSetPoint() {
        m_error = Math.abs(getPIDController().getSetpoint() - returnPIDInput());
        if (Math.abs(m_error) < MAX_ALLOWABLE_ERROR_DISTANCE_IN) {
            m_atSetPointCycleCount++;
        };
        return m_atSetPointCycleCount >= NUM_CYCLES_REQUIRED_AT_SETPOINT;
    }
    
    protected double returnPIDInput() {
        return m_encoder.getDistance();
    }

    public double getDistance() {
        return m_encoder.getDistance();
    }

    protected void usePIDOutput(double percentVbus) {
        setMoveMotorSpeed(percentVbus);
    }

    private void setMoveMotorSpeed(double percentVbus) {
        limitSpeed(percentVbus, m_maxSpeed);
        m_motorController.set(percentVbus);
        System.out.println("Time = " + System.currentTimeMillis() + ", Distance = " + returnPIDInput() + ", PercentVbus = " + percentVbus);
    }
    
    private double limitSpeed(double percentVbus, double maxSpeed) {
        if (Math.abs(percentVbus) > maxSpeed) {
            if (percentVbus > 0) {
                percentVbus = maxSpeed;
            }
            else {
                percentVbus = -maxSpeed;
            }
        }
        return percentVbus;
    }

    public void initDefaultCommand() {
    }
    
    public void updateStatus() {
        try {
            SmartDashboard.putNumber("Blocker Distance ", returnPIDInput());
        } catch (Exception ex) {
            System.out.println("Error in updateStatus Blocker.  Message = " + ex.getMessage());
        }
    }

}
