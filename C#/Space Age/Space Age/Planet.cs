using System;
using System.Collections.Generic;

namespace SpaceAge
{
    //A planet sudo struct to hold orbit time of planets
    public class Planet
    {
        public Dictionary<String, double> Orbit;

        public Planet()
        {
            Orbit = new Dictionary<string, double>();
            Orbit.Add("mercury", 7595341.5312);
            Orbit.Add("venus", 19400860.79136);
            Orbit.Add("earth", 31557600);
            Orbit.Add("mars", 59313407.0688);
            Orbit.Add("jupiter", 374099426.64);
            Orbit.Add("saturn", 928656296.928);
            Orbit.Add("uranus", 2649555255.46);
            Orbit.Add("neptune", 5196859067.52);
        }

        public double getOrbit(string key)
        {
            return Orbit[key];
        }

        public bool Contains(string key)
        {
            return Orbit.ContainsKey(key);
        }
    }
}
