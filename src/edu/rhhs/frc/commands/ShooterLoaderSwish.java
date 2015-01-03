/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rhhs.frc.commands;

import edu.rhhs.frc.subsystems.PneumaticSubsystem;

/**
 *
 * @author bselle
 */
public class ShooterLoaderSwish extends CommandBase {
    
    private static final double WAIT_TIMEOUT = 0.3; 
    
    public ShooterLoaderSwish() {
        requires(getShooterLoader());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        getShooterLoader().setPosition(PneumaticSubsystem.EXTEND);
        setTimeout(WAIT_TIMEOUT);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {  
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        getShooterLoader().setPosition(PneumaticSubsystem.RETRACT);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        getShooterLoader().setPosition(PneumaticSubsystem.RETRACT);
    }
}
