public class Lokasyon
{
    private int X;
    private int Y;

    public Lokasyon (int x, int y)
    {
        this.X=x;
        this.Y=y;
    }

    public void LocationAyarla(int x, int y)
    {
        this.X=x;
        this.Y=y;
    }

    public int getX()
    {
        return X;
    }

    public void setX(int x)
    {
        this.X = x;
    }

    public int getY()
    {
        return Y;
    }

    public void setY(int y)
    {
        this.Y = y;
    }
}