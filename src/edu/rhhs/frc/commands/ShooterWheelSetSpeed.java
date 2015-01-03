package edu.rhhs.frc.commands;

/**
 * @author rhhs
 */
public class ShooterWheelSetSpeed extends CommandBase {
    
    private double m_speed;
    
    public ShooterWheelSetSpeed(double speed) {
        m_speed = speed;
        requires(getShooterWheel()); 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        getShooterWheel().disable();
        if (m_speed == 0) {
            getShooterWheel().stop();
        }
        else {
            getShooterWheel().setSpeed(m_speed);
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        getShooterWheel().stop();
    }
}
