public class Sac
{
    private int[]   jetons  ;
    private int     nbJeton ;
    private boolean jokerEstPioche ;

    public Sac()
    {
        int temp ;
        int indiceAleatoire1, indiceAleatoire2 ;
        
        this.jetons = new int[] {
            1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30,

            11, 12, 13, 14, 15, 16, 17, 18, 19,

            -1
        } ;

        this.nbJeton = this.jetons.length ;
        
        for ( int cpt = 0 ; cpt < 1000 ; cpt++ )
        {
            indiceAleatoire1 = (int) ( Math.random() * this.nbJeton ) ;
            indiceAleatoire2 = (int) ( Math.random() * this.nbJeton ) ;

            temp = this.jetons[indiceAleatoire1] ;
            this.jetons[indiceAleatoire1] = this.jetons[indiceAleatoire2] ;
            this.jetons[indiceAleatoire2] = temp ; 
        }

        this.jokerEstPioche = false ;
    }

    public int piocher()
    {
        int indiceAleatoire ;
        int ecaille ;
        
        if ( this.nbJeton < 1 ) { return 0 ; }
        
        indiceAleatoire = (int) ( Math.random() * this.nbJeton ) ;

        ecaille = this.jetons[indiceAleatoire] ;

        this.jetons[indiceAleatoire] = this.jetons[nbJeton - 1] ;

        this.nbJeton-- ;

        if ( ecaille == -1 )
        {
            this.jokerEstPioche = true ;
        }

        return ecaille ;
    }

    public boolean getJokerEstPioche()
    {
        return this.jokerEstPioche ;
    }
}