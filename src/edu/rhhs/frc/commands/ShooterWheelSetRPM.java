package edu.rhhs.frc.commands;

/**
 * @author rhhs
 */
public class ShooterWheelSetRPM extends CommandBase {
    
    private double m_absoluteRPM;
    private double m_time;
    
    public ShooterWheelSetRPM(double absoluteRPM) {
        m_absoluteRPM = absoluteRPM;
        requires(getShooterWheel()); 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if (m_absoluteRPM == 0) {
            getShooterWheel().stop();
        }
        else {
            getShooterWheel().setRPM(m_absoluteRPM);
            m_time = System.currentTimeMillis();
            if (getShooterWheel().isEnabled() == false) {
                getShooterWheel().startPID();
            }
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (m_absoluteRPM == 0) {
            return true;
        }
        return getShooterWheel().atSetPoint();
    }

    // Called once after isFinished returns true
    protected void end() {
//        System.out.println("Shooter wheel set RPM = " + m_absoluteRPM + ", Startup time = " + (System.currentTimeMillis() - m_time)/1000.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        getShooterWheel().stop();
    }
}
