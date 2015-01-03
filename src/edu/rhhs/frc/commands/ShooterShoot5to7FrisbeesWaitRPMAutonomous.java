package edu.rhhs.frc.commands;

import edu.rhhs.frc.subsystems.ShooterIntake;
import edu.rhhs.frc.subsystems.Transmission;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * @author rhhs
 */
public class ShooterShoot5to7FrisbeesWaitRPMAutonomous extends CommandGroup {
    
    public static final double DISTANCE_5_FRISBEES_IN = 50;
    public static final double DISTANCE_7_FRISBEES_IN = 155;
    
    public ShooterShoot5to7FrisbeesWaitRPMAutonomous(double distance) {     
        addSequential(new ShooterPitchSetToShoot(-1.0));
        addParallel(new TransmissionShift(Transmission.LO_GEAR));
        addSequential(new ShooterShoot3FrisbeesWaitRPM());
        addSequential(new FloorIntakeExtendAndLowerAuton());
        if (distance == DISTANCE_5_FRISBEES_IN) {
            addSequential(new WaitCommand(0.5));
        }
        else {
            addSequential(new WaitCommand(0.2));
        }
        addParallel(new ShooterIntakeLoad4FrisbeesAuton(ShooterIntake.SHOOTER_INTAKE_LOAD_SPEED_AUTON));
        // Pyramid is 94" wide
        // Front of pyramid to wall is 122"
        // Back of pyramid to wall is 216".    
        // Robot w/ intake is 48" 
        // Back of robot is 6" behind back of pyramid
        // Front of intake to wall is 174"
        // Second set of Frisbees is 78" from wall
        // Front of intake to second set of Frisbees is 96" 

        if (distance == DISTANCE_5_FRISBEES_IN) {
            addSequential(new ChassisMove(distance, 0.4, true));  
            addSequential(new FloorIntakeRaiseAndRetract());
            addSequential(new ChassisMove(-(distance + 4.0), 0.6, true)); 
        }
        else {
            addSequential(new ChassisMove(distance, 0.5, true));  
            addParallel(new FloorIntakeRaiseAndRetractAuton());
            addSequential(new WaitCommand(0.2));
//            addSequential(new ChassisTurn(-7, 0.75, 0));  
            addSequential(new ChassisMove(-(distance + 4.0), 1.0, true)); 
        }
            
        addSequential(new ShooterIntakeEject(0));  // Cancel intake loading
        addSequential(new ShooterPitchSetToShoot(-1.0));
//        addSequential(new WaitCommand(0.05));  // Make sure things are settled out
        if (distance == DISTANCE_5_FRISBEES_IN) {
            addSequential(new WaitCommand(0.7));
        }
        else {
            addSequential(new WaitCommand(0.2));
        }
        addSequential(new ShooterShoot4FrisbeesWaitRPM());
    }
}

