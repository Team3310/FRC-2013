package edu.rhhs.frc.commands;

import edu.rhhs.frc.subsystems.ShooterIntake;
import edu.rhhs.frc.subsystems.ShooterWheelRPM;
import edu.rhhs.frc.subsystems.Transmission;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * @author rhhs
 */
public class ShooterShoot5to7FrisbeesAutonomous extends CommandGroup {
    
    public static final double DISTANCE_5_FRISBEES_IN = 50;
    public static final double DISTANCE_7_FRISBEES_IN = 120;
    
    public ShooterShoot5to7FrisbeesAutonomous(double distance) {     
        addParallel(new ShooterPitchSetToShoot(-0.8));
        addParallel(new TransmissionShift(Transmission.LO_GEAR));
        addSequential(new ShooterWheelSetRPM(ShooterWheelRPM.SHOOTER_WHEEL_RPM_REAR_PYRAMID));
        addSequential(new ShooterShoot3Frisbees());
//        addSequential(new WaitCommand(0.05));  // Make sure last Frisbee clears shooter
//        addSequential(new ChassisMove(-8.0, 0.8)); 
        addSequential(new FloorIntakeExtendAndLowerAuton());
        addParallel(new ShooterIntakeLoad4FrisbeesAuton(ShooterIntake.SHOOTER_INTAKE_LOAD_SPEED_AUTON));
        
        // Pyramid is 94" wide
        // Front of pyramid to wall is 122"
        // Back of pyramid to wall is 216".    
        // Robot w/ intake is 48" 
        // Back of robot is 6" behind back of pyramid
        // Front of intake to wall is 174"
        // Second set of Frisbees is 78" from wall
        // Front of intake to second set of Frisbees is 96" 
        addSequential(new ChassisMove(distance, 0.8, true));  

        if (distance == DISTANCE_5_FRISBEES_IN) {
            addSequential(new FloorIntakeRaiseAndRetract());
            addSequential(new ChassisMove(-distance, 0.8, true)); 
        }
        else {
            addParallel(new FloorIntakeRaiseAndRetract());
            addSequential(new ChassisMove(-(distance-6.0), 1.0, true)); 
        }
            
        addSequential(new ShooterIntakeEject(0));  // Cancel intake loading
        addSequential(new ShooterPitchSetToShoot(-1.0));
        addSequential(new WaitCommand(0.05));  // Make sure things are settled out
        addSequential(new ShooterShoot4Frisbees());
    }
}

