package edu.rhhs.frc.subsystems;

import edu.rhhs.frc.RobotMap;
import edu.rhhs.frc.commands.ClimbWinchRotateWithJoystick;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author rhhs
 */
public class ClimbWinch extends PotentiometerPIDSubsystem {
    
    // Constants for preset positions 
    public static final double RETRACTED = 360;
    public static final double EXTENDED = 3240;
    
    // PID Constants
    private final static double kP = 2.0;
    private final static double kI = 0.0;
    private final static double kD = 0.0;
    
    public ClimbWinch() {
        super(kP, kI, kD);
        try {
            NUM_POTENTIOMETER_TURNS = 10;
            POTENTIOMETER_TO_DEVICE_GEAR_RATIO = 1.0;  // Potentiometer installed on the climb arm shaft
            MIN_DEVICE_ANGLE_SOFT_LIMIT = RETRACTED; 
            MAX_DEVICE_ANGLE_SOFT_LIMIT = EXTENDED;
            DEFAULT_POTENTIOMETER_ZERO_POSITION_VOLTS = 0.0;
            m_motorController = new Victor(RobotMap.CLIMB_WINCH_DSC_SLOT_ID, RobotMap.CLIMB_WINCH_DSC_PWM_ID);
            m_potentiometer = new AnalogChannel(RobotMap.CLIMB_WINCH_POTENTIOMETER_ANALOG_BREAKOUT_PORT);
            
            setSoftLimitOn(true);
            initPotentiometerPID();
        } 
        catch (Exception e) {
            System.out.println("Unknown error initializing climb arm.  Message = " + e.getMessage());
        }
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new ClimbWinchRotateWithJoystick()); // set default command   
    }

    /*
     * This function is called to update the SmartBoard display
     */
    public void updateStatus() {
        SmartDashboard.putNumber("Climb Winch Pot Volts", m_potentiometer.getVoltage());
        SmartDashboard.putNumber("Climb Winch Position", getDeviceAngle());
    }
}
