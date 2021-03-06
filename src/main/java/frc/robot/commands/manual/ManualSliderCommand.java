package frc.robot.commands.manual;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotSettings;
import frc.robot.helper.Direction;

public class ManualSliderCommand extends Command {

    private Direction direction = Direction.UP;

    /**
     * requires(Subsystem subsystem) is crucial where any other Command (including instances) 
     * with the same subsystem requirement will call {@link Command#interrupted()} on the last command.
     */
    public ManualSliderCommand(Direction direction) {
        requires(Robot.slider);
        this.direction = direction; //Bips was here too :)
    }

    /**
     * Execute based on the passed Direction object from OI.
     */
    @Override
    protected void execute() {
        switch(direction) {
            case UP:
                Robot.slider.raise();
                break;
            case DOWN:
                Robot.slider.lower();
                break;
                
            default:
                Robot.slider.lower();
        }
    }

    /**
     * If the robot slider is moving up, #isFinished() will be dependent on the limit switch.
     * If the robot slider is moving down, it will default to false and will stop with button release.
     * 
     * @return If the command should be cancelled or not -- calls {@link Command#interrupted()}
     */
    @Override
    protected boolean isFinished() {
        if (RobotSettings.LIMIT_SWITCH_ON != 0.0) {
            boolean limit = Robot.slider.getLimitSwitch().get();
            switch(direction) {
                case UP:
                    return limit;
                case DOWN:
                    return false;
                default:
                    return limit;
            }
        } else {
            return false;
        }
    }

    @Override
    protected void end() {
       Robot.slider.stopMotor();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
