import java.lang.RuntimeException;
import java.util.ArrayList;

public class Piece extends Corps
{
	private ArrayList <Corps> corps;
	
	private int poidsCorps;
	
	public Piece()
	{
		super();
		
		this.corps = new ArrayList <Corps> ();
	}
	
	public Piece(String nom, int poids)
	{
		super(nom, poids);
		
		this.corps = new ArrayList <Corps> ();
	}
	
	public Piece(Piece piece)
	{
		super((Corps) piece);
		
		this.corps = new ArrayList <Corps> ();
	}
	
	public int getNombreCorps()
	{
		return corps.size();
	}
	
	public Corps getCorps(int position)
	{
		if (position >= 0 && position < corps.size())
		{
			return new corps.get(position);
		}
		else
		{
			throw new IllegalArgumentException("Il n'y a pas de corps à cette position.");
		}
	}
	
	boolean ajouterCorps(Corps corps)
	{
		if (this.poidsCorps + corps.getPoids() < this.poids && corps.add(new Corps(corps)))
		{
			poids += corps.getPoids();
			
			return true;
		}
		else
		{
			return false;
		}
	}
	
	Corps retirerCorps(int position)
	{
		if (position >= 0 && position < corps.size())
		{
			Corps corps = corps.remove(position);
			
			this.poidsCorps -= corps.getPoids();
			
			return corps;
		}
		else
		{
			return throw new IllegalArgumentException("Il n'y a pas de corps à cette position.");
		}
	}
    
    public equals(Object object)
    {
        if(object instanceof Piece)
        {
            Piece piece = (Piece)object;
            return super.equals(piece) && this.poidsCorps == piece.poidsCorps && this.corps.equals(piece.corps);
        }
        else
            return false;
    }
}
