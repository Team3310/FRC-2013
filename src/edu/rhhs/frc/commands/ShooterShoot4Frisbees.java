package edu.rhhs.frc.commands;

import edu.rhhs.frc.subsystems.ShooterWheelRPM;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * @author rhhs
 */
public class ShooterShoot4Frisbees extends CommandGroup {
    
    public ShooterShoot4Frisbees() {
        addSequential(new ShooterIntakeClearJam());
        addSequential(new ShooterShoot3Frisbees());
        addSequential(new ShooterLoaderSwish());
        addSequential(new WaitTimer(ShooterWheelRPM.SHOOTER_WHEEL_DELAY_BETWEEN_SHOTS_SEC));
        addSequential(new ShooterKickerShootOne());
        addSequential(new WaitCommand(0.05));  // Make sure last Frisbee clears shooter
        addSequential(new ShooterWheelSetRPM(0));
    }
}

