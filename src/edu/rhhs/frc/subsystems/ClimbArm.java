package edu.rhhs.frc.subsystems;

import edu.rhhs.frc.RobotMap;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author rhhs
 */
public class ClimbArm extends PotentiometerPIDSubsystem {
    
    // Constants for preset positions 
    public static final double RETRACTED = 0;
    public static final double START_CLIMB_LEVEL_1 = 45;
    public static final double START_CLIMB_LEVEL_2_AND_3 = 100;
    public static final double APPROACH_LEVEL_1 = 65;
    public static final double APPROACH_LEVEL_2_AND_3 = 75;
    public static final double AVOID_TOP_RUNG_LEVEL_3 = 65;
    
    // PID Constants
    private final static double kP = 2.0;
    private final static double kI = 0.0;
    private final static double kD = 0.0;
    
    public ClimbArm() {
        super(kP, kI, kD);
        try {
            POTENTIOMETER_TO_DEVICE_GEAR_RATIO = 1.0;  // Potentiometer installed on the climb arm shaft
            MIN_DEVICE_ANGLE_SOFT_LIMIT = RETRACTED; 
            MAX_DEVICE_ANGLE_SOFT_LIMIT = START_CLIMB_LEVEL_2_AND_3;
            DEFAULT_POTENTIOMETER_ZERO_POSITION_VOLTS = 0.1;
            m_motorController = new Victor(RobotMap.CLIMB_ARM_DSC_SLOT_ID, RobotMap.CLIMB_ARM_DSC_PWM_ID);
            m_potentiometer = new AnalogChannel(RobotMap.CLIMB_ARM_POTENTIOMETER_ANALOG_BREAKOUT_PORT);
 
            setSoftLimitOn(false);
            initPotentiometerPID();
        } 
        catch (Exception e) {
            System.out.println("Unknown error initializing climb arm.  Message = " + e.getMessage());
        }
    }
    
    /*
     * This function is called to update the SmartBoard display
     */
    public void updateStatus() {
        SmartDashboard.putNumber("Climb Arm Pot Volts", m_potentiometer.getVoltage());
        SmartDashboard.putNumber("Climb Arm Position", getDeviceAngle());
    }
}
