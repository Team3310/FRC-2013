package edu.rhhs.frc.commands;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Command;
import edu.rhhs.frc.RobotMap;
import edu.rhhs.frc.subsystems.Blocker;
import edu.rhhs.frc.subsystems.Chassis;
import edu.rhhs.frc.subsystems.Climb10PtHanger;
import edu.rhhs.frc.subsystems.ClimbArm;
import edu.rhhs.frc.subsystems.ClimbFoot;
import edu.rhhs.frc.subsystems.ClimbWinch;
import edu.rhhs.frc.subsystems.FloorIntake;
import edu.rhhs.frc.subsystems.LEDLights;
import edu.rhhs.frc.subsystems.ShooterIntake;
import edu.rhhs.frc.subsystems.ShooterKicker;
import edu.rhhs.frc.subsystems.ShooterLoader;
import edu.rhhs.frc.subsystems.ShooterPitchAngle;
import edu.rhhs.frc.subsystems.ShooterPitchSelector;
import edu.rhhs.frc.subsystems.ShooterWheelRPM;
import edu.rhhs.frc.subsystems.Transmission;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    // Create a single static instance of all of your subsystems
    private static Blocker m_blocker;
    private static Chassis m_chassis;
    private static ClimbArm m_climbArm;
    private static Climb10PtHanger m_climb10PtHanger;
    private static ClimbFoot m_climbFoot;
    private static ClimbWinch m_climbWinch;
    private static FloorIntake m_floorIntake;
    private static LEDLights m_ledLights;
    private static ShooterIntake m_shooterIntake;
    private static ShooterKicker m_shooterKicker;
    private static ShooterLoader m_shooterLoader;
    private static ShooterPitchAngle m_shooterPitchAngle;
    private static ShooterPitchSelector m_shooterPitchSelector;
    private static ShooterWheelRPM m_shooterWheel;
    private static Transmission m_transmission;
    
    public static Compressor m_compressor = new Compressor(
            RobotMap.COMPRESSOR_SWITCH_DSC_SLOT_ID, RobotMap.COMPRESSOR_SWITCH_DSC_DIO_ID, 
            RobotMap.COMPRESSOR_DSC_SLOT_ID, RobotMap.COMPRESSOR_DSC_RELAY_ID);

    public static void init() {
        m_compressor.start();
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
    
    public static Blocker getBlocker() {
        if (m_blocker == null) {
            m_blocker = new Blocker();
        }
        return m_blocker;
    }
    
    public static Chassis getChassis() {
        if (m_chassis == null) {
            m_chassis = new Chassis();
        }
        return m_chassis;
    }
    
    public static ClimbArm getClimbArm() {
        if (m_climbArm == null) {
            m_climbArm = new ClimbArm();
        }
        return m_climbArm;
    }

    public static ClimbFoot getClimbFoot() {
        if (m_climbFoot == null) {
            m_climbFoot = new ClimbFoot();
        }
        return m_climbFoot;
    }

    public static Climb10PtHanger getClimb10PtHanger() {
        if (m_climb10PtHanger == null) {
            m_climb10PtHanger = new Climb10PtHanger();
        }
        return m_climb10PtHanger;
    }

    public static ClimbWinch getClimbWinch() {
        if (m_climbWinch == null) {
            m_climbWinch = new ClimbWinch();
        }
        return m_climbWinch;
    }

    public static FloorIntake getFloorIntake() {
        if (m_floorIntake == null) {
            m_floorIntake = new FloorIntake();
        }
        return m_floorIntake;
    }

    public static LEDLights getLEDLights() {
        if (m_ledLights == null) {
            m_ledLights = new LEDLights();
        }
        return m_ledLights;
    }
    
    public static ShooterIntake getShooterIntake() {
        if (m_shooterIntake == null) {
            m_shooterIntake = new ShooterIntake();
        }
        return m_shooterIntake;
    }
    
    public static ShooterKicker getShooterKicker() {
        if (m_shooterKicker == null) {
            m_shooterKicker = new ShooterKicker();
        }
        return m_shooterKicker;
    }
    
    public static ShooterLoader getShooterLoader() {
        if (m_shooterLoader == null) {
            m_shooterLoader = new ShooterLoader();
        }
        return m_shooterLoader;
    }
    
    public static ShooterPitchAngle getShooterPitchAngle() {
        if (m_shooterPitchAngle == null) {
            m_shooterPitchAngle = new ShooterPitchAngle();
        }
        return m_shooterPitchAngle;
    }
    
    public static ShooterPitchSelector getShooterPitchSelector() {
        if (m_shooterPitchSelector == null) {
            m_shooterPitchSelector = new ShooterPitchSelector();
        }
        return m_shooterPitchSelector;
    }
    
    public static ShooterWheelRPM getShooterWheel() {
        if (m_shooterWheel == null) {
            m_shooterWheel = new ShooterWheelRPM();
        }
        return m_shooterWheel;
    }
    
    public static Transmission getTransmission() {
        if (m_transmission == null) {
            m_transmission = new Transmission();
        }
        return m_transmission;
    }
}
