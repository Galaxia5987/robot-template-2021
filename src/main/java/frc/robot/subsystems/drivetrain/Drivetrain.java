package frc.robot.subsystems.drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
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


    public Drivetrain() {
        motorLeftBack.follow(motorLeftFront);
        motorRightBack.follow(motorRightFront);

        motorLeftFront.setInverted(Ports.Drivetrain.LEFT_INVERTED);
        motorLeftBack.setInverted(Ports.Drivetrain.LEFT_INVERTED);

        motorRightFront.setInverted(Ports.Drivetrain.RIGHT_INVERTED);
        motorRightBack.setInverted(Ports.Drivetrain.RIGHT_INVERTED);

        motorLeftFront.config_kP(0, Constants.Drivetrain.PIDF[0]);
        motorLeftFront.config_kI(0, Constants.Drivetrain.PIDF[1]);
        motorLeftFront.config_kD(0, Constants.Drivetrain.PIDF[2]);
        motorLeftFront.config_kF(0, Constants.Drivetrain.PIDF[3]);

        motorRightFront.config_kP(0, Constants.Drivetrain.PIDF[0]);
        motorRightFront.config_kI(0, Constants.Drivetrain.PIDF[1]);
        motorRightFront.config_kD(0, Constants.Drivetrain.PIDF[2]);
        motorRightFront.config_kF(0, Constants.Drivetrain.PIDF[3]);
    }


    /**
     * This method returns the distance that the left side of the robot did.
     *
     * @return distance of the left side. [m]
     */
    public double getLeftDistance() {
        return unitModel.toUnits(motorLeftFront.getSelectedSensorPosition());
    }

    /**
     * This method returns the distance that the right side of the robot did.
     *
     * @return distance of the right side. [m]
     */
    public double getRightDistance() {
        return unitModel.toUnits(motorRightFront.getSelectedSensorPosition());
    }

    /**
     * Move the drivetrain certain distance.
     *
     * @param distance the distance that the robot drive. [m]
     */
    public void setLeftDistance(double distance) {
        motorLeftFront.set(ControlMode.Position, unitModel.toTicks(distance));
    }

    /**
     * Move the drivetrain certain distance.
     *
     * @param distance the distance that the robot drive. [m]
     */
    public void setRightDistance(double distance) {
        motorRightFront.set(ControlMode.Position, unitModel.toTicks(distance));
    }

    /**
     * This method gives power to the motors.
     *
     * @param leftInput  the power to give to the left motor. [-1:1]
     * @param rightInput the power to give to the right motor. [-1:1]
     */
    public void setPower(double leftInput, double rightInput) {
        motorLeftFront.set(ControlMode.PercentOutput, leftInput);
        motorRightFront.set(ControlMode.PercentOutput, rightInput);
    }


    @Override
    public void periodic() {

    }
}