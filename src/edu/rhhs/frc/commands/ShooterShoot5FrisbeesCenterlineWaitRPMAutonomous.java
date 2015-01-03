package edu.rhhs.frc.commands;

import edu.rhhs.frc.subsystems.ShooterIntake;
import edu.rhhs.frc.subsystems.ShooterPitchSelector;
import edu.rhhs.frc.subsystems.Transmission;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * @author rhhs
 */
public class ShooterShoot5FrisbeesCenterlineWaitRPMAutonomous extends CommandGroup {
    
    public ShooterShoot5FrisbeesCenterlineWaitRPMAutonomous(boolean isRightSide) {     
        addSequential(new ShooterSetShootPosition(ShooterPitchSelector.SHOOTER_SELECTOR_ANGLE_CORNER));
        addParallel(new TransmissionShift(Transmission.LO_GEAR));
        addSequential(new ShooterShoot3FrisbeesWaitRPM());
        addParallel(new FloorIntakeExtendAndLowerAuton());
        addSequential(new ChassisMove(-90, 1.0, true));  
        if (isRightSide) {
            addSequential(new ChassisTurn(-77, 0.7, 0));  
        }
        else {
            addSequential(new ChassisTurn(77, 0.7, 0));  
        }
        addSequential(new WaitCommand(0.2));
        addParallel(new ShooterIntakeLoad4FrisbeesAuton(ShooterIntake.SHOOTER_INTAKE_LOAD_SPEED_AUTON));
        addSequential(new ChassisMove(90, 0.7, true));  
        addParallel(new FloorIntakeRaiseAndRetract());

        if (isRightSide) {
            addSequential(new ChassisTurn(98, 0.7, 0));  
        }
        else {
            addSequential(new ChassisTurn(-98, 0.7, 0));  
        }
            
        addSequential(new ChassisMove(105, 0.80, true));  
        addSequential(new ShooterIntakeEject(0));  // Cancel intake loading
        addSequential(new ShooterPitchSetToShoot(-1.0));
        addSequential(new WaitCommand(0.05));  // Make sure things are settled out
        addSequential(new ShooterShoot4FrisbeesWaitRPM());
    }
}

