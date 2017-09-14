using System;

namespace RobotWalkingSimulator
{
    class Controller
    {
        private const Int32 startX = 7;
        private const Int32 startY = 3;
        static private Location location;
        

        public Controller()
        {
            location = new Location(startX, startY);
        }

        public void MoveRobot (string instruction)
        {
            foreach(char currentInstruction in instruction)
            {
                switch (currentInstruction)
                {
                    case 'R':
                        location.heading.TurnRight();
                        break;
                    case 'L':
                        location.heading.TurnLeft();
                        break;
                    case 'A':
                        Advance();
                        break;
                }
            }
        }

        private void Advance()
        {
            switch (location.heading.AsString())
            {
                case "NORTH":
                    location.MoveUp();
                    break;
                case "EAST":
                    location.MoveRight();
                    break;
                case "SOUTH":
                    location.MoveDown();
                    break;
                case "WEST":
                    location.MoveLeft();
                    break;
            }
        }

        public Location GetLocation()
        {
            return location;
        }
    }
}
