 package edu.rhhs.frc.subsystems;

import edu.rhhs.frc.RobotMap;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author rhhs
 */
public class ShooterPitchAngleComp extends PotentiometerPIDSubsystem {
    
    // Constants for preset positions 
    public static final double FLOOR_INTAKE_LOAD = 38.0;
    public static final double FEEDER_STATION_LOAD = -7.0; // competition 6.0;
    public static final double SHOOT_PYRAMID_FRONT = 26.0;
    public static final double SHOOT_PYRAMID_BACK = 25.0;
    public static final double SHOOT_MAX_ANGLE = 40.0;
    
    // PID Constants
    private final static double kP = -5.5;   // - for comp robot
    private final static double kI = -0.02;  // - for comp robot
    private final static double kD = 0.0;
    
    private DigitalInput m_limitSwitch;
    
    public ShooterPitchAngleComp() {
        super(kP, kI, kD);
        try {
            m_limitSwitch = new DigitalInput(RobotMap.SHOOTER_PITCH_LIMIT_SWITCH_DSC_SLOT_ID, RobotMap.SHOOTER_PITCH_LIMIT_SWITCH_DSC_DIO_ID);
            POTENTIOMETER_TO_DEVICE_GEAR_RATIO = -1.0;  // 1.0 competition
            MIN_DEVICE_ANGLE_SOFT_LIMIT = FLOOR_INTAKE_LOAD; 
            MAX_DEVICE_ANGLE_SOFT_LIMIT = SHOOT_MAX_ANGLE;
            DEFAULT_POTENTIOMETER_ZERO_POSITION_VOLTS = 2.10;   // 1.98 pratice robot
            m_motorController = new Victor(RobotMap.SHOOTER_PITCH_DSC_SLOT_ID, RobotMap.SHOOTER_PITCH_DSC_PWM_ID);
            m_potentiometer = new AnalogChannel(RobotMap.SHOOTER_PITCH_POTENTIOMETER_ANALOG_BREAKOUT_PORT);
 
            setSoftLimitOn(false);
            initPotentiometerPID();
        } 
        catch (Exception e) {
            System.out.println("Unknown error initializing shooter pitch angle.  Message = " + e.getMessage());
        }
    }
    
    public boolean isLimitSwitchClosed() {
        return !m_limitSwitch.get();
    }
    
    /*
     * This function is called to update the SmartBoard display
     */
    public void updateStatus() {
        SmartDashboard.putNumber("Shooter Pitch Pot Volts", m_potentiometer.getVoltage());
        SmartDashboard.putNumber("Shooter Pitch Position", getDeviceAngle());
        SmartDashboard.putNumber("Shooter Pitch Zero Position", getDeviceZeroPositionOffsetDeg());
        SmartDashboard.putBoolean("Shooter Pitch Limit Switch Closed", isLimitSwitchClosed());
    }
}
