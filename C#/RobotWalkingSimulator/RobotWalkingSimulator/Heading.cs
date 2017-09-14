using System;

namespace RobotWalkingSimulator
{
    public struct Heading
    {
        public string CurrentHeading;

        public string AsString()
        {
            return CurrentHeading;
        }

        public void TurnRight()
        {
            switch (CurrentHeading)
            {
                case "NORTH":
                    CurrentHeading = "EAST";
                    break;
                case "EAST":
                    CurrentHeading = "SOUTH";
                    break;
                case "SOUTH":
                    CurrentHeading = "WEST";
                    break;
                case "WEST":
                    CurrentHeading = "NORTH";
                    break;
                default:
                    CurrentHeading = null;
                    break;
            }
        }

        public void TurnLeft()
        {
            switch (CurrentHeading)
            {
                case "NORTH":
                    CurrentHeading = "WEST";
                    break;
                case "EAST":
                    CurrentHeading = "NORTH";
                    break;
                case "SOUTH":
                    CurrentHeading = "EAST";
                    break;
                case "WEST":
                    CurrentHeading = "SOUTH";
                    break;
                default:
                    CurrentHeading = null;
                    break;
            }
        }

        public void NORTH()
        {
            CurrentHeading = "NORTH";
        }
        public void EAST()
        {
            CurrentHeading = "EAST";
        }
        public void SOUTH()
        {
            CurrentHeading = "SOUTH";
        }
        public void WEST()
        {
            CurrentHeading = "WEST";
        }
    }
}
