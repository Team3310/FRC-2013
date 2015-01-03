package edu.rhhs.frc.subsystems;

import edu.rhhs.frc.RobotMap;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author rhhs
 */
public class ShooterWheelRPM extends PIDSubsystem {
    
    public static final double SHOOTER_WHEEL_SPEED_TEST = -0.3;
    public static final double SHOOTER_WHEEL_SPEED_REAR_PYRAMID = -0.6;
    public static final double SHOOTER_WHEEL_RPM_TEST = 1000;
    public static final double SHOOTER_WHEEL_RPM_DEMO = 2500;
    public static final double SHOOTER_WHEEL_RPM_REAR_PYRAMID = 3000; // 2800;
    public static final double SHOOTER_WHEEL_SPOOL_UP_TIME_SEC = 3;
    public static final double SHOOTER_WHEEL_DELAY_BETWEEN_SHOTS_SEC = 0.4; //0.25
    
    // Tolerance, calibration info
    private final static double MAX_RPM = 5000;
    private final static double MAX_ALLOWABLE_ERROR_RPM = 100;
    private final static int    NUM_CYCLES_REQUIRED_AT_SETPOINT = 1;
    
    // PID Constants
    private final static double KP = -0.004; // -0.004  
    private final static double KI = 0.0; // -0.000001;
    private final static double KD = -0.001;  //-0.001
    private final static double KF = -0.0002;  // -0.0002 for 3000 RPM (3000 * -0.0002 = -0.6)
    
    private RPMEncoder m_rpmEncoder; 
    private Victor m_motorController;    
    private double m_rpm = SHOOTER_WHEEL_RPM_DEMO;
    
    private double m_error = 0;
    private double m_percentVBus;
    private boolean m_enabled = false;
//    private double m_pidStartTime = 0;
    
    private int m_atSetPointCycleCount = 0;
    
    public ShooterWheelRPM() {
        super("ShooterRPM", KP, KI, KD, KF);

        try {
            m_motorController = new Victor(RobotMap.SHOOTER_RPM_DSC_SLOT_ID, RobotMap.SHOOTER_RPM_DSC_PWM_ID);
            m_rpmEncoder = new RPMEncoder(
                    RobotMap.SHOOTER_RPM_ENCODER_A_DSC_SLOT_ID, RobotMap.SHOOTER_RPM_ENCODER_A_DSC_DIO_ID, 
                    RobotMap.SHOOTER_RPM_ENCODER_B_DSC_SLOT_ID, RobotMap.SHOOTER_RPM_ENCODER_B_DSC_DIO_ID, true, 360, 5);
            m_motorController.stopMotor();
        } 
        catch (Exception ex) {
            System.out.println("Unknown exception initializing shooter wheel RPM.  Message = " + ex.getMessage());
        } 
        finally {
            this.disable();
        }
    }
    
    public void stop() {
        setMotorSpeed(0);
        this.disable();
        m_enabled = false;
    }
    
    // Methods for PID control to a position
    public void startPID() {
    	m_rpmEncoder.resetMotorRPM();
        this.enable();
        m_enabled = true;
//        m_pidStartTime = System.currentTimeMillis();
    }
    
    public boolean isEnabled() {
        return m_enabled;
    }
    
    public void setRPM(double rpm) {
        if (rpm > MAX_RPM) {
            rpm = MAX_RPM;
        }
        m_rpm = rpm;
        m_atSetPointCycleCount = 0;
        this.setSetpoint(rpm);
    }
    
    public void incrementRPM(double increment) {
        m_rpm += increment;
        setRPM(m_rpm);
    }

    public void setSpeed(double percentVbus) {
        if (isEnabled()) {
            disable();
        }
        m_motorController.set(percentVbus);
        m_percentVBus = percentVbus;
    }

    public boolean atSetPoint() {
        m_error = Math.abs(getPIDController().getSetpoint() - returnPIDInput());
        if (Math.abs(m_error) < MAX_ALLOWABLE_ERROR_RPM) {
            m_atSetPointCycleCount++;
        };
        return m_atSetPointCycleCount >= NUM_CYCLES_REQUIRED_AT_SETPOINT;
    }
    
    protected double returnPIDInput() {
        m_rpmEncoder.updateMotorRPM();
        return m_rpmEncoder.getAveragedRPM();
    }
    
    public double getShooterWheelRPM() {
        return m_rpmEncoder.getAveragedRPM();
    }

    protected void usePIDOutput(double percentVbus) {
        setMotorSpeed(percentVbus);
    }

    private void setMotorSpeed(double percentVbus) {
//        System.out.println("Time = " + (System.currentTimeMillis() - m_pidStartTime)/1000 + ", RPM = " + m_rpmEncoder.getAveragedRPM() + ", Motor = " + percentVbus);
        m_motorController.set(percentVbus);
        m_percentVBus = percentVbus;
    }

    public void initDefaultCommand() {
    }
    
    /*
     * This function is called to update the SmartBoard display
     */
    public void updateStatus() {
        m_rpmEncoder.updateMotorRPM();
        SmartDashboard.putNumber("Shooter Set RPM", m_rpm);
        SmartDashboard.putNumber("Shooter Average RPM Plot", m_rpmEncoder.getAveragedRPM());
        SmartDashboard.putNumber("Shooter Average RPM", m_rpmEncoder.getAveragedRPM());
        SmartDashboard.putNumber("Shooter PercentVBus", m_percentVBus);
    }
}
