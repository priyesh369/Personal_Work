using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpaceAge
{
    class SpaceAgeUI
    {
        static SpaceAgeInner controller;

        static void Main(string[] args)
        {
            while (true)
            {
                Console.WriteLine("Enter your age in seconds: ");
                controller = new SpaceAgeInner(Int64.Parse(Console.ReadLine()));
                Console.WriteLine("Enter a planet of your choice in our solar system: ");
                string planet = Console.ReadLine();
                double age = controller.GetAgeOnPlanet(planet);
                if (age == -0)
                {
                    Console.WriteLine("planet not found");
                }
                else
                {
                    Console.WriteLine("You are " + age + " years old on " + planet);
                }
            }
        }
    }
}
        

    
