/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rhhs.frc.commands;

import edu.rhhs.frc.subsystems.PneumaticSubsystem;
import edu.rhhs.frc.subsystems.ShooterWheelRPM;

/**
 *
 * @author bselle
 */
public class ShooterIntakeLoad4Frisbees extends ExtraTwoTimeoutCommandBase {
    
    private double m_motorSpeed;
    private boolean m_limitSwitchClosed = false;
    private static final double TOTAL_TIMEOUT = 10.0;   
    private static final double FRONT_ROLLER_TIMEOUT = 0.1;   
    private static final double REVERSE_ROLLER_TIMEOUT = 0.6;   
    
    public ShooterIntakeLoad4Frisbees(double motorSpeed) {
        m_motorSpeed = motorSpeed;
        requires(getShooterIntake());
        requires(getShooterLoader());
        requires(getShooterWheel());
   }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(TOTAL_TIMEOUT);
        m_extraTimeout1 = -1;
        m_extraTimeout2 = -1;
//        System.out.println("Frisbee count = " + getShooterIntake().getFrisbeeCount());
        m_limitSwitchClosed = getShooterIntake().isCountLimitSwitchClosed();
        if (m_motorSpeed != 0.0 && getShooterIntake().getFrisbeeCount() < 2) {
            getShooterIntake().setFrontRollerSpeed(m_motorSpeed);
            getShooterIntake().setRearRollerSpeed(m_motorSpeed);
        }
        if (m_motorSpeed != 0.0 && getShooterIntake().getFrisbeeCount() ==  0) {
            getShooterLoader().setPosition(PneumaticSubsystem.EXTEND);
            getShooterIntake().resetOpticalLoaderSwitchCount();
        }
        getLEDLights().setIncrementShootColor(getShooterIntake().getFrisbeeCount());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (getShooterIntake().getOpticalLoaderSwitchCount() > 0) {
            getShooterLoader().setPosition(PneumaticSubsystem.RETRACT);
            System.out.println("Loader Retract, Optical count = " + getShooterIntake().getOpticalLoaderSwitchCount());
        }
            
        // Limit switch changes from open to closed
        if (m_limitSwitchClosed == false && getShooterIntake().isCountLimitSwitchClosed() == true) {
            m_limitSwitchClosed = true;
            getShooterIntake().incrementFrisbeeCount(1);
            getLEDLights().setIncrementShootColor(getShooterIntake().getFrisbeeCount());
            System.out.println("Limit switch closed");
            System.out.println("Frisbee count = " + getShooterIntake().getFrisbeeCount());
            if (getShooterIntake().getFrisbeeCount() == 2) {
                startExtraTimeout1(FRONT_ROLLER_TIMEOUT);
                getShooterIntake().setRearRollerSpeed(-0.4);
                getShooterIntake().setFrontRollerSpeed(0.5);
            }
            else if (getShooterIntake().getFrisbeeCount() == 3) {
                getShooterIntake().incrementFrisbeeCount(1);   // add one for the fourth frisbee
//                getShooterIntake().stopFrontRoller();
//                getShooterIntake().stopRearRoller();
 //               System.out.println("Stop Roller");
                getShooterIntake().setRearRollerSpeed(-0.4);
                startExtraTimeout2(REVERSE_ROLLER_TIMEOUT);
           }
        }
        
        // Limit switch changes from closed to open
        else if (m_limitSwitchClosed == true && getShooterIntake().isCountLimitSwitchClosed() == false) {
            m_limitSwitchClosed = false;
//            System.out.println("Limit switch open");
        }
        
        if (isExtraTimedOut1()) {
            System.out.println("First timeout 1");
            getShooterIntake().setFrontRollerSpeed(m_motorSpeed);
            getShooterIntake().setRearRollerSpeed(m_motorSpeed);
        }
              
//        return isExtraTimedOut2() || isTimedOut();
        return isExtraTimedOut2();
    }

    // Called once after isFinished returns true
    protected void end() {
//        System.out.println("Second timeout 2");
        getShooterIntake().stopFrontRoller();
        getShooterIntake().stopRearRoller();
        if (getShooterIntake().getFrisbeeCount() == 3) {
            getShooterIntake().incrementFrisbeeCount(1);
        }
        getLEDLights().setIncrementShootColor(getShooterIntake().getFrisbeeCount());

        getShooterWheel().setRPM(ShooterWheelRPM.SHOOTER_WHEEL_RPM_REAR_PYRAMID);
        if (getShooterWheel().isEnabled() == false) {
            getShooterWheel().startPID();
        }
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
