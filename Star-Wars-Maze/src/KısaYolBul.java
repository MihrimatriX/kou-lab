import java.util.List;

public class KısaYolBul
{
    public static boolean araYol(int[][] tunel, int x, int y, List<Integer> yol)
    {
        if (HaritaCizim.Labirent[y][x] == 3)
        {
            yol.add(x);
            yol.add(y);
            return true;
        }

        if (HaritaCizim.Labirent[y][x] == 1)//Eğer Yollardan Geçiliyorsa
        {
            HaritaCizim.Labirent[y][x] = 2;//Gezdiklerimizi 2 Yapıyoruz.

            int dx = -1;
            int dy = 0;

            if (araYol(HaritaCizim.Labirent, x + dx, y + dy, yol))
            {
                yol.add(x);
                yol.add(y);
                return true;
            }

            dx = 0;
            dy = -1;
            if (araYol(HaritaCizim.Labirent, x + dx, y + dy, yol))
            {
                yol.add(x);
                yol.add(y);
                return true;
            }

            dx = 1;
            dy = 0;
            if (araYol(HaritaCizim.Labirent, x + dx, y + dy, yol))
            {
                yol.add(x);
                yol.add(y);
                return true;
            }

            dx = 0;
            dy = 1;
            if (araYol(HaritaCizim.Labirent, x + dx, y + dy, yol))
            {
                yol.add(x);
                yol.add(y);
                return true;
            }
        }
        return false;
    }
}