using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MultiplesOf3and5
{
    class Program
    {
        static List<int> multiples = new List<int>();

        static void Main(string[] args)
        {
            multiplesOf3And5();
        }

        static void multiplesOf3And5()
        {
            for (int i = 0; i <= 1000; i++)
            {
                if (i % 3 == 0 || i % 5 == 0)
                {
                    multiples.Add(i);
                }
            }
            Console.WriteLine(multiples.Sum());
            Console.ReadKey();

        }
    }
}
