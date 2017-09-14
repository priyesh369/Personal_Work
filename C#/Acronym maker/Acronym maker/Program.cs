using System;

namespace Acronym_maker
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("enter a phrase to ancronymify: ");
            string input = Console.ReadLine();
            string[] split = input.Split(' ');

            foreach(String word in split)
            {
                Console.Write(word[0]);
            }
            Console.WriteLine();
            Console.ReadKey();
        }
    }
}
