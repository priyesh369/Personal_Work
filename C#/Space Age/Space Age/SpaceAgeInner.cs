using System;

namespace SpaceAge
{
    public class SpaceAgeInner
    {
        private Planet planet = new Planet();
        private Int64 ageInSeconds;

        public SpaceAgeInner(Int64 ageInSeconds)
        {
            this.ageInSeconds = ageInSeconds;
        }

        public double GetAgeOnPlanet(string key)
        {
            key = key.ToLower();
            if (planet.Contains(key))
            {
                double ageInYears = (ageInSeconds / planet.getOrbit(key)) ;
                return Math.Round(ageInYears ,2);
            }
            else { return -0; };
        }
    }
}
