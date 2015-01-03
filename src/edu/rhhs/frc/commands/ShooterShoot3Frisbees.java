package edu.rhhs.frc.commands;

import edu.rhhs.frc.subsystems.PneumaticSubsystem;
import edu.rhhs.frc.subsystems.ShooterWheelRPM;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author rhhs
 */
public class ShooterShoot3Frisbees extends CommandGroup {
    
    public ShooterShoot3Frisbees() {
        addSequential(new ShooterKickerShootOne());
        addSequential(new ShooterLoaderSwish());
        addSequential(new WaitTimer(ShooterWheelRPM.SHOOTER_WHEEL_DELAY_BETWEEN_SHOTS_SEC));
        addSequential(new ShooterKickerShootOne());
//        addParallel(new ChassisMove(8.0, 0.8)); 
        addSequential(new ShooterLoaderSetPosition(PneumaticSubsystem.EXTEND));
        addSequential(new ShooterIntakeTimedRollers(0.5, 0.1));
        addSequential(new ShooterIntakeTimedRearRoller(1.0, 0.6));
        addSequential(new ShooterLoaderSetPosition(PneumaticSubsystem.RETRACT));
        addSequential(new ShooterIntakeTimedRollers(0.9, 0.5));
        addParallel(new ShooterIntakeTimedRollers(1.0, 1.0));
        addSequential(new ShooterKickerShootOne());
    }
    
    
}

