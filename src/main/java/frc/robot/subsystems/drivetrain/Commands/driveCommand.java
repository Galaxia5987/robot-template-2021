package frc.robot.subsystems.drivetrain.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Ports;
import frc.robot.RobotContainer;
import frc.robot.subsystems.drivetrain.Drivetrain;

/**
 *
 */
public class driveCommand extends CommandBase {

    int mode = 1;
    Drivetrain sub;
    double rightInput, leftInput;
    public driveCommand(int mode, Drivetrain sub) {
        this.mode = mode;
        this.sub = sub;
        addRequirements(sub);
    }

    @Override
// Called just before this Command runs the first time
    public void initialize() {

    }

    @Override
// Called repeatedly when this Command is scheduled to run
    public void execute() {

        switch (mode) {
            case 1:
                rightInput = RobotContainer.getRightJoystick();
                leftInput = RobotContainer.getLeftJoystick();
            case 2:
                rightInput = RobotContainer.getYRightXbox();
                leftInput = RobotContainer.getYLeftXbox();
            case 3:
                rightInput = .75 * RobotContainer.getYLeftXbox() + .25 * RobotContainer.getXRightXbox();
                leftInput = .75 * RobotContainer.getYLeftXbox() - .25 * RobotContainer.getXRightXbox();
            case 4:
                rightInput = RobotContainer.getXboxRT();
                leftInput = RobotContainer.getXboxLT();
        }

        sub.setPower(leftInput, rightInput);
    }

    @Override
// Make this return true when this Command no longer needs to run execute()
    public boolean isFinished() {

        return false;

    }

    @Override
// Called once after isFinished returns true
    public void end(boolean interrupted) {

    }
}