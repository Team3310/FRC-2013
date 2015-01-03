package edu.rhhs.frc.commands;

import edu.rhhs.frc.subsystems.ShooterPitchAngle;
import edu.rhhs.frc.subsystems.ShooterWheelRPM;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * @author rhhs
 */
public class ShooterShoot4FrisbeesHalfCourtWaitRPM extends CommandGroup {
    
    public ShooterShoot4FrisbeesHalfCourtWaitRPM() {
        addSequential(new ShooterIntakeClearJam());
        addSequential(new ShooterShoot3FrisbeesHalfCourtWaitRPM());
        addSequential(new ShooterLoaderSwish());
        addSequential(new ShooterWheelSetRPM(ShooterWheelRPM.SHOOTER_WHEEL_RPM_REAR_PYRAMID));
        addSequential(new ShooterSetShootPositionRelative(ShooterPitchAngle.SHOOT_HALF_COURT_RELATIVE_ANGLE));
        addSequential(new WaitTimer(ShooterWheelRPM.SHOOTER_WHEEL_DELAY_BETWEEN_SHOTS_SEC));
        addSequential(new ShooterKickerShootOne());
        addSequential(new WaitCommand(0.1));  // Make sure last Frisbee clears shooter
        addSequential(new ShooterWheelSetRPM(0));
    }
}

