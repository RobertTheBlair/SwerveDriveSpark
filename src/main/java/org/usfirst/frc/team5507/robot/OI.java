package org.usfirst.frc.team5507.robot;

import org.usfirst.frc.team5507.robot.commands.AdjustFieldOrientedAngleCommand;
import org.usfirst.frc.team5507.robot.commands.AutoAlign;
import org.usfirst.frc.team5507.robot.commands.CargoIn;
import org.usfirst.frc.team5507.robot.commands.CargoOut;
import org.usfirst.frc.team5507.robot.commands.HatchIn;
import org.usfirst.frc.team5507.robot.commands.HatchOut;
import org.usfirst.frc.team5507.robot.commands.ResetDrivetrainEncoderCommand;
import org.usfirst.frc.team5507.robot.commands.ResetHappy;
import org.usfirst.frc.team5507.robot.commands.StopArm1;
import org.usfirst.frc.team5507.robot.commands.StopArm2;
import org.usfirst.frc.team5507.robot.commands.SwitchLedModes;
import org.usfirst.frc.team5507.robot.commands.ToggleFieldOrientedCommand;
import org.usfirst.frc.team5507.robot.commands.ZeroNavX;
import org.usfirst.frc.team5507.robot.input.DPadButton;
import org.usfirst.frc.team5507.robot.input.IGamepad;
import org.usfirst.frc.team5507.robot.input.XboxGamepad;
import org.usfirst.frc.team5507.robot.subsystems.HolonomicDrivetrain;

import edu.wpi.first.wpilibj.XboxController;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private IGamepad mController = new XboxGamepad(0);
	private IGamepad climbController = new XboxGamepad(1);

	private Robot mRobot;

	public OI(Robot robot) {
		mRobot = robot;
	}

	public void registerControls() { 
		//mController.getAButton().whenPressed(new ResetDrivetrainEncoderCommand(mRobot.getDrivetrain()));
		mController.getAButton().whenPressed(new CargoOut());
		mController.getAButton().whenReleased(new CargoIn());

		mController.getBButton().whenPressed(new HatchOut());
		mController.getBButton().whenReleased(new HatchIn());

		mController.getXButton().whileHeld(new AutoAlign(Robot.targetPos));
		mController.getXButton().whenReleased(new ResetHappy());
		
		mController.getYButton().whenPressed(new ZeroNavX());
		mController.getStartButton().whenPressed(new ToggleFieldOrientedCommand(Robot.swerveDriveSubsystem));



		climbController.getLeftBumperButton().whenPressed(new StopArm1());
		climbController.getRightBumperButton().whenPressed(new StopArm2());
		
		
		//mController.getStartButton().whenPressed(new ToggleFieldOrientedCommand(mRobot.getDrivetrain()));
		//mController.getDPadButton(DPadButton.Direction.LEFT).whenPressed(new AdjustFieldOrientedAngleCommand(mRobot.getDrivetrain(), false));
		//mController.getDPadButton(DPadButton.Direction.RIGHT).whenPressed(new AdjustFieldOrientedAngleCommand(mRobot.getDrivetrain(), true));
		//mController.getXButton().whenPressed(new ClimberLatch());
	}

	public IGamepad getController() {
		return mController;
	}
}
