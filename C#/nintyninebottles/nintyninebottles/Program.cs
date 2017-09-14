using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace nintyninebottles
{
    class Program
    {
        static int num;
        static string bot = "bottles";

        static void Main(string[] args)
        {
            num = Int32.Parse(Console.ReadLine());
            run(num);
            Console.ReadKey();
        }

        private static void run(int f)
        {

            for (int i = f; i >= 0; i--)
            {
                if (i == 0)
                {
                    printNill(f);
                }
                else if (i == 1)
                {
                    bot = "bottle";
                    print();
                }
                else
                {
                    print();
                }
            }
        }

        private static void printNill(int f)
        {
            Console.WriteLine("no more bottles of beer on the wall,no more bottles of beer.");
            Console.WriteLine("go to the store and buy some more, " + f + " bottles of beer on the wall.");
            Console.WriteLine();
        }

        static private void print()
        {
            Console.WriteLine(num + " " + bot + " of beer on the wall, " + num + " " + bot + " of beer.");
            num = (int)num - 1;
            Console.WriteLine("Take one down and pass it around, " + num + " " + bot + " of beer on the wall.");
            Console.WriteLine();
        }
    }
}
