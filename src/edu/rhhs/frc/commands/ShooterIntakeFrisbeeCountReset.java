/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rhhs.frc.commands;

/**
 *
 * @author bselle
 */
public class ShooterIntakeFrisbeeCountReset extends CommandBase {
    
    public ShooterIntakeFrisbeeCountReset() {
        requires(getShooterIntake());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        getShooterIntake().resetFrisbeeCount();
        getLEDLights().setIncrementShootColor(getShooterIntake().getFrisbeeCount());
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
    }
}
