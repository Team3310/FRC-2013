/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rhhs.frc.commands;

/**
 *
 * @author bselle
 */
public class ShooterIntakeEject extends CommandBase {
    
    private double m_motorSpeed;
    
    public ShooterIntakeEject(double motorSpeed) {
        m_motorSpeed = motorSpeed;
        requires(getShooterIntake());
        requires(getFloorIntake());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if (m_motorSpeed != 0.0) {
            getShooterIntake().setFrontRollerSpeed(m_motorSpeed);
            getShooterIntake().setRearRollerSpeed(m_motorSpeed);
            getFloorIntake().setRollerSpeed(m_motorSpeed);
        }
        else {
            getShooterIntake().stopFrontRoller();
            getShooterIntake().stopRearRoller();
            getFloorIntake().stopRoller();
        }
//        System.out.println("Time = " + System.currentTimeMillis()/1000 + ", Shooter Intake Eject");
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
        getShooterIntake().stopFrontRoller();
        getShooterIntake().stopRearRoller();
        getFloorIntake().stopRoller();
    }
}
