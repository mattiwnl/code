package frc.robot.drive;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.*;

public class driveSplitArcade extends CommandBase  {

    public driveSplitArcade(DriveSubsystem driveSub) {
    }

    @Override
    public void execute() {
        double throttle = RobotContainer.xbox.getRawAxis(1);
        double turn = RobotContainer.xbox.getRawAxis(4);
        RobotContainer.driveSub.driveLeft(ControlMode.PercentOutput, throttle + turn);
        RobotContainer.driveSub.driveRight(ControlMode.PercentOutput, throttle - turn);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}