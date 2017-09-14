using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StringsAndLists
{
    class Program
    {
        static List<int> testFiveInt = new List<int>() { 12, 13, 45, 21, 1 };
        static List<String> testFiveString = new List<String>() { "Des", "Pa", "Ci", "To", "!" };
        static List<int> testEmptyInt = new List<int>() { };

        static void Main(string[] args)
        {
            //TestCount();
            //TestOddPos();
            //TestContains();
            //TestLargest();//
            Console.WriteLine("press the anykey to exit.");
            Console.ReadKey();
        }
        

        static T LargestInList<T>(List<T> input)
        {
            if (CountList(input) <= 0)
            {
                Console.WriteLine("Input List is empty");
                return default(T);
            }
            else
            {
                return input.Max();
            }
        }

        static void ReverseList<T>(List<T> input)
        {
            input.Reverse();
        }

        static bool ListContains<T>(List<T> input, T check)
        {
            bool output = false;
            input.ForEach(X =>
            {
                if (X.Equals(check))
                {
                    output = true;
                }
            });
            return output;
        }

        static void ListElementsAtOddPos<T>(List<T> input)
        {
            if (CountList(input) <= 0)
            {
                Console.WriteLine("No elements in list");
            }
            else
            {
                for (int i = 1; i < CountList(input); i += 2)
                {
                    Console.WriteLine("Element at pos " + i + ": " + input[i]);
                }
            }
        }

        static int CountList<T>(List<T> input)
        {
            int count = 0;
            input.ForEach(x =>
            {
                count++;
            });
            return count;
        }

        static void TestCount()
        {
            Console.WriteLine("testFiveInt contains: " + CountList(testFiveInt));
            Console.WriteLine("testFiveString contains: " + CountList(testFiveString));
            Console.WriteLine("testEmptyInt contains: " + CountList(testEmptyInt));
        }

        static void TestOddPos()
        {
            Console.WriteLine("testFiveInt results: ");
            ListElementsAtOddPos(testFiveInt);
            Console.WriteLine("testFiveInt results: ");
            ListElementsAtOddPos(testFiveString);
            Console.WriteLine("testFiveInt results: ");
            ListElementsAtOddPos(testEmptyInt);
        }

        static void TestContains()
        {
            Console.WriteLine("testFiveInt contains 12 is: " + ListContains(testFiveInt, 12));
            Console.WriteLine("testFiveString contains Des is: " + ListContains(testFiveString, "Des"));
            Console.WriteLine("testEmptyInt contains: 12 is: " + ListContains(testEmptyInt, 12));
            Console.WriteLine("testFiveInt contains 15 is: " + ListContains(testFiveInt, 15));
        }

        static void TestReverse()
        {
            Console.WriteLine("testFiveInt contains: " + CountList(testFiveInt));
            Console.WriteLine("testFiveString contains: " + CountList(testFiveString));
            Console.WriteLine("testEmptyInt contains: " + CountList(testEmptyInt));
        }

        static void TestLargest()
        {
            Console.WriteLine("testFiveInt largest is: " + LargestInList(testFiveInt));
            Console.WriteLine("testFiveString largest is: " + LargestInList(testFiveString));
            Console.WriteLine("testEmptyInt largest is: " + LargestInList(testEmptyInt));
        }
    }
}