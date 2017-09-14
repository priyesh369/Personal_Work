using System;

namespace RobotWalkingSimulator
{
    class UI
    {
        static readonly Controller Controller = new Controller();
        static string inputString;

        static void Main(string[] args)
        {
            Intro();
            inputString = Console.ReadLine();
            PerformTurn();
            NormalRun();
        }

        private static void NormalRun()
        {
            bool replay = true;
            do
            {
                Console.WriteLine("Do you want to move again? y/n");
                String check = Console.ReadLine();
                if (check == "N" || check == "n")
                {
                    replay = false;
                    Console.WriteLine("Okay, thanks for playing. press any key to exit :)");
                    Console.ReadKey();
                }
                else
                {
                    Console.WriteLine("enter your next instruction: ");
                    inputString = Console.ReadLine();
                    PerformTurn();
                }

            } while (replay == true);
        }

        private static void PerformTurn()
        {
            Location robotAt = Controller.GetLocation();
            Console.WriteLine("Robot starting at: {" + robotAt.x + "," + robotAt.y + "}, facing "
                             + robotAt.heading.AsString() + ".\n running instruction...\n\n");
            Controller.MoveRobot(inputString);
            robotAt = Controller.GetLocation();
            Console.WriteLine("Robot now at: {" + robotAt.x + "," + robotAt.y + "}, facing "
                             + robotAt.heading.AsString() + ".\n\n");
        }

        private static void Intro()
        {
            Console.WriteLine("===Welcome to Benderama - the robot walking simulator===");
            Console.WriteLine("your controls are case insensitive and are as follows: ");
            Console.WriteLine("A - Advance One Space in current heading");
            Console.WriteLine("R - Turn right by 90 degrees");
            Console.WriteLine("L - Turn left by 90 degrees");
            Console.WriteLine("input your instruction as a single line,eg: AARLA");
            Console.WriteLine("Let's begin, enter your first instruction: ");
        }
    }
}
