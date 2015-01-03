package edu.rhhs.frc.commands;

/**
 * @author rhhs
 */
public class ShooterWheelSetDeltaRPM extends CommandBase {
    
    private static double m_currentRPM;
    private double m_deltaRPM;
    
    public ShooterWheelSetDeltaRPM(double deltaRPM) {
        m_deltaRPM = deltaRPM;
        m_currentRPM = 0;
        requires(getShooterWheel()); 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("Shooter RPM Delta = " + m_deltaRPM + ", Current RPM = " + m_currentRPM);
        if (m_deltaRPM == 0) {
            m_currentRPM = 0;
            getShooterWheel().stop();
        }
        else {
            m_currentRPM += m_deltaRPM;
            if (m_currentRPM < 0) {
                m_currentRPM = 0;
            } 
//            getShooterWheel().setRPM(m_currentRPM);
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (m_deltaRPM != 0) {
//            getShooterWheel().updateMotorSpeed();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//        if (m_deltaRPM == 0) {
//            return true;
//        }
//        return getShooterWheel().atSetPoint();
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }
    
    public static void resetRPM() {
        m_currentRPM = 0;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
//        getShooterWheel().stop();
        resetRPM();
    }
}
