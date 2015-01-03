package edu.rhhs.frc.commands;

/**
 * @author rhhs
 */
public class ShooterWheelStartAtSetRPM extends CommandBase {
    
    
    public ShooterWheelStartAtSetRPM() {
        requires(getShooterWheel()); 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        getShooterWheel().incrementRPM(0);
         if (getShooterWheel().isEnabled() == false) {
            getShooterWheel().startPID();
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return getShooterWheel().atSetPoint();
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
