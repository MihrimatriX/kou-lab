import java.awt.image.BufferedImage;

public class Karakter
{
    public int can;
    public int hiz;

    public int X;
    public int Y;


    public void setLocation(int x, int y)
    {
        x=this.X;
        y=this.Y;
    }


    public int getHiz()
    {
        return hiz;
    }

    public void setHiz(int hiz)
    {
        this.hiz = hiz;
    }

    public int getCan()
    {
        return can;
    }

    public void setCan(int can)
    {
        this.can = can;
    }

    public int getX()
    {
        return X;
    }

    public void setX(int x)
    {
        X = x;
    }

    public int getY()
    {
        return Y;
    }

    public void setY(int y)
    {
        Y = y;
    }

    public Karakter()
    {
        System.out.println("Karakter Uterildi..");
    }
}