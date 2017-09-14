
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace UnitTestProject1
{
    [TestClass]
    public class UnitTest1
    {
        SpaceAge.SpaceAgeInner p = new SpaceAge.SpaceAgeInner(31556926);

        [TestMethod]
        public void TestMethod1()
        {
            Assert.AreEqual(1, p.GetAgeOnPlanet("earth"));
        }
    }
}
