public class SerpentNumerique
{
    public static void main(String[] args)
    {
        /*---------------*/
		/*  Données      */
		/*---------------*/

		/* Constantes    */
		/* - - - - - - - */

        final int TAILLE_SERPENT = 20 ;

		/* Variables     */
		/* - - - - - - - */

        int[] serpentJoueur1 ;
        int[] serpentJoueur2 ;

        int[] score ;
        Sac   sac ;

        int ecaille ;

        int scoreJoueur1 ;
        int scoreJoueur2 ;

        int joueur ;

		/*---------------*/
		/*  Instructions */
		/*---------------*/

        serpentJoueur1 = new int[TAILLE_SERPENT] ;
        serpentJoueur2 = new int[TAILLE_SERPENT] ;

        sac = new Sac() ;

        Affichage.retourLigne(40) ;

        score = Affichage.tableauScore () ;

        if ( args.length > 0 )
        {
            for ( int cpt = 0 ; cpt < serpentJoueur1.length ; cpt++ )
            {
                if ( args[0].substring(cpt * 2, cpt * 2 + 2).equals ( "??" ) )
                {
                    serpentJoueur1[cpt] = -1 ;
                    Affichage.retourLigne(100) ;
                    Affichage.remplaceJoker ( serpentJoueur1, 1 ) ;
                }
                else
                {
                    serpentJoueur1[cpt] = Integer.parseInt( args[0].substring(cpt * 2, cpt * 2 + 2) ) ;
                }
            }

            Affichage.retourLigne(100) ;
            Affichage.affichageSerpent ( serpentJoueur1 ) ;
            Affichage.suiteSerpent     ( serpentJoueur1, score, 1 ) ;

            return ;
        }

        for ( int tour = 1 ; tour <= 20 ; tour++ )
        {   
            ecaille = sac.piocher() ;
            
            joueur = 1 ;
            
            Affichage.tourJoueur( joueur, serpentJoueur1, tour, score, ecaille ) ;

            joueur = 2 ;

            Affichage.tourJoueur( joueur, serpentJoueur2, tour, score, ecaille ) ;
        }

        Affichage.retourLigne ( 40 ) ;
        
        Affichage.affichageSerpent( serpentJoueur1 ) ;

        Affichage.retourLigne ( 3 ) ;

        Affichage.affichageSerpent( serpentJoueur2 ) ;

        Affichage.retourLigne ( 3 ) ;

        if ( sac.getJokerEstPioche() )
        {
            serpentJoueur1 = Affichage.remplaceJoker( serpentJoueur1, 1 ) ;

            Affichage.retourLigne ( 3 ) ;

            serpentJoueur2 = Affichage.remplaceJoker( serpentJoueur2, 2 ) ;
        }

        scoreJoueur1 = Affichage.suiteSerpent( serpentJoueur1, score, 1 ) ;

        scoreJoueur2 = Affichage.suiteSerpent( serpentJoueur2, score, 2 ) ;

        if ( scoreJoueur1 > scoreJoueur2 )
        {
            Affichage.ecranVictoire( "Victoire du Joueur 1" ) ;
        }
        else
        {
            if ( scoreJoueur1 < scoreJoueur2 )
            {
                Affichage.ecranVictoire( "Victoire du Joueur 2" ) ;
            }
            else
            {
                Affichage.ecranVictoire( "Match nul...        " ) ;
            }
        }
    }
}                                                              