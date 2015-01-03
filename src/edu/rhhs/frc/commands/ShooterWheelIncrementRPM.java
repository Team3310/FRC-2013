package edu.rhhs.frc.commands;

/**
 * @author rhhs
 */
public class ShooterWheelIncrementRPM extends CommandBase {
    
    private double m_incrementRPM;
    
    public ShooterWheelIncrementRPM(double incrementRPM) {
        m_incrementRPM = incrementRPM;
        requires(getShooterWheel()); 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        getShooterWheel().incrementRPM(m_incrementRPM);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
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
