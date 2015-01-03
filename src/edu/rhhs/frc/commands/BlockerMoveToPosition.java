/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rhhs.frc.commands;

/**
 * @author rhhs
 */
public class BlockerMoveToPosition extends CommandBase {
    
    private double m_distanceIn;
    private double m_maxSpeed;
    
    public BlockerMoveToPosition(double distanceIn, double maxSpeed) {
        m_distanceIn = distanceIn;
        m_maxSpeed = maxSpeed;
        requires(getBlocker()); // reserve the chassis subsystem
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        getBlocker().setDistance(m_distanceIn, m_maxSpeed);
        getBlocker().startPID();
        System.out.println("Time = " + System.currentTimeMillis() + "Blocker move start for distance = " + m_distanceIn);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return getBlocker().atSetPoint();
    }

    // Called once after isFinished returns true
    protected void end() {
        getBlocker().disable();
        System.out.println("Time = " + System.currentTimeMillis() + ", Bloker move end for distance = " + m_distanceIn);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
