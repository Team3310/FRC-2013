/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rhhs.frc.commands;

/**
 * @author rhhs
 */
public class ChassisMove extends CommandBase {
    
    private double m_distanceIn;
    private double m_maxSpeed;
    private boolean m_reset;
    
    public ChassisMove(double distanceIn, double maxSpeed, boolean reset) {
        m_distanceIn = distanceIn;
        m_maxSpeed = maxSpeed;
        m_reset = reset;
        requires(getChassis()); // reserve the chassis subsystem
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        getChassis().setDistance(m_distanceIn, m_maxSpeed);
        if (m_reset == true) {
            getChassis().startPID();
        }
        else {
            getChassis().startNoResetPID();
        }
        //        System.out.println("Time = " + System.currentTimeMillis() + "Chassis move start for distance = " + m_distanceIn);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return getChassis().atSetPoint();
    }

    // Called once after isFinished returns true
    protected void end() {
        getChassis().disable();
//        System.out.println("Time = " + System.currentTimeMillis() + ", Chassis move end for distance = " + m_distanceIn);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
