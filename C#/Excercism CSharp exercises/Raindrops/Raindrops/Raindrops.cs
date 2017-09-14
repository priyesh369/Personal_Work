using System;
using System.Collections.Generic;

namespace Raindrops
{
    public static class Raindrops
    {
        static void Main(string[] args)
        {
            while (true)
            {
                Console.WriteLine("Enter Value to convert: ");
                Int32.TryParse(Console.ReadLine(), out int x);
                Console.WriteLine(Convert(x));
            }
        }

        public static String Convert(int num)
        {
            List<int> factors = new List<int>();
            String result = null;

            for (int i = 3; i <= 7; i += 2)
            {
                if (num % i == 0)
                {
                    if (i == 3) { result += "Pling"; }
                    else if (i == 5) { result += "Plang"; }
                    else if (i == 7) { result += "Plong"; }
                }
            }
            if (result == null) { result += num; }

            return result;
        }
    }
}
