package system;

/**
 * @author Tony Cotta
 */
public class DoublePlaySolver 
{
    private double favOdds, drawOdds;
    protected double favorite, favorite2, draw2, draw3;
    
    //--------------------------------------------------------------------------
    // Constructor sets up a solver
    //--------------------------------------------------------------------------
    public void DoublePlaySolver()
    {
        favOdds = 0;
        drawOdds = 0;
        favorite = 0;
        draw3 = 0;
        favorite2 = 0;
        draw2 = 0;
    }
    
    //--------------------------------------------------------------------------
    // Double Play Favorite Solver
    //--------------------------------------------------------------------------
    /*
     * @param favOdds odds on the favorite to win
     * @param drawOdds odds on the result being a draw
     * @return wager size on the favorite.
     */
    public double DPFavSolver(double favOdds, double drawOdds)
    {
    	double fav, draw;
    	if(favOdds > 0 && favOdds < 100)
    		fav = convertOdds(favOdds);
    	else
    		fav = favOdds;
    	
    	if(drawOdds > 0 && drawOdds < 100)
    		draw = convertOdds(drawOdds);
    	else
    		draw = drawOdds;
    	
        //=IF(favOdds<0,-((drawOdds+100)*ABS(favOdds))/(10*ABS(favOdds)-10*drawOdds),(1000*drawOdds+100000)/(drawOdds*favOdds-10000))
        if (fav < 0)
        {
            favorite = -((draw+100)*Math.abs(fav))/(10*Math.abs(fav)-10*draw);
        }
        else
        {
            favorite = (1000*draw+100000)/(draw*fav-10000);
        }
        return favorite;
    }
    
    //--------------------------------------------------------------------------
    // Double Play Draw Solver
    //--------------------------------------------------------------------------
    /*
     * @param favOdds odds on the favorite to win
     * @param drawOdds odds on the result being a draw
     * @return wager size on the draw.
     */
    public double DPDrawSolver(double favOdds, double drawOdds)
    {
    	double fav, draw;
    	if(favOdds > 0 && favOdds < 100)
    		fav = convertOdds(favOdds);
    	else
    		fav = favOdds;
    	
    	if(drawOdds > 0 && drawOdds < 100)
    		draw = convertOdds(drawOdds);
    	else
    		draw = drawOdds;
    	
        //=IF(favOdds<-99,-((10*ABS(favOdds)+1000)/(ABS(favOdds)-drawOdds)),(((1000*drawOdds+100000)/(drawOdds*favOdds-10000))*favOdds-1000)/100)
        if (fav < 0)
        {
            draw3 = -((10*Math.abs(fav)+1000)/(Math.abs(fav)-draw));
        }
        else
        {
            draw3 = (((1000*draw+100000)/(draw*fav-10000))*fav-1000)/100;
        }
        return draw3;
    }
    
    //--------------------------------------------------------------------------
    // Draw Saver Favorite Solver
    //--------------------------------------------------------------------------
    /*
     * @param favOdds odds on the favorite to win
     * @param drawOdds odds on the result being a draw
     * @return wager size on the favorite.
     */
    public double DSFavSolver(double favOdds, double drawOdds)
    {
    	double fav, draw;
    	if(favOdds > 0 && favOdds < 100)
    		fav = convertOdds(favOdds);
    	else
    		fav = favOdds;
    	
    	if(drawOdds > 0 && drawOdds < 100)
    		draw = convertOdds(drawOdds);
    	else
    		draw = drawOdds;
    	
        //=IF(favOdds<0,(((-(10*ABS(favOdds))/(ABS(favOdds)-drawOdds))*drawOdds)/100),(((100000/(drawOdds*favOdds-10000))*drawOdds)/100))
        if (fav < 0)
        {
            draw2 = (((-(10*Math.abs(fav))/(Math.abs(fav)-draw))*draw)/100);
        }
        else
        {
            draw2 = (((100000/(draw*fav-10000))*draw)/100);
        }
        return draw2;

    }
    
    //--------------------------------------------------------------------------
    // Draw Saver Draw Solver
    //--------------------------------------------------------------------------
    /*
     * @param favOdds odds on the favorite to win
     * @param drawOdds odds on the result being a draw
     * @return wager size on the draw.
     */
    public double DSDrawSolver(double favOdds, double drawOdds)
    {
    	double fav, draw;
    	if(favOdds > 0 && favOdds < 100)
    		fav = convertOdds(favOdds);
    	else
    		fav = favOdds;
    	
    	if(drawOdds > 0 && drawOdds < 100)
    		draw = convertOdds(drawOdds);
    	else
    		draw = drawOdds;
    	
        //=IF(favOdds<0,(-(10*ABS(favOdds))/(ABS(favOdds)-drawOdds)),(100000/(drawOdds*favOdds-10000)))
        if (fav < 0)
        {
            favorite2 = (-(10*Math.abs(fav))/(Math.abs(fav)-draw));
        }
        else
        {
            favorite2 = (100000/(draw*fav-10000));
        }
        return favorite2;
    }
    
    /*
     * Converts odds from decimal format to American
     * @param odds odds to be converted
     * @return odds in American format
     */
    public double convertOdds(double odds){
    	double ret = 0.0;
    	if (odds < 2.0){
    		ret = -100/(odds-1);
    	}
    	else{
    		ret = 100*(odds-1);
    	}

    	return ret;
    }
}
