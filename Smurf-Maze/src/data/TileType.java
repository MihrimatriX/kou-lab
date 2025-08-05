package data;

public enum TileType 
{
    Duvar("duvar", false), Yol("yol", true);
    
    String textureName;
    boolean buildable;
    
    TileType(String textureName, boolean buildable) 
    {
        this.textureName = textureName;
        this.buildable = buildable;
    }

}
