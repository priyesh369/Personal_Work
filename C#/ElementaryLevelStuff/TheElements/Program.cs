using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TheElements
{
    class Program
    {
        static void Main(string[] args)
        {
            //HelloWorldFunction();
            //GreetUser();
            //SumToN();
            //SumToN3or5Multiples();
            //PlusOrTimes();
            //MultiplicationTable();
            //PrimeNumbers();
            Guesser();

            if (CheckForReplay())
            {
                Main(args);
            }
            else
            {
                Console.WriteLine("Okay, press any key to exit.");
            }
            Console.ReadKey();

        }

        //returns true false to replay program
        static bool CheckForReplay()
        {
            Console.WriteLine("Play again? enter Y/N");
            String input = Console.ReadLine();
            switch (input)
            {
                case "Y":
                    return true;
                case "y":
                    return true;
                default:
                    return false;
            }
        }

        //Hello World
        static void HelloWorldFunction()
        {
            Console.WriteLine("Hello World");
            Console.WriteLine("Press any key to exit.");
        }

        //Greet User with name Alice or Bob
        static void GreetUser()
        {
            Console.WriteLine("Hi, what's your name?");
            String name = Console.ReadLine();
            switch (name)
            {
                case "Alice":
                    GreetUserInner(name);
                    break;
                case "Bob":
                    GreetUserInner(name);
                    break;
                default:
                    Console.WriteLine("I don't answer to you...");
                    break;
            }

        }

        //prints the greeting to the console, used by greet user
        static private void GreetUserInner(String name)
        {
            Console.WriteLine("Hello " + name + "! \nWelcome to World of Tomorr...C#!");
        }

        //Return sum of numbers for 1 to user inputed n
        static void SumToN()
        {
            Console.WriteLine("Enter a positive number and I'll give you the sum of all numbers to that number:");
            String input = Console.ReadLine();
            if (Int32.TryParse(input, out int n) && n >= 1)
            {
                int output = 0;
                for (int i = 1; i <= n; i++)
                {
                    output = output + i;
                }
                Console.WriteLine("The sum from 1 to " + input + " is: " + output + ". Impressive, isn't it?");
            }
            else
            {
                Console.WriteLine("I can't do anything with that.");
            }

        }

        //write sum of numbers which are multiples of 3 or 5 for 1 to user inputed n
        static void SumToN3or5Multiples()
        {
            Console.WriteLine("Enter a positive number and I'll give you the sum of the multiples of 3 or 5 to that number:");
            String input = Console.ReadLine();
            if (Int32.TryParse(input, out int n) && n >= 1)
            {
                int output = 0;
                for (int i = 1; i <= n; i++)
                {
                    if (i % 3 == 0 || i % 5 == 0)
                    {
                        output = output + i;
                    }
                }
                Console.WriteLine("The sum from 1 to " + input + " for the multiples of 3 or 5 is: " + output + ". Impressive, isn't it?");
            }
            else
            {
                Console.WriteLine("I can't do anything with that.");
            }

        }

        //ask user if they want product or sum of numbers then proceed accordingly
        static void PlusOrTimes()
        {
            Console.WriteLine("Do you want sum or product today?");
            if (Console.ReadLine().Equals("sum"))
            {
                SumToN();
            }
            else
            {
                ProdToN();
            }
        }

        //write to console product of numbers for 1 to user inputed n
        static void ProdToN()
        {
            Console.WriteLine("Enter a positive number and I'll give you the product of all numbers to that number:");
            String input = Console.ReadLine();
            if (Int32.TryParse(input, out int n) && n >= 1)
            {
                int output = 1;
                for (int i = 2; i <= n; i++)
                {
                    output = output * i;
                }
                Console.WriteLine("The product from 1 to " + input + " is: " + output + ". Impressive, isn't it?");
            }
            else
            {
                Console.WriteLine("I can't do anything with that.");
            }

        }

        //print multiplication tables upto 12
        static void MultiplicationTable()
        {
            for (int i = 1; i < 13; i++)
            {
                if (i == 1)
                {
                    for (int k = 1; k <= 13; k++)
                    {
                        Console.Write("{0,4}", k - 1 + "|");

                    }
                    Console.WriteLine();

                    Console.Write("{0,4}", i + "|");
                }
                else
                {
                    Console.Write("{0,4}", i + "|");
                }
                for (int j = 1; j < 13; j++)
                {
                    Console.Write("{0,4}", j * i + "|");
                }
                Console.WriteLine();
            }
        }

        //print prime numbers
        static void PrimeNumbers()
        {
            int i = 1;
            while (i < 100)
            {
                //check if prime
                if (IsPrime(i))
                {
                    Console.WriteLine(i);
                }
                i++;
            }
        }

        //check if prime for PrimeNumbers to use
        static private bool IsPrime(int i)
        {
            if (i <= 1) { return false; }
            else if (i <= 3) { return true; }
            else if (i % 2 == 0 || i % 3 == 0) { return false; }
            int j = 5;
            while (j * j <= i)
            {
                if (i % j == 0 || i % (i + 2) == 0) { return false; }
                j = j + 6;
            }
            return true;
        }

        //Guessing game
        static void Guesser()
        {
            Random random = new Random();
            int target = random.Next(1, 100);
            List<int> guessedNumbers = new List<int>();
            bool match = false;

            Console.WriteLine("Let's play a game... \nA guessing game!\nI'm thinking of a number between 1 and 100, what is it?");
            while (match != true)
            {
                String input = Console.ReadLine();
                if (Int32.TryParse(input, out int guess))
                {
                    if (guess == target)
                    {
                        match = true;
                        Console.WriteLine("Well played, that was the number I was thinking of!");
                        guessedNumbers.Add(guess);
                        Console.WriteLine("And it only took you " + guessedNumbers.Count + " guesses.");
                    }
                    else
                    {
                        if (guess > target) { Console.WriteLine("Too high, try again."); }
                        else if (guess < target) { Console.WriteLine("Too low, try again."); }

                        if (!guessedNumbers.Contains(guess))
                        {
                            guessedNumbers.Add(guess);
                        }
                    }

                }
                else
                {
                    Console.WriteLine("I said a number silly, try again.");
                }

            }



        }
    }
}