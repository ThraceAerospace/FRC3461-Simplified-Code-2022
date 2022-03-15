// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final class DriveTrain{
        public static final int LEFT_TOP_PORT = 0,
                             LEFT_BOTTOM_PORT = 1,
                               RIGHT_TOP_PORT = 3,
                            RIGHT_BOTTOM_PORT = 4;
    }

    public static final class Shooter{
        public static final int HOOD_PORT = 15,
                              TURRET_PORT = 10;
    }

    public static final class Tower{
        public static final int ARMS_PORT = 11,
                          TRAVERSIAL_PORT = 7,
                          GATEKEEPER_PORT = 8;
    }

    public static final class Climber {
        public static final int MIDDLE_WINCH_TOP_PORT = 16,
                             MIDDLE_WINCH_BOTTOM_PORT = 17,
                                             ARM_PORT = 18;
    }

}
