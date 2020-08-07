package frc.robot.subsystems.drivetrain;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Ports;
import frc.robot.subsystems.UnitModel;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Drivetrain extends SubsystemBase {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    TalonFX motorLeftFront = new TalonFX(Ports.Drivetrain.MOTOR_LEFT_FRONT);
    TalonFX motorLeftBack = new TalonFX(Ports.Drivetrain.MOTOR_LEFT_BACK);
    TalonFX motorRightFront = new TalonFX(Ports.Drivetrain.MOTOR_RIGHT_FRONT);
    TalonFX motorRightBack = new TalonFX(Ports.Drivetrain.MOTOR_RIGHT_BACK);
    UnitModel unitModel = new UnitModel(Constants.Drivetrain.TICKS_TO_METER);


    public Drivetrain(){
        motorLeftBack.follow(motorLeftFront);
        motorRightBack.follow(motorRightFront);

        motorLeftFront.setInverted(Ports.Drivetrain.LEFT_INVERTED);
        motorLeftBack.setInverted(Ports.Drivetrain.LEFT_INVERTED);

        motorRightFront.setInverted(Ports.Drivetrain.RIGHT_INVERTED);
        motorRightBack.setInverted(Ports.Drivetrain.RIGHT_INVERTED);

    }

    @Override
    public void periodic() {

    }
}