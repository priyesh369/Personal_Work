using System;
using MathNet.Numerics;


namespace PascalsTriangle
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("How many row's of the Pascal triangle would you like?");
            int rows = Int32.Parse(Console.ReadLine());
            Console.WriteLine();
            printTriangle(rows);
            Console.ReadKey();
        }

        static private void printTriangle(int rows)
        {
            int blkSpace = rows;
            for (int i = 0; i < rows; i++)
            {
                for (int k = blkSpace; k >= 0; k--)
                {
                    Console.Write(" ");
                }
                blkSpace = blkSpace - 1;
                for (int j = 0; j <= i; j++)
                {
                    Console.Write(Combinatorics.Combinations(i, j)+" ");
                }
                Console.WriteLine();
            }
        }
    }
}
