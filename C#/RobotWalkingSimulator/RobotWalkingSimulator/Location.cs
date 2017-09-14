namespace RobotWalkingSimulator
{
    public struct Location
    {
        public int x;
        public int y;
        public Heading heading;

        public Location(int x, int y)
        {
            this.x = x;
            this.y = y;
            heading = new Heading();
            heading.NORTH();
        }

        internal void MoveUp()
        {
            y++;
        }

        internal void MoveRight()
        {
            x++;
        }

        internal void MoveDown()
        {
            y--;
        }

        internal void MoveLeft()
        {
            x--;
        }
    }
}
