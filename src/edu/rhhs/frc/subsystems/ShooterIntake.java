/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rhhs.frc.subsystems;

import edu.rhhs.frc.RobotMap;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author bselle
 */
public class ShooterIntake extends Subsystem {
    
    public static final double SHOOTER_INTAKE_LOAD_SPEED = 0.7;  //0.7
    public static final double SHOOTER_INTAKE_LOAD_SPEED_AUTON = 1.0;
    public static final double SHOOTER_INTAKE_UNLOAD_TO_SHOOT_SPEED = 0.7;
    public static final double SHOOTER_INTAKE_UNLOAD_TO_SHOOT_NEXT_SEC = 1.0;

    private Victor m_frontMotorController;
    private Victor m_rearMotorController;
    private DigitalInput m_limitSwitch;
//    private DigitalInput m_opticalSwitch;
    private Counter m_opticalCounter;
    private int m_frisbeeCount = 0;
    
    public ShooterIntake() {
        super();
        try {
            m_frontMotorController = new Victor(RobotMap.SHOOTER_INTAKE_FRONT_DSC_SLOT_ID, RobotMap.SHOOTER_INTAKE_FRONT_DSC_PWM_ID);
            m_rearMotorController = new Victor(RobotMap.SHOOTER_INTAKE_REAR_DSC_SLOT_ID, RobotMap.SHOOTER_INTAKE_REAR_DSC_PWM_ID);
            m_limitSwitch = new DigitalInput(RobotMap.FRISBEE_COUNT_SWITCH_DSC_SLOT_ID, RobotMap.FRISBEE_COUNT_SWITCH_DSC_DIO_ID);
//            m_opticalSwitch = new DigitalInput(2, 10);
            m_opticalCounter = new Counter(RobotMap.FRISBEE_LOADER_OPTICAL_SWITCH_DSC_SLOT_ID, RobotMap.FRISBEE_LOADER_OPTICAL_SWITCH_DSC_DIO_ID);
            m_opticalCounter.start();
            m_opticalCounter.reset();
        } catch (Exception e) {
            System.out.println("Unknown error initializing shooter intake.  Message = " + e.getMessage());
        }
    }
    
    public void setFrontRollerSpeed(double speed) {
        m_frontMotorController.set(speed);
    }
            
    public void stopFrontRoller() {
        m_frontMotorController.stopMotor();
    }
            
    public void setRearRollerSpeed(double speed) {
        m_rearMotorController.set(speed);
    }
            
    public void stopRearRoller() {
        m_rearMotorController.stopMotor();
    }
            
    public void initDefaultCommand() {
    }
    
    public int getFrisbeeCount() {
        return m_frisbeeCount;
    }
    
    public void setFrisbeeCount(int count) {
        m_frisbeeCount = count;
        SmartDashboard.putNumber("Frisbee Count", getFrisbeeCount());
    }
    
    public void resetFrisbeeCount() {
        m_frisbeeCount = 0  ;
        SmartDashboard.putNumber("Frisbee Count", getFrisbeeCount());
    }
    
    public void incrementFrisbeeCount(int increment) {
        m_frisbeeCount += increment;
        if (m_frisbeeCount < 0) {
            m_frisbeeCount = 0;
        }
        else if (m_frisbeeCount > 4) {
            m_frisbeeCount = 4;
        }
        SmartDashboard.putNumber("Frisbee Count", getFrisbeeCount());
    }
    
    public boolean isCountLimitSwitchClosed() {
        return !m_limitSwitch.get();
    }
    
//    public boolean isOpticalSwitchClosed() {
//        return !m_opticalSwitch.get();
//    }
    
    public void resetOpticalLoaderSwitchCount() {
        m_opticalCounter.reset();
    }
    
    public int getOpticalLoaderSwitchCount() {
        int count = m_opticalCounter.get();
        return count;
    }

    /*
     * This function is called to update the SmartBoard display
     */
    public void updateStatus() {
//        SmartDashboard.putNumber("Shooter Front Intake Speed", m_frontMotorController.getSpeed());
//        SmartDashboard.putNumber("Shooter Rear Intake Speed", m_rearMotorController.getSpeed());
//        SmartDashboard.putBoolean("Shooter Intake Switch Closed", isCountLimitSwitchClosed());
//        SmartDashboard.putBoolean("Shooter Intake Optical Switch Closed", isOpticalSwitchClosed());
        SmartDashboard.putNumber("Shooter Intake Optical Switch Count", getOpticalLoaderSwitchCount());
    }
}
