import iut.algo.Clavier ;

import iut.algo.Console ;
import iut.algo.CouleurConsole ;

public class Affichage
{
    private static final String espaceAffichageSerpent = "                                                     " ;
    private static final String espaceAffichageInfo    = "                                                                                  " ;
    private static final String espaceAffichageJoueur  = "                                                                                      " ;
    
    public static void affichageSerpent(int[] serpent)
    { 
        /* Variables     */
		/* - - - - - - - */

        int ligne ;

        /* Instructions  */
		/* - - - - - - - */
        
        final int[][] DISPOSITION_SERPENT = { 
            {  0,  1, 2, -1, 8,  9, 10, -1, 16, 17, 18 }, 
            { -1, -1, 3, -1, 7, -1, 11, -1, 15, -1, 19 },
            { -1, -1, 4,  5, 6, -1, 12, 13, 14, -1, -1 }
        } ; 
             
        Console.normal() ;
        Console.couleurFont(CouleurConsole.VERT) ;

        for ( int cptLig = 0 ; cptLig < DISPOSITION_SERPENT.length ; cptLig++ )
        {
            for ( int cptCol = 0 ; cptCol < DISPOSITION_SERPENT[cptLig].length ; cptCol++ )
            {
                if ( cptCol == 0 )
                {
                    Console.print( espaceAffichageSerpent ) ;
                }
                
                if ( DISPOSITION_SERPENT[cptLig][cptCol] == -1 )
                {
                    if ( cptLig > 0 )
                    {
                        if ( DISPOSITION_SERPENT[cptLig - 1][cptCol] != -1 )
                        {
                            Console.couleurFont(CouleurConsole.VERT) ;
                            Console.print ( "+======+" ) ;
                        }
                        else
                        {
                            Console.couleurFont(CouleurConsole.VERT) ;
                            Console.print ( "        " ) ;
                        }
                    }
                    else
                    {
                        Console.couleurFont(CouleurConsole.VERT) ;
                        Console.print ( "        " ) ;
                    }
                }
                else
                {
                    Console.couleurFont(CouleurConsole.VERT) ;
                    Console.print ( "+==" ) ;
                    
                    Console.couleurFont(CouleurConsole.BLANC) ;
                    Console.print ( String.format( "%2d", DISPOSITION_SERPENT[cptLig][cptCol] + 1 ) ) ; 
                    
                    Console.couleurFont(CouleurConsole.VERT) ;
                    Console.print ( "==+" ) ;
                }
            }

            Console.println () ;

            for ( int cptCol = 0 ; cptCol < DISPOSITION_SERPENT[cptLig].length ; cptCol++ )
            {
                if ( cptCol == 0 )
                {
                    Console.print( espaceAffichageSerpent ) ;
                }
                
                if ( DISPOSITION_SERPENT[cptLig][cptCol] == -1 )
                {
                    Console.print ( "        " ) ;
                }
                else
                {
                    Console.couleurFont(CouleurConsole.VERT) ;
                    Console.print ( "|      |" ) ;
                }
            }

            Console.println () ;

            for ( int cptCol = 0 ; cptCol < DISPOSITION_SERPENT[cptLig].length ; cptCol++ )
            {
                if ( cptCol == 0 )
                {
                    Console.print( espaceAffichageSerpent ) ;
                }
                
                if ( DISPOSITION_SERPENT[cptLig][cptCol] == -1 ) 
                {
                    Console.print ( "        " ) ;
                }
                else
                {
                    if ( serpent[DISPOSITION_SERPENT[cptLig][cptCol]] != 0 )
                    {
                        Console.couleurFont(CouleurConsole.VERT) ;
                        Console.print ( "|  " ) ;
                        
                        if ( serpent[DISPOSITION_SERPENT[cptLig][cptCol]] == -1 )
                        {
                            Console.couleurFont(CouleurConsole.BLANC) ;
                            Console.print ( " J" ) ; 
                        }
                        else
                        {
                            Console.couleurFont(CouleurConsole.BLANC) ;
                            Console.print ( String.format( "%2d" , serpent[DISPOSITION_SERPENT[cptLig][cptCol]] ) ) ; 
                        }
                        
                        Console.couleurFont(CouleurConsole.VERT) ;
                        Console.print ( "  |" ) ;
                    }
                    else
                    {
                        Console.couleurFont(CouleurConsole.VERT) ;
                        Console.print ( "|      |" ) ;
                    }
                }
            }

            Console.println () ;

            for ( int cptCol = 0 ; cptCol < DISPOSITION_SERPENT[cptLig].length ; cptCol++ )
            {
                if ( cptCol == 0 )
                {
                    Console.print( espaceAffichageSerpent ) ;
                }
                
                if ( DISPOSITION_SERPENT[cptLig][cptCol] == -1 )
                {
                    Console.print ( "        " ) ;
                }
                else
                {
                    Console.couleurFont(CouleurConsole.VERT) ;
                    Console.print ( "|      |" ) ;
                }
            }

            Console.println () ;

        }

        for ( int cptCol = 0 ; cptCol < DISPOSITION_SERPENT[2].length ; cptCol++ )
        {
            if ( cptCol == 0 )
                {
                    Console.print("                                                     ") ;
                }
            
            if ( DISPOSITION_SERPENT[2][cptCol] == -1 )
            {
                Console.print ( "        " ) ;
            }
            else
            {
                Console.couleurFont(CouleurConsole.VERT) ;
                Console.print ( "+======+" ) ;
            }
        }

        Console.println () ;
    }

    public static int suiteSerpent( int[] serpent, int[] score, int joueur )
    {
        /* Variables     */
		/* - - - - - - - */

        int suiteNombre ;
        int sommeSuite ;
        int termePrec ;
        int cptSuite ;

        int totalScore ;

        String suite ;

        retourLigne ( 3 ) ;

        Console.couleurFont(CouleurConsole.VERT) ;
        Console.print ( "Score du Joueur " + joueur +"\n-----------------\n\n" ) ;

        suite =  "" ; 

        suiteNombre = 1 ;
        sommeSuite = cptSuite = totalScore = 0 ;
        
        termePrec = serpent[0] ;
        suite = Integer.toString ( serpent[0] ) + " " ;
        for ( int cpt = 1 ; cpt < serpent.length ; cpt++ )
        {
            if ( termePrec <= serpent[cpt] )
            {
                suiteNombre++ ;
                suite = suite + Integer.toString ( serpent[cpt] ) + " " ; 
            }
            else
            {
                Console.print ( String.format ( "%-60s", suite ) + " : " + score[suiteNombre - 1] + "\n" ) ;
                totalScore = totalScore + score[suiteNombre - 1] ;

                suiteNombre = 1 ;
                suite = Integer.toString ( serpent[cpt] ) + " " ;
            }
            termePrec = serpent[cpt] ;
        }

        Console.print ( String.format ( "%-60s", suite ) + " : " + score[suiteNombre - 1] + "\n" ) ;
        totalScore = totalScore + score[suiteNombre - 1] ;

        Console.print ( String.format ( "%-60s", "Total" ) + " : " + totalScore + "\n" ) ;

        return totalScore ;
    }

    public static void retourLigne(int nbRetourLigne)
    {
        for ( int cpt = 0 ; cpt < nbRetourLigne ; cpt++ )
        {
            Console.print( "\n" ) ;
        }
    }

    public static int saisieCase(int caseMax)
    {
        /* Variables     */
		/* - - - - - - - */
        
        int posSerpent ;
        
        do {

            Console.normal() ;
            Console.couleurFont(CouleurConsole.VERT) ;

            Console.print ( espaceAffichageInfo + "[============================]\n" ) ;
            Console.print ( espaceAffichageInfo + "     Saisir la case : " ) ;

            posSerpent = Clavier.lire_int() ;

        } while ( posSerpent < 1 || posSerpent > caseMax ) ;

        return posSerpent ;
    }

    public static void tourJoueur(int joueur, int[] serpent, int tour, int[] score, int tirage)
    {
        /* Variables     */
		/* - - - - - - - */
        
        int posSerpent, valSerpent ;

        String difficulte ;

        if ( score[5] == 3 )
        {
            difficulte = "Avancé" ;
        }
        else
        {
            difficulte = "Normal" ;
        }
        
        retourLigne ( 40 ) ;

        Console.couleurFont(CouleurConsole.VERT) ;
        Console.print ( espaceAffichageInfo + "[============================]\n" ) ;
        
        Console.couleurFont(CouleurConsole.BLANC) ;
        Console.print ( espaceAffichageInfo + "|           Tour " + String.format( "%2d", tour ) + "          |\n" ) ;
            
        Console.couleurFont(CouleurConsole.VERT) ;
        Console.print ( espaceAffichageInfo + "[============================]\n" ) ;
        Console.print ( espaceAffichageInfo + "         Mode : " + difficulte ) ;
            
        retourLigne ( 2 ) ;

        Console.couleurFont(CouleurConsole.BLANC) ;
        Console.print ( espaceAffichageJoueur + "[====================]\n" ) ;
        Console.print ( espaceAffichageJoueur + "|      Joueur " + joueur + "      |\n" ) ;
        Console.print ( espaceAffichageJoueur + "[====================]" ) ;

        retourLigne ( 3 ) ;

        Console.couleurFont(CouleurConsole.VERT) ;
        Console.print ( espaceAffichageJoueur + "+=======" ) ;
        
        Console.couleurFont(CouleurConsole.BLANC) ;
        Console.print ( "Pioche" ) ; 
        
        Console.couleurFont(CouleurConsole.VERT) ;
        Console.print ( "=======+\n" ) ;
        Console.print ( espaceAffichageJoueur + "|                    |\n" ) ;
        Console.print ( espaceAffichageJoueur + "|         " ) ; 
        
        Console.couleurFont(CouleurConsole.BLANC) ;
        
        if ( tirage == -1 )
        {
            Console.print ( " J" ) ;
        }
        else
        {
            Console.print ( String.format("%2d", tirage) ) ;
        }
        
        Console.couleurFont(CouleurConsole.VERT) ;
        Console.print ( "         |\n" ) ;
        Console.print ( espaceAffichageJoueur + "|                    |\n" ) ;
        Console.print ( espaceAffichageJoueur + "+====================+" ) ;
            
        retourLigne ( 3 ) ;
        
        affichageSerpent ( serpent ) ;

        retourLigne ( 3 ) ;

        do {

            posSerpent = saisieCase (20) ;

        } while ( serpent[posSerpent - 1] != 0 ) ;

        valSerpent = tirage ;

        serpent[posSerpent - 1] = valSerpent ;
    }

    public static int[] remplaceJoker(int[] serpent, int joueur)
    {
        /* Variables     */
		/* - - - - - - - */

        int indiceJoker ;
        
        indiceJoker = -1 ;
        for ( int cpt = 0 ; cpt < serpent.length ; cpt++ )
        {
            if ( serpent[cpt] == -1 )
            {
                indiceJoker = cpt ;
                break ;
            }
        }

        Console.couleurFont(CouleurConsole.VERT) ;
        Console.print( espaceAffichageInfo + "[==========Joueur " + joueur + "==========]\n" ) ;
        Console.print( espaceAffichageInfo + "      Valeur du Joker : " ) ;

        if ( indiceJoker > -1 )
        {
            serpent[indiceJoker] = Clavier.lire_int() ;
        }

        return serpent ;
    }

    public static void ecranVictoire( String message )
    {
        retourLigne ( 5 ) ;

        Console.couleurFont(CouleurConsole.VERT) ;
        Console.print( espaceAffichageInfo + "[============================]\n" ) ;
        Console.print( espaceAffichageInfo + "|    " ) ;
        
        Console.couleurFont(CouleurConsole.BLANC) ;
        Console.print( String.format("%20s", message) ) ; 
        
        Console.couleurFont(CouleurConsole.VERT) ;
        Console.print( "    |\n" ) ; 
        Console.print( espaceAffichageInfo + "[============================]" ) ;
    }
}