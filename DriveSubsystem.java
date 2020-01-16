package frc.robot.drive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import frc.robot.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {

    private static final TalonFX leftMaster = new TalonFX(Constants.DriveMasterLeft);
    private static final TalonFX leftSlave1 = new TalonFX(Constants.DriveSlaveLeft);
    private static final TalonFX rightMaster = new TalonFX(Constants.DriveMasterRight);
    private static final TalonFX rightSlave1 = new TalonFX(Constants.DriveSlaveRight);

    public DriveSubsystem() {
        // Follows
        leftSlave1.follow(leftMaster);
        rightSlave1.follow(rightMaster);

        // Invert Right
        rightMaster.setInverted(true);
        rightSlave1.setInverted(true);

        // Brake Motors
        leftMaster.setNeutralMode(NeutralMode.Coast);
        rightMaster.setNeutralMode(NeutralMode.Coast);

        // leftMaster.configOpenloopRamp(.25, 0);
        leftMaster.configNeutralDeadband(.175, 0);

        // rightMaster.configOpenloopRamp(.25, 0); 
        rightMaster.configNeutralDeadband(.175, 0);
    }

    public void driveLeft(ControlMode mode, double left) {
        // Left Side DriveTrain
        leftMaster.set(mode, left);
    }
    public void driveRight(ControlMode mode, double right) {
        // Right Side DriveTrain
        rightMaster.set(mode, right);
    }


}