/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rhhs.frc.commands;

/**
 * @author rhhs
 */
public class BlockerMove extends CommandBase {
    
    private double m_speed;
    private double m_distance;
    
    public BlockerMove(double speed, double distance) {
        m_speed = speed;
        m_distance = distance;
        requires(getBlocker()); // reserve the chassis subsystem
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("Blocker move " + m_speed);
        getBlocker().stop();
        if (m_speed != 0) {
            getBlocker().setSpeed(m_speed);
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (m_distance < 0) {
            return true;
        }
        if (m_speed > 0) {
            if (getBlocker().getDistance() > m_distance) {
                return true;
            }
        }
        else if (m_speed < 0) {
            if (getBlocker().getDistance() < m_distance) {
                return true;
            }            
        }
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        if (m_distance > 0) {
            getBlocker().setSpeed(0);
        }
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
