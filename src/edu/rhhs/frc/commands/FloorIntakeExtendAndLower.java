package edu.rhhs.frc.commands;

import edu.rhhs.frc.subsystems.PneumaticSubsystem;
import edu.rhhs.frc.subsystems.ShooterIntake;
import edu.rhhs.frc.subsystems.ShooterPitchAngle;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author rhhs
 */
public class FloorIntakeExtendAndLower extends CommandGroup {
    
    public FloorIntakeExtendAndLower() {
        addSequential(new ShooterPitchSetToShoot(-1.0));
        addSequential(new FloorIntakeSetPosition(PneumaticSubsystem.EXTEND));
        addSequential(new ShooterPitchSetAngle(ShooterPitchAngle.FLOOR_INTAKE_LOAD));
        addSequential(new FloorIntakeSetRollerSpeed(-1.0));
        addSequential(new ShooterIntakeLoad4FrisbeesFloorLoad(ShooterIntake.SHOOTER_INTAKE_LOAD_SPEED_AUTON));
    }
}

