/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rhhs.frc.commands;

/**
 *
 * @author bselle
 */
public class ShooterLoaderSetPosition extends CommandBase {
    
    private int m_position;
    
    public ShooterLoaderSetPosition(int position) {
        m_position = position;
        requires(getShooterLoader());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        getShooterLoader().setPosition(m_position);
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
