/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rhhs.frc.commands;

/**
 *
 * @author bselle
 */
public class LEDLightsShow extends CommandBase {
    
    private int r1;
    private int g1;
    private int b1;
    private int r2;
    private int g2;
    private int b2;
    
    public LEDLightsShow(int r1, int g1, int b1, int r2, int g2, int b2) {
        this.r1 = r1;
        this.g1 = g1;
        this.b1 = b1;
        this.r2 = r2;
        this.g2 = g2;
        this.b2 = b2;
        requires(getLEDLights());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        getLEDLights().setColor2(r1, g1, b1, r2, g2, b2);
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
