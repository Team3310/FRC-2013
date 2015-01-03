/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rhhs.frc.commands;

/**
 *
 * @author bselle
 */
public class ShooterIntakeSetRearRollerSpeed extends CommandBase {
    
    private double m_motorSpeed;
    
    public ShooterIntakeSetRearRollerSpeed(double motorSpeed) {
        m_motorSpeed = motorSpeed;
        requires(getShooterIntake());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("Start rear roller = " + m_motorSpeed);
        if (m_motorSpeed != 0.0) {
            getShooterIntake().setRearRollerSpeed(m_motorSpeed);
        }
        else {
            getShooterIntake().stopRearRoller();
        }
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
